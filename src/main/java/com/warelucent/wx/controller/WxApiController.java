package com.warelucent.wx.controller;


import com.warelucent.wx.config.wxsettings.WxConstant;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tool.HttpServletRequestTool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;


@RestController
@RequestMapping(value = "/api/wx")
public class WxApiController {

    private static final Logger logger = Logger.getLogger(WxApiController.class);

    @RequestMapping(value = "/code")
    public void getWxCode(HttpServletRequest request, HttpServletResponse response) {
        String codeDomainUrl = WxConstant.CODE_DOMAIN_URL;
        String basePath = HttpServletRequestTool.getURLPath(request);
        try {
            String appID = WxConstant.APPID;
            String scope = WxConstant.SNS_AUTH_TYPE;
            String redirectUri = basePath + "api/wx/openid";
            String encode_redirectUri = URLEncoder.encode(redirectUri, "utf-8");
            codeDomainUrl = codeDomainUrl.replace("APP_ID", appID);
            codeDomainUrl = codeDomainUrl.replace("SCOPE", scope);
            codeDomainUrl = codeDomainUrl.replace("REDIRECT_URI", encode_redirectUri);
            logger.info(codeDomainUrl);
            response.sendRedirect(redirectUri);
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }

    }

    @RequestMapping(value = "/openid")
    public void setWxOpenID(@RequestParam(value = "code") String code) {

    }

}
