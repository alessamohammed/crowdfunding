package com.example.crowdfunding.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "campaign_requests")
public class CampaignRequest extends Campaign {
    private String status;
}
