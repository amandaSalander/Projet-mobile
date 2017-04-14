package model;

import android.graphics.drawable.ColorDrawable;

import java.util.Calendar;

/**
 * Created by amanda on 14/04/17.
 */

public class RendezVous {

    private ColorDrawable RDVcouleur;
    private String RDVnom;
    private Calendar RDVdate;
    private Boolean RDVetat;

    public RendezVous(String RDVnom, Calendar RDVdate, Boolean RDVetat, ColorDrawable RDVcouleur) {
        this.RDVnom = RDVnom;
        this.RDVdate = RDVdate;
        this.RDVetat = RDVetat;
        this.RDVcouleur= RDVcouleur;
    }

    public String getRDVnom() {
        return RDVnom;
    }

    public void setRDVnom(String RDVnom) {
        this.RDVnom = RDVnom;
    }

    public Calendar getRDVdate() {
        return RDVdate;
    }

    public void setRDVdate(Calendar RDVdate) {
        this.RDVdate = RDVdate;
    }

    public Boolean getRDVetat() {
        return RDVetat;
    }

    public void setRDVetat(Boolean RDVetat) {
        this.RDVetat = RDVetat;
    }

    public ColorDrawable getRDVcouleur() {
        return RDVcouleur;
    }

    public void setRDVcouleur(ColorDrawable RDVcouleur) {
        this.RDVcouleur = RDVcouleur;
    }
}
