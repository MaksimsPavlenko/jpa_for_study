package lu_dokuments.data_generation;

import lu_dokuments.model.Course;
import lu_dokuments.model.Students;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Component
public class TestDataGeneration {

    @PersistenceContext
    EntityManager em;


    String symbols = "abcdefghijklmnopqrstuvwxyzQWERTYUIOPASDFGHJKLZXCVBNM";

    @Transactional
    public void generate_studentu_data() {
        System.out.println("Started student generation");
        LocalDateTime dateTime = LocalDateTime.now();

        for (int i = 0; i < 300; i++) {
            String randomtext = new Random().ints(11, 0, symbols.length())
                    .mapToObj(symbols::charAt)
                    .map(Object::toString)
                    .collect(Collectors.joining());

            //Generate numbers for student card and email
            int min = 0;
            int max = 4;
            int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
            int randomNum2 = ThreadLocalRandom.current().nextInt(min, max + 1);

            String generatedEmail = randomNum + randomtext + randomNum2 + "@" + "gmail.com";
            String generatedStudApl = randomtext + randomNum2 + randomNum;

            //Generate student raiting
            min = 24;
            max = 1000;
            int rating = ThreadLocalRandom.current().nextInt(min, max + 1);

            //Course id (we aspect only 100)
            min = 1;
            max = 100;
            int courseId = ThreadLocalRandom.current().nextInt(min, max + 1);

            //Create Set of courses
            Course course = new Course();
            course.setCid(courseId);
            Set<Course> courseIdSet =  new HashSet<>();
            courseIdSet.add(course);

            //Add student to db
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
            System.out.println(courseIdSet);
        }
        System.out.println("Student generation completed");
        //Transaction info
        LocalDateTime dateTime2 = LocalDateTime.now();
        int diffInNano = java.time.Duration.between(dateTime, dateTime2).getNano();
        long diffInSeconds = java.time.Duration.between(dateTime, dateTime2).getSeconds();
        long diffInMilli = java.time.Duration.between(dateTime, dateTime2).toMillis();
        System.out.println("Started at:" + dateTime);
        System.out.println("Finish at: " + dateTime2);
        System.out.printf("\nDifference is  %d Seconds, %d Milli, and %d Nano\n\n",  diffInSeconds, diffInMilli, diffInNano );

    }


    @Transactional
    public void generate_course() {
        System.out.println("Start course generation");

        for (int i = 0; i < 100; i++) {
            String courseName = new Random().ints(6, 0, symbols.length())
                    .mapToObj(symbols::charAt)
                    .map(Object::toString)
                    .collect(Collectors.joining());

        //Create semestr
            int min = 1;
            int max = 10;
            int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

        //Create title
            max = 99;
            int title = ThreadLocalRandom.current().nextInt(min, max + 1);
            String courseTitle= "courseTitle:" + courseName + title;

        //Set course in db
            Course course = new Course();
            course.setTitle(courseTitle);
            course.setSemester(randomNum);
            em.persist(course);

        }
            System.out.println("Course generation completed!");

    }






}
