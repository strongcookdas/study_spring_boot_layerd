package com.example.springboot_layered.domain.entity;

import com.example.springboot_layered.domain.dto.hospital.HospitalResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nation_wide_hospitals")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hospital {
    @Id
    private Integer id;

    private String openServiceName;
    private Integer businessStatusCode;
    private String phone;
    private String fullAddress;
    private String roadNameAddress;
    private String hospitalName;
    private String businessTypeName;

    public HospitalResponseDto toResponseDto(){
        return new HospitalResponseDto(this.id,this.openServiceName,this.phone,this.fullAddress,this.roadNameAddress,this.hospitalName,this.businessTypeName);
    }
}
