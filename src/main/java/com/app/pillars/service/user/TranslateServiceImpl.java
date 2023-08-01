package com.app.pillars.service.user;

import com.app.pillars.model.Translate;
import com.app.pillars.repo.TranslateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TranslateServiceImpl extends  TranslateService{

    @Autowired
    private TranslateRepo translateRepo;
    @Override
    public List<Translate> translateAllByLang(String key) {
        List<Translate> byKey = this.translateRepo.findByLang(key);
        return byKey;
    }

    @Override
    public List<Translate> translateAllByLangAndWord(String key,String word) {
        List<Translate> byKeyAndWord = this.translateRepo.findByLangAndWord(key, word);

        return byKeyAndWord;
    }

    @Override
    public List<Translate> findByLangAndWordAndValue(String key, String word, String value) {
      return   this.translateRepo.findByLangAndWordAndValue(key,word,value);
    }
}
