package com.dev.rahul.liboio.utility;

import java.text.DecimalFormat;

/**
 * Created by rahul on 15/1/18.
 */

public class LibUtil {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.#");
    private static final int THOUSAND = 1000;

    public static String formattedCount(int count) {

        double convertedValue = count;

        if (count >= THOUSAND) {
            return DECIMAL_FORMAT.format(convertedValue/THOUSAND) + "K";
        } else {
            return String.valueOf(count);
        }

    }
}
