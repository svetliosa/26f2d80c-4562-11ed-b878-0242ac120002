package com.example.Covid19.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class GlobalStatisticsDto {
    @JsonProperty("ID")
    private UUID id;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("Global")
    private GlobalDto globalDto;
    @JsonProperty("Countries")
    private ArrayList<CountryStatisticsDto> countriestList;
    @JsonProperty("Date")
    private Date date;
}
