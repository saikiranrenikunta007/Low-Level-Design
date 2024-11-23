package designpatterns.creational.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;
    private ThreadSafeSingleton() {
    }
    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            try {
                Thread.sleep(100); // Intentional delay to increase race condition likelihood
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new ThreadSafeSingleton();
        }
        System.out.println("hashCode :: "+instance.hashCode());
        return instance;
    }

    public static void main(String[] args) {
       ThreadSafeSingleton.getInstance();
       ThreadSafeSingleton.getInstance();


        int numberOfThreads = 10000; // Number of threads to simulate

        // Create a thread pool with 100 threads
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            executorService.submit(() -> {
                Singleton.getInstance();
            });
        }
    }

    /**
     *  This is thread safe but because of synchronized
     *  it will block the thread to access method
     *  so there will be poor performance
     */
}
