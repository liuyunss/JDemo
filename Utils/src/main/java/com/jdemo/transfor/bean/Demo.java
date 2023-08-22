package com.jdemo.transfor.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 类描述.
 *
 * @author SKIES
 * @date 2023-04-07 18:26
 */
@Data
public class Demo {
    private String strTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dateTime1;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date dateTime2;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateTime3;
    @JsonFormat
    private Date dateTime4;
}
