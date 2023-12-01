package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* renamed from: com.amap.api.col.3sl.if  reason: invalid class name and invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/if.class */
public final class Cif {
    public static final String a = ib.c("SYmFja3Vwcw");
    public static final String b = ib.c("SLmFkaXU");
    public static final String c = ib.c("JIw");

    private static String a(Context context) {
        if (Build.VERSION.SDK_INT >= 31 || (context.getApplicationInfo().targetSdkVersion >= 30 && Build.VERSION.SDK_INT >= 30)) {
            return context.getApplicationContext().getExternalFilesDir("").getAbsolutePath();
        }
        StorageManager storageManager = Build.VERSION.SDK_INT >= 9 ? (StorageManager) context.getSystemService("storage") : null;
        try {
            Class<?> cls = Class.forName(ib.c("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
            Method method = storageManager.getClass().getMethod(ib.c("FZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
            Method method2 = cls.getMethod(ib.c("ZZ2V0UGF0aA"), new Class[0]);
            Method method3 = cls.getMethod(ib.c("AaXNSZW1vdmFibGUK"), new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return null;
                }
                Object obj = Array.get(invoke, i2);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (!((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                    return str;
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }
    }

    public static void a(Context context, String str, String str2) {
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile;
        synchronized (Cif.class) {
            try {
                if (Build.VERSION.SDK_INT >= 19 && (context == null || context.checkCallingOrSelfPermission(ib.c("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX0VYVEVSTkFMX1NUT1JBR0U=")) != 0 || context.checkCallingOrSelfPermission(ib.c("EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ==")) != 0)) {
                    return;
                }
                String a2 = a(context);
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                String str3 = str + c + str2;
                File file = new File(a2 + File.separator + a);
                File file2 = new File(file, b);
                FileLock fileLock = null;
                FileLock fileLock2 = null;
                try {
                    if (!file.exists() || file.isDirectory()) {
                        file.mkdirs();
                    }
                    file2.createNewFile();
                    randomAccessFile = new RandomAccessFile(file2, "rws");
                    try {
                        FileChannel channel = randomAccessFile.getChannel();
                        try {
                            FileLock tryLock = channel.tryLock();
                            if (tryLock != null) {
                                fileLock = tryLock;
                                channel.write(ByteBuffer.wrap(str3.getBytes("UTF-8")));
                            }
                            if (tryLock != null) {
                                try {
                                    tryLock.release();
                                } catch (IOException e) {
                                }
                            }
                            if (channel != null) {
                                try {
                                    channel.close();
                                } catch (IOException e2) {
                                }
                            }
                            try {
                                randomAccessFile.close();
                            } catch (Throwable th) {
                            }
                        } catch (Throwable th2) {
                            fileLock2 = fileLock;
                            fileChannel = channel;
                            if (fileLock2 != null) {
                                try {
                                    fileLock2.release();
                                } catch (IOException e3) {
                                }
                            }
                            if (fileChannel != null) {
                                try {
                                    fileChannel.close();
                                } catch (IOException e4) {
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (Throwable th3) {
                                }
                            }
                        }
                    } catch (Throwable th4) {
                        fileChannel = null;
                    }
                } catch (Throwable th5) {
                    fileChannel = null;
                    randomAccessFile = null;
                }
            } catch (Throwable th6) {
                throw th6;
            }
        }
    }
}
