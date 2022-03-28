package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author andri
 * @see Menu,Months,Seasons
 * @since 1.8
 */

/* Name of class*/
public class Calendar extends Menu {

    public static void main(String[] args) {

        List<Months> list = new ArrayList();
        list.add(Months.January);
        list.add(Months.February);
        list.add(Months.March);
        list.add(Months.April);
        list.add(Months.May);
        list.add(Months.June);
        list.add(Months.July);
        list.add(Months.August);
        list.add(Months.September);
        list.add(Months.October);
        list.add(Months.November);
        list.add(Months.December);
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            /**
             * @since 1.8
             * @author andri
             * @see Menu;
             * */
            menu();

            switch (scanner.next()) {
                //1 Перевірити чи є такий місяць
                case "1": {
                    System.out.println("Введіть місяць");
                    scanner = new Scanner(System.in);
                    String scan = scanner.next();

                    boolean flag = isFlag(list, scan);
                    if (!flag) {
                        System.out.println("Не існує");
                    }
                    break;
                }
                //2 Вивести всі місяці з такою ж порою року
                case "2": {
                    System.out.println("Введіть пору року");
                    scanner = new Scanner(System.in);
                    String scan = scanner.next();

                    boolean flag = false;

                    for (Months list1 : list) {
                        if (scan.equalsIgnoreCase(list1.getSeasons().name())) {
                            flag = true;
                            System.out.println(list1);
                        }
                    }

                    if (!flag) {
                        System.out.println("не існує");
                    }
                    break;
                }
                //3 Вивести всі місяці які мають таку саму кількість днів
                case "3": {
                    System.out.println("Введіть цифри (28,30,31) ");
                    scanner = new Scanner(System.in);
                    String scan = scanner.next();

                    boolean flag = false;

                    for (Months list1 : list) {
                        if (list1.getDays() == Integer.parseInt(scan)) {
                            flag = true;
                        }
                    }
                    if (flag) {
                        for (Months list2 : list) {
                            if (list2.getDays() == Integer.parseInt(scan)) {
                                System.out.println(list2.name());
                            }
                        }
                    }
                    if (!flag) {
                        System.out.println("не існує");
                    }
                    break;
                }
                //4 Вивести на екран всі місяці які мають меншу кількість днів
                case "4": {
                    for (Months list1 : list) {
                        if (list1.getDays() == minValue(list1)) {
                            System.out.println(list1.name());
                        }
                    }
                    break;
                }
                //5 Вивести на екран всі місяці які мають більшу кількість днів
                case "5": {
                    for (Months list1 : list) {
                        if (list1.getDays() == maxValue(list1)) {
                            System.out.println(list1.name());
                        }
                    }
                    break;
                }
                //6 Вивести на екран наступну пору року
                case "6": {
                    System.out.println("Введіть місяць");
                    scanner = new Scanner(System.in);
                    String scan = scanner.next();

                    boolean flag = isFlag(list, scan);

                    if (flag) {
                        Months list1 = Months.valueOf(scan);
                        int ordinal = list1.ordinal();

                        if (ordinal == list.size() - 1) {
                            ordinal = 0;
                            System.out.println(list.get(ordinal).name());
                        } else {
                            System.out.println(list.get(ordinal + 1).name());
                        }
                    }
                    if (!flag) {
                        System.out.println("не існує");
                    }
                    break;
                }
                //7 Вивести на екран попередню пору року
                case "7": {
                    System.out.println("Введіть місяць");
                    scanner = new Scanner(System.in);
                    String scan = scanner.next();

                    boolean flag = isFlag(list, scan);

                    if (flag) {
                        Months result2 = Months.valueOf(scan);
                        int ordinal = result2.ordinal();

                        if (ordinal == list.size() + 1) {
                            ordinal = 0;
                            System.out.println(list);
                        } else if (ordinal == 0) {
                            int maxOrdinal = 0;
                            for (Months month : list) {
                                if (month.ordinal() > maxOrdinal) {
                                    maxOrdinal = month.ordinal();
                                }
                            }
                            System.out.println(list.get(maxOrdinal).name());
                        } else {
                            System.out.println(list.get(ordinal - 1).name());
                        }
                    }
                    if (!flag) {
                        System.out.println("не існує");
                    }
                    break;
                }
                //8 Вивести на екран всі місяці які мають парну кількість днів
                case "8": {
                    for (Months list1 : list) {
                        if (list1.getDays() % 2 == 0) {
                            System.out.println(list1.name());
                        }
                        break;
                    }
                }
                //9 Вивести на екран всі місяці які мають непарну кількість днів
                case "9": {
                    for (Months list1 : list) {
                        if (list1.getDays() % 2 == 1) {
                            System.out.println(list1.name());
                        }
                    }
                    break;
                }
                //0 Вивести на екран чи введений з консолі місяць має парну кількість днів
                case "0": {
                    System.out.println("Введіть місяць");
                    scanner = new Scanner(System.in);
                    String scan = scanner.next();

                    for (Months month : list) {
                        if (month.name().equalsIgnoreCase(scan)) {
                            if (month.getDays() % 2 == 0) {
                                System.out.println("Парне " + month.name());
                            } else {
                                System.out.println("Не парне " + month.name());
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean isFlag(List<Months> list, String scan) {
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            if (scan.equalsIgnoreCase(list.get(i).name())) {
                System.out.println("Існує");
                flag = true;
            }
        }
        return flag;
    }

    /**
     * @param months
     * @author andri
     * @since 1.8
     */

    /* Determination of the minimum value */
    private static int minValue(Months months) {
        int minValue = months.getDays();
        for (Months m : Months.values()) {
            if (minValue > m.getDays()) {
                minValue = m.getDays();
            }
        }
        return minValue;
    }

    /**
     * @param months
     * @author andri
     * @see java code convention
     * @since 1.8
     */

    /* Determination of the maximum value  */
    private static int maxValue(Months months) {
        int maxValue = months.getDays();
        for (Months m : Months.values()) {
            if (maxValue < m.getDays()) {
                maxValue = m.getDays();
            }
        }
        return maxValue;
    }
}