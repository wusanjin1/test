package threadtest01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        for(int i = 0; i <5; i++) {
            Task t = new Task();
            Thread td = new Thread(t);
            td.start();
        }
    }
}

class Task implements Runnable{
    boolean flag = true;
    @Override
    public void run() {
        while (flag) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Date d = new Date();
            DateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            String s = df.format(d);
            System.out.println("线程名:" + Thread.currentThread().getName() + "时间:" + s);
        }

    }
}
