package lu_dokuments.model;


import net.bytebuddy.utility.RandomString;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Component
public class JPQL {
    @PersistenceContext
    EntityManager em;

    public void select_all_students() {
        Query query = em.createQuery("select s from Students s");
        List<Students> listOfStudents = query.getResultList();

        for (Students s : listOfStudents) {
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

    public void select_all_courses() {
        Query query = em.createQuery("select c from Course c");
        List<Course> listOfCourses = query.getResultList();

        for (Course s : listOfCourses) {
            System.out.println(s.getCid()
                    + " "
                    + s.getSemester()
                    + " "
                    + s.getTitle()
            );
        }
    }


    public void innerJoinStudentAndCourse() {
        String iStart = new SimpleDateFormat("HH.mm.ss").format(new Date(System.currentTimeMillis()));
        System.out.println(iStart);
        System.out.println("students and course join start");
        Query query = em.createQuery("SELECT s FROM Students s JOIN Course c");
        List<Students> innerJoinStudentAndCourse = query.getResultList();
        for (Students s : innerJoinStudentAndCourse) {
            for (Course c : s.getCourse()) {
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

        System.out.println("students and course join end");
        String sstart = "stated at" + iStart;
        String iEnd = new SimpleDateFormat("HH.mm.ss").format(new Date(System.currentTimeMillis()));
        System.out.println(sstart);
        System.out.println(iEnd);
    }

    public void fetchInnerJoinStudentAndCourse() {
        String fstart = new SimpleDateFormat("HH.mm.ss").format(new Date(System.currentTimeMillis()));
        System.out.println(fstart);
        System.out.println("students and course join start");
        Query query = em.createQuery("SELECT s FROM Students s JOIN FETCH Course c");
        List<Students> innerJoinStudentAndCourse = query.getResultList();
        for (Students s : innerJoinStudentAndCourse) {
            for (Course c : s.getCourse()) {
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

        System.out.println("students and course join with FETCH end");
        String fend = new SimpleDateFormat("HH.mm.ss").format(new Date(System.currentTimeMillis()));
        String fsstart = "stated at" + fstart;
        System.out.println(fsstart);

        System.out.println(fend);
    }


    @Transactional
    public void generate_course() {
        System.out.println("start generate course");
        for (int i = 0; i < 100; i++) {
            String symbols = "abcdefghijklmnopqrstuvwxyzQWERTYUIOPASDFGHJKLZXCVBNM";
            String courseName = new Random().ints(6, 0, symbols.length())
                    .mapToObj(symbols::charAt)
                    .map(Object::toString)
                    .collect(Collectors.joining());

            int min = 1;
            int max = 10;
            int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

            max = 99;
            int title = ThreadLocalRandom.current().nextInt(min, max + 1);
            String courseTitle= "courseTitle:" + courseName + title;
            Course course = new Course();
            course.setTitle(courseTitle);
            course.setSemester(randomNum);
            em.persist(course);

        }        System.out.println("end generate course");

    }

    @Transactional
    public void generate_studentu_data() {
        System.out.println("start user generation");
        LocalDateTime dateTime = LocalDateTime.now();

        for (int i = 0; i < 1000; i++) {
            String symbols = "abcdefghijklmnopqrstuvwxyzQWERTYUIOPASDFGHJKLZXCVBNM";
            String randomtext = new Random().ints(11, 0, symbols.length())
                    .mapToObj(symbols::charAt)
                    .map(Object::toString)
                    .collect(Collectors.joining());

            int min = 0;
            int max = 4;
            int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
            int randomNum2 = ThreadLocalRandom.current().nextInt(min, max + 1);
            min = 24;
            max = 1000;
            int rating = ThreadLocalRandom.current().nextInt(min, max + 1);


            String generatedEmail = randomNum + randomtext + randomNum2 + "@" + "gmail.com";
            String generatedStudApl = randomtext + randomNum2 + randomNum;
            min = 1;
            max = 100;
            int courseId = ThreadLocalRandom.current().nextInt(min, max + 1);

            String courseIds = "SELECT c FROM Course c where c.cid = " + courseId;

            Query query = em.createQuery(courseIds);
            Set<Course> courseIdSet = new HashSet<>(query.getResultList());

            String lname = "lname:"+ randomtext;
            String fname = "fname:"+ randomtext;
            Students students = new Students();
            students.setLastName(lname);
            students.setFirstName(fname);
            students.setEmail(generatedEmail);
            students.setStudAplNr(generatedStudApl);
            students.setRating(rating);
            students.setCourse(courseIdSet);
            em.persist(students);

        }
        //maybe
        em.clear();
        em.close();
        LocalDateTime dateTime2 = LocalDateTime.now();
        int diffInNano = java.time.Duration.between(dateTime, dateTime2).getNano();
        long diffInSeconds = java.time.Duration.between(dateTime, dateTime2).getSeconds();
        long diffInMilli = java.time.Duration.between(dateTime, dateTime2).toMillis();
        System.out.printf("\nDifference is  %d Seconds, %d Milli, and %d Nano\n\n",  diffInSeconds, diffInMilli, diffInNano );
//        String end = new SimpleDateFormat("HH.mm.ss").format(new Date(System.currentTimeMillis()));

            System.out.println("end user generation");


    }

}
