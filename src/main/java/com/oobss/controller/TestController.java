package com.oobss.controller;

import com.oobss.common.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * Created by clarkzhao on 2017/12/29.
 *
 * @author clarkzhao
 * @date 2017/12/29
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/user")
    public Result currentUser() {
        Result result = new Result();
        result.setData(Collections.EMPTY_LIST);
        return result;
    }
}
