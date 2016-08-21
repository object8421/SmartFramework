package com.zhu.framework.util;

import org.apache.commons.lang3.StringUtils;

public abstract class StringUtil {
    public static boolean isEmpty(String string) {
        if (string != null) {
            string = string.trim();
        }
        return StringUtils.isEmpty(string);
    }
    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }
    /**
     * 按照指定字符分割字符串
     * @param str
     * @param splitStr
     * @return
     */
    public static String[] splitString(String str, String splitStr) {
        return str.split(splitStr);
    }
}
