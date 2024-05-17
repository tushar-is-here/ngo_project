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
@Table(name = "state")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stateId;

    @Column(name = "state_title", nullable = false, length = 50)
    private String stateTitle;

    @Column(name = "state_description", columnDefinition = "TEXT", nullable = false)
    private String stateDescription;

    @Column(name = "status", nullable = false, length = 10)
    private String status;
}

