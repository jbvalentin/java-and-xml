package simple.jsontest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class EssaiJson {

	// http://tutorials.jenkov.com/java-json/jackson-objectmapper.html

	public static void main(final String[] args) {
		final JSONObject jo = new JSONObject();
		jo.put("KEYa", "value a");

		final JSONArray ja = new JSONArray();

		for (int i = 0; i < 5; i++) {
			final JSONObject jotmp = new JSONObject();
			jotmp.put("wawawa", "value" + i);
			ja.add(jotmp);

		}

		jo.put("KEYB", ja);

		System.out.println(jo.toJSONString());
	}
}
