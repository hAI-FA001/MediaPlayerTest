package ThreadTest;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //create this to execute threads
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //submit our thread and store it in a Future
        Future<String> future = executorService.submit(new Thread1());
        //this stops execution in main thread
        //until the thread in Future is done
        //and returns the value from call() method
        System.out.println(future.get());
        //need to shut down the threads we made or else they will keep running
        executorService.shutdown();
        System.out.println("END OF MAIN");
    }
}
