package com.jdemo.apiversion;

import com.jdemo.apiversion.base.ApiVersion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 与位置服务组件相关接口
 * @Author SKIES
 * @Date 2023/8/2 17:41
 */
@RestController
@RequestMapping("{version}/device")
@ApiVersion("1.0")
@Slf4j
public class UseDemoController {
    @GetMapping("/test")
    public String test() {
        return "version1";
    }
}
