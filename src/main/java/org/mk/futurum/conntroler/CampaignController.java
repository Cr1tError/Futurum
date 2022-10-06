package org.mk.futurum.conntroler;

import org.mk.futurum.model.Campaign;
import org.mk.futurum.to.CampaignTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.mk.futurum.service.CampaignService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Controller
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping("/campaigns")
    public String getAllCampaigns(Model model){
       List<CampaignTo> campaignsTo;

       try{
           List<Campaign> campaigns = campaignService.findAll();
           campaignsTo = campaigns.stream()
                   .map(CampaignTo::getOne)
                   .collect(Collectors.toList());
           model.addAttribute("campaigns", campaignsTo);
       }catch (NoSuchElementException e){
           campaignsTo = Collections.emptyList();
           model.addAttribute("campaigns", campaignsTo);
       }
        return "campaigns";
    }

    @GetMapping("/campaign-create")
    public String createCampaignForm(CampaignTo campaignTo){
        return "campaign-create";
    }

    @PostMapping("/campaign-create")
    public String createCampaign(CampaignTo campaignTo){

        campaignService.saveCampaign(createCampaignFromTo(campaignTo));
        return "redirect:/campaigns";
    }

    @GetMapping("campaign-delete/{id}")
    public String deleteCampaign(@PathVariable("id") long id){
        campaignService.deleteById(id);
        return "redirect:/campaigns";
    }

    @GetMapping("/campaign-update/{id}")
    public String updateCampaignForm(@PathVariable("id") long id, Model model){
        Campaign campaign = campaignService.findById(id);
        CampaignTo campaignTo = CampaignTo.getOne(campaign);
        model.addAttribute("campaignTo", campaignTo);
        return "campaign-update";
    }

    @PostMapping("/campaign-update")
    public String updateCampaign(CampaignTo campaignTo){
        campaignService.saveCampaign(updateCampaignFromTo(campaignTo));
        return "redirect:/campaigns";
    }

    private Campaign updateCampaignFromTo(CampaignTo campaignTo){
        boolean status = false;
        if(campaignTo.getStatus().equals("Active")){
            status = true;
        } else if (campaignTo.getStatus().equals("Disable")){
            status= false;
        }
        Campaign campaign = campaignService.findById(campaignTo.getId());
        campaign.setName(campaignTo.getName());
        campaign.setKeywords(campaignTo.getKeywords());
        campaign.setBidAmount(campaignTo.getBidAmount());
        campaign.setCampaignFund(campaignTo.getCampaignFund());
        campaign.setStatus(status);
        campaign.setCity(campaignTo.getCity());
        campaign.setKilometers(campaignTo.getKilometers());

        return campaign;
    }

    private Campaign createCampaignFromTo(CampaignTo campaignTo){
        boolean status = false;
        if(campaignTo.getStatus().equals("Active")){
            status = true;
        } else if (campaignTo.getStatus().equals("Disable")){
            status= false;
        }
        Campaign campaign = new Campaign();
        campaign.setName(campaignTo.getName());
        campaign.setKeywords(campaignTo.getKeywords());
        campaign.setBidAmount(campaignTo.getBidAmount());
        campaign.setCampaignFund(campaignTo.getCampaignFund());
        campaign.setStatus(status);
        campaign.setCity(campaignTo.getCity());
        campaign.setKilometers(campaignTo.getKilometers());
        return campaign;
    }

}
