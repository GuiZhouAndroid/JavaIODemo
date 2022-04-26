package com.dhrj.zs.buffer;

import java.io.*;

/**
 * created by on 2022/4/26
 * 描述：缓存字符输出流  + OutputStreamWriter转换流(字节流 转换为 字符流)
 *
 * @author ZSAndroid
 * @create 2022-04-26-18:46
 */
public class BufferWriterTest {
    public static void main(String[] args) {
        BufferedWriter bufferedWriter = null;
        try {
            //FileOutputStream 节点流 OutputStreamWriter 包装流 相对角度
            //OutputStreamWriter 节点流 BufferedWriter 包装流 相对角度
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("MyBufferedWriter",true)));
            bufferedWriter.write("BufferWriterTest文件写入成功");
            //刷新输出流管道
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    //只需关闭包装流即可，底层源码自动关闭节点流
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
