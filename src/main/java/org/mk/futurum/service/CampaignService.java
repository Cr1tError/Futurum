package org.mk.futurum.service;

import org.mk.futurum.model.Campaign;
import org.mk.futurum.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {

    private final CampaignRepository campaignRepository;

    @Autowired
    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    public Campaign findById(long id){
        return campaignRepository.getReferenceById(id);
    }

    public List<Campaign> findAll(){
        return campaignRepository.findAll();
    }

    public Campaign saveCampaign( Campaign campaign){
        return campaignRepository.save(campaign);
    }

    public void deleteById(long id){
        campaignRepository.deleteById(id);
    }
}
