import java.util.Random;
import java.util.Scanner;

public class EcosystemSimulator {
    public static boolean DEBUG = true;
    public static Random rand = new Random(100);
    public static Animal[] ecosystem = new Animal[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        init();
        System.out.println("Initial ecosystem:");
        printEcosystem(ecosystem);
        System.out.println();
        for (int i = 0; i < 10; i++) {
            runCycle();
            System.out.println("Ecosystem after cycle " + i + ":");
            printEcosystem(ecosystem);
            System.out.println();
            System.out.println("Press enter to continue.");
            sc.nextLine();
        }
        sc.close();
    }

    public static void init() {
        // 10% of being Fish, 5% of Bear, 85% of null
        for (int i = 0; i < ecosystem.length; i++) {
            int random = rand.nextInt(100);
            if (random < 10) {
                ecosystem[i] = new Fish(rand.nextBoolean(), rand.nextInt(9) + 1);
            } else if (random < 15) {
                ecosystem[i] = new Bear(rand.nextBoolean(), rand.nextInt(9) + 1);
            } else {
                ecosystem[i] = null;
            }
        }
    }

    public static void printEcosystem(Animal[] ecosystem) {
        for (int i = 0; i < ecosystem.length; i++) {
            if (ecosystem[i] == null) {
                System.out.print("~");
            } else {
                System.out.print(ecosystem[i]);
            }
        }
    }

    public static void spawnAnimalRandom(Animal animal) {
        int randomIndex = rand.nextInt(ecosystem.length);
        while (ecosystem[randomIndex] != null) {
            randomIndex = rand.nextInt(ecosystem.length);
        }
        ecosystem[randomIndex] = animal;
        if (DEBUG) {
            System.out.println(animal + " spawned at index " + randomIndex + ".");
        }
    }

