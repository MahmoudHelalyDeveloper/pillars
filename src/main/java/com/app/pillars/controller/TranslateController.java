package com.app.pillars.controller;

import com.app.pillars.model.Translate;
import com.app.pillars.service.user.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/translate")
public class TranslateController {

    @Autowired
    private TranslateService translateService;

    @GetMapping("all")
    public ResponseEntity<List<Translate>> getTranslationByLang( @RequestParam("lang") String lang){
        List<Translate> translates = this.translateService.translateAllByLang(lang);
        return new ResponseEntity<>(translates, HttpStatus.OK);
    }

    @GetMapping("transalteWord")
    public ResponseEntity<List<Translate>> getTranslationByLangAndWord( @RequestParam("lang") String lang,@RequestParam("word") String word){
        List<Translate> translates = this.translateService.translateAllByLangAndWord(lang,word);
        return new ResponseEntity<>(translates, HttpStatus.OK);
    }

}
