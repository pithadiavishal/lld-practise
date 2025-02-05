package lld.designpatterns.ChainOfResposibility.logger;

public abstract class Logger {
    public static int INFO = 1;
    public static int WARN = 2;
    public static int ERROR = 3;
    protected final int level;
    protected final Logger nextLogger;
    public Logger(int level, Logger nextLogger){
        this.level = level;
        this.nextLogger = nextLogger;
    }
    public abstract void message(int level, String msg);
}
