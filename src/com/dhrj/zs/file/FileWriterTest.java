package com.dhrj.zs.file;

import java.io.FileWriter;
import java.io.IOException;

/**
 * created by on 2022/4/26
 * 描述：文件字符输出流，只能写出普通文本文件
 *
 * @author ZSAndroid
 * @create 2022-04-26-17:42
 */
public class FileWriterTest {
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("file1");
            char[] chars = {'我','是','张','松'};
            fileWriter.write(chars);
            //刷新输出流管道
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
