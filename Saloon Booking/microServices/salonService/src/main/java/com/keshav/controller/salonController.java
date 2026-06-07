package com.keshav.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.keshav.mapper.salonMapper;
import com.keshav.model.salon;
import com.keshav.payload.dto.salonDTO;
import com.keshav.payload.dto.userDTO;
import com.keshav.services.salonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/salons")
@RequiredArgsConstructor
public class salonController {

    private final salonService salonService;

    @PostMapping
    public ResponseEntity<salonDTO> createSalon(@RequestBody salonDTO salonDTO) {
        userDTO userDTO=new userDTO();
        userDTO.setId(1L);

        salon salon=salonService.createSalon(salonDTO, userDTO);
        salonDTO salonDTO1=salonMapper.mapToDTO(salon);
        
        return ResponseEntity.ok(salonDTO1);
    }

    @PutMapping("/{salonId}")
    public ResponseEntity<salonDTO> updateSalon(@PathVariable Long salonId,@RequestBody salonDTO salonDTO) throws Exception {
        userDTO userDTO=new userDTO();
        userDTO.setId(1L);

        salon salon=salonService.updateSalon(salonDTO, userDTO, salonId);
        salonDTO salonDTO1=salonMapper.mapToDTO(salon);
        
        return ResponseEntity.ok(salonDTO1);
    }

    @GetMapping()
    public ResponseEntity<List<salonDTO>> getSalons(){
        List<salon> salons=salonService.getAllSalons();

        List<salonDTO> salonDTOS=salons.stream().map((salon)->
                {
                    salonDTO salonDTO = salonMapper.mapToDTO(salon);
                    return salonDTO;
                }      
            ).toList();
        
        return ResponseEntity.ok(salonDTOS);
    }

    @GetMapping("/{salonId}")
    public ResponseEntity<salonDTO> getSalonById(@PathVariable Long salonId) throws Exception {

        salon salon=salonService.getSalonById(salonId);
        salonDTO salonDTO=salonMapper.mapToDTO(salon);
        
        return ResponseEntity.ok(salonDTO);
    }

    @GetMapping("/owner")
    public ResponseEntity<salonDTO> getSalonByOwnerId(@PathVariable Long salonId) {
        userDTO userDTO=new userDTO();
        userDTO.setId(1L);

        salon salon=salonService.getSalonByOwnerId(userDTO.getId());
        salonDTO salonDTO=salonMapper.mapToDTO(salon);
        
        return ResponseEntity.ok(salonDTO);
    }

    @GetMapping("/search")
    public ResponseEntity<List<salonDTO>> searchSalons(@RequestParam("city") String city){
        List<salon> salons=salonService.searchSalonByCity(city);

        List<salonDTO> salonDTOS=salons.stream().map((salon)->
                {
                    salonDTO salonDTO = salonMapper.mapToDTO(salon);
                    return salonDTO;
                }      
            ).toList();
        
        return ResponseEntity.ok(salonDTOS);
    }
}
