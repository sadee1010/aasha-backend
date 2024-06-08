package com.example.aasha.service;

import com.example.aasha.dto.PartnerDTO;
import com.example.aasha.entity.Partner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PartnerService {

    List<Partner> getAllPartners();

    Partner getPartnerById(Long id);

    Partner savePartner(Partner partner);

    Partner updatePartner(Long id, Partner partner);

    void deletePartner(Long id);

    public PartnerDTO convertToDTO(Partner partner);

}
