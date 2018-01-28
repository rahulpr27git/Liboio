package com.dev.rahul.liboio.utility;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by rahul on 15/1/18.
 */

public class LibUtil {

    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.#");
    private static final int THOUSAND = 1000;

    public static String formattedCount(int count) {

        double convertedValue = count;

        if (count >= THOUSAND) {
            return DECIMAL_FORMAT.format(convertedValue/THOUSAND) + "K";
        } else {
            return String.valueOf(count);
        }

    }

    public static final SimpleDateFormat SIMPLE_DATE_FORMAT_WITH_TZ = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT_dd_EEE_YYY = new SimpleDateFormat("dd EEE, yyyy");

    public static String getConvertedDate(String dateTime) {
        try {
            return SIMPLE_DATE_FORMAT_dd_EEE_YYY.format(SIMPLE_DATE_FORMAT_WITH_TZ.parse(dateTime));
        } catch (ParseException e) {
            e.printStackTrace();
            return "NA";
        }
    }

}
