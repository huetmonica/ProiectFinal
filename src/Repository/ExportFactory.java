package Repository;

import java.util.ArrayList;





public class ExportFactory {
	ArrayList list = new ArrayList();

	public Export exporta(String option) {
		if (option == null) {
			return null;
		}
		if (option.equalsIgnoreCase("csv")) {
			DictionarDAO sino = new DictionarDAO();
			list = sino.getSinonime();
			return new CsvExport(list);

		} else if (option.equalsIgnoreCase("json")) {
			DictionarDAO sino = new DictionarDAO();
			list = sino.getSinonime();
			return new JSonExport(list);
		}

		return null;
	}
}
