package com.example.covid19.repository.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonNaming(value = PropertyNamingStrategy.UpperCamelCaseStrategy.class)
public class CovidData {

  private Integer confirmed;
  private Integer deaths;
  private Integer recovered;
  private Integer active;
  private String date;

  public Integer getConfirmed() {
    return confirmed;
  }

  public void setConfirmed(Integer confirmed) {
    this.confirmed = confirmed;
  }

  public Integer getDeaths() {
    return deaths;
  }

  public void setDeaths(Integer deaths) {
    this.deaths = deaths;
  }

  public Integer getRecovered() {
    return recovered;
  }

  public void setRecovered(Integer recovered) {
    this.recovered = recovered;
  }

  public Integer getActive() {
    return active;
  }

  public void setActive(Integer active) {
    this.active = active;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public com.example.covid19.service.model.CovidData toCovidData() {
    return new com.example.covid19.service.model.CovidData(
        this.confirmed,
        this.deaths,
        this.recovered,
        this.active,
        LocalDateTime.parse(
            this.date.substring(
                BigDecimal.ZERO.intValue(),
                this.date.length()-1))
            .toLocalDate());
  }
}
