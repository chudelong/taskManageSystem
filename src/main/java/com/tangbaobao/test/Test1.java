package com.tangbaobao.test;

import org.junit.Test;

/**
 * 测试
 *
 * @author 唐学俊
 * @create 2018/02/20
 **/

public class Test1 {
    @Test
    public void fun1(){
        String str = "2015214326";
        String substring = str.substring(0, 4);
        System.out.println(substring);
    }
}
