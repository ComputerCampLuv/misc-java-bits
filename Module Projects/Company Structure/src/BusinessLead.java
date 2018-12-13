import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee {

    private int headcount;
    private ArrayList<Accountant> subordinates = new ArrayList<>();

    //Should create a new BusinessLead that is a Manager. The BusinessLead's base salary should be twice that of an
    // Accountant. They should start with a head count of 10.
    public BusinessLead(String name) {super(name); this.baseSalary *= 2; this.headcount = 10;}

    //Should return true if the number of direct reports this manager has is less than their headcount.
    public boolean hasHeadCount() {
        if (this.subordinates.size() < this.headcount) {
            return true;
        } else {
            return false;
        }
    }

    //Should accept the reference to an Accountant object, and if the BusinessLead has head count left should add this
    // employee to their list of direct reports. If the employee is successfully added to the BusinessLead's direct reports
    // true should be returned, false should be returned otherwise. Each time a report is added the BusinessLead's bonus
    // budget should be increased by 1.1 times that new employee's base salary. That employee's team they are supporting
    // should be updated to reflect the reference to the TechnicalLead given. If the employee is successfully added true
    // should be returned, false otherwise.
    public boolean addReport(Accountant e, TechnicalLead supportTeam) {

        if (hasHeadCount() && e.getTeamSupported() != null) {
            e.supportTeam(supportTeam);
            this.subordinates.add(e);
            this.bonusBudget += e.baseSalary*1.1;
            return true;
        } else return false;
    }

    //Should check if the bonus amount requested would fit in current BusinessLead's budget. If it is, that employee
    // should get that bonus, the BusinessLeader's budget should be deducted and true should be returned. False should
    // be returned otherwise
    public boolean requestBonus(Employee e, double bonus) {
        if (this.bonusBudget >= bonus) {
            e.baseSalary += bonus;
            this.bonusBudget -= bonus;
            return true;
        } else return false;
    }

    //This function should look through the Accountants the BusinessLead manages, and if any of them are supporting a the
    // TechnicalLead that is the manager of the Employee passed in then the Accountant's budget should be consulted to see
    // if the bonus could be afforded. If the team can afford the bonus it should be rewarded and true returned, false otherwise
    public boolean approveBonus(Employee e, double bonus) {

        for (int i = 0; i < this.subordinates.size(); i++) {
            if (this.subordinates.get(i).techLead.equals(e.manager)) {
                if (this.subordinates.get(i).approveBonus(bonus)) {
                    this.subordinates.get(i).bonusBudget -= bonus;
                    e.baseSalary += bonus;
                    return true;
                }
            }
        } return false;
    }
}