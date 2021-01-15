package lu_dokuments.model;

import javax.persistence.*;

@Entity
@Table(name = "assinged_task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "assignment_id")
    private int assignmentID;

    @Column(name = "description")
    private String taskDescription;

    @Column(name = "lector_fk")
    private int lectorTaskFk;

    public int getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(int assignmentID) {
        this.assignmentID = assignmentID;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public int getLectorTaskFk() {
        return lectorTaskFk;
    }

    public void setLectorTaskFk(int lectorTaskFk) {
        this.lectorTaskFk = lectorTaskFk;
    }
}
