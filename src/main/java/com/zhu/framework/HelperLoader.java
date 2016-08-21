package com.zhu.framework;

import com.zhu.framework.helper.BeanHelper;
import com.zhu.framework.helper.ClassHelper;
import com.zhu.framework.helper.ControllerHelper;
import com.zhu.framework.helper.IocHelper;
import com.zhu.framework.util.ClassUtil;

/**
 * 加载相应的Helper类
 */
public final class HelperLoader {
    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(), false);
        }
    }
}
