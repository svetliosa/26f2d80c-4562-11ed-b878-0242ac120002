package com.example.Covid19.Resource;

import com.example.Covid19.Dto.CountryStatisticsDto;
import com.example.Covid19.Service.CovidStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("CovidStatisticsResource")
@RequestMapping("/country/{COUNTRYCODE}")
public class CovidStatisticsResource {
    private final CovidStatisticsService covidStatisticsService;

    @Autowired
    public CovidStatisticsResource(CovidStatisticsService covidStatisticsService) {
        this.covidStatisticsService = covidStatisticsService;
    }

    @GetMapping
    public List<CountryStatisticsDto> getCovidStatistics(
            @PathVariable("COUNTRYCODE") String countryCode
    ) {
        return covidStatisticsService.getcovidStatistics(countryCode);
    }
}
