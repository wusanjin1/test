package com.yc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.ycframework.context.YcAnnotationConfigApplicationContext;
import org.ycframework.context.YcApplicationContext;

public class TestMain2 {
    public static void main(String[] args) {
//        Logger logger= LoggerFactory.getLogger(TestMain2.class);
//        logger.error("error");
//        logger.warn("warn");
//        logger.info("info");
//        logger.debug("debug");
//        logger.trace("trace");

        YcApplicationContext ac=new YcAnnotationConfigApplicationContext(MyConfig.class);
//        UserBiz ub=(UserBiz) ac.getBean("userBizImpl");
//        ub.add("张三");
    }
}
