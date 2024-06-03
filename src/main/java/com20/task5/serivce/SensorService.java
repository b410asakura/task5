package com20.task5.serivce;

import com20.task5.dto.SimpleResponse;
import com20.task5.dto.sensorDto.SensorRequest;
import com20.task5.dto.sensorDto.SensorResponse;

import java.util.List;

public interface SensorService {
    List<SensorResponse> getAll();

    SensorResponse getById(Long id);

    SimpleResponse save(SensorRequest sensorRequest);

    SimpleResponse delete(Long id);

    SimpleResponse update(SensorRequest sensorRequest, Long id);

}
