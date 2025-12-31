import java.util.*;

public class DequeUses {
    static class Stack{
        Deque<Integer> deque=new LinkedList<>();

        public void push(int data){
            deque.addLast(data);
        }

        public int pop(){
            if(deque.isEmpty()){
                return -1;
            }
            return deque.removeLast();
        }

        public int peek(){
            if(deque.isEmpty()){
                return -1;
            }
            return deque.getLast();
        }
    }

    static class Queue{
        Deque<Integer> deque=new LinkedList<>();

        public void add(int data){
            deque.addLast(data);
        }

        public int remove(){
            if(deque.isEmpty()){
                return -1;
            }
            return deque.removeFirst();
        }

        public int peek(){
            if(deque.isEmpty()){
                return -1;
            }
            return deque.getFirst();
        }
    }

    public static void main(String[] args) {
        Stack s=new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(" peek= "+s.peek());

        Queue q=new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(" peek= "+q.peek());
        
    }
}
