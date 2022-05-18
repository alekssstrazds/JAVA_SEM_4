package lv.venta.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.demo.model.Course;
import lv.venta.demo.model.Grade;
import lv.venta.demo.model.ProfDegree;
import lv.venta.demo.model.Professor;
import lv.venta.demo.model.Student;
import lv.venta.demo.repo.ICourseRepo;
import lv.venta.demo.repo.IGradeRepo;
import lv.venta.demo.repo.IProfessorRepo;
import lv.venta.demo.repo.IStudentRepo;

@SpringBootApplication
public class JavaSem4Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaSem4Application.class, args);
	}
	
	
	@Bean //visur, kur šī annotācija, tiks izsukts automātiski
	public CommandLineRunner testdb(IProfessorRepo profRepo,
			IStudentRepo studRepo, ICourseRepo courRepo,
			IGradeRepo grRepo)
	{
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				Professor pr1 = new Professor("Prof", "Pirmais", ProfDegree.bachelor);
		        Professor pr2 = new Professor("Prof", "Otrais", ProfDegree.master);
		        Professor pr3 = new Professor("Prof", "Tresais", ProfDegree.doctor);
		        profRepo.save(pr1);
		        profRepo.save(pr2);
		        profRepo.save(pr3);

		        Student st1 = new Student("Student", "Pirmais");
		        Student st2 = new Student("Student", "Otrais");
		        Student st3 = new Student("Student", "Tresais");
		        studRepo.save(st1);
		        studRepo.save(st2);
		        studRepo.save(st3);

		        Course co1 = new Course("Java", 2, Arrays.asList(pr1, pr2));
		        Course co2 = new Course("Data str", 4, Arrays.asList(pr2));
		        Course co3 = new Course("Matematika", 1, Arrays.asList(pr1, pr2, pr3));
		        courRepo.save(co1);
		        courRepo.save(co2);
		        courRepo.save(co3);
		        pr1.addNewCourse(co1);
		        pr1.addNewCourse(co3);
		        profRepo.save(pr1);
		        
		        pr2.addNewCourse(co1);
		        pr2.addNewCourse(co2);
		        pr2.addNewCourse(co3);
		        profRepo.save(pr2);
		        
		        pr3.addNewCourse(co3);
		        profRepo.save(pr3);
		        

		      
		        Grade gr3 = new Grade(3, st3, co1);//3 Tresais Kurss
		        Grade gr4 = new Grade(2, st1, co2);
		        Grade gr5 = new Grade(1, st2, co2);
		        grRepo.save(new Grade(5, st1, co1));
		        grRepo.save(new Grade(4, st2, co1));
		        grRepo.save(gr3);
		        grRepo.save(gr4);
		        grRepo.save(gr5);
				
				//TODO - pāŗējos objektus 
				
				
			}
		};
	}
}