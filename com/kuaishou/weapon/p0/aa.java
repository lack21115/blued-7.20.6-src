package com.kuaishou.weapon.p0;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.BufferedInputStream;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/aa.class */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    private static volatile aa f23716a;

    private aa() {
    }

    public static aa a() {
        aa aaVar;
        synchronized (aa.class) {
            try {
                if (f23716a == null) {
                    synchronized (aa.class) {
                        if (f23716a == null) {
                            f23716a = new aa();
                        }
                    }
                }
                aaVar = f23716a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aaVar;
    }

    private static String a(BufferedInputStream bufferedInputStream) {
        int read;
        if (bufferedInputStream == null) {
            return "";
        }
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

    public String a(String str) {
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String b(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.aa.b(java.lang.String):java.lang.String");
    }
}
