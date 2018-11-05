package grocerylistfrontend;

/**
 *Written by Nicholas Knight
 */
public class GroceryList {
    private class ListNode{
        private GroceryItem data;
        private ListNode link;
        
        public ListNode(GroceryItem aData, ListNode aLink){
            data=aData;
            link=aLink;
        }
    }
    ListNode head;
    ListNode curr;
    ListNode prev;
    public GroceryList(){
        head=curr=prev=null;
    }
    public void goToNext(){
        if(curr==null)
            return;
        prev=curr;
        curr=curr.link;
    }
    public GroceryItem getDataAtCurrent(){
        if(curr!=null)
            return curr.data;
        else
            return null;
    }
    public void setDataAtCurrent(GroceryItem aData){
        if(curr!=null)
            curr.data=aData;
    }
    public void addItem(GroceryItem aData){
        //create new node
        ListNode newNode= new ListNode(aData,null);
        if(head==null){ //check head 
            head=newNode;   //means list is empty so we make the first one
            curr=head;
            return;
        }
        //find end of list
        ListNode temp=head;
        while(temp.link!=null){
            temp = temp.link;
        }
        //add to end
        temp.link=newNode;
    }
    public void insertAfterCurrent(GroceryItem aData){
        ListNode newNode=new ListNode(aData, curr.link);
        if(curr!=null){
            curr.link= newNode;
        }
        else if(head!=null){    //current is outside of linked list
            return;
        }
        else{   //empty (head null, and curr null so no list
            return;
        }
    }
    public void deleteCurrentNode(){
         if(curr!=null && prev !=null){
            prev.link=curr.link;
            curr=curr.link;
            
        }
        else if(curr!=null && prev ==null){//curr is head
            head=head.link;
            curr=head;
        }
        else{
            System.out.println("List was empty");
        }
    }
    public void showList(){
        ListNode temp=head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.link;
        }
    }
    public boolean contains(GroceryItem aData){
        ListNode temp=head;
        boolean contains=false;
        while(temp!=null){
            if(temp.data== aData){
                contains=true;
                break;
            }
            temp=temp.link;
        }
        return contains;
    }
    public double totalCost(){
        ListNode temp=head;
        double total=0.0;
        while(temp!=null){
            total+=temp.data.getValue();
            temp=temp.link;
            
        }


        return total;
    }      
}
