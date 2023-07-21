package json;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import jsonorg.DemoJsonOrg;

public class TestDemoJsonOrg {

    @Test
    void testParse() {
        assertNotNull(DemoJsonOrg.testParseJson("{}"));

        assertNotNull(DemoJsonOrg.testParseJson("{\"key\":{\"sub\":\"subvalue\"}}"));
        // erreur
        assertThrows(org.json.JSONException.class, () -> DemoJsonOrg.testParseJson("{"));

    }

}
