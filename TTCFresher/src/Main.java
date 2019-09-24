import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.time.Period;
import java.util.stream.Collectors;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static int WRONG_VALUE = -1;
    private static int WRONG_CHOICE = -2;

    public static void main(String[] args) {
        int selected = WRONG_VALUE;
        while (selected != 0) {
            if (selected == WRONG_CHOICE) {
                System.out.print("Your choice must be an integer from 0 to 5. Try again: ");
            } else {
                System.out.print("Select question:\n"
                        + "1. Calculate sum (I.1)\n"
                        + "2. Sort ascending (I.2)\n"
                        + "3. BILL (I.3-8)\n"
                        + "4. String (II)\n"
                        + "5. Date (III)\n"
                        + "0. Exit\n"
                        + "Your choice :"
                );
            }
            try {
                selected = Integer.parseInt(sc.nextLine().trim());
                if (selected < 0) {
                    selected = WRONG_CHOICE;
                } else {
                    System.out.println("============================================================");
                    switch (selected) {
                        case 1:
                            calSum();
                            break;
                        case 2:
                            sortArray();
                            break;
                        case 3:
                            billProblem();
                            break;
                        case 4:
                            stringProblem();
                            break;
                        case 5:
                            dateProblem();
                            break;
                        case 0:
                            System.out.println("GOODBYE!!!");
                        default:
                            break;
                    }
                    System.out.println("============================================================");
                }
            } catch (Exception e) {
                selected = WRONG_CHOICE;
            }
        }
    }

    private static void dateProblem() {
        int selected = WRONG_VALUE;
        while (selected != 0) {
            if (selected == WRONG_CHOICE) {
                System.out.print("Your choice must be an integer from 0 to 4. Try again: ");
            } else {
                System.out.print("Select question:\n"
                        + "1. Convert string to date (III. 1-2)\n"
                        + "2. Compare date (III. 3-4)\n"
                        + "3. Timestamp (III. 5-6)\n"
                        + "4. Change Format (III. 7)\n"
                        + "0. Exit\n"
                        + "Your choice: "
                );
            }
            try {
                selected = Integer.parseInt(sc.nextLine().trim());
                if (selected < 0) {
                    selected = WRONG_CHOICE;
                } else {
                    System.out.println("========================================");
                    switch (selected) {
                        case 1:
                            convertStringToDate();
                            break;
                        case 2:
                            compareDate();
                            break;
                        case 3:
                            stringToTimeStamp();
                            break;
                        case 4:
                            changeFormat();
                            break;
                        default:
                            break;
                    }
                    System.out.println("========================================");
                }
            } catch (Exception e) {
                selected = WRONG_CHOICE;
            }
        }
    }

    private static void changeFormat() {
        System.out.print("Input date (yyyy/MM/dd HH:mm:ss): ");
        String dateStr = sc.nextLine().trim();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf3 = new SimpleDateFormat("MMM yyyy,dd HH:mm:ss");
        try {
            Date date = formatter.parse(dateStr);
            System.out.println(sdf2.format(date));
            System.out.println(sdf3.format(date));
        } catch (Exception e) {
            System.out.println("Wrong Input.");
        }
    }

    private static void stringToTimeStamp() {
        System.out.print("Input date (yyyy-MM-dd HH:mm:ss): ");
        String dateStr = sc.nextLine().trim();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = formatter.parse(dateStr);
            Timestamp timestamp = new Timestamp(date.getTime());
            System.out.println("Timestamp: " + timestamp);

            Date reverseDate = new Date();
            reverseDate.setTime(timestamp.getTime());
            System.out.println("String: " + formatter.format(reverseDate));

            long ts = timestamp.getTime();
            long min = getMinitueZero(ts) / (1000 * 60);
            System.out.println("Math round minute: " + min);
            long hour = getHourZero(ts) / (1000 * 60 * 60);
            System.out.println("Math round hour: " + hour);
            long day = getDayZero(ts) / (1000 * 60 * 60 * 24);
            System.out.println("Math round day: " + day);

        } catch (Exception e) {
            System.out.println("Wrong Input.");
        }
    }

    private static long getMinitueZero(long timeStamp) {
        return timeStamp - (timeStamp % (1000 * 60));
    }

    private static long getHourZero(long timeStamp) {
        return timeStamp - (timeStamp % (1000 * 60 * 60));
    }

    private static long getDayZero(long timeStamp) {
        return timeStamp - (timeStamp % (1000 * 60 * 60 * 24));
    }

    private static void compareDate() {
        System.out.print("Input date a (yyyy-MM-dd HH:mm:ss): ");
        String dateStrA = sc.nextLine().trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {
            LocalDate dateA = LocalDate.parse(dateStrA, formatter);
            System.out.print("Input date b (yyyy-MM-dd HH:mm:ss): ");
            String dateStrB = sc.nextLine().trim();
            LocalDate dateB = LocalDate.parse(dateStrB, formatter);

            System.out.println("a is after b: " + (dateA.isAfter(dateB)));

            Period period = Period.between(dateA, dateB);
            System.out.println("Remain time: " + period.getYears() + " year " + period.getMonths() + " month " + period.getDays() + " day ");

        } catch (Exception e) {
            System.out.println("Wrong Input.");
        }
    }

    private static void convertStringToDate() {
        System.out.print("Input date (yyyy-MM-dd HH:mm:ss): ");
        String dateStr = sc.nextLine().trim();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = formatter.parse(dateStr);
            System.out.println(formatter.format(date));


            Calendar cal = Calendar.getInstance();
            cal.setTime(date);

            SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy/MM/dd");

            cal.set(Calendar.DAY_OF_MONTH, 1);
            System.out.println("First: " + formatter2.format(cal.getTime()));

            cal.setTime(date);
            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
            System.out.println("Last: " + formatter2.format(cal.getTime()));

            cal.setTime(date);
            cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
            System.out.println("First day of week: " + formatter2.format(cal.getTime()));

            cal.setTime(date);
            cal.add(Calendar.DATE, 100);
            System.out.println("After 100 days: " + formatter2.format(cal.getTime()));

        } catch (ParseException e) {
            System.out.println("Wrong Input.");
        }
    }

    private static void stringProblem() {
        int selected = WRONG_VALUE;
        while (selected != 0) {
            if (selected == WRONG_CHOICE) {
                System.out.print("Your choice must be an integer from 0 to 4. Try again: ");
            } else {
                System.out.print("Select question:\n"
                        + "1. Find in String (II.1)\n"
                        + "2. Max occurrences (II.2)\n"
                        + "3. Merge list string (II.3-4)\n"
                        + "4. Replace (II.5)\n"
                        + "0. Exit\n"
                        + "Your choice: "
                );
            }
            try {
                selected = Integer.parseInt(sc.nextLine().trim());
                if (selected < 0) {
                    selected = WRONG_CHOICE;
                } else {
                    System.out.println("========================================");
                    switch (selected) {
                        case 1:
                            findInString();
                            break;
                        case 2:
                            maxOccurrences();
                            break;
                        case 3:
                            meargeListString();
                            break;
                        case 4:
                            replaceAllRaw();
                            break;
                        default:
                            break;
                    }
                    System.out.println("========================================");
                }
            } catch (Exception e) {
                selected = WRONG_CHOICE;
            }
        }
    }

    private static void replaceAllRaw() {
        System.out.print("Input raw: ");
        String raw = sc.nextLine().trim();
        System.out.print("Input from: ");
        String from = sc.nextLine().trim();
        System.out.print("Input to: ");
        String to = sc.nextLine().trim();
        String result = raw.replaceAll(from, to);
        System.out.println(result);
    }

    private static void meargeListString() {
        System.out.println("Input list String (stop with 'N'): ");
        String inputStr = "";
        List<String> strList = new ArrayList<>();
        while (!inputStr.equals("N")) {
            inputStr = sc.nextLine().trim();
            if (inputStr.length() > 0 && !inputStr.equals("N")) strList.add(inputStr);
        }

        String mergedStr = String.join(",", strList);
        System.out.println(mergedStr);

        List<String> reverseStrList = Arrays.asList(mergedStr.split(","));

        System.out.println(reverseStrList);
    }

    private static void maxOccurrences() {
        System.out.print("Input String: ");
        String baseStr = sc.nextLine().trim();
        baseStr = baseStr.replaceAll("\\s", "");
        System.out.println("Base String: " + baseStr);
        HashMap<String, Integer> mapStr = new HashMap<>();
        for (int subLength = 1; subLength <= baseStr.length(); subLength++) {
            for (int subIndex = 0; subIndex < baseStr.length() - subLength; subIndex++) {
                String currentStr = baseStr.substring(subIndex, subIndex + subLength);
                if (mapStr.get(currentStr) == null) {
                    mapStr.put(currentStr, 1);
                } else {
                    mapStr.put(currentStr, mapStr.get(currentStr) + 1);
                }
            }
            if (subLength == 1) {
                Optional<Map.Entry<String, Integer>> maxEntry = mapStr.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
                System.out.println("Max character: " + maxEntry.get().getKey());
            }
        }

        System.out.println("Map: [");
        mapStr.entrySet().stream().forEach(item -> System.out.println("\t" + item.getKey() + " - " + item.getValue()));
        System.out.println("]");
    }

    private static void findInString() {
        System.out.print("Input base String: ");
        String baseStr = sc.nextLine().trim();
        System.out.print("Input searching String: ");
        String searchingStr = sc.nextLine().trim();
        String[] splited = baseStr.split(searchingStr);
        int count = splited.length - 1;
        if (baseStr.endsWith(searchingStr)) {
            count++;
        }


        System.out.println("Number of occurrences: " + count);
        if (count > 0) {
            System.out.println("Index of first: " + baseStr.indexOf(searchingStr));
            if (count > 1) {
                System.out.println("Index of last: " + baseStr.lastIndexOf(searchingStr));
                if (count > 2) {
                    System.out.print("Input n (1-" + count + "): ");
                    int n = 0;
                    try {
                        n = Integer.parseInt(sc.nextLine().trim());
                        if (n <= 0) {
                            System.out.println("Wrong Input.");
                            return;
                        } else {
                            int index = 0;
                            for (int i = 0; i < n; i++) {
                                index += splited[i].length() + searchingStr.length();
                            }
                            index -= searchingStr.length();
                            System.out.println("Index of " + n + ": " + index);
                        }
                    } catch (Exception e) {
                        System.out.println("Wrong Input.");
                        return;
                    }
                }
            }
        }
    }

    private static void billProblem() {
        List<Bill> billList = new ArrayList<>();
        Set<Bill> billSet = new HashSet<>();
        int selected = WRONG_VALUE;
        while (selected != 0) {
            if (selected == WRONG_CHOICE) {
                System.out.print("Your choice must be an integer from 0 to 8. Try again: ");
            } else {
                System.out.print("Select question:\n"
                        + "1. Add Bill\n"
                        + "2. View Bills\n"
                        + "3. Sort by money (I.3)\n"
                        + "4. Get distinct date list (I.4)\n"
                        + "5. Money > 1.000.000 (I.5)\n"
                        + "6. Get HashMap<String, List<Bill>> by date (I.6)\n"
                        + "7. Get List<List<Bill>> by date (I.7)\n"
                        + "8. Set<Bill> (I.8)\n"
                        + "0. Exit\n"
                        + "Your choice: "
                );
            }
            try {
                selected = Integer.parseInt(sc.nextLine().trim());
                if (selected < 0) {
                    selected = WRONG_CHOICE;
                } else {
                    System.out.println("========================================");
                    switch (selected) {
                        case 1:
                            addBill(billList, billSet);
                            break;
                        case 2:
                            viewBills(billList);
                            break;
                        case 3:
                            sortByMoney(billList);
                            break;
                        case 4:
                            getDistinctDate(billList);
                            break;
                        case 5:
                            getListMoneyOver1m(billList);
                            break;
                        case 6:
                            splitBillListByDate(billList);
                            break;
                        case 7:
                            splitBillListByDate2(billList);
                            break;
                        case 8:
                            getSetBill(billSet);
                        default:
                            break;
                    }
                    System.out.println("========================================");
                }
            } catch (Exception e) {
                selected = WRONG_CHOICE;
            }
        }
    }

    private static void getSetBill(Set<Bill> billSet) {
        billSet.stream().forEach(System.out::println);
    }

    private static void splitBillListByDate2(List<Bill> billList) {
        HashMap<String, List<Bill>> mapDate = filterBillListByDate(billList);


        List<List<Bill>> billLists = new ArrayList<>();
        mapDate.keySet().stream().forEach(item -> billLists.add(mapDate.get(item)));

        System.out.println("[");
        billLists.stream().forEach(item -> System.out.println("\t" + item));
        System.out.println("]");
    }

    private static void splitBillListByDate(List<Bill> billList) {
        HashMap<String, List<Bill>> mapDate = filterBillListByDate(billList);
        mapDate.entrySet().stream().forEach(item -> {
            System.out.println("+++ " + item.getKey());
            item.getValue().stream().forEach(itemValue -> System.out.println(itemValue));
        });
    }

    private static void getListMoneyOver1m(List<Bill> billList) {
        billList.stream().filter(bill -> bill.getMoney() > 1000000).forEach(System.out::println);
    }

    private static HashMap<String, List<Bill>> filterBillListByDate(List<Bill> billList) {
        HashMap<String, List<Bill>> mapDate = new HashMap<>();
        billList.stream().forEach(item -> {
            if (mapDate.containsKey(item.getDate())) {
                mapDate.get(item.getDate()).add(item);
            } else {
                List<Bill> billSameDateList = new ArrayList<>();
                billSameDateList.add(item);
                mapDate.put(item.getDate(), billSameDateList);
            }
        });
        return mapDate;
    }

    private static void getDistinctDate(List<Bill> billList) {
        HashMap<String, List<Bill>> mapDate = filterBillListByDate(billList);
        mapDate.keySet().stream().forEach(System.out::println);
    }

    private static void sortByMoney(List<Bill> billList) {
        Collections.sort(billList, new Comparator<Bill>() {
            @Override
            public int compare(Bill o1, Bill o2) {
                if ((o1.getMoney() - o2.getMoney()) < 0)
                    return -1;
                else if ((o1.getMoney() - o2.getMoney()) == 0)
                    return 0;
                else return 1;
            }
        });
        viewBills(billList);
    }

    private static void viewBills(List<Bill> billList) {
        billList.stream().forEach(System.out::println);
    }

    private static void addBill(List<Bill> billList, Set<Bill> billSet) {
        System.out.print("Id: ");
        int id;
        try {
            id = Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Wrong Input.");
            return;
        }
        System.out.print("Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Money: ");
        long money;
        try {
            money = Long.parseLong(sc.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Wrong Input.");
            return;
        }
        System.out.print("Date (yyyy-MM-dd): ");
        String date = sc.nextLine().trim();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date testDate = formatter.parse(date);
            date = formatter.format(testDate);
        } catch (ParseException e) {
            System.out.println("Wrong Input.");
            return;
        }
        Bill bill = new Bill(id, name, money, date);
        billList.add(bill);
        billSet.add(bill);

        System.out.println("Bill was added");
    }

    private static void sortArray() {
        System.out.print("Input an integer array (1 2 3 ...): ");
        String arr = sc.nextLine().trim();
        List<String> splited = Arrays.asList(arr.split("\\s+"));
        List<Integer> iList;
        try {
            iList = splited.stream().map(Integer::parseInt).collect(Collectors.toList());
        } catch (Exception e) {
            iList = null;
        }
        if (iList == null) {
            System.out.println("Wrong input.");
        } else {
            System.out.println("Default: " + iList);
            Collections.sort(iList);
            System.out.println("Sorted: " + iList);
        }
    }

    private static void calSum() {
        System.out.print("Input a natural number:");
        try {
            int n = Integer.parseInt(sc.nextLine().trim());
            if (n < 0) {
                System.out.println("Number input must be a natural number.");
            } else {
                System.out.println("Sum: " + ((n + 1) * n / 2));
            }
        } catch (Exception e) {
            System.out.println("Wrong input.");
        }
    }
}
