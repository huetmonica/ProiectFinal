package Repository;

import java.util.ArrayList;

public class Dictionar {

	public ArrayList<String> Consistenta(ArrayList<String> lista) {
		int aux;
		int i;
		int result = 0;
		DictionarDAO dc = new DictionarDAO();
		String st = "";
		aux = lista.size();
		ArrayList<String> sino = new ArrayList<String>();
		sino.clear();
		for (i = 0; i < aux; i++) {
			st = lista.get(i);
			result = dc.Gaseste(st);
			if (result == 1) {
				sino.add(st);

			}
		}
		return sino;

	}

	public ArrayList Gasire(Cuvant cuv) {

		ArrayList<Cuvant> sino = new ArrayList<Cuvant>();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		DictionarDAO dc = new DictionarDAO();
		String nume = cuv.getCuvant();
		String aux, aux1 = "";

		Sinonime sinonime;
		int k = 0;
		boolean gasit, ok;

		ok = false;
		if (nume.equals("*")) {
			list = dc.getSinonime();
			ok = true;
			return list;
		} else {

			if (nume.contains("*") || nume.contains("?")) {

				String cuvantNou = nume.replaceAll("\\*", "[a-zA-Z]*");
				cuvantNou = cuvantNou.replaceAll("\\?", "[a-z]");
				list = dc.getSinonime();
				for (int i = 0; i < list.size(); i++) {
					aux = list.get(i);
					k = 0;
					String[] tokens = aux.split("=");
					for (String t : tokens) {
						if (k == 0) {
							aux1 = t;
						}
						k++;
					}

					if (aux1.matches(cuvantNou)) {
						list2.add(list.get(i));
						System.out.println("intra");
					}
				}

				return list2;
			}

		}
		list = list2;
		return list;
	}

}