package com.example.covid19.controller;

import com.example.covid19.controller.model.CovidDataResponse;
import com.example.covid19.service.CovidService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CovidController {

  public final CovidService colombiaService;
  public final CovidService chileService;

  public CovidController(
      @Qualifier("colombiaService")
      CovidService colombiaService,
      @Qualifier("chileService")
      CovidService chileService) {
    this.colombiaService = colombiaService;
    this.chileService = chileService;
  }

  @GetMapping("/data-colombia")
  public CovidDataResponse getCovidDataColombia() {
    return colombiaService.getCovidDataByCurrentDay()
        .toCovidDataResponse();
  }

  @GetMapping("/data-chile")
  public CovidDataResponse getCovidDataChile() {
    return chileService.getCovidDataByCurrentDay()
        .toCovidDataResponse();
  }
}
