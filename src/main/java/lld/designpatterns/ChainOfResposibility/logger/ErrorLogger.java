package lld.designpatterns.ChainOfResposibility.logger;

public class ErrorLogger extends Logger{

    public ErrorLogger(Logger nextLogger) {
        super(Logger.ERROR, nextLogger);
    }

    @Override
    public void message(int level, String msg) {
        if(level>=super.level){
            System.out.println("severity: Error, message: " + msg);
        }
        if(super.nextLogger!=null){
            nextLogger.message(level, msg);
        }
    }
}
