public class Fish extends Animal {
    public Fish(boolean isFemale, int strength) {
        super(isFemale, strength);
    }

    @Override
    public String toString() {
        return "|" + (this.getSex() ? "F" : "M") + ((Integer) this.getStrength()).toString() + "F|";
    }

    @Override
    public String collide(Animal other) {
        if (other instanceof Bear) {
            return "eaten";
        }
        return super.collide(other);
    }
}
