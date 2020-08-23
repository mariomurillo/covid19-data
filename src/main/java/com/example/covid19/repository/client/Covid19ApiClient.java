package com.example.covid19.repository.client;

import com.example.covid19.repository.model.CovidData;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "covid19Client", url = "${covid19.http.client.url}")
public interface Covid19ApiClient {

  @RequestMapping(value = "/country/{country}", method = RequestMethod.GET, produces = "application/json")
  List<CovidData> getDataByCountry(
      @PathVariable(value = "country") String country,
      @RequestParam(value = "from") String from,
      @RequestParam(value = "to") String to);
}
