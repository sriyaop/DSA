  public class LinkedList{
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size=0;

    public void addFirst(int data){
        //create new node
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        //new node next= head
        newNode.next=head;

        //newNode = head
        head=newNode;
    }

    public void addLast(int data){
        //create new node
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }

        //new node next= head
        tail.next=newNode;

        //newNode = head
        tail=newNode;
    }

    public void printLL(){
        Node node=head;
        while(node!=null){
            System.out.print(node.data+"->");
            node=node.next;
        }
        System.out.println("null");
    }

    public void add(int idx,int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newNode=new Node(data);
        size++;
        Node temp=head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }

    public int removeFirst(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        //prev node i=size-2
        Node prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        int val=prev.next.data;
        prev.next=null;
        tail=prev;
        size--;
        return val;
    }

    public int itrSearch(int key){
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }
    public int recurrSearch(int key,Node node,int idx){
        if(head==null){
            return -1;
        }
        if(node.data==key){
            return idx;
        }
        return recurrSearch(key,node.next,idx+1);
    }

    public void reverse(){
        Node prev=null;//before head
        //put curr at head 
        Node curr=tail=head;//brings tail to head first so that we can move head to tail's place latter...
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    public void deleteNthFromEnd(int n){
        //calculate size
        int sz=0;
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
            sz++;
        }
        if(n==sz){
            head=head.next;//remove first
            return;
        }
        //sz-n
        int i=1;
        int iTofind=sz-n;
        Node prev=head;
        while(i<iTofind){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;
    }

    public Node findMid(Node head){//helper function
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;//+1
            fast=fast.next.next;//+2
        }
        return slow;
    }

    public boolean checkPalindrome(){
        if(head==null || head.next==null){
            return true;
        }
        //step-1 find mid
        Node midNode=findMid(head);

        //step-2 reverse 2nd half
        Node prev=null;
        Node curr=midNode;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node right=prev;//right half's head
        Node left=head;

        //step-3 check left and right halfs
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }

    public static boolean isCycle(){//floyd's cycle finding algorithm
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;//+1
            fast=fast.next.next;//+2
            if(slow==fast){
                return true;//cycle exists
            }
        }
        return false;//cycle does'nt exist
    }

    public static void removeCycle(){
        //detect cycle
        Node slow=head;
        Node fast=head;
        boolean cycle=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;//+1
            fast=fast.next.next;//+2
            if(slow==fast){
                cycle=true;
                break;
            }
        }
        if(cycle==false){
            System.out.println("cycle does not exist!");
        }
        //find meeting point
        slow=head;
        Node prev=null;
        while(slow!=fast){
            slow=slow.next;
            prev=fast;
            fast=fast.next;
        }

        //remove cycle-> prev.next=null
        prev.next=null;
    }
    private Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null &&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;//mid node
    }

    private Node merge(Node lh,Node rh ){
        Node mergedLL=new Node(-1);
        Node temp=mergedLL;

        while(lh!=null && rh!=null){
            if(lh.data<=rh.data){
                temp.next=lh;
                lh=lh.next;
                temp=temp.next;
            }else{
                temp.next=rh;
                rh=rh.next;
                temp=temp.next;
            }
        }
        while(lh!=null){
            temp.next=lh;
            lh=lh.next;
            temp=temp.next;
        }
        while(rh!=null){
            temp.next=rh;
            rh=rh.next;
            temp=temp.next;
        }
        return mergedLL.next;
    }
    public Node mergeSort(Node head){

        if(head==null || head.next==null){
            return head;
        }
        //find mid
        Node mid=getMid(head);

        //left & right MS
        Node rightHead=mid.next;
        mid.next=null;
        Node newLeft=mergeSort(head);
        Node newRight=mergeSort(rightHead);

        //merge
        return merge(newLeft,newRight);
    }

    public void zigZag(){
        //find mid
        Node mid=getMid(head);

        //reverse 2nd half
        //step-2 reverse 2nd half
        Node prev=null;
        Node curr=mid.next;
        mid.next=null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node right=prev;//right half's head
        Node left=head;
        Node nextL,nextR;

        //alternate merge
        while(left!=null && right!=null){
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;

            left=nextL;
            right=nextR;
        }
    }

    public static void main(String args[]){
        LinkedList ll=new LinkedList();
        // ll.printLL();
        // ll.addFirst(1);
        // ll.printLL();
        // ll.addFirst(2);
        // ll.printLL();
        // ll.addLast(8);
        // ll.printLL();
        // ll.addLast(26);
        // ll.printLL();
        // ll.add(2,5);
        // ll.printLL();
        // System.out.println(size);
        // System.out.println(ll.removeFirst());
        // ll.printLL();
        // System.out.println(size);
        // System.out.println(ll.removeLast());
        // ll.printLL();
        // System.out.println(size);
        // System.out.println(ll.itrSearch(5));
        // System.out.println(ll.recurrSearch(5,head,0));
        // ll.deleteNthFromEnd(2);

        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(2);
        // ll.addLast(1);
        // ll.printLL();
        // System.out.println(ll.checkPalindrome());

        // head=new Node(1);
        // head.next=new Node(2);
        // head.next.next=new Node(3);
        // head.next.next.next=head;
        // //1-2-3-1
        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        // ll.addFirst(3);
        // ll.addFirst(4);
        // ll.addLast(5);
        // ll.addLast(6);
        // ll.add(3,4);
        // ll.addFirst(7);
        // ll.addFirst(1);

        // ll.printLL();

        // ll.head=ll.mergeSort(ll.head);

        // ll.printLL();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        
        ll.printLL();

        ll.zigZag();

        ll.printLL();

    }
}