/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processqueuesimulator;

/**
 *Nicholas Knight
 */
public class LinkedListQueue <T>{
   private class ListNode{
        T data;
        ListNode link;
        public ListNode(T aData, ListNode aLink){
            data=aData;
            link=aLink;
        }
    }
        private ListNode head;
        private ListNode tail;
    
        public LinkedListQueue()
        {
         head=tail=null;   
        }
        public void enqueue(T aData){
            ListNode newNode=new ListNode(aData,null);
            if(head==null){
                head=tail=newNode;
                return;
            }
            tail.link=newNode;
            tail=newNode;
        }
        public T dequeue(){
            if(head==null)
                return null;
            T ret=head.data;
            head=head.link;
            return ret;
        }
        public T peek(){
            if(head==null)
                return null;
            return head.data;
        }
        public void print(){
            ListNode temp=head;
            while(temp!=null){
                System.out.println(temp.data);
                temp=temp.link;
            }
        } 
}
