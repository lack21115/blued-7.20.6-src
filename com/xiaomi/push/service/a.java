package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f27899a;

    /* renamed from: a  reason: collision with other field name */
    private Context f902a;
    private volatile String e;
    private volatile String f;

    /* renamed from: a  reason: collision with other field name */
    private final Object f903a = new Object();
    private final Object b = new Object();

    /* renamed from: a  reason: collision with other field name */
    private final String f904a = "mipush_region";

    /* renamed from: b  reason: collision with other field name */
    private final String f905b = "mipush_country_code";

    /* renamed from: c  reason: collision with root package name */
    private final String f27900c = "mipush_region.lock";
    private final String d = "mipush_country_code.lock";

    public a(Context context) {
        this.f902a = context;
    }

    public static a a(Context context) {
        if (f27899a == null) {
            synchronized (a.class) {
                try {
                    if (f27899a == null) {
                        f27899a = new a(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f27899a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.io.Closeable] */
    private String a(Context context, String str, String str2, Object obj) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        Throwable th;
        RandomAccessFile randomAccessFile2;
        FileLock fileLock2;
        RandomAccessFile randomAccessFile3;
        FileLock lock;
        File file = new File(context.getFilesDir(), str);
        if (!file.exists()) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("No ready file to get data from ".concat(String.valueOf(str)));
            return null;
        }
        synchronized (obj) {
            try {
                try {
                    File file2 = new File(context.getFilesDir(), str2);
                    com.xiaomi.push.x.m9172a(file2);
                    randomAccessFile3 = new RandomAccessFile(file2, "rw");
                    try {
                        lock = randomAccessFile3.getChannel().lock();
                    } catch (Exception e) {
                        e = e;
                        randomAccessFile2 = randomAccessFile3;
                        fileLock2 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileLock = null;
                        randomAccessFile = randomAccessFile3;
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e2) {
                                com.xiaomi.channel.commonutils.logger.b.a(e2);
                            }
                        }
                        com.xiaomi.push.x.a((Closeable) randomAccessFile);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    randomAccessFile2 = null;
                    fileLock2 = null;
                } catch (Throwable th3) {
                    th = th3;
                    randomAccessFile = null;
                    fileLock = null;
                }
                try {
                    String a2 = com.xiaomi.push.x.a(file);
                    if (lock != null && lock.isValid()) {
                        try {
                            lock.release();
                        } catch (IOException e4) {
                            com.xiaomi.channel.commonutils.logger.b.a(e4);
                        }
                    }
                    com.xiaomi.push.x.a(randomAccessFile3);
                    return a2;
                } catch (Exception e5) {
                    randomAccessFile2 = randomAccessFile3;
                    fileLock2 = lock;
                    e = e5;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    if (fileLock2 != null && fileLock2.isValid()) {
                        try {
                            fileLock2.release();
                        } catch (IOException e6) {
                            com.xiaomi.channel.commonutils.logger.b.a(e6);
                        }
                    }
                    com.xiaomi.push.x.a(randomAccessFile2);
                    return null;
                }
            } catch (Throwable th4) {
                fileLock = null;
                randomAccessFile = str;
                th = th4;
            }
        }
    }

    private void a(Context context, String str, String str2, String str3, Object obj) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        RandomAccessFile randomAccessFile3;
        RandomAccessFile randomAccessFile4;
        synchronized (obj) {
            FileLock fileLock2 = null;
            try {
                File file = new File(context.getFilesDir(), str3);
                com.xiaomi.push.x.m9172a(file);
                randomAccessFile4 = new RandomAccessFile(file, "rw");
                fileLock2 = null;
                fileLock = null;
                randomAccessFile = randomAccessFile4;
            } catch (Exception e) {
                e = e;
                randomAccessFile2 = null;
            } catch (Throwable th) {
                th = th;
                fileLock = null;
                randomAccessFile = null;
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (IOException e2) {
                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                    }
                }
                com.xiaomi.push.x.a(randomAccessFile);
                throw th;
            }
            try {
                try {
                    FileLock lock = randomAccessFile4.getChannel().lock();
                    fileLock2 = lock;
                    com.xiaomi.push.x.a(new File(context.getFilesDir(), str2), str);
                    randomAccessFile3 = randomAccessFile4;
                    if (lock != null) {
                        randomAccessFile3 = randomAccessFile4;
                        if (lock.isValid()) {
                            try {
                                lock.release();
                                randomAccessFile3 = randomAccessFile4;
                            } catch (IOException e3) {
                                com.xiaomi.channel.commonutils.logger.b.a(e3);
                                randomAccessFile3 = randomAccessFile4;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileLock != null && fileLock.isValid()) {
                        fileLock.release();
                    }
                    com.xiaomi.push.x.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                randomAccessFile2 = randomAccessFile4;
                fileLock = fileLock2;
                randomAccessFile = randomAccessFile2;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                randomAccessFile3 = randomAccessFile2;
                if (fileLock2 != null) {
                    randomAccessFile3 = randomAccessFile2;
                    if (fileLock2.isValid()) {
                        try {
                            fileLock2.release();
                            randomAccessFile3 = randomAccessFile2;
                        } catch (IOException e5) {
                            com.xiaomi.channel.commonutils.logger.b.a(e5);
                            randomAccessFile3 = randomAccessFile2;
                        }
                    }
                }
                com.xiaomi.push.x.a(randomAccessFile3);
            }
            com.xiaomi.push.x.a(randomAccessFile3);
        }
    }

    public String a() {
        if (TextUtils.isEmpty(this.e)) {
            this.e = a(this.f902a, "mipush_region", "mipush_region.lock", this.f903a);
        }
        return this.e;
    }

    public void a(String str, boolean z) {
        if (!TextUtils.equals(str, this.e)) {
            this.e = str;
        }
        if (z) {
            a(this.f902a, str, "mipush_region", "mipush_region.lock", this.f903a);
        }
    }

    public String b() {
        if (TextUtils.isEmpty(this.f)) {
            this.f = a(this.f902a, "mipush_country_code", "mipush_country_code.lock", this.b);
        }
        return this.f;
    }

    public void b(String str, boolean z) {
        if (!TextUtils.equals(str, this.f)) {
            this.f = str;
        }
        if (z) {
            a(this.f902a, str, "mipush_country_code", "mipush_region.lock", this.f903a);
        }
    }
}
