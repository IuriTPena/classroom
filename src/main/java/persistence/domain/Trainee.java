package persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long traineeId;
    private String traineeName;
    @Column(name = "classId")
    private long classId;

    public Trainee() {
    }

    public Trainee(String traineeName) {
        this.traineeName = traineeName;
    }

    public long getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(long traineeId) {
        this.traineeId = traineeId;
    }

    public String getTraineeName() {
        return traineeName;
    }

    public void setTraineeName(String traineeName) {
        this.traineeName = traineeName;
    }

    public long getClassID() {
        return classId;
    }

    public void setClassID(long classID) {
        this.classId = classId;
    }
}
