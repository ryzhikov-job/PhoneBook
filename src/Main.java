import java.util.*;

public class Main {
    public static void addNumber(String key, int value, Map<String, Set<Integer>> map) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            Set<Integer> set = new TreeSet<>();
            set.add(value);
            map.put(key, set);
        }
    }

    public static void printBook(Map<String, Set<Integer>> map) {
        LinkedHashMap<String, Set<Integer>> sortedMap = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));

        for (var item : sortedMap.entrySet()) {
            String phones = "";
            for (int phone : item.getValue()) {
                phones += phone + ", ";
            }
            if (!phones.isEmpty()) {
                phones = phones.substring(0, phones.length() - 2);
            }
            System.out.printf("%s: %s \n", item.getKey(), phones);
        }
    }

    public static void main(String[] args) {
        Map<String, Set<Integer>> bookPhone = new HashMap<>();
        addNumber("John", 5551234, bookPhone);
        addNumber("John", 5551234, bookPhone);
        addNumber("John", 5555678, bookPhone);
        addNumber("Jeffrey", 5559876, bookPhone);
        addNumber("Jeffrey", 5558765, bookPhone);
        addNumber("Jeffrey", 5552345, bookPhone);
        addNumber("Daenerys", 5556789, bookPhone);
        addNumber("Sansa", 5554321, bookPhone);
        addNumber("Sansa", 5557890, bookPhone);
        addNumber("Tyrion", 5559456, bookPhone);
        addNumber("Tyrion", 5554456, bookPhone);
        addNumber("Tyrion", 5551456, bookPhone);
        addNumber("Tyrion", 5553256, bookPhone);
        addNumber("Cersei", 5558765, bookPhone);
        addNumber("Cersei", 5552109, bookPhone);
        printBook(bookPhone);
    }
}
