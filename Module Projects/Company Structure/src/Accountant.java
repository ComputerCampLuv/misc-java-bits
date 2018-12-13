public class Accountant extends BusinessEmployee {

    public TechnicalLead techLead;

    //Should start with a bonus budget of 0 and no team they are officially supporting
    public Accountant(String name){super(name);}

    //Should return a reference to the TechnicalLead that this Accountant is currently supporting. If they have not
    // been assigned a TechnicalLead null should be returned
    public TechnicalLead getTeamSupported() {return techLead;}

    //Should allow a reference to a TechnicalLead to be passed in and saved. Once this happens the Accountant's bonus
    // budget should be updated to be the total of each SoftwareEngineer's base salary that reports to that TechnicalLead
    // plus 10%. For example, if the TechnicalLead supports 2 SoftwareEngineers, each with a salary of 75000, the
    // Accountant's budget should be 150000 + 15000 for a total of 165000
    public void supportTeam(TechnicalLead lead) {

        if (this.getTeamSupported() == null) {
            System.out.println("Accountant is already supporting a Technical Team");
        } else {
            techLead = lead;
            techLead.accountant = this;
            this.bonusBudget = 0;

            for (int i = 0; i < lead.subordinates.size(); i++) {
                this.bonusBudget += lead.subordinates.get(i).baseSalary;
            }
            this.bonusBudget *= 1.1;
        }
    }

    //Should take in a suggested bonus amount and check if there is still enough room in the budget. If the bonus is
    // greater than the remaining budget, false should be returned, otherwise true. If the accountant is not supporting
    // any team false should be returned.
    public boolean approveBonus(double bonus) {

        if (this.getTeamSupported() != null && this.bonusBudget >= bonus) {
            return true;
        } else return false;
    }

    //Should return a String representation of this Accountant that includes their ID, name, the size of their currently
    // managed budget and the name of the TechnicalLead they are currently supporting. Example: "1 Kasey with a budget
    // of 22500.0 is supporting Satya Nadella"
    public String employeeStatus() {
        return this.toString() + " with a budget of " + bonusBudget + " is supporting " + techLead;
    }
}
