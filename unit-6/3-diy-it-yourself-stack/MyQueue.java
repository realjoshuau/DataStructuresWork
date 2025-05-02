

public class Main {
    public static void main(String[] args) {
        MyDeque deque = new MyDeque();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("(1) Push a value (2) Pop a value (3) View a value (4) Show size (5) Print Deque (6) Quit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("(1) Push to the front (2) Push to the back");
                    int pushChoice = scanner.nextInt();
                    System.out.print("Enter the word to push: ");
                    String value = scanner.next();
                    if (pushChoice == 1) {
                        deque.pushFront(value);
                    } else if (pushChoice == 2) {
                        deque.pushBack(value);
                    }
                    break;

                case 2:
                    System.out.println("(1) Pop from the front (2) Pop from the back");
                    int popChoice = scanner.nextInt();
                    String removedValue;
                    if (popChoice == 1) {
                        removedValue = deque.popFront();
                    } else {
                        removedValue = deque.popBack();
                    }
                    if (removedValue == null) {
                        System.out.println("No elements could be popped!");
                    } else {
                        System.out.println("Removed " + removedValue);
                    }
                    break;

                case 3:
                    System.out.println("(1) View the front (2) View the back");
                    int viewChoice = scanner.nextInt();
                    String peekValue;
                    if (viewChoice == 1) {
                        peekValue = deque.peekFront();
                        if (peekValue == null) {
                            System.out.println("No elements to peek at!");
                        } else {
                            System.out.println(peekValue + " is at the front");
                        }
                    } else {
                        peekValue = deque.peekBack();
                        if (peekValue == null) {
                            System.out.println("No elements to peek at!");
                        } else {
                            System.out.println(peekValue + " is at the back");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Current size is " + deque.size());
                    break;

                case 5:
                    System.out.println(deque.toString());
                    break;

                case 6:
                    System.out.println("Thanks for dequeing~!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
