package Controller;

import org.springframework.validation.BindingResult;
import Repository.Export;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Repository.Angajat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import Repository.MD5Digest;
import Repository.UserService;
import Repository.Cuvant;
import Repository.UserDAO;
import Repository.DictionarDAO;
import Repository.CuvantDAO;
import java.util.ArrayList;


@Controller
public class CuvantController {

	@RequestMapping(value = "/cuvant")
	public ModelAndView cuvant() {

		return new ModelAndView("cuvant", "command", new Cuvant());
	}

	@RequestMapping(value = "/adaugaC", method = RequestMethod.POST)
	public String adaugaS(@ModelAttribute("SpringWeb") UserDAO ub, MD5Digest md, UserService us, Angajat ang,
			DictionarDAO dictionar, Cuvant cuv, ModelMap model) throws Exception {
		ArrayList list = new ArrayList();
		CuvantDAO cuvant = new CuvantDAO();
		String cuvantaux = "";
		model.addAttribute("cuvant", cuv.getCuvant());
		cuvantaux = cuv.getCuvant();
		cuv.setCuvant(cuvantaux);
		cuvant.addCuvant(cuv);

		return "redirect:/cuvant.do";

	}

	@RequestMapping(value = "/VizualizareC", method = RequestMethod.POST)
	public ModelAndView Vizualizare() {
		CuvantDAO cuv = new CuvantDAO();
		ArrayList list = new ArrayList();
		list = cuv.getCuvinte();
		ModelAndView model = new ModelAndView("listaCuvinte");
		model.addObject("lists", list);
		return model;

	}

	@RequestMapping(value = "/cauta", method = RequestMethod.POST)
	public ModelAndView cauta(@ModelAttribute("SpringWeb") Cuvant cuv1) {
		ArrayList list = new ArrayList();
		DictionarDAO dic = new DictionarDAO();
		String cuvantaux = "";

		ModelMap model = new ModelMap();
		model.addAttribute("cuvant", cuv1.getCuvant());
		cuvantaux = cuv1.getCuvant();
	
		list = dic.VerificaSinonime(cuvantaux);

		ModelAndView model1 = new ModelAndView("listaCuvinte");
		model1.addObject("lists", list);
		return model1;

	}

}