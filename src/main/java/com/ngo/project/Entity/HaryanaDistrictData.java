package com.ngo.project.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "haryana_district_data")
public class HaryanaDistrictData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "district_code")
    private Integer districtCode;

    @Column(name = "district_name", columnDefinition = "TEXT")
    private String districtName;

    @Column(name = "block_code")
    private Integer blockCode;

    @Column(name = "block_name", columnDefinition = "TEXT")
    private String blockName;

    @Column(name = "village_id")
    private Integer villageId;

    @Column(name = "village_name", columnDefinition = "TEXT")
    private String villageName;

    @Column(name = "assembly_constituency_code")
    private Integer assemblyConstituencyCode;

    @Column(name = "assembly_constituency_name", columnDefinition = "TEXT")
    private String assemblyConstituencyName;

    @Column(name = "parliament_constituency_code")
    private Integer parliamentConstituencyCode;

    @Column(name = "parliament_constituency_name", columnDefinition = "TEXT")
    private String parliamentConstituencyName;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private String createdAt;

    @Column(name = "created_by", columnDefinition = "TEXT")
    private String createdBy;

    @UpdateTimestamp
    @Column(name = "updated_at", insertable = false)
    private String updatedAt;

    @Column(name = "updated_by", columnDefinition = "TEXT")
    private String updatedBy;

    @Column(name = "village_latitude", columnDefinition = "TEXT")
    private String villageLatitude;

    @Column(name = "village_longitude", columnDefinition = "TEXT")
    private String villageLongitude;
}

