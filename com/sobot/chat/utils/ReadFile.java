package com.sobot.chat.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/ReadFile.class */
public class ReadFile {
    public static void readFileByBytes(String str) {
        File file = new File(str);
        StringBuffer stringBuffer = new StringBuffer();
        if (!file.isFile() || !file.exists()) {
            System.out.println("找不到指定的文件，请确认文件路径是否正确");
            return;
        }
        System.out.println("以字节为单位读取文件内容，一次读多个字节：");
        byte[] bArr = new byte[1024];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            showAvailableBytes(fileInputStream);
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    return;
                }
                stringBuffer.append(new String(bArr, 0, read));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showAvailableBytes(InputStream inputStream) {
        try {
            PrintStream printStream = System.out;
            printStream.println("当前字节输入流中的字节数为:" + inputStream.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> toArrayByFileReader(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            FileReader fileReader = new FileReader(str);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    fileReader.close();
                    return arrayList;
                }
                arrayList.add(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    public static List<String> toArrayByInputStreamReader(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File(str)));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    inputStreamReader.close();
                    return arrayList;
                }
                arrayList.add(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    public static List<String> toArrayByRandomAccessFile(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(str), "r");
            while (true) {
                String readLine = randomAccessFile.readLine();
                if (readLine == null) {
                    randomAccessFile.close();
                    return arrayList;
                }
                arrayList.add(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return arrayList;
        }
    }
}
