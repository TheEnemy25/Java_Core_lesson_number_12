package first;

import java.util.*;

public class Main extends Menu {
    public static void main(String[] args) throws IllegalAccessException {
        //      Перше завдання
        List list = new ArrayList();
        list.add(22);
        list.add(10);
        list.add(20);
        list.add(675);
        list.add(99);
        list.add(1002);
        list.add(4323);
        list.add(754);
        System.out.println("До сортування :");
        for (Object sort : list) {
            System.out.print(sort + "; ");
        }

        Collections.sort(list);
        System.out.println();
        System.out.println();
        System.out.println("Відсортування в порядку зростання :");
        for (Object sort : list) {
            System.out.print(sort + "; ");
        }

        Collections.sort(list, Collections.reverseOrder());
        System.out.println();
        System.out.println();
        System.out.println("Відсортування в порядку спадання :");
        for (Object sort : list) {
            System.out.println(sort + "; ");
        }


//     Друге завдання
        Scanner scanner = new Scanner(System.in);

        while (true) {
            menu();
            switch (scanner.next()) {
                case "1": {

                    List list1 = toList(getRandomValue(1, 6));
                    for (Object car : list1) {
                        System.out.println(car);
                    }
                    break;
                }
                case "2": {
                    List list1 = toList(getRandomValue(1, 6));
                    list1.addAll(1, list1);

                    for (Object car : list1) {
                        System.out.println(car);
                    }

                    break;
                }
            }
        }
    }

    public static List toList(int count) throws IllegalAccessException {
        List list = new ArrayList();
        for (int i = 0; i < count; i++) {
            list.add(new Car(getRandomValue(10, 100), getRandomValue(10, 100)));
        }
        return list;
    }

    public static int getRandomValue(int min, int max) throws IllegalAccessException {
        if (min >= max) {
            throw new IllegalAccessException("Не правильне твердження");
        }

        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }


}