package com.dhrj.zs.print;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * created by on 2022/4/26
 * 描述：标准输出流：更改控制台输出方向为MyPrintStreamFile文件
 *
 * @author ZSAndroid
 * @create 2022-04-26-20:20
 */
public class PrintStreamTest {
    public static void main(String[] args) {
        LogUtil.log("使用Java标准输出流自定义日志工具类，将打印输出的信息写入log.txt文件里");
    }
}

/**
 * 自定义打印日志工具类
 */
class LogUtil {
    public static void log(String msg) {
        PrintStream printStream = null;
        try {
            //指向日志文件log.txt，自动追加
            printStream = new PrintStream(new FileOutputStream("log.txt", true));
            //改变输出方向
            System.setOut(printStream);
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
            String strTime = simpleDateFormat.format(date);
            System.out.println(strTime + ":" +msg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (printStream != null) {
                printStream.close();
            }
        }
    }
}
