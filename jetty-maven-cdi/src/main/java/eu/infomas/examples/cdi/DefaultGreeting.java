package eu.infomas.examples.cdi;

import javax.enterprise.context.ApplicationScoped;

/**
 * {@code DefaultGreeting}.
 *
 * @author <a href="mailto:rmuller@xiam.nl">Ronald K. Muller</a>
 * @since INFOMAS NG 3.0
 */
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
