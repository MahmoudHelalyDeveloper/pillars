package com.app.pillars.configure.jwt;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static com.app.pillars.util.Constant.langApp;

@Component
@Scope("session")
public class CustomValueFilterEnglish {

    @Override
    public boolean equals(Object other) {


        String a = (String) other;
        if (langApp.equals( "en")) {

            return false;
        }
        return a == a;
    }
}
