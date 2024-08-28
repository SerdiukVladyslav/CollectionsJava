package collections.classes;

import java.util.Map;

public class MapUtils {
    public static void printMap(String mapName, Map<Integer, String> map) {
        System.out.println(mapName + ":");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
