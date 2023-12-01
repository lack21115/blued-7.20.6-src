package com.xiaomi.push;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/x.class */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f28023a = {"jpg", "png", "bmp", "gif", "webp"};

    public static String a(File file) {
        InputStreamReader inputStreamReader;
        StringWriter stringWriter = new StringWriter();
        try {
            try {
                inputStreamReader = new InputStreamReader(new BufferedInputStream(new FileInputStream(file)));
            } catch (IOException e) {
                e = e;
                inputStreamReader = null;
            } catch (Throwable th) {
                th = th;
                a((Closeable) null);
                a(stringWriter);
                throw th;
            }
            try {
                char[] cArr = new char[2048];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read == -1) {
                        String stringWriter2 = stringWriter.toString();
                        a(inputStreamReader);
                        a(stringWriter);
                        return stringWriter2;
                    }
                    stringWriter.write(cArr, 0, read);
                }
            } catch (IOException e2) {
                e = e2;
                StringBuilder sb = new StringBuilder("read file :");
                InputStreamReader inputStreamReader2 = inputStreamReader;
                sb.append(file.getAbsolutePath());
                InputStreamReader inputStreamReader3 = inputStreamReader;
                sb.append(" failure :");
                InputStreamReader inputStreamReader4 = inputStreamReader;
                sb.append(e.getMessage());
                InputStreamReader inputStreamReader5 = inputStreamReader;
                com.xiaomi.channel.commonutils.logger.b.c(sb.toString());
                a(inputStreamReader);
                a(stringWriter);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            a((Closeable) null);
            a(stringWriter);
            throw th;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    public static void a(File file, File file2) {
        ZipOutputStream zipOutputStream;
        ZipOutputStream zipOutputStream2 = null;
        try {
            try {
                zipOutputStream = new ZipOutputStream(new FileOutputStream(file, false));
                try {
                    a(zipOutputStream, file2, null, null);
                    a(zipOutputStream);
                } catch (FileNotFoundException e) {
                    a(zipOutputStream);
                } catch (IOException e2) {
                    e = e2;
                    StringBuilder sb = new StringBuilder("zip file failure + ");
                    ZipOutputStream zipOutputStream3 = zipOutputStream;
                    sb.append(e.getMessage());
                    ZipOutputStream zipOutputStream4 = zipOutputStream;
                    com.xiaomi.channel.commonutils.logger.b.m8344a(sb.toString());
                    a(zipOutputStream);
                } catch (Throwable th) {
                    zipOutputStream2 = zipOutputStream;
                    th = th;
                    a(zipOutputStream2);
                    throw th;
                }
            } catch (FileNotFoundException e3) {
                zipOutputStream = null;
            } catch (IOException e4) {
                e = e4;
                zipOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(File file, String str) {
        BufferedWriter bufferedWriter;
        if (!file.exists()) {
            com.xiaomi.channel.commonutils.logger.b.c("mkdir " + file.getAbsolutePath());
            file.getParentFile().mkdirs();
        }
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                BufferedWriter bufferedWriter3 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                try {
                    bufferedWriter3.write(str);
                    a(bufferedWriter3);
                } catch (IOException e) {
                    bufferedWriter = bufferedWriter3;
                    e = e;
                    StringBuilder sb = new StringBuilder("write file :");
                    BufferedWriter bufferedWriter4 = bufferedWriter;
                    sb.append(file.getAbsolutePath());
                    BufferedWriter bufferedWriter5 = bufferedWriter;
                    sb.append(" failure :");
                    BufferedWriter bufferedWriter6 = bufferedWriter;
                    sb.append(e.getMessage());
                    bufferedWriter2 = bufferedWriter;
                    com.xiaomi.channel.commonutils.logger.b.c(sb.toString());
                    a(bufferedWriter);
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter2 = bufferedWriter3;
                    a(bufferedWriter2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
            bufferedWriter = null;
        }
    }

    public static void a(ZipOutputStream zipOutputStream, File file, String str, FileFilter fileFilter) {
        FileInputStream fileInputStream;
        ZipEntry zipEntry;
        FileInputStream fileInputStream2;
        String sb;
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        FileInputStream fileInputStream3 = null;
        try {
            try {
                if (file.isDirectory()) {
                    File[] listFiles = fileFilter != null ? file.listFiles(fileFilter) : file.listFiles();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(File.separator);
                    zipOutputStream.putNextEntry(new ZipEntry(sb2.toString()));
                    if (TextUtils.isEmpty(str2)) {
                        sb = "";
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str2);
                        sb3.append(File.separator);
                        sb = sb3.toString();
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= listFiles.length) {
                            break;
                        }
                        File file2 = listFiles[i2];
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(sb);
                        sb4.append(listFiles[i2].getName());
                        a(zipOutputStream, file2, sb4.toString(), null);
                        i = i2 + 1;
                    }
                    File[] listFiles2 = file.listFiles(new y());
                    fileInputStream2 = null;
                    if (listFiles2 != null) {
                        int length = listFiles2.length;
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            fileInputStream2 = null;
                            if (i4 >= length) {
                                break;
                            }
                            File file3 = listFiles2[i4];
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(sb);
                            sb5.append(File.separator);
                            sb5.append(file3.getName());
                            a(zipOutputStream, file3, sb5.toString(), fileFilter);
                            i3 = i4 + 1;
                        }
                    }
                } else {
                    if (TextUtils.isEmpty(str2)) {
                        Date date = new Date();
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(String.valueOf(date.getTime()));
                        sb6.append(".txt");
                        zipEntry = new ZipEntry(sb6.toString());
                    } else {
                        zipEntry = new ZipEntry(str2);
                    }
                    zipOutputStream.putNextEntry(zipEntry);
                    fileInputStream2 = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            zipOutputStream.write(bArr, 0, read);
                        }
                    } catch (IOException e) {
                        fileInputStream = fileInputStream2;
                        e = e;
                        StringBuilder sb7 = new StringBuilder("zipFiction failed with exception:");
                        FileInputStream fileInputStream4 = fileInputStream;
                        sb7.append(e.toString());
                        FileInputStream fileInputStream5 = fileInputStream;
                        com.xiaomi.channel.commonutils.logger.b.d(sb7.toString());
                        a((Closeable) fileInputStream);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream3 = fileInputStream2;
                        a((Closeable) fileInputStream3);
                        throw th;
                    }
                }
                a((Closeable) fileInputStream2);
            } catch (IOException e2) {
                e = e2;
                fileInputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m9172a(File file) {
        try {
            if (file.isDirectory()) {
                return false;
            }
            if (file.exists()) {
                return true;
            }
            File parentFile = file.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                return file.createNewFile();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            try {
                try {
                    int read = inputStream.read(bArr, 0, 8192);
                    if (read <= 0) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (Exception e) {
                    e.printStackTrace();
                    a((Closeable) inputStream);
                    a(byteArrayOutputStream);
                    return null;
                }
            } finally {
                a((Closeable) inputStream);
                a(byteArrayOutputStream);
            }
        }
    }

    public static byte[] a(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e) {
            return bArr;
        }
    }

    public static void b(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        if (file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            return;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read < 0) {
                        fileInputStream.close();
                        fileOutputStream.close();
                        return;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            fileInputStream = null;
        }
    }
}
