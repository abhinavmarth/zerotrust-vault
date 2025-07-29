package com.project.zerotrust.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ZeroTrustModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String username;

    @Column(name = "password_encrypted")
    private String password;
    @Column(name = "user_id")
    private String userId;

    private String notes;
    private Long createdAt; // Epoch timestamp

    private Long updatedAt;
}
