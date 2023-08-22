package com.jdemo.apiversion.base;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @Description 版本号筛选，将提取请求URL中版本号，
 * 与注解上定义的版本号进行比对，以此来判断某个请求应落在哪个controller上
 * @Author SKIES
 * @Date 2023/8/2 17:49
 */
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {
    private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile(".*v(\\d[.]\\d+).*");

    private String apiVersion;

    ApiVersionCondition(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    private String getApiVersion() {
        return apiVersion;
    }


    @Override
    public ApiVersionCondition combine(ApiVersionCondition apiVersionCondition) {
        return new ApiVersionCondition(apiVersionCondition.getApiVersion());
    }

    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest httpServletRequest) {
        Matcher m = VERSION_PREFIX_PATTERN.matcher(httpServletRequest.getRequestURI());
        if (m.find()) {
            String version = m.group(1);
            if (version.compareTo(this.apiVersion) >= 0) {
                return this;
            }
        }
        return null;
    }

    @Override
    public int compareTo(ApiVersionCondition apiVersionCondition, HttpServletRequest httpServletRequest) {
        return apiVersionCondition.getApiVersion().compareTo(this.apiVersion);
    }

    public static void main(String[] args) {
        System.out.println("1.0".compareTo("2.0"));
    }
}
