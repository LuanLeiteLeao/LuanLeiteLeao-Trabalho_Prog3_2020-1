package views;
// Fig. 26.12: WelcomeServlet2.java
// Processando solicitações get de HTTP contendo dados.
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;        
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controler.RacaControler;
import model.Raca;
import renderHTML.RenderInserirCavalo;
import renderHTML.RenderInserirRaca;
import renderHTML.RenderizadorHtml;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cadastra_raca")
public class CadastrarRaca extends HttpServlet  
{
   // processa a solicitação "get" do cliente
  protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	   if (req.getMethod().equals("POST")) {
		   RacaControler controler = new RacaControler();
		   String nomeBr = req.getParameter("nomeBr");
		   String nomeEng = req.getParameter("nomeEng");
		   String paisOrigem = req.getParameter("paisOrigem");
		   String uso = req.getParameter("uso");
		   String temperamento = req.getParameter("temperamento");
		   String breveHistoria = req.getParameter("breveHistoria");
		   
		   controler.inserir(new Raca(nomeBr, nomeEng, paisOrigem, uso, temperamento, breveHistoria));
		   res.sendRedirect("/CRUD_SERVELT_JAVA");
		    
		   
	   }
	   else {

			  String current2 = getServletContext().getRealPath("/");
			 
			  
			 RenderInserirRaca render = new RenderInserirRaca();
			 render.renderHtml(current2+"/WEB-INF/static/html/inserir_raca.html", res);
			 
			PrintWriter out = res.getWriter();
			
	   }
	
   } // fim do método doGet
} // fim da classe WelcomeServlet2

