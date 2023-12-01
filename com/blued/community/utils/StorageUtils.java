package com.blued.community.utils;

import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.utils.Md5;
import com.blued.community.auto.CommunityServiceManager;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/utils/StorageUtils.class */
public class StorageUtils {

    /* renamed from: a  reason: collision with root package name */
    private static String f6868a;
    private static String b;

    public static Uri a(File file) {
        return Build.VERSION.SDK_INT < 24 ? Uri.fromFile(file) : FileProvider.getUriForFile(AppInfo.d(), a(), file);
    }

    public static String a() {
        String g = CommunityServiceManager.a().g();
        String str = g;
        if (TextUtils.isEmpty(g)) {
            str = "com.blued.community";
        }
        return str + ".fileprovider";
    }

    public static String a(String str, String str2, String str3) {
        String d = d(str);
        if (TextUtils.isEmpty(d)) {
            return str3;
        }
        if (TextUtils.equals(str2, str3)) {
            if (AppMethods.a(str3, d, true)) {
                return d;
            }
        } else if (AppMethods.a(str3, d)) {
            return d;
        }
        return str3;
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        if (TextUtils.isEmpty(d()) || !str.startsWith(d())) {
            return !TextUtils.isEmpty(c()) && str.startsWith(c());
        }
        return true;
    }

    public static Uri b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return a(new File(str));
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy();
    }

    public static String c() {
        if (TextUtils.isEmpty(f6868a)) {
            try {
                f6868a = AppInfo.d().getExternalCacheDir().getParentFile().getAbsolutePath();
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (f6868a == null) {
            f6868a = "";
        }
        return f6868a;
    }

    public static byte[] c(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String d() {
        if (TextUtils.isEmpty(b)) {
            try {
                b = AppInfo.d().getCacheDir().getParentFile().getAbsolutePath();
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (b == null) {
            b = "";
        }
        return b;
    }

    private static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String b2 = AppMethods.b("video");
        String a2 = Md5.a(str.toLowerCase());
        return b2 + File.separator + a2;
    }
}
