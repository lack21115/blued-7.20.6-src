package com.qiniu.pili.droid.shortvideo.b;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/b/a.class */
public class a {
    private static final String C = a.class.getSimpleName();
    protected int A;
    protected int B;

    /* renamed from: a  reason: collision with root package name */
    protected int f27524a;
    protected int b;

    /* renamed from: c  reason: collision with root package name */
    protected int f27525c;
    protected boolean d;
    protected int e;
    protected int[] g;
    protected int[] h;
    protected int i;
    protected int j;
    protected int k;
    protected boolean l;
    protected int m;
    protected ByteBuffer n;
    protected short[] q;
    protected byte[] r;
    protected byte[] s;
    protected byte[] t;
    protected int[] u;
    protected int[] v;
    protected ArrayList<C0742a> w;
    protected C0742a x;
    protected Bitmap y;
    protected Bitmap z;
    protected int f = 1;
    protected byte[] o = new byte[256];
    protected int p = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qiniu.pili.droid.shortvideo.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/b/a$a.class */
    public static class C0742a {

        /* renamed from: a  reason: collision with root package name */
        public int f27526a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public int f27527c;
        public int d;
        public boolean e;
        public boolean f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int[] k;

        private C0742a() {
        }
    }

    public int a(int i) {
        if (i < 0 || i >= this.B) {
            return -1;
        }
        return this.w.get(i).i;
    }

    public int a(InputStream inputStream, int i) {
        System.currentTimeMillis();
        if (inputStream != null) {
            int i2 = 4096;
            if (i > 0) {
                i2 = 4096 + i;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                a(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                Log.w(C, "Error reading data from stream", e);
            }
        } else {
            this.f27524a = 2;
        }
        try {
            inputStream.close();
        } catch (Exception e2) {
            Log.w(C, "Error closing stream", e2);
        }
        return this.f27524a;
    }

    public int a(byte[] bArr) {
        g();
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.n = wrap;
            wrap.rewind();
            this.n.order(ByteOrder.LITTLE_ENDIAN);
            k();
            if (!f()) {
                j();
                if (this.B < 0) {
                    this.f27524a = 1;
                }
            }
        } else {
            this.f27524a = 2;
        }
        return this.f27524a;
    }

