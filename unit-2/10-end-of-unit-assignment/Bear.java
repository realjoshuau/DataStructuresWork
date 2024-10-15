public class Bear extends Animal {
    public Bear(boolean isFemale, int strength) {
        super(isFemale, strength);
    }

    @Override
    public String toString() {
        return "|" + (this.getSex() ? "F" : "M") + ((Integer) this.getStrength()).toString() + "B|";
    }

    @Override
    public String collide(Animal other) {
        if (other instanceof Fish) {
            return "eat";
        }
        return super.collide(other);
    }
}
