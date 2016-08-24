package com.zhu.framework.bean;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zhu.framework.util.CastUtil;
import com.zhu.framework.util.CollectionUtil;
import com.zhu.framework.util.StringUtil;

import java.util.List;
import java.util.Map;

public class Param {
    private List<FormParam> formParamList;
    private List<FileParam> fileParamList;

    public Param(List<FormParam> formParamList) {
        this.formParamList = formParamList;
    }

    public Param(List<FormParam> formParamList, List<FileParam> fileParamList) {
        this.formParamList = formParamList;
        this.fileParamList = fileParamList;
    }

    /**
     * 获取请求参数映射
     * @return
     */
    public Map<String, Object> getFieldMap() {
        Map<String, Object> fieldMap = Maps.newHashMap();
        if (CollectionUtil.isNotEmpty(formParamList)) {
            for (FormParam param : formParamList) {
                String fieldName = param.getFieldName();
                Object fieldValue = param.getFieldValue();
                if (fieldMap.containsKey(fieldName)) {
                    fieldValue = fieldMap.get(fieldName) + StringUtil.SEPARATOR + fieldValue;
                }
                fieldMap.put(fieldName, fieldValue);
            }
        }
        return fieldMap;
    }

    /**
     * 获取上传文件映射
     * @return
     */
    public Map<String, List<FileParam>> getFileMap() {
        Map<String, List<FileParam>> fileMap = Maps.newHashMap();
        if (CollectionUtil.isNotEmpty(fileParamList)) {
            for (FileParam fileParam : fileParamList) {
                String fieldName = fileParam.getFieldName();
                List<FileParam> fileParams;
                if (fileMap.containsKey(fieldName)) {
                    fileParams = fileMap.get(fieldName);
                } else {
                    fileParams = Lists.newArrayList();
                }
                fileParams.add(fileParam);
                fileMap.put(fieldName, fileParams);
            }
        }
        return fileMap;
    }

    public List<FileParam> getFileList(String fieldName) {
        return getFileMap().get(fieldName);
    }

    /**
     * 获取唯一上传文件
     * @param fieldName 该文件名对应的文件唯一时返回文件参数，否则返回空值
     * @return
     */
    public FileParam getFile(String fieldName) {
        List<FileParam> fileParamList = getFileList(fieldName);
        if (CollectionUtil.isNotEmpty(fileParamList) && fileParamList.size() == 1) {
            return fileParamList.get(0);
        }
        return null;
    }

    public boolean isEmpty() {
        return CollectionUtil.isEmpty(formParamList) && CollectionUtil.isEmpty(fileParamList);
    }

    public String getString(String name) {
        return CastUtil.castString(getFieldMap().get(name));
    }
    public double getDouble(String name) {
        return CastUtil.castDouble(getFieldMap().get(name));
    }
    public long getLong(String name) {
        return CastUtil.castLong(getFieldMap().get(name));
    }
    public int getInt(String name) {
        return CastUtil.castInt(getFieldMap().get(name));
    }
    public boolean getBoolean(String name) {
        return CastUtil.castBoolean(getFieldMap().get(name));
    }
}
