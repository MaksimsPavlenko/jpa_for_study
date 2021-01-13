package lu_dokuments.model;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @Column(name = "cid")
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int cid;

    @Column(name = "title")
    private String title;

    @Column(name = "semester")
    private int semester;

    @ManyToMany(mappedBy = "courseList", fetch = FetchType.EAGER)
    private List<Students> studentsList;


    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

//    public int getLector_fk() {
//        return lector_fk;
//    }
//
//    public void setLector_fk(int lector_fk) {
//        this.lector_fk = lector_fk;
//    }
//fk
//    @Column(name = "lector")
//    private int lector_fk;

    //???
//    @OneToMany
//    @JoinColumn(name = "stud_fk", referencedColumnName = "sid")
//    private List<Students> students;
}
