import java.util.*;
public class StackBasics{
    static class StackArrLists{
        static ArrayList<Integer> list=new ArrayList<>();
        public static boolean isEmpty(){
            return list.size()==0;
        }
        //push
        public static void push(int data){
            list.add(data);
        }
        //pop
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top=list.get(list.size()-1);
            list.remove(top);
            return top;
        }
        //peek
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }

    }

    static class StackLL{
        static class Node{
            int data;
            Node next;
            Node(int data){
                this.data=data;
                this.next=null;
            }
        }
        static Node head=null;

            public static boolean isEmpty(){
                return head==null;
            }
            //push
            public static void push(int data){
                Node newNode=new Node(data);
                if(isEmpty()){
                    head=newNode;
                    return;
                }
                newNode.next=head;
                head=newNode;
            }
            //pop
            public static int pop(){
                if(isEmpty()){
                    return -1;
                }
                int val=head.data;
                head=head.next;
                return val;
            }
            //peek
            public static int peek(){
                if(isEmpty()){
                    return -1;
                }
                return head.data;
            }
    }
    public static void main(String[] args) {
        StackArrLists sal=new StackArrLists();
        System.out.println("stack with array lists");
        sal.push(1);
        sal.push(2);
        sal.push(3);

        while(!sal.isEmpty()){
            System.out.println(sal.peek());
            sal.pop();
        }

        StackLL sll=new StackLL();
        System.out.println("Stack with linked Lists");
        sll.push(1);
        sll.push(2);
        sll.push(3);

        while(!sll.isEmpty()){
            System.out.println(sll.peek());
            sll.pop();
        }

    }
}