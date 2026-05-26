package com.example.demo.controller;

import com.example.demo.dto.AppVersionDTO;
import com.example.demo.dto.UpdateCheckResponse;
import com.example.demo.entity.AppVersion;
import com.example.demo.service.AppVersionService;
import com.example.demo.service.UpdateCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class VersionController {

    private final AppVersionService versionService;
    private final UpdateCheckService updateCheckService;   // добавлено

    @PostMapping("/versions")
    public AppVersion addVersion(@RequestBody AppVersionDTO dto) {
        return versionService.addVersion(dto);
    }

    @GetMapping("/versions/latest")
    public AppVersion getLatest(@RequestParam String platform) {
        return versionService.getLatestVersion(platform);
    }

    // Новый эндпоинт: проверка обновления
    @GetMapping("/update/check")
    public UpdateCheckResponse checkUpdate(
            @RequestParam String userId,
            @RequestParam String current,
            @RequestParam String platform) {
        // userId пока не используется, но можно передать для логирования
        return updateCheckService.checkUpdate(userId, current, platform);
    }
}