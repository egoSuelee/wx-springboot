package com.warelucent.wx.dao.supermarket;

import com.warelucent.wx.domain.SignDayEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupermarketDao {

    List<SignDayEntity> querySignDays(@Param("openid") String openid);

}
