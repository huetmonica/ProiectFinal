package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

import Repository.Angajat;
import Repository.UserDAO;
import Repository.MD5Digest;
import Repository.UserService;

@Controller
public class LoginController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("login", "command", new Angajat());
	}

	@RequestMapping(value = "/Logare", method = RequestMethod.POST)
	public String Logare(@ModelAttribute("SpringWeb") UserDAO ub, Angajat ang, MD5Digest md, UserService us,
			ModelMap model) throws Exception {
		String parola = "";
		String parolav = "";
		int valid = -5;
		parola = ang.getParola();
		parolav = md.Criptare(parola);
		ang.setParola(parolav);
		model.addAttribute("nume", ang.getNume());
		model.addAttribute("user", ang.getUser());
		model.addAttribute("cnp", ang.getCnp());
		model.addAttribute("parola", ang.getParola());
		valid = us.Verific(ang.getNume(), ang.getUser(), ang.getParola());

		if (valid == 1) {

			return "redirect:/cuvant.do";
			
		}
		if (valid == 0) {

			return "redirect:/sinonime.do";

		}

		return "";

	}

	@RequestMapping(value = "/Resetare", method = RequestMethod.POST)
	public String Resetare(@ModelAttribute("SpringWeb") UserService us, UserDAO ub, Angajat ang, MD5Digest md,
			ModelMap model) throws Exception {
		String parola = "";
		String nume = "";
		String user = "";
		String cnp = "";
		String parolav = "";
		nume = ang.getNume();
		user = ang.getUser();
		cnp = ang.getCnp();
		model.addAttribute("nume", ang.getNume());
		model.addAttribute("user", ang.getUser());
		model.addAttribute("cnp", ang.getCnp());
		parola = us.Reseteaza(nume, user, cnp);
		ang.setParola(parola);
		model.addAttribute("parola", parola);
		parolav = md.Criptare(parola);
		ub.UpdateUser(nume, parolav);

		return "reset";
	}

}