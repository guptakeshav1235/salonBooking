package com.keshav.mapper;

import com.keshav.model.salon;
import com.keshav.payload.dto.salonDTO;

public class salonMapper {
    
    public static salonDTO mapToDTO(salon salon) {
        salonDTO salonDTO = new salonDTO();

        salonDTO.setId(salon.getId());
        salonDTO.setName(salon.getName());
        salonDTO.setAddress(salon.getAddress());
        salonDTO.setCity(salon.getCity());
        salonDTO.setEmail(salon.getEmail());
        salonDTO.setImages(salon.getImages());
        salonDTO.setCloseTime(salon.getCloseTime());
        salonDTO.setOpenTime(salon.getOpenTime());
        salonDTO.setPhoneNumber(salon.getPhoneNumber());
        salonDTO.setOwnerId(salon.getOwnerId());

        return salonDTO;    
    }
}
