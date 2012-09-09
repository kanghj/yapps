package com.vouov.yapps.util;

import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * User: yuminglong
 * Date: 12-3-22
 * Time: 下午5:06
 */
public class FTPUtils {
    private static final Logger log = LoggerFactory.getLogger(FTPUtils.class);
    /**
     * 上传静态页面到ftp服务器
     *
     * @param htmlList 静态文件列表
     * @throws java.io.IOException
     * Modification History:
     * Date         Author          Version            Description
     * ---------------------------------------------------------*
     * 2012-3-22     yuml           v1.0.0
     */
    public static void uploadHTMLPage(ArrayList<File> htmlList) throws IOException {
        FTPHelper ftp = new FTPHelper();
        ftp.uploadFileList(htmlList, ConfigUtils.getValue("ftp.html.dir"));
    }

    /**
     * Ckeditor上传的文件到ftp服务器
     *
     * @param is  文件输入流
     * @param filename 文件名称
     * @throws java.io.IOException
     * Modification History:
     * Date         Author          Version            Description
     * ---------------------------------------------------------*
     * 2012-3-23     yuml           v1.0.0
     */
    public static void uploadCKEditorFile(InputStream is, String filename) throws IOException {
        FTPHelper ftp = null;
        try {
            ftp = new FTPHelper();
            //获取ckeditor在ftp保存目录
            String remoteDir = ConfigUtils.getValue("ftp.ckeditor.dir");
            ftp.mkdirs(remoteDir);
            //获取ftpclient实例对象
            FTPClient ftpClient = ftp.getFtp();
            //保存文件到ftp
            if(!ftpClient.storeFile(remoteDir + "/" + filename, is)){
                log.error("upload ckeditor file failed:"+remoteDir+"/"+filename);
            }
        } finally {
            if (ftp != null)
                ftp.close();
        }
    }

    /**
     * 上传多媒体文件到ftp服务器
     *
     * @param flashList 静态文件列表
     * @throws java.io.IOException
     * Modification History:
     * Date         Author          Version            Description
     * ---------------------------------------------------------*
     * 2012-3-23     yuml           v1.0.0
     */
    public static void uploadMultimediaFile(ArrayList<File> flashList) throws IOException {
        FTPHelper ftp = new FTPHelper();
        ftp.uploadFileList(flashList, ConfigUtils.getValue("ftp.multimedia.dir"));
    }

    /**
     * 上传CSS到ftp服务器
     *
     * @param cssList 静态文件列表
     * @throws java.io.IOException
     * Modification History:
     * Date         Author          Version            Description
     * ---------------------------------------------------------*
     * 2012-3-23     yuml           v1.0.0
     */
    public static void uploadCSSFile(ArrayList<File> cssList) throws IOException {
        FTPHelper ftp = new FTPHelper();
        ftp.uploadFileList(cssList, ConfigUtils.getValue("ftp.css.dir"));
    }

    /**
     * 上传图片到ftp服务器
     *
     * @param jsList 静态文件列表
     * @throws java.io.IOException
     * Modification History:
     * Date         Author          Version            Description
     * ---------------------------------------------------------*
     * 2012-3-23     yuml           v1.0.0
     */
    public static void uploadJSFile(ArrayList<File> jsList) throws IOException {
        FTPHelper ftp = new FTPHelper();
        ftp.uploadFileList(jsList, ConfigUtils.getValue("ftp.js.dir"));
    }

    /**
     * 上传到ftp服务器其他目录
     *
     * @param otherList 静态文件列表
     * @throws java.io.IOException
     * Modification History:
     * Date         Author          Version            Description
     * ---------------------------------------------------------*
     * 2012-3-23     yuml           v1.0.0
     */
    public static void uploadOtherFile(ArrayList<File> otherList) throws IOException {
        FTPHelper ftp = new FTPHelper();
        ftp.uploadFileList(otherList, ConfigUtils.getValue("ftp.other.dir"));
    }

    /**
     * 下载ftp目录内容到本地
     *
     * @param context servlet上下文
     * @return 是否成功
     * @throws java.io.IOException
     * Modification History:
     * Date         Author          Version            Description
     * ---------------------------------------------------------*
     * 2012-3-23     yuml           v1.0.0
     */
    public static boolean downloadHTMLPages(ServletContext context) throws IOException {
        FTPHelper ftp = new FTPHelper();
        //获得配置目录
        String dir = ConfigUtils.getValue("ftp.html.dir");
        //下载
        return ftp.downloadFile(dir, context.getRealPath(dir));
    }
}
