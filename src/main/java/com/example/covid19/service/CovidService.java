package com.example.covid19.service;

import com.example.covid19.service.model.CovidData;

public interface CovidService {

  CovidData getCovidDataByCurrentDay();
}
