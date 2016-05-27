package Repository;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSonExport implements Export {
	ArrayList lista = new ArrayList();
	int i;

	public JSonExport(ArrayList list) {
		for (i = 0; i < list.size(); i++) {
			lista.add(list.get(i));
		}
	}

	public void export() {
		JSONArray list = new JSONArray();
		for (i = 0; i < lista.size(); i++) {
			list.add(lista.get(i));
		}
		try (FileWriter file = new FileWriter("D:/ANUL_III/IS/Incerc/doi/ProiectFinal/file1.txt")) {
			file.write(list.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");

		} catch (IOException e) {
		}
	}

}
