package hotpotato;

/**
 *Nicholas Knight
 */
public class CircularLL <T> {
    private class ListNode{
        T data;
        ListNode link; 
        public ListNode(T aData, ListNode aLink){
            data=aData;
            link=aLink;
        }    
    }
    ListNode head;
    ListNode curr;
    ListNode prev;
    public CircularLL(){
        head=curr=prev=null;
    }
    public void insert(T aData){
        ListNode newNode=new ListNode(aData,null);
        if(head==null){
            head= newNode;
            curr=newNode;
            return;
        }
        ListNode temp=head;
        while(temp.link!=null){
            temp=temp.link;
        }
        temp.link=newNode;
            
    }
    public void printCurr(){
        System.out.println(curr.data);
    }
    public void print(){
        ListNode temp= head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.link;
        }
    }
    public void moveForward(){
        if(curr==null)
            return;
        prev=curr;
        curr=curr.link;
        if(curr.link==null){
            curr.link=head;
        }
    }
    public void resetCurrent(){
        curr=head;
        prev=null;
    }
    public T getCurrent(){
        if(curr==null)
            return null;
        return curr.data;
    }
    public void setCurrent(T aData){
        if(curr!=null)
            curr.data=aData;
    }
    public void deleteCurrent(){
        if(curr!=null && prev!=null){
            prev.link=curr.link;
            curr=curr.link;
        }
        else if(curr!=null)
            head=head.link;
    }
    public boolean onePlayerLeft(){
        boolean win=false;
        if(curr==curr.link)
            win=true;
        return win;
    }
}
