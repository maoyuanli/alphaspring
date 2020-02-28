package com.alphasmart.alphaspring.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class TickersAndSources {
    public static ArrayList<String> getTickers() {
        return new ArrayList<String>(Arrays.asList("ABN", "ADYEN", "INGA", "KPN", "RDSA", "BNP"));
    }

    public static ArrayList<String> getSources() {
        return new ArrayList<String>(Arrays.asList("marketwatch", "wsj", "ft", "business", "theeconomist", "cnbc", "barronsonline"));
    }
}
