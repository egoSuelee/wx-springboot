package com.warelucent.wx.config.wxsettings;

public class WxConstant {

    /**
     * #华隆微信配置
     * #APP_ID = wx7a16caec7c2d6bd8
     * #APP_SECRET = 9a81f95779a47b1784d9d46e46cdad39
     * <p>
     * #香江百货微信配置
     * APP_ID = wxc3cae8e5a448c886
     * APP_SECRET = 9a37458a190ad905b180877b309521db
     */

    public static final String APPID = "wx7a16caec7c2d6bd8";

    public static final String APPSECRET = "9a81f95779a47b1784d9d46e46cdad39";


    /**
     * scope:应用授权作用域
     * 　snsapi_base:不弹出授权页面，直接跳转，只能获取用户openid
     * 　snsapi_userinfo:弹出授权页面，可通过openid拿到昵称、性别、所在地
     */

    public static final String SNS_AUTH_TYPE = "snsapi_base";


    /**
     * (1)注册送的积分 (2) 绑定会员送的积分 (3)签到送的积分
     */
    public static final int REGISTER_GIFT_POINTS = 50;

    public static final int BIND_GIFT_POINTS = 10;

    public static final int SIGN_GIFT_POINTS = 10;


    /**
     * 微信的访问接口URL
     */
    public static final String CODE_DOMAIN_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APP_ID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";




}
