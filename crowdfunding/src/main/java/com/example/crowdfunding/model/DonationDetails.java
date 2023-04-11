package com.example.crowdfunding.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "donation_details")
public class DonationDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private double amount;
    private String date;
    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;
    @ManyToOne
    @JoinColumn(name = "donor_id")
    private Donor donor;
}
