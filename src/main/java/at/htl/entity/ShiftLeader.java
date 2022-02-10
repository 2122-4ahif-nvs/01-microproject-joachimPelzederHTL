package at.htl.entity;

import javax.persistence.Entity;

@Entity
public class ShiftLeader extends Employee {

    int extraSal;

    public ShiftLeader() {
    }

    public ShiftLeader(String firstName, String lastName, int salary, int extraSal) {
        super(firstName, lastName, salary);
        this.extraSal = extraSal;
    }

    public int getExtraSal() {
        return extraSal;
    }

    public void setExtraSal(int extraSal) {
        this.extraSal = extraSal;
    }
}
