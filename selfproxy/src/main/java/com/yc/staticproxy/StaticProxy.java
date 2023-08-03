package com.yc.staticproxy;

public class StaticProxy implements OrderBiz {
    //目标类的引用，利用setXxx，或构造方法   注入
    private OrderBiz orderBiz;

    public StaticProxy(OrderBiz orderBiz) {
        this.orderBiz = orderBiz;
    }
    @Override
    public void addOrder(int pid, int num) {
        //前置增强
        showHello();
        this.orderBiz.addOrder(pid, num);
        //后置增强
        showBye();
    }

    //前置
    private void showHello() {
        System.out.println("hello");
    }

    //后置
    private void showBye() {
        System.out.println("bye");
    }
}
