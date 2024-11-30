package src.designpatterns.behavioural.command;


interface Command {
    void execute();
}

class Tv {

    public void on() {
        System.out.println("Tv on");
    }
    public void off() {
        System.out.println("Tv off");
    }
    public void volumeUp() {
        System.out.println("volume up");
    }
    public void volumeDown() {
        System.out.println("volume down");
    }
}

class TvOnCommand implements Command{

    private final Tv tv;
    TvOnCommand(Tv tv){
        this.tv = tv;
    }
    @Override
    public void execute() {
        tv.on();
    }
}
class TvOFFCommand implements  Command{
    private final Tv tv;

    TvOFFCommand(Tv tv){
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }
}
class VolumeUpCommand implements Command{

    private final Tv tv;

    VolumeUpCommand(Tv tv){
        this.tv = tv;
    }
    @Override
    public void execute() {
        tv.volumeUp();
    }
}
class VolumeDownCommand implements Command{

    private final Tv tv;

    VolumeDownCommand(Tv tv){
        this.tv = tv;
    }
    @Override
    public void execute() {
        tv.volumeDown();
    }
}
class RemoteControl {

    Command button1;
    Command button2;

    Command button3;
    Command button4;

    public Command getButton1() {
        return button1;
    }

    public void setButton1(Command button1) {
        this.button1 = button1;
    }

    public Command getButton2() {
        return button2;
    }

    public void setButton2(Command button2) {
        this.button2 = button2;
    }

    public Command getButton3() {
        return button3;
    }

    public void setButton3(Command button3) {
        this.button3 = button3;
    }

    public Command getButton4() {
        return button4;
    }

    public void setButton4(Command button4) {
        this.button4 = button4;
    }
    public void pressButton1() {
        this.getButton1().execute();
    }
    public void pressButton2() {
        this.getButton2().execute();
    }
    public void pressButton3() {
        this.getButton3().execute();
    }
    public void pressButton4() {
        this.getButton4().execute();
    }



}

public class Main {
    public static void main(String[] args) {
       RemoteControl control = new RemoteControl();
       Tv tv = new Tv();
       control.setButton1(new TvOnCommand(tv));
       control.setButton2(new TvOFFCommand(tv));
       control.setButton3(new VolumeDownCommand(tv));
       control.setButton4(new VolumeUpCommand(tv));
       control.pressButton1();
       control.pressButton2();
       control.pressButton3();
       control.pressButton4();
    }
}


