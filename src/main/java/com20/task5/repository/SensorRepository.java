package com20.task5.repository;

import com20.task5.dto.sensorDto.SensorResponse;
import com20.task5.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
    @Query("select new com20.task5.dto.sensorDto.SensorResponse(s.id,  s.info,  s.model, s.type, s.installationDate, s.status) from Sensor s")
    List<SensorResponse> getAll();
}
