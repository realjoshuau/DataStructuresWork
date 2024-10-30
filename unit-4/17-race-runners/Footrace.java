public class Footrace {
    public static void main(String[] args) {
        Runner x = new Runner("Linus Sebastian");
        x.run();
        x.run();
        x.run();
        System.out.println(x);
        System.out.println(x.getDistance());
        // Create an array of Runner objects with different names
        Runner[] runners = {
                new Runner("Linus Sebastian"),
                new Runner("Akali"),
                new Runner("Ahri"),
                new Runner("David"),
                new Runner("Lucy"),
                new Runner("Adam Smasher"),
                new Runner("Jayce"),
                new Runner("Natty"),
                new Runner("Haneul"),
                new Runner("Belle"),
                new Runner("Julie"),
                new Runner("Karina"),
                new Runner("Vi"),
                new Runner("Jinx"),
                new Runner("Silco"),
                new Runner("Viktor"),
                new Runner("Caitlyn"),
                new Runner("Ekko"),
        };

        // Simulate the footrace
        int timeStep = 0;
        boolean raceFinished = true;

        while (!raceFinished) {
            timeStep++;

            // Each runner runs
            for (Runner runner : runners) {
                runner.run();
            }

            // Sort the runners by distance
            Sorter.sort(runners, new RunnerDistanceComparator());

            // Display runners' progress
            System.out.println("Time Step: " + timeStep);
            for (Runner runner : runners) {
                System.out.println(runner);
            }

            // Check if the race is finished
            for (Runner runner : runners) {
                if (runner.getDistance() >= 50) {
                    raceFinished = true;
                    System.out.println("\nCongratulations to " + runner.getName() + " for winning the race in "
                            + timeStep + " time steps!");
                    break;
                }
            }
        }
    }
}