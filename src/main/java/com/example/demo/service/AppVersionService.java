package com.example.demo.service;

import com.example.demo.dto.AppVersionDTO;
import com.example.demo.entity.AppVersion;
import com.example.demo.repository.AppVersionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AppVersionService {

    private final AppVersionRepository appVersionRepository;

    public AppVersion addVersion(AppVersionDTO dto) {
        AppVersion version = new AppVersion();
        version.setVersion(dto.getVersion());
        version.setPlatform(dto.getPlatform());
        version.setReleaseDate(dto.getReleaseDate() != null ? dto.getReleaseDate() : LocalDateTime.now());
        version.setChangelog(dto.getChangelog());
        version.setUpdateType(dto.getUpdateType());
        version.setActive(true);
        return appVersionRepository.save(version);
    }

    public AppVersion getLatestVersion(String platform) {
        return appVersionRepository.findTopByPlatformAndIsActiveTrueOrderByReleaseDateDesc(platform)
                .orElseThrow(() -> new RuntimeException("No version found for platform: " + platform));
    }
}
