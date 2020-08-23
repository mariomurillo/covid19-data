package com.example.covid19.controller.model;

public class CovidDataResponse {

  private final Integer confirmed;
  private final Integer deaths;
  private final Integer recovered;
  private final Integer active;

  public CovidDataResponse(Integer confirmed, Integer deaths, Integer recovered,
      Integer active) {
    this.confirmed = confirmed;
    this.deaths = deaths;
    this.recovered = recovered;
    this.active = active;
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
}
