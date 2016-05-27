package Repository;

import java.util.ArrayList;

import java.io.FileWriter;
import java.io.IOException;

public class CsvExport implements Export {
	ArrayList lista = new ArrayList();
	int i;

	public CsvExport(ArrayList list) {
		for (i = 0; i < list.size(); i++) {
			lista.add(list.get(i));
		}
		System.out.println(45);
	}

	public void export() {
		try (FileWriter file = new FileWriter("D:/ANUL_III/IS/Incerc/doi/ProiectFinal/file2.txt")) {
			for (i = 0; i < lista.size(); i++) {
				file.append(lista.get(i).toString());
			}
			System.out.println("Successfully Copied CSV Object to File...");

		} catch (IOException e) {
		}
	}
}
