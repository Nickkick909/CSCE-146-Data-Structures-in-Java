package fruittree;

/**
 *Nicholas Knight
 */
public class GenericTree <T extends Comparable<T>>{
    private class Node{
        T data;
        Node leftChild;
        Node rightChild;
        public Node(T aData){
            data=aData;
            leftChild=rightChild=null;
        }
    }
    private Node root;
    public GenericTree(){
        root=null;
    }
    public void insert(T aData){
        if(root==null)
            root=new Node(aData);
        else
            insert(root, aData);
    }
    public Node insert(Node aNode, T aData){
        if(aNode==null)
            aNode=new Node(aData);
        else if(aData.compareTo(aNode.data)<0)
            aNode.leftChild=insert(aNode.leftChild, aData);
        else if(aData.compareTo(aNode.data)>=0)
            aNode.rightChild=insert(aNode.rightChild, aData);
        return aNode;
    }
    public void delete(T aData){
        root=delete(root, aData);
    }
    private Node delete(Node aNode, T aData){
        //find value
        if(aNode==null) //not found
            return null;
        if(aData.compareTo(aNode.data)<0)       //no left
            aNode.leftChild=delete(aNode.leftChild, aData);
        else if(aData.compareTo(aNode.data)>0)   //go right
            aNode.rightChild=delete(aNode.rightChild, aData);
        else    //found value so kill it
        {
            if(aNode.rightChild==null)  //either no child or just left
                return aNode.leftChild;
            if(aNode.leftChild==null)   //has only right
                return aNode.rightChild;
            //it has 2 children
            aNode.data=smallestInTree(aNode.rightChild);
            delete(aNode.rightChild, aNode.data);   //deletes duplicate
        }
        return aNode;
    }
    private T smallestInTree(Node aNode){
        if(aNode.leftChild==null)
            return aNode.data;
        else
            return smallestInTree(aNode.leftChild);
    }
    public void printPreOrder(){
        printPreOrder(root);
    }
    private void printPreOrder(Node aNode){
        if(aNode == null)
            return;
        System.out.println(aNode.data);     //print
        printPreOrder(aNode.leftChild);     //go left   
        printPreOrder(aNode.rightChild);    //go right
    }
    public void printInOrder(){
        printInOrder(root);
    }
    private void printInOrder(Node aNode){
        if(aNode==null)
            return;
        printInOrder(aNode.leftChild);      //go left
        System.out.println(aNode.data);     //print
        printInOrder(aNode.rightChild);     //go right
    }
    public void printPostOrder(){
        printPostOrder(root);
    }
    private void printPostOrder(Node aNode){
        if(aNode==null)
            return;
        printInOrder(aNode.leftChild);      //go left
        printInOrder(aNode.rightChild);     //go right  
        System.out.println(aNode.data);     //print
    }
}
