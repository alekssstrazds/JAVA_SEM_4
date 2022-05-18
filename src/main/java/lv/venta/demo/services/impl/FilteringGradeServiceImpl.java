package lv.venta.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.demo.model.Grade;
import lv.venta.demo.repo.IGradeRepo;
import lv.venta.demo.services.IFilteringGradeService;

@Service
public class FilteringGradeServiceImpl implements IFilteringGradeService{

	@Autowired
	private IGradeRepo gradeRepo;
	
	@Override
	public ArrayList<Grade> filterStudentGrades(int id) {
		ArrayList<Grade> result = gradeRepo.findByStudentIdSt(id);
		return result;
	}

	@Override
	public ArrayList<Grade> filterGradesByCourse(int id) {
		ArrayList<Grade> result = gradeRepo.findByCourseIdCo(id);
		return result;
	}

	@Override
	public ArrayList<Grade> filterGradesByStudentName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Grade> filterNonPassingGradesAndStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float calcAverageOfCourse(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float calcAverageOfStudent(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
}