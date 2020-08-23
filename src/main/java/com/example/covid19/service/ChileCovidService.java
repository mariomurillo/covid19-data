package com.example.covid19.service;

import com.example.covid19.repository.CovidDataRepository;
import com.example.covid19.service.model.CovidData;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service("chileService")
public class ChileCovidService implements CovidService {

  private static final String COUNTRY = "chile";
  private final CovidDataRepository repository;

  public ChileCovidService(CovidDataRepository repository) {
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
