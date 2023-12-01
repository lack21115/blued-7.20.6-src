package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.ai;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dr.class */
public abstract class dr extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    protected int f41343a;

    /* renamed from: a  reason: collision with other field name */
    protected Context f310a;

    public dr(Context context, int i) {
        this.f41343a = i;
        this.f310a = context;
    }

    public static void a(Context context, ho hoVar) {
        dk m11623a = dl.a().m11623a();
        String a2 = m11623a == null ? "" : m11623a.a();
        if (TextUtils.isEmpty(a2) || TextUtils.isEmpty(hoVar.a())) {
            return;
        }
        a(context, hoVar, a2);
    }

    private static void a(Context context, ho hoVar, String str) {
        BufferedOutputStream bufferedOutputStream;
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        RandomAccessFile randomAccessFile2;
        BufferedOutputStream bufferedOutputStream2;
        File file;
        byte[] b = dn.b(str, iq.a(hoVar));
        if (b == null || b.length == 0) {
            return;
        }
        synchronized (Cdo.f41340a) {
            try {
                File file2 = new File(context.getExternalFilesDir(null), "push_cdata.lock");
                x.m12222a(file2);
                RandomAccessFile randomAccessFile3 = new RandomAccessFile(file2, "rw");
                try {
                    fileLock = randomAccessFile3.getChannel().lock();
                    try {
                        file = new File(context.getExternalFilesDir(null), "push_cdata.data");
                        bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file, true));
                    } catch (IOException e) {
                        e = e;
                        bufferedOutputStream2 = null;
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream2 = null;
                    }
                } catch (IOException e2) {
                    e = e2;
                    fileLock = null;
                    randomAccessFile2 = randomAccessFile3;
                    bufferedOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileLock = null;
                    randomAccessFile = randomAccessFile3;
                    bufferedOutputStream = null;
                }
                try {
                    bufferedOutputStream2.write(ab.a(b.length));
                    bufferedOutputStream2.write(b);
                    bufferedOutputStream2.flush();
                    file.setLastModified(0L);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e3) {
                        }
                    }
                    x.a(bufferedOutputStream2);
                    randomAccessFile2 = randomAccessFile3;
                } catch (IOException e4) {
                    e = e4;
                    randomAccessFile2 = randomAccessFile3;
                    bufferedOutputStream = bufferedOutputStream2;
                    try {
                        e.printStackTrace();
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e5) {
                            }
                        }
                        x.a(bufferedOutputStream);
                        x.a(randomAccessFile2);
                    } catch (Throwable th3) {
                        randomAccessFile = randomAccessFile2;
                        th = th3;
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e6) {
                            }
                        }
                        x.a(bufferedOutputStream);
                        x.a(randomAccessFile);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    randomAccessFile = randomAccessFile3;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (fileLock != null) {
                        fileLock.release();
                    }
                    x.a(bufferedOutputStream);
                    x.a(randomAccessFile);
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
                bufferedOutputStream = null;
                randomAccessFile2 = null;
                fileLock = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedOutputStream = null;
                randomAccessFile = null;
                fileLock = null;
            }
            x.a(randomAccessFile2);
        }
    }

    private String c() {
        return "dc_job_result_time_" + a();
    }

    private String d() {
        return "dc_job_result_" + a();
    }

    public abstract hi a();

    /* renamed from: a  reason: collision with other method in class */
    protected boolean m11626a() {
        return dn.a(this.f310a, String.valueOf(a()), this.f41343a);
    }

    public abstract String b();

    /* renamed from: b  reason: collision with other method in class */
    protected boolean m11627b() {
        return true;
    }

    /* renamed from: c  reason: collision with other method in class */
    protected boolean m11628c() {
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        String b = b();
        if (TextUtils.isEmpty(b)) {
            return;
        }
        if (m11626a()) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("DC run job mutual: " + a());
            return;
        }
        dk m11623a = dl.a().m11623a();
        String a2 = m11623a == null ? "" : m11623a.a();
        if (!TextUtils.isEmpty(a2) && m11627b()) {
            String str = b;
            if (m11628c()) {
                SharedPreferences sharedPreferences = this.f310a.getSharedPreferences("mipush_extra", 0);
                str = b;
                if (bn.a(b).equals(sharedPreferences.getString(d(), null))) {
                    long j = sharedPreferences.getLong(c(), 0L);
                    int a3 = com.xiaomi.push.service.ba.a(this.f310a).a(hl.DCJobUploadRepeatedInterval.a(), 604800);
                    if ((System.currentTimeMillis() - j) / 1000 < this.f41343a) {
                        return;
                    }
                    str = b;
                    if ((System.currentTimeMillis() - j) / 1000 < a3) {
                        str = "same_".concat(String.valueOf(j));
                    }
                }
            }
            ho hoVar = new ho();
            hoVar.a(str);
            hoVar.a(System.currentTimeMillis());
            hoVar.a(a());
            a(this.f310a, hoVar, a2);
        }
    }
}
