package com.mnb.shedulerservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    @JsonProperty("user_id")
    private UUID userId;

    @Column(nullable = false, name = "user_name")
    @JsonProperty("user_name")
    private String userName;

    @Column(columnDefinition = "TEXT", name = "user_password")
    @JsonProperty("user_password")
    private String userPassword;

    @Column(nullable = false, name = "user_email")
    @JsonProperty("user_email")
    private String userEmail;

    @Column(nullable = false, name = "user_role")
    @JsonProperty("user_role")
    private List<String> userRole;
}
