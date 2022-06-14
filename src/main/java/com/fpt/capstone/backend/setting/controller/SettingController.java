package com.fpt.capstone.backend.setting.controller;

import com.fpt.capstone.backend.setting.dto.SettingsDTO;
import com.fpt.capstone.backend.setting.entity.Settings;
import com.fpt.capstone.backend.setting.service.SettingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("setting")
public class SettingController {

    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private SettingService settingService;

    @GetMapping("/getType")
    public List<Settings> getType() {
        return settingService.getTypeSetting();
    }

    @GetMapping("/getSettingByType")
    public List<SettingsDTO> getSettingByTile(@RequestParam("key_id") int  key_id
            , @RequestParam("page") int page, @RequestParam("per_page") int per_page)
    {
        Page<SettingsDTO> settings = settingService.getSetingByType(key_id,page,per_page);
        List<SettingsDTO> settingsDTOS = Arrays.asList(modelMapper.map(settings.getContent(), SettingsDTO[].class));
        return settingsDTOS;
    }

}
