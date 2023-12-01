package com.youzan.spiderman.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/utils/FileUtil.class */
public class FileUtil {
    public static boolean checkFileExists(String str) {
        if (StringUtils.isNotEmpty(str)) {
            File file = new File(str);
            return file.exists() && file.isFile();
        }
        throw new IllegalArgumentException("Path cannot be empty");
    }

    public static void cleanDir(File file) {
        String[] list;
        if (file == null || !file.isDirectory() || (list = file.list()) == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.length) {
                return;
            }
            new File(file, list[i2]).delete();
            i = i2 + 1;
        }
    }

    public static File createDir(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            createParentDirIfNeeded(file);
            file.mkdirs();
        }
        return file;
    }

    public static void createDir(File file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("dir cannot be null");
        }
        if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
            throw new IOException(String.format("Failed to create dir path %s", file.getAbsolutePath()));
        }
    }

    public static File createFile(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            createParentDirIfNeeded(file);
            file.createNewFile();
        }
        return file;
    }

    public static void createParentDirIfNeeded(File file) throws IOException {
        File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            return;
        }
        createParentDirIfNeeded(parentFile.getParentFile());
        createDir(parentFile);
    }

    public static void deleteFile(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static long dirSize(File file) {
        File[] listFiles = file.listFiles();
        long j = 0;
        long j2 = 0;
        if (listFiles != null) {
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                j2 = j;
                if (i2 >= length) {
                    break;
                }
                File file2 = listFiles[i2];
                j += file2.isFile() ? file2.length() : dirSize(file2);
                i = i2 + 1;
            }
        }
        return j2;
    }

    public static String getFileContent(File file) throws IOException {
        BufferedInputStream bufferedInputStream;
        try {
            if (!file.exists()) {
                IOUtils.closeSilently(null);
                return "";
            }
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                int length = (int) file.length();
                byte[] bArr = new byte[length];
                for (int i = 0; i < length; i += bufferedInputStream2.read(bArr, i, Math.min(length - i, 4096))) {
                }
                String str = new String(bArr, "UTF-8");
                IOUtils.closeSilently(bufferedInputStream2);
                return str;
            } catch (Throwable th) {
                bufferedInputStream = bufferedInputStream2;
                th = th;
                IOUtils.closeSilently(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
        }
    }

    public static String getFileContent(String str) throws IOException {
        return getFileContent(new File(str));
    }

    public static void renameToFile(String str, String str2) {
        new File(str).renameTo(new File(str2));
    }

    public static void unPackZip(File file, File file2) {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(file2)));
            byte[] bArr = new byte[1024];
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream.close();
                    return;
                }
                String name = nextEntry.getName();
                if (name.contains("../")) {
                    throw new RuntimeException("unsecurity zipfile");
                }
                if (nextEntry.isDirectory()) {
                    new File(file.getPath() + File.separator + name).mkdirs();
                } else {
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(file.getPath() + File.separator + name));
                    while (true) {
                        int read = zipInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.close();
                    zipInputStream.closeEntry();
                }
            }
        } catch (IOException e) {
            Logger.e("error", e);
        }
    }

    public static boolean unpackToOverrideInDir(InputStream inputStream, File file) {
        ZipInputStream zipInputStream;
        ZipInputStream zipInputStream2 = null;
        try {
            try {
                zipInputStream = new ZipInputStream(new BufferedInputStream(inputStream));
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            zipInputStream.close();
                            return true;
                        }
                        String name = nextEntry.getName();
                        if (name.contains("../")) {
                            throw new RuntimeException("unsecurity zipfile");
                        }
                        File file2 = new File(file, name);
                        if (!file2.exists()) {
                            if (nextEntry.isDirectory()) {
                                new File(file, name).mkdirs();
                            } else {
                                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                                while (true) {
                                    int read = zipInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                fileOutputStream.close();
                                zipInputStream.closeEntry();
                            }
                        }
                    }
                } catch (IOException e) {
                    e = e;
                    zipInputStream2 = zipInputStream;
                    Logger.e("error", e);
                    if (zipInputStream != null) {
                        try {
                            zipInputStream.close();
                            return false;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    zipInputStream2 = zipInputStream;
                    th = th;
                    if (zipInputStream2 != null) {
                        try {
                            zipInputStream2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e4) {
            e = e4;
            zipInputStream = null;
        }
    }

    public static boolean writeContentToFile(File file, String str) {
        PrintWriter printWriter;
        PrintWriter printWriter2 = null;
        try {
            try {
                if (file.exists() || file.createNewFile()) {
                    printWriter = new PrintWriter(new FileOutputStream(file));
                    try {
                        printWriter.println(str);
                        printWriter.close();
                        printWriter.close();
                        return true;
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        if (printWriter != null) {
                            printWriter.close();
                            return false;
                        }
                        return false;
                    } catch (Throwable th) {
                        printWriter2 = printWriter;
                        th = th;
                        if (printWriter2 != null) {
                            printWriter2.close();
                        }
                        throw th;
                    }
                }
                return false;
            } catch (IOException e2) {
                e = e2;
                printWriter = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean writeContentToFile(String str, String str2) {
        return writeContentToFile(new File(str), str2);
    }

    public static boolean writeStreamToFile(File file, InputStream inputStream) {
        BufferedOutputStream bufferedOutputStream;
        byte[] bArr = new byte[4096];
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                if (!file.exists() && !file.createNewFile()) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            return false;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return false;
                        }
                    }
                    return false;
                }
                if (inputStream != null) {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                    while (true) {
                        try {
                            int read = inputStream.read(bArr, 0, 4096);
                            if (read == -1) {
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                        } catch (IOException e2) {
                            e = e2;
                            e.printStackTrace();
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                    return false;
                                } catch (IOException e4) {
                                    e4.printStackTrace();
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
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedOutputStream.close();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return true;
                    } catch (IOException e7) {
                        e7.printStackTrace();
                        return true;
                    }
                }
                return true;
            } catch (IOException e8) {
                e = e8;
                bufferedOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
