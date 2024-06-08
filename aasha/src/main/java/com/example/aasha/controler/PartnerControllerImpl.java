package com.example.aasha.controler;

import com.example.aasha.dto.PartnerDTO;
import com.example.aasha.entity.Partner;
import com.example.aasha.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PartnerControllerImpl implements PartnerController{
    private final PartnerService partnerService;

    @Autowired
    public PartnerControllerImpl(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @Override
    public ResponseEntity<List<PartnerDTO>> getAllPartners() {
        List<PartnerDTO> partnerDTOs = partnerService.getAllPartners()
                .stream()
                .map(partnerService::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(partnerDTOs);
    }

    @Override
    public ResponseEntity<PartnerDTO> getPartnerById(@PathVariable Long id) {
        PartnerDTO partnerDTO = partnerService.convertToDTO(partnerService.getPartnerById(id));
        return ResponseEntity.status(HttpStatus.OK).body(partnerDTO);
    }

    @Override
    public ResponseEntity<PartnerDTO> savePartner(@RequestBody Partner partner) {
        Partner newPartner = partnerService.savePartner(partner);
        PartnerDTO newPartnerDTO = partnerService.convertToDTO(newPartner);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPartnerDTO);
    }

    @Override
    public ResponseEntity<PartnerDTO> updatePartner(@PathVariable Long id, @RequestBody Partner partner) {
        Partner updatedPartner = partnerService.updatePartner(id, partner);
        PartnerDTO updatedPartnerDTO = partnerService.convertToDTO(updatedPartner);
        return ResponseEntity.status(HttpStatus.OK).body(updatedPartnerDTO);
    }

    @Override
    public ResponseEntity<Void> deletePartner(@PathVariable Long id) {
        partnerService.deletePartner(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
