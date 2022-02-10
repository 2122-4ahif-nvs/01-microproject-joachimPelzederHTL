package at.htl.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Shift {

    @Id
    Long id;
    @ManyToOne
    ShiftLeader leader;
    @OneToMany(cascade = CascadeType.ALL)
    List<ShiftWorker> workers;

    String shiftName;
    int beginn;
    int end;

    public Shift() {
    }

    public Shift(ShiftLeader leader, List<ShiftWorker> workers, int beginn, int end) {
        this.leader = leader;
        this.workers = workers;
        this.beginn = beginn;
        this.end = end;
    }

    public ShiftLeader getLeader() {
        return leader;
    }

    public void setLeader(ShiftLeader leader) {
        this.leader = leader;
    }

    public List<ShiftWorker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<ShiftWorker> workers) {
        this.workers = workers;
    }

    public int getBeginn() {
        return beginn;
    }

    public void setBeginn(int beginn) {
        this.beginn = beginn;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
