package com.blued.android.statistics.util;

import android.text.TextUtils;
import com.anythink.core.common.k.f;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.MessageDigest;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/util/FileUtils.class */
public class FileUtils {
    private static final char[] a = "0123456789abcdef".toCharArray();

    public static String a(File file) {
        try {
            char[] cArr = new char[(int) file.length()];
            FileReader fileReader = new FileReader(file);
            fileReader.read(cArr);
            fileReader.close();
            return new String(cArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static String a(String str) {
        try {
            return a(MessageDigest.getInstance(f.a).digest(str.getBytes()));
        } catch (Exception e) {
            return str;
        }
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            byte b = bArr[i2];
            sb.append(a[(b >> 4) & 15]);
            sb.append(a[b & 15]);
            i = i2 + 1;
        }
    }

    public static void a(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(str);
            fileWriter.close();
        } catch (Exception e) {
        }
    }
}
