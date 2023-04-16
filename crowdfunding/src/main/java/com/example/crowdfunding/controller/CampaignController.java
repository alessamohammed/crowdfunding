package com.example.crowdfunding.controller;

import com.example.crowdfunding.model.Campaign;
import com.example.crowdfunding.repository.CampaignRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/campaign")
public class CampaignController {
    @Autowired
    private CampaignRepo CampaignRepo;

    @GetMapping("/all")
    public Iterable<Campaign> getAllCampaigns() {
        return CampaignRepo.findAll();
    }

    // get approved campaigns
    @GetMapping("/approved")
    public Iterable<Campaign> getApprovedCampaigns() {
        return CampaignRepo.findByStatus("approved");
    }

    // get disapproved campaigns
    @GetMapping("/disapproved")
    public Iterable<Campaign> getDisapprovedCampaigns() {
        return CampaignRepo.findByStatus("disapproved");
    }

    // get processing campaigns
    @GetMapping("/processing")
    public Iterable<Campaign> getProcessingCampaigns() {
        return CampaignRepo.findByStatus("processing");
    }

    // university approved
    @GetMapping("/university-approved")
    public Iterable<Campaign> getUniversityApprovedCampaigns() {
        return CampaignRepo.findByStatus("university-approved");
    }

    // university approve campaign
    @PutMapping("/university-approve/{id}")
    public Campaign universityApproveCampaign(@PathVariable("id") Integer id) {
        Campaign campaign = CampaignRepo.findById(id).get();
        campaign.setStatus("university-approved");
        CampaignRepo.save(campaign);
        return CampaignRepo.save(campaign);
    }

    @GetMapping("/{id}")
    public Campaign getCampaignById(@PathVariable("id") Integer id) {
        return CampaignRepo.findById(id).get();
    }

    @PostMapping("/add")
    public Campaign addCampaign(@RequestBody Campaign campaign) {
        campaign.setStatus("processing");
        return CampaignRepo.save(campaign);
    }

    @PutMapping("/update")
    public Campaign updateCampaign(@RequestBody Campaign campaign) {
        return CampaignRepo.save(campaign);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCampaign(@PathVariable("id") Integer id) {
        CampaignRepo.deleteById(id);
    }

    @PutMapping("/disapprove/{id}")
    public Campaign disapproveCampaign(@PathVariable("id") Integer id) {
        Campaign campaign = CampaignRepo.findById(id).get();
        campaign.setStatus("disapproved");
        CampaignRepo.save(campaign);
        return CampaignRepo.save(campaign);
    }

    @PutMapping("/approve/{id}")
    public Campaign approveCampaign(@PathVariable("id") Integer id) {
        Campaign campaign = CampaignRepo.findById(id).get();
        campaign.setStatus("approved");
        CampaignRepo.save(campaign);
        return CampaignRepo.save(campaign);
    }

}
