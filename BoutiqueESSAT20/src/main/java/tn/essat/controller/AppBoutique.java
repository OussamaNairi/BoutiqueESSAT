package tn.essat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tn.essat.dao.ICategorieDao;
import tn.essat.dao.IClientDao;
import tn.essat.dao.ICommandeDao;
import tn.essat.dao.ILigneCommandeDao;
import tn.essat.dao.IProduitDao;
import tn.essat.model.Categorie;
import tn.essat.model.Produit;

@Controller
public class AppBoutique {
	@Autowired
	ICategorieDao catdao;
	@Autowired
	IProduitDao proddao;
	@Autowired
	IClientDao cltdao;
	@Autowired
	ICommandeDao cdedao;
	@Autowired
	ILigneCommandeDao licdedao;
	public void setCatdao(ICategorieDao catdao) {
		this.catdao = catdao;
	}
	public void setProddao(IProduitDao proddao) {
		this.proddao = proddao;
	}
	public void setCltdao(IClientDao cltdao) {
		this.cltdao = cltdao;
	}
	public void setCdedao(ICommandeDao cdedao) {
		this.cdedao = cdedao;
	}
	public void setLicdedao(ILigneCommandeDao licdedao) {
		this.licdedao = licdedao;
	}
    @GetMapping("/home")
	public String get1(Model m) {
		List<Categorie> liste1=catdao.findAll();
		List<Produit> liste2=proddao.findAll();
		m.addAttribute("prods",liste2);
		m.addAttribute("cats",liste1);
		return "accueil";
	}
	
}
