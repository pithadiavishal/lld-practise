package lld.designpatterns.ChainOfResposibility.logger;

public class LoggerApplication {
    public static void main(String[] args) {
        Logger logger = new ErrorLogger(new WarnLogger(new InfoLogger(null)));
        logger.message(Logger.INFO, "info level log");
        System.out.println("============================");
        logger.message(Logger.WARN, "warn level log");
        System.out.println("============================");
        logger.message(Logger.ERROR, "error level log");
    }
}
