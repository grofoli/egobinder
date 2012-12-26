package com.ego.egobinder.shared;

import java.util.List;

public class GeneralUtil {
    public static <T> boolean isNullOrEmpty(List<T> list) {
        if (list == null ||
                (list != null && list.size() == 0)) {
            return true;
        }
        return false;
    }

    public static boolean isNullOrEmpty(String term) {
        if (term == null) {
            return true;
        }
        if (term.equals("")) {
            return true;
        }
        return false;
    }

    public static String trim(String str) {
        if (str == null
                || (str != null && str.trim().equals(""))) {
            return null;
        }
        return str.trim();
    }

}
