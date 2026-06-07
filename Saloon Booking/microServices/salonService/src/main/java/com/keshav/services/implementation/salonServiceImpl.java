package com.keshav.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.keshav.model.salon;
import com.keshav.payload.dto.salonDTO;
import com.keshav.payload.dto.userDTO;
import com.keshav.repositories.salonRepository;
import com.keshav.services.salonService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class salonServiceImpl implements salonService{

    private final salonRepository salonRepository;

    @Override
    public salon createSalon(salonDTO req, userDTO user) {
        salon salon = new salon();
        salon.setName(req.getName());
        salon.setAddress(req.getAddress());
        salon.setEmail(req.getEmail());
        salon.setCity(req.getCity());
        salon.setImages(req.getImages());
        salon.setOwnerId(user.getId().toString()); 
        salon.setOpenTime(req.getOpenTime());
        salon.setCloseTime(req.getCloseTime());
        salon.setPhoneNumber(req.getPhoneNumber());

        return salonRepository.save(salon);
    }

    @Override
    public salon updateSalon(salonDTO salon, userDTO user, Long salonId) throws Exception {
        salon existingSalon = salonRepository.findById(salonId).orElse(null);

        if(!salon.getOwnerId().equals(user.getId().toString()))
            throw new Exception("you don't have permission to update this salon");

        if (existingSalon != null) {
            existingSalon.setCity(salon.getCity());
            existingSalon.setName(salon.getName());
            existingSalon.setAddress(salon.getAddress());
            existingSalon.setEmail(salon.getEmail());
            existingSalon.setImages(salon.getImages());
            existingSalon.setOpenTime(salon.getOpenTime());
            existingSalon.setCloseTime(salon.getCloseTime());
            existingSalon.setOwnerId(user.getId().toString());
            existingSalon.setPhoneNumber(salon.getPhoneNumber());
            
            return salonRepository.save(existingSalon);
        }
       
        throw new Exception("Salon not found");
    }
    @Override
    public List<salon> getAllSalons() {
        return salonRepository.findAll();
    }

    @Override
    public salon getSalonById(Long salonId) throws Exception {
        return salonRepository.findById(salonId).orElseThrow(() -> new Exception("salon not exist"));
    }

    @Override
    public salon getSalonByOwnerId(Long ownerId) {
        return salonRepository.findByOwnerId(ownerId);
    }

    @Override
    public List<salon> searchSalonByCity(String city) {
        return salonRepository.searchSalons(city);
    }
}
