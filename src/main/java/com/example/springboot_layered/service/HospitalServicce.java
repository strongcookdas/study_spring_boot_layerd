package com.example.springboot_layered.service;

import com.example.springboot_layered.domain.dto.hospital.HospitalResponseDto;
import com.example.springboot_layered.domain.entity.Hospital;
import com.example.springboot_layered.repository.HospitalRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HospitalServicce {

    private final HospitalRepository hospitalRepository;

    public HospitalResponseDto getHospital(Integer id){
        HospitalResponseDto hospitalResponseDto = null;
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        if(!optionalHospital.isEmpty()){
            hospitalResponseDto = optionalHospital.get().toResponseDto();
            switch (optionalHospital.get().getBusinessStatusCode()){
                case 13:
                    hospitalResponseDto.setBusinessStatusCode("영업중");
                    break;
                case 3:
                    hospitalResponseDto.setBusinessStatusCode("폐업");
                    break;
                default:
                    hospitalResponseDto.setBusinessStatusCode(String.valueOf(optionalHospital.get().getBusinessStatusCode()));
            }
        }
        return hospitalResponseDto;
    }
}
