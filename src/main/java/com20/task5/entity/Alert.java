package com20.task5.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "alerts")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Alert {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "alert_gen"
    )
    @SequenceGenerator(
            name = "alert_gen",
            sequenceName = "alert_seq",
            allocationSize = 1
    )
    private Long id;
    private String info;
    @ManyToOne
    private Sensor sensor;
}
