package com.example.demo.repository;

import com.example.demo.entity.UserDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface UserDeviceRepository extends JpaRepository<UserDevice, Long> {
    Optional<UserDevice> findByUserIdAndPlatform(String userId, String platform);
    List<UserDevice> findByCurrentVersion(String version);
}
