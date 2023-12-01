package com.qiniu.pili.droid.shortvideo.encode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.provider.Downloads;
import android.view.View;
import com.blued.das.live.LiveProtos;
import dalvik.bytecode.Opcodes;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/encode/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f27651a;
    private int b;
    private int f;
    private OutputStream j;
    private Bitmap k;
    private byte[] l;
    private byte[] m;
    private int n;
    private byte[] o;

    /* renamed from: c  reason: collision with root package name */
    private int f27652c = 0;
    private int d = 0;
    private int e = -1;
    private int g = -1;
    private int h = 0;
    private boolean i = false;
    private boolean[] p = new boolean[256];
    private int q = 7;
    private int r = -1;
    private boolean s = false;
    private boolean t = true;
    private boolean u = false;
    private int v = 10;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/encode/b$a.class */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        int f27653a;

        /* renamed from: c  reason: collision with root package name */
        int f27654c;
        int j;
        int k;
        int l;
        int p;
        private int s;
        private int t;
        private byte[] u;
        private int v;
        private int w;
        private int x;
        int b = 12;
        int d = 4096;
        int[] e = new int[5003];
        int[] f = new int[5003];
        int g = 5003;
        int h = 0;
        boolean i = false;
        int m = 0;
        int n = 0;
        int[] o = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, Opcodes.OP_SPUT_BYTE_JUMBO, View.PUBLIC_STATUS_BAR_VISIBILITY_MASK, Short.MAX_VALUE, 65535};
        byte[] q = new byte[256];

        a(int i, int i2, byte[] bArr, int i3) {
            this.s = i;
            this.t = i2;
            this.u = bArr;
            this.v = Math.max(2, i3);
        }

        private int a() {
            int i = this.w;
            if (i == 0) {
                return -1;
            }
            this.w = i - 1;
            byte[] bArr = this.u;
            int i2 = this.x;
            this.x = i2 + 1;
            return bArr[i2] & 255;
        }

        void a(byte b, OutputStream outputStream) throws IOException {
            byte[] bArr = this.q;
            int i = this.p;
            int i2 = i + 1;
            this.p = i2;
            bArr[i] = b;
            if (i2 >= 254) {
                c(outputStream);
            }
        }

        void a(int i) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return;
                }
                this.e[i3] = -1;
                i2 = i3 + 1;
            }
        }

        void a(int i, OutputStream outputStream) throws IOException {
            int i2;
            int[] iArr;
            this.j = i;
            int i3 = 0;
            this.i = false;
            this.f27653a = i;
            this.f27654c = b(i);
            int i4 = 1 << (i - 1);
            this.k = i4;
            this.l = i4 + 1;
            this.h = i4 + 2;
            this.p = 0;
            int a2 = a();
            int i5 = this.g;
            while (true) {
                int i6 = i5;
                if (i6 >= 65536) {
                    break;
                }
                i3++;
                i5 = i6 * 2;
            }
            int i7 = this.g;
            a(i7);
            b(this.k, outputStream);
            int i8 = a2;
            while (true) {
                int i9 = i8;
                int a3 = a();
                if (a3 == -1) {
                    b(i9, outputStream);
                    b(this.l, outputStream);
                    return;
                }
                int i10 = (a3 << this.b) + i9;
                int i11 = (a3 << (8 - i3)) ^ i9;
                int[] iArr2 = this.e;
                if (iArr2[i11] == i10) {
                    i8 = this.f[i11];
                } else {
                    int i12 = i11;
                    if (iArr2[i11] >= 0) {
                        int i13 = i7 - i11;
                        int i14 = i11;
                        if (i11 == 0) {
                            i13 = 1;
                            i14 = i11;
                        }
                        do {
                            int i15 = i14 - i13;
                            i2 = i15;
                            if (i15 < 0) {
                                i2 = i15 + i7;
                            }
                            iArr = this.e;
                            if (iArr[i2] == i10) {
                                i8 = this.f[i2];
                                break;
                            }
                            i14 = i2;
                        } while (iArr[i2] >= 0);
                        i12 = i2;
                    }
                    b(i9, outputStream);
                    int i16 = this.h;
                    if (i16 < this.d) {
                        int[] iArr3 = this.f;
                        this.h = i16 + 1;
                        iArr3[i12] = i16;
                        this.e[i12] = i10;
                    } else {
                        a(outputStream);
                    }
                    i8 = a3;
                }
            }
        }

        void a(OutputStream outputStream) throws IOException {
            a(this.g);
            int i = this.k;
            this.h = i + 2;
            this.i = true;
            b(i, outputStream);
        }

        final int b(int i) {
            return (1 << i) - 1;
        }

        void b(int i, OutputStream outputStream) throws IOException {
            int i2 = this.m;
            int[] iArr = this.o;
            int i3 = this.n;
            int i4 = i2 & iArr[i3];
            this.m = i4;
            if (i3 > 0) {
                this.m = i4 | (i << i3);
            } else {
                this.m = i;
            }
            this.n += this.f27653a;
            while (this.n >= 8) {
                a((byte) (this.m & 255), outputStream);
                this.m >>= 8;
                this.n -= 8;
            }
            if (this.h > this.f27654c || this.i) {
                if (this.i) {
                    int i5 = this.j;
                    this.f27653a = i5;
                    this.f27654c = b(i5);
                    this.i = false;
                } else {
                    int i6 = this.f27653a + 1;
                    this.f27653a = i6;
                    if (i6 == this.b) {
                        this.f27654c = this.d;
                    } else {
                        this.f27654c = b(i6);
                    }
                }
            }
            if (i == this.l) {
                while (this.n > 0) {
                    a((byte) (this.m & 255), outputStream);
                    this.m >>= 8;
                    this.n -= 8;
                }
                c(outputStream);
            }
        }

        void b(OutputStream outputStream) throws IOException {
            outputStream.write(this.v);
            this.w = this.s * this.t;
            this.x = 0;
            a(this.v + 1, outputStream);
            outputStream.write(0);
        }

        void c(OutputStream outputStream) throws IOException {
            int i = this.p;
            if (i > 0) {
                outputStream.write(i);
                outputStream.write(this.q, 0, this.p);
                this.p = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qiniu.pili.droid.shortvideo.encode.b$b  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/encode/b$b.class */
    public class C0746b {
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private byte[] f27656c;
        private int d;
        private int e;
        private int[] g = new int[256];
        private int[] h = new int[256];
        private int[] i = new int[256];
        private int[] j = new int[32];
        private int[][] f = new int[256];

        /* JADX WARN: Type inference failed for: r1v13, types: [int[], int[][]] */
        public C0746b(byte[] bArr, int i, int i2) {
            this.f27656c = bArr;
            this.d = i;
            this.e = i2;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= 256) {
                    return;
                }
                int[][] iArr = this.f;
                iArr[i4] = new int[4];
                int[] iArr2 = iArr[i4];
                int i5 = (i4 << 12) / 256;
                iArr2[2] = i5;
                iArr2[1] = i5;
                iArr2[0] = i5;
                this.i[i4] = 256;
                this.h[i4] = 0;
                i3 = i4 + 1;
            }
        }

        private void a(int i, int i2, int i3, int i4, int i5) {
            int i6 = i2 - i;
            int i7 = i6;
            if (i6 < -1) {
                i7 = -1;
            }
            int i8 = i2 + i;
            int i9 = i8;
            if (i8 > 256) {
                i9 = 256;
            }
            int i10 = i2 + 1;
            int i11 = i2 - 1;
            int i12 = 1;
            while (true) {
                int i13 = i12;
                if (i10 >= i9 && i11 <= i7) {
                    return;
                }
                int i14 = i13 + 1;
                int i15 = this.j[i13];
                int i16 = i10;
                if (i10 < i9) {
                    int[] iArr = this.f[i10];
                    try {
                        iArr[0] = iArr[0] - (((iArr[0] - i3) * i15) / 262144);
                        iArr[1] = iArr[1] - (((iArr[1] - i4) * i15) / 262144);
                        iArr[2] = iArr[2] - (((iArr[2] - i5) * i15) / 262144);
                    } catch (Exception e) {
                    }
                    i16 = i10 + 1;
                }
                if (i11 > i7) {
                    int[] iArr2 = this.f[i11];
                    try {
                        iArr2[0] = iArr2[0] - (((iArr2[0] - i3) * i15) / 262144);
                        iArr2[1] = iArr2[1] - (((iArr2[1] - i4) * i15) / 262144);
                        iArr2[2] = iArr2[2] - ((i15 * (iArr2[2] - i5)) / 262144);
                    } catch (Exception e2) {
                    }
                    i11--;
                    i10 = i16;
                    i12 = i14;
                } else {
                    i10 = i16;
                    i12 = i14;
                }
            }
        }

        private int b(int i, int i2, int i3) {
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = -1;
            int i7 = -1;
            int i8 = 0;
            while (i8 < 256) {
                int[] iArr = this.f[i8];
                int i9 = iArr[0] - i;
                int i10 = i9;
                if (i9 < 0) {
                    i10 = -i9;
                }
                int i11 = iArr[1] - i2;
                int i12 = i11;
                if (i11 < 0) {
                    i12 = -i11;
                }
                int i13 = iArr[2] - i3;
                int i14 = i13;
                if (i13 < 0) {
                    i14 = -i13;
                }
                int i15 = i10 + i12 + i14;
                int i16 = i4;
                if (i15 < i4) {
                    i6 = i8;
                    i16 = i15;
                }
                int i17 = i15 - (this.h[i8] >> 12);
                int i18 = i5;
                if (i17 < i5) {
                    i7 = i8;
                    i18 = i17;
                }
                int[] iArr2 = this.i;
                int i19 = iArr2[i8] >> 10;
                iArr2[i8] = iArr2[i8] - i19;
                int[] iArr3 = this.h;
                iArr3[i8] = iArr3[i8] + (i19 << 10);
                i8++;
                i4 = i16;
                i5 = i18;
            }
            int[] iArr4 = this.i;
            iArr4[i6] = iArr4[i6] + 64;
            int[] iArr5 = this.h;
            iArr5[i6] = iArr5[i6] - 65536;
            return i7;
        }

        private void b(int i, int i2, int i3, int i4, int i5) {
            int[] iArr = this.f[i2];
            iArr[0] = iArr[0] - (((iArr[0] - i3) * i) / 1024);
            iArr[1] = iArr[1] - (((iArr[1] - i4) * i) / 1024);
            iArr[2] = iArr[2] - ((i * (iArr[2] - i5)) / 1024);
        }

        public int a(int i, int i2, int i3) {
            int i4 = this.g[i2];
            int i5 = i4 - 1;
            int i6 = 1000;
            int i7 = -1;
            while (true) {
                if (i4 >= 256 && i5 < 0) {
                    return i7;
                }
                int i8 = i4;
                int i9 = i6;
                int i10 = i7;
                if (i4 < 256) {
                    int[] iArr = this.f[i4];
                    int i11 = iArr[1] - i2;
                    if (i11 >= i6) {
                        i8 = 256;
                        i9 = i6;
                        i10 = i7;
                    } else {
                        int i12 = i4 + 1;
                        int i13 = i11;
                        if (i11 < 0) {
                            i13 = -i11;
                        }
                        int i14 = iArr[0] - i;
                        int i15 = i14;
                        if (i14 < 0) {
                            i15 = -i14;
                        }
                        int i16 = i13 + i15;
                        i8 = i12;
                        i9 = i6;
                        i10 = i7;
                        if (i16 < i6) {
                            int i17 = iArr[2] - i3;
                            int i18 = i17;
                            if (i17 < 0) {
                                i18 = -i17;
                            }
                            int i19 = i16 + i18;
                            i8 = i12;
                            i9 = i6;
                            i10 = i7;
                            if (i19 < i6) {
                                i10 = iArr[3];
                                i9 = i19;
                                i8 = i12;
                            }
                        }
                    }
                }
                i4 = i8;
                i6 = i9;
                i7 = i10;
                if (i5 >= 0) {
                    int[] iArr2 = this.f[i5];
                    int i20 = i2 - iArr2[1];
                    if (i20 >= i9) {
                        i5 = -1;
                        i4 = i8;
                        i6 = i9;
                        i7 = i10;
                    } else {
                        int i21 = i5 - 1;
                        int i22 = i20;
                        if (i20 < 0) {
                            i22 = -i20;
                        }
                        int i23 = iArr2[0] - i;
                        int i24 = i23;
                        if (i23 < 0) {
                            i24 = -i23;
                        }
                        int i25 = i22 + i24;
                        i4 = i8;
                        i5 = i21;
                        i6 = i9;
                        i7 = i10;
                        if (i25 < i9) {
                            int i26 = iArr2[2] - i3;
                            int i27 = i26;
                            if (i26 < 0) {
                                i27 = -i26;
                            }
                            int i28 = i27 + i25;
                            i4 = i8;
                            i5 = i21;
                            i6 = i9;
                            i7 = i10;
                            if (i28 < i9) {
                                i7 = iArr2[3];
                                i6 = i28;
                                i4 = i8;
                                i5 = i21;
                            }
                        }
                    }
                }
            }
        }

        public byte[] a() {
            byte[] bArr = new byte[768];
            int[] iArr = new int[256];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 256) {
                    break;
                }
                iArr[this.f[i2][3]] = i2;
                i = i2 + 1;
            }
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i3 >= 256) {
                    return bArr;
                }
                int i6 = iArr[i3];
                int i7 = i5 + 1;
                int[][] iArr2 = this.f;
                bArr[i5] = (byte) iArr2[i6][0];
                int i8 = i7 + 1;
                bArr[i7] = (byte) iArr2[i6][1];
                bArr[i8] = (byte) iArr2[i6][2];
                i3++;
                i4 = i8 + 1;
            }
        }

        public void b() {
            int i;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                i = i4;
                if (i2 >= 256) {
                    break;
                }
                int[] iArr = this.f[i2];
                int i5 = iArr[1];
                int i6 = i2 + 1;
                int i7 = i2;
                int i8 = i6;
                while (i8 < 256) {
                    int[] iArr2 = this.f[i8];
                    int i9 = i5;
                    if (iArr2[1] < i5) {
                        i9 = iArr2[1];
                        i7 = i8;
                    }
                    i8++;
                    i5 = i9;
                }
                int[] iArr3 = this.f[i7];
                if (i2 != i7) {
                    int i10 = iArr3[0];
                    iArr3[0] = iArr[0];
                    iArr[0] = i10;
                    int i11 = iArr3[1];
                    iArr3[1] = iArr[1];
                    iArr[1] = i11;
                    int i12 = iArr3[2];
                    iArr3[2] = iArr[2];
                    iArr[2] = i12;
                    int i13 = iArr3[3];
                    iArr3[3] = iArr[3];
                    iArr[3] = i13;
                }
                int i14 = i3;
                int i15 = i;
                if (i5 != i3) {
                    this.g[i3] = (i + i2) >> 1;
                    while (true) {
                        i3++;
                        if (i3 >= i5) {
                            break;
                        }
                        this.g[i3] = i2;
                    }
                    i15 = i2;
                    i14 = i5;
                }
                i2 = i6;
                i3 = i14;
                i4 = i15;
            }
            this.g[i3] = (i + 255) >> 1;
            int i16 = i3;
            while (true) {
                int i17 = i16 + 1;
                if (i17 >= 256) {
                    return;
                }
                this.g[i17] = 255;
                i16 = i17;
            }
        }

        public void c() {
            if (this.d < 1509) {
                this.e = 1;
            }
            int i = this.e;
            this.b = ((i - 1) / 3) + 30;
            byte[] bArr = this.f27656c;
            int i2 = this.d;
            int i3 = i2 / (i * 3);
            int i4 = i3 / 100;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= 32) {
                    break;
                }
                this.j[i6] = 1024 * (((1024 - (i6 * i6)) * 256) / 1024);
                i5 = i6 + 1;
            }
            int i7 = this.d;
            int i8 = i7 < 1509 ? 3 : i7 % 499 != 0 ? 1497 : i7 % Downloads.Impl.STATUS_UNKNOWN_ERROR != 0 ? 1473 : i7 % LiveProtos.Event.LIVE_GIFT_WALL_PAGE_HISTORY_ONE_CLICK_VALUE != 0 ? 1461 : 1509;
            int i9 = 0;
            int i10 = 2048;
            int i11 = 32;
            int i12 = 1024;
            int i13 = 0;
            while (i9 < i3) {
                int i14 = (bArr[i13 + 0] & 255) << 4;
                int i15 = (bArr[i13 + 1] & 255) << 4;
                int i16 = (bArr[i13 + 2] & 255) << 4;
                int b = b(i14, i15, i16);
                b(i12, b, i14, i15, i16);
                if (i11 != 0) {
                    a(i11, b, i14, i15, i16);
                }
                int i17 = i13 + i8;
                int i18 = i17;
                if (i17 >= i2) {
                    i18 = i17 - this.d;
                }
                int i19 = i18;
                int i20 = i9 + 1;
                int i21 = i4;
                if (i4 == 0) {
                    i21 = 1;
                }
                i9 = i20;
                i4 = i21;
                i13 = i19;
                if (i20 % i21 == 0) {
                    int i22 = i12 - (i12 / this.b);
                    int i23 = i10 - (i10 / 30);
                    int i24 = i23 >> 6;
                    if (i24 <= 1) {
                        i24 = 0;
                    }
                    int i25 = 0;
                    while (true) {
                        int i26 = i25;
                        i9 = i20;
                        i4 = i21;
                        i10 = i23;
                        i11 = i24;
                        i12 = i22;
                        i13 = i19;
                        if (i26 < i24) {
                            int i27 = i24 * i24;
                            this.j[i26] = (((i27 - (i26 * i26)) * 256) / i27) * i22;
                            i25 = i26 + 1;
                        }
                    }
                }
            }
        }

        public byte[] d() {
            c();
            e();
            b();
            return a();
        }

        public void e() {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 256) {
                    return;
                }
                int[][] iArr = this.f;
                int[] iArr2 = iArr[i2];
                iArr2[0] = iArr2[0] >> 4;
                int[] iArr3 = iArr[i2];
                iArr3[1] = iArr3[1] >> 4;
                int[] iArr4 = iArr[i2];
                iArr4[2] = iArr4[2] >> 4;
                iArr[i2][3] = i2;
                i = i2 + 1;
            }
        }
    }

    private void a(String str) throws IOException {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return;
            }
            this.j.write((byte) str.charAt(i2));
            i = i2 + 1;
        }
    }

    private int b(int i) {
        byte[] bArr = this.o;
        if (bArr == null) {
            return -1;
        }
        int i2 = 0;
        int length = bArr.length;
        int i3 = 0;
        int i4 = 16777216;
        while (true) {
            int i5 = i4;
            if (i2 >= length) {
                return i3;
            }
            byte[] bArr2 = this.o;
            int i6 = i2 + 1;
            int i7 = ((i >> 16) & 255) - (bArr2[i2] & 255);
            int i8 = i6 + 1;
            int i9 = ((i >> 8) & 255) - (bArr2[i6] & 255);
            int i10 = ((i >> 0) & 255) - (bArr2[i8] & 255);
            int i11 = (i7 * i7) + (i9 * i9) + (i10 * i10);
            int i12 = i8 / 3;
            int i13 = i3;
            int i14 = i5;
            if (this.p[i12]) {
                i13 = i3;
                i14 = i5;
                if (i11 < i5) {
                    i14 = i11;
                    i13 = i12;
                }
            }
            i2 = i8 + 1;
            i3 = i13;
            i4 = i14;
        }
    }

    private void b() {
        byte[] bArr = this.l;
        int length = bArr.length;
        int i = length / 3;
        this.m = new byte[i];
        C0746b c0746b = new C0746b(bArr, length, this.v);
        this.o = c0746b.d();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            byte[] bArr2 = this.o;
            if (i3 >= bArr2.length) {
                break;
            }
            byte b = bArr2[i3];
            int i4 = i3 + 2;
            bArr2[i3] = bArr2[i4];
            bArr2[i4] = b;
            this.p[i3 / 3] = false;
            i2 = i3 + 3;
        }
        int i5 = 0;
        int i6 = 0;
        while (i6 < i) {
            byte[] bArr3 = this.l;
            int i7 = i5 + 1;
            byte b2 = bArr3[i5];
            int i8 = i7 + 1;
            int a2 = c0746b.a(b2 & 255, bArr3[i7] & 255, bArr3[i8] & 255);
            this.p[a2] = true;
            this.m[i6] = (byte) a2;
            i6++;
            i5 = i8 + 1;
        }
        this.l = null;
        this.n = 8;
        this.q = 7;
        int i9 = this.e;
        if (i9 != -1) {
            this.f = b(i9);
        }
    }

    private int[] b(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    private void c() {
        int width = this.k.getWidth();
        int height = this.k.getHeight();
        if (width != this.f27651a || height != this.b) {
            Bitmap createBitmap = Bitmap.createBitmap(this.f27651a, this.b, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.k, 0.0f, 0.0f, new Paint());
            this.k = createBitmap;
        }
        int[] b = b(this.k);
        this.l = new byte[b.length * 3];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= b.length) {
                return;
            }
            int i3 = b[i2];
            int i4 = i2 * 3;
            byte[] bArr = this.l;
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((i3 >> 0) & 255);
            bArr[i5] = (byte) ((i3 >> 8) & 255);
            bArr[i5 + 1] = (byte) ((i3 >> 16) & 255);
            i = i2 + 1;
        }
    }

    private void c(int i) throws IOException {
        this.j.write(i & 255);
        this.j.write((i >> 8) & 255);
    }

    private void d() throws IOException {
        int i;
        int i2;
        this.j.write(33);
        this.j.write(249);
        this.j.write(4);
        if (this.e == -1) {
            i = 0;
            i2 = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        int i3 = this.r;
        if (i3 >= 0) {
            i2 = i3 & 7;
        }
        this.j.write(i | (i2 << 2) | 0 | 0);
        c(this.h);
        this.j.write(this.f);
        this.j.write(0);
    }

    private void e() throws IOException {
        this.j.write(44);
        c(this.f27652c);
        c(this.d);
        c(this.f27651a);
        c(this.b);
        if (this.t) {
            this.j.write(0);
        } else {
            this.j.write(this.q | 128);
        }
    }

    private void f() throws IOException {
        c(this.f27651a);
        c(this.b);
        this.j.write(this.q | 240);
        this.j.write(0);
        this.j.write(0);
    }

    private void g() throws IOException {
        this.j.write(33);
        this.j.write(255);
        this.j.write(11);
        a("NETSCAPE2.0");
        this.j.write(3);
        this.j.write(1);
        c(this.g);
        this.j.write(0);
    }

    private void h() throws IOException {
        OutputStream outputStream = this.j;
        byte[] bArr = this.o;
        outputStream.write(bArr, 0, bArr.length);
        int length = this.o.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 768 - length) {
                return;
            }
            this.j.write(0);
            i = i2 + 1;
        }
    }

    private void i() throws IOException {
        new a(this.f27651a, this.b, this.m, this.n).b(this.j);
    }

    public void a(int i) {
        this.h = i / 10;
    }

    public void a(int i, int i2) {
        this.f27651a = i;
        this.b = i2;
        if (i < 1) {
            this.f27651a = 320;
        }
        if (this.b < 1) {
            this.b = 240;
        }
        this.u = true;
    }

    public void a(boolean z) {
        this.g = !z ? 1 : 0;
    }

    public boolean a() {
        boolean z;
        if (this.i) {
            this.i = false;
            try {
                this.j.write(59);
                this.j.flush();
                if (this.s) {
                    this.j.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.f = 0;
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = null;
            this.o = null;
            this.s = false;
            this.t = true;
            return z;
        }
        return false;
    }

    public boolean a(Bitmap bitmap) {
        boolean z = false;
        if (bitmap != null) {
            if (!this.i) {
                return false;
            }
            try {
                if (!this.u) {
                    a(bitmap.getWidth(), bitmap.getHeight());
                }
                this.k = bitmap;
                c();
                b();
                if (this.t) {
                    f();
                    h();
                    if (this.g >= 0) {
                        g();
                    }
                }
                d();
                e();
                if (!this.t) {
                    h();
                }
                i();
                this.t = false;
                z = true;
            } catch (IOException e) {
                return false;
            }
        }
        return z;
    }

    public boolean a(OutputStream outputStream) {
        boolean z = false;
        if (outputStream == null) {
            return false;
        }
        this.s = false;
        this.j = outputStream;
        try {
            a("GIF89a");
            z = true;
        } catch (IOException e) {
        }
        this.i = z;
        return z;
    }
}
