import java.util.*;
public class BuildBT{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree{
        static int idx=-1;
        public static Node buildTree(int nodes[]) {
            idx++;  // Always increment first
            if (idx >= nodes.length || nodes[idx] == -1) {
                return null;
            }
        
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
        
            return newNode;
        }

        public static void preOrder(Node root){
            if(root==null){
                // System.out.print(-1+" ");
                return;
            }
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root){
            if(root==null){
                // System.out.print(-1+" ");
                return;
            }
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }

        public static void postOrder(Node root){
            if(root==null){
                // System.out.print(-1+" ");
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
        
        public static void levelOrder(Node root){
            if(root==null){
                return;
            }

            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);
            int height=0;
            while(!q.isEmpty()){
                Node currNode=q.remove();
                if(currNode==null){
                    System.out.println();
                    height++;
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }
            System.out.println("height of tree in terms of 'nodes' is "+height);
            System.out.println("height of tree in terms of 'edges' is "+(height-1));
        }
        
        public static int h=0;
        public static int height(Node root){
            if(root==null){
                return 0;
            }
            int lh=height(root.left);
            int rh=height((root.right));
            h=Math.max(lh,rh)+1;

            return h;
        }

        public static int count=0;
        public static int countNodes(Node root){
            if(root==null){
                return 0;
            }
            int lcnt=countNodes(root.left);
            int rcnt=countNodes(root.right);
            count=lcnt+rcnt+1;

            return count;
        }
        
        public static int sumNodes(Node root) {
            if (root == null) {
                return 0;
            }
            return root.data + sumNodes(root.left) + sumNodes(root.right);
        }
        
        public static int diameterApproach1(Node root){
            if(root==null){
                return 0;
            }
            int leftDiam=diameterApproach1(root.left);
            int leftHeight=height(root.left);

            int rightDiam=diameterApproach1(root.right);
            int rightHeight=height(root.right);

            int selfDiam=leftHeight+rightHeight+1;
            return Math.max(selfDiam,Math.max(leftDiam,rightDiam));

        }

        static class Info{
            int diam;
            int ht;

            public Info(int diam,int ht){
                this.diam=diam;
                this.ht=ht;
            }
        }

        public static Info diameter(Node root){
            if(root==null){
                return new Info(0,0);
            }
            Info leftInfo=diameter(root.left);
            Info rightInfo=diameter(root.right);

            int diam=Math.max(leftInfo.ht+rightInfo.ht+1,Math.max(leftInfo.diam,rightInfo.diam));
            int ht=Math.max(leftInfo.ht,rightInfo.ht)+1;

            return new Info(diam,ht);

        }
        
        public static boolean isIdentical(Node node,Node subRoot){
            if(node==null && subRoot==null){
                return true;
            }else if(node==null||subRoot==null|| node.data!=subRoot.data){
                return false;
            }

            if(!isIdentical(node.left,subRoot.left)){
                return false;
            }
            if(!isIdentical(node.right,subRoot.right)){
                return false;
            }

            return true;
        }

        public static boolean isSubTree(Node root,Node subRoot){
            if(root==null){
                return false;
            }

            if(root.data==subRoot.data){
                if(isIdentical(root,subRoot)){
                    return true;
                }
            }
            boolean leftAns=isSubTree(root.left,subRoot);
            boolean rightAns=isSubTree(root.right,subRoot);

            return leftAns||rightAns;
        }
        
        //top view of tree
        static class Information{
            Node node;
            int hd;
            public Information(Node node,int hd){
                this.node=node;
                this.hd=hd;
            }
        }

        public static void topView(Node root){
            //Level Order we gonna use
            Queue<Information> q= new LinkedList<>();
            HashMap<Integer,Node> map=new HashMap<>();

            int min=0,max=0;
            q.add(new Information(root,0));
            q.add(null);//tracks a level indication

            while(!q.isEmpty()){
                Information curr=q.remove();
                if(curr==null){
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    if(!map.containsKey(curr.hd)){//first time this horizontal distance occurred
                        map.put(curr.hd,curr.node);
                    }
    
                    if(curr.node.left !=null){
                        q.add(new Information(curr.node.left,curr.hd-1));
                        min=Math.min(min,curr.hd-1);
                    }
    
                    if(curr.node.right !=null){
                        q.add(new Information(curr.node.right,curr.hd+1));
                        max=Math.max(max,curr.hd+1);
                    }
    
                }
            }

            for(int i=min;i<=max;i++){
                System.out.print(map.get(i).data+" ");
            }
            System.out.println();
        }
    
        public static void KLevel(Node root,int level,int K){
            if(root==null){
                return;
            }

            if(level==K){
                System.out.print(root.data+" ");
                return;
            }
            KLevel(root.left,level+1,K);
            KLevel(root.right,level+1,K);
        }

        public static boolean getPath(Node root,int n,ArrayList<Node> path){
            if(root==null){
                return false;
            }
            path.add(root);
            if(root.data==n){
                return true;
            }

            boolean foundLeft=getPath(root.left,n,path);
            boolean foundRight=getPath(root.right,n,path);

            if(foundLeft || foundRight){
                return true;
            }

            path.remove(path.size()-1);
            return false;
        }

        public static Node lca(Node root,int n1,int n2){
            ArrayList<Node> path1=new ArrayList<>();
            ArrayList<Node> path2=new ArrayList<>();

            getPath(root,n1,path1);
            getPath(root,n2,path2);

            //last common ancestor
            int i=0;
            for(;i<path1.size() && i<path2.size();i++){
                if(path1.get(i)!=path2.get(i)){
                    break;
                }
            }

            //last equal node-> i-1th

            Node lca=path1.get(i-1);
            return lca;
        }
    }
    public static void main(String[] args) {
        // int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1};
        // BinaryTree tree=new BinaryTree();
        // Node root=tree.buildTree(nodes);
        // System.out.println("root is: "+root.data);

        // System.out.print("pre-Order traversal: ");
        // tree.preOrder(root);
        // System.out.println();

        // System.out.print("in-Order traversal: ");
        // tree.inOrder(root);
        // System.out.println();

        // System.out.print("post-Order traversal: ");
        // tree.postOrder(root);
        // System.out.println();

        // System.out.println("level-Order traversal: ");
        // tree.levelOrder(root);

        // System.out.println("height is "+tree.height(root));
        // System.out.println("total node count is "+tree.countNodes(root));
        // System.out.println("total node sum is "+tree.sumNodes(root));
        // System.out.println("diameterApproach1 of tree is "+tree.diameterApproach1(root));
        
        /* 
                  1
                 / \
                2   3
               / \ / \
              4  5 6  7

         */
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        /* 
                2
               / \
              4   5

         */
        
        Node subRoot=new Node(2);
        subRoot.left=new Node(4);
        subRoot.right=new Node(5);

        //System.out.println(BinaryTree.isSubTree(root,subRoot));
        BinaryTree.topView(root);
        BinaryTree.KLevel(root,1,2);
    }
}