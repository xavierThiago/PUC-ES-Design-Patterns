package br.puc.se.designPatterns.creational.singleton;

public class MyCustomApplicationContext {
    private static MyCustomApplicationContext instance;
    
    private MyCustomApplicationContext() {

    }
    
    public static MyCustomApplicationContext getInstance() {
        if (MyCustomApplicationContext.instance == null) {
            MyCustomApplicationContext.instance = new MyCustomApplicationContext();
        }
        
        return MyCustomApplicationContext.instance;
    }
}
