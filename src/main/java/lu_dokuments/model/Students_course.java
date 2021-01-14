package lu_dokuments.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_course")
public class Students_course {

    @Id
    @Column(name = "student_fk")
    private int student_fk;
    @Column(name = "course_fk")
    private int course_fk;
}
