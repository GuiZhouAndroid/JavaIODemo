package com.dhrj.zs.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * created by on 2022/4/26
 * 描述：文件字节流输入流，负责读：硬盘--->内存
 *
 * @author ZSAndroid
 * @create 2022-04-26-15:09
 */
public class FileInputStreamTest {

    public static void main(String[] args) {
        //fileInputStreamOneRead();//死循环读取返回单个字节本身
        //fileInputStreamByteRead();//死循环读取返回byte数组.length长度的字节指定数量
        fileInputStreamByteReadByAvailable();//读取返回byte总字节数量数组，舍弃while循环，不适合读取大字节数量的文件
    }

    /**
     * 效率低，死循环读取返回单个字节本身
     */
    public static void fileInputStreamOneRead() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("C:\\Users\\ZSAndroid\\Desktop\\Demo\\JavaIODemo\\file");
            //fileInputStream.skip(x)//跳过几个字节不读。
            int readResult;
            //fileInputStream.read()读取返回的int是字节数据本身
            while ((readResult = fileInputStream.read()) != -1) {
                System.out.println(readResult);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 效率较高，死循环读取返回byte数组.length长度的字节指定数量
     */
    public static void fileInputStreamByteRead() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("file");//工程目录为默认为IDEA的当前路径
            //fileInputStream.skip(x)//跳过几个字节不读。
            int readByteNum;
            //fileInputStream.read(new byte[4]))读取返回的int是字节的总数量，不是字节数据本身
            byte[] bytes = new byte[100];
            while ((readByteNum = fileInputStream.read(bytes)) != -1) {
                //按照4个字节大小遍历n次，遍历一次byte数组转换一次String字符串
                System.out.println("遍历中===" + new String(bytes, 0, readByteNum));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 效率高，读取返回byte总字节数量数组，舍弃while循环，不适合读取大字节数量的文件
     */
    public static void fileInputStreamByteReadByAvailable() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("file");//工程目录为默认为IDEA的当前路径
            //fileInputStream.skip(x)//跳过几个字节不读。
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            //遍历字节的总数量的byte数组并转换String字符串
            System.out.println("遍历结束===" + new String(bytes));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
