package com.qwm.ssh_crm.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qwm.ssh_crm.domain.UploadResponseBean;
import com.qwm.ssh_crm.utils.Md5Utils;
import org.apache.struts2.ServletActionContext;

import java.io.File;

public class UploadFileAction extends ActionSupport{

    private String mUploadDir = "/upload";

    //上传的文件会自动封装到File对象
    //在后台提供一个与前台input type=file组件 name相同的属性
    private File upFile;
    //在提交键名后加上固定后缀FileName,文件名称会自动封装到属性中
    private String upFileFileName;
    //在提交键名后加上固定后缀ContentType,文件MIME类型会自动封装到属性中
    private String upFileContentType;

    public String uploadFile(){
        UploadResponseBean uprb = new UploadResponseBean();
        if(upFile==null){
            uprb.setMessage("图片不能为空");
            ActionContext.getContext().put("uprb",uprb);
            return SUCCESS;
        }
        String savePath = ServletActionContext.getRequest().getRealPath(mUploadDir);
        //判断文件夹是否存在，不存在创建
        File saveDir = new File(savePath);
        if(!saveDir.exists()){
            saveDir.mkdir();
        }
        String filename = Md5Utils.md5Encode(upFileFileName) + "." +upFileFileName.substring( upFileFileName.lastIndexOf(".")+1 );
        //保存文件
        upFile.renameTo(new File(saveDir+"/"+filename));

        String filePath = mUploadDir+"/"+filename;
        uprb.setMessage("图片上传成功");
        uprb.setFilePath(filePath);
        uprb.setMime(upFileContentType);
        ActionContext.getContext().put("uprb",uprb);
        return SUCCESS;
    }

    public File getUpFile() {
        return upFile;
    }

    public void setUpFile(File upFile) {
        this.upFile = upFile;
    }

    public String getUpFileFileName() {
        return upFileFileName;
    }

    public void setUpFileFileName(String upFileFileName) {
        this.upFileFileName = upFileFileName;
    }

    public String getUpFileContentType() {
        return upFileContentType;
    }

    public void setUpFileContentType(String upFileContentType) {
        this.upFileContentType = upFileContentType;
    }
}
