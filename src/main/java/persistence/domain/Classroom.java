package persistence.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "classroomId")
    private long classroomId;
    private String trainer;
    @JoinColumn(name = "classId", referencedColumnName = "classroomId")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Trainee> trainees;

    public Classroom() {
        super();
    }

    public Classroom(String trainer, List<Trainee> trainees) {
        this.trainer = trainer;
        this.trainees = trainees;
    }

    public long getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(long classroomId) {
        this.classroomId = classroomId;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(List<Trainee> trainees) {
        this.trainees = trainees;
    }
}
