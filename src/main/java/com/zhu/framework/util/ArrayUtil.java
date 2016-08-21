package com.zhu.framework.util;

import org.apache.commons.lang3.ArrayUtils;

public abstract class ArrayUtil {
    public static boolean isNotEmpty(Object[] array) {
        return !ArrayUtils.isNotEmpty(array);
    }
    public static boolean isEmpty(Object[] array) {
        return !ArrayUtils.isEmpty(array);
    }
}
