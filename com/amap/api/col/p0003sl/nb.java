package com.amap.api.col.p0003sl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.Arrays;

/* renamed from: com.amap.api.col.3sl.nb  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/nb.class */
public class nb {
    ByteBuffer a;
    int b;
    int d;
    int[] e;
    int f;
    boolean g;
    boolean h;
    int i;
    int[] j;
    int k;
    int l;
    boolean m;
    CharsetEncoder n;
    ByteBuffer o;
    static final /* synthetic */ boolean p = !nb.class.desiredAssertionStatus();
    static final Charset c = Charset.forName("UTF-8");

    private nb() {
        this.d = 1;
        this.e = null;
        this.f = 0;
        this.g = false;
        this.h = false;
        this.j = new int[16];
        this.k = 0;
        this.l = 0;
        this.m = false;
        this.n = c.newEncoder();
        this.b = 1024;
        this.a = d(1024);
    }

    public nb(ByteBuffer byteBuffer) {
        this.d = 1;
        this.e = null;
        this.f = 0;
        this.g = false;
        this.h = false;
        this.j = new int[16];
        this.k = 0;
        this.l = 0;
        this.m = false;
        this.n = c.newEncoder();
        a(byteBuffer);
    }

    private void a(long j) {
        ByteBuffer byteBuffer = this.a;
        int i = this.b - 8;
        this.b = i;
        byteBuffer.putLong(i, j);
    }

    private void a(short s) {
        ByteBuffer byteBuffer = this.a;
        int i = this.b - 2;
        this.b = i;
        byteBuffer.putShort(i, s);
    }

    private static ByteBuffer b(ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity();
        if (((-1073741824) & capacity) == 0) {
            int i = capacity << 1;
            byteBuffer.position(0);
            ByteBuffer d = d(i);
            d.position(i - capacity);
            d.put(byteBuffer);
            return d;
        }
        throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    }

    private void b(byte b) {
        ByteBuffer byteBuffer = this.a;
        int i = this.b - 1;
        this.b = i;
        byteBuffer.put(i, b);
    }

    private void b(long j) {
        c(8, 0);
        a(j);
    }

    private void b(short s) {
        c(2, 0);
        a(s);
    }

    private void b(boolean z) {
        ByteBuffer byteBuffer = this.a;
        int i = this.b - 1;
        this.b = i;
        byteBuffer.put(i, z ? (byte) 1 : (byte) 0);
    }

    private int c(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        a((byte) 0);
        a(1, remaining, 1);
        ByteBuffer byteBuffer2 = this.a;
        int i = this.b - remaining;
        this.b = i;
        byteBuffer2.position(i);
        this.a.put(byteBuffer);
        return a();
    }

    private void c(int i, int i2) {
        if (i > this.d) {
            this.d = i;
        }
        int capacity = ((this.a.capacity() - this.b) + i2 + 1) & (i - 1);
        while (this.b < capacity + i + i2) {
            int capacity2 = this.a.capacity();
            ByteBuffer b = b(this.a);
            this.a = b;
            this.b += b.capacity() - capacity2;
        }
        e(capacity);
    }

    private void c(boolean z) {
        c(1, 0);
        b(z);
    }

    private int d() {
        return this.a.capacity() - this.b;
    }

    private static ByteBuffer d(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(i);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        return allocate;
    }

    private byte[] d(int i, int i2) {
        e();
        byte[] bArr = new byte[i2];
        this.a.position(i);
        this.a.get(bArr);
        return bArr;
    }

