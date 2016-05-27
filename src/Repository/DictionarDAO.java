package Repository;

import java.sql.Connection;
import java.util.ArrayList;

public class DictionarDAO {
	Conexiune c = new Conexiune();
	public Connection con;

	public void addSinonime(Cuvant cuv, ArrayList list) {
		String sb = null;

		try {

			con = c.Conectare();
			String cuvant = "";
			java.sql.Statement st = con.createStatement();
			sb = ("INSERT INTO dictionar");
			sb = sb + ("(cuvant,sinonime) ");
			sb = sb + ("VALUES ( ");
			sb = sb + ("  '" + cuv.getCuvant() + "'");
			for (int i = 0; i < list.size(); i++) {
				cuvant = cuvant + list.get(i).toString() + ",";
			}
			sb = sb + (", '" + cuvant + "' ");
			sb = sb + (")");

			st.executeUpdate(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> getSinonime() {
		Cuvant cuv = new Cuvant();
		Sinonime sinonime = null;

		ArrayList list = new ArrayList();
		ArrayList list2 = new ArrayList();

		try {
			con = c.Conectare();
			java.sql.Statement st = con.createStatement();
			java.sql.ResultSet res = st.executeQuery("SELECT * FROM dictionar");

			while (res.next()) {
				String nume = res.getString("cuvant");
				String sin = res.getString("sinonime");
				String[] tokens = sin.split(",");
				list.clear();
				cuv.setCuvant(nume);
				list.add(cuv.toString());

				for (String t : tokens) {
					cuv.setCuvant(t);
					list.add(cuv.toString());

				}
				sinonime = new Sinonime(list);
				list2.add(sinonime.toString());

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return list2;
	}

	public ArrayList VerificaSinonime(String sino) {
		ArrayList list = new ArrayList();

		try {
			con = c.Conectare();
			java.sql.Statement st = con.createStatement();
			java.sql.ResultSet res = st.executeQuery("SELECT * FROM dictionar");

			while (res.next()) {
				String cuvant = res.getString("cuvant");
				String sinonime = res.getString("sinonime");
				if (sino.compareTo(cuvant) == 0) {
					list.add(cuvant);
					String[] tokens = sinonime.split(",");
					for (String t : tokens) {
						list.add(t);

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public int Gaseste(String sino) {
		ArrayList list = new ArrayList();
		int aux = -1;
		try {
			con = c.Conectare();
			java.sql.Statement st = con.createStatement();
			java.sql.ResultSet res = st.executeQuery("SELECT * FROM dictionar");

			while (res.next()) {
				String cuvant = res.getString("cuvant");
				String sinonime = res.getString("sinonime");
				if (sino.compareTo(cuvant) == 0) {
					aux = 1;

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return aux;

	}
	/*
	 * public static void main(String[] args) { ArrayList<String> list = new
	 * ArrayList<String>(); ArrayList lista1= new ArrayList(); DictionarDAO sino
	 * = new DictionarDAO(); list = sino.VerificaSinonime("agitat"); for (int i
	 * = 0; i < list.size(); i++){ System.out.println(list.get(i).toString()); }
	 * Cuvant cuv1= new Cuvant ("ra"); Cuvant cuv2= new Cuvant ("mtta"); Cuvant
	 * cuv3= new Cuvant ("etta"); lista1.add(cuv2); lista1.add(cuv3);
	 * 
	 * //Sinonime sin =new Sinonime(lista1); // sino.addSinonime(cuv1, lista1);
	 * }
	 */
}
