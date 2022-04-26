package com.dhrj.zs.file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * created by on 2022/4/26
 * 描述：文件拷贝：使用FileReader + FileWriter
 * 一边读一边写，字符流方式仅支持拷贝普通文本文件
 *
 * @author ZSAndroid
 * @create 2022-04-26-18:02
 */
public class FileReaderWriterCopyTest {
    public static void main(String[] args) {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("file");//读取输入
            fileWriter = new FileWriter("file2", true);//写出输出

            char[] chars = new char[1024 * 512]; // 1个char为2个字节，1024 * 512 = 1MB
            //同时读写业务
            int readerNum;
            while ((readerNum = fileReader.read(chars)) != -1) {
                fileWriter.write(chars, 0, readerNum);
            }
            //刷新输出流管道
            fileWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
