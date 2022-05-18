package lv.venta.demo.services;

import java.util.ArrayList;

import lv.venta.demo.model.Grade;

public interface IFilteringGradeService {
	//Atrast kāda konkrēta studenta visas atzīmes 
    public abstract ArrayList<Grade> filterStudentGrades(int id);
  //Atrast visas atzīmes konkrētā kursā 
    public abstract ArrayList<Grade> filterGradesByCourse(int id);
  //Atrast visas konkrēta studenta atzīmes pēc viņa vārda 
    public abstract ArrayList<Grade> filterGradesByStudentName(String name);
	//Atrast visas nesekmīgās atzīmes un šo atzīmju studentus 
    public abstract ArrayList<Grade> filterNonPassingGradesAndStudents();
  //Atrast vidējo atzīmi konkrētā kursā 
    public abstract float calcAverageOfCourse(int id);
  //Atrast vidējo atzīmi konkrētam studentam
    public abstract float calcAverageOfStudent(int id);
}