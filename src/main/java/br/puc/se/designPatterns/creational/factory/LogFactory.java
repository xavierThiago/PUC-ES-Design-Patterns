package br.puc.se.designPatterns.creational.factory;

public class LogFactory {
    public OutputLogger of(LoggerType loggerType) {
        switch (loggerType) {
            case JMS: {
                return new JMSOutputLogger();
            }
            case CONSOLE : {
                return new ConsoleOutputLogger();
            }
            case HTTP_POST:
            default: {
                return new HTTPOutputLogger();
            }
        }
    }
}