    public static void runCycle() {
        for (int i = 0; i < ecosystem.length; i++) {
            if (ecosystem[i] == null) {
                continue;
            }
            int choice = rand.nextInt(3); // Choices are 0, 1, 2
            if (choice == 0) {
                // Stay still.
                if (DEBUG) {
                    System.out.println(ecosystem[i] + " stays still.");
                }
                continue;
            }
            if (choice == 1) {
                // Move left
                if (i == 0) {
                    if (DEBUG) {
                        System.out.println(ecosystem[i] + " wanted to move left but is at the edge.");
                    }
                    continue;
                }
                if (ecosystem[i - 1] == null) {
                    if (DEBUG) {
                        System.out.println(ecosystem[i] + " moves left.");
                    }
                    ecosystem[i - 1] = ecosystem[i];
                    ecosystem[i] = null;
                    continue;
                }
                // We know there is an animal to the left - what is it?
                String result = ecosystem[i].collide(ecosystem[i - 1]);
                switch (result) {
                    case "bounce":
                        if (DEBUG) {
                            System.out.println(ecosystem[i] + " wanted to move left but there was a " + ecosystem[i - 1]
                                    + " there. They fought and bounced.");
                        }
                        break;
                    case "eat":
                        if (DEBUG) {
                            System.out.println(ecosystem[i] + " wanted to move left but there was a " + ecosystem[i - 1]
                                    + " there. They fought and the " + ecosystem[i] + " ate the " + ecosystem[i - 1]
                                    + ".");
                        }
                        ecosystem[i - 1] = ecosystem[i];
                        ecosystem[i] = null;
                        break;
                    case "eaten":
                        if (DEBUG) {
                            System.out.println(ecosystem[i] + " wanted to move left but there was a " + ecosystem[i - 1]
                                    + " there. They fought and the " + ecosystem[i - 1] + " ate the " + ecosystem[i]
                                    + ".");
                        }
                        ecosystem[i] = null;
                        break;
                    case "die":
                        if (DEBUG) {
                            System.out.println(ecosystem[i] + " wanted to move left but there was a " + ecosystem[i - 1]
                                    + " there. They fought and the " + ecosystem[i] + " died.");
                        }
                        ecosystem[i] = null;
                        break;
                    case "beat":
                        if (DEBUG) {
                            System.out.println(ecosystem[i] + " wanted to move left but there was a " + ecosystem[i - 1]
                                    + " there. They fought and the " + ecosystem[i] + " beat the " + ecosystem[i - 1]
                                    + ".");
                        }
                        ecosystem[i - 1] = ecosystem[i];
                        ecosystem[i] = null;
                        break;
                    case "baby":
                        if (DEBUG) {
                            System.out.println(ecosystem[i] + " wanted to move left but there was a " + ecosystem[i - 1]
                                    + " there. They had a baby.");
                        }
                        // What is the type of the animal? Spawn it in randomly
                        if (ecosystem[i] instanceof Fish) {
                            spawnAnimalRandom(new Fish(rand.nextBoolean(), rand.nextInt(9) + 1));
                        } else if (ecosystem[i] instanceof Bear) {
                            spawnAnimalRandom(new Bear(rand.nextBoolean(), rand.nextInt(9) + 1));
                        }
                        break;
                }
                continue;
            } else {
                // Move RIGHT
                if (i == ecosystem.length - 1) {
                    if (DEBUG) {
                        System.out.println(ecosystem[i] + " wanted to move right but is at the edge.");
                    }
                    continue;
                }
                if (ecosystem[i + 1] == null) {
                    if (DEBUG) {
                        System.out.println(ecosystem[i] + " moves right.");
                    }
                    ecosystem[i + 1] = ecosystem[i];
                    ecosystem[i] = null;
                    continue;
                }
                // We know there is an animal to the right - what is it?
                String result = ecosystem[i].collide(ecosystem[i + 1]);
                switch (result) {
                    case "bounce":
                        if (DEBUG) {
                            System.out
                                    .println(ecosystem[i] + " wanted to move right but there was a " + ecosystem[i + 1]
                                            + " there. They fought and bounced.");
                        }
                        break;
                    case "eat":
                        if (DEBUG) {
                            System.out.println(ecosystem[i] + " wanted to move right but there was a "
                                    + ecosystem[i + 1]
                                    + " there. They fought and the " + ecosystem[i] + " ate the " + ecosystem[i + 1]
                                    + ".");
                        }
                        ecosystem[i + 1] = ecosystem[i];
                        ecosystem[i] = null;
                        break;
                    case "eaten":
                        if (DEBUG) {
                            System.out.println(ecosystem[i] + " wanted to move right but there was a "
                                    + ecosystem[i + 1]
                                    + " there. They fought and the " + ecosystem[i + 1] + " ate the " + ecosystem[i]
                                    + ".");
                        }
                        ecosystem[i] = null;
                        break;
                    case "die":
                        if (DEBUG) {
                            System.out
                                    .println(ecosystem[i] + " wanted to move right but there was a " + ecosystem[i + 1]
                                            + " there. They fought and the " + ecosystem[i] + " died.");
                        }
                        ecosystem[i] = null;
                        break;
                    case "beat":
                        if (DEBUG) {
                            System.out.println(ecosystem[i] + " wanted to move right but there was a "
                                    + ecosystem[i + 1]
                                    + " there. They fought and the " + ecosystem[i] + " beat the " + ecosystem[i + 1]
                                    + ".");
                        }
                        ecosystem[i + 1] = ecosystem[i];
                        ecosystem[i] = null;
                        break;
                    case "baby":
                        if (DEBUG) {
                            System.out
                                    .println(ecosystem[i] + " wanted to move right but there was a " + ecosystem[i + 1]
                                            + " there. They had a baby.");
                        }
                        // What is the type of the animal? Spawn it in randomly
                        if (ecosystem[i] instanceof Fish) {
                            spawnAnimalRandom(new Fish(rand.nextBoolean(), rand.nextInt(9) + 1));
                        } else if (ecosystem[i] instanceof Bear) {
                            spawnAnimalRandom(new Bear(rand.nextBoolean(), rand.nextInt(9) + 1));
                        }
                        break;
                }
                continue;
            }
        }
    }
}