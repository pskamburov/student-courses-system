
package com.fmi.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.fmi.model.Course;
import com.fmi.service.CoursesService;

@ManagedBean(name = "coursesView")
@ViewScoped
public class CoursesView {

  private List<Course> courses;

  @ManagedProperty("#{coursesService}")
  private CoursesService coursesService;

  @PostConstruct
  public void init() {
    courses = coursesService.getCourses();
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

  public CoursesService getCoursesService() {
    return coursesService;
  }

  public void setCoursesService(CoursesService service) {
    this.coursesService = service;
  }

}
