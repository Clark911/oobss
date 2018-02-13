package com.oobss.controller;

import com.oobss.common.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
