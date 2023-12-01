package com.tencent.cloud.huiyansdkface.okhttp3.internal.publicsuffix;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.GzipSource;
import com.tencent.cloud.huiyansdkface.okio.Okio;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/publicsuffix/PublicSuffixDatabase.class */
public final class PublicSuffixDatabase {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f22337a = {42};
    private static final String[] b = new String[0];

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f22338c = {"*"};
    private static final PublicSuffixDatabase d = new PublicSuffixDatabase();
    private final AtomicBoolean e = new AtomicBoolean(false);
    private final CountDownLatch f = new CountDownLatch(1);
    private byte[] g;
    private byte[] h;

    private static String a(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int length = bArr.length;
        int i7 = 0;
        while (i7 < length) {
            int i8 = (i7 + length) / 2;
            while (true) {
                i2 = i8;
                if (i2 <= -1 || bArr[i2] == 10) {
                    break;
                }
                i8 = i2 - 1;
            }
            int i9 = i2 + 1;
            int i10 = 1;
            while (true) {
                int i11 = i10;
                i3 = i9 + i11;
                if (bArr[i3] == 10) {
                    break;
                }
                i10 = i11 + 1;
            }
            int i12 = i3 - i9;
            int i13 = i;
            boolean z = false;
            int i14 = 0;
            int i15 = 0;
            while (true) {
                if (z) {
                    i4 = 46;
                    z = false;
                } else {
                    i4 = bArr2[i13][i14] & 255;
                }
                i5 = i4 - (bArr[i9 + i15] & 255);
                if (i5 == 0) {
                    i15++;
                    i14++;
                    if (i15 == i12) {
                        break;
                    } else if (bArr2[i13].length == i14) {
                        if (i13 == bArr2.length - 1) {
                            break;
                        }
                        i13++;
                        z = true;
                        i14 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i5 >= 0) {
                if (i5 <= 0) {
                    int i16 = i12 - i15;
                    int length2 = bArr2[i13].length - i14;
                    while (true) {
                        i6 = length2;
                        i13++;
                        if (i13 >= bArr2.length) {
                            break;
                        }
                        length2 = i6 + bArr2[i13].length;
                    }
                    if (i6 >= i16) {
                        if (i6 <= i16) {
                            return new String(bArr, i9, i12, Util.e);
                        }
                    }
                }
                i7 = i3 + 1;
            }
            length = i9 - 1;
        }
        return null;
    }

    private void a() {
        boolean z;
        boolean z2 = false;
        while (true) {
            try {
                try {
                    try {
                        z = z2;
                        b();
                        break;
                    } catch (InterruptedIOException e) {
                        Thread.interrupted();
                        z2 = true;
                    }
                } catch (IOException e2) {
                    Platform.get().log(5, "Failed to read public suffix list", e2);
                    if (z) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0122  */
    /* JADX WARN: Type inference failed for: r0v18, types: [byte[], byte[][], java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String[] a(java.lang.String[] r6) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.internal.publicsuffix.PublicSuffixDatabase.a(java.lang.String[]):java.lang.String[]");
    }

    private void b() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        BufferedSource buffer = Okio.buffer(new GzipSource(Okio.source(resourceAsStream)));
        try {
            byte[] bArr = new byte[buffer.readInt()];
            buffer.readFully(bArr);
            byte[] bArr2 = new byte[buffer.readInt()];
            buffer.readFully(bArr2);
            synchronized (this) {
                this.g = bArr;
                this.h = bArr2;
            }
            this.f.countDown();
        } finally {
            Util.closeQuietly(buffer);
        }
    }

    public static PublicSuffixDatabase get() {
        return d;
    }

    public String getEffectiveTldPlusOne(String str) {
        if (str != null) {
            String[] split = IDN.toUnicode(str).split("\\.");
            String[] a2 = a(split);
            if (split.length != a2.length || a2[0].charAt(0) == '!') {
                char charAt = a2[0].charAt(0);
                int length = split.length;
                int length2 = a2.length;
                if (charAt != '!') {
                    length2++;
                }
                StringBuilder sb = new StringBuilder();
                String[] split2 = str.split("\\.");
                for (int i = length - length2; i < split2.length; i++) {
                    sb.append(split2[i]);
                    sb.append('.');
                }
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }
            return null;
        }
        throw new NullPointerException("domain == null");
    }
}
