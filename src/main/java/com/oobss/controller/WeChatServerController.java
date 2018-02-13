package com.oobss.controller;

import com.oobss.common.util.Result;
import org.springframework.web.bind.annotation.*;

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
    public String msg(@RequestBody Object xml){
        return "http://task.oobss.com";
    }
}
