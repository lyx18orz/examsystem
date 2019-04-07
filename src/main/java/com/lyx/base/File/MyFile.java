package com.lyx.base.File;

import com.lyx.base.Create.MyCreate;
import com.lyx.base.result.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyFile {
    @Autowired
    private MyCreate myCreate;

    public String MultipartFileOutputFile(MultipartFile multipartFile, String outFilePath) {
        ResultData resultData = new ResultData();
        int maxPostSize = 1024 * 1024 * 2;//图片大小设置为2M,Byte
        SimpleDateFormat iddate = new SimpleDateFormat("yyyyMMddHHmmsss");
        String fileName = multipartFile.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf("."), fileName.length());//获得文件后缀
        if (ext.equals(".jpg") || ext.equals(".png") || ext.equals(".bmp")) {
            if (multipartFile.getSize() > maxPostSize) {
                resultData.setMsg("图片超过1M!");
            } else {
                fileName = iddate.format(new Date()) + myCreate.RandomString() + ext;
            }
        } else {
            resultData.setMsg("Image format wrong!");
        }
        try {
            File filePath = new File(outFilePath);
            if (!filePath.exists()) {
                boolean mkdirs = filePath.mkdirs();
            }
            multipartFile.transferTo(new File(outFilePath + fileName));
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
