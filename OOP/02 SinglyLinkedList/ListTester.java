public class ListTester{
    public static void main(String[] args){
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.add(10);
        sll.add(1);
        sll.add(7);
        sll.add(9);
        sll.add(20);
        sll.add(-2);
        sll.printValue();
        System.out.println(sll.findNode(20));
        sll.removeAt(5);
        sll.printValue();
    }
}