package com20.task5.dto.sensorDto;

import lombok.Builder;

import java.time.ZonedDateTime;

@Builder
public record SensorRequest(

        String info,
        String model,
        String type,
        ZonedDateTime installationDate,
        String status) {
}
