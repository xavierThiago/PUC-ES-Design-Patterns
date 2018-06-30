package br.puc.se.designPatterns.creational.factory;

public class JMSOutputLogger extends OutputLogger implements LogListener {
    @Override
    protected String formatMessage(String logMessage) {
        return logMessage;
    }

    @Override
    public void act(String logMessage) {
    }
    
}
