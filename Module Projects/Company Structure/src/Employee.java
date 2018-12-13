public abstract class Employee {

    private static int employeeCount = 1;
    private int employeeID;
    private String name;
    public double baseSalary;
    public Employee manager;


    //Should construct a new employee object and take in two parameters, one for the name of the user and one for their base salary
    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.employeeID = employeeCount;
        employeeCount++;
    }

    //Should return the employee's current salary
    public double getBaseSalary() {
        return this.baseSalary;
    }

    //Should return the employee's current name
    public String getName() {
        return this.name;
    }

    //Should return the employee's ID. The ID should be issued on behalf of the employee at the time they are constructed. The first ever employee should have an ID of "1", the second "2" and so on
    public int getEmployeeID() {
        return employeeID;
    }

    //Should return a reference to the Employee object that represents this employee's manager
    //public Employee getManager(){}

    //Should return true if the two employee IDs are the same, false otherwise
    public boolean equals(Employee other) {
        if (this.employeeID == other.employeeID) {
            return true;
        } else {
            return false;
        }
    }

    //Should return a String representation of the employee that is a combination of their id followed by their name. Example: "1 Kasey"
    public String toString() {return employeeID + " " + name;}

    //Should return a String representation of that Employee's current status. This will be different for every subclass of Employee
    public abstract String employeeStatus();
}










