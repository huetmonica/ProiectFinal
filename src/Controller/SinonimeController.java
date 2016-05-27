package Controller;

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

import Repository.Dictionar;
import Repository.UserDAO;
import Repository.DictionarDAO;

import java.util.ArrayList;

import Repository.ExportFactory;

@Controller
public class SinonimeController {

	@RequestMapping(value = "/sinonime")
	public ModelAndView sinonime() {

		return new ModelAndView("sinonime", "command", new Cuvant());
	}

	@RequestMapping(value = "/adaugaS", method = RequestMethod.POST)
	public String adaugaS(@ModelAttribute("SpringWeb") UserDAO ub, MD5Digest md, UserService us, Angajat ang,
			DictionarDAO dictionar, Cuvant cuv, ModelMap model) throws Exception {
		ArrayList list = new ArrayList();
		dictionar = new DictionarDAO();
		String cuvantaux = "";
		model.addAttribute("cuvant", cuv.getCuvant());
		cuvantaux = cuv.getCuvant();
		String[] tokens = cuvantaux.split(",");
		int k = 0;
		for (String t : tokens) {
			if (k == 0) {
				cuv.setCuvant(t);
			} else {
				list.add(t);
			}
			k++;
		}

		dictionar.addSinonime(cuv, list);

		return "redirect:/sinonime.do";

	}

	@RequestMapping(value = "/consistenta", method = RequestMethod.POST)
	public ModelAndView consistenta(@ModelAttribute("SpringWeb") Cuvant cuv1) {
		ArrayList list = new ArrayList();
		ArrayList list1 = new ArrayList();

		Dictionar dc = new Dictionar();
		ModelMap model = new ModelMap();
		String cuvantaux = "";
		model.addAttribute("cuvant", cuv1.getCuvant());
		cuvantaux = cuv1.getCuvant();
		String[] tokens = cuvantaux.split(",");

		for (String t : tokens) {
			list1.add(t);
		}
		list = dc.Consistenta(list1);
		ModelAndView model1 = new ModelAndView("listaSinonime");
		model1.addObject("lists", list);
		return model1;

	}

	@RequestMapping(value = "/VizualizareS", method = RequestMethod.POST)
	public ModelAndView Vizualizare() {
		DictionarDAO sinonim = new DictionarDAO();
		ArrayList list = new ArrayList();
		list = sinonim.getSinonime();
		ModelAndView model = new ModelAndView("listaSinonime");
		model.addObject("lists", list);
		return model;

	}

	@RequestMapping(value = "/SalvareCsv", method = RequestMethod.POST)
	public String adaugaA(@ModelAttribute("SpringWeb") ModelMap model) {
		ExportFactory ef = new ExportFactory();
		Export exp = ef.exporta("csv");
		exp.export();
		return "redirect:/sinonime.do";
	}

	@RequestMapping(value = "/SalvareJson", method = RequestMethod.POST)
	public String adaugaAL(@ModelAttribute("SpringWeb") ModelMap model) {

		ExportFactory ef = new ExportFactory();
		Export exp = ef.exporta("json");
		exp.export();

		return "redirect:/sinonime.do";
	}
}