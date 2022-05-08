package Tools;

import File.StudentFile;
import File.VaccineFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utils {

    private static Scanner sc = new Scanner(System.in);
    private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    public static Date getDate() {
        boolean check = false;
        Date d = null;
        do {
            try {
                String injDate1 = getString("Date 1[dd/mm/yy]:", "Date is empty! Try Again!");
                df.setLenient(false);
                d = df.parse(injDate1);
                check = true;
            } catch (ParseException e) {
                System.out.println("Invalid Date! Try again.");
            }
        } while (check == false);
        return d;
    }

    public static Date getDate2(String inputMsg, Date date1) {
        while (true){
            try {
                System.out.print(inputMsg);
                String injDate2 = sc.nextLine().trim();
                df.setLenient(false);
                Date d2 = df.parse(injDate2);
                if (injDate2.length() == 0 || injDate2.isEmpty()) {
                    return null;
                } else {
                    if (d2.compareTo(date1) < 1 || getDifferenceDays(date1, d2) <= 28) {
                        System.out.println("The 2nd of vaccine must be given 4 to 12 weeks after the first injection");
                        System.out.println("RETURN 2nd VACCINE NULL");
                        return null;
                    } else {
                        return d2;
                    }
                }
            } catch (ParseException e) {
                System.out.println("Invalid Date! Try again.");
            }
        }
    }

    public static int getInt(String inputMsg, String errorMsg) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static double getDouble(String inputMsg, String errorMsg) {
        double n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getID(String inputMsg, String errorMsg, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || match == false) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }

    public static String getString(String inputMsg, String errorMsg) {
        String id;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim();
            if (id.length() == 0 || id.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }

    public static void printTF(boolean check, String trueMessage, String falseMessage) {
        if (check) {
            System.out.println(trueMessage);
        } else {
            System.out.println(falseMessage);
        }
    }

    public static String updateString(String messageString, String oldValue) {
        String result = oldValue;
        System.out.println(messageString);
        String newValue = sc.nextLine().trim();
        if (newValue.isEmpty() || newValue.length() == 0) {
            return result;
        } else {
            return newValue;
        }
    }

    static long getDifferenceDays(Date d1, Date d2) {
        long diffInMillies = Math.abs(d1.getTime() - d2.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return diff;
    }

    public static String getStudentID(String inputMsg, String errorMsg, StudentFile student) {
        String id;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim();
            if (!student.isIDExist(id)) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }

    public static String getVaccineID(String inputMsg, String errorMsg, VaccineFile vaccine) {
        String id;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim();
            if (!vaccine.isIDExist(id)) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }

}
