
package com.fmi.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.fmi.model.Course;
import com.fmi.model.Student;

@ManagedBean(name = "evaluationService")
@ApplicationScoped
public class EvaluationService {

  private static boolean isEvaluated;

  private static List<Student> students;

  @ManagedProperty("#{studentService}")
  private StudentService studentService;

  @PostConstruct
  public void init() {
    students = studentService.getStudents();
  }

  public static boolean isEvaluated() {
    return isEvaluated;
  }

  public static void setIsEvaluated(boolean isEvaluated) {
    EvaluationService.isEvaluated = isEvaluated;
  }

  public static List<Student> getStudents() {
    return students;
  }

  public static void setStudents(List<Student> students) {
    EvaluationService.students = students;
  }

  public StudentService getStudentService() {
    return studentService;
  }

  public void setStudentService(StudentService studentService) {
    this.studentService = studentService;
  }

  public void evaluateCourseWishes() {
    if (!isEvaluated()) {
      students.sort((s1, s2) -> Double.compare(s2.getGradePointsAverage(), s1.getGradePointsAverage()));
      for (Student student : students) {
        enrollInAvilableCourses(student);
      }
      setIsEvaluated(true);
    }
  }

  private void enrollInAvilableCourses(Student student) {
    List<Course> desiredAvailableCourses = student.getWishedCourses().stream().filter(Course::hasAvailablePlaces).collect(Collectors.toList());
    for (Course course : desiredAvailableCourses) {
      course.enrollStudent(student);
    }
  }

}
