package com.tencent.qmsp.sdk.f;

import android.widget.ExpandableListView;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/f/c.class */
class c {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f38601a;
    private byte[] b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f38602c;
    private int d;
    private int e;
    private int f;
    private int g;
    private byte[] h;
    private int j;
    private boolean i = true;
    private Random k = new Random();

    private void a() {
        this.f = 0;
        while (true) {
            int i = this.f;
            if (i >= 8) {
                break;
            }
            if (this.i) {
                byte[] bArr = this.f38601a;
                bArr[i] = (byte) (bArr[i] ^ this.b[i]);
            } else {
                byte[] bArr2 = this.f38601a;
                bArr2[i] = (byte) (bArr2[i] ^ this.f38602c[this.e + i]);
            }
            this.f++;
        }
        System.arraycopy((Object) b(this.f38601a), 0, (Object) this.f38602c, this.d, 8);
        this.f = 0;
        while (true) {
            int i2 = this.f;
            if (i2 >= 8) {
                System.arraycopy((Object) this.f38601a, 0, (Object) this.b, 0, 8);
                int i3 = this.d;
                this.e = i3;
                this.d = i3 + 8;
                this.f = 0;
                this.i = false;
                return;
            }
            byte[] bArr3 = this.f38602c;
            int i4 = this.d + i2;
            bArr3[i4] = (byte) (bArr3[i4] ^ this.b[i2]);
            this.f = i2 + 1;
        }
    }

    private boolean a(byte[] bArr, int i, int i2) {
        this.f = 0;
        while (true) {
            int i3 = this.f;
            if (i3 >= 8) {
                byte[] a2 = a(this.b);
                this.b = a2;
                if (a2 == null) {
                    return false;
                }
                this.j += 8;
                this.d += 8;
                this.f = 0;
                return true;
            } else if (this.j + i3 >= i2) {
                return true;
            } else {
                byte[] bArr2 = this.b;
                bArr2[i3] = (byte) (bArr2[i3] ^ bArr[(this.d + i) + i3]);
                this.f = i3 + 1;
            }
        }
    }

    private byte[] a(byte[] bArr) {
        return a(bArr, 0);
    }

