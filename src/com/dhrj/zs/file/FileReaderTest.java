package com.dhrj.zs.file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * created by on 2022/4/26
 * 描述：文件字符输入流，只能读取普通文本文件
 *
 * @author ZSAndroid
 * @create 2022-04-26-17:41
 */
public class FileReaderTest {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("file");
            char[] chars = new char[10];
            int readCount;
            while ((readCount = reader.read(chars)) != -1) {
                System.out.println(new String(chars, 0, readCount));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
