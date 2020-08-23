package com.example.covid19.service.model;

import com.example.covid19.controller.model.CovidDataResponse;
import java.time.LocalDate;

public class CovidData {

  private final Integer confirmed;
  private final Integer deaths;
  private final Integer recovered;
  private final Integer active;
  private final LocalDate date;

  public CovidData(Integer confirmed, Integer deaths, Integer recovered, Integer active,
      LocalDate date) {
    this.confirmed = confirmed;
    this.deaths = deaths;
    this.recovered = recovered;
    this.active = active;
    this.date = date;
  }

  public Integer getConfirmed() {
    return confirmed;
  }

  public Integer getDeaths() {
    return deaths;
  }

  public Integer getRecovered() {
    return recovered;
  }

  public Integer getActive() {
    return active;
  }

  public LocalDate getDate() {
    return date;
  }

  public CovidDataResponse toCovidDataResponse() {
    return new CovidDataResponse(this.confirmed, this.deaths, this.recovered, this.active);
  }
}
