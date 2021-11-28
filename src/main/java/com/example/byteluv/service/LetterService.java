package com.example.byteluv.service;

import com.example.byteluv.pojo.LoveLetter;

import java.util.List;

/**
 * @Author MrWang98
 * @Date 2021/11/28 0:06
 **/
public interface LetterService {
    public Boolean addLoveLetterByUid(Integer uid,LoveLetter loveLetter);
    public Boolean updateLoveLetterById(LoveLetter loveLetter);
    public Boolean deleteLoveLetterById(Integer id);
    public List<LoveLetter> getLoveLetterByUid(Integer uid);
}
