package com20.task5.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "sensors")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sensor {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "equipment_gen"
    )
    @SequenceGenerator(
            name = "equipment_gen",
            sequenceName = "equipment_seq",
            allocationSize = 1
    )
    private Long id;
    private String info;
    private String model;
    private String type;
    private ZonedDateTime installationDate;
    private String status;
    @OneToMany(mappedBy = "sensor")
    private List<Data> data;
    @OneToMany(mappedBy = "sensor")
    private List<Alert> alert;
}