    public void a() {
        this.A = (this.A + 1) % this.B;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
        if (r7.length < r23) goto L91;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void a(com.qiniu.pili.droid.shortvideo.b.a.C0742a r6, byte[] r7) {
        /*
            Method dump skipped, instructions count: 727
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.pili.droid.shortvideo.b.a.a(com.qiniu.pili.droid.shortvideo.b.a$a, byte[]):void");
    }

    public int b() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = this.B;
            if (i >= i3) {
                return i2 / i3;
            }
            i2 += this.w.get(i).i;
            i++;
        }
    }

    protected void b(int i) {
        int i2;
        int i3;
        int i4;
        Bitmap bitmap;
        Bitmap bitmap2;
        C0742a c0742a = this.w.get(i);
        int i5 = i - 1;
        C0742a c0742a2 = i5 >= 0 ? this.w.get(i5) : null;
        int[] iArr = this.u;
        int i6 = 0;
        if (c0742a2 != null && c0742a2.g > 0) {
            if (c0742a2.g == 1 && (bitmap2 = this.z) != null) {
                int i7 = this.b;
                bitmap2.getPixels(iArr, 0, i7, 0, 0, i7, this.f27525c);
            }
            if (c0742a2.g == 2) {
                int i8 = !c0742a.f ? this.j : 0;
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 >= c0742a2.d) {
                        break;
                    }
                    int i11 = ((c0742a2.b + i10) * this.b) + c0742a2.f27526a;
                    int i12 = c0742a2.f27527c;
                    int i13 = i11;
                    while (true) {
                        int i14 = i13;
                        if (i14 < i12 + i11) {
                            iArr[i14] = i8;
                            i13 = i14 + 1;
                        }
                    }
                    i9 = i10 + 1;
                }
            }
            if (c0742a2.g == 3 && (bitmap = this.y) != null) {
                int i15 = this.b;
                bitmap.getPixels(iArr, 0, i15, 0, 0, i15, this.f27525c);
            }
        }
        a(c0742a, this.t);
        int i16 = 8;
        int i17 = 0;
        int i18 = 1;
        while (i6 < c0742a.d) {
            if (c0742a.e) {
                i4 = i16;
                int i19 = i17;
                int i20 = i18;
                if (i17 >= c0742a.d) {
                    i20 = i18 + 1;
                    if (i20 == 2) {
                        i19 = 4;
                        i4 = i16;
                    } else if (i20 == 3) {
                        i4 = 4;
                        i19 = 2;
                    } else if (i20 != 4) {
                        i4 = i16;
                        i19 = i17;
                    } else {
                        i4 = 2;
                        i19 = 1;
                    }
                }
                i3 = i19;
                i18 = i20;
                i2 = i19 + i4;
            } else {
                i2 = i17;
                i3 = i6;
                i4 = i16;
            }
            int i21 = i3 + c0742a.b;
            if (i21 < this.f27525c) {
                int i22 = i21 * this.b;
                int i23 = c0742a.f27526a + i22;
                int i24 = c0742a.f27527c + i23;
                int i25 = this.b;
                int i26 = i24;
                if (i22 + i25 < i24) {
                    i26 = i22 + i25;
                }
                int i27 = c0742a.f27527c * i6;
                while (true) {
                    int i28 = i27;
                    if (i23 < i26) {
                        int i29 = this.h[this.t[i28] & 255];
                        if (i29 != 0) {
                            iArr[i23] = i29;
                        }
                        i23++;
                        i27 = i28 + 1;
                    }
                }
            }
            i6++;
            i16 = i4;
            i17 = i2;
        }
        Bitmap bitmap3 = this.z;
        int[] iArr2 = this.v;
        int i30 = this.b;
        bitmap3.getPixels(iArr2, 0, i30, 0, 0, i30, this.f27525c);
        Bitmap bitmap4 = this.y;
        int[] iArr3 = this.v;
        int i31 = this.b;
        bitmap4.setPixels(iArr3, 0, i31, 0, 0, i31, this.f27525c);
        Bitmap bitmap5 = this.z;
        int i32 = this.b;
        bitmap5.setPixels(iArr, 0, i32, 0, 0, i32, this.f27525c);
    }

    public int c() {
        return this.B;
    }

    protected int[] c(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.n.get(bArr);
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
            Log.w(C, "Format Error Reading Color Table", e);
            this.f27524a = 1;
        }
        return iArr;
    }

    public int d() {
        return this.A;
    }

    public Bitmap e() {
        int i;
        if (this.B <= 0 || (i = this.A) < 0 || this.z == null) {
            return null;
        }
        C0742a c0742a = this.w.get(i);
        int i2 = 0;
        if (c0742a.k == null) {
            this.h = this.g;
        } else {
            this.h = c0742a.k;
            if (this.i == c0742a.h) {
                this.j = 0;
            }
        }
        if (c0742a.f) {
            i2 = this.h[c0742a.h];
            this.h[c0742a.h] = 0;
        }
        if (this.h == null) {
            Log.w(C, "No Valid Color Table");
            this.f27524a = 1;
            return null;
        }
        b(this.A);
        if (c0742a.f) {
            this.h[c0742a.h] = i2;
        }
        return this.z;
    }

    protected boolean f() {
        return this.f27524a != 0;
    }

    protected void g() {
        this.f27524a = 0;
        this.B = 0;
        this.A = -1;
        this.w = new ArrayList<>();
        this.g = null;
    }

    protected int h() {
        try {
            return this.n.get() & 255;
        } catch (Exception e) {
            this.f27524a = 1;
            return 0;
        }
    }

    protected int i() {
        int h = h();
        this.p = h;
        int i = 0;
        int i2 = 0;
        if (h > 0) {
            while (true) {
                i = i2;
                try {
                    if (i2 >= this.p) {
                        break;
                    }
                    int i3 = this.p - i2;
                    this.n.get(this.o, i2, i3);
                    i2 += i3;
                } catch (Exception e) {
                    Log.w(C, "Error Reading Block", e);
                    this.f27524a = 1;
                    i = i2;
                }
            }
        }
        return i;
    }

    protected void j() {
        boolean z = false;
        while (!z && !f()) {
            int h = h();
            if (h == 33) {
                int h2 = h();
                if (h2 == 1) {
                    q();
                } else if (h2 == 249) {
                    this.x = new C0742a();
                    l();
                } else if (h2 == 254) {
                    q();
                } else if (h2 != 255) {
                    q();
                } else {
                    i();
                    String str = "";
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= 11) {
                            break;
                        }
                        str = str + ((char) this.o[i2]);
                        i = i2 + 1;
                    }
                    if (str.equals("NETSCAPE2.0")) {
                        o();
                    } else {
                        q();
                    }
                }
            } else if (h == 44) {
                m();
            } else if (h != 59) {
                this.f27524a = 1;
            } else {
                z = true;
            }
        }
    }

    protected void k() {
        String str = "";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 6) {
                break;
            }
            str = str + ((char) h());
            i = i2 + 1;
        }
        if (!str.startsWith("GIF")) {
            this.f27524a = 1;
            return;
        }
        n();
        if (!this.d || f()) {
            return;
        }
        int[] c2 = c(this.e);
        this.g = c2;
        this.j = c2[this.i];
    }

    protected void l() {
        h();
        int h = h();
        this.x.g = (h & 28) >> 2;
        boolean z = true;
        if (this.x.g == 0) {
            this.x.g = 1;
        }
        C0742a c0742a = this.x;
        if ((h & 1) == 0) {
            z = false;
        }
        c0742a.f = z;
        this.x.i = p() * 10;
        this.x.h = h();
        h();
    }

    protected void m() {
        this.x.f27526a = p();
        this.x.b = p();
        this.x.f27527c = p();
        this.x.d = p();
        int h = h();
        this.l = (h & 128) != 0;
        this.m = (int) Math.pow(2.0d, (h & 7) + 1);
        C0742a c0742a = this.x;
        boolean z = false;
        if ((h & 64) != 0) {
            z = true;
        }
        c0742a.e = z;
        if (this.l) {
            this.x.k = c(this.m);
        } else {
            this.x.k = null;
        }
        this.x.j = this.n.position();
        a((C0742a) null, this.t);
        q();
        if (f()) {
            return;
        }
        this.B++;
        this.w.add(this.x);
    }

    protected void n() {
        this.b = p();
        this.f27525c = p();
        int h = h();
        this.d = (h & 128) != 0;
        this.e = 2 << (h & 7);
        this.i = h();
        this.k = h();
        int i = this.b;
        int i2 = this.f27525c;
        this.t = new byte[i * i2];
        this.u = new int[i * i2];
        this.v = new int[i * i2];
        this.y = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        this.z = Bitmap.createBitmap(this.b, this.f27525c, Bitmap.Config.ARGB_8888);
    }

    protected void o() {
        do {
            i();
            byte[] bArr = this.o;
            if (bArr[0] == 1) {
                this.f = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.p <= 0) {
                return;
            }
        } while (!f());
    }

    protected int p() {
        return this.n.getShort();
    }

    protected void q() {
        do {
            i();
            if (this.p <= 0) {
                return;
            }
        } while (!f());
    }
}
