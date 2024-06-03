package com20.task5.dto.alertDto;

import lombok.Builder;

@Builder
public record AlertResponse(
        Long id,
        String info
) {
}
