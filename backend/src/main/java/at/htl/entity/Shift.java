package at.htl.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ShiftLeader leader;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private List<ShiftWorker> workers;

    @NotBlank(message = "Shift should have a name!")
    private String shiftName;
    @Max(message = "24 is the maximum!", value = 24)
    @Min(message = "There is no negative time", value = 0)
    private int beginn;
    @Max(message = "24 is the maximum!", value = 24)
    @Min(message = "There is no negative time", value = 0)
    private int end;

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
