package treeofstrings;

/**
 *Written by Nicholas Knight
 */
public class StrBSTree{
    private class Node{
        private String data;
        Node leftChild;
        Node rightChild;
        public Node(String aData){
            data= aData;
            leftChild=rightChild=null;
        }
    }
    private Node root;
    public StrBSTree(){
        root=null;
    }
    public void insert(String aData){
        if(root==null)
            root=new Node(aData);
        else
            insert(root, aData);
    }
    private Node insert(Node aNode, String aData){
        if(aNode==null)
            aNode= new Node(aData);
        else if(aData.length()-aNode.data.length()<0)
            aNode.leftChild=insert(aNode.leftChild, aData);
        else if(aData.length()-aNode.data.length()>=0)
            aNode.rightChild=insert(aNode.rightChild, aData);
        return aNode;
    }
    public void printPreOrder(){
        printPreOrder(root);
    }
    private void printPreOrder(Node aNode){
        if(aNode==null)
            return;
        System.out.println(aNode.data);
        printPreOrder(aNode.leftChild);
        printPreOrder(aNode.rightChild);
    }
    public void delete(String aData){
        root=delete(root, aData);
    }
    private Node delete(Node aNode, String aData){
        if(aNode==null)
            return null;
        if(aData.length()-aNode.data.length()<0)
            aNode.leftChild=delete(aNode.leftChild, aData);
        else if(aData.length()-aNode.data.length()>0)
            aNode.rightChild=delete(aNode.rightChild, aData);
        else{   //found value
            if(aNode.rightChild==null)
                return aNode.leftChild;
            if(aNode.leftChild==null)
                return aNode.rightChild;
            aNode.data=smallestInTree(aNode.rightChild);
            delete(aNode.rightChild, aNode.data);
        }
        return aNode;
    }
    private String smallestInTree(Node aNode){
        if(aNode.leftChild==null)
            return aNode.data;
        else
            return smallestInTree(aNode.leftChild);
    }
    public void getDepth(String aData){
        int depth=-1;
        getDepth(root, aData, depth);
        //System.out.println(depth);
        
    }
    private void getDepth(Node aNode, String aData, int depth){
        if(aNode==null)
            return;
        else if(aData.length()-aNode.data.length()<0){  //go left
            depth=depth+1;
            //System.out.println(depth);
            getDepth(aNode.leftChild, aData, depth);
        }
        else if(aData.length()-aNode.data.length()>=0){   //go right
            depth=depth+1;
            //System.out.println(depth);
            getDepth(aNode.rightChild, aData,depth);
        }
        //decide left or right or match if match print the depth
        if(aNode.data.equals(aData))
            System.out.println("The depth of "+aData+ " is "+ depth);
        return;
        
    }
}
