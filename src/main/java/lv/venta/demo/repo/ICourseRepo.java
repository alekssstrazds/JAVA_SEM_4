package lv.venta.demo.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.model.Course;

public interface ICourseRepo extends CrudRepository <Course, Integer> {

}
