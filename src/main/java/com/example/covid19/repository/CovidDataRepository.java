package com.example.covid19.repository;

import com.example.covid19.repository.model.CovidData;
import java.time.LocalDate;

public interface CovidDataRepository {

  CovidData getCovidData(LocalDate currentDate, String country);
}
