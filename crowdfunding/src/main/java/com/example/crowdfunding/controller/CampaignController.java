package com.example.crowdfunding.controller;

import com.example.crowdfunding.model.Campaign;
import com.example.crowdfunding.model.CampaignRequest;
import com.example.crowdfunding.repository.CampaignRepo;
import com.example.crowdfunding.repository.CampaignRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/campaign")
public class CampaignController {
    @Autowired
    private CampaignRepo CampaignRepo;
    private CampaignRequestRepo CampaignRequestRepo;

    public CampaignController(CampaignRepo CampaignRepo, CampaignRequestRepo CampaignRequestRepo) {
        this.CampaignRepo = CampaignRepo;
        this.CampaignRequestRepo = CampaignRequestRepo;
    }

    @GetMapping("/all")
    public Iterable<Campaign> getAllCampaigns() {
        return CampaignRepo.findAll();
    }

    @GetMapping("/{id}")
    public Campaign getCampaignById(@PathVariable("id") Integer id) {
        return CampaignRepo.findById(id).get();
    }

    @PostMapping("/add")
    public Campaign addCampaign(@RequestBody Campaign campaign) {
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

    // add campaign request
    @PostMapping("/addRequest")
    public CampaignRequest addCampaignRequest(@RequestBody CampaignRequest campaignRequest) {
        return CampaignRequestRepo.save(campaignRequest);
    }

    @DeleteMapping("/deleteRequest/{id}")
    public void deleteCampaignRequest(@PathVariable("id") Integer id) {
        CampaignRequestRepo.deleteById(id);
    }

    @PutMapping("/disapprove/{id}")
    public CampaignRequest disapproveCampaignRequest(@PathVariable("id") Integer id) {
        CampaignRequest campaignRequest = CampaignRequestRepo.findById(id).get();
        campaignRequest.setStatus("disapproved");
        CampaignRequestRepo.save(campaignRequest);
        return CampaignRequestRepo.save(campaignRequest);
    }

    @PutMapping("/approve/{id}")
    public CampaignRequest approveCampaignRequest(@PathVariable("id") Integer id) {
        CampaignRequest campaignRequest = CampaignRequestRepo.findById(id).get();
        campaignRequest.setStatus("approved");
        CampaignRequestRepo.save(campaignRequest);
        return CampaignRequestRepo.save(campaignRequest);
    }

}
