package com.ishumei.l111l11111Il;

import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.bh;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l11l1111Il.class */
public final class l11l1111Il {
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075 A[Catch: Exception -> 0x00aa, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x00aa, blocks: (B:3:0x0002, B:5:0x000b, B:7:0x0013, B:12:0x002f, B:14:0x0037, B:16:0x004c, B:19:0x0057, B:21:0x0060, B:26:0x0075), top: B:47:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String l1111l111111Il() {
        /*
            Method dump skipped, instructions count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ishumei.l111l11111Il.l11l1111Il.l1111l111111Il():java.lang.String");
    }

    private static String l1111l111111Il(int i) {
        Method method;
        if (Build.VERSION.SDK_INT > 27) {
            return String.format(Locale.CHINA, "u0_a%d", Integer.valueOf(i - 10000));
        }
        try {
            Field declaredField = Class.forName("libcore.io.Libcore").getDeclaredField(bh.x);
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            Object obj = declaredField.get(null);
            if (obj == null || (method = obj.getClass().getMethod("getpwuid", Integer.TYPE)) == null) {
                return null;
            }
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            Object invoke = method.invoke(obj, Integer.valueOf(i));
            if (invoke != null) {
                Field declaredField2 = invoke.getClass().getDeclaredField("pw_name");
                if (!declaredField2.isAccessible()) {
                    declaredField2.setAccessible(true);
                }
                return (String) declaredField2.get(invoke);
            }
            return null;
        } catch (Exception e) {
            return String.format(Locale.CHINA, "u0_a%d", Integer.valueOf(i - 10000));
        }
    }

    private static String l1111l111111Il(BufferedInputStream bufferedInputStream) {
        int read;
        byte[] bArr = new byte[512];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb.append(new String(bArr, 0, read));
                }
            } catch (Exception e) {
            }
        } while (read >= 512);
        return sb.toString();
    }

    private static String l1111l111111Il(String str) {
        BufferedInputStream bufferedInputStream;
        Process process;
        BufferedInputStream bufferedInputStream2;
        try {
            process = Runtime.getRuntime().exec(str);
            try {
                bufferedInputStream = new BufferedInputStream(process.getInputStream());
            } catch (Exception e) {
                bufferedInputStream2 = null;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = null;
            }
        } catch (Exception e2) {
            process = null;
            bufferedInputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
            process = null;
        }
        try {
            process.waitFor();
            String l1111l111111Il = l1111l111111Il(bufferedInputStream);
            try {
                bufferedInputStream.close();
            } catch (IOException e3) {
            }
            if (process != null) {
                process.destroy();
            }
            return l1111l111111Il;
        } catch (Exception e4) {
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e5) {
                }
            }
            if (process != null) {
                process.destroy();
                return null;
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e6) {
                }
            }
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
    }

    public static void l1111l111111Il(com.ishumei.l1111l111111Il.l111l11111lIl l111l11111lil) {
        try {
            String l1111l111111Il = l1111l111111Il();
            if (TextUtils.isEmpty(l1111l111111Il)) {
                return;
            }
            String l1111l111111Il2 = l1111l111111Il("ps");
            if (!TextUtils.isEmpty(l1111l111111Il2) && l1111l111111Il2.split("\n").length > 0) {
                l111l11111lil.l11l11l11I1l(l1111l111111Il);
            }
        } catch (Exception e) {
        }
    }

    private static void l111l11111lIl(com.ishumei.l1111l111111Il.l111l11111lIl l111l11111lil) {
        try {
            String l1111l111111Il = l1111l111111Il();
            if (TextUtils.isEmpty(l1111l111111Il)) {
                return;
            }
            String l1111l111111Il2 = l1111l111111Il("ps");
            if (!TextUtils.isEmpty(l1111l111111Il2) && l1111l111111Il2.split("\n").length > 0) {
                l111l11111lil.l11l11l11I1l(l1111l111111Il);
            }
        } catch (Exception e) {
        }
    }

    private static boolean l111l11111lIl(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return true;
            }
            if (!Character.isDigit(str.charAt(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }
}
