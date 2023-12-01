package com.tencent.cloud.huiyansdkface.record.h264;

import java.nio.ByteBuffer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/record/h264/NV21Convert.class */
public class NV21Convert {

    /* renamed from: a  reason: collision with root package name */
    private int f36063a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f36064c;
    private int d;
    private int e;
    private boolean f;
    private boolean g = false;
    private int h;
    private byte[] i;

    public void convert(byte[] bArr, ByteBuffer byteBuffer) {
        byteBuffer.put(convert(bArr), 0, byteBuffer.capacity() < bArr.length ? byteBuffer.capacity() : bArr.length);
    }

    public byte[] convert(byte[] bArr) {
        byte[] bArr2;
        byte[] bArr3 = this.i;
        if (bArr3 == null || bArr3.length != (((this.f36063a * 3) * this.f36064c) / 2) + this.h) {
            this.i = new byte[(((this.f36063a * 3) * this.f36064c) / 2) + this.h];
        }
        if (!this.f) {
            if (this.f36063a == this.b && this.f36064c == this.d) {
                if (!this.g) {
                    int i = this.e;
                    while (true) {
                        int i2 = i;
                        int i3 = this.e;
                        if (i2 >= i3 + (i3 / 2)) {
                            break;
                        }
                        byte[] bArr4 = this.i;
                        int i4 = i2 + 1;
                        bArr4[0] = bArr[i4];
                        bArr[i4] = bArr[i2];
                        bArr[i2] = bArr4[0];
                        i = i2 + 2;
                    }
                }
                bArr2 = bArr;
                if (this.h > 0) {
                    System.arraycopy((Object) bArr, 0, (Object) this.i, 0, this.e);
                    int i5 = this.e;
                    System.arraycopy((Object) bArr, i5, (Object) this.i, this.h + i5, i5 / 2);
                    bArr2 = this.i;
                }
            }
            return bArr;
        }
        if (this.f36063a == this.b && this.f36064c == this.d) {
            if (!this.g) {
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    int i8 = this.e;
                    if (i7 >= i8 / 4) {
                        break;
                    }
                    byte[] bArr5 = this.i;
                    int i9 = i7 * 2;
                    bArr5[i7] = bArr[i8 + i9 + 1];
                    bArr5[(i8 / 4) + i7] = bArr[i8 + i9];
                    i6 = i7 + 1;
                }
            } else {
                int i10 = 0;
                while (true) {
                    int i11 = i10;
                    int i12 = this.e;
                    if (i11 >= i12 / 4) {
                        break;
                    }
                    byte[] bArr6 = this.i;
                    int i13 = i11 * 2;
                    bArr6[i11] = bArr[i12 + i13];
                    bArr6[(i12 / 4) + i11] = bArr[i12 + i13 + 1];
                    i10 = i11 + 1;
                }
            }
            if (this.h == 0) {
                byte[] bArr7 = this.i;
                int i14 = this.e;
                System.arraycopy((Object) bArr7, 0, (Object) bArr, i14, i14 / 2);
                return bArr;
            }
            System.arraycopy((Object) bArr, 0, (Object) this.i, 0, this.e);
            byte[] bArr8 = this.i;
            int i15 = this.e;
            System.arraycopy((Object) bArr8, 0, (Object) bArr8, this.h + i15, i15 / 2);
            bArr2 = this.i;
        }
        return bArr;
        return bArr2;
    }

    public void destory() {
        this.i = null;
    }

    public int getBufferSize() {
        return (this.e * 3) / 2;
    }

    public boolean getPlanar() {
        return this.f;
    }

    public int getSliceHeight() {
        return this.f36063a;
    }

    public int getStride() {
        return this.f36064c;
    }

    public boolean getUVPanesReversed() {
        return this.g;
    }

    public int getYPadding() {
        return this.h;
    }

    public void setColorPanesReversed(boolean z) {
        this.g = z;
    }

    public void setEncoderColorFormat(int i) {
        boolean z;
        if (i != 39 && i != 2130706688) {
            switch (i) {
                case 19:
                case 20:
                    z = true;
                    break;
                case 21:
                    break;
                default:
                    return;
            }
            setPlanar(z);
        }
        z = false;
        setPlanar(z);
    }

    public void setPlanar(boolean z) {
        this.f = z;
    }

    public void setSize(int i, int i2) {
        this.b = i2;
        this.d = i;
        this.f36063a = i2;
        this.f36064c = i;
        this.e = i * i2;
    }

    public void setSliceHeight(int i) {
        this.f36063a = i;
    }

    public void setStride(int i) {
        this.f36064c = i;
    }

    public void setYPadding(int i) {
        this.h = i;
    }
}
