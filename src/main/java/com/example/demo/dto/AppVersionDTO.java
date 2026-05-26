package com.example.demo.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AppVersionDTO {
    private String version;
    private String platform;
    private LocalDateTime releaseDate;
    private String changelog;
    private String updateType;
}