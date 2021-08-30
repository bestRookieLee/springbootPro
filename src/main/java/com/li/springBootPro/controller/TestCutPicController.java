package com.li.springBootPro.controller;

import com.li.springBootPro.util.PictureCut;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping(value = "/cutPic")
public class TestCutPicController {

    @PostMapping(value = "updateFile")
    public String importExceptionDesc(HttpServletRequest request, MultipartHttpServletRequest requestMultipart){
        MultipartFile multipartFile = requestMultipart.getFile("files");

        BufferedImage srcImage = null;
        try {
            FileInputStream in = (FileInputStream) multipartFile.getInputStream();
            srcImage = ImageIO.read(in);
        } catch (IOException e) {
            System.out.println("读取图片文件报错！" +  e.getMessage());
        }
        PictureCut.cut2(srcImage, "D:/img切割/",3, 4, multipartFile.getOriginalFilename());
        return multipartFile.getOriginalFilename();
    }
}
