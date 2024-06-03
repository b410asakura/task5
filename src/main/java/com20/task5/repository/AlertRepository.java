package com20.task5.repository;

import com20.task5.dto.alertDto.AlertResponse;
import com20.task5.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {
    @Query("select new com20.task5.dto.alertDto.AlertResponse(a.id, a.info) from Alert a")
    List<AlertResponse> getAll();
}
