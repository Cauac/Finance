package finance;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ApplicationUtils {

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static final DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("yyyy-MM");
    public static final DecimalFormat moneyFormat = new DecimalFormat();
    public static final Map<String, LocalDate> dateRangeMap = new LinkedHashMap<>();

    static {
        moneyFormat.setMaximumFractionDigits(3);
        initRangeMap();
    }

    public static String getPercent(long x, long y) {
        double r = x;
        double z = y;
        return String.format("%1$,.2f", (r / z) * 100) + "%";
    }


    public static String formatMoney(long m) {
        return moneyFormat.format(m);
    }

    private static void initRangeMap() {
        DateTimeFormatter YEAR_MONTH = DateTimeFormatter.ofPattern("LLLL yyyy");
        LocalDate today = LocalDate.now();
        LocalDate date = LocalDate.of(2013, 11, 1);
        do {
            dateRangeMap.put(YEAR_MONTH.format(date), date);
            date = date.plusMonths(1);
        } while (!date.isAfter(today));
    }

    public static List<String> getMonthRanges() {
        return new ArrayList<>(dateRangeMap.keySet());
    }
}
