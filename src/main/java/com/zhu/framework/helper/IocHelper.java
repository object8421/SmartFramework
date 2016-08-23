package com.zhu.framework.helper;

import com.zhu.framework.annotation.Inject;
import com.zhu.framework.util.ArrayUtil;
import com.zhu.framework.util.CollectionUtil;
import com.zhu.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 依赖注入助手类
 * 实现思想：通过BeanHelper获取所有Bean Map，然后遍历整个映射关系，取出Bean类和Bean实例，
 * 通过反射获取类中的所有成员变量。遍历这些变量，判断这些成员变量是否有Inject注解，
 * 若有，则在Bean Map中取出Bean实例
 */
public final class IocHelper {
    static {
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            // 遍历beanMap
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                // 获取Bean类中定义的所有成员变量
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(beanFields)) {
                    // 遍历bean Field
                    for (Field beanField : beanFields) {
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }

            }
        }
    }
}
