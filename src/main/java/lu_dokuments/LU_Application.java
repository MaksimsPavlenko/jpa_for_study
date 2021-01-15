package lu_dokuments;

import lu_dokuments.data_generation.TestDataGeneration;
import lu_dokuments.model.JPQL;
import lu_dokuments.model.Students;
import lu_dokuments.select.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class LU_Application implements CommandLineRunner {

	public static void main(String[] args) {
		System.out.println("pikapika");
		SpringApplication.run(LU_Application.class, args);

	}
	@PersistenceContext
	EntityManager em;
	@Autowired
	JPQL jpql;

	@Autowired
	TestDataGeneration generate;

	@Autowired
	Select select;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
//		generate.generate_studentu_data();
//		generate.generate_course();
//		generate.generate_lector();
//		generate.generate_parking();
		generate.generate_assigned_task();

//		select.select_all_courses();
//		select.select_all_students();

//		select.selectTopStudent();
//		select.selectLowestRatingStudent();
//		select.selectStudentAverageRating();
//		select.selectStudentWithRating(344);
//		select.selectStudentByCourseByFirstCharacter();

//		select.innerJoinStudentAndCourse();
//		select.fetchInnerJoinStudentAndCourse();

	}
}
