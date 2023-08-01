package com.app.pillars.repo;

import com.app.pillars.model.Translate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TranslateRepo extends JpaRepository< Translate,Integer> {

    public List<Translate> findByLang(String lang);

    public List<Translate> findByLangAndWord(String lang,String word);

    public List<Translate> findByLangAndWordAndValue(String lang,String word,String value);


}
