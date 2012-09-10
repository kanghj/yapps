package com.vouov.yapps.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * User: yuml
 * Date: 12-9-10
 * Time: 下午12:22
 */
public class ExtIconTools {

    public static void generateCss(File iconDirPath, File outCssPath) throws IOException {
          if(iconDirPath != null){
              FileWriter writer = new FileWriter(outCssPath);
            for(File file : iconDirPath.listFiles()){
                String fileName = file.getName();
                String suffix = fileName.substring(fileName.lastIndexOf('.'));
                String name = fileName.substring(0, fileName.lastIndexOf('.'));
                if(!file.isFile() || !".png".equals(suffix.toLowerCase())) continue;
                writer.write(".icon-"+name+" {background-image:url('../icons/fam/"+fileName+"') !important;}\r\n");
            }
              writer.close();
          }
    }

    public static void main(String[] args) throws Exception{
        generateCss(new File("G:\\workspace\\yapps\\src\\main\\webapp\\resources\\extjs\\resources\\icons\\fam"), new File("G:\\workspace\\yapps\\src\\main\\webapp\\resources\\extjs\\resources\\css\\ext-icon.css"));
    }
}
