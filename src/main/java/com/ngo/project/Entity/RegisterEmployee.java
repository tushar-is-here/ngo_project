package com.ngo.project.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RegisterEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String gender;
    private Date dob;
    private String address;
    private String pincode;
    private int role;
    private String password;
    @CreationTimestamp
    @Column(name = "created_on", updatable = false)
    private LocalDateTime createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on", insertable = false)
    private LocalDateTime updatedOn;
}
