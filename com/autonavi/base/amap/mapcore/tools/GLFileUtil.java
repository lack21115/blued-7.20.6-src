package com.autonavi.base.amap.mapcore.tools;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/amap/mapcore/tools/GLFileUtil.class */
public class GLFileUtil {
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    public static void copy(Context context, String str, File file) throws Exception {
        file.delete();
        InputStream open = context.getAssets().open(str);
        byte[] bArr = new byte[open.available()];
        try {
            open.read(bArr);
            closeQuietly(open);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr);
            } finally {
                closeQuietly(fileOutputStream);
            }
        } catch (Throwable th) {
            closeQuietly(open);
            throw th;
        }
    }

    public static void deleteFile(File file) {
        if (file == null) {
            return;
        }
        File[] listFiles = file.listFiles();
        if (file.isDirectory() && listFiles != null) {
            for (File file2 : listFiles) {
                deleteFile(file2);
            }
        }
        file.delete();
    }

    public static File getCacheDir(Context context) {
        File cacheDir = context.getCacheDir();
        File file = cacheDir;
        if (cacheDir == null) {
            file = context.getDir("cache", 0);
        }
        File file2 = file;
        if (file == null) {
            file2 = new File("/data/data/" + context.getPackageName() + "/app_cache");
        }
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public static File getFilesDir(Context context) {
        File filesDir = context.getFilesDir();
        File file = filesDir;
        if (filesDir == null) {
            file = context.getDir("files", 0);
        }
        File file2 = file;
        if (file == null) {
            file2 = new File("/data/data/" + context.getPackageName() + "/app_files");
        }
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public static byte[] readFileContents(String str) {
        InputStream inputStream;
        Throwable th;
        FileInputStream fileInputStream;
        try {
            File file = new File(str);
            if (!file.exists()) {
                closeQuietly(null);
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        byteArrayOutputStream.close();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        closeQuietly(fileInputStream);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (Exception e) {
                closeQuietly(fileInputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = fileInputStream;
                closeQuietly(inputStream);
                throw th;
            }
        } catch (Exception e2) {
            fileInputStream = null;
        } catch (Throwable th3) {
            inputStream = null;
            th = th3;
        }
    }

    public static void writeDatasToFile(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        writeLock.lock();
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    File file = new File(str);
                    File parentFile = file.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                        writeLock.unlock();
                        closeQuietly(fileOutputStream);
                        return;
                    } catch (Exception e) {
                        writeLock.unlock();
                        closeQuietly(fileOutputStream);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        writeLock.unlock();
                        closeQuietly(fileOutputStream);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        }
        writeLock.unlock();
        closeQuietly(null);
    }
}
