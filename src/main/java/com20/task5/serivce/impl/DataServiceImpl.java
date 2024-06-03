package com20.task5.serivce.impl;

import com20.task5.dto.SimpleResponse;
import com20.task5.dto.dataDto.DataRequest;
import com20.task5.dto.dataDto.DataResponse;
import com20.task5.entity.Data;
import com20.task5.globalException.NotFoundException;
import com20.task5.repository.DataRepository;
import com20.task5.serivce.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {
    private final DataRepository dataRepository;
    @Override
    public List<DataResponse> getAll() {
        return dataRepository.getAll();
    }

    @Override
    public DataResponse getById(Long id) {
        Data data = dataRepository.findById(id).orElseThrow(
                () -> new NotFoundException(
                        "There is no data with id: " + id
                )
        );
        return DataResponse.builder()
                .id(data.getId())
                .temperature(data.getTemperature())
                .speed(data.getSpeed())
                .pressure(data.getPressure())
                .build();
    }

    @Override
    public SimpleResponse save(DataRequest dataRequest) {
        Data data = new Data();
        data.setPressure(dataRequest.pressure());
        data.setTemperature(dataRequest.temperature());
        data.setSpeed(dataRequest.speed());
        dataRepository.save(data);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("data saved")
                .build();
    }

    @Override
    public SimpleResponse delete(Long id) {
        Data data = dataRepository.findById(id).orElseThrow(
                () -> new NotFoundException(
                        "There is no data with id: " + id
                )
        );
        dataRepository.delete(data);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("data deleted")
                .build();
    }

    @Override
    public SimpleResponse update(DataRequest dataRequest, Long id) {
        Data data = dataRepository.findById(id).orElseThrow(
                () -> new NotFoundException(
                        "There is no data with id: " + id
                )
        );
        data.setPressure(dataRequest.pressure());
        data.setTemperature(dataRequest.temperature());
        data.setSpeed(dataRequest.speed());
        dataRepository.save(data);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("data updated")
                .build();
    }
}
