package lu_dokuments.select;

import lu_dokuments.model.Course;
import lu_dokuments.model.Students;
import lu_dokuments.statistic.Statistic_functions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;
import org.w3c.dom.ls.LSOutput;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Component
public class Select {
    @PersistenceContext
    EntityManager em;
    @Autowired
    Statistic_functions statistic;

///////////////Select all students /////////////////////////////////////////////////////////////////////////////////////
    public void select_all_students() {
        System.out.println("select_all_students started");
        LocalDateTime date1 =  LocalDateTime.now();
        List<Students> query = em.createQuery("select s from Students s").getResultList();
        for (Students s : query) {
            System.out.println(s.getSid()
                    + " "
                    + s.getFirstName()
                    + " "
                    + s.getLastName()
                    + " "
                    + s.getStudAplNr()
                    + " "
                    + s.getEmail()
                    + " "
            );
        }
        LocalDateTime date2 =  LocalDateTime.now();
        System.out.println("select_all_students completed");
        statistic.timeStatistic(date1,date2);
    }

///////////////Select all courses //////////////////////////////////////////////////////////////////////////////////////
    public void select_all_courses() {
        System.out.println("select_all_courses started");
        LocalDateTime date1 =  LocalDateTime.now();
        List<Course> query =  em.createQuery("select c from Course c").getResultList();
//        for (Course s : query) {
//            System.out.println(s.getCid()
//                    + " "
//                    + s.getSemester()
//                    + " "
//                    + s.getTitle()
//            );
//        }
        LocalDateTime date2 =  LocalDateTime.now();
        System.out.println("select_all_courses completed");
        statistic.timeStatistic(date1,date2);
    }

///////////////Select student with set rating //////////////////////////////////////////////////////////////////////////
    public void selectStudentWithRating(int param){
        System.out.println("selectStudentWithRating started");
        LocalDateTime date1 =  LocalDateTime.now();
        long studentsWithRating = (long) em.createQuery("SELECT COUNT(s) FROM Students s WHERE s.rating = " + param).getSingleResult();
        LocalDateTime date2 =  LocalDateTime.now();
        System.out.println("selectStudentWithRating completed");
        statistic.timeStatistic(date1,date2);
//        System.out.println("students with rating " + param + " count: " + studentsWithRating);
    }

///////////////Select student with top rating //////////////////////////////////////////////////////////////////////////
    public void selectTopStudent(){
        System.out.println("selectTopStudent started");
        LocalDateTime date1 =  LocalDateTime.now();
        int maxStudentsRating = (int) em.createQuery("SELECT MAX(s.rating) FROM Students s").getSingleResult();
        LocalDateTime date2 =  LocalDateTime.now();
        System.out.println("selectTopStudent completed");
        statistic.timeStatistic(date1,date2);
//        System.out.println(maxStudentsRating);

    }

///////////////Select student with lowest rating ///////////////////////////////////////////////////////////////////////
    public void selectLowestRatingStudent(){
        System.out.println("selectLowestRatingStudent started");
        LocalDateTime date1 =  LocalDateTime.now();
        int minStudentsRating = (int) em.createQuery("SELECT MIN(s.rating) FROM Students s").getSingleResult();
        LocalDateTime date2 =  LocalDateTime.now();
        System.out.println("selectLowestRatingStudent completed");
        statistic.timeStatistic(date1,date2);
//        System.out.println(minStudentsRating);

    }

///////////////Select students average  rating /////////////////////////////////////////////////////////////////////////
    public void selectStudentAverageRating(){
        System.out.println("selectStudentAverageRating started");
        LocalDateTime date1 =  LocalDateTime.now();
        double avgStudentsRating = (double) em.createQuery("SELECT AVG(s.rating) FROM Students s").getSingleResult();
        LocalDateTime date2 =  LocalDateTime.now();
        System.out.println("selectStudentAverageRating completed");
        statistic.timeStatistic(date1,date2);
//        System.out.println(avgStudentsRating);
    }

///////////////Select students by first course character////////////////////////////////////////////////////////////////
    public void selectStudentByCourseByFirstCharacter(){
        System.out.println("selectStudentByCourseByFirstCharacter started");
        LocalDateTime date1 =  LocalDateTime.now();
        long studentWithCourseStartedWithCharacter = (long) em.createQuery("SELECT DISTINCT COUNT(s) FROM Students s JOIN s.courseList c WHERE c.title LIKE 'courseTitle:A%' ").getSingleResult();
        LocalDateTime date2 =  LocalDateTime.now();
        System.out.println("selectStudentByCourseByFirstCharacter completed");
        statistic.timeStatistic(date1,date2);
        //        System.out.println("Course with character A "  + "student count: " + studentWithCourseStartedWithCharacter);
    }

//////////////JOIN SELECT //////////////////////////////////////////////////////////////////////////////////////////////
    public void fetchInnerJoinStudentAndCourse() {
        System.out.println("fetchInnerJoinStudentAndCourse started");
        LocalDateTime date1 =  LocalDateTime.now();
        Query query = em.createQuery("SELECT s FROM Students s JOIN FETCH Course c");
//        for (Object ss : query.getResultList()) {
//            Students s = (Students) ss;
//            for (Course c : s.getCourse()) {
//                System.out.println(c.getCid()
//                        + " "
//                        + c.getSemester()
//                        + " "
//                        + c.getTitle()
//                        + " "
//                        + s.getFirstName()
//                        + " "
//                        + s.getLastName()
//                        + " "
//                        + s.getRating()
//                        + " "
//                        + s.getStudAplNr()
//                );
//            }
//        }
        LocalDateTime date2 =  LocalDateTime.now();
        System.out.println("fetchInnerJoinStudentAndCourse completed");
        statistic.timeStatistic(date1,date2);
    }

    public void innerJoinStudentAndCourse() {
        System.out.println("innerJoinStudentAndCourse started");
        LocalDateTime date1 = LocalDateTime.now();
        Query query = em.createQuery("SELECT s FROM Students s, Students_course sc JOIN Course  c where c.cid = sc.course_fk and s.sid = sc.student_fk");
        for (Object ss : query.getResultList()) {
            Students s = (Students) ss;
            for (Course c : s.getCourse()) {
                if(c == null){
                        System.out.println("course pusta");
                    }
                if(s == null){
                        System.out.println("students pusta");
                    }else{
                        System.out.println(s);
                        System.out.println(c.getCid()
                                + " "
                                + c.getSemester()
                                + " "
                                + c.getTitle()
                                + " "
                                + s.getFirstName()
                                + " "
                                + s.getLastName()
                                + " "
                                + s.getRating()
                                + " "
                                + s.getStudAplNr()
                        );
                    }
            }
        }
        LocalDateTime date2 =  LocalDateTime.now();
        System.out.println("Students and course join completed");
        statistic.timeStatistic(date1,date2);
    }

}
