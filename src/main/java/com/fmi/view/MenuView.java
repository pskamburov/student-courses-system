
package com.fmi.view;


import static com.fmi.view.LanguageView.addMessage;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.menu.MenuModel;

import com.fmi.model.Course;
import com.fmi.service.CoursesService;
import com.fmi.service.EvaluationService;


@ManagedBean(name = "menuView")
@ViewScoped
public class MenuView implements Serializable {

  private static final long serialVersionUID = 2969574076389375333L;

  private MenuModel model;

  @ManagedProperty("#{evaluationService}")
  private EvaluationService evaluationService;

  @ManagedProperty("#{coursesService}")
  private CoursesService service;

  private List<Course> courses;

  @PostConstruct
  public void init() {
    courses = service.getCourses();
  }

  public MenuModel getModel() {
    return model;
  }

  public void evaluate() {
    evaluationService.evaluateCourseWishes();
    addMessage("Студентите са класирани");
  }

  public EvaluationService getEvaluationService() {
    return evaluationService;
  }

  public void setEvaluationService(EvaluationService evaluationService) {
    this.evaluationService = evaluationService;
  }

  public CoursesService getService() {
    return service;
  }

  public void setService(CoursesService service) {
    this.service = service;
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

  public void setModel(MenuModel model) {
    this.model = model;
  }

}