public class SinglyLinkedList{
    public Node head;
    
    public SinglyLinkedList(){
        this.head = null;
    }
    public void add(int value){
        Node newNode = new Node(value);
        if (head == null){
            head = newNode;
        }else{
            Node runner = head;
            while(runner.next!=null){
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }
    public void removeLast(){
        if (head == null){
            return;
        }else {
            Node runner = head;
            while(runner.next.next !=null){
                runner = runner.next;
            }
            runner.next = null;
        }
    }
    public void printValue(){
        Node runner = this.head;
        // check sll is empty - no Node
        if (runner == null){
            System.out.println(runner);
        }else{
            while (runner !=null){
                System.out.println(runner.value);
                runner = runner.next;
            }
        }
    }
    public Node findNode(int value){
        Node runner = this.head;
        while (runner.value != value){
            runner = runner.next;
        }
        return runner;
    }
    public void removeAt(int n){
        Node runner = this.head;
        if (runner == null){
            System.out.println("SSL is empty. Nothing to remove");
        }else if(n == 0){
            this.head = runner.next;
        }else{
            for (int i=0;i<n-1;i++){
                runner = runner.next;
            }
            runner.next = runner.next.next;
        }
    }
}