import java.util.LinkedList;
public class LLWithJCF {
    public static void main(String[] args) {
        LinkedList<Integer> ll= new LinkedList<>();

        ll.addFirst(3);
        ll.addFirst(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.add(3,4);
        ll.addFirst(7);
        ll.addFirst(1);

        System.out.println(ll);
        ll.removeFirst();
        ll.remove(5);

        System.out.println(ll);


    }
}
