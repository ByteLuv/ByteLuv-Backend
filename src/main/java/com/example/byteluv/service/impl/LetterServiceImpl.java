package com.example.byteluv.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.byteluv.mappers.LoveLetterMapper;
import com.example.byteluv.pojo.LoveLetter;
import com.example.byteluv.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author MrWang98
 * @Date 2021/11/28 0:08
 **/
@Service
public class LetterServiceImpl implements LetterService {

    @Autowired
    LoveLetterMapper loveLetterMapper;
    @Override
    public Boolean addLoveLetterByUid(Integer uid, LoveLetter loveLetter) {
        try{
            Integer id = loveLetterMapper.insert(loveLetter);
            System.out.println(loveLetter.getId());
        }catch (Exception e){
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    @Override
    public Boolean updateLoveLetterById(LoveLetter loveLetter) {
        try{
            loveLetterMapper.updateById(loveLetter);
        }catch (Exception e){
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteLoveLetterById(Integer id) {
        try{
            loveLetterMapper.delete(new QueryWrapper<LoveLetter>().eq("id",id));
        }catch (Exception e){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public List<LoveLetter> getLoveLetterByUid(Integer uid) {
        List<LoveLetter> loveLetterList = null;
        try{
            loveLetterList = loveLetterMapper.selectList(new QueryWrapper<LoveLetter>().eq("uid",uid));
        }catch (Exception e){
            return loveLetterList;
        }

        return loveLetterList;
    }
}
