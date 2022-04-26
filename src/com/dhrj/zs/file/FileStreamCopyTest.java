package com.dhrj.zs.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * created by on 2022/4/26
 * 描述：文件拷贝：使用FileInputStream + FileOutputStream
 * 一边读一边写，字节流方式可拷贝任意类型文件
 *
 * @author ZSAndroid
 * @create 2022-04-26-16:50
 */
public class FileStreamCopyTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //复制目标(读取硬盘文件 到 内存数据)
            fis = new FileInputStream("MyJavaFileOutputStream");
            //粘贴目标(写出内存数据 到 硬盘文件)
            fos = new FileOutputStream("src/com/dhrj/zs/MyJavaFileOutputStream", true);
            //同时进行读写业务
            byte[] bytes = new byte[1024 * 1024];//1024B * 1024B = 1048576B = 1024KB =  1mb
            int readByteNum;
            while ((readByteNum = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, readByteNum);
            }
            //刷新输出流管道
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
