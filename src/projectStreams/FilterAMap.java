package projectStreams;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by PawelM on 2017-02-23.
 */
public class FilterAMap {

    public static void main(String[] args) {

        FilterMapJava7();
        FilterMapJava8();
    }

    private static void FilterMapJava8() {
        Map<String, String> simpleMap = getSimpleMap();

        //Map -> Stream -> Filter -> String
        String result = simpleMap.entrySet().stream()
                .filter(map -> "Volskvagen".equals(map.getValue()))
                .map(map->map.getValue())
                .collect(Collectors.joining());
        System.out.println("FilterMapJava8 = " + result);
    }

    private static void FilterMapJava7() {
        Map<String, String> simpleMap = getSimpleMap();

        String result = "";
        for (Map.Entry<String, String> entry : simpleMap.entrySet()) {
            if("Volskvagen".equals(entry.getValue())){
                result = entry.getValue();
                break;
            }
        }
        System.out.println("FilterMapJava7 = " + result);
    }

    private static Map<String, String> getSimpleMap() {
        Map<String, String> simpleMap = new HashMap<String, String>();
        simpleMap.put("FRUIT", "Apple");
        simpleMap.put("VEGETABLE", "Carrot");
        simpleMap.put("CAR", "Volskvagen");
        simpleMap.put("COLOR", "Red");
        return simpleMap;
    }
}
