package com.tencent.thumbplayer.c.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingDataRequest;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.m;
import java.io.RandomAccessFile;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/c/a/c.class */
public class c implements ITPAssetResourceLoadingDataRequest {

    /* renamed from: a  reason: collision with root package name */
    private static String f39240a = "TPAssetResourceLoadingDataRequest";
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private long f39241c;
    private boolean d;
    private long e;
    private long f;
    private long g;
    private int h;
    private b i;
    private m j = new m();
    private String k;
    private RandomAccessFile l;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/c/a/c$a.class */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        long f39242a;
        byte[] b;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/c/a/c$b.class */
    public class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 256) {
                return;
            }
            a aVar = (a) message.obj;
            long j = aVar.f39242a;
            byte[] bArr = aVar.b;
            int i = message.arg1;
            c cVar = c.this;
            if (!cVar.a(j, bArr, cVar.k)) {
                TPLogUtil.e(c.f39240a, "write data failed");
                return;
            }
            c.this.j.writeLock().lock();
            c.this.e = i + j;
            c.this.j.writeLock().unlock();
            String str = c.f39240a;
            TPLogUtil.i(str, "write data from " + j + " , with dataLength" + i);
        }
    }

    public c(long j, long j2, boolean z) {
        this.b = j;
        this.f = j;
        this.e = j;
        this.f39241c = j2;
        this.d = z;
    }

    private void a(int i, int i2, int i3, Object obj) {
        b bVar = this.i;
        if (bVar != null) {
            Message obtainMessage = bVar.obtainMessage();
            obtainMessage.what = i;
            obtainMessage.arg1 = i2;
            obtainMessage.arg2 = i3;
            obtainMessage.obj = obj;
            this.i.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004f, code lost:
        if (r8 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
        if (r8 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0066, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006d, code lost:
        com.tencent.thumbplayer.utils.TPLogUtil.e(com.tencent.thumbplayer.c.a.c.f39240a, "fail to close mRandomAccessFile");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(long r6, byte[] r8, java.lang.String r9) {
        /*
            r5 = this;
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L3d java.io.FileNotFoundException -> L98 java.io.IOException -> L9c
            r1 = r0
            r2 = r9
            java.lang.String r3 = "rw"
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L3d java.io.FileNotFoundException -> L98 java.io.IOException -> L9c
            r9 = r0
            r0 = r5
            r1 = r9
            r0.l = r1     // Catch: java.lang.Throwable -> L3d java.io.FileNotFoundException -> L98 java.io.IOException -> L9c
            r0 = r9
            r1 = r6
            r0.seek(r1)     // Catch: java.lang.Throwable -> L3d java.io.FileNotFoundException -> L98 java.io.IOException -> L9c
            r0 = r5
            java.io.RandomAccessFile r0 = r0.l     // Catch: java.lang.Throwable -> L3d java.io.FileNotFoundException -> L98 java.io.IOException -> L9c
            r1 = r8
            r0.write(r1)     // Catch: java.lang.Throwable -> L3d java.io.FileNotFoundException -> L98 java.io.IOException -> L9c
            r0 = 1
            r10 = r0
            r0 = r5
            java.io.RandomAccessFile r0 = r0.l
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L78
            r0 = r8
            r0.close()     // Catch: java.io.IOException -> La0
            r0 = 1
            return r0
        L33:
            java.lang.String r0 = com.tencent.thumbplayer.c.a.c.f39240a
            java.lang.String r1 = "fail to close mRandomAccessFile"
            com.tencent.thumbplayer.utils.TPLogUtil.e(r0, r1)
            r0 = 1
            return r0
        L3d:
            r8 = move-exception
            goto L7b
        L41:
            java.lang.String r0 = com.tencent.thumbplayer.c.a.c.f39240a     // Catch: java.lang.Throwable -> L3d
            java.lang.String r1 = "fail to write data"
            com.tencent.thumbplayer.utils.TPLogUtil.e(r0, r1)     // Catch: java.lang.Throwable -> L3d
            r0 = r5
            java.io.RandomAccessFile r0 = r0.l
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L75
            goto L66
        L55:
            java.lang.String r0 = com.tencent.thumbplayer.c.a.c.f39240a     // Catch: java.lang.Throwable -> L3d
            java.lang.String r1 = "file not found"
            com.tencent.thumbplayer.utils.TPLogUtil.e(r0, r1)     // Catch: java.lang.Throwable -> L3d
            r0 = r5
            java.io.RandomAccessFile r0 = r0.l
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L75
        L66:
            r0 = r8
            r0.close()     // Catch: java.io.IOException -> La4
            goto L75
        L6d:
            java.lang.String r0 = com.tencent.thumbplayer.c.a.c.f39240a
            java.lang.String r1 = "fail to close mRandomAccessFile"
            com.tencent.thumbplayer.utils.TPLogUtil.e(r0, r1)
        L75:
            r0 = 0
            r10 = r0
        L78:
            r0 = r10
            return r0
        L7b:
            r0 = r5
            java.io.RandomAccessFile r0 = r0.l
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L96
            r0 = r9
            r0.close()     // Catch: java.io.IOException -> La8
            goto L96
        L8e:
            java.lang.String r0 = com.tencent.thumbplayer.c.a.c.f39240a
            java.lang.String r1 = "fail to close mRandomAccessFile"
            com.tencent.thumbplayer.utils.TPLogUtil.e(r0, r1)
        L96:
            r0 = r8
            throw r0
        L98:
            r8 = move-exception
            goto L55
        L9c:
            r8 = move-exception
            goto L41
        La0:
            r8 = move-exception
            goto L33
        La4:
            r8 = move-exception
            goto L6d
        La8:
            r9 = move-exception
            goto L8e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.c.a.c.a(long, byte[], java.lang.String):boolean");
    }

    public int a() {
        return this.h;
    }

    public int a(long j) {
        this.j.readLock().lock();
        long j2 = this.e;
        this.j.readLock().unlock();
        if (j >= j2) {
            return -1;
        }
        if (j < this.b) {
            TPLogUtil.e(f39240a, "Offset less than mRequestedOffset");
            return -1;
        }
        return (int) (j2 - j);
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(Looper looper) {
        this.i = new b(looper);
    }

    public void a(String str) {
        this.k = str;
    }

    public void b() {
        b bVar = this.i;
        if (bVar != null) {
            bVar.removeCallbacksAndMessages(null);
            this.i = null;
        }
    }

    @Override // com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingDataRequest
    public long getCurrentOffset() {
        this.j.readLock().lock();
        long j = this.f;
        this.j.readLock().unlock();
        return j;
    }

    @Override // com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingDataRequest
    public long getRequestedLength() {
        return this.f39241c;
    }

    @Override // com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingDataRequest
    public long getRequestedOffset() {
        return this.b;
    }

    @Override // com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingDataRequest
    public void notifyDataReady(long j, long j2) {
        long j3 = j2 + j;
        long j4 = this.b;
        if (j3 > this.f39241c + j4) {
            TPLogUtil.e(f39240a, "data exceed the max request offset");
            return;
        }
        if (j < j4) {
            TPLogUtil.w(f39240a, "the notify data offset is less than request offset");
        }
        if (j3 < this.f) {
            TPLogUtil.e(f39240a, "data not reach current offset");
            return;
        }
        this.j.writeLock().lock();
        this.f = j3;
        this.e = j3;
        this.j.writeLock().unlock();
    }

    @Override // com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingDataRequest
    public void respondWithData(byte[] bArr) {
        if (this.g > this.f39241c) {
            TPLogUtil.i(f39240a, "respond full data");
            return;
        }
        int length = bArr.length;
        a aVar = new a();
        aVar.f39242a = this.f;
        aVar.b = bArr;
        a(256, length, 0, aVar);
        String str = f39240a;
        TPLogUtil.i(str, "respond data from:" + this.f + ", dataLength:" + length);
        this.j.writeLock().lock();
        long j = (long) length;
        this.f = this.f + j;
        this.g = this.g + j;
        this.j.writeLock().unlock();
    }
}
