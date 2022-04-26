package com.dhrj.zs.buffer;

import java.io.*;

/**
 * created by on 2022/4/26
 * 描述：缓冲区字符输入流 + InputStreamReader转换流(字节流 转换为 字符流)
 *
 * @author ZSAndroid
 * @create 2022-04-26-18:37
 */
public class BufferReaderTest {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            //FileInputStream 节点流 InputStreamReader 包装流 相对角度
            //InputStreamReader 节点流 BufferedReader 包装流 相对角度
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("file")));
            String strResult = null;
            while ((strResult = reader.readLine()) != null) {
                System.out.println(strResult);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    //只需关闭包装流即可，底层源码自动关闭节点流
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
