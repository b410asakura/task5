package com20.task5.serivce;

import com20.task5.dto.SimpleResponse;
import com20.task5.dto.dataDto.DataRequest;
import com20.task5.dto.dataDto.DataResponse;

import java.util.List;

public interface DataService {
    List<DataResponse> getAll();
    DataResponse getById(Long id);

    SimpleResponse save(DataRequest dataRequest);

    SimpleResponse delete(Long id);

    SimpleResponse update(DataRequest dataRequest, Long id);


}
