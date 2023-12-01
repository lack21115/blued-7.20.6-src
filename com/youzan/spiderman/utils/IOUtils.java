package com.youzan.spiderman.utils;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/utils/IOUtils.class */
public class IOUtils {
    private static final String TAG = "IOUtils";

    /* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/utils/IOUtils$ProgressListener.class */
    public interface ProgressListener {
        void onNewProgress(long j, long j2);
    }

    public static void closeSilently(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th) {
            Logger.e("IOUtils", th);
        }
    }

    public static BufferedInputStream openFile(File file) throws FileNotFoundException, IOException {
        return new BufferedInputStream(new FileInputStream(file));
    }

    public static BufferedInputStream openGzipFile(File file) throws FileNotFoundException, IOException {
        return new BufferedInputStream(new GZIPInputStream(new FileInputStream(file)));
    }

    public static String streamToString(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toString("UTF-8");
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } finally {
                closeSilently(byteArrayOutputStream);
            }
        }
    }

    public static void writeStreamToFile(File file, InputStream inputStream) throws IOException {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            closeSilently(inputStream);
                            closeSilently(fileOutputStream);
                            return;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    closeSilently(inputStream);
                    closeSilently(fileOutputStream);
                } catch (Throwable th) {
                    fileOutputStream2 = fileOutputStream;
                    th = th;
                    closeSilently(inputStream);
                    closeSilently(fileOutputStream2);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a1, code lost:
        if (r16 >= r18) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c6, code lost:
        throw new java.lang.InterruptedException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00cb, code lost:
        closeSilently(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00cf, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void writeStreamToGzipFile(java.io.File r9, java.io.InputStream r10, long r11, boolean r13, long r14, long r16, long r18, com.youzan.spiderman.utils.IOUtils.ProgressListener r20) throws java.io.IOException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youzan.spiderman.utils.IOUtils.writeStreamToGzipFile(java.io.File, java.io.InputStream, long, boolean, long, long, long, com.youzan.spiderman.utils.IOUtils$ProgressListener):void");
    }

    public static void writeStreamToImgFile(File file, InputStream inputStream) throws IOException {
        FileOutputStream fileOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr, 0, 4096);
                    if (read == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            fileOutputStream.write(byteArray);
                            closeSilently(byteArrayOutputStream);
                            closeSilently(fileOutputStream);
                            closeSilently(inputStream);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            closeSilently(byteArrayOutputStream);
                            closeSilently(fileOutputStream);
                            closeSilently(inputStream);
                            throw th;
                        }
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            byteArrayOutputStream = null;
        }
    }

    public static void writeStringToFile(String str, String str2) throws IOException {
        FileWriter fileWriter = new FileWriter(str);
        try {
            fileWriter.write(str2);
        } finally {
            fileWriter.close();
        }
    }
}
