package com.example.Covid19.Repository;

import com.example.Covid19.Entity.CovidStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CovidStatisticsRepository extends JpaRepository<CovidStatistics, String> {
    @Query(value = "SELECT * FROM COVID_STATISTICS_BY_COUNTRY a WHERE a.COUNTRY_CODE = :countryCode", nativeQuery = true)
    List<CovidStatistics> findAllByCountryCode(@Param("countryCode") String countryCode);
}
