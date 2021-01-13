package lu_dokuments.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "students")
public class Students {


    @Id
    @Column(name = "sid")
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int sid;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "stud_apl_nr")
    private String studAplNr;

    @Column(name = "email")
    private String email;

    @Column(name = "rating")
    private int rating;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_fk"),
            inverseJoinColumns = @JoinColumn(name = "course_fk"))
    private Set<Course> courseList;



    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudAplNr() {
        return studAplNr;
    }

    public void setStudAplNr(String studAplNr) {
        this.studAplNr = studAplNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Set<Course> getCourse() {
        return courseList;
    }

    public void setCourse(Set<Course> course) {
        this.courseList = course;
    }
//PREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREV
//    @Id
//    @Column(name = "stud_id")
//    private int  studID;
//
//    @Column(name = "uzvards")
//    private String uzvards;
//
//    @Column(name = "vards")
//    private String vards;
//
//
////    @ManyToOne
////    @JoinColumn(referencedColumnName = "kursa_id")
////    private Kursi kurss;
//
//
//
//
//
//    @ManyToMany
//    @JoinColumn(referencedColumnName = "kursa_id")
//    private Set<Kursi> kursuSaraksts;
//
//
//
//
//
//
////    @OneToOne(cascade = CascadeType.ALL)
////    @JoinColumn(name = "kartes_id_fk", referencedColumnName = "kartes_id")
////    private StudentuKarte studentuKarte;
//
//
//
//    public int getStudID() {
//        return studID;
//    }
//
//    public void setStudID(int studID) {
//        this.studID = studID;
//    }
//
//    public String getUzvards() {
//        return uzvards;
//    }
//
//    public void setUzvards(String uzvards) {
//        this.uzvards = uzvards;
//    }
//
//    public String getVards() {
//        return vards;
//    }
//
//    public void setVards(String vards) {
//        this.vards = vards;
//    }
//
////    public StudentuKarte getStudentuKarte() {
////        return studentuKarte;
////    }
////
////    public void setStudentuKarte(StudentuKarte studentuKarte) {
////        this.studentuKarte = studentuKarte;
////    }
    //PREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREVPREV
}
