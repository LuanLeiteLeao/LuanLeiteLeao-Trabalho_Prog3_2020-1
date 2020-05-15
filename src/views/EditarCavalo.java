package views;

import javax.servlet.RequestDispatcher;
//Fig. 26.12: WelcomeServlet2.java
//Processando solicitações get de HTTP contendo dados.
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import controler.CavaloControler;
import controler.RacaControler;
import model.Cavalo;

import model.Raca;
import model.RacaDB;
import renderHTML.RenderInserirCavalo;
import renderHTML.RenderizadorHtml;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/editar_cavalo")
public class EditarCavalo extends HttpServlet {
// processa a solicitação "get" do cliente
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		/*	
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		if (req.getMethod().equals("POST")) {

			Connection con = (Connection) req.getAttribute("connection");
			PessoaDao pessoaDao = new PessoaDao(con);
			PessoaData pessoa = new PessoaData(id, req.getParameter("nameInput"), req.getParameter("inputEmail"));
			pessoaDao.update(pessoa);

			res.sendRedirect("listar_pessoas");
			
			System.out.println(req.getMethod());

		} else if (id > 0) {
			Connection con = (Connection) req.getAttribute("connection");
			PessoaDao pessoaDao = new PessoaDao(con);
			req.setAttribute("edit", pessoaDao.resgatarPessoa(id));

			req.setAttribute("namePage", "Editar Pessoa");
			req.setAttribute("editar", true);
			req.setAttribute("nameButton", "Editar");
			req.setAttribute("action", "editar_pessoa?id="+id);
			

			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/CadastrarPessoa.jsp");
			rd.forward(req, res);

		}
		*/

		Integer id =  Integer.parseInt(req.getParameter("id"));
			
		if (req.getMethod().equals("POST")) {
			
			
			
			String nome = req.getParameter("nome");

			Float altura = Float.parseFloat(req.getParameter("altura"));
			String corPelo = req.getParameter("corPelo");
			Float peso = Float.parseFloat(req.getParameter("peso"));

			String alimentacao = req.getParameter("alimentacao");
			Integer raca_id = Integer.parseInt(req.getParameter("raca"));
			
			RacaDB dbRaca = new RacaDB();
			Raca raca = dbRaca.resgatarRaca(raca_id);
			
			Cavalo cavalo = new  Cavalo(id, nome, altura, corPelo, peso, alimentacao, raca);
			
			CavaloControler controle = new CavaloControler();
			
			controle.update(cavalo);
			
			res.sendRedirect("/CRUD_SERVELT_JAVA");
			
			System.out.println(req.getMethod());
			
		}
		else {

			
			CavaloControler contole = new CavaloControler();
			Cavalo cav =  contole.Resgatar(id);
			
			RenderInserirCavalo render = new RenderInserirCavalo();
			render.setCavalo(cav);
			
			String current2 = getServletContext().getRealPath("/");

			render.renderHtml(current2 + "/WEB-INF/static/html/editar_cavalo.html", res);

			PrintWriter out = res.getWriter();

		}
		
		
		

	} // fim do método doGet
} // fim da classe WelcomeServlet2
