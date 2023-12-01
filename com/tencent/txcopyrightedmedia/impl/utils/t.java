package com.tencent.txcopyrightedmedia.impl.utils;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.txcopyrightedmedia.TXCopyrightedMedia;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/t.class */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public MediaExtractor f40154a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f40155c;
    public long d;
    public boolean e;
    public long f;
    public aa g;
    public boolean h;
    public MediaFormat i;
    public String j;
    public volatile long k;
    public volatile long l;
    private int n;
    private Uri p;
    private int o = 0;
    public int m = 2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/t$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        long f40156a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        private String f40157c;

        public a(long j, String str, int i) {
            this.f40156a = j;
            this.f40157c = str;
            this.b = i;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    private static long a(byte b, int i) {
        byte b2 = b;
        if (b < 0) {
            b2 = b + 256;
        }
        long j = b2;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return j;
            }
            j *= 2;
            i2 = i3 + 1;
        }
    }

    private static long a(byte[] bArr, int i) {
        long j = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 4) {
                return j;
            }
            j += a(bArr[i + i3], (3 - i3) * 8);
            i2 = i3 + 1;
        }
    }

    private static a a(byte[] bArr, String str, a aVar) {
        int i = aVar.b;
        while (true) {
            int i2 = i;
            long j = i2;
            if (j >= aVar.b + aVar.f40156a || i2 + 8 >= bArr.length) {
                return null;
            }
            long a2 = a(bArr, i2);
            String str2 = new String(bArr, i2 + 4, 4);
            if (TextUtils.equals(str, str2)) {
                return new a(a2, str2, i2);
            }
            i = (int) (j + a2);
        }
    }

    public final int a(ByteBuffer byteBuffer) {
        int readSampleData;
        long currentTimeMillis = System.currentTimeMillis();
        this.f40154a.seekTo(this.f, 0);
        int i = 0;
        while (true) {
            readSampleData = this.f40154a.readSampleData(byteBuffer, 0);
            StringBuilder sb = new StringBuilder("do seek: seek time: ");
            sb.append(this.f);
            sb.append(", sampleSize: ");
            sb.append(readSampleData);
            sb.append(", sampleTime: ");
            sb.append(this.f40154a.getSampleTime());
            if (readSampleData >= 0) {
                if (this.f40154a.getSampleTime() >= this.f) {
                    break;
                }
                this.f40154a.advance();
            } else if (i > 0 || this.f >= this.d * 1000) {
                break;
            } else {
                try {
                    this.f40154a.release();
                    MediaExtractor mediaExtractor = new MediaExtractor();
                    this.f40154a = mediaExtractor;
                    mediaExtractor.setDataSource(TXCopyrightedMedia.instance().getApplicationContext(), this.p, (Map<String, String>) null);
                    this.f40154a.selectTrack(this.o);
                    this.f40154a.seekTo(0L, 0);
                    this.f40154a.seekTo(this.f, 0);
                    i++;
                } catch (IOException e) {
                    e.printStackTrace();
                    new StringBuilder("fix exception: ").append(Log.getStackTraceString(e));
                }
            }
        }
        aa aaVar = this.g;
        if (aaVar != null) {
            aaVar.a();
        }
        new StringBuilder("seek cost: ").append(System.currentTimeMillis() - currentTimeMillis);
        return readSampleData;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0085, code lost:
        r9.b = r9.i.getInteger(android.media.MediaFormat.KEY_SAMPLE_RATE);
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e6 A[Catch: Exception -> 0x01f7, TRY_LEAVE, TryCatch #3 {Exception -> 0x01f7, blocks: (B:7:0x0031, B:9:0x0044, B:11:0x0051, B:13:0x0072, B:31:0x00de, B:33:0x00e6, B:35:0x00ef, B:38:0x00f9, B:40:0x0110, B:42:0x0127, B:46:0x0164, B:45:0x0154, B:47:0x016a, B:48:0x016d, B:29:0x00d9, B:25:0x00c0, B:21:0x00ab, B:17:0x0096, B:49:0x01cb, B:50:0x01d8, B:52:0x01df, B:23:0x00b0, B:19:0x009b, B:27:0x00c5, B:15:0x0085), top: B:66:0x0031, inners: #0, #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01df A[Catch: Exception -> 0x01f7, TRY_LEAVE, TryCatch #3 {Exception -> 0x01f7, blocks: (B:7:0x0031, B:9:0x0044, B:11:0x0051, B:13:0x0072, B:31:0x00de, B:33:0x00e6, B:35:0x00ef, B:38:0x00f9, B:40:0x0110, B:42:0x0127, B:46:0x0164, B:45:0x0154, B:47:0x016a, B:48:0x016d, B:29:0x00d9, B:25:0x00c0, B:21:0x00ab, B:17:0x0096, B:49:0x01cb, B:50:0x01d8, B:52:0x01df, B:23:0x00b0, B:19:0x009b, B:27:0x00c5, B:15:0x0085), top: B:66:0x0031, inners: #0, #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.tencent.txcopyrightedmedia.impl.utils.i a(byte[] r10, android.net.Uri r11) {
        /*
            Method dump skipped, instructions count: 543
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.txcopyrightedmedia.impl.utils.t.a(byte[], android.net.Uri):com.tencent.txcopyrightedmedia.impl.utils.i");
    }

    public final void a() {
        if (this.m == 2) {
            return;
        }
        this.m = 2;
        aa aaVar = this.g;
        if (aaVar != null) {
            aaVar.d();
        }
    }

    public final void b() {
        MediaExtractor mediaExtractor;
        this.h = true;
        if (this.m == 2 && (mediaExtractor = this.f40154a) != null) {
            try {
                mediaExtractor.release();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        a();
    }

    public final boolean c() {
        return this.m != 2;
    }
}
