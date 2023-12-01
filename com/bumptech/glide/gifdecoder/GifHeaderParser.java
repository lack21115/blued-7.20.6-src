package com.bumptech.glide.gifdecoder;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/gifdecoder/GifHeaderParser.class */
public class GifHeaderParser {
    private ByteBuffer b;

    /* renamed from: c  reason: collision with root package name */
    private GifHeader f7084c;

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f7083a = new byte[256];
    private int d = 0;

    private void a(int i) {
        boolean z = false;
        while (!z && !o() && this.f7084c.f7082c <= i) {
            int m = m();
            if (m == 33) {
                int m2 = m();
                if (m2 == 1) {
                    k();
                } else if (m2 == 249) {
                    this.f7084c.d = new GifFrame();
                    e();
                } else if (m2 == 254) {
                    k();
                } else if (m2 != 255) {
                    k();
                } else {
                    l();
                    StringBuilder sb = new StringBuilder();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= 11) {
                            break;
                        }
                        sb.append((char) this.f7083a[i3]);
                        i2 = i3 + 1;
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        g();
                    } else {
                        k();
                    }
                }
            } else if (m == 44) {
                if (this.f7084c.d == null) {
                    this.f7084c.d = new GifFrame();
                }
                f();
            } else if (m != 59) {
                this.f7084c.b = 1;
            } else {
                z = true;
            }
        }
    }

    private int[] b(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.b.get(bArr);
            int[] iArr2 = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (true) {
                iArr = iArr2;
                if (i2 >= i) {
                    break;
                }
                int i4 = i3 + 1;
                byte b = bArr[i3];
                int i5 = i4 + 1;
                iArr2[i2] = ((b & 255) << 16) | (-16777216) | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                i3 = i5 + 1;
                i2++;
            }
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
            }
            this.f7084c.b = 1;
        }
        return iArr;
    }

    private void c() {
        this.b = null;
        Arrays.fill(this.f7083a, (byte) 0);
        this.f7084c = new GifHeader();
        this.d = 0;
    }

    private void d() {
        a(Integer.MAX_VALUE);
    }

    private void e() {
        m();
        int m = m();
        this.f7084c.d.g = (m & 28) >> 2;
        boolean z = true;
        if (this.f7084c.d.g == 0) {
            this.f7084c.d.g = 1;
        }
        GifFrame gifFrame = this.f7084c.d;
        if ((m & 1) == 0) {
            z = false;
        }
        gifFrame.f = z;
        int n = n();
        int i = n;
        if (n < 2) {
            i = 10;
        }
        this.f7084c.d.i = i * 10;
        this.f7084c.d.h = m();
        m();
    }

    private void f() {
        this.f7084c.d.f7079a = n();
        this.f7084c.d.b = n();
        this.f7084c.d.f7080c = n();
        this.f7084c.d.d = n();
        int m = m();
        boolean z = false;
        boolean z2 = (m & 128) != 0;
        int pow = (int) Math.pow(2.0d, (m & 7) + 1);
        GifFrame gifFrame = this.f7084c.d;
        if ((m & 64) != 0) {
            z = true;
        }
        gifFrame.e = z;
        if (z2) {
            this.f7084c.d.k = b(pow);
        } else {
            this.f7084c.d.k = null;
        }
        this.f7084c.d.j = this.b.position();
        j();
        if (o()) {
            return;
        }
        this.f7084c.f7082c++;
        this.f7084c.e.add(this.f7084c.d);
    }

    private void g() {
        do {
            l();
            byte[] bArr = this.f7083a;
            if (bArr[0] == 1) {
                byte b = bArr[1];
                this.f7084c.m = ((bArr[2] & 255) << 8) | (b & 255);
            }
            if (this.d <= 0) {
                return;
            }
        } while (!o());
    }

    private void h() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 6) {
                break;
            }
            sb.append((char) m());
            i = i2 + 1;
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f7084c.b = 1;
            return;
        }
        i();
        if (!this.f7084c.h || o()) {
            return;
        }
        GifHeader gifHeader = this.f7084c;
        gifHeader.f7081a = b(gifHeader.i);
        GifHeader gifHeader2 = this.f7084c;
        gifHeader2.l = gifHeader2.f7081a[this.f7084c.j];
    }

    private void i() {
        this.f7084c.f = n();
        this.f7084c.g = n();
        int m = m();
        this.f7084c.h = (m & 128) != 0;
        this.f7084c.i = (int) Math.pow(2.0d, (m & 7) + 1);
        this.f7084c.j = m();
        this.f7084c.k = m();
    }

    private void j() {
        m();
        k();
    }

    private void k() {
        int m;
        do {
            m = m();
            this.b.position(Math.min(this.b.position() + m, this.b.limit()));
        } while (m > 0);
    }

    private void l() {
        int m = m();
        this.d = m;
        if (m <= 0) {
            return;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            try {
                if (i >= this.d) {
                    return;
                }
                int i4 = i2;
                i2 = this.d - i;
                this.b.get(this.f7083a, i, i2);
                i += i2;
            } catch (Exception e) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i3 + " blockSize: " + this.d, e);
                }
                this.f7084c.b = 1;
                return;
            }
        }
    }

    private int m() {
        try {
            return this.b.get() & 255;
        } catch (Exception e) {
            this.f7084c.b = 1;
            return 0;
        }
    }

    private int n() {
        return this.b.getShort();
    }

    private boolean o() {
        return this.f7084c.b != 0;
    }

    public GifHeaderParser a(ByteBuffer byteBuffer) {
        c();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public void a() {
        this.b = null;
        this.f7084c = null;
    }

    public GifHeader b() {
        if (this.b != null) {
            if (o()) {
                return this.f7084c;
            }
            h();
            if (!o()) {
                d();
                if (this.f7084c.f7082c < 0) {
                    this.f7084c.b = 1;
                }
            }
            return this.f7084c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }
}
