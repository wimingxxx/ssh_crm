package com.qwm.ssh_crm.domain;
/**
 * @author：qiwenming
 * @date：2017/11/30 0030   23:43
 * @description：
 * 图片上传成以后的应答
 */
public class UploadResponseBean {
    private String message;
    private String filePath;
    private String mime;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }
}
