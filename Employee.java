package application;

/*
 * File name : Employee.java
 * Author : Evan Lunney
 * Student number : C23473822
 * Description of class : sub class to be inherited by driver class
 */

public class Employee {
	
    private int employeeNumber;
    private String name;
    private int yearsWorking;
    private String courseName;
    private boolean valid;

    public Employee(int employeeNumber, String name, int yearsWorking, String courseName) {
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.valid = true; 

        if (yearsWorking <= 5) {
            System.out.println("Error: Must have more than 5 years experience to be enrolled in course.");
            this.valid = false;
        } else {
            this.yearsWorking = yearsWorking;
        }

        if (!courseName.startsWith("FOOD")) {
            System.out.println("Error: Must start with 'FOOD'.");
            this.courseName = "ERROR";
            this.valid = false;
        } else {
            this.courseName = courseName;
        }
    }

    // Getters
    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getName() {
        return name;
    }

    public int getYearsWorking() {
        return yearsWorking;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setYearsWorking(int yearsWorking) {
		this.yearsWorking = yearsWorking;
	}
    public boolean isValid() {
        return valid;
    }

    public String toString() {
        return "Employee Number: " + employeeNumber +
               ", Name: " + name +
               ", Years: " + yearsWorking +
               ", Course: " + courseName;
    }
}
