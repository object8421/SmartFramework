package com.zhu.framework.bean;

/**
 * data类型数据对象，返回JSON数据
 */
public class Data {
    /**
     * 模型数据
     */
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}
