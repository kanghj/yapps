package com.vouov.yapps.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.SocketException;
import java.util.ArrayList;

public class FTPHelper {

    private final static Logger log = LoggerFactory.getLogger(FTPHelper.class);

    private FTPClient ftp;

    public FTPHelper() throws IOException {
        String ip = ConfigUtils.getValue("ftp.ip");
        String username = ConfigUtils.getValue("ftp.username");
        String password = ConfigUtils.getValue("ftp.password");
        String sport = ConfigUtils.getValue("ftp.port");
        int port = StringUtils.isEmpty(sport)?21:Integer.parseInt(sport);
        connect(ip, port, username, password);
    }

    public FTPHelper(String hostIP,int port,String username, String password) throws IOException {
        connect(hostIP, port, username, password);
    }

    public FTPClient getFtp() {
        return ftp;
    }

    public void setFtp(FTPClient ftp) {
        this.ftp = ftp;
    }

    /**
     * 
     * @Function: connect
     * @Description: 连接FTP服务器
     *
     * @param hostIP 主机IP
     * @param port  端口号
     * @param username 用户名
     * @param password 密码
     * @throws java.net.SocketException
     * @throws java.io.IOException
     *
     * @version: v1.0.0
     * @author: zhengzq
     * @date: 2012-3-20 下午06:13:06
     *
     * Modification History:
     * Date         Author          Version            Description
     *---------------------------------------------------------*
     * 2012-3-20     zhengzq           v1.0.0
     */
    public void connect(String hostIP,int port,String username, String password) throws SocketException, IOException{
        ftp= new FTPClient();
        ftp.connect(hostIP, port);//连接FTP服务器
        ftp.login(username, password);//登录
    }

    /**
     *
     * @Function: dir
     * @Description: 切换工作目录
     *
     * @param dir 工作目录

     * @throws java.net.SocketException
     * @throws java.io.IOException
     *
     *
     * Modification History:
     * Date         Author          Version            Description
     *---------------------------------------------------------*
     * 2012-3-22     yuml           v1.0.0
     */
    public boolean cd(String dir) throws SocketException, IOException{
        return  ftp.changeWorkingDirectory(dir.replace("\\","/"));
    }

    /**
     *
     * @Function: 新建目录，支持子目录
     * @Description: 切换工作目录
     *
     * @param remoteDir 需要创建的目录

     * @throws java.net.SocketException
     * @throws java.io.IOException
     *
     *
     * Modification History:
     * Date         Author          Version            Description
     *---------------------------------------------------------*
     * 2012-3-22     yuml           v1.0.0
     */
    public void mkdirs(String remoteDir) throws IOException {
        File file = new File(remoteDir);
        log.debug("mkdirs remote dir:"+remoteDir);
        if("".equals(file.getName())) {
            return;
        }
        if(!cd(remoteDir)){
            //linux下只支持一级一级往下新建文件夹目录
            mkdirs(file.getParent());
            //新建最后层级文件夹
            log.debug("make dir:" + file.getName());
            if(!ftp.makeDirectory(file.getName())){
                log.error("make dir failed."+remoteDir);
            }
            //切换至该目录下
            log.debug("change work dir:"+remoteDir);
            if(!cd(remoteDir)){
                log.error("change dir failed:"+remoteDir);
            }
        }
        else {
            return;
        }
    }

