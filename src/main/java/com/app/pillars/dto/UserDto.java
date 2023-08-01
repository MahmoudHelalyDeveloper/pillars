package com.app.pillars.dto;

import com.app.pillars.configure.jwt.CustomValueFilterArabic;
import com.app.pillars.configure.jwt.CustomValueFilterEnglish;
import com.fasterxml.jackson.annotation.JsonInclude;

public interface UserDto {

    int getId();

    String getPassword();

    String getUserName();

    String getCreatedName();
    @JsonInclude(value = JsonInclude.Include.CUSTOM,
            valueFilter = CustomValueFilterEnglish.class)

    String getGenderEn();
    @JsonInclude(value = JsonInclude.Include.CUSTOM,
            valueFilter = CustomValueFilterArabic.class)
    String getGenderAr();

    String geGenderName();

    String getUpdatedName();

}
