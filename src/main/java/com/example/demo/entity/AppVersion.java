package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "app_versions")
@Data
public class AppVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String version;

    @Column(nullable = false)
    private String platform;   // "android", "ios", "windows"

    private LocalDateTime releaseDate;

    @Column(length = 5000)
    private String changelog;

    @Column(nullable = false)
    private String updateType; // MANDATORY, OPTIONAL, DEPRECATED

    private boolean isActive = true;
}

