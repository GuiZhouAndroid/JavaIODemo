package com.dhrj.zs.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * created by on 2022/4/26
 * 描述：文件字节输出流，负责写：内存--->硬盘
 *
 * @author ZSAndroid
 * @create 2022-04-26-15:10
 */
public class FileOutputStreamTest {
    public static void main(String[] args) {
        FileOutputStream fileOutputStream = null;
        try {
            //文件不存在会自动创建在指定的目录下
            //fileOutputStream = new FileOutputStream("MyJavaFileOutputStream");//清空覆盖原内容，数据丢失，谨慎使用
            fileOutputStream = new FileOutputStream("MyJavaFileOutputStream", true);//追加原内容
            //开始写出
            //fileOutputStream.write(new byte[]{'a','b','c','d','e'});//byte数组全部写出到文件
            //fileOutputStream.write(new byte[]{'a', 'b', 'c', 'd', 'e'}, 0, 2);//byte数组部分写出到文件
            //写入中文---> getBytes()
            byte[] bytes = "我是中国人".getBytes();
            fileOutputStream.write(bytes);
            //刷新输出流管道
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
