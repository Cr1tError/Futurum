package org.mk.futurum.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mk.futurum.FuturumApplication;
import org.mk.futurum.model.Campaign;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = FuturumApplication.class)
class CampaignServiceTest {

    @MockBean
    private CampaignService campaignService;


    @Test
    void testFindByIdCampaign() {
        Campaign campaign = getCampaign();
        given(campaignService.findById(1)).willReturn(campaign);
        Campaign result = campaignService.findById(1);
        assertEquals(result.getId(), 1);
    }

    @Test
    void testFindAllCampaigns() {
        Campaign campaign = getCampaign();
        List<Campaign> campaigns = new ArrayList<>();
        campaigns.add(campaign);
        given(campaignService.findAll()).willReturn(campaigns);
        List<Campaign> result = campaignService.findAll();
        assertEquals(result.size(), 1);
    }

    @Test
    void testSaveCampaign() {
        Campaign campaign = getCampaign();
        given(campaignService.saveCampaign(campaign)).willReturn(campaign);
        campaignService.saveCampaign(campaign);
        assertTrue(true);
    }

    @Test
    void testDeleteByIdCampaign() {
        doNothing().when(campaignService).deleteById(1);
        campaignService.deleteById(1);
        assertTrue(true);
    }

    private Campaign getCampaign(){
        Campaign campaign = new Campaign();
        campaign.setId(1);
        campaign.setName("Siemens");
        campaign.setBidAmount(2022);
        campaign.setCampaignFund(2020);
        campaign.setStatus(true);
        campaign.setCity("Paris");
        campaign.setKilometers(20);
        return campaign;
    }
}