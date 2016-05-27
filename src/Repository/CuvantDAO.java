package Repository;

import java.sql.Connection;
import java.util.ArrayList;

public class CuvantDAO {

	Conexiune c = new Conexiune();
	public Connection con;

	public void addCuvant(Cuvant cuv) {
		String sb = null;

		try {

			con = c.Conectare();
		
			java.sql.Statement st = con.createStatement();
			sb = ("INSERT INTO cuvant");
			sb = sb + ("(denumire) ");
			sb = sb + ("VALUES ( ");
			sb = sb + ("  '" + cuv.getCuvant() + "'");
			sb = sb + (")");

			st.executeUpdate(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Cuvant getCuvant() {
		Cuvant cuv = new Cuvant();
		

		try {
			con = c.Conectare();
			java.sql.Statement st = con.createStatement();
			java.sql.ResultSet res = st.executeQuery("SELECT * FROM cuvant");

			while (res.next()) {
				String nume = res.getString("denumire");

				cuv.setCuvant(nume);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return cuv;
	}
	public ArrayList getCuvinte() {
		Cuvant cuv = new Cuvant();
		
        ArrayList list = new ArrayList();
		try {
			con = c.Conectare();
			java.sql.Statement st = con.createStatement();
			java.sql.ResultSet res = st.executeQuery("SELECT * FROM cuvant");

			while (res.next()) {
				String nume = res.getString("denumire");
                list.add(nume);
				cuv.setCuvant(nume);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return list;
	}
}
