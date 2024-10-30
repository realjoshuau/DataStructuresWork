import java.util.Comparator;

public class RunnerDistanceComparator implements Comparator<Runner> {
    public int compare(Runner r1, Runner r2) {
        if (r1.getDistance() == r2.getDistance()) {
            return r1.getName().compareTo(r2.getName());
        }
        return r2.getDistance() - r1.getDistance();
    }
}