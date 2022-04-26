package com.dhrj.zs.buffer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * created by on 2022/4/26
 * 描述：缓冲区字节输出流
 *
 * @author ZSAndroid
 * @create 2022-04-26-19:05
 */
public class BufferOutInputStreamTest {
    public static void main(String[] args) {
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream("MyJavaFileOutputStream"));
            byte[] bytes = new byte[1024 * 1024];  //每次读取1MB
            int readByteCount;
            while ((readByteCount = bis.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, readByteCount));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
