package com.tinubu.insurance.domain;

import javax.validation.constraints.NotNull;
import com.tinubu.insurance.reference.PolicyStatus;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/***
 * Policy entity
 */
@Data
@Entity
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Size(min = 1)
    private String name;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private PolicyStatus status;

    @NotNull
    private LocalDateTime startDate;

    @NotNull
    private LocalDateTime endDate;


    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
