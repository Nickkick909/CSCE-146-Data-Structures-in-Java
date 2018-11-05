package grocerylistfrontend;

/**
 *Written by Nicholas Knight
 */
public class GroceryListFrontEnd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GroceryList list= new GroceryList();
        System.out.println("Grocery List Tester"
        +"\nCreating grocery list"
        +"\nAdding 5 grocery items"
        +"\nPrint out list");
        GroceryItem item1= new GroceryItem("Taco", 2.0);
        list.addItem(item1);
        GroceryItem item2= new GroceryItem("Salsa",1.59);
        list.addItem(item2);
        GroceryItem item3= new GroceryItem("Chips", 1.29);
        list.addItem(item3);
        GroceryItem item4= new GroceryItem("Ground Beef", 4.59);
        list.addItem(item4);
        GroceryItem item5= new GroceryItem("Shredded Cheese", 2.99);
        list.addItem(item5);
        list.showList();
        //list.curr=list.head;    //start at beginning of list
        System.out.println("Moving current twice");
        list.goToNext();
        list.goToNext();
        System.out.println("Adding an item after current"
        +"\nPrinting list");
        GroceryItem item6= new GroceryItem("Heart Burn Medicine", 5.99);
        list.insertAfterCurrent(item6);
        list.showList();
        System.out.println("Maybe I should add something healthy");
        GroceryItem item7= new GroceryItem("Banana", 0.99);
        list.insertAfterCurrent(item7);
        list.showList();
        System.out.println("Nevermind let\'s get rid of that");
        list.goToNext();    //move to banana and remove it
        list.deleteCurrentNode();
        list.showList();
        System.out.println("Did I remember the salsa?");
        System.out.println(list.contains(item2));
        System.out.print("The total cost is ");//+list.totalCost());
        System.out.println(list.totalCost());
        System.out.println("Done!!");
        
    }
    
}
