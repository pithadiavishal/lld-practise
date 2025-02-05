package lld.designpatterns.ChainOfResposibility.logger;

public class InfoLogger extends Logger{

    public InfoLogger(Logger nextLogger) {
        super(Logger.INFO, nextLogger);
    }

    @Override
    public void message(int level, String msg) {
        if(level>=super.level){
            System.out.println("severity: Info, message: " + msg);
        }
        if(super.nextLogger!=null){
            nextLogger.message(level, msg);
        }
    }
}
