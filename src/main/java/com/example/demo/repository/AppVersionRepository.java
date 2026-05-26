package com.example.demo.repository;

import com.example.demo.entity.AppVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface AppVersionRepository extends JpaRepository<AppVersion, Long> {
    Optional<AppVersion> findTopByPlatformAndIsActiveTrueOrderByReleaseDateDesc(String platform);
    List<AppVersion> findByPlatformAndIsActiveTrueOrderByReleaseDateDesc(String platform);
    boolean existsByVersionAndPlatform(String version, String platform);
}
