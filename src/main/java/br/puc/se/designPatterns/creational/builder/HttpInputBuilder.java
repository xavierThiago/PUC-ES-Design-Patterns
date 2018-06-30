package br.puc.se.designPatterns.creational.builder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class HttpInputBuilder implements InputBuilder<HttpInputConnection> {
	
    private Properties connectionProperties;
    private final HttpInputConnection connection;
    private final Input<HttpInputConnection> input;

    public HttpInputBuilder() {
        this.connection = new HttpInputConnection();

        this.input = new Input<HttpInputConnection>() {
            
            @Override
            public HttpInputConnection getContent() {
                return HttpInputBuilder.this.connection;
            }

        };
    }

    public HttpInputBuilder fromPropertyFile(String fileName) throws FileNotFoundException, IOException {
        this.connectionProperties = BuilderUtilities.readPropertiesFromResourceFile(fileName);

        this.connection.setProtocol(this.connectionProperties.getProperty("protocol"));
        this.connection.setHost(this.connectionProperties.getProperty("host"));
        this.connection.setPort(this.connectionProperties.getProperty("port"));
        this.connection.setMethod(this.connectionProperties.getProperty("method"));
        
        return this;
    }

    public HttpInputBuilder fromHost(String host) {
        this.connection.setHost(host);

        return this;
    }

    public HttpInputBuilder usingProtocol(String protocol) {
        this.connection.setProtocol(protocol);

        return this;
    }

    public HttpInputBuilder onPort(int port) {
        this.connection.setPort(String.valueOf(port));

        return this;
    }

    public HttpInputBuilder usingMethod(String method) {
        this.connection.setMethod(method);

        return this;
    }

    @Override
    public Input<HttpInputConnection> build() {
        return this.input;
    }

    @Override
    public void fromResource(String resource) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
