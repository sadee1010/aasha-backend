package com.example.aasha.controler;

import com.example.aasha.dto.PartnerDTO;
import com.example.aasha.dto.ResponseDTO;
import com.example.aasha.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/partners")
@CrossOrigin
public class PartnerController {
    @Autowired
    PartnerService partnerService;

    @PostMapping("/save")
    public ResponseEntity savePartner(@RequestBody PartnerDTO partnerDTO){
        ResponseDTO responseDTO = partnerService.savePartner(partnerDTO);
        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
    }

    @GetMapping( "/get")
    public ResponseEntity getPartner (){
        ResponseDTO responseDTO = partnerService.getPartner();
        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePartner(@PathVariable Long id){
        ResponseDTO responseDTO = partnerService.deletePartner(id);
        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
    }


}
