public class Main {
    public static void main(String[] args) {
        MyStack<Integer> myS = new MyStack<Integer>();
        myS.push(10);
        myS.push(11);
        System.out.println(myS.pop());
        myS.push(12);
        System.out.println(myS.size());
        myS.pop();
        myS.pop();
        System.out.println(myS.isEmpty());
    }
}