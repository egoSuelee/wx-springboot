package com.warelucent.wx.service;

import com.warelucent.wx.domain.SignDayEntity;

import java.util.List;

public interface SupermarketService {

    List<SignDayEntity> querySignDays(String openid);

}
