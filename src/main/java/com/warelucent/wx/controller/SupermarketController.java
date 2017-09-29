package com.warelucent.wx.controller;

import com.warelucent.wx.domain.SignDayEntity;
import com.warelucent.wx.service.SupermarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class SupermarketController {

    @Autowired
    private SupermarketService supermarketService;

    @RequestMapping(value = "/sign/{openid}/days", method = RequestMethod.GET)
    public List<SignDayEntity> querySignDays(@PathVariable("openid") String openid) {
        return supermarketService.querySignDays(openid);
    }

}
