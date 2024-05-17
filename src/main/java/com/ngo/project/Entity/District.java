package com.ngo.project.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "district")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer districtId;

    @Column(name = "state_id", nullable = false)
    private Integer stateId;

    @Column(name = "district_title", nullable = false, length = 50)
    private String districtTitle;

    @Column(name = "district_description", columnDefinition = "TEXT", nullable = false)
    private String districtDescription;

    @Column(name = "district_status", nullable = false, length = 10)
    private String districtStatus;
}

