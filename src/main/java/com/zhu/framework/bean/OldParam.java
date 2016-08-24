package com.zhu.framework.bean;

import com.zhu.framework.util.CastUtil;
import com.zhu.framework.util.CollectionUtil;

import java.util.Map;

/**
 * 请求参数对象
 */
public class OldParam {
    private Map<String, Object> paramMap;


    public OldParam(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    /**
     * 根据参数名获取long型参数值
     * @param name
     * @return
     */
    public long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }

    /**
     * 获取所有字段信息
     * @return
     */
    public Map<String, Object> getMap() {
        return paramMap;
    }

    public boolean isEmpty() {
        return CollectionUtil.isEmpty(paramMap);
    }

}
