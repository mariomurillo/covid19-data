package com.example.covid19.service;

import com.example.covid19.repository.CovidDataRepository;
import com.example.covid19.service.model.CovidData;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service("colombiaService")
public class ColombiaCovidService implements CovidService {

  private static final String COUNTRY = "colombia";
  private final CovidDataRepository repository;

  public ColombiaCovidService(CovidDataRepository repository) {
    this.repository = repository;
  }

  @Override
  public CovidData getCovidDataByCurrentDay() {
    var customDate = LocalDate.now().minusDays(BigDecimal.ONE.intValue()); // yesterday
    var covidData = repository.getCovidData(customDate, COUNTRY)
        .toCovidData();

    if (customDate.equals(covidData.getDate())) {
      return covidData;
    } else {
      throw new NullPointerException("Data not found");
    }
  }
}
