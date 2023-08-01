package com.app.pillars.service.user;

import com.app.pillars.model.Translate;

import java.util.List;

public abstract class TranslateService {

    public abstract List<Translate> translateAllByLang(String key);
    public abstract List<Translate> translateAllByLangAndWord(String key,String word);

    public abstract List<Translate> findByLangAndWordAndValue(String key,String word,String value);



}
