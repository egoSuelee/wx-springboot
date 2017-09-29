package com.warelucent.wx.service.impl;

import com.warelucent.wx.dao.supermarket.SupermarketDao;
import com.warelucent.wx.domain.SignDayEntity;
import com.warelucent.wx.service.SupermarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupermarketServiceImpl implements SupermarketService {

    @Autowired
    private SupermarketDao supermarketDao;

    @Override
    public List<SignDayEntity> querySignDays(String openid) {

        List<SignDayEntity> signDayEntities = supermarketDao.querySignDays(openid);
        return signDayEntities;
    }
}
