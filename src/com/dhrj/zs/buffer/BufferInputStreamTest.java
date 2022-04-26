package com.dhrj.zs.buffer;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * created by on 2022/4/26
 * 描述：缓冲区字节输入流
 *
 * @author ZSAndroid
 * @create 2022-04-26-19:04
 */
public class BufferInputStreamTest {
    public static void main(String[] args) {
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream("MyBufferedOutputStream"));
            byte[] bytes = {'Z', 'S', 'A', 'n', 'd', 'r', 'o', 'i', 'd'};
            bos.write(bytes);
            //刷新输出流管道
            bos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
