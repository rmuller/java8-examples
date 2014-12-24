package eu.infomas.examples.cdi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainServlet", urlPatterns = {"/"})
public class MainServlet extends HttpServlet {

    @Inject
    private Greeting greeting;
    @Inject
    private javax.enterprise.event.Event<String> event;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MainServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>Servlet MainServlet at " +  greeting.getText() + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
        event.fire("Simple event");
    }
    
    public void onEvent(@Observes String event) {
        System.out.println("Observed event: " + event);
    }
    
}
