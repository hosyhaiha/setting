package com.fpt.capstone.backend.setting.repository;

import com.fpt.capstone.backend.setting.dto.SettingsDTO;
import com.fpt.capstone.backend.setting.entity.Settings;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SettingsRepository extends JpaRepository<Settings, Integer> {
    @Query("SELECT s FROM Settings s WHERE s.typeId = 1")
    public List<Settings> getTypeSeting();

    @Query("SELECT new com.fpt.capstone.backend.setting.dto.SettingsDTO( s1.id, s1.typeId, s2.value , s1.value" +
            ", s1.displayOrder, s1.status, s1.created, s1.createdBy, s1.modified, s1.modifiedBy) FROM Settings s1 " +
            "JOIN Settings s2 ON s1.typeId = s2.id " +
            "WHERE s2.id = ?1")
    public Page<SettingsDTO> getSetingByType(int id, Pageable pageable);


}
