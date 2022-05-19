package lv.venta.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.demo.model.Grade;
import lv.venta.demo.repo.ICourseRepo;
import lv.venta.demo.repo.IGradeRepo;
import lv.venta.demo.repo.IStudentRepo;
import lv.venta.demo.services.IFilteringGradeService;

@Service
public abstract class FilteringGradeServiceImpl implements IFilteringGradeService{

	@Autowired
	private IGradeRepo gradeRepo;
	
	@Autowired
	private IStudentRepo studRepo;

	@Autowired
	private ICourseRepo courseRepo;
	
	@Override
	public ArrayList<Grade> filterStudentGrades(int id) throws Exception
	{
		if(studRepo.existsById(id)) {
			ArrayList<Grade> result = gradeRepo.findByStudentIdSt(id);
			return result;
		} else throw new Exception("Nav atbilstoss id");
	}

	@Override
	public ArrayList<Grade> filterGradesByCourse(int id) throws Exception
	{
		if(courseRepo.existsById(id)) {
			ArrayList<Grade> result = gradeRepo.findByCourseIdCo(id);
			return result;
		} else throw new Exception("Nav atbilstoss id");
	}

	@Override
	public ArrayList<Grade> filterGradesByStudentNameStudentSurname(String name, String surname) throws Exception {
		if(studRepo.existsByNameAndSurname(name, surname)) {
			ArrayList<Grade> result = gradeRepo.findByStudentNameAndStudentSurname(name, surname);
			return result;
		} else throw new Exception("Students ar tadu vardu un uzvardu neeksiste");
	}

	@Override
	public ArrayList<Grade> filterNonPassingGradesAndStudents() {
		return gradeRepo.findByValueLessThan(4);
	}

	@Override
	public float calcAverageOfCourse(int id) throws Exception 
	{
		if(courseRepo.existsById(id)){
			return gradeRepo.calculateAVGByCourseId(id);
		} else throw new Exception("Nav atbilstoss id");
	}

	@Override
	public float calcAverageOfStudent(int id) throws Exception {
		if(studRepo.existsById(id)){
			return gradeRepo.calculateAVGByCourseId(id);
		} else throw new Exception("Nav atbilstoss id");
	}

	@Override
	public ArrayList<Grade> filterNonPassingGradesByCourseId(int id) throws Exception 
	{
		if(courseRepo.existsById(id)) {
			return gradeRepo.findByCourseIdCoAndValueLessThan(id, 4);
		} else throw new Exception("Nav atbilstoss id");
	}
}