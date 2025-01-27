//Abstract Data Type definition for a Linked List

//Note that this is not a full definition as we are only implementing some
//of the standard functions associated with a list.
 
package util;
/*
* File name : LinkedListADT.java
* Author : Evan Lunney
* Student number : C23473822
*/

public interface LinkedListADT <T>
	{
	   //  Adds one element to the start or end of this list
	   public void add (T element);

	   //  Removes and returns the first element from this list
	   public T remove();
  
	   //  Returns true if this list contains no elements
	   public boolean isEmpty();

	   //  Returns the number of elements in this list
	   public int size();

	   //  Returns a string representation of this list
	   public String toString();
	

}
