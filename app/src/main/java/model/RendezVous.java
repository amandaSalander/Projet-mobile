package model;

import java.util.Date;

/**
 * Created by amanda on 14/04/17.
 */

public class RendezVous {

    private String RDVnom;
    private Date RDVdate;
    private Boolean RDVetat;

    public RendezVous(String RDVnom, Date RDVdate, Boolean RDVetat) {
        this.RDVnom = RDVnom;
        this.RDVdate = RDVdate;
        this.RDVetat = RDVetat;
    }

    public String getRDVnom() {
        return RDVnom;
    }

    public void setRDVnom(String RDVnom) {
        this.RDVnom = RDVnom;
    }

    public Date getRDVdate() {
        return RDVdate;
    }

    public void setRDVdate(Date RDVdate) {
        this.RDVdate = RDVdate;
    }

    public Boolean getRDVetat() {
        return RDVetat;
    }

    public void setRDVetat(Boolean RDVetat) {
        this.RDVetat = RDVetat;
    }
}
