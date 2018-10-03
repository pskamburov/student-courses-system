
package com.fmi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Student {

  private String id;
  private String name;
  private String specialty;
  private double gradePointsAverage;

  /**
   * The actually enrolled courses.
   */
  private List<Course> courses;

  private List<Course> courseWishes;

  public Student(String name, double scoring, List<Course> majors, String university) {
    this(UUID.randomUUID().toString(), name, scoring, majors, university);
  }

  public Student(String id, String name, double averageGrades, List<Course> courseWishes, String specialty) {
    this.id = id;
    this.name = name;
    this.gradePointsAverage = averageGrades;
    this.courseWishes = courseWishes;
    this.specialty = specialty;
    this.courses = new ArrayList<Course>();
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getGradePointsAverage() {
    return gradePointsAverage;
  }

  public void setGradePointsAverage(double gradePointsAverage) {
    this.gradePointsAverage = gradePointsAverage;
  }

  public List<Course> getWishedCourses() {
    return courseWishes;
  }

  public void setWishedCourses(List<Course> courses) {
    this.courseWishes = courses;
  }

  public String getSpecialty() {
    return specialty;
  }

  public void setSpecialty(String specialty) {
    this.specialty = specialty;
  }

  public void enrollCourse(Course course) {
    courses.add(course);
  }

}
