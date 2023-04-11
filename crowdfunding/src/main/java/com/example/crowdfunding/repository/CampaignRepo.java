package com.example.crowdfunding.repository;

import com.example.crowdfunding.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepo extends JpaRepository<Campaign, Integer> {
}
