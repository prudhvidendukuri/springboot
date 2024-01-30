package com.springboot.spring;

import com.springboot.spring.dao.StudentDAO;
import com.springboot.spring.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(
		scanBasePackages = {"com.springboot.spring","outsidepackagescan"}
)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandlinerunner(StudentDAO studentDao){
		return runner -> {
			System.out.println("---START---");
			System.out.println("saving in DB");
			//to save data
//			this.createStudent(studentDao);
//			createMultipleStudents(studentDao);
			System.out.println("find in DB");
			//to find data
//			Student student = studentDao.findById(1);
//			System.out.println(student.toString());

			System.out.println("find all DB");
			//to find all students
//			List<Student> students = studentDao.findAll();
//			for(Student student:students){
//				System.out.println(student.toString());
//			}

			System.out.println("find using like");
//			List<Student> students1 = studentDao.findByLike("raju");
//			for(Student student:students1){
//				System.out.println(student.toString());
//			}
			System.out.println("find using where");
//			List<Student> students2 = studentDao.findByWhere();
//			for(Student student:students2){
//				System.out.println(student.toString());
//			}
			System.out.println("find using order by");
//			List<Student> students3 = studentDao.findOrderBy();
//			for(Student student:students3){
//				System.out.println(student.toString());
//			}

//			System.out.println("Update the Student -");
//			Student student4 = studentDao.findById(1);
//			student4.setEmail("ddsprraju@gmail.com");
//			studentDao.updateStudent(student4);
//			System.out.println("NEW UPDATED STUDENT - ");
//			Student student5 = studentDao.findById(1);
//			System.out.println(student5.toString());


			System.out.println("delete using query");
//			studentDao.deleteStudent(7);

			System.out.println("---DELETED---");

		};
	}
	public void createStudent(StudentDAO studentDAO){
		System.out.println("creating a student object");
		Student student = new Student("krishna","teja","krishnateja@gmail.com");
		System.out.println("saving the student using JPA");
		studentDAO.save(student);
		System.out.println("ID of the user"+ student.getId());

	}
	public void createMultipleStudents(StudentDAO studentDao){
		System.out.println("creating multiple student object");
		Student student = new Student("kalyani","varma","kalyanivarma@gmail.com");
		Student student2 = new Student("mounika","varma","mounikavarma@gmail.com");

		studentDao.save(student);
		studentDao.save(student2);

		System.out.println("saving completed");

	}
}
