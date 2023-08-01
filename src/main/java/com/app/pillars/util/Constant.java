package com.app.pillars.util;

public class Constant {
    public abstract class TokenConstant {
        public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 1000 * 60 * 60  *10;//10 hours
        public static final String SIGNING_KEY = "secretkeySSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS";
        public static final String TOKEN_PREFIX = "Bearer ";
        public static final String HEADER_STRING = "Authorization";

    }
    public static String langApp="fr";
    public static String setLang(String lang){
        langApp=lang;
        return langApp;
    }
}

