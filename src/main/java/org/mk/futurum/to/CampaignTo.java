package org.mk.futurum.to;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.mk.futurum.model.Campaign;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CampaignTo {

    private long id;
    private String name;
    private String keywords;
    private long bidAmount;
    private long campaignFund;
    private String status;
    private String city;
    private double kilometers;

    public CampaignTo(long id, String name, String keywords, long bidAmount, long campaignFund, String status, String city, double kilometers) {
        this.id = id;
        this.name = name;
        this.keywords = keywords;
        this.bidAmount = bidAmount;
        this.campaignFund = campaignFund;
        this.status = status;
        this.city = city;
        this.kilometers = kilometers;
    }

    public static CampaignTo getOne(Campaign campaign){
        String status;
        long id = campaign.getId();
        String name = campaign.getName();
        String keywords = campaign.getKeywords();
        long bidAmount = campaign.getBidAmount();
        long campaignFund = campaign.getCampaignFund();
        if (campaign.isStatus()){
            status = "Active";
        } else {
             status = "Disable";
        }
        String city = campaign.getCity();
        double kilometers = campaign.getKilometers();
        return new CampaignTo(id, name, keywords, bidAmount, campaignFund, status, city, kilometers);
    }
}
