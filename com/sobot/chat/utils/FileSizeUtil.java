package com.sobot.chat.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/FileSizeUtil.class */
public class FileSizeUtil {
    public static final int SIZETYPE_B = 1;
    public static final int SIZETYPE_GB = 4;
    public static final int SIZETYPE_KB = 2;
    public static final int SIZETYPE_MB = 3;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/FileSizeUtil$CallBack.class */
    public interface CallBack<T> {
        void call(T t);
    }

    private static double FormetFileSize(long j, int i) {
        long j2 = j;
        if (i != 1) {
            if (i == 2) {
                j2 = j / 1024;
            } else if (i == 3) {
                j2 = j / 1048576;
            } else if (i != 4) {
                return 0.0d;
            } else {
                j2 = j / 1073741824;
            }
        }
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String FormetFileSize(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j == 0) {
            return "0B";
        }
        if (j < 1024) {
            return decimalFormat.format(j) + "B";
        } else if (j < 1048576) {
            return decimalFormat.format(j / 1024.0d) + "KB";
        } else if (j < 1073741824) {
            return decimalFormat.format(j / 1048576.0d) + "MB";
        } else {
            return decimalFormat.format(j / 1.073741824E9d) + "GB";
        }
    }

    public static double getAutoFileOrFilesSize(File file) {
        try {
            return file.isDirectory() ? getFileSizes(file) : getFileSize(file);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("获取文件大小失败!");
            return 0.0d;
        }
    }

    public static double getFileOrFilesSize(String str, int i) {
        long j;
        File file = new File(str);
        try {
            j = file.isDirectory() ? getFileSizes(file) : getFileSize(file);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("获取文件大小失败!");
            j = 0;
        }
        return FormetFileSize(j, i);
    }

    private static long getFileSize(File file) {
        try {
            if (file.exists()) {
                return new FileInputStream(file).available();
            }
            file.createNewFile();
            LogUtils.e("获取文件大小->文件不存在!");
            return 0L;
        } catch (Exception e) {
            return 0L;
        }
    }

    private static long getFileSizes(File file) throws Exception {
        File[] listFiles = file.listFiles();
        long j = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= listFiles.length) {
                return j;
            }
            j += listFiles[i2].isDirectory() ? getFileSizes(listFiles[i2]) : getFileSize(listFiles[i2]);
            i = i2 + 1;
        }
    }

    public static void getFileUrlSize(final String str, final CallBack<String> callBack) {
        if (str == null || "".equals(str)) {
            callBack.call("0B");
        }
        new Thread(new Runnable() { // from class: com.sobot.chat.utils.FileSizeUtil.1
            @Override // java.lang.Runnable
            public void run() {
                URL url;
                HttpURLConnection httpURLConnection;
                long j;
                HttpURLConnection httpURLConnection2 = null;
                try {
                    url = new URL(str);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    url = null;
                }
                try {
                    try {
                        httpURLConnection = (HttpURLConnection) url.openConnection();
                        try {
                            httpURLConnection.setRequestMethod("HEAD");
                            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows 7; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.73 Safari/537.36 YNoteCef/5.8.0.1 (Windows)");
                            j = httpURLConnection.getContentLength();
                            httpURLConnection.disconnect();
                        } catch (IOException e2) {
                            httpURLConnection2 = httpURLConnection;
                            callBack.call("0B");
                            httpURLConnection.disconnect();
                            j = 0;
                            callBack.call(FileSizeUtil.FormetFileSize(j));
                        } catch (Throwable th) {
                            th = th;
                            httpURLConnection2 = httpURLConnection;
                            httpURLConnection2.disconnect();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e3) {
                    httpURLConnection = null;
                }
                callBack.call(FileSizeUtil.FormetFileSize(j));
            }
        }).start();
    }
}
