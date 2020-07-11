package cn.cuit.HairdressAssociation.mybatisutil;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

    @Service
    public class FileService {

        private String filePath = "D:/images/"; //定义上传文件的存放位置

        public String upLoadFile(MultipartFile upload, String name) {
            //判断文件夹是否存在,不存在则创建
            File file = new File(filePath);

            if (!file.exists()) {
                file.mkdirs();
            }

            String originalFileName = upload.getOriginalFilename();//获取原始图片的扩展名
            String newFileName = name;
            System.out.println(newFileName);

            String oldName=upload.getOriginalFilename();
            //原文件的类型
            String type=oldName.substring(oldName.indexOf(".")); // 格式为.jpg 或 .png 或 ......
            String newFilePath = filePath + newFileName; //新文件的路径
            System.out.println(newFilePath);
            try {
                upload.transferTo(new File(newFilePath));  //将传来的文件写入新建的文件
                return newFileName;
            } catch (IOException e) {
                e.printStackTrace();
                return "err";
            }


        }
    }




