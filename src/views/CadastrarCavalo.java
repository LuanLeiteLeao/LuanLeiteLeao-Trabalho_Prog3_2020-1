package views;

//Fig. 26.12: WelcomeServlet2.java
//Processando solicitações get de HTTP contendo dados.
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controler.CavaloControler;
import controler.RacaControler;
import model.Cavalo;
import model.Raca;
import model.RacaDB;
import renderHTML.RenderInserirCavalo;
import renderHTML.RenderizadorHtml;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cadastrar_cavalo")
public class CadastrarCavalo extends HttpServlet {
// processa a solicitação "get" do cliente
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		if (req.getMethod().equals("POST")) {


			String nome = req.getParameter("nome");

			Float altura = Float.parseFloat(req.getParameter("altura"));
			String corPelo = req.getParameter("corPelo");
			Float peso = Float.parseFloat(req.getParameter("peso"));

			String alimentacao = req.getParameter("alimentacao");
			Integer raca_id = Integer.parseInt(req.getParameter("raca"));

			RacaDB dbRaca = new RacaDB();
			Raca raca = dbRaca.resgatarRaca(raca_id);

			CavaloControler controler = new CavaloControler();
			
			Cavalo cavalo = new Cavalo(raca.id, nome, altura, corPelo, peso, alimentacao, raca);
			 
			controler.inserir(cavalo);

			res.sendRedirect("/CRUD_SERVELT_JAVA");
		} else {
			RenderInserirCavalo render = new RenderInserirCavalo();

			String current2 = getServletContext().getRealPath("/");

			render.renderHtml(current2 + "/WEB-INF/static/html/inserir_cavalo.html", res);

			PrintWriter out = res.getWriter();
		}

	} // fim do método doGet
} // fim da classe WelcomeServlet2
