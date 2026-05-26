package com.example.demo.service;

import com.example.demo.dto.UpdateCheckResponse;
import com.example.demo.entity.AppVersion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCheckService {

    private final AppVersionService appVersionService;

    public UpdateCheckResponse checkUpdate(String userId, String currentVersion, String platform) {
        AppVersion latest = appVersionService.getLatestVersion(platform);
        boolean needUpdate = !latest.getVersion().equals(currentVersion);
        String message = needUpdate ? "New version available!" : "You are on the latest version";
        return new UpdateCheckResponse(
                needUpdate,
                latest.getVersion(),
                latest.getUpdateType(),
                latest.getChangelog(),
                message
        );
    }
}
