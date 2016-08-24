package com.zhu.framework.bean;

import java.io.InputStream;

/**
 * 封装上传文件参数
 */
public class FileParam {
    private String fileName;
    private String fieldName;
    private long fileSize;
    private String contentType;
    private InputStream inputStream;

    public FileParam(String fileName, String fieldName, long fileSize, String contentType, InputStream inputStream) {
        this.fileName = fileName;
        this.fieldName = fieldName;
        this.fileSize = fileSize;
        this.contentType = contentType;
        this.inputStream = inputStream;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public String getContentType() {
        return contentType;
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}
