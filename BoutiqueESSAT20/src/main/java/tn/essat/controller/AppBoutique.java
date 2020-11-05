package tn.essat.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tn.essat.dao.ICategorieDao;
import tn.essat.dao.IClientDao;
import tn.essat.dao.ICommandeDao;
import tn.essat.dao.ILigneCommandeDao;
import tn.essat.dao.IProduitDao;
import tn.essat.model.Categorie;
import tn.essat.model.LignePanier;
import tn.essat.model.Panier;
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
    
    @GetMapping("/produits/{id}")
	public String get2(Model m, @PathVariable("id") int id) {
		List<Categorie> liste1=catdao.findAll();
		List<Produit> liste2=proddao.getAllProduitByCat(id);
		m.addAttribute("prods",liste2);
		m.addAttribute("cats",liste1);
		return "accueil";
	}
    @GetMapping("/addPanier/{id}")
	public String get3(Model m, @PathVariable("id") int id,HttpSession session) {
		Panier pan= (Panier) session.getAttribute("monpanier");
		if(pan==null) {
			Panier p=new Panier();
			Produit prod=proddao.findOne(id);
			p.addPanier(new LignePanier(prod,1));
			session.setAttribute("monpanier", p);
		}else {
			boolean test=false;
			for(LignePanier li:pan.getLignes()) {
				if(li.getProd().getId()==id) {
					li.setQuantite(li.getQuantite()+1);
					test=true;
				}
			}
			if(test==false) {
				Produit prod=proddao.findOne(id);
				pan.addPanier(new LignePanier(prod,1));
				
			}
			session.setAttribute("monpanier", pan);
		}
		return "redirect:/panier";
	}
    @GetMapping("/panier")
   	public String get4(Model m) {
   		List<Categorie> liste1=catdao.findAll();
   		m.addAttribute("cats",liste1);
   		return "panier";
   	}
	
}
