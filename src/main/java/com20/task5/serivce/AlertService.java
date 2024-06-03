package com20.task5.serivce;

import com20.task5.dto.SimpleResponse;
import com20.task5.dto.alertDto.AlertRequest;
import com20.task5.dto.alertDto.AlertResponse;

import java.util.List;

public interface AlertService {
    List<AlertResponse> getAll();

    AlertResponse getById(Long id);

    SimpleResponse save(AlertRequest alertRequest);

    SimpleResponse delete(Long id);

    SimpleResponse update(AlertRequest alertRequest, Long id);

}
