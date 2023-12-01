package com.baidu.aip.face.stat;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/stat/FileUtil.class */
public class FileUtil {
    private static final String TAG = "FileUtil";

    private FileUtil() {
        throw new RuntimeException("This class instance can not be created.");
    }

    public static boolean createFile(File file) {
        if (file == null) {
            return false;
        }
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists() && file.length() > 3145728) {
            file.delete();
        }
        if (file.exists()) {
            return true;
        }
        try {
            file.createNewFile();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean loadPropertiesFile(File file, Properties properties) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream);
                    try {
                        bufferedInputStream.close();
                        return true;
                    } catch (IOException e) {
                        return true;
                    }
                } catch (Exception e2) {
                    e = e2;
                    bufferedInputStream2 = bufferedInputStream;
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                            return false;
                        } catch (IOException e3) {
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    bufferedInputStream2 = bufferedInputStream;
                    th = th;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedInputStream = null;
        }
    }

    public static boolean savePropertiesFile(File file, Properties properties) {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    properties.store(bufferedOutputStream, (String) null);
                    try {
                        bufferedOutputStream.close();
                        return true;
                    } catch (IOException e) {
                        return true;
                    }
                } catch (Exception e2) {
                    e = e2;
                    bufferedOutputStream2 = bufferedOutputStream;
                    e.printStackTrace();
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                            return false;
                        } catch (IOException e3) {
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    bufferedOutputStream2 = bufferedOutputStream;
                    th = th;
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedOutputStream = null;
        }
    }
}
