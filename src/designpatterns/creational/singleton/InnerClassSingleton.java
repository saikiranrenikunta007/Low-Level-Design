package src.designpatterns.creational.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InnerClassSingleton {
    private static InnerClassSingleton instance;

    private InnerClassSingleton() {
    }

    public static class SingletonHelper {

        public static InnerClassSingleton getInstance() {
            if(instance ==null) instance = new InnerClassSingleton();
            return instance;
        }
    }

    public static InnerClassSingleton getInstance() {
        InnerClassSingleton instance = SingletonHelper.getInstance();
        System.out.println("hashCode: "+instance.hashCode());
        return instance;
    }


    public static void main(String[] args) {
        InnerClassSingleton.getInstance();
        InnerClassSingleton.getInstance();


        int numberOfThreads = 10000; // Number of threads to simulate

        // Create a thread pool with 100 threads
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            executorService.submit(() -> {
                InnerClassSingleton.getInstance();
            });
        }
    }
}
