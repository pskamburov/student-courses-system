
package com.fmi.view;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "languageView")
@SessionScoped
public class LanguageView implements Serializable {

  private static final long serialVersionUID = 8521564288240011891L;

  private String localeCode = "bg";

  public String getLocaleCode() {
    return localeCode;
  }

  public void setLocaleCode(String localeCode) {
    this.localeCode = localeCode;
  }

  public void changeToBg(ActionEvent actionEvent) {
    localeCode = "bg";
    FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(localeCode, "BG"));
    addMessage("Changed to BG");
  }

  public void changeToEn(ActionEvent actionEvent) {
    localeCode = "en";
    FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
    addMessage("Changed to EN");
  }

  public static void addMessage(String summary) {
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
    FacesContext.getCurrentInstance().addMessage(null, message);
  }

}
