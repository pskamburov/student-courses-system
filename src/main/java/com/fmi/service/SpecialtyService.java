
package com.fmi.service;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "specialtiesService")
@ApplicationScoped
public class SpecialtyService {

  private static List<String> specialties;

  public SpecialtyService() {
    specialties = Arrays.asList("Компютърни науки", "Софтуерно инженерство", "Информатика", "Изкуствен интелект", "Извличане на информация",
        "Електронен бизнес");
  }

  public List<String> getSpecialties() {
    return specialties;
  }

  public void setSpecialties(List<String> specialties) {
    SpecialtyService.specialties = specialties;
  }

}
