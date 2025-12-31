
public class DoubleLL {
    public class Node{
        int data;
        Node next;
        Node prev;
        
        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void printDll(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" <-> ");
            temp=temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void addFirst(int data){
        Node node=new Node(data);
        size++;
        if(head==null){
            head=tail=node;
            return;
        }
        node.next=head;
        head.prev=node;
        head=node;
        return;
    }

    public int removeFirst(){
        if(head==null){
            System.out.println("dll is empty");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        int val=head.data;
        head=head.next;
        head.prev=null;
        size--;
        return val;

    }

    public void reverse(){
        Node curr=head;
        Node prev=null;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;

            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public static void main(String[] args) {
        DoubleLL dll=new DoubleLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addFirst(0);
        dll.printDll();
        System.out.println(size);
        dll.removeFirst();
        dll.printDll();
        System.out.println(size);

        dll.reverse();
        dll.printDll(); 

    }
}
