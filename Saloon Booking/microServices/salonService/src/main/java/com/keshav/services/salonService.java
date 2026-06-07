package com.keshav.services;

import java.util.List;

import com.keshav.model.salon;
import com.keshav.payload.dto.salonDTO;
import com.keshav.payload.dto.userDTO;

public interface salonService {
    salon createSalon(salonDTO salonDTO, userDTO userDTO);

    salon updateSalon(salonDTO salonDTO, userDTO userDTO, Long salonId) throws Exception;

    List<salon> getAllSalons();

    salon getSalonById(Long salonId) throws Exception;

    salon getSalonByOwnerId(Long ownerId);

    List<salon> searchSalonByCity(String city);
}
