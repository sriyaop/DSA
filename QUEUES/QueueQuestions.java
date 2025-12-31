import java.util.*;
public class QueueQuestions {
    //Queue with 2 Stacks
    // static class Queue{
    //     static Stack<Integer> s1= new Stack<>();
    //     static Stack<Integer> s2= new Stack<>();
    //     public static boolean isEmpty(){
    //         return s1.isEmpty();
    //     }
    //     //add O(n)
    //     public static void add(int data){
    //         while(!s1.isEmpty()){
    //             s2.push(s1.pop());
    //         }
    //         s1.push(data);
    //         while(!s2.isEmpty()){
    //             s1.push(s2.pop());
    //         }
    //     }
    //     //remove O(1)
    //     public static int remove(){
    //         if(s1.isEmpty()){
    //             System.out.println("Empty");
    //             return -1;
    //         }
    //         return s1.pop();
    //     }
    //     //peek O(1)
    //     public static int peek(){
    //         if(s1.isEmpty()){
    //             System.out.println("Empty");
    //             return -1;
    //         }
    //         return s1.peek();
    //     }
    // }

    //Stack with 2 Queues
    // static class Stack{
    //     static Queue<Integer> q1= new LinkedList<>();
    //     static Queue<Integer> q2= new LinkedList<>();
    //     public static boolean isEmpty(){
    //         return q1.isEmpty() && q2.isEmpty();
    //     }
    //     //add O(n)
    //     public static void push(int data){
    //         if(!q1.isEmpty()){
    //             q1.add(data);
    //         }else{
    //             q2.add(data);  
    //         }
    //     }
    //     //remove O(1)
    //     public static int pop(){
    //         if(isEmpty()){
    //             System.out.println("Empty Stack");
    //             return -1;
    //         }
    //         int top=-1;
    //         if(!q1.isEmpty()){
    //             while(!q1.isEmpty()){
    //                 top=q1.remove();
    //                 if(q1.isEmpty()){
    //                     break;
    //                 }
    //                 q2.add(top);
    //             }
    //         }else{
    //             while(!q2.isEmpty()){
    //                 top=q2.remove();
    //                 if(q2.isEmpty()){
    //                     break;
    //                 }
    //                 q1.add(top);
    //             }
    //         }
    //         return top;
    //     }
    //     //peek O(1)
    //     public static int peek(){
    //         if(isEmpty()){
    //             System.out.println("Empty Stack");
    //             return -1;
    //         }
    //         int top=-1;
    //         if(!q1.isEmpty()){
    //             while(!q1.isEmpty()){
    //                 top=q1.remove();
    //                 q2.add(top);
    //             }
    //         }else{
    //             while(!q2.isEmpty()){
    //                 top=q2.remove();
    //                 q1.add(top);
    //             }
    //         }
    //         return top;
    //     }
    // }

    public static void printNonRepeatin(String str){
        int freq[]= new int[26];
        Queue<Character> q=new LinkedList<>();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;

            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove();
            }

            if(q.isEmpty()){
                System.out.print(-1+" ");
            }else{
                System.out.print(q.peek()+" ");
            }
        }
        System.out.println();
    }

    public static void interleaveQueue(Queue<Integer> queue) {
        if (queue.size() % 2 != 0) {
            throw new IllegalArgumentException("Queue must have an even number of elements");
        }

        int halfSize = queue.size() / 2;
        Queue<Integer> firstHalf = new LinkedList<>();

        // Move first half of the queue to a separate queue
        for (int i = 0; i < halfSize; i++) {
            firstHalf.add(queue.remove());
        }

        // Interleave the two halves
        while (!firstHalf.isEmpty()) {
            queue.add(firstHalf.remove()); // Add from first half
            queue.add(queue.remove());     // Add from second half
        }
    }
    
    public static void queueReversal(Queue<Integer> queue){
        Stack<Integer> s=new Stack<>();
        while(!queue.isEmpty()){
            s.push(queue.remove());
        }

        while(!s.isEmpty()){
            queue.add(s.pop());
        }

    }
    public static void main(String[] args) {
        //Queue with 2 stacks
        // Queue q= new Queue();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // while(!q.isEmpty()){
        //     System.out.println(q.peek());
        //     q.remove();
        // }

        //Stack with 2 Queues
        // Stack s= new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }

        //printNonRepeatin
        String str="aabccxb";
        printNonRepeatin(str);

        //interleaveQueue even length
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            queue.add(i);
        }

        System.out.println("Original queue: " + queue);
        interleaveQueue(queue);
        System.out.println("Interleaved queue: " + queue);

        Queue<Integer> queue2 = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            queue2.add(i);
        }
        System.out.println("Original queue: " + queue2);
        queueReversal(queue2);
        System.out.println("Ireversed queue: " + queue2);
    }
}
