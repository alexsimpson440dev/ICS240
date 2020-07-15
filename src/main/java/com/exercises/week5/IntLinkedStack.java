package com.exercises.week5;

import java.util.EmptyStackException;
/**
 * Invariant of the IntLinkedStack class:
 * 1. The items in the stack are stored in a linked list, with the top of
 * the stack stored at the head node, down to the bottom of the stack
 * at the final node.
 * 2. The instance variable top is the head reference of the linked list of items.
 * 
 * @author Thanaa Ghanem
 *
 */

public class IntLinkedStack implements IntStackInterface
{
   
	private IntNode top; 

   /**
   * Initialize an empty stack. 
   **/   
   public IntLinkedStack( ){
      top = null;
   }

   
     
   /**
   * Determine whether this stack is empty.
   * @return true if this stack is empty and false otherwise. 
   **/
   public boolean isEmpty( ){
      return (top == null);
   }
   

   /**
   * @return the top item of the stack without removing it
   * @exception EmptyStackException Indicates that this stack is empty.
   **/   
   public int peek( )   {
      if (top == null)
         // EmptyStackException is from java.util and its constructor has no argument.
         throw new EmptyStackException( );
      return top.getData( );
   }

   
   /**
   * Get the top item, removing it from this stack.
   * @return The return value is the top item of this stack, and the item is removed.
   * @exception EmptyStackException Indicates that this stack is empty.
   **/    
   public int pop( ) {
      int answer;
      
      if (this.top == null)
         // EmptyStackException is from java.util and its constructor has no argument.
         throw new EmptyStackException( );
      
      answer = this.top.getData( );
      this.top = this.top.getLink( );
      return answer;
   }    


   /**
   * Push a new item onto this stack. 
   * @param item - the item to be pushed onto this stack 
   **/    
   public void push(int item){
      this.top = new IntNode(item, this.top);
   }
              

   /**
   * Accessor method to determine the number of items in this stack.
   * @return the number of items in this stack
   **/ 
   public int size( ) {
      return IntNode.listLength(this.top);
   }
   
   /** convert the stack to a printable string
    * @return	a string representing the stack
    */
   	public String toString() {
   		String output = "[ ";
   		IntNode cursor = top;
   	
   		while (cursor != null){
   			output += cursor.getData()+",";
   			cursor = cursor.getLink();
   		}

   		output = output.substring(0, output.length()-1);
   		output  += " ] \n";
   		return output;
   }

   public void empty() {
   	    while (!this.isEmpty()) {
   	        this.pop();
        }
   }

   public int middleItem() {
   	    if(this.isEmpty()) {
   	        return -1;
        } else {
   	        int count = this.size();
            int total = 0;
            IntNode cursor = this.top;

   	        if (count%2 == 0) {
   	            int middle1 = count/2;
   	            int middle2 = (count/2)+1;

   	            for(int i = 1; i <= middle2; i++) {
   	                if(i == middle1 || i == middle2) {
   	                    total += cursor.getData();
                    }
   	                cursor = cursor.getLink();
                }

   	            return total/2;
            } else {
                int middle = (count/2)+1; // integer division rounds down, but we want to round up.

                for(int i = 1; i <= middle; i++) {
                    if(i == middle) {
                        total += cursor.getData();
                    }
                    cursor = cursor.getLink();
                }

                return total;
            }
        }
   }

   public static IntLinkedStack reverse(IntLinkedStack stack) {
   	    IntLinkedStack reversedStack = new IntLinkedStack();
   	    while (!stack.isEmpty()) {
   	        reversedStack.push(stack.pop());
        }

   	    return reversedStack;
   }
}
