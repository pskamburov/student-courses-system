
package com.fmi.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

import com.fmi.model.Course;
import com.fmi.model.Student;
import com.fmi.service.CoursesService;
import com.fmi.service.StudentService;

@ManagedBean
public class ChartView implements Serializable {

  private static final long serialVersionUID = -249706414000365922L;

  private PieChartModel pieModel;

  private LineChartModel lineModel;

  @ManagedProperty("#{coursesService}")
  private CoursesService coursesService;

  @ManagedProperty("#{studentService}")
  private StudentService studentService;

  public LineChartModel getLineModel() {
    return lineModel;
  }

  public void setLineModel(LineChartModel lineModel) {
    this.lineModel = lineModel;
  }

  public StudentService getStudentService() {
    return studentService;
  }

  public void setStudentService(StudentService studentService) {
    this.studentService = studentService;
  }

  public CoursesService getCoursesService() {
    return coursesService;
  }

  public void setCoursesService(CoursesService coursesService) {
    this.coursesService = coursesService;
  }

  @PostConstruct
  public void init() {
    createPieModel();
    createLineModels();
  }

  public PieChartModel getPieModel() {
    return pieModel;
  }

  private void createPieModel() {
    pieModel = new PieChartModel();

    List<Course> courses = coursesService.getCourses();
    for (Course course : courses) {
      pieModel.set(course.getName(), course.getEnrolledStudentsCounter());

    }

    pieModel.setTitle("Избираеми дисциплини");
    pieModel.setLegendPosition("w");
    pieModel.setShowDataLabels(true);
  }

  private void createLineModels() {
    List<Student> students = studentService.getStudents();
    lineModel = initLinearModel(students);
    lineModel.setTitle("Отношение на успеха спрямо брой записани дисциплини");
    lineModel.setShowPointLabels(true);
    setAxesProperties(students);
  }

  private void setAxesProperties(List<Student> students) {
    Axis yAxis = lineModel.getAxis(AxisType.Y);
    yAxis.setLabel("Брой записани дисциплини");
    yAxis.setMin(-1);
    yAxis.setMax(6);
    yAxis.setTickCount(8);

    Axis xAxis = lineModel.getAxis(AxisType.X);
    xAxis.setMin(students.get(students.size() - 1).getGradePointsAverage());
    xAxis.setMax(students.get(0).getGradePointsAverage());
    xAxis.setTickCount(students.size());
    xAxis.setLabel("Среден успех на студента");
  }

  private LineChartModel initLinearModel(List<Student> students) {
    LineChartModel model = new LineChartModel();
    LineChartSeries series = new LineChartSeries();
    for (Student student : students) {
      series.set(student.getGradePointsAverage(), student.getCourses().size());
    }

    model.addSeries(series);
    model.setShowPointLabels(true);
    return model;
  }

}