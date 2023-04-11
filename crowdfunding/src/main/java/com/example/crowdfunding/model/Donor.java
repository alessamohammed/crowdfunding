package com.example.crowdfunding.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "donors")
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String address;
}
