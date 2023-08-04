package threadtest02;


import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

    private static final int CORE_POOL_SIZR = 3;
    private static final int MAX_POOL_SIZE = 5;
    private static final int QUEUE_CAPACITY = 2;
    private static final Long KEEP_ALIVE_TIME = 0L;

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZR,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 5; i++) {
            executor.submit( () -> {
                while (true) {
                    Date d = new Date();
                    System.out.println(Thread.currentThread().getName() + "的时间为" + d);
                    Thread.sleep(1000);
                }
            });
        }
    }
}
