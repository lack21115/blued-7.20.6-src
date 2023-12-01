package com.tencent.qimei.j;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Date;
import java.util.Random;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/j/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Random f38340a = new Random();

    public static String a() {
        String d = com.tencent.qimei.c.a.d();
        int nextInt = f38340a.nextInt(2147473647);
        return a(BridgeUtil.UNDERLINE_STR + d + BridgeUtil.UNDERLINE_STR + new Date().getTime() + BridgeUtil.UNDERLINE_STR + (nextInt + 1000));
    }

    public static String a(String str) {
        String b = b(str);
        if (b != null) {
            try {
                return b.substring(8, 24);
            } catch (Exception e) {
                com.tencent.qimei.k.a.a(e);
            }
        }
        return b;
    }

    public static void a(Closeable... closeableArr) {
        int length = closeableArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Closeable closeable = closeableArr[i2];
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            i = i2 + 1;
        }
    }

    public static String b(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes(Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();
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
        } catch (Exception e) {
            com.tencent.qimei.k.a.a(e);
            return str;
        }
    }

    public static String c(String str) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        String byteArrayOutputStream2 = byteArrayOutputStream.toString("UTF-8");
                        a(fileInputStream);
                        a(byteArrayOutputStream);
                        return byteArrayOutputStream2;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (Exception e) {
                a(fileInputStream);
                a(byteArrayOutputStream);
                return "";
            } catch (Throwable th) {
                th = th;
                a(fileInputStream);
                a(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }
}
