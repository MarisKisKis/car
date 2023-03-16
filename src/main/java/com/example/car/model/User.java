package com.example.car.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uuid")
    private String uuid;


    @NotBlank
    @Column(name = "money", nullable = false)
    private long money;


    @NotBlank
    @Column(name = "country", nullable = false)
    private String country;

    @NotBlank
    @Size(max = 10240)
    @Column(name = "jsonData", nullable = false)
    private String jsonData;

    @NotBlank
    @Column(name = "firstTimestamp", nullable = false)
    private LocalDateTime firstTimestamp;

}
