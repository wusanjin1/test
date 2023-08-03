package com.yc.jdkproxy;

public class Test2 {
    public static void main(String[] args) {
        //设置代理生成的字节码 保存到当前目录
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        JdkProxyTool jp = new JdkProxyTool(new OrderBizImpl());
        OrderBiz ob = (OrderBiz) jp.createProxy();
//        System.out.println("生成代理类对象:" + ob.toString());

        ob.findOrder();
        ob.addOrder(1,99);
    }
}