    private void e() {
        if (!this.h) {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    private void e(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            ByteBuffer byteBuffer = this.a;
            int i4 = this.b - 1;
            this.b = i4;
            byteBuffer.put(i4, (byte) 0);
            i2 = i3 + 1;
        }
    }

    private void f() {
        if (this.g) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    private void f(int i) {
        ByteBuffer byteBuffer = this.a;
        int i2 = this.b - 4;
        this.b = i2;
        byteBuffer.putInt(i2, i);
    }

    private void g(int i) {
        c(4, 0);
        f(i);
    }

    private void h(int i) {
        this.e[i] = d();
    }

    public final int a() {
        if (this.g) {
            this.g = false;
            f(this.l);
            return d();
        }
        throw new AssertionError("FlatBuffers: endVector called without startVector");
    }

    public int a(CharSequence charSequence) {
        int length = (int) (charSequence.length() * this.n.maxBytesPerChar());
        ByteBuffer byteBuffer = this.o;
        if (byteBuffer == null || byteBuffer.capacity() < length) {
            this.o = ByteBuffer.allocate(Math.max(128, length));
        }
        this.o.clear();
        CoderResult encode = this.n.encode(charSequence instanceof CharBuffer ? (CharBuffer) charSequence : CharBuffer.wrap(charSequence), this.o, true);
        if (encode.isError()) {
            try {
                encode.throwException();
            } catch (CharacterCodingException e) {
                throw new Error(e);
            }
        }
        this.o.flip();
        return c(this.o);
    }

    public final nb a(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
        byteBuffer.clear();
        this.a.order(ByteOrder.LITTLE_ENDIAN);
        this.d = 1;
        this.b = this.a.capacity();
        this.f = 0;
        this.g = false;
        this.h = false;
        this.i = 0;
        this.k = 0;
        this.l = 0;
        return this;
    }

    public final void a(byte b) {
        c(1, 0);
        b(b);
    }

    public final void a(int i) {
        c(4, 0);
        if (!p && i > d()) {
            throw new AssertionError();
        }
        f((d() - i) + 4);
    }

    public final void a(int i, byte b) {
        if (this.m || b != 0) {
            a(b);
            h(i);
        }
    }

    public final void a(int i, int i2) {
        if (this.m || i2 != 0) {
            g(i2);
            h(i);
        }
    }

    public final void a(int i, int i2, int i3) {
        f();
        this.l = i2;
        int i4 = i * i2;
        c(4, i4);
        c(i3, i4);
        this.g = true;
    }

    public final void a(int i, long j) {
        if (this.m || j != 0) {
            b(j);
            h(i);
        }
    }

    public final void a(int i, short s) {
        if (this.m || s != 0) {
            b(s);
            h(i);
        }
    }

    public final void a(boolean z) {
        if (this.m || z) {
            c(z);
            h(0);
        }
    }

    public final int b() {
        int i;
        int i2;
        if (this.e == null || !this.g) {
            throw new AssertionError("FlatBuffers: endObject called without startObject");
        }
        g(0);
        int d = d();
        int i3 = this.f;
        while (true) {
            int i4 = i3 - 1;
            if (i4 < 0) {
                break;
            }
            int[] iArr = this.e;
            b((short) (iArr[i4] != 0 ? d - iArr[i4] : 0));
            i3 = i4;
        }
        b((short) (d - this.i));
        b((short) ((this.f + 2) * 2));
        int i5 = 0;
        loop1: while (true) {
            int i6 = i5;
            if (i6 >= this.k) {
                i = 0;
                break;
            }
            int capacity = this.a.capacity() - this.j[i6];
            int i7 = this.b;
            short s = this.a.getShort(capacity);
            if (s == this.a.getShort(i7)) {
                while (true) {
                    int i8 = i2;
                    if (i8 >= s) {
                        i = this.j[i6];
                        break loop1;
                    }
                    i2 = this.a.getShort(capacity + i8) == this.a.getShort(i7 + i8) ? i8 + 2 : 2;
                }
            }
            i5 = i6 + 1;
        }
        if (i != 0) {
            int capacity2 = this.a.capacity() - d;
            this.b = capacity2;
            this.a.putInt(capacity2, i - d);
        } else {
            int i9 = this.k;
            int[] iArr2 = this.j;
            if (i9 == iArr2.length) {
                this.j = Arrays.copyOf(iArr2, i9 * 2);
            }
            int[] iArr3 = this.j;
            int i10 = this.k;
            this.k = i10 + 1;
            iArr3[i10] = d();
            ByteBuffer byteBuffer = this.a;
            byteBuffer.putInt(byteBuffer.capacity() - d, d() - d);
        }
        this.g = false;
        return d;
    }

    public final void b(int i) {
        f();
        int[] iArr = this.e;
        if (iArr == null || iArr.length < i) {
            this.e = new int[i];
        }
        this.f = i;
        Arrays.fill(this.e, 0, i, 0);
        this.g = true;
        this.i = d();
    }

    public final void b(int i, int i2) {
        if (this.m || i2 != 0) {
            a(i2);
            h(i);
        }
    }

    public final void c(int i) {
        c(this.d, 4);
        a(i);
        this.a.position(this.b);
        this.h = true;
    }

    public final byte[] c() {
        return d(this.b, this.a.capacity() - this.b);
    }
}
