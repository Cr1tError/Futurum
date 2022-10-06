package org.mk.futurum.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
@Data
@NoArgsConstructor
public class Campaign {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String name;

    private String keywords;

    private long bidAmount;

    private long campaignFund;

    private boolean status;

    private String city;

    private double kilometers;

    public Campaign(String name, String keywords, long bidAmount, long campaignFund, boolean status, String city, double kilometers) {
        this.name = name;
        this.keywords = keywords;
        this.bidAmount = bidAmount;
        this.campaignFund = campaignFund;
        this.status = status;
        this.city = city;
        this.kilometers = kilometers;
    }


}
