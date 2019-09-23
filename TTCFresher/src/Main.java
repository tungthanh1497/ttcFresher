import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

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
            long min = Math.round(ts / (1000 * 60 * 1.0));
            System.out.println("Math round minute: " + min);
            long hour = Math.round(ts / (1000 * 60 * 60 * 1.0));
            System.out.println("Math round hour: " + hour);
            long day = Math.round(ts / (1000 * 60 * 60 * 24 * 1.0));
            System.out.println("Math round day: " + day);

        } catch (Exception e) {
            System.out.println("Wrong Input.");
        }
    }

    private static void compareDate() {
        System.out.print("Input date a (yyyy-MM-dd HH:mm:ss): ");
        String dateStrA = sc.nextLine().trim();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dateA = formatter.parse(dateStrA);
            System.out.print("Input date b (yyyy-MM-dd HH:mm:ss): ");
            String dateStrB = sc.nextLine().trim();
            Date dateB = formatter.parse(dateStrB);

            System.out.println("a>b: " + (dateA.after(dateB)));

            long remainTime = Math.abs(dateA.getTime() - dateB.getTime());
            long days = TimeUnit.MILLISECONDS.toDays(remainTime);
            long year = 0, month = 0, day = 0;
            if (days < 30) {
                day = days;
            } else if (days < 30 * 12) {
                month = days / 30;
                day = days % 30;
            } else {
                year = days / (12 * 30);
                month = (days - year * 12 * 30) / 12;
                day = days - year * 12 * 30 - month * 30;
            }
            remainTime -= TimeUnit.DAYS.toMillis(days);
            long hour = TimeUnit.MILLISECONDS.toHours(remainTime);
            remainTime -= TimeUnit.HOURS.toMillis(hour);
            long min = TimeUnit.MILLISECONDS.toMinutes(remainTime);
            remainTime -= TimeUnit.MINUTES.toMillis(min);
            long sec = TimeUnit.MILLISECONDS.toSeconds(remainTime);
            String result = year + " year " + month + " month " + day + " day " + hour + " hour " + min + " minute " + sec + " second";

            System.out.println("Remain time: " + result);
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
            int month = cal.get(Calendar.MONTH) + 1;
            int year = cal.get(Calendar.YEAR);

            System.out.println("First: " + year + "/" + month + "/01");
            System.out.println("Last: " + year + "/" + month + "/" + cal.getActualMaximum(Calendar.DAY_OF_MONTH));

            Calendar cal2 = Calendar.getInstance();
            cal2.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
            System.out.println("First day of week: " + cal2.get(Calendar.YEAR) + "/" + (cal2.get(Calendar.MONTH) + 1) + "/" + cal2.get(Calendar.DATE));

            Calendar cal3 = cal;
            cal3.add(Calendar.DATE, 100);
            System.out.println("After 100 days: " + cal3.get(Calendar.YEAR) + "/" + (cal3.get(Calendar.MONTH) + 1) + "/" + cal3.get(Calendar.DATE));

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
        String mergedStr = "";
        if (strList.size() > 0) {
            mergedStr = strList.get(0);
        }
        for (int i = 1; i < strList.size(); i++) {
            mergedStr += "," + strList.get(i);
        }
        System.out.println(mergedStr);

        List<String> reverseStrList = new ArrayList<>();
        String[] splited = mergedStr.split(",");
        for (String s : splited) {
            reverseStrList.add(s);
        }
        System.out.println("[");
        for (String s : reverseStrList) {
            System.out.println("\t" + s);
        }
        System.out.println("]");
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
                Map.Entry<String, Integer> maxEntry = null;
                for (Map.Entry<String, Integer> entry : mapStr.entrySet()) {
                    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                        maxEntry = entry;
                    }
                }
                System.out.println("Max character: " + maxEntry.getKey());
            }
        }

        Map.Entry<String, Integer> maxEntry = null;
        System.out.println("Map:");
        for (Map.Entry<String, Integer> entry : mapStr.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
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
        for (Bill b : billSet) {
            System.out.println(b);
        }
    }

    private static void splitBillListByDate2(List<Bill> billList) {
        HashMap<String, List<Bill>> mapDate = filterBillListByDate(billList);
        List<List<Bill>> billLists = new ArrayList<>();
        Iterator iterator = mapDate.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry me2 = (Map.Entry) iterator.next();
            List<Bill> bList = (List<Bill>) me2.getValue();
            billLists.add(bList);
        }
        for (List<Bill> lb : billLists) {
            System.out.println("[");
            for (Bill b : lb) {
                System.out.println("\t" + b);
            }
            System.out.println("]");
        }
    }

    private static void splitBillListByDate(List<Bill> billList) {
        HashMap<String, List<Bill>> mapDate = filterBillListByDate(billList);
        Iterator iterator = mapDate.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry me2 = (Map.Entry) iterator.next();
            System.out.println("+++ " + me2.getKey());
            List<Bill> bList = (List<Bill>) me2.getValue();
            for (Bill b : bList) {
                System.out.println(b);
            }
        }
    }

    private static void getListMoneyOver1m(List<Bill> billList) {
        List<Bill> over1mBillList = new ArrayList<>();
        for (Bill b : billList) {
            if (b.getMoney() > 1000000) {
                over1mBillList.add(b);
            }
        }
        if (over1mBillList.size() <= 0) {
            System.out.println("There is no bill has money over 1000000");
        } else {
            for (Bill b : over1mBillList) {
                System.out.println(b);
            }
        }
    }

    private static HashMap<String, List<Bill>> filterBillListByDate(List<Bill> billList) {
        HashMap<String, List<Bill>> mapDate = new HashMap<>();
        for (Bill b : billList) {
            if (mapDate.get(b.getDate()) == null) {
                List<Bill> billSameDateList = new ArrayList<>();
                billSameDateList.add(b);
                mapDate.put(b.getDate(), billSameDateList);
            } else {
                List<Bill> billSameDateList = mapDate.get(b.getDate());
                billSameDateList.add(b);
                mapDate.put(b.getDate(), billSameDateList);
            }
        }
        return mapDate;
    }

    private static void getDistinctDate(List<Bill> billList) {
        HashMap<String, List<Bill>> mapDate = filterBillListByDate(billList);
        Iterator iterator = mapDate.entrySet().iterator();
        List<String> dateList = new ArrayList<>();
        while (iterator.hasNext()) {
            Map.Entry me2 = (Map.Entry) iterator.next();
            dateList.add(me2.getKey() + "");
        }
        for (String s : dateList) {
            System.out.println(s);
        }
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
        for (Bill b : billList) {
            System.out.println(b);
        }
    }

    private static void addBill(List<Bill> billList, Set<Bill> billSet) {
        System.out.print("Id: ");
        int id = 0;
        try {
            id = Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Wrong Input.");
            return;
        }
        System.out.print("Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Money: ");
        long money = 0;
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
        String[] splited = arr.split(" ");
        List<Integer> iList = new ArrayList<>();
        for (String s : splited) {
            try {
                int i = Integer.parseInt(s);
                iList.add(i);
            } catch (Exception e) {
                iList = null;
                break;
            }
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
