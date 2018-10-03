
package com.fmi.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.fmi.model.Student;
import com.fmi.service.StudentService;

@ManagedBean(name = "StudentView")
@ViewScoped
public class StudentView implements Serializable {

  private static final long serialVersionUID = -2469303302221816199L;

  private List<Student> students;

  @ManagedProperty("#{studentService}")
  private StudentService service;

  @PostConstruct
  public void init() {
    students = service.getStudents();
  }

  public List<Student> getStudents() {
    return students;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }

  public StudentService getService() {
    return service;
  }

  public void setService(StudentService service) {
    this.service = service;
  }

}
