package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/bo.class */
public class bo {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6510a = "IOUtils";

    public static void a(Context context, String str, String str2) {
        try {
            a(context.getAssets().open(str), str2);
        } catch (Exception e) {
            bq.a().a(e);
        }
    }

    public static void a(InputStream inputStream, String str) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            inputStream.close();
            fileOutputStream.close();
            if (inputStream != null) {
                inputStream.close();
            }
            fileOutputStream.close();
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    public static boolean a(File file) {
        boolean z = false;
        if (file != null) {
            z = false;
            try {
                if (file.exists()) {
                    z = false;
                    if (file.canRead()) {
                        z = false;
                        if (file.length() > 0) {
                            z = true;
                        }
                    }
                }
            } catch (Exception e) {
                return false;
            }
        }
        return z;
    }

    public static boolean a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            boolean z = false;
            if (file.exists()) {
                z = false;
                if (file.canRead()) {
                    z = false;
                    if (file.length() > 0) {
                        z = true;
                    }
                }
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean a(String str, String str2) {
        boolean z = false;
        try {
            File file = new File(str);
            File file2 = new File(str2);
            if (file.exists()) {
                z = file.renameTo(file2);
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }
}
