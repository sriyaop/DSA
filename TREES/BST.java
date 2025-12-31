import java.util.ArrayList;
public class BST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){
            root.left=insert(root.left,val);
        }else{
            root.right=insert(root.right,val);
        }
        return root;
    }
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static boolean search(Node root,int value){//O(H)
        if(root==null){
            return false;
        }
        if(root.data==value){
            return true;
        }
        if(root.data>value){
            return search(root.left,value);
        }else{
            return search(root.right,value);
        }
    }

    public static Node findInOrderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }

    public static Node deleteNode(Node root, int val){
        if(root==null){
            return null;
        }
        if(root.data>val){
            root.left= deleteNode(root.left,val);
        }
        else if(root.data<val){
            root.right= deleteNode(root.right,val);
        }
        else{//found the node
            //case-1: leaf
            if(root.left==null &&root.right==null){
                return null;
            }

            //case-2: one child
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }

            //case-3: two children
            Node inSucc=findInOrderSuccessor(root.right);
            root.data=inSucc.data;
            root.right=deleteNode(root.right, inSucc.data);
        }
        return root;
    }

    public static void printInRange(Node root,int k1,int k2){
        if(root==null) return;

        if(root.data>=k1 && root.data<=k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        else if( root.data<k1){//all values lie in left subtree
            printInRange(root.right, k1, k2);
        }else{
            printInRange(root.left, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> path){
        System.out.println();
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
    }
    public static void printPaths2Leafs(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null){
            printPath(path);
        }
        printPaths2Leafs(root.left, path);
        printPaths2Leafs(root.right, path);
        path.remove(path.size()-1);
    }

    public static void main(String args[]){
        int values[]={5,1,3,4,8,9,2,7,6};
        Node root=null;
        for(int i=0;i<values.length;i++){
            root=insert(root,values[i]);
        }
        inOrder(root);
        System.out.println(search(root,7));
        System.out.println();
        deleteNode(root, 5);
        inOrder(root);
        System.out.println(search(root,5));
        System.out.println();
        printInRange(root, 2, 7);
        System.out.println();
        ArrayList<Integer> path=new ArrayList<>();
        printPaths2Leafs(root, path);
    }
}
