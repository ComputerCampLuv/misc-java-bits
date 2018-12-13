public abstract class BusinessEmployee extends Employee {

    public double bonusBudget;

    //Has a default salary of 50000
    public BusinessEmployee(String name) {super(name, 50000);}

    //Should establish a running tally of the remaining bonusBudget for the team this employee supports. How that budget is determined will depend on which type of Business Employee it is
    public double getBonusBudget() { return this.bonusBudget;}

    //Should return a String representation of this BusinessEmployee that includes their ID, name and the size of their currently managed budget. Example: "1 Kasey with a budget of 22500.0"
    public String employeeStatus() {return this.toString() + " with a budget of " + this.bonusBudget;}
}