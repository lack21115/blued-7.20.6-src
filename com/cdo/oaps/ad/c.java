package com.cdo.oaps.ad;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static Random f7913a = new Random();

    /* renamed from: c  reason: collision with root package name */
    private int f7914c;
    private int d;
    private int e;
    private byte[] g;
    private byte[] h;
    private int i;
    private byte[] j;
    private int k;
    private byte[] l;
    private boolean f = true;
    private ByteArrayOutputStream b = new ByteArrayOutputStream(8);

    private static long a(byte[] bArr, int i, int i2) {
        long j = 0;
        int i3 = i2 > 8 ? i + 8 : i2 + i;
        while (i < i3) {
            j = (j << 8) | (bArr[i] & 255);
            i++;
        }
        return (4294967295L & j) | (j >>> 32);
    }

    private void a() {
        byte[] bArr;
        int i;
        byte[] bArr2;
        byte[] bArr3;
        this.k = 0;
        while (true) {
            int i2 = this.k;
            if (i2 >= 8) {
                break;
            }
            if (this.f) {
                this.j[i2] = (byte) (bArr3[i2] ^ this.l[i2]);
            } else {
                this.j[i2] = (byte) (bArr2[i2] ^ this.h[this.e + i2]);
            }
            this.k++;
        }
        System.arraycopy(b(this.j), 0, this.h, this.d, 8);
        this.k = 0;
        while (true) {
            int i3 = this.k;
            if (i3 >= 8) {
                System.arraycopy(this.j, 0, this.l, 0, 8);
                int i4 = this.d;
                this.e = i4;
                this.d = i4 + 8;
                this.k = 0;
                this.f = false;
                return;
            }
            this.h[this.d + i3] = (byte) (bArr[i] ^ this.l[i3]);
            this.k = i3 + 1;
        }
    }

    private void a(int i) {
        this.b.write(i >>> 24);
        this.b.write(i >>> 16);
        this.b.write(i >>> 8);
        this.b.write(i);
    }

    private byte[] a(byte[] bArr) {
        return a(bArr, 0);
    }

    private byte[] a(byte[] bArr, int i) {
        long a2 = a(bArr, i, 4);
        long a3 = a(bArr, i + 4, 4);
        long a4 = a(this.g, 0, 4);
        long a5 = a(this.g, 4, 4);
        long a6 = a(this.g, 8, 4);
        long a7 = a(this.g, 12, 4);
        long j = 3816266640L;
        for (int i2 = 16; i2 > 0; i2--) {
            a3 = (a3 - ((((a2 << 4) + a6) ^ (a2 + j)) ^ ((a2 >>> 5) + a7))) & 4294967295L;
            a2 = (a2 - ((((a3 << 4) + a4) ^ (a3 + j)) ^ ((a3 >>> 5) + a5))) & 4294967295L;
            j = (j - 2654435769L) & 4294967295L;
        }
        this.b.reset();
        a((int) a2);
        a((int) a3);
        return this.b.toByteArray();
    }

    private int b() {
        return f7913a.nextInt();
    }

    private boolean b(byte[] bArr, int i, int i2) {
        byte[] bArr2;
        this.k = 0;
        while (true) {
            int i3 = this.k;
            if (i3 >= 8) {
                this.l = a(this.l);
                this.f7914c += 8;
                this.d += 8;
                this.k = 0;
                return true;
            } else if (this.f7914c + i3 >= i2) {
                return true;
            } else {
                this.l[i3] = (byte) (bArr2[i3] ^ bArr[(this.d + i) + i3]);
                this.k = i3 + 1;
            }
        }
    }

    private byte[] b(byte[] bArr) {
        long a2 = a(bArr, 0, 4);
        long a3 = a(bArr, 4, 4);
        long a4 = a(this.g, 0, 4);
        long a5 = a(this.g, 4, 4);
        long a6 = a(this.g, 8, 4);
        long a7 = a(this.g, 12, 4);
        long j = 0;
        for (int i = 16; i > 0; i--) {
            j = (j + 2654435769L) & 4294967295L;
            a2 = (a2 + ((((a3 << 4) + a4) ^ (a3 + j)) ^ ((a3 >>> 5) + a5))) & 4294967295L;
            a3 = (a3 + ((((a2 << 4) + a6) ^ (a2 + j)) ^ ((a2 >>> 5) + a7))) & 4294967295L;
        }
        this.b.reset();
        a((int) a2);
        a((int) a3);
        return this.b.toByteArray();
    }

    public byte[] a(byte[] bArr, int i, int i2, byte[] bArr2) {
        if (bArr2 == null) {
            return null;
        }
        this.e = 0;
        this.d = 0;
        this.g = bArr2;
        int i3 = i + 8;
        byte[] bArr3 = new byte[i3];
        byte[] bArr4 = null;
        if (i2 % 8 == 0) {
            if (i2 < 16) {
                return null;
            }
            byte[] a2 = a(bArr, i);
            this.l = a2;
            int i4 = a2[0] & 7;
            this.k = i4;
            int i5 = (i2 - i4) - 10;
            if (i5 < 0) {
                return null;
            }
            int i6 = i;
            while (true) {
                int i7 = i6;
                if (i7 >= i3) {
                    break;
                }
                bArr3[i7] = (byte) 0;
                i6 = i7 + 1;
            }
            this.h = new byte[i5];
            this.e = 0;
            this.d = 8;
            this.f7914c = 8;
            this.k++;
            this.i = 1;
            byte[] bArr5 = bArr3;
            while (true) {
                int i8 = this.i;
                int i9 = 0;
                byte[] bArr6 = bArr5;
                int i10 = i5;
                if (i8 <= 2) {
                    int i11 = this.k;
                    if (i11 < 8) {
                        this.k = i11 + 1;
                        this.i = i8 + 1;
                    }
                    if (this.k == 8) {
                        if (!b(bArr, i, i2)) {
                            return null;
                        }
                        bArr5 = bArr;
                    }
                } else {
                    while (i10 != 0) {
                        int i12 = this.k;
                        int i13 = i9;
                        int i14 = i10;
                        if (i12 < 8) {
                            this.h[i9] = (byte) (bArr6[(this.e + i) + i12] ^ this.l[i12]);
                            i13 = i9 + 1;
                            this.k = i12 + 1;
                            i14 = i10 - 1;
                        }
                        i9 = i13;
                        i10 = i14;
                        if (this.k == 8) {
                            this.e = this.d - 8;
                            if (!b(bArr, i, i2)) {
                                return null;
                            }
                            bArr6 = bArr;
                            i9 = i13;
                            i10 = i14;
                        }
                    }
                    this.i = 1;
                    while (this.i < 8) {
                        int i15 = this.k;
                        if (i15 < 8) {
                            if ((bArr6[(this.e + i) + i15] ^ this.l[i15]) != 0) {
                                return null;
                            }
                            this.k = i15 + 1;
                        }
                        byte[] bArr7 = bArr6;
                        if (this.k == 8) {
                            this.e = this.d;
                            if (!b(bArr, i, i2)) {
                                return null;
                            }
                            bArr7 = bArr;
                        }
                        this.i++;
                        bArr6 = bArr7;
                    }
                    bArr4 = (byte[]) this.h.clone();
                }
            }
        }
        return bArr4;
    }

    public byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, 0, bArr.length, bArr2);
    }

    public byte[] b(byte[] bArr, int i, int i2, byte[] bArr2) {
        int i3;
        int i4;
        int i5;
        if (bArr2 == null) {
            return bArr;
        }
        this.j = new byte[8];
        this.l = new byte[8];
        this.k = 1;
        this.i = 0;
        this.e = 0;
        this.d = 0;
        this.g = bArr2;
        this.f = true;
        int i6 = (i2 + 10) % 8;
        this.k = i6;
        if (i6 != 0) {
            this.k = 8 - i6;
        }
        this.h = new byte[this.k + i2 + 10];
        this.j[0] = (byte) ((b() & 248) | this.k);
        int i7 = 1;
        while (true) {
            int i8 = i7;
            i3 = this.k;
            if (i8 > i3) {
                break;
            }
            this.j[i8] = (byte) (b() & 255);
            i7 = i8 + 1;
        }
        this.k = i3 + 1;
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= 8) {
                break;
            }
            this.l[i10] = (byte) 0;
            i9 = i10 + 1;
        }
        this.i = 1;
        while (true) {
            i4 = i;
            i5 = i2;
            if (this.i > 2) {
                break;
            }
            int i11 = this.k;
            if (i11 < 8) {
                byte[] bArr3 = this.j;
                this.k = i11 + 1;
                bArr3[i11] = (byte) (b() & 255);
                this.i++;
            }
            if (this.k == 8) {
                a();
            }
        }
        while (i5 > 0) {
            int i12 = this.k;
            int i13 = i4;
            int i14 = i5;
            if (i12 < 8) {
                byte[] bArr4 = this.j;
                this.k = i12 + 1;
                bArr4[i12] = bArr[i4];
                i14 = i5 - 1;
                i13 = i4 + 1;
            }
            i4 = i13;
            i5 = i14;
            if (this.k == 8) {
                a();
                i4 = i13;
                i5 = i14;
            }
        }
        this.i = 1;
        while (true) {
            int i15 = this.i;
            if (i15 > 7) {
                return (byte[]) this.h.clone();
            }
            int i16 = this.k;
            if (i16 < 8) {
                byte[] bArr5 = this.j;
                this.k = i16 + 1;
                bArr5[i16] = (byte) 0;
                this.i = i15 + 1;
            }
            if (this.k == 8) {
                a();
            }
        }
    }

    public byte[] b(byte[] bArr, byte[] bArr2) {
        return b(bArr, 0, bArr.length, bArr2);
    }
}
