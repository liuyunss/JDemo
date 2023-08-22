package com.jdemo.transfor;

import com.jdemo.transfor.bean.Demo;
import org.junit.Test;

import java.util.Date;

/**
 * 类描述.
 *
 * @author SKIES
 * @date 2023-04-07 18:32
 */
public class StringToDateTest {

    @Test
    public void testDate(){
        Demo demo = new Demo();
        demo.setDateTime1(new Date());
        demo.setDateTime2(new Date());
        demo.setDateTime3(new Date());
        demo.setDateTime4(new Date());
        System.out.println(demo.toString());
    }

}
