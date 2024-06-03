package com20.task5.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "datas")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Data {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "data_gen"
    )
    @SequenceGenerator(
            name = "data_gen",
            sequenceName = "data_seq",
            allocationSize = 1
    )
    private Long id;
    private String temperature;
    private String speed;
    private String pressure;
    @ManyToOne
    private Sensor sensor;
}
