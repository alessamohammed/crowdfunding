package com.example.crowdfunding.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "anonymous_donors")
public class AnonymousDonor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Nullable
    private String name;
    private String ip;
}
