package com.example.Covid19.Service;

import com.example.Covid19.Dto.CountryStatisticsDto;
import com.example.Covid19.Entity.CovidStatistics;
import com.example.Covid19.Repository.CovidStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service("CovidStatisticsService")
public class CovidStatisticsService {
    private final CovidStatisticsRepository covidStatisticsRepository;

    @Autowired
    public CovidStatisticsService(CovidStatisticsRepository covidStatisticsRepository) {
        this.covidStatisticsRepository = covidStatisticsRepository;
    }

    public List<CountryStatisticsDto> getcovidStatistics(String countryCode) {
        return covidStatisticsRepository.findAllByCountryCode(countryCode)
            .stream()
            .map(this::mapToCovidStatisticsDto)
            .collect(Collectors.toList());
    }

    public List<CountryStatisticsDto> getAll() {
        return covidStatisticsRepository.findAll()
            .stream()
            .map(this::mapToCovidStatisticsDto)
            .sorted(filterStatisticByCountryAlpahabetic())
            .collect(Collectors.toList());
    }

    private Comparator<CountryStatisticsDto> filterStatisticByCountryAlpahabetic() {
        return Comparator.comparing(CountryStatisticsDto::getCountry, Comparator.nullsLast(Comparator.naturalOrder()));
    }

    private CountryStatisticsDto mapToCovidStatisticsDto(CovidStatistics covidStatistics) {
        return new CountryStatisticsDto()
            .setId(covidStatistics.getId())
            .setCountry(covidStatistics.getCountry())
            .setCountryCode(covidStatistics.getCountryCode())
            .setSlug(covidStatistics.getSlug())
            .setNewConfirmed(covidStatistics.getNewConfirmed())
            .setTotalConfirmed(covidStatistics.getTotalConfirmed())
            .setNewDeaths(covidStatistics.getNewDeaths())
            .setTotalDeaths(covidStatistics.getTotalDeaths())
            .setNewRecovered(covidStatistics.getNewRecovored())
            .setTotalRecovered(covidStatistics.getTotalRecovored())
            .setDate(covidStatistics.getDate());
    }
}
