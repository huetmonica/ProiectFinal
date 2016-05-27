package Repository;

import java.util.Random;

public class UserService {

	public String user;
	public String name;
	public String pass;
	public String cnp;

	public int Verific(String name, String user, String pass) throws Exception {
		int valid = -1;
		int tip = 2;
		UserDAO us = new UserDAO();
		String parola = "";
		MD5Digest md = new MD5Digest();
		parola = md.Criptare(pass);

		valid = us.VerificaUser(name, user, parola);
		// daca e o exista in baza de date
		if (valid == 1) {
			if (user.compareTo("angajat") == 0) {
				tip = 1;
			}
			if (user.compareTo("admin") == 0) {
				tip = 0;
			}
		}

		return tip;
	}

	public void Ceeaza() throws Exception {
		String parola = "";
		UserDAO ubd = new UserDAO();
		MD5Digest md = new MD5Digest();
		parola = md.Criptare(pass);
		Angajat ang = new Angajat();
		ang.setNume(name);
		ang.setUser(user);
		ang.setCnp(cnp);
		ang.setParola(parola);
		ubd.addUser(ang);
	}

	public String Reseteaza(String name, String user, String cnp) throws Exception {
		String parola = "";
		String parol = "";
		int valid = -1;
		UserDAO ubd = new UserDAO();
		MD5Digest md = new MD5Digest();
		Random rand = new Random();
		valid = ubd.VerificaCnp(name, user, cnp);

		if (valid == 1) {
			int n = rand.nextInt(10000) + 1;
			parola = String.valueOf(n);
			parol = md.Criptare(parola);
			ubd.UpdateUser(name, parol);
		}
		return parola;
	}
}
