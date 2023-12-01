package com.opos.cmn.func.dl.base.h;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.opos.cmn.an.a.c;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/h/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11261a = a.class.getSimpleName();
    private static final Pattern b = Pattern.compile("attachment;\\s*filename\\s*=\\s*(\"?)([^\"]*)\\1\\s*$", 2);

    public static int a(String str, String str2) {
        return (str + File.separator + str2).hashCode();
    }

    public static String a(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            int length = digest.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return sb.toString();
                }
                int i3 = digest[i2] & 255;
                if (i3 < 16) {
                    sb.append(0);
                }
                sb.append(Integer.toHexString(i3));
                i = i2 + 1;
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 should be supported", e);
        }
    }

    public static void a(File file) {
        if (file == null || file.exists()) {
            return;
        }
        if (!com.opos.cmn.an.d.b.a.b(com.opos.cmn.an.d.b.a.d(file))) {
            com.opos.cmn.an.d.b.a.c(file);
        }
        com.opos.cmn.an.d.b.a.f(file);
    }

    public static void a(Closeable... closeableArr) {
        try {
            int length = closeableArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                Closeable closeable = closeableArr[i2];
                if (closeable != null) {
                    closeable.close();
                }
                i = i2 + 1;
            }
        } catch (IOException e) {
            com.opos.cmn.an.f.a.c(f11261a, e.getMessage());
        }
    }

    private static boolean a() {
        try {
            return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean a(int i) {
        return i == 200 || i == 206;
    }

    public static boolean a(long j) {
        if (a()) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return j <= ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        }
        return false;
    }

    public static boolean a(long j, File file) {
        boolean z = j <= 0 || j == file.length();
        com.opos.cmn.an.f.a.a(f11261a, "length check:".concat(String.valueOf(z)));
        return z;
    }

    public static boolean a(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 && context.checkCallingOrSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0;
    }

    public static boolean a(String str, File file) {
        boolean equals = !TextUtils.isEmpty(str) ? str.equals(c.a(file)) : true;
        com.opos.cmn.an.f.a.a(f11261a, "md5 check:".concat(String.valueOf(equals)));
        return equals;
    }

    public static long b(String str) {
        if (str == null) {
            return -1L;
        }
        String[] split = str.split("/");
        if (split.length >= 2) {
            try {
                return Long.parseLong(split[1]);
            } catch (NumberFormatException e) {
                com.opos.cmn.an.f.a.c(f11261a, "parse instance length failed with ".concat(String.valueOf(str)));
                return -1L;
            }
        }
        return -1L;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Matcher matcher = b.matcher(str);
            if (matcher.find()) {
                return matcher.group(2);
            }
            return null;
        } catch (IllegalStateException e) {
            return null;
        }
    }

    public static String d(String str) {
        String e = e(str);
        String str2 = e;
        if (TextUtils.isEmpty(e)) {
            str2 = a(str);
        }
        return str2;
    }

    private static String e(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        try {
            String path = new URL(str).getPath();
            String substring = path.substring(path.lastIndexOf(47) + 1);
            if (substring.isEmpty()) {
                return null;
            }
            return substring;
        } catch (MalformedURLException e) {
            return null;
        }
    }
}
