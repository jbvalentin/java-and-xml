package jsonorg;

import org.json.JSONObject;

import java.time.Duration;
import java.time.Period;
import java.util.Map;
import java.util.TreeMap;

public class DemoJsonOrg {

    public static void main(String[] args) {

        Map<String, Object> map = new TreeMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("period", Period.ofDays(15));
        map.put("duration", Duration.ofDays(2));
        System.out.println(JSONObject.valueToString(map));
    }

    public static JSONObject testParseJson(String s) {
        return new JSONObject(s);
    }

}
