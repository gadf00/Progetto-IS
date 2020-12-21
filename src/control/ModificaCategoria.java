package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.categoria.CategoriaBean;
import model.categoria.CategoriaDAO;
import model.servizio.ConvertitoreImmagine;


@WebServlet(urlPatterns = {"/ModificaCategoria","/titolare/ModificaCategoria"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB after which the file will be
// temporarily stored on disk
maxFileSize = 1024 * 1024 * 10, // 10MB maximum size allowed for uploaded files
maxRequestSize = 1024 * 1024 * 50) // 50MB overall size of all uploaded files

public class ModificaCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoriaDAO categoriaDAO = new CategoriaDAO();
    public ModificaCategoria() {
        super();
    }

    
    /**
	 * Permette di modificare una categoria esistente prendendo dati dal form
	 * */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoriaBean categoria = new CategoriaBean();
		categoria.setNome(request.getParameter("nome"));
		categoria.setTipoGenerico(request.getParameter("tipoGenerico"));
		categoria.setDescrizione(request.getParameter("descrizione"));
		categoria.setPrezzo(Float.parseFloat(request.getParameter("prezzo")));
		categoria.setImmagine(ConvertitoreImmagine.converti(request.getPart("immagine")));
		
		try {
			categoriaDAO.doUpdate(categoria, categoria.getNome());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}