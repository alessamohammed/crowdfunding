package com.example.crowdfunding.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String bio;
    private String address;
    private String highSchool;
    private double gpa;
    private String major;
    private String year;
    private double gatScore;
    private double academicAchievementScore;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
