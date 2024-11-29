package util;

import application.Employee;

/*
 * File name : LinkedList.java
 * Author : Evan Lunney
 * Student number : C23473822
 * Description of class : Linked list to function alongside driver class
 */

public class LinkedList<T> implements LinkedListADT<T> {

    private int count; // the current number of elements in the list
    private LinearNode<T> front; // pointer to the first element
    private LinearNode<T> last; // pointer to the last element

    // -----------------------------------------------------------------
    // Creates an empty list.
    // -----------------------------------------------------------------
    public LinkedList() {
        this.count = 0;
        this.last = null;
        this.front = null;
    }

    // -----------------------------------------------------------------
    // Adds one element to the end of this list
    // -----------------------------------------------------------------
    public void add(T element) {
        LinearNode<T> node = new LinearNode<T>(element);

        if (size() == 0) {
            this.last = node; // This is the last and the
            this.front = node; // first node
            this.count++;
        } else {
            last.setNext(node); // Add node to the end of the list
            last = node; // Now make this the new last node
            this.count++;
        }
    }

    // -----------------------------------------------------------------
    // Removes and returns the first element from this list
    // -----------------------------------------------------------------
    public T remove() {
        LinearNode<T> temp = null;
        T result = null;
        if (isEmpty()) {
            System.out.println("There are no nodes in the list");
        } else {
            result = this.front.getElement();
            temp = this.front;
            this.front = this.front.getNext();
            temp.setNext(null); // Dereference the original first element
            count--;
        }
        return result;
    }

    // -----------------------------------------------------------------
    // Removes an employee based on their employee number
    // -----------------------------------------------------------------
    
    /**public T remove(T element) {
    	LinearNode<T> current = this.front;
    	LinearNode<T> previous = null;
    	T removeElement = null;
    	
    	if(element == null || current == null || count == 0) {
    		throw new IllegalStateException();
    	}
    	while (current != null) {
    		if(current.getElement().equals(element)) {
    			removeElement = current.getElement();
    			System.out.println("element to be removed" + removeElement.toString());
    			if(previous == null) {
    				this.front = front.getNext();
    			} else {
    				previous.setNext(current.getNext());
    			}
    			count--;
    			break;
    		}
    		previous = current;
    		current = current.getNext();
    		System.out.println("" + current.getElement().toString());
    		System.out.println("" + previous.getElement().toString());
    	}
    	return removeElement;
    			} */
    		
    	
    
    public boolean removeEmployeeByNumber(int employeeNumber) {
        if (isEmpty()) return false;

        LinearNode<T> current = front;
        LinearNode<T> previous = null;

        while (current != null) {
            Employee employee = (Employee) current.getElement();
            if (employee.getEmployeeNumber() == employeeNumber) {
                if (previous == null) { // Removing the first node
                    front = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }

                if (current == last) { // Removing the last node
                    last = previous;
                }

                count--;
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    } 

    // -----------------------------------------------------------------
    // Removes all employees from a specified course
    // -----------------------------------------------------------------
    public boolean removeEmployeesFromCourse(String courseName) {
        boolean courseFound = false;

        if (isEmpty()) {
            return false; // No employees to check
        }

        LinearNode<T> current = front;
        LinearNode<T> previous = null;

        while (current != null) {
            Employee employee = (Employee) current.getElement();
            if (employee.getCourseName().equalsIgnoreCase(courseName)) {
                courseFound = true;

                // Remove the employee from the list
                if (previous == null) { // Removing the first node
                    front = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }

                if (current == last) { // Removing the last node
                    last = previous;
                }

                count--;
            } else {
                previous = current; // Move previous pointer forward
            }

            current = current.getNext();
        }

        return courseFound;
    }

    // -----------------------------------------------------------------
    // Finds and displays employees with a specified minimum years of experience
    // -----------------------------------------------------------------
    public void findEmployeesByYears(int minYears) {
        if (isEmpty()) {
            System.out.println("No employees in the list.");
            return;
        }

        LinearNode<T> current = front;
        boolean found = false;

        while (current != null) {
            Employee employee = (Employee) current.getElement();
            if (employee.getYearsWorking() >= minYears) {
                System.out.println(employee);
                found = true;
            }
            current = current.getNext();
        }

        if (!found) {
            System.out.println("No employees found with " + minYears + " or more years of experience.");
        }
    }

    // -----------------------------------------------------------------
    // Displays all elements in the list
    // -----------------------------------------------------------------
    public void displayAll() {
        if (isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }

        LinearNode<T> current = front;
        while (current != null) {
            System.out.println(current.getElement());
            current = current.getNext();
        }
    }

    // -----------------------------------------------------------------
    // Returns true if this list contains no elements
    // -----------------------------------------------------------------
    public boolean isEmpty() {
        return this.front == null;
    }

    // -----------------------------------------------------------------
    // Returns the number of elements in this list
    // -----------------------------------------------------------------
    public int size() {
        return this.count;
    }

    // -----------------------------------------------------------------
    // Returns a string representation of this list
    // -----------------------------------------------------------------
    public String toString() {
        LinearNode<T> current = front;
        StringBuilder fullList = new StringBuilder();

        while (current != null) {
            fullList.append(current.getElement().toString()).append("\n");
            current = current.getNext();
        }

        return fullList.toString();
    }

}
