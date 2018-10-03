
package com.fmi.service;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.fmi.model.Course;

@ManagedBean(name = "coursesService")
@ApplicationScoped
public class CoursesService {

  private static List<Course> courses;

  public CoursesService() {
    courses = Arrays.asList(new Course("Apache Spark", 3), new Course("Cloud Startup", 2), new Course("Практическо програмиране с Perl", 1),
        new Course("Програмиране с Python", 3), new Course("Интернет технологии и уеб програмиране", 2),
        new Course("Системи с паралелна обработка", 2), new Course(" Мрежово програмиране на Java", 1),
        new Course("Линукс системно и мрежово администриране", 30));
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    CoursesService.courses = courses;
  }

}
