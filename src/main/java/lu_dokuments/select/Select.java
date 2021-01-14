package lu_dokuments.select;

import lu_dokuments.model.Course;
import lu_dokuments.model.Students;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;
import org.w3c.dom.ls.LSOutput;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class Select {
    @PersistenceContext
    EntityManager em;

///////////////Select all students //////////////////////////////////////////////////////////////////
    public void select_all_students() {
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
    }

///////////////Select all courses //////////////////////////////////////////////////////////////////
    public void select_all_courses() {
        List<Course> query =  em.createQuery("select c from Course c").getResultList();
        for (Course s : query) {
            System.out.println(s.getCid()
                    + " "
                    + s.getSemester()
                    + " "
                    + s.getTitle()
            );
        }
    }

///////////////Select student with set rating //////////////////////////////////////////////////////////////////
    public void selectStudentWithRating(int param){
        long studentsWithRating = (long) em.createQuery("SELECT COUNT(s) FROM Students s WHERE s.rating = " + param).getSingleResult();
        System.out.println("students with rating " + param + " count: " + studentsWithRating);
        System.out.println("selectStudentWithRating");

    }

///////////////Select student with top rating //////////////////////////////////////////////////////////////////
    public void selectTopStudent(){
        int maxStudentsRating = (int) em.createQuery("SELECT MAX(s.rating) FROM Students s").getSingleResult();
        System.out.println(maxStudentsRating);
        System.out.println("selectTopStudent");

    }

///////////////Select student with lowest rating //////////////////////////////////////////////////////////////////
    public void selectLowestRatingStudent(){
        int minStudentsRating = (int) em.createQuery("SELECT MIN(s.rating) FROM Students s").getSingleResult();
        System.out.println(minStudentsRating);
        System.out.println("selectLowestRatingStudent");

    }

///////////////Select students average  rating //////////////////////////////////////////////////////////////////
    public void selectStudentAverageRating(){
        double avgStudentsRating = (double) em.createQuery("SELECT AVG(s.rating) FROM Students s").getSingleResult();
        System.out.println(avgStudentsRating);
        System.out.println("selectStudentAverageRating");
    }

///////////////Select students by first course character//////////////////////////////////////////////////////////////////
    public void selectStudentByCourseByFirstCharacter(){
        long studentWithCourseStartedWithCharacter = (long) em.createQuery("SELECT COUNT(s) FROM Students s JOIN Course c WHERE c.title LIKE 'A%' ").getSingleResult();
        System.out.println("Course with character A "  + " count: " + studentWithCourseStartedWithCharacter);

    }



}
