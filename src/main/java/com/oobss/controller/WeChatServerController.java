package com.oobss.controller;

import com.oobss.common.util.MessageUtil;
import com.oobss.common.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author clark
 */
@RestController
public class WeChatServerController {
    @GetMapping("/")
    public String checkSignature(@RequestParam String signature,
                                 @RequestParam String timestamp,
                                 @RequestParam String nonce,
                                 @RequestParam String echostr){
        return echostr;
    }
    @PostMapping("/")
    public void msg(HttpServletRequest request,HttpServletResponse response){
        System.out.println("这是 post 方法！");
        try{
            Map<String, String> map=MessageUtil.parseXml(request);
            map.forEach((a,b)->{
                System.out.println(a+" : "+b);
            });
            System.out.println("============================="+map.get("Content"));
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
