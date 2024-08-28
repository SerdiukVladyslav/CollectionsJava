package collections.classes;

import java.util.*;

public class CollectionsExample {

    public static void main(String[] args) {
        // 1. Базовая работа с List
        List<String> list1 = new ArrayList<>();
        String[] array = {"one", "two", "three", "four"};
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>(list1);
        List<String> list3 = Arrays.asList("five", "six", "seven");
        list2.addAll(list2.size() / 2, list3);
        list2.sort(Collections.reverseOrder());

        ListIterator<String> iterator = list2.listIterator();
        boolean remove = false;
        while (iterator.hasNext()) {
            iterator.next();
            if (remove) {
                iterator.remove();
            }
            remove = !remove;
        }
        System.out.println("List2 after operations: " + list2);

        // 2. Базовая работа с Set
        Set<String> set1 = new HashSet<>();
        set1.add("random1");
        set1.add("random2");
        set1.addAll(list1);
        set1.addAll(list2);
        System.out.println("Set1: " + set1);

        Set<String> set2 = new LinkedHashSet<>();
        set2.addAll(list2);
        set2.addAll(list3);
        System.out.println("Set2: " + set2);

        // 3. Базовая работа с Map
        Map<Integer, String> map1 = new LinkedHashMap<>();
        map1.put(1, "January");
        map1.put(2, "February");
        map1.put(3, "March");
        map1.put(4, "April");
        map1.put(5, "May");
        map1.put(6, "June");
        map1.put(7, "July");
        map1.put(8, "August");
        map1.put(9, "September");
        map1.put(10, "October");
        map1.put(11, "November");
        map1.put(12, "December");

        System.out.println("First month: " + map1.get(1));
        System.out.println("Last month: " + map1.get(12));

        map1.put(6, "ОТПУСК");
        System.out.println("Map1 after vacation update: " + map1);

        Map<Integer, String> map2 = new HashMap<>();
        map2.putAll(map1);

        MapUtils.printMap("Map1", map1);
        MapUtils.printMap("Map2", map2);

        // 4. Работа со своим классом
        // a. Создать класс User с полями name, old и phone
        // b. Создать userSet (HashSet<User>)
        Set<User> userSet = new HashSet<>();

        // c. Создать 2 экземпляра класса User с одинаковыми полями и 1 экземпляр отличающийся возрастом
        User user1 = new User("Alice", 25, "123456789");
        User user2 = new User("Vlad", 18, "1234567890");
        User user3 = new User("Yarik", 20, "12345678");

        // d. Добавить пользователей в userSet
        userSet.add(user1);
        userSet.add(user2);
        userSet.add(user3);

        // e. Вывести пользователей на экран
        System.out.println("UserSet before hashCode change: " + userSet);

        // f. Переопределить в классе User метод hashCode, указав в нем только обработку поля name
        user1.setHashCodeMode(User.HashCodeMode.NAME_ONLY);
        user2.setHashCodeMode(User.HashCodeMode.NAME_ONLY);
        user3.setHashCodeMode(User.HashCodeMode.NAME_ONLY);

        // Пересоздать userSet, чтобы изменения в hashCode вступили в силу
        userSet = new HashSet<>(userSet);
        System.out.println("UserSet after hashCode change (name only): " + userSet);

        // h. Переопределить в классе User метод hashCode, указав в нем все поля класса
        user1.setHashCodeMode(User.HashCodeMode.ALL_FIELDS);
        user2.setHashCodeMode(User.HashCodeMode.ALL_FIELDS);
        user3.setHashCodeMode(User.HashCodeMode.ALL_FIELDS);

        // Пересоздать userSet, чтобы изменения в hashCode вступили в силу
        userSet = new HashSet<>(userSet);
        System.out.println("UserSet after hashCode change (all fields): " + userSet);
    }
}
