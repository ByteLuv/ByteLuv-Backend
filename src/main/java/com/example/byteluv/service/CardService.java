package com.example.byteluv.service;

import com.example.byteluv.pojo.Card;
import com.example.byteluv.pojo.CardDecoration;

/**
 * @Author MrWang98
 * @Date 2021/9/22 14:58
 **/
public interface CardService {
    public Card getCardByUId(Integer uid);
    public Card getCardByCId(Integer cid);
    public CardDecoration getCardDecByCId(Integer cid);
}
