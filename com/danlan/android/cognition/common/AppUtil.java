package com.danlan.android.cognition.common;

import android.content.Context;
import com.danlan.android.cognition.StringFog;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/common/AppUtil.class */
public class AppUtil {
    public static String getCurrentProcessName() {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        int i;
        try {
            fileInputStream = new FileInputStream(StringFog.decrypt("DlNWTEIMV0RNRQtATEdISE9G"));
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            try {
                byte[] bArr = new byte[256];
                int i2 = 0;
                while (true) {
                    i = i2;
                    int read = fileInputStream.read();
                    if (read <= 0 || i >= 256) {
                        break;
                    }
                    bArr[i] = (byte) read;
                    i2 = i + 1;
                }
                fileInputStream2 = fileInputStream;
                if (i > 0) {
                    String str = new String(bArr, 0, i, StringFog.decrypt("dHdiDhk="));
                    try {
                        fileInputStream.close();
                        return str;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return str;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream2 = fileInputStream;
                        fileInputStream2.close();
                        return null;
                    }
                    return null;
                } catch (Throwable th3) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th3;
                }
            }
            fileInputStream2.close();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static String getVersionCode(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (Exception e) {
            return "";
        }
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            return "";
        }
    }
}
