package com.zhu.framework.bean;

/**
 * 封装表单参数
 */
public class FormParam {
    private String fieldName;
    private Object fieldValue;

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public FormParam(String fieldName, Object fieldValue) {

        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
