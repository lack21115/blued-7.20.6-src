package com.tencent.cos.xml.utils;

import android.util.Log;
import com.tencent.cos.xml.CosXmlBaseService;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.internal.Util;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/utils/FileUtils.class */
public class FileUtils {
    public static boolean clearFile(String str) throws IOException {
        if (deleteFileIfExist(str)) {
            return new File(str).createNewFile();
        }
        return false;
    }

    public static boolean deleteFileIfExist(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static void intercept(String str, long j, long j2) throws IOException {
        if (j2 <= 0) {
            clearFile(str);
        }
        File file = new File(str);
        File file2 = new File(str.concat("." + System.currentTimeMillis() + ".temp"));
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        FileInputStream fileInputStream = new FileInputStream(file);
        if (j > 0 && fileInputStream.skip(j) != j) {
            throw new IOException("skip size is not equal to offset");
        }
        byte[] bArr = new byte[65536];
        long j3 = 65536;
        long min = Math.min(j3, j2);
        while (true) {
            int read = fileInputStream.read(bArr, 0, (int) min);
            if (read <= 0) {
                break;
            }
            fileOutputStream.write(bArr, 0, read);
            j2 -= read;
            min = Math.min(j3, j2);
        }
        deleteFileIfExist(str);
        if (file2.renameTo(file)) {
            return;
        }
        throw new IOException("rename to " + str + "failed");
    }

    public static File[] listFile(File file) {
        if (file == null || !file.isDirectory()) {
            return null;
        }
        return file.listFiles();
    }

    public static void saveInputStreamToTmpFile(InputStream inputStream, File file, long j, long j2) throws IOException {
        FileOutputStream fileOutputStream;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[8192];
                long j3 = j2;
                if (j2 < 0) {
                    j3 = Long.MAX_VALUE;
                }
                long j4 = 0;
                if (j > 0) {
                    inputStream.skip(j);
                    j4 = 0;
                }
                while (j4 < j3) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    long j5 = read;
                    fileOutputStream2.write(bArr, 0, (int) Math.min(j5, j3 - j4));
                    j4 += j5;
                }
                fileOutputStream2.flush();
                Util.a(fileOutputStream2);
            } catch (Throwable th) {
                fileOutputStream = fileOutputStream2;
                th = th;
                if (fileOutputStream != null) {
                    Util.a(fileOutputStream);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    public static String tempCache(InputStream inputStream) throws CosXmlClientException {
        if (inputStream == null) {
            return null;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(CosXmlBaseService.appCachePath);
                sb.append(File.separator);
                sb.append("temp.tmp");
                String sb2 = sb.toString();
                Log.d("UnitTest", sb2);
                File file = new File(sb2);
                if (file.exists()) {
                    file.delete();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[65536];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 65536);
                        if (read <= 0) {
                            fileOutputStream2.flush();
                            CloseUtil.closeQuietly(fileOutputStream2);
                            CloseUtil.closeQuietly(inputStream);
                            return sb2;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    }
                } catch (IOException e) {
                    fileOutputStream = fileOutputStream2;
                    e = e;
                    throw new CosXmlClientException(ClientErrorCode.IO_ERROR.getCode(), e);
                } catch (Throwable th) {
                    fileOutputStream = fileOutputStream2;
                    th = th;
                    CloseUtil.closeQuietly(fileOutputStream);
                    CloseUtil.closeQuietly(inputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream = null;
        }
    }
}
