package com.example.crowdfunding.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "universities")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String bio;

}
