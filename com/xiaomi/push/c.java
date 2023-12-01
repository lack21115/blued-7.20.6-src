package com.xiaomi.push;

import android.os.BatteryStats;
import com.tencent.tinker.loader.shareutil.ShareElfFile;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final int f41297a;

    /* renamed from: a  reason: collision with other field name */
    private final OutputStream f236a;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f237a;
    private int b;

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/c$a.class */
    public static class a extends IOException {
        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private c(OutputStream outputStream, byte[] bArr) {
        this.f236a = outputStream;
        this.f237a = bArr;
        this.b = 0;
        this.f41297a = bArr.length;
    }

    private c(byte[] bArr, int i, int i2) {
        this.f236a = null;
        this.f237a = bArr;
        this.b = i;
        this.f41297a = i + i2;
    }

    public static int a(int i) {
        if (i >= 0) {
            return d(i);
        }
        return 10;
    }

    public static int a(int i, int i2) {
        return c(i) + a(i2);
    }

    public static int a(int i, long j) {
        return c(i) + a(j);
    }

    public static int a(int i, com.xiaomi.push.a aVar) {
        return c(i) + a(aVar);
    }

    public static int a(int i, e eVar) {
        return c(i) + a(eVar);
    }

    public static int a(int i, String str) {
        return c(i) + a(str);
    }

    public static int a(int i, boolean z) {
        return c(i) + a(z);
    }

    public static int a(long j) {
        return c(j);
    }

    public static int a(com.xiaomi.push.a aVar) {
        return d(aVar.a()) + aVar.a();
    }

    public static int a(e eVar) {
        int b = eVar.b();
        return d(b) + b;
    }

    public static int a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return d(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int a(boolean z) {
        return 1;
    }

    public static c a(OutputStream outputStream) {
        return a(outputStream, 4096);
    }

    public static c a(OutputStream outputStream, int i) {
        return new c(outputStream, new byte[i]);
    }

    public static c a(byte[] bArr, int i, int i2) {
        return new c(bArr, i, i2);
    }

    public static int b(int i) {
        return d(i);
    }

    public static int b(int i, int i2) {
        return c(i) + b(i2);
    }

    public static int b(int i, long j) {
        return c(i) + b(j);
    }

    public static int b(long j) {
        return c(j);
    }

    public static int c(int i) {
        return d(f.a(i, 0));
    }

    public static int c(long j) {
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

    private void c() {
        OutputStream outputStream = this.f236a;
        if (outputStream == null) {
            throw new a();
        }
        outputStream.write(this.f237a, 0, this.b);
        this.b = 0;
    }

    public static int d(int i) {
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

    public final int a() {
        if (this.f236a == null) {
            return this.f41297a - this.b;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    /* renamed from: a  reason: collision with other method in class */
    public final void m11560a() {
        if (this.f236a != null) {
            c();
        }
    }

    public final void a(byte b) {
        if (this.b == this.f41297a) {
            c();
        }
        byte[] bArr = this.f237a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final void m11561a(int i) {
        if (i >= 0) {
            m11580d(i);
        } else {
            m11579c(i);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public final void m11562a(int i, int i2) {
        c(i, 0);
        m11561a(i2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public final void m11563a(int i, long j) {
        c(i, 0);
        m11568a(j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public final void m11564a(int i, com.xiaomi.push.a aVar) {
        c(i, 2);
        m11569a(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public final void m11565a(int i, e eVar) {
        c(i, 2);
        m11570a(eVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public final void m11566a(int i, String str) {
        c(i, 2);
        m11571a(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public final void m11567a(int i, boolean z) {
        c(i, 0);
        m11572a(z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public final void m11568a(long j) {
        m11579c(j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public final void m11569a(com.xiaomi.push.a aVar) {
        byte[] m11493a = aVar.m11493a();
        m11580d(m11493a.length);
        a(m11493a);
    }

    /* renamed from: a  reason: collision with other method in class */
    public final void m11570a(e eVar) {
        m11580d(eVar.a());
        eVar.a(this);
    }

    /* renamed from: a  reason: collision with other method in class */
    public final void m11571a(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        m11580d(bytes.length);
        a(bytes);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    /* renamed from: a  reason: collision with other method in class */
    public final void m11572a(boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final void a(byte[] bArr) {
        m11573a(bArr, 0, bArr.length);
    }

    /* renamed from: a  reason: collision with other method in class */
    public final void m11573a(byte[] bArr, int i, int i2) {
        int i3 = this.f41297a;
        int i4 = this.b;
        if (i3 - i4 >= i2) {
            System.arraycopy((Object) bArr, i, (Object) this.f237a, i4, i2);
            this.b += i2;
            return;
        }
        int i5 = i3 - i4;
        System.arraycopy((Object) bArr, i, (Object) this.f237a, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.b = this.f41297a;
        c();
        if (i7 > this.f41297a) {
            this.f236a.write(bArr, i6, i7);
            return;
        }
        System.arraycopy((Object) bArr, i6, (Object) this.f237a, 0, i7);
        this.b = i7;
    }

    public final void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public final void m11574b(int i) {
        m11580d(i);
    }

    /* renamed from: b  reason: collision with other method in class */
    public final void m11575b(int i, int i2) {
        c(i, 0);
        m11574b(i2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public final void m11576b(int i, long j) {
        c(i, 0);
        m11577b(j);
    }

    /* renamed from: b  reason: collision with other method in class */
    public final void m11577b(long j) {
        m11579c(j);
    }

    /* renamed from: c  reason: collision with other method in class */
    public final void m11578c(int i) {
        a((byte) i);
    }

    public final void c(int i, int i2) {
        m11580d(f.a(i, i2));
    }

    /* renamed from: c  reason: collision with other method in class */
    public final void m11579c(long j) {
        while (((-128) & j) != 0) {
            m11578c((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m11578c((int) j);
    }

    /* renamed from: d  reason: collision with other method in class */
    public final void m11580d(int i) {
        while ((i & (-128)) != 0) {
            m11578c((i & 127) | 128);
            i >>>= 7;
        }
        m11578c(i);
    }
}
