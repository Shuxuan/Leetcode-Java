package util;

/**
 * Created by shuxuannie on 7/11/16.
 */
public class Weekday {

    public static int getWeek(int y, int m, int d) {
        if (m < 3) {
            m += 12;
            y--;
        }
        int w = (d + 1 + 2 * m + 3 * (m + 1) / 5 + y + (y >> 2) - y / 100 + y / 400) % 7;
        return w;
    }

    public static void main(String[] args) {
        System.out.println(Weekday.getWeek(2016, 7, 11));
    }
}

