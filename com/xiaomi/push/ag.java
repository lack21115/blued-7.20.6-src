package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ag.class */
public class ag {
    public static boolean a(Context context, String str, long j) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        if (Build.VERSION.SDK_INT < 23 || g.d(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            FileLock fileLock = null;
            Closeable closeable = null;
            FileLock fileLock2 = null;
            try {
                try {
                    File file = new File(new File(context.getExternalFilesDir(null), "/.vdevdir/"), "lcfp.lock");
                    x.m12222a(file);
                    randomAccessFile2 = new RandomAccessFile(file, "rw");
                    fileLock = null;
                } catch (IOException e) {
                    e = e;
                    randomAccessFile = null;
                } catch (Throwable th) {
                    th = th;
                    closeable = null;
                    if (0 != 0) {
                        try {
                            fileLock2.release();
                        } catch (IOException e2) {
                        }
                    }
                    x.a(closeable);
                    throw th;
                }
                try {
                    FileLock lock = randomAccessFile2.getChannel().lock();
                    fileLock = lock;
                    boolean b = b(context, str, j);
                    if (lock != null && lock.isValid()) {
                        try {
                            lock.release();
                        } catch (IOException e3) {
                        }
                    }
                    x.a(randomAccessFile2);
                    return b;
                } catch (IOException e4) {
                    e = e4;
                    randomAccessFile = randomAccessFile2;
                    e.printStackTrace();
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e5) {
                        }
                    }
                    x.a(randomAccessFile);
                    return true;
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0 && fileLock2.isValid()) {
                    fileLock2.release();
                }
                x.a(closeable);
                throw th;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x0145: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r16 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:49:0x0145 */
    /* JADX WARN: Removed duplicated region for block: B:64:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01c8 A[EDGE_INSN: B:98:0x01c8->B:80:0x01c8 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v75, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean b(android.content.Context r7, java.lang.String r8, long r9) {
        /*
            Method dump skipped, instructions count: 481
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ag.b(android.content.Context, java.lang.String, long):boolean");
    }
}
