package com.example.Covid19.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "COVID_STATISTICS_BY_COUNTRY")
@Getter
@Setter
@Accessors(chain = true)
public class CovidStatistics implements Serializable {
    @Id
    @Column(name = "ID")
    private UUID id;
    @Column(name = "COUNTRY", nullable = false, length = 20, unique = true)
    private String country;
    @Column(name = "COUNTRY_CODE", nullable = false, length = 10, unique = true)
    private String countryCode;
    @Column(name = "SLUG", nullable = false, length = 20, unique = true)
    private String slug;
    @Column(name = "NEW_CONFIRMED", nullable = false)
    private int newConfirmed;
    @Column(name = "TOTAL_CONFIRMED", nullable = false)
    private int totalConfirmed;
    @Column(name = "NEW_DEATHS", nullable = false)
    private int newDeaths;
    @Column(name = "TOTAL_DEATHS", nullable = false)
    private int totalDeaths;
    @Column(name = "NEW_RECOVERED", nullable = false)
    private int newRecovored;
    @Column(name = "TOTAL_RECOVERED", nullable = false)
    private int totalRecovored;
    @Column(name = "DATE", nullable = false)
    private Date date;
}
