package lv.venta.demo.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.model.Grade;

public interface IGradeRepo extends CrudRepository <Grade, Integer> {

	public abstract ArrayList<Grade> findByStudentIdSt(int id);

	public abstract ArrayList<Grade> findByCourseIdCo(int id);

	public abstract ArrayList<Grade> findByStudentNameAndStudentSurname(String name, String surname);

    public abstract ArrayList<Grade> findByValueLessThan(int i);

	public abstract ArrayList<Grade> findByCourseIdCoAndValueLessThan(int id, int i);

	//ja ir @Query tad nav noziiimes funckijas nosaukumam!!!
	@Query(value="SELECT AVG(VALUE) FROM GRADE WHERE  ID_CO=?1", nativeQuery = true)
	public abstract float calculateAVGByCourseId(int id);

	@Query(value="SELECT AVG(VALUE) FROM GRADE WHERE  ID_CO=?1", nativeQuery = true)
	public abstract float calculateAVGByStudentId(int id);
}