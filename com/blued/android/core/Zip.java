package com.blued.android.core;

import com.blued.android.core.utils.ByteArrayPool;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/Zip.class */
public class Zip {
    public static String a(InputStream inputStream, String str) throws Exception {
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        String str2 = null;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                zipInputStream.close();
                return str2;
            }
            String name = nextEntry.getName();
            if (nextEntry.isDirectory()) {
                str2 = name.substring(0, name.length() - 1);
                new File(str + File.separator + str2).mkdirs();
            } else {
                File file = new File(str + File.separator + name);
                if (!file.exists()) {
                    File parentFile = file.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    file.createNewFile();
                }
                str2 = file.getParentFile().getName();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] a2 = ByteArrayPool.f9730a.a(1024);
                while (true) {
                    int read = zipInputStream.read(a2);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(a2, 0, read);
                    fileOutputStream.flush();
                }
                ByteArrayPool.f9730a.a(a2);
                fileOutputStream.close();
            }
        }
    }

    public static String a(String str, String str2) throws Exception {
        String a2 = a(new FileInputStream(str), str2);
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        return a2;
    }

    private static void a(String str, String str2, ZipOutputStream zipOutputStream) throws Exception {
        if (zipOutputStream == null) {
            return;
        }
        File file = new File(str + str2);
        if (!file.isFile()) {
            String[] list = file.list();
            if (list == null || list.length <= 0) {
                zipOutputStream.putNextEntry(new ZipEntry(str2 + File.separator));
                zipOutputStream.closeEntry();
                return;
            }
            for (int i = 0; i < list.length; i++) {
                a(str, str2 + File.separator + list[i], zipOutputStream);
            }
            return;
        }
        ZipEntry zipEntry = new ZipEntry(str2);
        FileInputStream fileInputStream = new FileInputStream(file);
        zipOutputStream.putNextEntry(zipEntry);
        byte[] a2 = ByteArrayPool.f9730a.a(1024);
        while (true) {
            int read = fileInputStream.read(a2);
            if (read == -1) {
                zipOutputStream.closeEntry();
                fileInputStream.close();
                ByteArrayPool.f9730a.a(a2);
                return;
            }
            zipOutputStream.write(a2, 0, read);
        }
    }

    public static void b(String str, String str2) throws Exception {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
        File file = new File(str);
        a(file.getParent() + File.separator, file.getName(), zipOutputStream);
        zipOutputStream.finish();
        zipOutputStream.close();
    }
}
