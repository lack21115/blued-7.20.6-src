package com.getui.gtc.i.b;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/i/b/a.class */
public final class a {
    public static String a(String str) {
        File file = new File(str);
        String str2 = "0";
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                str2 = "0";
                if (messageDigest != null) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    byte[] bArr = new byte[10240];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        } else if (read < 10240) {
                            byte[] bArr2 = new byte[read];
                            System.arraycopy(bArr, 0, bArr2, 0, read);
                            messageDigest.update(bArr2);
                        } else {
                            messageDigest.update(bArr);
                        }
                    }
                    byte[] digest = messageDigest.digest();
                    StringBuilder sb = new StringBuilder();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= digest.length) {
                            String sb2 = sb.toString();
                            fileInputStream.close();
                            return sb2;
                        }
                        sb.append(String.format("%02X", Byte.valueOf(digest[i2])));
                        i = i2 + 1;
                    }
                }
            } catch (NoSuchAlgorithmException e) {
                com.getui.gtc.i.c.a.c(e);
                return "0";
            }
        } catch (Exception e2) {
            com.getui.gtc.i.c.a.c(e2);
        }
        return str2;
    }

    public static void a(File file) {
        try {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= listFiles.length) {
                            file.delete();
                            return;
                        } else {
                            a(listFiles[i2]);
                            i = i2 + 1;
                        }
                    }
                }
                file.delete();
            }
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.b(th);
        }
    }

    public static void a(String str, final String str2) {
        File[] listFiles;
        File file = new File(str);
        if (!file.isDirectory() || (listFiles = file.listFiles(new FileFilter() { // from class: com.getui.gtc.i.b.a.1
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                return file2.isDirectory() || file2.getName().startsWith(str2);
            }
        })) == null || listFiles.length <= 0) {
            return;
        }
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            File file2 = listFiles[i2];
            if (file2.isDirectory()) {
                a(file2.getAbsolutePath(), str2);
            } else {
                file2.delete();
            }
            i = i2 + 1;
        }
    }
}
