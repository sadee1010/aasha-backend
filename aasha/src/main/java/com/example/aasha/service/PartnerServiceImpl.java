package com.example.aasha.service;

import com.example.aasha.dto.PartnerDTO;
import com.example.aasha.entity.Partner;
import com.example.aasha.repo.PartnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PartnerServiceImpl implements PartnerService{

    private PartnerRepo partnerRepo;

    @Autowired
    public PartnerServiceImpl(PartnerRepo partnerRepo) {
        this.partnerRepo = partnerRepo;
    }

    @Override
    public List<Partner> getAllPartners() {
        return partnerRepo.findAll();
    }

    @Override
    public Partner getPartnerById(Long id) {
        return partnerRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Partner not found with " + id));
    }

    @Override
    public Partner savePartner(Partner partner) {
        return partnerRepo.save(partner);
    }

    @Override
    public Partner updatePartner(Long id, Partner updatedPartner) {
        Partner existingPartner = partnerRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Partner not found with id " + id));

        existingPartner.setPname(updatedPartner.getPname());

        return partnerRepo.save(existingPartner);
    }

    @Override
    public void deletePartner(Long id) {
        partnerRepo.deleteById(id);
    }

    @Override
    public PartnerDTO convertToDTO(Partner partner) {
        PartnerDTO partnerDTO = new PartnerDTO();
        partnerDTO.setPid(partner.getPid());
        partnerDTO.setPname(partner.getPname());

        return partnerDTO;
    }

}
