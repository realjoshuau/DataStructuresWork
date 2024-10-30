public class Runner {
    private String name;
    private int distance;

    public Runner(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void run__(int distance) {
        distance += distance;
    }

    public void run() {
        // Random 1-5
        distance += (int) (Math.random() * 5) + 1;
    }

    public String toString() {
        // Requires Java 11
        return "-".repeat(distance) + name;
    }
}