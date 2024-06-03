package com20.task5.api;

import com20.task5.dto.SimpleResponse;
import com20.task5.dto.sensorDto.SensorRequest;
import com20.task5.dto.sensorDto.SensorResponse;
import com20.task5.repository.SensorRepository;
import com20.task5.serivce.SensorService;
import io.micrometer.observation.transport.SenderContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sensor")
@PreAuthorize("hasAnyAuthority('ADMIN')")
@Tag(name = "Sensor API")
public class SensorApi {

    private final SensorService sensorService;

    @GetMapping("/getAll")
    @Operation(summary = "to get all sensors")
    List<SensorResponse> getAll() {
        return sensorService.getAll();
    }

    @GetMapping("/getById")
    @Operation(summary = "to get by id")
    SensorResponse getById(@RequestParam Long id) {
        return sensorService.getById(id);
    }

    @PostMapping()
    @Operation(summary = "to save new sensor")
    SimpleResponse save(@RequestBody SensorRequest sensorRequest) {
        return sensorService.save(sensorRequest);
    }

    @DeleteMapping()
    @Operation(summary = "to delete sensor")
    SimpleResponse delete(@RequestParam Long id) {
        return sensorService.delete(id);
    }

    @PutMapping()
    @Operation(summary = "to update sensor")
    SimpleResponse update(@RequestBody SensorRequest sensorRequest, @RequestParam Long id) {
        return sensorService.update(sensorRequest, id);
    }
}
