import java.util.*;
import javax.swing.*;
import java.text.*;

public class LinkedList {
  //reference to the head node
    
    private Node head;
    private int listCount;
    
    //linked list constructor
    
    public LinkedList() {
        //this is an empty list, so the reference to the head node is set to the new node with no data
        
        head = new Node(null);
        listCount = 0;

    }
    
    public void add(Object data){
        // post: append the specified element to the end of the list
        
         Node temp = new Node(data);
         Node current = head;
         // starting at the head, crawl to the end of the list
         while (current.getNext() != null){
             current = current.getNext();
             
         }
         // the last node (reference)
         
         current.setNext(temp);
         listCount++;
  
    }
     
    private Object sum(){
        Node temp = head;
        double sum = 0;
        
        while (temp != null){
            sum += (double) temp.getData();
            temp = temp.getNext();
        }
        
        return sum;
    }
    // removes an element from the list at the specified location
    public boolean remove(Object num){
        Node current = head;
        
       while (current != null){
           if (num == current.data){
               return true;
           } else
               current = current.getNext();
       }   
        return false;
    }
    
    private void printList(){
        String output = "\n The Linked list elements are: \n";
        Node temp = head;
        while (temp.getNext() != null){
           temp = temp.getNext();
           output += "     " + temp.getData();
           
        }
       JOptionPane.showMessageDialog(null, output);
    }
    
    
    private class Node{
        
        Node next;
        Object data;
        
        //the Node constuctor
        public Node(Object _data){
            next = null;
            data = _data;
            
        }
        
        public Node(Object _data, Node _next){
            
            next = _next;
            data = _data;
        }
        
        public Object getData(){
            return data;
        }
        
        public void setData(Object _data){
            data = _data;
        }
        
        public Node getNext(){
            return next;
        }
        
        public void setNext(Node _next){
            next = _next;
        }
    }
    
    public static void main(String[] args) {
        
        LinkedList list = new LinkedList();
        
        Scanner keyboard = new Scanner(System.in);
        
        DecimalFormat df = new DecimalFormat("####.##");
        
         for (int i = 0; i<5 ; i++){
            String n = df.format(Math.random() * 10) ;
            list.add(n);
        }
        while (true){
                     
        String output = "";
        
        String input = JOptionPane.showInputDialog(
                "\n Make a selection from the following\n"
                + "\n 1. Insert an element into the list,"
                + "\n 2. Delete an element from the list."
                + "\n 3. Print the Linked List."
                + "\n 4. Ends the program.\n \n"
        );
        
        int choice = Integer.parseInt(input);
       
        switch (choice){
            case 1:   
                    break;
            case 2:
                    String in = JOptionPane.showInputDialog("\n Enter a number to delete from the list");
                    double num = Double.parseDouble(in);
                    boolean blank = list.remove();
                    if (blank == true){
                        output += " " + num + " is deleted.";
                    } else 
                        output += " " + num + " is not in the list." ;
                    JOptionPane.showMessageDialog(null, output);
                    break;
            case 3:
                    list.printList();
                    break;
            case 4: 
                    output += "\n End of program";
                    JOptionPane.showMessageDialog(null, output);
                    System.exit(0);
            default:
                    output += "\n Invalid selection.";
                    JOptionPane.showMessageDialog(null, output);
        }
        }
       // System.out.println("\n The sum of the Linked List elements are " + 
       // list.sum());
    }
    
    
    
}