package lv.venta.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.model.Grade;

public interface IGradeRepo extends CrudRepository <Grade, Integer> {

	public abstract ArrayList<Grade> findByStudentIdSt(int id);

	public abstract ArrayList<Grade> findByCourseIdCo(int id);

}