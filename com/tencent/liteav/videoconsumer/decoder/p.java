package com.tencent.liteav.videoconsumer.decoder;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/p.class */
public final class p {
    int b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f23107c;
    private int d;
    private int e;
    private final OutputStream f;
    private int h;

    /* renamed from: a  reason: collision with root package name */
    protected a f23106a = new a();
    private int[] g = new int[8];

    public p(InputStream inputStream, OutputStream outputStream) throws IOException {
        this.f23107c = inputStream;
        this.f = outputStream;
        this.d = inputStream.read();
        this.e = inputStream.read();
    }

    private void a(long j, int i) throws IOException {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            f(((int) (j >> ((i - i3) - 1))) & 1);
            i2 = i3 + 1;
        }
    }

    private int c(boolean z) throws IOException {
        if (this.b == 8) {
            f();
            if (this.d == -1) {
                return -1;
            }
        }
        int i = this.d;
        int i2 = this.b;
        int i3 = (i >> (7 - i2)) & 1;
        this.b = i2 + 1;
        if (z && this.f != null) {
            f(i3);
        }
        return i3;
    }

    private long e(int i) throws IOException {
        if (i > 64) {
            throw new IllegalArgumentException("Can not readByte more then 64 bit");
        }
        long j = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return j;
            }
            j = (j << 1) | c(true);
            i2 = i3 + 1;
        }
    }

    private void f() throws IOException {
        this.d = this.e;
        this.e = this.f23107c.read();
        this.b = 0;
    }

    private void f(int i) throws IOException {
        if (this.h == 8) {
            this.h = 0;
            h();
        }
        int[] iArr = this.g;
        int i2 = this.h;
        this.h = i2 + 1;
        iArr[i2] = i;
    }

    private int g() throws IOException {
        int i;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (c(true) != 0) {
                break;
            }
            i3 = i + 1;
        }
        if (i > 0) {
            i2 = (int) (((1 << i) - 1) + e(i));
        }
        return i2;
    }

    private void h() throws IOException {
        int[] iArr = this.g;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        this.f.write(iArr[7] | (i << 7) | (i2 << 6) | (i3 << 5) | (i4 << 4) | (i5 << 3) | (i6 << 2) | (i7 << 1));
    }

    public final long a() throws IOException {
        return e(8);
    }

    public final void a(int i) throws IOException {
        if (i > 64) {
            throw new IllegalArgumentException("Can not skip more then 64 bit");
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            c(true);
            i2 = i3 + 1;
        }
    }

    public final boolean a(boolean z) throws IOException {
        return c(z) == 1;
    }

    public final int b() throws IOException {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (c(false) != 0) {
                break;
            }
            i2 = i + 1;
        }
        if (i <= 0) {
            return 0;
        }
        if (i > 64) {
            throw new IllegalArgumentException("Can not readByte more then 64 bit");
        }
        long j = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                return (int) (((1 << i) - 1) + j);
            }
            j = (j << 1) | c(false);
            i3 = i4 + 1;
        }
    }

    public final void b(int i) throws IOException {
        a(i);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public final void b(boolean z) throws IOException {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final int c() throws IOException {
        return g();
    }

    public final void c(int i) throws IOException {
        int[] iArr = new int[i];
        int i2 = 8;
        int i3 = 8;
        int i4 = 0;
        while (i4 < i) {
            int i5 = i2;
            if (i2 != 0) {
                int g = g();
                int i6 = g & 1;
                i5 = (((((g >> 1) + i6) * ((i6 << 1) - 1)) + i3) + 256) % 256;
            }
            if (i5 != 0) {
                i3 = i5;
            }
            iArr[i4] = i3;
            i3 = iArr[i4];
            i4++;
            i2 = i5;
        }
    }

    public final void d() throws IOException {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (c(true) != 0) {
                break;
            }
            i2 = i + 1;
        }
        if (i > 0) {
            a(i);
        }
    }

    public final void d(int i) throws IOException {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i2 = i5;
            i3 = 0;
            if (i4 >= 15) {
                break;
            }
            int i6 = (1 << i4) + i2;
            if (i < i6) {
                i3 = i4;
                break;
            } else {
                i4++;
                i5 = i6;
            }
        }
        a(0L, i3);
        f(1);
        a(i - i2, i3);
    }

    public final void e() throws IOException {
        f(1);
        a(0L, 8 - this.h);
        int i = this.h;
        while (true) {
            int i2 = i;
            if (i2 >= 8) {
                this.h = 0;
                h();
                return;
            }
            this.g[i2] = 0;
            i = i2 + 1;
        }
    }
}
