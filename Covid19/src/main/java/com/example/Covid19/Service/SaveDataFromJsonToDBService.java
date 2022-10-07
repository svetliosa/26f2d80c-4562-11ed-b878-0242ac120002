package com.example.Covid19.Service;

import com.example.Covid19.Dto.CountryStatisticsDto;
import com.example.Covid19.Dto.GlobalStatisticsDto;
import com.example.Covid19.Entity.CovidStatistics;
import com.example.Covid19.Repository.CovidStatisticsRepository;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import org.springframework.stereotype.Service;
import java.io.File;

@Service
public class SaveDataFromJsonToDBService {
    private final CovidStatisticsRepository covidStatisticsRepository;

    public SaveDataFromJsonToDBService(CovidStatisticsRepository covidStatisticsRepository) {
        this.covidStatisticsRepository = covidStatisticsRepository;
    }

    public CovidStatistics save(CovidStatistics covidStatistics) {
        return covidStatisticsRepository.save(covidStatistics);
    }

    public void readDataFromJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
            GlobalStatisticsDto globalStatisticsDtos = mapper.readValue(new File("c:\\summary.json"), GlobalStatisticsDto.class);
            for (CountryStatisticsDto cs : globalStatisticsDtos.getCountriestList()) {
                save(mapToCovidStatistics(cs));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public CovidStatistics mapToCovidStatistics(CountryStatisticsDto countryStatisticsDto) {
        return new CovidStatistics()
            .setId(countryStatisticsDto.getId())
            .setCountry(countryStatisticsDto.getCountry())
            .setCountryCode(countryStatisticsDto.getCountryCode())
            .setSlug(countryStatisticsDto.getSlug())
            .setNewConfirmed(countryStatisticsDto.getNewConfirmed())
            .setTotalConfirmed(countryStatisticsDto.getTotalConfirmed())
            .setNewDeaths(countryStatisticsDto.getNewDeaths())
            .setTotalDeaths(countryStatisticsDto.getTotalDeaths())
            .setNewRecovored(countryStatisticsDto.getNewRecovered())
            .setTotalRecovored(countryStatisticsDto.getTotalRecovered())
            .setDate(countryStatisticsDto.getDate());
    }
}
