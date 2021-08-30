package com.li.springBootPro.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;

public class PictureCut {

    public static void cut2(BufferedImage bi, String descDir, int rows, int cols, String fileName){
        try {
            if(rows <= 0 || rows > 20) rows = 6;
            if(cols <= 0 || cols > 20) cols = 1;
            //读取源图像
            int srcWidth = bi.getWidth() - 40;//宽度
            int srcHeight = bi.getHeight();//高度
            if(srcWidth > 0 && srcHeight > 0){
                Image img;
                ImageFilter cropFilter;
                Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_SMOOTH);
                int destWidth = srcWidth;
                int destHeight = srcHeight;
                if(srcWidth % cols == 0){
                    destWidth = srcWidth / cols;
                }else{
                    destWidth = (int) Math.floor(srcWidth / cols) + 1;
                }

                if(srcHeight % rows == 0){
                    destHeight = srcHeight / rows;
                }else{
                    destHeight = (int) Math.floor(srcHeight / rows) + 1;
                }

                //循环建立切片
                //改进方法:是否可用多线程加快切割速度
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        //四个参数分别为图像起点坐标和宽高
                        //CropImageFilter(int x, int y, int width, int height)
                        cropFilter = new CropImageFilter(j * destWidth, i*destHeight, destWidth, destHeight);
                        img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
                        BufferedImage tag = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_INT_RGB);
                        Graphics g = tag.getGraphics();
                        g.drawImage(img, 0, 0, null);
                        g.dispose();
                        ImageIO.write(tag, "png",
                                new File(descDir + fileName + "_r" + i + "_c" + j + ".png" ));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
