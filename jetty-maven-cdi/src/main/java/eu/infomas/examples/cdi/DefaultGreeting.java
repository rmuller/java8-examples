package eu.infomas.examples.cdi;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DefaultGreeting implements Greeting {

    public DefaultGreeting() {
        System.out.println("new DefaultGreeting()");
    }
    
    @Override
    public String getText() {
        return "Hello injected world!";
    }

}