    /**
     *
     * @Function: uploadFile
     * @Description: 上传文件
     *
     * @param localFile 目录或者文件
     * @return
     * @throws java.io.IOException
     *
     * @version: v1.0.0
     * @author: zhengzq
     * @date: 2012-3-20 下午06:16:49
     *
     * Modification History:
     * Date         Author          Version            Description
     *---------------------------------------------------------*
     * 2012-3-20     zhengzq           v1.0.0
     */
    public boolean uploadFile(File localFile, String remotePath) throws IOException {

        try {
            FileInputStream in =null;
            //获取本地待上传文件list
            ArrayList<String> files = getLocalFileList(localFile, "");
            for(String file:files){
                //本地文件
                File f = new File(localFile, file);
                //上传后欲在ftp服务器生成的文件
                File r = new File(remotePath+file);
                //在服务器上新建文件目录
                mkdirs(r.getParent());
                try {
                    in = new FileInputStream(f);
                    if(!ftp.storeFile(f.getName(), in)){
                        log.debug("store failed!");

                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }finally{
                    if(in!=null){
                        in.close();
                        in=null;
                    }
                }
            }

            close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     *
     * @Function: uploadFileList
     * @Description: 上传文件列表到FTP指定目录
     *
     * @param remoteDir 需要创建的目录

     * @throws java.net.SocketException
     * @throws java.io.IOException
     *
     *
     * Modification History:
     * Date         Author          Version            Description
     *---------------------------------------------------------*
     * 2012-3-22     yuml           v1.0.0
     */
    public void uploadFileList(ArrayList<File> files, String remoteDir) throws IOException {
        FileInputStream in = null;
        if (files != null && !files.isEmpty()) {
            //创建目录并且切换到此工作目录
            mkdirs(remoteDir);
            for (File file : files) {
                try {
                    in = new FileInputStream(file);
                    //上传文件到ftp
                    ftp.storeFile(file.getName(), in);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (in != null) {
                        in.close();
                        in = null;
                    }
                }
            }
            close();
        }
    }

    /**
     *
     * @Function: downloadFile
     * @Description:下载服务器文件
     *
     * @param remotePath 服务器目录
     * @param localPath 本地目录
     * @return
     *
     * @version: v1.0.0
     * @author: zhengzq
     * @date: 2012-3-21 下午06:01:29
     *
     * Modification History:
     * Date         Author          Version            Description
     *---------------------------------------------------------*
     * 2012-3-21     zhengzq           v1.0.0
     */
    public boolean downloadFile(String remotePath,String localPath) {
        try {
            //获取ftp服务器上欲下载的文件list
            ArrayList<String> filenames =getFtpFileNameList(remotePath, "");
            for(String filename:filenames){
                //下载后要在本地生成的文件
                File localFile = new File(localPath+"/"+filename);
                //判断文件目录是否存在，不存在则新建
                if(!localFile.getParentFile().exists()){
                    localFile.getParentFile().mkdirs();
                }
                OutputStream out=null;
                try{
                    //获取文件输出流
                    out = new FileOutputStream(localFile);
                    //写文件
                    if(!ftp.retrieveFile(remotePath + filename, out)){
                        log.debug("download failed");
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    if(out!=null) {
                        out.close();
                        out = null;
                    }
                }

            }

            close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    /**
     *
     * @Function: deleteFile
     * @Description:删除ftp服务器文件
     *
     * @param file
     * @throws java.io.IOException
     *
     * Modification History:
     * Date         Author          Version            Description
     *---------------------------------------------------------*
     * 2012-3-23     yuml           v1.0.0
     */
    public void deleteFile(String file) throws IOException{
        ftp.deleteFile(file);
    }
    /**
     *
     * @Function: deleteDirectory
     * @Description:删除ftp服务器文件夹
     *
     * @param dir
     *
     * Modification History:
     * Date         Author          Version            Description
     *---------------------------------------------------------*
     * 2012-3-23     yuml           v1.0.0
     */
    public void deleteDirectory(String dir){
        try {
            //切换到该工作目录下
            if(cd(dir)){
                //获取文件目录下的所有文件
                FTPFile[] files = ftp.listFiles();
                if(files!=null && files.length>0){
                    for(FTPFile file: files){
                        //是文件则直接删除
                        if(file.isFile()){
                            if( !ftp.deleteFile(file.getName())){
                                log.debug("delete file failed");
                            }
                        }
                        //若是文件夹，须先删除该文件夹下的所有文件
                        else if(file.isDirectory()){
                            deleteDirectory(file.getName());
                            //切换至上级目录
                            ftp.changeToParentDirectory();
                            //删除上一级的空文件夹
                            if(! ftp.removeDirectory(file.getName())){
                                log.debug("remove directory failed");
                            }
                        }
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
    /**
     *
     * @Function: getLocalFileList
     * @Description: 获取本地目录下所有文件
     *
     * @param baseDir 待上传文件目录
     * @param filePath 待上传的文件名或者文件夹名
     * @throws java.io.FileNotFoundException
     *
     * @version: v1.0.0
     * @author: zhengzq
     * @date: 2012-3-20 上午11:17:32
     *
     * Modification History:
     * Date         Author          Version            Description
     *---------------------------------------------------------*
     * 2012-3-20     zhengzq           v1.0.0
     */
    public static ArrayList<String> getLocalFileList(File baseDir, String filePath) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        File file = new File(baseDir, filePath) ;
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                String fileName = filePath+"/"+f.getName();
                if (f.isDirectory()) {
                    list.addAll(getLocalFileList(baseDir, fileName));
                }else
                    if (f.isFile()) {
                        list.add(fileName);
                    }
            }
        }
        return list;
    }
    /**
     *
     * @Function: getFtpFileNameList
     * @Description: 获取ftp目录下的文件路径
     *
     * @param basePath 根目录
     * @param filePath 相对于根目录的下载文件或者目录
     * @return
     * @throws java.io.IOException
     *
     * @version: v1.0.0
     * @author: zhengzq
     * @date: 2012-3-21 下午06:00:21
     *
     * Modification History:
     * Date         Author          Version            Description
     *---------------------------------------------------------*
     * 2012-3-21     zhengzq           v1.0.0
     */
    public  ArrayList<String> getFtpFileNameList(String basePath, String filePath) throws IOException {
        ftp.changeWorkingDirectory(basePath+filePath);//转移到FTP服务器目录
        ArrayList<String> list = new ArrayList<String>();
        FTPFile[] files = ftp.listFiles();
        for (FTPFile file : files) {
            String fileName = filePath+"/"+file.getName();
            if (file.isDirectory()) {
                list.addAll(getFtpFileNameList(basePath, fileName));
            }else
                if (file.isFile()) {
                    list.add(fileName);
                }
        }
        return list;
    }

    /**
     * 
     * @Function: close
     * @Description: 关闭FTP连接
     *
     *
     * @version: v1.0.0
     * @author: zhengzq
     * @date: 2012-3-20 下午06:15:40
     *
     * Modification History:
     * Date         Author          Version            Description
     *---------------------------------------------------------*
     * 2012-3-20     zhengzq           v1.0.0
     */
    public void close(){
        try {
            if(ftp!=null){
                ftp.logout();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }



}
