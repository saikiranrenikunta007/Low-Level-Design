package src.designpatterns.behavioural.cor;


enum LogLevel {
    INFO(1),
    ERROR(2),
    DEBUG(3);

    private final int level;
    LogLevel(int level) {
        this.level = level;
    }

    public int getLevel(){
        return this.level;
    }
}

abstract class Logger {

    private LogLevel logLevel;

    Logger(LogLevel level){
        this.logLevel = level;
    }

    private Logger next;

    public void log(LogLevel logLevel,String message){

        if(this.logLevel.getLevel() <= logLevel.getLevel()){
           write(message);
        }
        if(this.next != null)
            this.next.log(logLevel,message);
    }
    public abstract void write(String message);

    public void setNext(Logger next){
        this.next = next;
    }
}

class InfoLogger extends Logger{
    InfoLogger() {
        super(LogLevel.INFO);
    }
    @Override
    public void write(String message) {
        System.out.println("INFO: " + message);
    }
}
class ErrorLogger extends Logger {

    ErrorLogger() {
        super(LogLevel.ERROR);
    }

    @Override
    public void write(String message){
        System.out.println("ERROR: "+message);
    }
}
class DebugLogger extends Logger{
    DebugLogger() {
        super(LogLevel.DEBUG);
    }

    @Override
    public void write(String messsage){
        System.out.println("DEBUG: "+messsage);
    }
}

class LoggerFactory {

    private static Logger logger;

    private LoggerFactory() {}

    public static Logger getLogger() {
            if(logger == null) {

                synchronized (LoggerFactory.class){
                    if(logger == null){
                        logger = createChain();
                    }
                }


            }
            return logger;
    }

    private static Logger createChain() {
        Logger infoLogger = new InfoLogger();
        Logger errorLogger = new ErrorLogger();
        Logger debugLogger = new DebugLogger();

        infoLogger.setNext(errorLogger);
        errorLogger.setNext(debugLogger);
        return infoLogger;
    }

}
public class ChainOfResponsibilty {



    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger();
        logger.log(LogLevel.DEBUG,"this is a message");
    }

}
