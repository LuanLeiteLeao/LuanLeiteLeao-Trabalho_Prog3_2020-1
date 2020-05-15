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

@WebServlet("/remover_cavalo")
public class RemoverCavalo extends HttpServlet {
// processa a solicitação "get" do cliente
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String action = null;
		Integer id = null;

		action = req.getParameter("action");
		id = Integer.parseInt(req.getParameter("id"));

		if (action.equals("delete") && id != null) {
			CavaloControler controle = new CavaloControler();
		controle.Remove(new Cavalo(id, null, null, null, null, null, null));
		}

	

		String current2 = getServletContext().getRealPath("/");

		RenderInserirCavalo render = new RenderInserirCavalo();

		render.renderHtml(current2 + "/WEB-INF/static/html/listar.html", res);

		PrintWriter out = res.getWriter();

	} // fim do método doGet
} // fim da classe WelcomeServlet2
