package com.example.car.model;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "stats", schema = "public")
public class Stats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "activity", nullable = false)
    private long activity;

    @NotBlank
    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    @NotBlank
    @Column(name = "uuid", nullable = false)
    private String uuid;

    public Stats(Long activity, LocalDateTime time, String uuid) {
        this.activity = activity;
        this.time = time;
        this.uuid = uuid;
    }
}
