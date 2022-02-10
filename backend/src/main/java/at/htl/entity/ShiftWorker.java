package at.htl.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ShiftWorker extends Employee{

    @ManyToOne(cascade = CascadeType.ALL)
    private Workstation workstation;

    public ShiftWorker() {
    }

    public ShiftWorker(String firstName, String lastName, int salary, Workstation workstation) {
        super(firstName, lastName, salary);
        this.workstation = workstation;
    }

    public Workstation getWorkstation() {
        return workstation;
    }

    public void setWorkstation(Workstation workstation) {
        this.workstation = workstation;
    }
}
