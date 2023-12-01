package com.heytap.nearx.a.a;

import android.os.BatteryStats;
import com.tencent.tinker.loader.shareutil.ShareElfFile;
import java.io.IOException;
import okio.BufferedSink;
import okio.ByteString;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/nearx/a/a/g.class */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final BufferedSink f22266a;

    public g(BufferedSink bufferedSink) {
        this.f22266a = bufferedSink;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i) {
        return c(b(i, a.VARINT));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if ((BatteryStats.STEP_LEVEL_MODIFIED_MODE_MASK & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(String str) {
        int i;
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt >= 128) {
                if (charAt < 2048) {
                    i3 += 2;
                } else if (charAt < 55296 || charAt > 57343) {
                    i3 += 3;
                } else if (charAt <= 56319 && (i = i2 + 1) < length && str.charAt(i) >= 56320 && str.charAt(i) <= 57343) {
                    i3 += 4;
                    i2 = i;
                }
                i2++;
            }
            i3++;
            i2++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i) {
        if (i >= 0) {
            return c(i);
        }
        return 10;
    }

    private static int b(int i, a aVar) {
        return (i << 3) | aVar.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b(long j) {
        return (j >> 63) ^ (j << 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & ShareElfFile.SectionHeader.SHF_MASKPROC) == 0 ? 4 : 5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long c(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i) {
        return (i >> 31) ^ (i << 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public void a(int i, a aVar) throws IOException {
        g(b(i, aVar));
    }

    public void a(ByteString byteString) throws IOException {
        this.f22266a.write(byteString);
    }

    public void b(String str) throws IOException {
        this.f22266a.writeUtf8(str);
    }

    public void d(long j) throws IOException {
        while (true) {
            BufferedSink bufferedSink = this.f22266a;
            if (((-128) & j) == 0) {
                bufferedSink.writeByte((int) j);
                return;
            } else {
                bufferedSink.writeByte((((int) j) & 127) | 128);
                j >>>= 7;
            }
        }
    }

    public void e(long j) throws IOException {
        this.f22266a.writeLongLe(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(int i) throws IOException {
        if (i >= 0) {
            g(i);
        } else {
            d(i);
        }
    }

    public void g(int i) throws IOException {
        while ((i & (-128)) != 0) {
            this.f22266a.writeByte((i & 127) | 128);
            i >>>= 7;
        }
        this.f22266a.writeByte(i);
    }

    public void h(int i) throws IOException {
        this.f22266a.writeIntLe(i);
    }
}
