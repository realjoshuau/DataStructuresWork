public class Animal {
    private boolean sex; // true if female, false if male
    private int strength; // strngth of the animal between 1-9 inclusive
    private boolean actedInCycle = false;

    public Animal(boolean isFemale, int strength) {
        this.sex = isFemale;
        this.strength = strength;
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean isFemale) {
        this.sex = isFemale;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String collide(Animal other) {
        this.act();
        if (this.sex == other.getSex()) {
            if (this.strength > other.getStrength()) {
                return "beat";
            } else if (this.strength < other.getStrength()) {
                return "die";
            } else {
                return "tie";
            }
        } else {
            return "baby"; // oh
        }
    }

    public void act() {
        this.actedInCycle = true;
    }

    public boolean hasActed() {
        return this.actedInCycle;
    }
}