    private byte[] a(byte[] bArr, int i) {
        try {
            long b = b(bArr, i, 4);
            long b2 = b(bArr, i + 4, 4);
            long b3 = b(this.h, 0, 4);
            long b4 = b(this.h, 4, 4);
            long b5 = b(this.h, 8, 4);
            long b6 = b(this.h, 12, 4);
            long j = 3816266640L;
            int i2 = 16;
            while (true) {
                int i3 = i2;
                if (i3 <= 0) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) b);
                    dataOutputStream.writeInt((int) b2);
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                b2 = (b2 - ((((b << 4) + b5) ^ (b + j)) ^ ((b >>> 5) + b6))) & ExpandableListView.PACKED_POSITION_VALUE_NULL;
                b = (b - ((((b2 << 4) + b3) ^ (b2 + j)) ^ ((b2 >>> 5) + b4))) & ExpandableListView.PACKED_POSITION_VALUE_NULL;
                j = (j - 2654435769L) & ExpandableListView.PACKED_POSITION_VALUE_NULL;
                i2 = i3 - 1;
            }
        } catch (IOException e) {
            return null;
        }
    }

    private int b() {
        return this.k.nextInt();
    }

    private static long b(byte[] bArr, int i, int i2) {
        long j = 0;
        int i3 = i2 > 8 ? i + 8 : i2 + i;
        while (i < i3) {
            j = (j << 8) | (bArr[i] & 255);
            i++;
        }
        return (ExpandableListView.PACKED_POSITION_VALUE_NULL & j) | (j >>> 32);
    }

    private byte[] b(byte[] bArr) {
        try {
            long b = b(bArr, 0, 4);
            long b2 = b(bArr, 4, 4);
            long b3 = b(this.h, 0, 4);
            long b4 = b(this.h, 4, 4);
            long b5 = b(this.h, 8, 4);
            long b6 = b(this.h, 12, 4);
            long j = 0;
            int i = 16;
            while (true) {
                int i2 = i;
                if (i2 <= 0) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) b);
                    dataOutputStream.writeInt((int) b2);
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                j = (j + 2654435769L) & ExpandableListView.PACKED_POSITION_VALUE_NULL;
                b = (b + ((((b2 << 4) + b3) ^ (b2 + j)) ^ ((b2 >>> 5) + b4))) & ExpandableListView.PACKED_POSITION_VALUE_NULL;
                b2 = (b2 + ((((b << 4) + b5) ^ (b + j)) ^ ((b >>> 5) + b6))) & ExpandableListView.PACKED_POSITION_VALUE_NULL;
                i = i2 - 1;
            }
        } catch (IOException e) {
            return null;
        }
    }

    private byte[] b(byte[] bArr, int i, int i2, byte[] bArr2) {
        int i3;
        int i4;
        int i5;
        this.f38601a = new byte[8];
        this.b = new byte[8];
        this.f = 1;
        this.g = 0;
        this.e = 0;
        this.d = 0;
        this.h = bArr2;
        this.i = true;
        int i6 = (i2 + 10) % 8;
        this.f = i6;
        if (i6 != 0) {
            this.f = 8 - i6;
        }
        this.f38602c = new byte[this.f + i2 + 10];
        this.f38601a[0] = (byte) ((b() & 248) | this.f);
        int i7 = 1;
        while (true) {
            int i8 = i7;
            i3 = this.f;
            if (i8 > i3) {
                break;
            }
            this.f38601a[i8] = (byte) (b() & 255);
            i7 = i8 + 1;
        }
        this.f = i3 + 1;
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= 8) {
                break;
            }
            this.b[i10] = 0;
            i9 = i10 + 1;
        }
        this.g = 1;
        while (true) {
            i4 = i;
            i5 = i2;
            if (this.g > 2) {
                break;
            }
            int i11 = this.f;
            if (i11 < 8) {
                byte[] bArr3 = this.f38601a;
                this.f = i11 + 1;
                bArr3[i11] = (byte) (b() & 255);
                this.g++;
            }
            if (this.f == 8) {
                a();
            }
        }
        while (i5 > 0) {
            int i12 = this.f;
            int i13 = i4;
            int i14 = i5;
            if (i12 < 8) {
                byte[] bArr4 = this.f38601a;
                this.f = i12 + 1;
                bArr4[i12] = bArr[i4];
                i14 = i5 - 1;
                i13 = i4 + 1;
            }
            i4 = i13;
            i5 = i14;
            if (this.f == 8) {
                a();
                i4 = i13;
                i5 = i14;
            }
        }
        this.g = 1;
        while (true) {
            int i15 = this.g;
            if (i15 > 7) {
                return this.f38602c;
            }
            int i16 = this.f;
            if (i16 < 8) {
                byte[] bArr5 = this.f38601a;
                this.f = i16 + 1;
                bArr5[i16] = 0;
                this.g = i15 + 1;
            }
            if (this.f == 8) {
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] a(byte[] bArr, int i, int i2, byte[] bArr2) {
        this.e = 0;
        this.d = 0;
        this.h = bArr2;
        int i3 = i + 8;
        byte[] bArr3 = new byte[i3];
        if (i2 % 8 != 0 || i2 < 16) {
            return null;
        }
        byte[] a2 = a(bArr, i);
        this.b = a2;
        int i4 = a2[0] & 7;
        this.f = i4;
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
            bArr3[i7] = 0;
            i6 = i7 + 1;
        }
        this.f38602c = new byte[i5];
        this.e = 0;
        this.d = 8;
        this.j = 8;
        this.f++;
        this.g = 1;
        while (true) {
            int i8 = this.g;
            int i9 = 0;
            byte[] bArr4 = bArr3;
            int i10 = i5;
            if (i8 > 2) {
                while (i10 != 0) {
                    int i11 = this.f;
                    int i12 = i9;
                    int i13 = i10;
                    if (i11 < 8) {
                        this.f38602c[i9] = (byte) (bArr4[(this.e + i) + i11] ^ this.b[i11]);
                        i12 = i9 + 1;
                        i13 = i10 - 1;
                        this.f = i11 + 1;
                    }
                    i9 = i12;
                    i10 = i13;
                    if (this.f == 8) {
                        this.e = this.d - 8;
                        if (!a(bArr, i, i2)) {
                            return null;
                        }
                        bArr4 = bArr;
                        i9 = i12;
                        i10 = i13;
                    }
                }
                this.g = 1;
                while (this.g < 8) {
                    int i14 = this.f;
                    if (i14 < 8) {
                        if ((bArr4[(this.e + i) + i14] ^ this.b[i14]) != 0) {
                            return null;
                        }
                        this.f = i14 + 1;
                    }
                    byte[] bArr5 = bArr4;
                    if (this.f == 8) {
                        this.e = this.d;
                        if (!a(bArr, i, i2)) {
                            return null;
                        }
                        bArr5 = bArr;
                    }
                    this.g++;
                    bArr4 = bArr5;
                }
                return this.f38602c;
            }
            int i15 = this.f;
            if (i15 < 8) {
                this.f = i15 + 1;
                this.g = i8 + 1;
            }
            if (this.f == 8) {
                if (!a(bArr, i, i2)) {
                    return null;
                }
                bArr3 = bArr;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] a(byte[] bArr, byte[] bArr2) {
        return b(bArr, 0, bArr.length, bArr2);
    }
}
