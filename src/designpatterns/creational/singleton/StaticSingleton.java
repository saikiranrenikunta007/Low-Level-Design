package designpatterns.creational.singleton;

public class StaticSingleton {

    private static final StaticSingleton  singleton = new StaticSingleton();
    private StaticSingleton() {
    }
    public static StaticSingleton getInstance(){
        System.out.println("hashCode :: "+singleton.hashCode());
        return singleton;
    }

    public static void main(String[] args) {
        StaticSingleton.getInstance();
        StaticSingleton.getInstance();
    }
}

/**
 *    Here we are creating singleton instance at the loading of class and this is known as Eager Initialization.
 *
 *    Disadvantage :
 *
 *    1) Memory wastage condition : Even though when no one needs this singleton object we are creating it.
 */