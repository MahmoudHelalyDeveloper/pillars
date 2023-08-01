package com.app.pillars.configure.jwt;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static com.app.pillars.util.Constant.langApp;

@Component
@Scope("session")
public class CustomValueFilterArabic {


    private String lang;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public boolean equals(Object other) {


        String a = (String) other;
        if (langApp.equals( "ar")) {

            return false;
        }
        return a == a;
    }
}
