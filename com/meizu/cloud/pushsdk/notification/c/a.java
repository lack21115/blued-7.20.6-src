package com.meizu.cloud.pushsdk.notification.c;

import android.text.TextUtils;
import com.huawei.openalliance.ad.utils.p;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/notification/c/a.class */
public class a {
    public static void a(String str, String str2) {
        File file;
        try {
            new File(str2).mkdirs();
            String[] list = new File(str).list();
            int length = list.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                String str3 = list[i2];
                if (str.endsWith(File.separator)) {
                    file = new File(str + str3);
                } else {
                    file = new File(str + File.separator + str3);
                }
                if (file.isFile()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    FileOutputStream fileOutputStream = new FileOutputStream(str2 + "/" + file.getName());
                    byte[] bArr = new byte[5120];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    fileInputStream.close();
                } else if (file.isDirectory()) {
                    a(str + "/" + str3, str2 + "/" + str3);
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str) || str.contains("../")) {
            return false;
        }
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str) || str.contains("../")) {
            return false;
        }
        String str2 = str;
        if (!str.endsWith(File.separator)) {
            str2 = str + File.separator;
        }
        File file = new File(str2);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            boolean z = true;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                File file2 = listFiles[i2];
                boolean isFile = file2.isFile();
                String absolutePath = file2.getAbsolutePath();
                if (isFile) {
                    boolean a2 = a(absolutePath);
                    z = a2;
                    if (!a2) {
                        z = a2;
                        break;
                    }
                    i = i2 + 1;
                } else {
                    boolean b = b(absolutePath);
                    z = b;
                    if (!b) {
                        z = b;
                        break;
                    }
                    i = i2 + 1;
                }
            }
            if (z) {
                return file.delete();
            }
            return false;
        }
        return false;
    }

    public static File[] b(String str, final String str2) {
        File file = new File(str);
        File[] fileArr = new File[0];
        if (file.isDirectory()) {
            fileArr = file.listFiles(new FileFilter() { // from class: com.meizu.cloud.pushsdk.notification.c.a.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    try {
                        return Long.valueOf(str2).longValue() > Long.valueOf(file2.getName().split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[1]).longValue();
                    } catch (Exception e) {
                        DebugLogger.e(p.Code, "filters file error " + e.getMessage());
                        return true;
                    }
                }
            });
        }
        return fileArr;
    }
}
