package lu_dokuments;

import lu_dokuments.model.JPQL;
import lu_dokuments.model.Students;
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

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		String daw = new SimpleDateFormat("HH.mm.ss").format(new Date(System.currentTimeMillis()));
//		jpql.generate_course();
		jpql.generate_studentu_data();
//		jpql.select_all_students();
//		jpql.select_all_courses();
//		jpql.innerJoinStudentAndCourse();
//		jpql.fetchInnerJoinStudentAndCourse();
	}
}
