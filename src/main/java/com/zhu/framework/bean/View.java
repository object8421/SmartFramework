package com.zhu.framework.bean;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * view类型视图对象，返回jsp页面
 */
public class View {
    /**
     * 视图路径
     */
    private String path;

    private Map<String, Object> model;

    public View(String path) {
        this.path = path;
        model = Maps.newHashMap();
    }

    public View addModel(String key, Object value) {
        model.put(key, value);
        return this;
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
