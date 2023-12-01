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
    private GifHeader f20690c;

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f20689a = new byte[256];
    private int d = 0;

    private void a(int i) {
        boolean z = false;
        while (!z && !o() && this.f20690c.f20688c <= i) {
            int m = m();
            if (m == 33) {
                int m2 = m();
                if (m2 == 1) {
                    k();
                } else if (m2 == 249) {
                    this.f20690c.d = new GifFrame();
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
                        sb.append((char) this.f20689a[i3]);
                        i2 = i3 + 1;
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        g();
                    } else {
                        k();
                    }
                }
            } else if (m == 44) {
                if (this.f20690c.d == null) {
                    this.f20690c.d = new GifFrame();
                }
                f();
            } else if (m != 59) {
                this.f20690c.b = 1;
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
            this.f20690c.b = 1;
        }
        return iArr;
    }

    private void c() {
        this.b = null;
        Arrays.fill(this.f20689a, (byte) 0);
        this.f20690c = new GifHeader();
        this.d = 0;
    }

    private void d() {
        a(Integer.MAX_VALUE);
    }

    private void e() {
        m();
        int m = m();
        this.f20690c.d.g = (m & 28) >> 2;
        boolean z = true;
        if (this.f20690c.d.g == 0) {
            this.f20690c.d.g = 1;
        }
        GifFrame gifFrame = this.f20690c.d;
        if ((m & 1) == 0) {
            z = false;
        }
        gifFrame.f = z;
        int n = n();
        int i = n;
        if (n < 2) {
            i = 10;
        }
        this.f20690c.d.i = i * 10;
        this.f20690c.d.h = m();
        m();
    }

    private void f() {
        this.f20690c.d.f20685a = n();
        this.f20690c.d.b = n();
        this.f20690c.d.f20686c = n();
        this.f20690c.d.d = n();
        int m = m();
        boolean z = false;
        boolean z2 = (m & 128) != 0;
        int pow = (int) Math.pow(2.0d, (m & 7) + 1);
        GifFrame gifFrame = this.f20690c.d;
        if ((m & 64) != 0) {
            z = true;
        }
        gifFrame.e = z;
        if (z2) {
            this.f20690c.d.k = b(pow);
        } else {
            this.f20690c.d.k = null;
        }
        this.f20690c.d.j = this.b.position();
        j();
        if (o()) {
            return;
        }
        this.f20690c.f20688c++;
        this.f20690c.e.add(this.f20690c.d);
    }

    private void g() {
        do {
            l();
            byte[] bArr = this.f20689a;
            if (bArr[0] == 1) {
                byte b = bArr[1];
                this.f20690c.m = ((bArr[2] & 255) << 8) | (b & 255);
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
            this.f20690c.b = 1;
            return;
        }
        i();
        if (!this.f20690c.h || o()) {
            return;
        }
        GifHeader gifHeader = this.f20690c;
        gifHeader.f20687a = b(gifHeader.i);
        GifHeader gifHeader2 = this.f20690c;
        gifHeader2.l = gifHeader2.f20687a[this.f20690c.j];
    }

    private void i() {
        this.f20690c.f = n();
        this.f20690c.g = n();
        int m = m();
        this.f20690c.h = (m & 128) != 0;
        this.f20690c.i = (int) Math.pow(2.0d, (m & 7) + 1);
        this.f20690c.j = m();
        this.f20690c.k = m();
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
                this.b.get(this.f20689a, i, i2);
                i += i2;
            } catch (Exception e) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i3 + " blockSize: " + this.d, e);
                }
                this.f20690c.b = 1;
                return;
            }
        }
    }

    private int m() {
        try {
            return this.b.get() & 255;
        } catch (Exception e) {
            this.f20690c.b = 1;
            return 0;
        }
    }

    private int n() {
        return this.b.getShort();
    }

    private boolean o() {
        return this.f20690c.b != 0;
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
        this.f20690c = null;
    }

    public GifHeader b() {
        if (this.b != null) {
            if (o()) {
                return this.f20690c;
            }
            h();
            if (!o()) {
                d();
                if (this.f20690c.f20688c < 0) {
                    this.f20690c.b = 1;
                }
            }
            return this.f20690c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }
}
