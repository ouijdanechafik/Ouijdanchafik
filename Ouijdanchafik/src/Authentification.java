import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.ws.WebServiceClient;

import com.sun.net.httpserver.HttpServer;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Test
 */
@WebServlet(
		description = "un test de servlet", 
		urlPatterns = { 
				"/Test", 
				"/pop"
		})
public abstract class Authentification extends HttpServer{
	private static final long serialVersionUID = 1L;
       int cpt1=0;
       int cpt2=0;
       
       Etudiantmanager e;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		e=new EtudiantManager();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		
	   String lg=request.getParameter("log");
	   String ps=request.getParameter("pass");
	   Etudiant e1=e.authentification(lg, ps);
	   if(e1!=null)
	   {
		   HttpSession ses = request.getSession(true);
		   
		   
		   ses.setAttribute("etudiant", e1);
		   
		   response.sendRedirect("index.jsp");
	   }else
		  
		   {
		   	cpt1++;
		   response.sendError(505, "le password ou login incorrect");
		   }
		
		
		
		
		
	}

	

	
}

