// see computer.jpg

class Computer {
    private String operatingSystem;
    private int yearOfManufacture;
    public int serialNumber;

    // default constructor for an "empty" computer
    public Computer() {
        this.operatingSystem = "";
        this.yearOfManufacture = -1;
        this.serialNumber = -1;
    }

    // parameterized constructor
    public Computer(String operatingSystem, int yearOfManufacture, int serialNumber) {
        assert serialNumber != -1 : "Serial number cannot be -1"; // -1 is special, says that the computer is empty
        this.operatingSystem = operatingSystem;
        this.yearOfManufacture = yearOfManufacture;
        this.serialNumber = serialNumber;
    }

    public int getKey() {
        return serialNumber;
    }

    @Override
    public String toString() {
        return "A " + operatingSystem + " Computer created in " + yearOfManufacture + ". [" + serialNumber + "]";
    }
}