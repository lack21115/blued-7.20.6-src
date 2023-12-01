package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.nio.channels.FileLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/w.class */
public class w {

    /* renamed from: a  reason: collision with root package name */
    private static w f25222a;
    private static FileLock e;
    private x b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f25223c;
    private boolean d;

    private w() {
    }

    public static w a() {
        if (f25222a == null) {
            synchronized (w.class) {
                try {
                    if (f25222a == null) {
                        f25222a = new w();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f25222a;
    }

    public x a(boolean z) {
        return z ? this.b : c();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0104 A[Catch: all -> 0x0302, TRY_LEAVE, TryCatch #3 {, blocks: (B:4:0x0002, B:9:0x0039, B:11:0x0040, B:20:0x00ab, B:22:0x00b2, B:25:0x00d8, B:27:0x0104, B:48:0x01d3, B:50:0x01de, B:52:0x01e7, B:54:0x0213, B:72:0x02fb, B:55:0x021d, B:57:0x0226, B:58:0x0253, B:60:0x025b, B:62:0x0264, B:64:0x028d, B:65:0x0297, B:67:0x02a0, B:68:0x02ca, B:70:0x02f4, B:18:0x009f, B:24:0x00c8, B:33:0x011f, B:36:0x012f, B:38:0x0144, B:40:0x014a, B:42:0x019d, B:44:0x01a3, B:13:0x0056, B:15:0x0063), top: B:86:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02ca A[Catch: all -> 0x0302, TRY_ENTER, TryCatch #3 {, blocks: (B:4:0x0002, B:9:0x0039, B:11:0x0040, B:20:0x00ab, B:22:0x00b2, B:25:0x00d8, B:27:0x0104, B:48:0x01d3, B:50:0x01de, B:52:0x01e7, B:54:0x0213, B:72:0x02fb, B:55:0x021d, B:57:0x0226, B:58:0x0253, B:60:0x025b, B:62:0x0264, B:64:0x028d, B:65:0x0297, B:67:0x02a0, B:68:0x02ca, B:70:0x02f4, B:18:0x009f, B:24:0x00c8, B:33:0x011f, B:36:0x012f, B:38:0x0144, B:40:0x014a, B:42:0x019d, B:44:0x01a3, B:13:0x0056, B:15:0x0063), top: B:86:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r7) {
        /*
            Method dump skipped, instructions count: 792
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.w.a(android.content.Context):void");
    }

    public FileLock b(Context context) {
        String str;
        TbsLog.i("X5CoreEngine", "tryTbsCoreLoadFileLock ##");
        FileLock fileLock = e;
        if (fileLock != null) {
            return fileLock;
        }
        synchronized (w.class) {
            try {
                if (e == null) {
                    FileLock e2 = FileUtil.e(context);
                    e = e2;
                    if (e2 == null) {
                        str = "init -- sTbsCoreLoadFileLock failed!";
                    } else {
                        str = "init -- sTbsCoreLoadFileLock succeeded: " + e;
                    }
                    TbsLog.i("X5CoreEngine", str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return e;
    }

    public boolean b() {
        if (QbSdk.f25023a) {
            return false;
        }
        return this.f25223c;
    }

    public x c() {
        if (QbSdk.f25023a) {
            return null;
        }
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.d;
    }
}
