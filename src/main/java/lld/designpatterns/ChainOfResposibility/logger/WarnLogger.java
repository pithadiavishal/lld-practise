package lld.designpatterns.ChainOfResposibility.logger;

public class WarnLogger extends Logger{

    public WarnLogger(Logger nextLogger) {
        super(Logger.WARN, nextLogger);
    }

    @Override
    public void message(int level, String msg) {
        if(level>=super.level){
            System.out.println("severity: Warn, message: " + msg);
        }
        if(super.nextLogger!=null){
            nextLogger.message(level, msg);
        }
    }
}
