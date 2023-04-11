package com.example.crowdfunding.repository;

import com.example.crowdfunding.model.CampaignRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRequestRepo extends JpaRepository<CampaignRequest, Integer> {
}