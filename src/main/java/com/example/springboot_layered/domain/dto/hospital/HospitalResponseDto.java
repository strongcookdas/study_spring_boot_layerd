package com.example.springboot_layered.domain.dto.hospital;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HospitalResponseDto {

    private Integer id;
    private String openServiceName;
    private String businessStatusCode;
    private String phone;
    private String fullAddress;
    private String roadNameAddress;
    private String hospitalName;
    private String businessTypeName;

    public HospitalResponseDto(Integer id, String openServiceName, String phone, String fullAddress, String roadNameAddress, String hospitalName, String businessTypeName) {
        this.id = id;
        this.openServiceName = openServiceName;
        this.phone = phone;
        this.fullAddress = fullAddress;
        this.roadNameAddress = roadNameAddress;
        this.hospitalName = hospitalName;
        this.businessTypeName = businessTypeName;
    }
}
