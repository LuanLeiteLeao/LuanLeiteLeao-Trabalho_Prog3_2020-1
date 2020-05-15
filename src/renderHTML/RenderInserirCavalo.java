package renderHTML;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import model.Cavalo;
import model.CavaloDB;
import model.Raca;
import model.RacaDB;

public class RenderInserirCavalo extends RenderizadorHtml {
	private Cavalo cavalo = null;

	@Override
	public String block(String linha) {

		if (linha.contains("{% block racas_select %}")) {
			
			return this.racasSelect();
	
		} else if (linha.contains("{% block cavalo_card_layout %}")) {
			return this.cavaloCardLayout();
		} else if (linha.contains("{{value_")) {
			return this.inserirValue(linha, this.cavalo);

		}

		return null;
	}

	private String cavaloCardLayout() {
		CavaloDB db = new CavaloDB();
		ArrayList<Cavalo> ca = db.resgatarTodosCavalo();
		String html = "";

		for (Cavalo cavalo : ca) {
			html += "<tr>\n" + "					<th scope=\"row\">" + cavalo.getId() + "</th>\n"
					+ "					<td>" + cavalo.getNome() + "</td>\n" + "					<td>"
					+ cavalo.getAltura() + "</td>\n" + "					<td>" + cavalo.getCorPelo() + "</td>\n"
					+ "					<td>" + cavalo.getPeso() + "</td>\n" + "					<td>"
					+ cavalo.getAlimentacao() + "</td>\n" + "					<td>" + cavalo.getRaca().getNomeBr()
					+ "</td>\n" + "					<td>" + " <a class=\"btn btn-primary\" href=\"http://localhost:8080/CRUD_SERVELT_JAVA/editar_cavalo?id="
							+  cavalo.getId() +"\" role=\"button\">"
					+ "Editar" + "</a>" + "</td>\n" + "					<td>"
//			+" <a class="btn btn-primary" href="#" role="button" href=\"/CRUD_SERVELT_JAVA/remover_cavalo?action=delete&"
//			+ "id="
//			+ cavalo.getId()
//			+ >"
//			+ "Remover"
//			+ "</a>"
//
					+ "<a  class=\"btn btn-danger\" href=\"#\" role=\"button\" href=\"javascript:func()\"\n"
					+ "onclick=\"confirmacao('" + cavalo.getId() + "')\">Remover</a>" + "</td>\n" +

					"				</tr>";

		}
//		
//		+" <a class=\"btn btn-danger\" href=\"/CRUD_SERVELT_JAVA/remover_cavalo?action=delete&"
//		+ "id="
//		+ cavalo.getId()
//		+ "\" role=\"button\">"
//		+ "Remover"
//		+ "</a>"
		return html;
	}

	public void setCavalo(Cavalo cav) {
		this.cavalo = cav;
	}

	public String inserirValue(String linha, Cavalo cav) {
		String value = "value=\"#\"";

		if (cav != null) {

			if (linha.contains("{{value_name}}")) {
				value = value.replace("#", cav.getNome());
				linha = linha.replace("{{value_name}}", value);

			} else if (linha.contains("{{value_cor_pelo}}")) {

				value = value.replace("#", cav.getCorPelo());
				linha = linha.replace("{{value_cor_pelo}}", value);

			} else if (linha.contains("{{value_altura}}")) {

				value = value.replace("#", Float.toString(cav.getAltura()));
				linha = linha.replace("{{value_altura}}", value);

			} else if (linha.contains("{{value_peso}}")) {

				value = value.replace("#", Float.toString(cav.getPeso()));
				linha = linha.replace("{{value_peso}}", value);

			} else if (linha.contains("{{value_alimentacao}}")) {

				value = value.replace("#", cav.getNome());
				linha = linha.replace("{{value_alimentacao}}", value);

			} else if (linha.contains("{{value_id_form_edit_cavalo}}")) {

				
				linha = linha.replace("{{value_id_form_edit_cavalo}}", Integer.toString(cav.getId()));

			}
		} else {
			value = value.replace("#", "");
			linha = linha.replace("{{value_", value);
		}

		return linha;

	}

	public String racasSelect() {
		String html = "";
		
		
		RacaDB db = new RacaDB();
		ArrayList<Raca> ra = db.resgatarTodasRacas();

		for (Raca raca : ra) {
			
			String modelo = "<option value=\"" + raca.getId() + "\" {{value_selected}} >" + raca.getNomeBr() + "</option>";
			
			if(this.cavalo != null) {
				
				modelo = modelo.replace("{{value_selected}}", "selected");
			}
			else {
				modelo = modelo.replace("{{value_selected}}", "");
			}
			html += modelo;

		}
		return html;
	}

}
