import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdOut;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTransaction {
    private static final int[] DAYS = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static boolean isLeapYear(int y) {
        if (y % 400 == 0) {
            return true;
        } else if (y % 100 == 0) {
            return false;
        } else {
            return y % 4 == 0;
        }
    }

    private static boolean isValid(int m, int d, int y) {
        if (m >= 1 && m <= 12) {
            if (d >= 1 && d <= DAYS[m]) {
                return m != 2 || d != 29 || isLeapYear(y);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    //1.2.11
    public static boolean smartDate(Date d) {
        if (!isValid(d.month(), d.day(), d.year())) throw new IllegalArgumentException("Invalid date");
        else return true;
    }

    //1.2.12
    public static String dayOfWeek(Date d) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            java.util.Date myDate = format.parse(Integer.toString(d.day()) + "/" +
                    Integer.toString(d.month()) + "/" + Integer.toString(d.year()));
            format.applyPattern("EEE, d MMM yyyy");
            return format.format(myDate);
        } catch (ParseException e) {
            return e.toString();
        }
    }

    public static void main(String[] args) {
        //month, day, year
        Date d = new Date(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        StdOut.println(d);
        StdOut.println(smartDate(d));

        StdOut.println(dayOfWeek(d));
    }
}
