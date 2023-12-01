package com.opos.cmn.func.a.a;

import android.content.Context;
import com.opos.cmn.an.g.f;
import com.opos.cmn.an.g.g;
import com.opos.cmn.an.g.h;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/a/a/c.class */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Context f11114a;
    private com.opos.cmn.func.a.a b;

    /* renamed from: c  reason: collision with root package name */
    private long f11115c;
    private long d;
    private CountDownLatch e;
    private boolean f = false;
    private long g;
    private int h;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/a/a/c$a.class */
    public class a {
        private RandomAccessFile b;

        public a(File file, long j) {
            if (file == null || -1 == j) {
                return;
            }
            com.opos.cmn.an.f.a.b("DownloadThread", "seekPos=" + j);
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                this.b = randomAccessFile;
                randomAccessFile.seek(j);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("DownloadThread", "", e);
            }
        }

        public int a(byte[] bArr, int i, int i2) {
            synchronized (this) {
                if (this.b != null) {
                    try {
                        this.b.write(bArr, i, i2);
                    } catch (IOException e) {
                        com.opos.cmn.an.f.a.c("DownloadThread", "", e);
                    }
                }
                i2 = -1;
            }
            return i2;
        }

        public void a() {
            synchronized (this) {
                if (this.b != null) {
                    try {
                        this.b.close();
                    } catch (IOException e) {
                        com.opos.cmn.an.f.a.c("DownloadThread", "", e);
                    }
                }
            }
        }
    }

    public c(Context context, com.opos.cmn.func.a.a aVar, long j, long j2, long j3, CountDownLatch countDownLatch) {
        this.h = -1;
        this.f11114a = context.getApplicationContext();
        this.b = aVar;
        this.g = j;
        this.f11115c = j2;
        this.d = j3;
        this.e = countDownLatch;
        this.h = hashCode();
    }

    public long a() {
        return this.f11115c;
    }

    public long b() {
        return this.d;
    }

    public boolean c() {
        return this.f;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        com.opos.cmn.an.f.a.b("DownloadThread", "threadId=" + this.h + " start.");
        com.opos.cmn.an.f.a.b("DownloadThread", "threadId=" + this.h + " ,startPos=" + this.f11115c + ",endPos=" + this.d);
        try {
            try {
                if (this.d + 1 > this.f11115c) {
                    long a2 = h.a();
                    HashMap hashMap = new HashMap();
                    if (this.b.f11108a.d != null) {
                        hashMap.putAll(this.b.f11108a.d);
                    }
                    String str2 = "bytes=" + this.f11115c + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.d;
                    com.opos.cmn.an.f.a.b("DownloadThread", "rangeProperty=" + str2);
                    hashMap.put("Range", str2);
                    g a3 = h.a(this.f11114a, a2, new f.a().a(this.b.f11108a.f10862a).b(this.b.f11108a.f10863c).a(hashMap).a(this.b.f11108a.b).a(this.b.f11108a.g).a(this.b.f11108a.i).a(this.b.f11108a.h).b(this.b.f11108a.e).c(this.b.f11108a.f).a());
                    if (a3 != null) {
                        com.opos.cmn.an.f.a.b("DownloadThread", "httpResponseEntity.getResponseCode()=" + a3.f10866a);
                        if (206 != a3.f10866a && 200 != a3.f10866a) {
                            str = "httpResponseEntity.getResponseCode()=" + a3.f10866a;
                        }
                        InputStream inputStream = a3.f10867c;
                        if (inputStream != null) {
                            a aVar = new a(d.b(this.f11114a, this.b), this.f11115c);
                            byte[] bArr = new byte[4096];
                            while (true) {
                                try {
                                    try {
                                        int read = inputStream.read(bArr);
                                        if (-1 == read || this.f11115c >= this.d) {
                                            break;
                                        }
                                        int a4 = aVar.a(bArr, 0, read);
                                        com.opos.cmn.an.f.a.b("DownloadThread", "threadId=" + this.h + ", pro=" + a4);
                                        this.f11115c = this.f11115c + ((long) a4);
                                        com.opos.cmn.an.f.a.b("DownloadThread", "threadId=" + this.h + " ,startPos=" + this.f11115c);
                                    } catch (Throwable th) {
                                        aVar.a();
                                        throw th;
                                    }
                                } catch (Exception e) {
                                    com.opos.cmn.an.f.a.c("DownloadThread", "", e);
                                }
                            }
                            aVar.a();
                        } else {
                            str = "InputStream is null.";
                        }
                    } else {
                        str = "httpResponseEntity is null.";
                    }
                    com.opos.cmn.an.f.a.b("DownloadThread", str);
                }
                com.opos.cmn.an.f.a.b("DownloadThread", "threadId=" + this.h + " ,startPos=" + this.f11115c + ",endPos=" + this.d);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("DownloadThread", "DownloadThread run", e2);
            }
            if (this.d + 1 == this.f11115c) {
                com.opos.cmn.an.f.a.b("DownloadThread", "start=endPos+1,download success.");
            } else if (this.g != this.d || this.d != this.f11115c) {
                com.opos.cmn.an.f.a.b("DownloadThread", "start!=endPos,download fail.");
                this.e.countDown();
                com.opos.cmn.an.f.a.b("DownloadThread", "threadId=" + this.h + " end.");
            } else {
                com.opos.cmn.an.f.a.b("DownloadThread", "start=endPos=contentLength,download success.");
            }
            this.f = true;
            this.e.countDown();
            com.opos.cmn.an.f.a.b("DownloadThread", "threadId=" + this.h + " end.");
        } catch (Throwable th2) {
            this.e.countDown();
            throw th2;
        }
    }
}
