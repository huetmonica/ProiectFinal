package Repository;

import java.util.ArrayList;

public class Sinonime {

	ArrayList<Cuvant> lista;

	public Sinonime(ArrayList<Cuvant> lista) {
		this.lista = lista;
	}

	public ArrayList<Cuvant> getSinonime() {
		return lista;
	}

	public int getSize() {
		return lista.size();
	}

	public String getCuvant() {
		return lista.get(0).getCuvant();
	}

	public String toString() {
		int i;
		int s = lista.size();
		String aux = "";
		aux = aux + ' ' + lista.get(0) + ' ' + '=';
		for (i = 1; i < lista.size() - 1; i++)
			aux = aux + ' ' + lista.get(i) + ',';

		aux = aux + ' ' + lista.get(s - 1);
		return aux;
	}
}