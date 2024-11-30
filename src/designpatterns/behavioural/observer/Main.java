package src.designpatterns.behavioural.observer;


import java.util.ArrayList;
import java.util.List;

class Subject{

    List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer){
        observers.add(observer);
    }
    public void unregisterObserver(Observer observer){
        observers.remove(observer);
    }
    public void notifyObservers(String news){

        for(Observer observer : observers){
            observer.update(news);
        }
    }
    public void publishNews(String news){

        System.out.println("publishing news");
        notifyObservers(news);
    }
}
interface Observer {
    void update(String news);
}

class EmailObserver implements Observer{

    @Override
    public void update(String news) {
        System.out.println("updating Email Feed with news : "+news);
    }
}

class RssFeedObserver implements Observer{

    @Override
    public void update(String news) {
        System.out.println("RssFeedObserver with news : "+news);
    }
}

public class Main {
    public static void main(String[] args) {

        Subject subject = new Subject();

        Observer emailObserver = new EmailObserver();
        Observer rssFeedObserver = new RssFeedObserver();

        subject.registerObserver(emailObserver);
        subject.registerObserver(rssFeedObserver);

        subject.publishNews("Breaking news : stock market crash");
    }
}
