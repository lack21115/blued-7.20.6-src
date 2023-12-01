package com.alibaba.mtl.log.e;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/k.class */
public class k {

    /* renamed from: a  reason: collision with root package name */
    static File f4497a;

    /* renamed from: a  reason: collision with other field name */
    static FileChannel f36a;

    /* renamed from: a  reason: collision with other field name */
    static FileLock f37a;

    public static boolean c(Context context) {
        FileLock fileLock;
        synchronized (k.class) {
            try {
                if (f4497a == null) {
                    f4497a = new File(context.getFilesDir() + File.separator + "ap.Lock");
                }
                boolean exists = f4497a.exists();
                boolean z = exists;
                if (!exists) {
                    try {
                        z = f4497a.createNewFile();
                    } catch (IOException e) {
                        z = exists;
                    }
                }
                if (z) {
                    if (f36a == null) {
                        try {
                            f36a = new RandomAccessFile(f4497a, "rw").getChannel();
                        } catch (Exception e2) {
                            return false;
                        }
                    }
                    try {
                        FileLock tryLock = f36a.tryLock();
                        fileLock = tryLock;
                        if (tryLock != null) {
                            f37a = tryLock;
                            return true;
                        }
                    } catch (Throwable th) {
                        fileLock = null;
                    }
                    Log.d("TAG", "mLock:" + fileLock);
                    return false;
                }
                return true;
            } finally {
            }
        }
    }

    public static void release() {
        synchronized (k.class) {
            try {
                if (f37a != null) {
                    try {
                        f37a.release();
                    } catch (IOException e) {
                    } catch (Throwable th) {
                        f37a = null;
                        throw th;
                    }
                    f37a = null;
                }
                if (f36a != null) {
                    try {
                        f36a.close();
                    } catch (Exception e2) {
                    } catch (Throwable th2) {
                        f36a = null;
                        throw th2;
                    }
                    f36a = null;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
