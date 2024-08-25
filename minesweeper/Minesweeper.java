import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
    protected static boolean haha = false;
    protected static boolean DEBUG = false;
    protected static boolean VERBOSE = false;
    protected static boolean gameLoopRunning = false;
    protected static boolean hitFirstSpace = false;
    protected static int width = 10;
    protected static int height = 10;
    protected static int numMines = 10;

    // Create a config array so (easy -> 10x10, 10 mines), (medium -> 16x16, 40
    // mines), (hard -> 16x30, 99 mines).
    protected static Map<String, int[]> config = Map.of("easy", new int[] { 10, 10, 10 }, "medium",
            new int[] { 16, 16, 40 },
            "hard", new int[] { 16, 30, 99 });

    protected static Space[][] spaces;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random prng = new Random(); // debugging: setting the seed to a constant value

        System.out.println("Welcome to Minesweeper!");
        System.out.println("Enter a difficulty level (easy, medium, hard): (and press Enter)");
        String difficulty = scanner.nextLine();
        System.out.println("You chose " + difficulty + " difficulty.");

        int[] difficultyConfig = config.get(difficulty);
        if (difficultyConfig == null) {
            System.out.println("Invalid difficulty level. Exiting...");
            System.exit(1);
        }

        width = difficultyConfig[0];
        height = difficultyConfig[1];
        numMines = difficultyConfig[2];

        // Create the spaces board.
        spaces = new Space[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                spaces[i][j] = new Space();
            }
        }

        String hadInvalidAction = "";

        // Game loop.
        gameLoopRunning = true;
        while (gameLoopRunning) {
            int x = -1;
            int y = -1;
            System.out.println(Color.CLEAR);
            if (checkWin()) {
                System.out.println("You win! Congratulations!");
                gameLoopRunning = false;
                continue;
            }
            if (hadInvalidAction != "") {
                System.out.println("Did not recognize input: " + hadInvalidAction);
                hadInvalidAction = "";
            }
            System.out.println(printBoard(false));
            if (DEBUG) {
                System.out.println("DEBUG: Mines: " + numMines);
                System.out.println("FIRST SPACE HIT: " + hitFirstSpace);
                System.out.println("DEBUG: ");
                findMines();
            }
            System.out.println("Enter a space to reveal or flag/unflag (x y \"r\"/\"f\"): ");
            String[] input = scanner.nextLine().split(" ");
            if (input[0] == "") {
                continue;
            }
            if (input.length != 3) {
                hadInvalidAction = "Invalid input. Please enter x y \"r\"/\"f\".";
                continue;
            }
            if (DEBUG) {
                System.out.println("DEBUG // ONE: " + input[0] + " TWO: " + input[1]);
            }
            if (input[0].equals("q") || input[1].equals("q") || input[2].equals("q")) {
                gameLoopRunning = false;
                continue;
            }
            // Parse the input.
            try {
                x = Integer.parseInt(input[0]);
                y = Integer.parseInt(input[1]);
            } catch (NumberFormatException e) {
                hadInvalidAction = "Invalid input. Please enter x y \"r\"/\"f\".";
                continue;
            }
            String action = input[2];

            if (action.equals("s")) {
                try {
                    System.out.println(printBoard(true));
                    System.out.println("DBG: " + "Current space: " + x + " " + y + " '" + spaces[x][y].toString()
                            + "'' adj"
                            + spaces[x][y].getNumAdjacentMines() + " mine: " + spaces[x][y].hasMine() + " revealed: "
                            + spaces[x][y].isRevealed() + " flagged: " + spaces[x][y].isFlagged() + " shown: "
                            + spaces[x][y].toStringRevealed());
                    System.out.println("Mine Locations: ");
                    findMines();
                    System.out.println("Hit enter to continue...");
                    scanner.nextLine();
                    continue;
                } catch (Exception e) {
                    hadInvalidAction = "DEBUG (ERROR) ::: Something went wrong (error: " + e
                            + ") \n ::: Please enter x y \"r\"/\"f\".";
                    continue;
                }
            }

            if (!action.equals("r") && !action.equals("f")) {
                hadInvalidAction = "Invalid action. Please enter \"r\" to reveal a space or \"f\" to flag/unflag a space.";
                continue;
            }

            if (x < 0 || x >= width || y < 0 || y >= height) {
                hadInvalidAction = "Invalid x or y value.";
                continue;
            }

            if (action.equals("r")) {
                if (DEBUG) {
                    System.out.println("DEBUG // REVEALING: " + x + " " + y);
                }
                if (spaces[x][y].isRevealed()) {
                    System.out.println("Space already revealed.");
                    hadInvalidAction = "Space already revealed.";
                    continue;
                }
                if (spaces[x][y].isFlagged()) {
                    System.out.println("Space is flagged. Unflag it first.");
                    hadInvalidAction = "Space is flagged. Unflag it first.";
                    continue;
                }
                // Have we hit our first space? No? Then place mines.
                if (!hitFirstSpace) {
                    if (haha) {
                        for (int i = 0; i < width; i++) {
                            for (int j = 0; j < height; j++) {
                                spaces[i][j].setMine(true);
                            }
                        }
                    } else {
                        // Randomly create mines.
                        int minesPlaced = 0;
                        while (minesPlaced < numMines) {
                            int xMine = (int) (prng.nextDouble() * width);
                            int yMine = (int) (prng.nextDouble() * height);

                            if (!spaces[xMine][yMine].hasMine() && (xMine != x && yMine != y)) {
                                spaces[xMine][yMine].setMine(true);
                                minesPlaced++;
                            }
                        }
                    }

                    // Create the adjacent mine counts.
                    for (int i = 0; i < width; i++) {
                        for (int j = 0; j < height; j++) {
                            spaces[i][j].setNumAdjacentMines(countAdjacentMines(i, j));
                        }
                    }
                }
                if (spaces[x][y].hasMine()) {
                    System.out.println("You hit a mine! GAME OVER :(");
                    gameLoopRunning = false;
                }
                // spaces[x][y].reveal();
                revealAdjacent(x, y);
                if (!hitFirstSpace) {
                    hitFirstSpace = true;
                }
            } else if (action.equals("f")) {
                spaces[x][y].toggleFlag();
            } else {
                System.out.println(
                        "Invalid action. Please enter \"r\" to reveal a space or \"f\" to flag/unflag a space.");
                if (DEBUG) {
                    System.out.println("DEBUG (unreachable code -- reached) // ACTION: " + action);
                }
                continue;
            }

            if (DEBUG) {
                System.out.println("DBG: " + "Current space: " + x + " " + y + " '" + spaces[x][y].toString() + "'' adj"
                        + spaces[x][y].getNumAdjacentMines() + " mine: " + spaces[x][y].hasMine() + " revealed: "
                        + spaces[x][y].isRevealed() + " flagged: " + spaces[x][y].isFlagged() + " shown: "
                        + spaces[x][y].toStringRevealed());
            }
            // System.out.println("Hit enter to continue...");
            // scanner.nextLine();
        }

        System.out.println("Game over. Thanks for playing!");
        System.out.println(printBoard(true));
        scanner.close();
    }

    // Check win condition function.
    public static boolean checkWin() {
        // Check if all non-mine spaces are revealed.
        int numSpaces = width * height;
        int numRevealed = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (!spaces[i][j].hasMine() && spaces[i][j].isRevealed()) {
                    numRevealed++;
                }
            }
        }
        if (numSpaces - numRevealed == numMines) {
            return true;
        }
        return false;
    }

    public static void findMines() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (spaces[i][j].hasMine()) {
                    System.out.println("Mine at: " + i + " " + j);
                }
            }
        }
    }

    public static int[][] directions = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
            { 1, 1 } };

    public static void revealAdjacent(int x, int y) {
        if (spaces == null) {
            throw new IllegalStateException("Spaces array is null.");
        } else if (x < 0 || x >= width || y < 0 || y >= height) {
            throw new IllegalArgumentException("Invalid x or y value.");
        }

        if (spaces[x][y].isRevealed()) {
            if (DEBUG && VERBOSE) {
                System.out.println("Space " + x + " " + y + " is already revealed.");
            }
            return;
        }

        if (spaces[x][y].hasMine()) {
            if (DEBUG && VERBOSE) {
                System.out.println("Space " + x + " " + y + " has a mine.");
            }
            return;
        }

        spaces[x][y].reveal();

        if (spaces[x][y].getNumAdjacentMines() == 0) {
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (newX >= 0 && newX < width && newY >= 0 && newY < height) {
                    revealAdjacent(newX, newY);
                }
            }
        }
    }

    public static String printBoard(boolean revealAll) {
        StringBuilder sb = new StringBuilder();

        // Print column numbers
        sb.append("  ");
        for (int i = 0; i < width; i++) {
            sb.append(i).append(" ");
        }
        sb.append("\n");

        for (int i = 0; i < width; i++) {
            sb.append(i).append(" ");

            for (int j = 0; j < height; j++) {
                sb.append(revealAll ? spaces[i][j].toStringRevealed() : spaces[i][j].toString()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // Pre-game functions.

    public static int countAdjacentMines(int x, int y) {
        if (spaces == null) {
            throw new IllegalStateException("Spaces array is null.");
        } else if (x < 0 || x >= width || y < 0 || y >= height) {
            throw new IllegalArgumentException("Invalid x or y value.");
        }

        int count = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < width && j >= 0 && j < height) {
                    if (spaces[i][j] != null && spaces[i][j].hasMine()) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
