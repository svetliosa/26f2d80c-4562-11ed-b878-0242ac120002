package com.example.Covid19.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.util.Date;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class CountryStatisticsDto {
    @JsonProperty("ID")
    private UUID id;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("CountryCode")
    private String countryCode;
    @JsonProperty("Slug")
    private String slug;
    @JsonProperty("NewConfirmed")
    private int newConfirmed;
    @JsonProperty("TotalConfirmed")
    private int totalConfirmed;
    @JsonProperty("NewDeaths")
    private int newDeaths;
    @JsonProperty("TotalDeaths")
    private int totalDeaths;
    @JsonProperty("NewRecovered")
    private int newRecovered;
    @JsonProperty("TotalRecovered")
    private int totalRecovered;
    @JsonProperty("Date")
    private Date date;
}
