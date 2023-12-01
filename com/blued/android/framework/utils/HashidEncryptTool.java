package com.blued.android.framework.utils;

import android.text.TextUtils;
import com.blued.android.framework.Hashids;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/HashidEncryptTool.class */
public class HashidEncryptTool {
    public static String a(String str) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            try {
                long[] a2 = new Hashids("1766", 6).a(str);
                int length = a2.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    sb.append(a2[i2]);
                    i = i2 + 1;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
            try {
                return new Hashids("1766", 6).a(Long.valueOf(str).longValue());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
                return str;
            }
        }
        return str;
    }
}
