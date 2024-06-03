package com20.task5.serivce.impl;

import com20.task5.dto.SimpleResponse;
import com20.task5.dto.sensorDto.SensorRequest;
import com20.task5.dto.sensorDto.SensorResponse;
import com20.task5.entity.Sensor;
import com20.task5.globalException.NotFoundException;
import com20.task5.repository.SensorRepository;
import com20.task5.serivce.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;
    @Override
    public List<SensorResponse> getAll() {
        return sensorRepository.getAll();
    }

    @Override
    public SensorResponse getById(Long id) {
        Sensor sensor = sensorRepository.findById(id).orElseThrow(
                () -> new NotFoundException(
                        "There is no sensor with id: " + id
                )
        );
        return SensorResponse.builder()
                .id(sensor.getId())
                .info(sensor.getInfo())
                .model(sensor.getModel())
                .type(sensor.getType())
                .status(sensor.getStatus())
                .installationDate(sensor.getInstallationDate())
                .build();
    }

    @Override
    public SimpleResponse save(SensorRequest sensorRequest) {
        Sensor sensor = new Sensor();
        sensor.setInfo(sensorRequest.info());
        sensor.setModel(sensorRequest.model());
        sensor.setType(sensorRequest.type());
        sensor.setStatus(sensorRequest.status());
        sensor.setInstallationDate(sensorRequest.installationDate());
        sensorRepository.save(sensor);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("sensor saved")
                .build();
    }

    @Override
    public SimpleResponse delete(Long id) {
        Sensor sensor = sensorRepository.findById(id).orElseThrow(
                () -> new NotFoundException(
                        "There is no sensor with id: " + id
                )
        );
        sensorRepository.delete(sensor);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("sensor deleted")
                .build();
    }

    @Override
    public SimpleResponse update(SensorRequest sensorRequest, Long id) {
        Sensor sensor = sensorRepository.findById(id).orElseThrow(
                () -> new NotFoundException(
                        "There is no sensor with id: " + id
                )
        );
        sensor.setInfo(sensorRequest.info());
        sensor.setModel(sensorRequest.model());
        sensor.setType(sensorRequest.type());
        sensor.setStatus(sensorRequest.status());
        sensor.setInstallationDate(sensorRequest.installationDate());
        sensorRepository.save(sensor);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("sensor updated")
                .build();
    }
}
