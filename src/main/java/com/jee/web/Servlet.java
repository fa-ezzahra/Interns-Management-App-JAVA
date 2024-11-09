package com.jee.web;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jee.beans.Stage;
import com.jee.business.Fenetre1businessimpl;
import com.jee.business.Fenetre1manager;
import com.jee.business.Fenetre2businessimpl;
import com.jee.business.Fenetre2manager;
import com.jee.business.Fenetre3businessimpl;
import com.jee.business.Fenetre3manager;
import com.jee.business.Fenetre4businessimpl;
import com.jee.business.Fenetre4manager;
import com.jee.dao.Fenetre1dao;
import com.jee.dao.Fenetre1daoimpl;
import com.jee.dao.Fenetre2dao;
import com.jee.dao.Fenetre2daoimpl;
import com.jee.dao.Fenetre3dao;
import com.jee.dao.Fenetre3daoimpl;
import com.jee.dao.Fenetre4dao;
import com.jee.dao.Fenetre4daoimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Fenetre1dao dao1 ;
	private Fenetre1manager manager1;
	private Fenetre2manager manager2;
    private Fenetre2dao dao2;
    private Fenetre3manager manager3;
    private Fenetre3dao dao3;
    private Fenetre4manager manager4;
    private Fenetre4dao dao4;
	
	

    
	public void init() throws ServletException {
		System.out.println("Initialisation de la Servlet");
		
		dao1 =new Fenetre1daoimpl();
		manager1= new Fenetre1businessimpl(dao1);
		 dao2 = new Fenetre2daoimpl();
	     manager2 = new Fenetre2businessimpl(dao2);
	     dao3 = new Fenetre3daoimpl();
	        manager3 = new Fenetre3businessimpl(dao3);
	        dao4 = new Fenetre4daoimpl();
	        manager4 = new Fenetre4businessimpl(dao4);
		
	}

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Execution d'un service");
		String url= req.getRequestURI();
	    List<Stage> dl = new ArrayList<>();
	    if(url.contains("login")) {
	    try {
	        dl = manager1.selectAllStages();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        req.setAttribute("errorMessage", "An error occurred while retrieving stage data.");
	        req.getRequestDispatcher("/error.jsp").forward(req, resp); 
	        return; 
	    }  
	    
	    req.setAttribute("dl", dl);
	    req.getRequestDispatcher("/views/fenetre1.jsp").forward(req, resp);}
	    else if (url.contains("lister")){
	    	String codeStage = req.getParameter("code");

	        List<String> stagiaires = manager2.selectStagiaire(codeStage);
	        
	        req.setAttribute("stagiaires", stagiaires);
	        
	        req.getRequestDispatcher("/views/fenetre2.jsp").forward(req, resp);
	    	
	    }
	    else if (url.contains("add")) {
	    	String nom = req.getParameter("nom");
			String prenom = req.getParameter("prenom");
			String statutParam = req.getParameter("statut");
			char statut = statutParam != null && !statutParam.isEmpty() ? statutParam.charAt(0) : ' '; 

			String code = req.getParameter("code");
			 manager3.inscrireStagiaire(nom, prenom, code, statut);
		     req.getRequestDispatcher("/views/fenetre3.jsp").forward(req, resp);
		   
		    } 
	    else if (url.contains("a")) {
	    	String nom = req.getParameter("nom");
	    	String prenom = req.getParameter("prenom");
	    	String anneeNaissanceStr = req.getParameter("anneeNaissance");
	    	LocalDate anneeNaissance = null;
	    	if (anneeNaissanceStr != null && !anneeNaissanceStr.isEmpty()) {
	    	    anneeNaissance = LocalDate.parse(anneeNaissanceStr);
	    	}
	    	String diplome = req.getParameter("diplome");
	    	String sexeParam = req.getParameter("sexe");
	    	char sexe;
	    	if (sexeParam != null && !sexeParam.isEmpty()) {
	    	    sexe = sexeParam.charAt(0);
	    	}else {
	            sexe = ' '; 
	        }
	    	
	    	manager4.insererStagiaire(nom, prenom, anneeNaissance, diplome,sexe);
		     req.getRequestDispatcher("/views/fenetre4.jsp").forward(req, resp);

	    	}
	    
	        	 
	}	
	     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
