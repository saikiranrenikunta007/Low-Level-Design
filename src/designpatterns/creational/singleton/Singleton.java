package designpatterns.creational.singleton;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                try {
                    Thread.sleep(100); // Intentional delay to increase race condition likelihood
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (instance == null) instance = new Singleton();
            }

        }
        System.out.println("hashCode :: " + instance.hashCode());
        return instance;
    }

    public static void main(String[] args) {
        Singleton.getInstance();
        Singleton.getInstance();


        int numberOfThreads = 100; // Number of threads to simulate

        // Create a thread pool with 100 threads
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            executorService.submit(() -> {
                Singleton.getInstance();
            });
        }
    }

    /**
     *  This is thread safe but because of synchronized block
     * we will use double check here other wise it might create multiple instances
     * Scenario when multiple instances will create :
     *
     * Let us take thread A and thread B
     * Both are hitting get Instance method but B entered the block when A already instantiated the object and released
     * the lock now B will be able to create the new instance.
     */
}

