package com20.task5.api;


import com20.task5.dto.SimpleResponse;
import com20.task5.dto.dataDto.DataRequest;
import com20.task5.dto.dataDto.DataResponse;
import com20.task5.serivce.DataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/data")
@PreAuthorize("hasAnyAuthority('ADMIN')")
@Tag(name = "Data API")
public class DataApi {
    private final DataService dataService;

    @GetMapping("/getAll")
    @Operation(summary = "to get all data")
    List<DataResponse> getAll() {
        return dataService.getAll();
    }

    @GetMapping("/getById")
    @Operation(summary = "to get data by id")
    DataResponse getById(@RequestParam Long id) {
        return dataService.getById(id);
    }

    @PostMapping()
    @Operation(summary = "to save new data")
    SimpleResponse save(@RequestBody DataRequest dataRequest) {
        return dataService.save(dataRequest);
    }

    @DeleteMapping()
    @Operation(summary = "to delete data")
    SimpleResponse delete(@RequestParam Long id) {
        return dataService.delete(id);
    }

    @PutMapping()
    @Operation(summary = "to update data")
    SimpleResponse update(@RequestBody DataRequest dataRequest, @RequestParam Long id) {
        return dataService.update(dataRequest, id);
    }
}
