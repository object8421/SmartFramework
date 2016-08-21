package com.zhu.framework.helper;

import com.google.common.collect.Maps;
import com.zhu.framework.annotation.Action;
import com.zhu.framework.bean.Handler;
import com.zhu.framework.bean.Request;
import com.zhu.framework.util.ArrayUtil;
import com.zhu.framework.util.CollectionUtil;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

public final class ControllerHelper {
    /**
     * 用于存放请求和处理器的映射关系（简称Action Map）
     */
    private static final Map<Request, Handler> ACTION_MAP = Maps.newHashMap();

    static {
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtil.isNotEmpty(controllerClassSet)) {
            for (Class<?> controllerClass : controllerClassSet) {
                Method[] methods = controllerClass.getDeclaredMethods();
                if (ArrayUtil.isNotEmpty(methods)) {
                    for (Method method :methods) {
                        // 判断当前method是否含有Action注解
                        if (method.isAnnotationPresent(Action.class)) {
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();
                            // 验证URL规则映射
                            if (mapping.matches("\\w+:/\\w*")) {
                                String[] array = mapping.split(":");
                                if (ArrayUtil.isNotEmpty(array) && array.length == 2) {
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod, requestPath);
                                    Handler handler = new Handler(controllerClass, method);
                                    ACTION_MAP.put(request, handler);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 获取Handler
     */
    public static Handler getHandler(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }
}
