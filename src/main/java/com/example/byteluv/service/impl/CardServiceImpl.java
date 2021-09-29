package com.example.byteluv.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.byteluv.mappers.CardDecorationMapper;
import com.example.byteluv.mappers.CardMapper;
import com.example.byteluv.pojo.Card;
import com.example.byteluv.pojo.CardDecoration;
import com.example.byteluv.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author MrWang98
 * @Date 2021/9/29 10:24
 **/
@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardMapper cardMapper;
    @Autowired
    CardDecorationMapper cardDecorationMapper;

    @Override
    public Card getCardByUId(Integer uid) {
        Card card = null;
        card = cardMapper.selectOne(new QueryWrapper<Card>().eq("uid",uid));
        return card;
    }

    @Override
    public Card getCardByCId(Integer cid) {
        Card card = null;
        card = cardMapper.selectOne(new QueryWrapper<Card>().eq("id",cid));
        return card;
    }

    @Override
    public CardDecoration getCardDecByCId(Integer cid) {
        CardDecoration cardDecoration = null;
        cardDecoration = cardDecorationMapper.selectOne(new QueryWrapper<CardDecoration>().eq("cid",cid));
        return cardDecoration;
    }
}
