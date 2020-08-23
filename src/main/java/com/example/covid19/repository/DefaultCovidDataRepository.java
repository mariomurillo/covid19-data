package com.example.covid19.repository;

import com.example.covid19.repository.client.Covid19ApiClient;
import com.example.covid19.repository.model.CovidData;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultCovidDataRepository implements CovidDataRepository {

  public final Covid19ApiClient client;

  public DefaultCovidDataRepository(Covid19ApiClient client) {
    this.client = client;
  }

  @Override
  public CovidData getCovidData(LocalDate currentDate, String country) {
    var from = currentDate.atStartOfDay(); // LocalDateTime: yesterday with hour 00:00:00
    var to = LocalDate.now().atStartOfDay(); // LocalDateTime: today with hour 00:00:00
    var fromString = from.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    var toString = to.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

    return client.getDataByCountry(
        country, fromString, toString)
        .stream()
        .findFirst()
        .orElseThrow();
  }
}
