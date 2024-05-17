package com.ngo.project.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "login_tbl")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private String username;
    private String password;
    private int role;
    private String phoneNumber;
    @CreationTimestamp
    @Column(name = "created_on", updatable = false)
    private LocalDateTime createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on", insertable = false)
    private LocalDateTime updatedOn;
}
