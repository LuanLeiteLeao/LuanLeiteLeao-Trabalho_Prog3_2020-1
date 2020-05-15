package renderHTML;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StyledEditorKit.BoldAction;


public abstract class RenderizadorHtml {


	/**
	 * Ler Html.
	 * 
	 * @param path                O caminho que o arquivo HTML se encontra (Tendo
	 *                            como referência a pasta WebContent/WEB-INF/)
	 * @param HttpServletResponse response
	 * @return
	 * @author Luan Leite Leao
	 */
	
	//remover o HttpServletResponse response e retornar uma string
	public abstract String block(String linha);
	
	public  void renderHtml(String path, HttpServletResponse response) throws IOException {
		String dir = System.getProperty("user.dir");
		System.out.println(dir);
		
		BufferedReader buffRead =  new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
		String linha = "";
		PrintWriter out = response.getWriter();
				
	
		while (linha != null) {
			linha = buffRead.readLine();
			if(linha != null) {
				
				String block = this.block(linha);
				
				
				if(block != null) {
					out.println(block);
				}
				else {
					out.println(linha);
				}
					
				
				
				
				
				
				
//				System.out.println(linha);
			}
			

		}
		buffRead.close();
	}
	


}
