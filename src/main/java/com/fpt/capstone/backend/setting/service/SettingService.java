package com.fpt.capstone.backend.setting.service;

import com.fpt.capstone.backend.setting.dto.SettingsDTO;
import com.fpt.capstone.backend.setting.entity.Settings;
import com.fpt.capstone.backend.setting.repository.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingService {


    @Autowired
    private SettingsRepository settingsRepository;

    public List<Settings> getTypeSetting() {
        return settingsRepository.getTypeSeting();
    }

    public Page<SettingsDTO> getSetingByType(int id, int page, int per_page) {
        Pageable pageable = PageRequest.of(page - 1, per_page);
        return settingsRepository.getSetingByType(id, pageable);
    }
}
