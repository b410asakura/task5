package com20.task5.serivce.impl;

import com20.task5.dto.SimpleResponse;
import com20.task5.dto.alertDto.AlertRequest;
import com20.task5.dto.alertDto.AlertResponse;
import com20.task5.entity.Alert;
import com20.task5.globalException.NotFoundException;
import com20.task5.repository.AlertRepository;
import com20.task5.serivce.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertServiceImpl implements AlertService {
    private final AlertRepository alertRepository;

    @Override
    public List<AlertResponse> getAll() {
        return alertRepository.getAll();
    }

    @Override
    public AlertResponse getById(Long id) {
        Alert alert = alertRepository.findById(id).orElseThrow(
                () -> new NotFoundException(
                        "There is no alert with id: " + id
                )
        );
        return new AlertResponse(alert.getId(), alert.getInfo());
    }

    @Override
    public SimpleResponse save(AlertRequest alertRequest) {
        Alert alert = new Alert();
        alert.setInfo(alertRequest.info());
        alertRepository.save(alert);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("alert saved")
                .build();
    }

    @Override
    public SimpleResponse delete(Long id) {
        Alert alert = alertRepository.findById(id).orElseThrow(
                () -> new NotFoundException(
                        "There is no alert with id: " + id
                )
        );
        alertRepository.delete(alert);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("alert deleted")
                .build();
    }

    @Override
    public SimpleResponse update(AlertRequest alertRequest, Long id) {
        Alert alert = alertRepository.findById(id).orElseThrow(
                () -> new NotFoundException(
                        "There is no alert with id: " + id
                )
        );
        alert.setInfo(alertRequest.info());
        alertRepository.save(alert);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("alert updated")
                .build();
    }
}
