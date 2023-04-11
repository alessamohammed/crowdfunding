package com.example.crowdfunding.controller;

import com.example.crowdfunding.repository.CampaignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.crowdfunding.repository.CampaignRequestRepo;
import com.example.crowdfunding.model.CampaignRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/campaignRequest")
public class CampaignRequestController {

    @Autowired
    private CampaignRequestRepo CampaignRequestRepo;
    private CampaignRepo CampaignRepo;

    public CampaignRequestController(CampaignRequestRepo CampaignRequestRepo) {
        this.CampaignRequestRepo = CampaignRequestRepo;
    }

    @GetMapping("/all")
    public Iterable<CampaignRequest> getAllCampaignRequests() {
        return CampaignRequestRepo.findAll();
    }

    @GetMapping("/{id}")
    public CampaignRequest getCampaignRequestById(@PathVariable("id") Integer id) {
        return CampaignRequestRepo.findById(id).get();
    }

    @PostMapping("/add")
    public CampaignRequest addCampaignRequest(@RequestBody CampaignRequest campaignRequest) {
        return CampaignRequestRepo.save(campaignRequest);
    }

    @PutMapping("/update")
    public CampaignRequest updateCampaignRequest(@RequestBody CampaignRequest campaignRequest) {
        return CampaignRequestRepo.save(campaignRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCampaignRequest(@PathVariable("id") Integer id) {
        CampaignRequestRepo.deleteById(id);
    }

    // approve campaign request
    @PutMapping("/approve/{id}")
    public CampaignRequest approveCampaignRequest(@PathVariable("id") Integer id) {
        CampaignRequest campaignRequest = CampaignRequestRepo.findById(id).get();

        CampaignRequestRepo.deleteById(id);
        return CampaignRequestRepo.save(campaignRequest);
    }

}
