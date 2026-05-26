package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateCheckResponse {
    private boolean updateAvailable;
    private String latestVersion;
    private String updateType;
    private String changelog;
    private String message;
}
