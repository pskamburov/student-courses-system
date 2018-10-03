
package com.fmi.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.fmi.model.Course;
import com.fmi.model.Student;

@ManagedBean(name = "studentService")
@ApplicationScoped
public class StudentService implements Serializable {

  private static final long serialVersionUID = -8183547680372819072L;

  @ManagedProperty("#{coursesService}")
  private CoursesService coursesService;

  @ManagedProperty("#{specialtiesService}")
  private SpecialtyService specialtiesService;

  private static List<Course> courses;

  private static List<String> specialties;

  public static List<Student> students;

  @PostConstruct
  public void init() {
    courses = coursesService.getCourses();
    specialties = specialtiesService.getSpecialties();
    students = Arrays.asList(new Student("Гошо", getRandomGrade(), getRandomCourses(3), getRandomSpecialty()),
        new Student("Иван", getRandomGrade(), getRandomCourses(3), getRandomSpecialty()),
        new Student("Пешо", getRandomGrade(), getRandomCourses(4), getRandomSpecialty()),
        new Student("Мария", getRandomGrade(), getRandomCourses(5), getRandomSpecialty()),
        new Student("Гергана", getRandomGrade(), getRandomCourses(5), getRandomSpecialty()),
        new Student("Димитър", getRandomGrade(), getRandomCourses(3), getRandomSpecialty()),
        new Student("Никола", getRandomGrade(), getRandomCourses(3), getRandomSpecialty()),
        new Student("Кирил", getRandomGrade(), getRandomCourses(3), getRandomSpecialty()),
        new Student("Димо", getRandomGrade(), getRandomCourses(3), getRandomSpecialty()),
        new Student("Натали", getRandomGrade(), getRandomCourses(3), getRandomSpecialty()),
        new Student("Никол", getRandomGrade(), getRandomCourses(3), getRandomSpecialty()),
        new Student("Краси", getRandomGrade(), getRandomCourses(3), getRandomSpecialty()),
        new Student("Стефан", getRandomGrade(), getRandomCourses(3), getRandomSpecialty()),
        new Student("Дидо", getRandomGrade(), getRandomCourses(3), getRandomSpecialty()));
  }

  public StudentService() {

  }

  public List<Student> getStudents() {
    return students;
  }

  public void setStudents(List<Student> students) {
    StudentService.students = students;
  }

  public CoursesService getCoursesService() {
    return coursesService;
  }

  public void setCoursesService(CoursesService coursesService) {
    this.coursesService = coursesService;
  }

  public SpecialtyService getSpecialtiesService() {
    return specialtiesService;
  }

  public void setSpecialtiesService(SpecialtyService specialtiesService) {
    this.specialtiesService = specialtiesService;
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    StudentService.courses = courses;
  }

  public List<String> getSpecialties() {
    return specialties;
  }

  public void setSpecialties(List<String> specialties) {
    StudentService.specialties = specialties;
  }

  private String getRandomSpecialty() {
    return specialties.get(ThreadLocalRandom.current().nextInt(specialties.size()));
  }

  private List<Course> getRandomCourses(int numberOfCourses) {
    Set<Course> randomCourses = new HashSet<Course>();
    while (randomCourses.size() < numberOfCourses) {
      randomCourses.add(courses.get(ThreadLocalRandom.current().nextInt(courses.size())));
    }
    return new ArrayList<Course>(randomCourses);
  }

  private Double getRandomGrade() {
    return ThreadLocalRandom.current().nextDouble(3, 6);
  }

}
