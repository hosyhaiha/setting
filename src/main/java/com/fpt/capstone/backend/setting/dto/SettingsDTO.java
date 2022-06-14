package com.fpt.capstone.backend.setting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class SettingsDTO {
    private Integer id;
    private Integer typeId;
    private String title;
    private String value;
    private Byte displayOrder;
    private String status;
    private java.sql.Timestamp created;
    private Integer createdBy;
    private java.sql.Timestamp modified;
    private Integer modifiedBy;
}
