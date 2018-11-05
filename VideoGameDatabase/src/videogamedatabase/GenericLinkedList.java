package videogamedatabase;

/**
 *Written by Nicholas Knight
 */
public class GenericLinkedList <T> {
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
    public GenericLinkedList(){
        head=curr=prev=null;
    }
     public void insert(T aData){ //insert at the end of list
         //create new node
         ListNode newNode=new ListNode(aData, null);//links to nothing cause its the end
         //link it to the end
         //check where the end is to see where to add it
         if(head==null){ //empty list
             head=newNode;
             curr=newNode; //curr=head
             return;
         }
         ListNode temp= head;
         while(temp.link!=null){ //check for end of list
             temp=temp.link;
         }
         temp.link=newNode;//adds to end of list
         
     }
     public void print(){
         ListNode temp=head;
         while(temp!=null){
             System.out.println(temp.data);
             temp=temp.link;
         }
         
         /*alt way off the scrpit
         for(ListNode temp= head; temp!=null; temp=temp.link)
         {
             System.out.println(temp.data);
         }*/
     }
     public void moveCurrFoward(){
         if(curr==null){
             return;
         }
         prev= curr;
         curr=curr.link;
         
     }
     public void resetCurrent(){
         curr=head;
         prev=null;
     }
     public T getCurrent(){
         if(curr==null){
             return null;
         }
         return curr.data;
     }
     public void setCurrent(T aData){
         if(curr!=null)
             curr.data=aData;
     }
     public boolean moreToIterate(){
         return curr!=null;
     }
     public void deleteCurrent(){
         //cutt it out of the list
         if(curr!=null && prev!=null){
             //somewhere in the middle
             prev.link=curr.link;
             curr=curr.link;
         }
         else if(curr!=null){
             //curr is the head
             head=head.link;
         }
     }
}
