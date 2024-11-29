package application;

import util.*;
import java.util.Scanner;

/*
 * File name : TrainingCourses.java
 * Author : Evan Lunney
 * Student number : C23473822
 * Description of class : Driver class that displays program
 */

public class TrainingCourses {
    public static void main(String[] args) {
        LinkedList<Employee> employees = new LinkedList<>();
        Scanner scan = new Scanner(System.in);

        // User defined number of employees
        System.out.print("Enter number of employees (up to 10): ");
        int numEmployees = scan.nextInt();
        scan.nextLine(); 

        if (numEmployees < 1 || numEmployees > 10) {
            System.out.println("Error: Number of employees must be between 1 and 10.");
            return;
        }

        for (int i = 1; i <= numEmployees; i++) {
            boolean valid = false;
            while (!valid) {
                System.out.println("\nEnter details for employee " + i + ":");
                System.out.print("Employee Number: ");
                int empNumber = scan.nextInt();
                scan.nextLine(); 
                System.out.print("Name: ");
                String name = scan.nextLine();
                System.out.print("Years Working: ");
                int yearsWorking = scan.nextInt();
                scan.nextLine(); 
                System.out.print("Course Name: ");
                String courseName = scan.nextLine();

                Employee newEmployee = new Employee(empNumber, name, yearsWorking, courseName);
                if (newEmployee.isValid()) {
                    employees.add(newEmployee);
                    valid = true;
                } else {
                    System.out.println("Invalid employee details. Please re-submit.");
                }
            }
        }

        // 2. Display employee details
        System.out.println("\nAll employees:");
        employees.displayAll();

        // 3. Remove an employee by number
        boolean employeeRemoved = false;
        while (!employeeRemoved) {
            System.out.print("\nEnter employee number to remove: ");
            int empNumToRemove = scan.nextInt();
            scan.nextLine(); 

            employeeRemoved = employees.removeEmployeeByNumber(empNumToRemove);

            if (!employeeRemoved) {
                System.out.println("Employee not found. Please re-submit a valid employee number.");
            } else {
                System.out.println("Employee removed.");
            }
        }

        // 4. Display remaining employee details
        System.out.println("\nRemaining employees:");
        employees.displayAll();

        // 5. Clear all employees from a course
        boolean courseFound = false;
        while (!courseFound) {
            System.out.print("\nEnter course name to remove employees from: ");
            String courseToRemove = scan.nextLine();

            courseFound = employees.removeEmployeesFromCourse(courseToRemove);

            if (!courseFound) {
                System.out.println("Error: Course code not found. Please re-submit a valid course name.");
            } else {
                System.out.println("Employees removed from the course successfully.");
            }
        }

        // 6. Display the remaining employees after clearing a course
        System.out.println("\nEmployees remaining after clearing course:");
        employees.displayAll();

        // 7. Find employees by years of experience
        System.out.print("\nEnter minimum years of experience to filter employees: ");
        int minYears = scan.nextInt();
        scan.nextLine(); 
        System.out.println("Employees with " + minYears + " or more years of experience:");
        employees.findEmployeesByYears(minYears);

        System.out.println("\n\nProgram terminating");
    }
}
