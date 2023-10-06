package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet({ "/Controller", "/controller" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String operacion = request.getParameter("operacion");
		String nombre = request.getParameter("nombre");
		request.setAttribute("operacion", operacion);
		request.setAttribute("nombre", nombre);
		request.getRequestDispatcher("/Salida.jsp");
		
		
		if (nombre == null)
		response.getWriter().append("Hola desconocido...").append(request.getContextPath());
		else {
			response.getWriter().append("Hola " + nombre+"\n").append(request.getContextPath());
			response.getWriter().append("La operacion que quieres realiza res: " + operacion).append(request.getContextPath());
		}}
		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><BODY BGCOLOR=\"#FDF5E6\">" +
		"<TABLE BORDER=1 ALIGN=CENTER>" +
		"<TR BGCOLOR=\"#FFAD00\">" +
		"<TH>Nombre parámetro</TH><TH>Valor</TH>");
		Enumeration nombresParametros = request.getParameterNames();
		while(nombresParametros.hasMoreElements()) {
		String nombreParametro = (String)nombresParametros.nextElement();
		out.print("<TR><TD>" + nombreParametro + "</TD><TD>");
		String[] valores =request.getParameterValues(nombreParametro);
		if (valores.length == 1) {
		String valor = valores[0];
		if (valor.length() == 0)
		out.println("<I>Sin valor</I>");
		else
		out.println(valor);
		} else {
		out.println("<UL>");
		for(int i=0; i<valores.length; i++) {
		out.println("<LI>" + valores[i]);
		}
		out.println("</UL>");
		}
		}
		out.println("</TABLE></BODY></HTML>");
		}
*/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}