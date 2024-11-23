package src.designpatterns.creational.singleton;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LazyInitialization{

    private static LazyInitialization instance;
    private LazyInitialization() {
    }
    public static LazyInitialization getInstance(){
        if(instance == null){
            try {
                Thread.sleep(100); // Intentional delay to increase race condition likelihood
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new LazyInitialization();
        }
        System.out.println("hashCode :: "+instance.hashCode());
        return instance;
    }

    public static void main(String[] args) {
        LazyInitialization.getInstance();
        LazyInitialization.getInstance();


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
     *  This will initialize the object it is null.
     *  Disadvantage:
     *  This is not a thread safe so when two threads concurrently enters the getInstance()
     *  method both will check for instance == null so two threads get true which leads to
     *  creation of multiple instances.
     *
     */
}
