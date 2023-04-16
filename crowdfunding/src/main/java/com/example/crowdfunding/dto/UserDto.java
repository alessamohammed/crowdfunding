package com.example.crowdfunding.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String token;

}
