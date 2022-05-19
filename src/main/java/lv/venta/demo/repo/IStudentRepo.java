package lv.venta.demo.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.model.Student;

public interface IStudentRepo extends CrudRepository<Student, Integer> {

    boolean existsByNameAndSurname(String name, String surname);

}