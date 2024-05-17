package com.ngo.project.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "district_id")
    private Integer districtId;

    @Column(name = "state_id")
    private Integer stateId;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "status", length = 10)
    private String status;
}
