
import java.lang.Math;
public class Tree {

    public Tree(int value) {
        this.root = new Node(value) ;
    }
    public Tree(){}

    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node ( int value){
            this.value = value;
        }
    }
    public Node root;
    @Override
    public String toString(){
        return toStringInorder(this.root);
    }

    public String toStringInorder(Node root) {
        String s = "";
        if (root == null) {
            return "";
        }

        s += toStringInorder(root.leftChild);
        s += root.value;
        s += toStringInorder(root.rightChild);
        return s;
    }

    //count of nodes in tree

    public  int countNode( Node root){
        if (root == null)
            return 0;
        return countNode(root.leftChild)+countNode(root.rightChild) +1;
    }

    //count of tree leaf

    public int countLeaf( Node root){
        if(root==null)
            return 0;
        if (root.leftChild==null &&root.rightChild==null)
            return 1;
        return countLeaf(root.rightChild)+countLeaf(root.leftChild);
    }

    //count of only child nodes

    public int countOnlyChildNodes(Node root){
        if (root ==null)
            return 0;
        if ((root.leftChild==null && root.rightChild!=null)||
                (root.rightChild==null &&root.leftChild!=null))
            return 1;
        return countOnlyChildNodes(root.leftChild) + countOnlyChildNodes(root.rightChild);
    }


    //binary search tree
    public void insert(int value){
        var node = new Node(value);
        Node current = root;
        if (root ==null){
            root = node;
            return;
        }
        while (true){
            if (value< current.value){
                if (current.leftChild ==null)
                    current.leftChild = node;
                current = current.leftChild;
            }
            else {
                if (current.rightChild==null)
                    current.rightChild = node;
                current = current.rightChild;
            }

        }
    }

    ///when you delete a node you should have a replace

    public Node findReplace(Node deleted){
        Node current;
        if(deleted.rightChild==null){
            current = deleted.leftChild;
            while (current.rightChild!=null){
                current=current.rightChild;
            }
            return current;
        }
       else if (deleted.leftChild ==null){
            current = deleted.rightChild;
            while (current.leftChild!=null){
                current = current.leftChild;
            }
            return current;
        }
       return null ;

    }

    //delete node

    public void deleteNode(Node del){
        var replace = findReplace(del);
        swap(del , replace);
        if(replace.rightChild!=null)
            deleteNode(replace);

        if(replace.leftChild!=null)
            deleteNode(replace);
        else {
            free(replace);
        }
    }
    private void free(Node node){
        node.leftChild = null;
        node.rightChild=null;
        node.value = 0;

    }
    private void swap(Node first , Node second){
        int temp = first.value;
        first.value = second.value;
        second.value = temp;
    }


    //post order
    public void postOrder(Node node){
        postOrder(node.leftChild);
        postOrder(node.rightChild);
        System.out.println(node.value);
    }

    //in order
    public void inOrder(Node node){
        inOrder(node.leftChild);
        System.out.println(node.value);
        inOrder(node.rightChild);
    }

    //pre order
    public void preOrder(Node node){
        System.out.println(node.value);
        preOrder(node.leftChild);
        preOrder(node.rightChild);

    }

    //find

    public boolean find(int value){
        Node current = root;
        while (current!=null){
            if (value<current.value)
                current = current.leftChild;
            if (value>current.value)
                current = current.rightChild;
            else return true;
        }
        return false;
    }

    //find min
    public int findMin(Node node){
        if (node.leftChild==null &&node.rightChild==null)
            return node.value;
        return Math.min(findMin(node.rightChild),findMin(node.leftChild));
    }

    //find min binary tree
    public int findMinBinary(Node node){
        var current = node;
        var last = current;
        while (current!= null){
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    //height
    public int height (Node node){
        if (node.leftChild==null &&node.rightChild==null)
            return 0;
        return 1+ Math.max(height(node.leftChild), height(node.rightChild));
    }

    //equal two tree
    public boolean equal(Node first, Node second){
        if (first ==null && second==null)
            return true;
        if (first !=null && second!=null){
            return first.value == second.value
                    && equal(first.rightChild , first.leftChild)
                    && equal(first.leftChild , first.rightChild);


        }
        return false;
    }

    //is binary search tree

    public boolean isBinarySearchTree(Node node){
        return isBinarySearchTree(node , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }
    private boolean isBinarySearchTree(Node root , int min , int max){
        if (root==null)
            return true;
        if (root.value<min || root.value>max )
            return false;
        return isBinarySearchTree(root.rightChild , root.value+1 , max)
                && isBinarySearchTree(root.leftChild , min , root.value-1 )
                && (height(root.rightChild)<height(root.leftChild));
    }


}
