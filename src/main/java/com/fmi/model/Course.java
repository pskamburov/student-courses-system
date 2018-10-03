
package com.fmi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Course {

  private String id;
  private String name;

  private int enrolledStudentsCounter;
  private int maxStudents;

  private List<Student> enrolledStudents;

  public Course(String name, int maxStudents) {
    this(UUID.randomUUID().toString(), name, maxStudents, 0, new ArrayList<>());
  }

  private Course(String id, String name, int maxStudents, int enrolledStudentsCounter, List<Student> enrolledStudents) {
    this.id = id;
    this.name = name;
    this.maxStudents = maxStudents;
    this.enrolledStudentsCounter = enrolledStudentsCounter;
    this.enrolledStudents = enrolledStudents;
  }

  public boolean hasAvailablePlaces() {
    return maxStudents > enrolledStudentsCounter;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getEnrolledStudentsCounter() {
    return enrolledStudentsCounter;
  }

  public void setEnrolledStudentsCounter(int enrolledStudentsCounter) {
    this.enrolledStudentsCounter = enrolledStudentsCounter;
  }

  public List<Student> getEnrolledStudents() {
    return enrolledStudents;
  }

  public void setEnrolledStudents(List<Student> enrolledStudents) {
    this.enrolledStudents = enrolledStudents;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getMaxStudents() {
    return maxStudents;
  }

  public void setMaxStudents(int maxStudents) {
    this.maxStudents = maxStudents;
  }

  public void enrollStudent(Student student) {
    student.enrollCourse(this);
    enrolledStudents.add(student);
    enrolledStudentsCounter++;
  }

}
