package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/gifdecoder/StandardGifDecoder.class */
public class StandardGifDecoder implements GifDecoder {

    /* renamed from: a  reason: collision with root package name */
    private static final String f20691a = StandardGifDecoder.class.getSimpleName();
    private int[] b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f20692c;
    private final GifDecoder.BitmapProvider d;
    private ByteBuffer e;
    private byte[] f;
    private short[] g;
    private byte[] h;
    private byte[] i;
    private byte[] j;
    private int[] k;
    private int l;
    private GifHeader m;
    private Bitmap n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private int s;
    private Boolean t;
    private Bitmap.Config u;

    public StandardGifDecoder(GifDecoder.BitmapProvider bitmapProvider) {
        this.f20692c = new int[256];
        this.u = Bitmap.Config.ARGB_8888;
        this.d = bitmapProvider;
        this.m = new GifHeader();
    }

    public StandardGifDecoder(GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
        this(bitmapProvider);
        a(gifHeader, byteBuffer, i);
    }

    private int a(int i, int i2, int i3) {
        int i4;
        int i5 = i;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            i4 = i10;
            if (i5 >= this.q + i) {
                break;
            }
            byte[] bArr = this.j;
            if (i5 >= bArr.length || i5 >= i2) {
                break;
            }
            int i11 = this.b[bArr[i5] & 255];
            int i12 = i6;
            int i13 = i7;
            int i14 = i8;
            int i15 = i9;
            int i16 = i4;
            if (i11 != 0) {
                i12 = i6 + ((i11 >> 24) & 255);
                i13 = i7 + ((i11 >> 16) & 255);
                i14 = i8 + ((i11 >> 8) & 255);
                i15 = i9 + (i11 & 255);
                i16 = i4 + 1;
            }
            i5++;
            i6 = i12;
            i7 = i13;
            i8 = i14;
            i9 = i15;
            i10 = i16;
        }
        int i17 = i + i3;
        int i18 = i17;
        int i19 = i6;
        while (i18 < this.q + i17) {
            byte[] bArr2 = this.j;
            if (i18 >= bArr2.length || i18 >= i2) {
                break;
            }
            int i20 = this.b[bArr2[i18] & 255];
            int i21 = i19;
            int i22 = i7;
            int i23 = i8;
            int i24 = i9;
            int i25 = i4;
            if (i20 != 0) {
                i21 = i19 + ((i20 >> 24) & 255);
                i22 = i7 + ((i20 >> 16) & 255);
                i23 = i8 + ((i20 >> 8) & 255);
                i24 = i9 + (i20 & 255);
                i25 = i4 + 1;
            }
            i18++;
            i19 = i21;
            i7 = i22;
            i8 = i23;
            i9 = i24;
            i4 = i25;
        }
        if (i4 == 0) {
            return 0;
        }
        return ((i19 / i4) << 24) | ((i7 / i4) << 16) | ((i8 / i4) << 8) | (i9 / i4);
    }

    private Bitmap a(GifFrame gifFrame, GifFrame gifFrame2) {
        Bitmap bitmap;
        int[] iArr = this.k;
        if (gifFrame2 == null) {
            Bitmap bitmap2 = this.n;
            if (bitmap2 != null) {
                this.d.a(bitmap2);
            }
            this.n = null;
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && gifFrame2.g == 3 && this.n == null) {
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && gifFrame2.g > 0) {
            if (gifFrame2.g == 2) {
                int i = 0;
                if (!gifFrame.f) {
                    i = this.m.l;
                    if (gifFrame.k != null && this.m.j == gifFrame.h) {
                        i = 0;
                    }
                }
                int i2 = gifFrame2.d / this.q;
                int i3 = gifFrame2.b / this.q;
                int i4 = gifFrame2.f20686c / this.q;
                int i5 = gifFrame2.f20685a / this.q;
                int i6 = this.s;
                int i7 = (i3 * i6) + i5;
                int i8 = i7;
                while (true) {
                    int i9 = i8;
                    if (i9 >= (i2 * i6) + i7) {
                        break;
                    }
                    int i10 = i9;
                    while (true) {
                        int i11 = i10;
                        if (i11 < i9 + i4) {
                            iArr[i11] = i;
                            i10 = i11 + 1;
                        }
                    }
                    i8 = i9 + this.s;
                }
            } else if (gifFrame2.g == 3 && (bitmap = this.n) != null) {
                int i12 = this.s;
                bitmap.getPixels(iArr, 0, i12, 0, 0, i12, this.r);
            }
        }
        c(gifFrame);
        if (gifFrame.e || this.q != 1) {
            b(gifFrame);
        } else {
            a(gifFrame);
        }
        if (this.o && (gifFrame.g == 0 || gifFrame.g == 1)) {
            if (this.n == null) {
                this.n = m();
            }
            Bitmap bitmap3 = this.n;
            int i13 = this.s;
            bitmap3.setPixels(iArr, 0, i13, 0, 0, i13, this.r);
        }
        Bitmap m = m();
        int i14 = this.s;
        m.setPixels(iArr, 0, i14, 0, 0, i14, this.r);
        return m;
    }

    private void a(GifFrame gifFrame) {
        int[] iArr = this.k;
        int i = gifFrame.d;
        int i2 = gifFrame.b;
        int i3 = gifFrame.f20686c;
        int i4 = gifFrame.f20685a;
        boolean z = this.l == 0;
        int i5 = this.s;
        byte[] bArr = this.j;
        int[] iArr2 = this.b;
        byte b = -1;
        for (int i6 = 0; i6 < i; i6++) {
            int i7 = (i6 + i2) * i5;
            int i8 = i7 + i4;
            int i9 = i8 + i3;
            int i10 = i7 + i5;
            int i11 = i9;
            if (i10 < i9) {
                i11 = i10;
            }
            int i12 = gifFrame.f20686c * i6;
            while (i8 < i11) {
                byte b2 = bArr[i12];
                int i13 = b2 & 255;
                byte b3 = b;
                if (i13 != b) {
                    int i14 = iArr2[i13];
                    if (i14 != 0) {
                        iArr[i8] = i14;
                        b3 = b;
                    } else {
                        b3 = b2;
                    }
                }
                i12++;
                i8++;
                b = b3;
            }
        }
        Boolean bool = this.t;
        this.t = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.t == null && z && b != -1));
    }

    private void b(GifFrame gifFrame) {
        int i;
        int i2;
        int i3;
        Boolean bool;
        int i4;
        int i5;
        int i6;
        Boolean bool2;
        Boolean bool3;
        int[] iArr = this.k;
        int i7 = gifFrame.d / this.q;
        int i8 = gifFrame.b / this.q;
        int i9 = gifFrame.f20686c / this.q;
        int i10 = gifFrame.f20685a / this.q;
        boolean z = this.l == 0;
        int i11 = this.q;
        int i12 = this.s;
        int i13 = this.r;
        byte[] bArr = this.j;
        int[] iArr2 = this.b;
        Boolean bool4 = this.t;
        int i14 = 8;
        int i15 = 0;
        int i16 = 0;
        int i17 = 1;
        while (true) {
            int i18 = i17;
            if (i15 >= i7) {
                break;
            }
            if (gifFrame.e) {
                if (i16 >= i7) {
                    i18++;
                    if (i18 == 2) {
                        i16 = 4;
                    } else if (i18 == 3) {
                        i16 = 2;
                        i14 = 4;
                    } else if (i18 == 4) {
                        i16 = 1;
                        i14 = 2;
                    }
                }
                i3 = i16 + i14;
                i = i16;
                i2 = i18;
            } else {
                i = i15;
                i2 = i18;
                i3 = i16;
            }
            int i19 = i + i8;
            boolean z2 = i11 == 1;
            if (i19 < i13) {
                int i20 = i19 * i12;
                int i21 = i20 + i10;
                int i22 = i21 + i9;
                int i23 = i20 + i12;
                int i24 = i22;
                if (i23 < i22) {
                    i24 = i23;
                }
                int i25 = i15 * i11 * gifFrame.f20686c;
                if (z2) {
                    int i26 = i21;
                    while (true) {
                        i4 = i8;
                        bool = bool4;
                        if (i26 >= i24) {
                            break;
                        }
                        int i27 = iArr2[bArr[i25] & 255];
                        if (i27 != 0) {
                            iArr[i26] = i27;
                            bool3 = bool4;
                        } else {
                            bool3 = bool4;
                            if (z) {
                                bool3 = bool4;
                                if (bool4 == null) {
                                    bool3 = true;
                                }
                            }
                        }
                        i25 += i11;
                        i26++;
                        bool4 = bool3;
                    }
                } else {
                    int i28 = i8;
                    int i29 = i25;
                    int i30 = i9;
                    int i31 = i21;
                    while (true) {
                        int i32 = i29;
                        i5 = i28;
                        bool = bool4;
                        i6 = i30;
                        if (i31 < i24) {
                            int a2 = a(i32, ((i24 - i21) * i11) + i25, gifFrame.f20686c);
                            if (a2 != 0) {
                                iArr[i31] = a2;
                                bool2 = bool4;
                            } else {
                                bool2 = bool4;
                                if (z) {
                                    bool2 = bool4;
                                    if (bool4 == null) {
                                        bool2 = true;
                                    }
                                }
                            }
                            i29 = i32 + i11;
                            i31++;
                            bool4 = bool2;
                        }
                    }
                    bool4 = bool;
                    i15++;
                    int i33 = i5;
                    i9 = i6;
                    i16 = i3;
                    i8 = i33;
                    i17 = i2;
                }
            } else {
                bool = bool4;
                i4 = i8;
            }
            i6 = i9;
            i5 = i4;
            bool4 = bool;
            i15++;
            int i332 = i5;
            i9 = i6;
            i16 = i3;
            i8 = i332;
            i17 = i2;
        }
        if (this.t == null) {
            this.t = Boolean.valueOf(bool4 == null ? false : bool4.booleanValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c(GifFrame gifFrame) {
        int i;
        int i2;
        short s;
        int i3;
        if (gifFrame != null) {
            this.e.position(gifFrame.j);
        }
        if (gifFrame == null) {
            i = this.m.f * this.m.g;
        } else {
            i = gifFrame.d * gifFrame.f20686c;
        }
        byte[] bArr = this.j;
        if (bArr == null || bArr.length < i) {
            this.j = this.d.a(i);
        }
        byte[] bArr2 = this.j;
        if (this.g == null) {
            this.g = new short[4096];
        }
        short[] sArr = this.g;
        if (this.h == null) {
            this.h = new byte[4096];
        }
        byte[] bArr3 = this.h;
        if (this.i == null) {
            this.i = new byte[4097];
        }
        byte[] bArr4 = this.i;
        int k = k();
        int i4 = 1 << k;
        int i5 = i4 + 2;
        int i6 = k + 1;
        int i7 = (1 << i6) - 1;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= i4) {
                break;
            }
            sArr[i10] = 0;
            bArr3[i10] = (byte) i10;
            i9 = i10 + 1;
        }
        byte[] bArr5 = this.f;
        int i11 = i6;
        int i12 = i5;
        int i13 = i7;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = -1;
        int i20 = 0;
        int i21 = 0;
        while (true) {
            if (i8 >= i) {
                break;
            }
            int i22 = i14;
            if (i14 == 0) {
                i22 = l();
                if (i22 <= 0) {
                    this.p = 3;
                    break;
                }
                i15 = 0;
            }
            i17 += (bArr5[i15] & 255) << i16;
            int i23 = i15 + 1;
            int i24 = i22 - 1;
            int i25 = i12;
            int i26 = i19;
            int i27 = i20;
            int i28 = i11;
            int i29 = i8;
            int i30 = i5;
            int i31 = i25;
            int i32 = i27;
            i16 += 8;
            while (true) {
                if (i16 < i28) {
                    int i33 = i26;
                    i12 = i31;
                    i20 = i32;
                    i5 = i30;
                    i8 = i29;
                    i14 = i24;
                    i15 = i23;
                    i11 = i28;
                    i19 = i33;
                    break;
                }
                int i34 = i17 & i13;
                i17 >>= i28;
                i16 -= i28;
                if (i34 == i4) {
                    i13 = i7;
                    i28 = i6;
                    i26 = -1;
                    i31 = i30;
                    i30 = i30;
                } else if (i34 == i4 + 1) {
                    int i35 = i32;
                    i5 = i30;
                    int i36 = i26;
                    i11 = i28;
                    i8 = i29;
                    i14 = i24;
                    i15 = i23;
                    i12 = i31;
                    i19 = i36;
                    i20 = i35;
                    break;
                } else if (i26 == -1) {
                    bArr2[i18] = bArr3[i34];
                    i18++;
                    i29++;
                    i26 = i34;
                    i32 = i26;
                } else {
                    if (i34 >= i31) {
                        bArr4[i21] = (byte) i32;
                        i2 = i21 + 1;
                        s = i26;
                    } else {
                        i2 = i21;
                        s = i34;
                    }
                    while (true) {
                        i3 = s;
                        if (i3 < i4) {
                            break;
                        }
                        bArr4[i2] = bArr3[i3];
                        i2++;
                        s = sArr[i3];
                    }
                    int i37 = bArr3[i3] & 255;
                    byte b = (byte) i37;
                    bArr2[i18] = b;
                    i21 = i2;
                    while (true) {
                        i18++;
                        i29++;
                        if (i21 <= 0) {
                            break;
                        }
                        i21--;
                        bArr2[i18] = bArr4[i21];
                    }
                    int i38 = i31;
                    int i39 = i28;
                    int i40 = i13;
                    if (i31 < 4096) {
                        sArr[i31] = (short) i26;
                        bArr3[i31] = b;
                        int i41 = i31 + 1;
                        i38 = i41;
                        i39 = i28;
                        i40 = i13;
                        if ((i41 & i13) == 0) {
                            i38 = i41;
                            i39 = i28;
                            i40 = i13;
                            if (i41 < 4096) {
                                i39 = i28 + 1;
                                i40 = i13 + i41;
                                i38 = i41;
                            }
                        }
                    }
                    i26 = i34;
                    i32 = i37;
                    i31 = i38;
                    i28 = i39;
                    i13 = i40;
                }
            }
        }
        Arrays.fill(bArr2, i18, i, (byte) 0);
    }

    private int k() {
        return this.e.get() & 255;
    }

    private int l() {
        int k = k();
        if (k <= 0) {
            return k;
        }
        ByteBuffer byteBuffer = this.e;
        byteBuffer.get(this.f, 0, Math.min(k, byteBuffer.remaining()));
        return k;
    }

    private Bitmap m() {
        Boolean bool = this.t;
        Bitmap a2 = this.d.a(this.s, this.r, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.u);
        a2.setHasAlpha(true);
        return a2;
    }

    public int a(int i) {
        if (i < 0 || i >= this.m.f20688c) {
            return -1;
        }
        return this.m.e.get(i).i;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public ByteBuffer a() {
        return this.e;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void a(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.u = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    public void a(GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
        synchronized (this) {
            if (i <= 0) {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
            }
            int highestOneBit = Integer.highestOneBit(i);
            this.p = 0;
            this.m = gifHeader;
            this.l = -1;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.e = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.e.order(ByteOrder.LITTLE_ENDIAN);
            this.o = false;
            Iterator<GifFrame> it = gifHeader.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().g == 3) {
                    this.o = true;
                    break;
                }
            }
            this.q = highestOneBit;
            this.s = gifHeader.f / highestOneBit;
            this.r = gifHeader.g / highestOneBit;
            this.j = this.d.a(gifHeader.f * gifHeader.g);
            this.k = this.d.b(this.s * this.r);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void b() {
        this.l = (this.l + 1) % this.m.f20688c;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int c() {
        int i;
        if (this.m.f20688c <= 0 || (i = this.l) < 0) {
            return 0;
        }
        return a(i);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int d() {
        return this.m.f20688c;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int e() {
        return this.l;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void f() {
        this.l = -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int g() {
        if (this.m.m == -1) {
            return 1;
        }
        if (this.m.m == 0) {
            return 0;
        }
        return this.m.m + 1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int h() {
        return this.e.limit() + this.j.length + (this.k.length * 4);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public Bitmap i() {
        synchronized (this) {
            if (this.m.f20688c <= 0 || this.l < 0) {
                if (Log.isLoggable(f20691a, 3)) {
                    String str = f20691a;
                    Log.d(str, "Unable to decode frame, frameCount=" + this.m.f20688c + ", framePointer=" + this.l);
                }
                this.p = 1;
            }
            if (this.p != 1 && this.p != 2) {
                this.p = 0;
                if (this.f == null) {
                    this.f = this.d.a(255);
                }
                GifFrame gifFrame = this.m.e.get(this.l);
                int i = this.l - 1;
                GifFrame gifFrame2 = i >= 0 ? this.m.e.get(i) : null;
                int[] iArr = gifFrame.k != null ? gifFrame.k : this.m.f20687a;
                this.b = iArr;
                if (iArr == null) {
                    if (Log.isLoggable(f20691a, 3)) {
                        String str2 = f20691a;
                        Log.d(str2, "No valid color table found for frame #" + this.l);
                    }
                    this.p = 1;
                    return null;
                }
                if (gifFrame.f) {
                    System.arraycopy((Object) this.b, 0, (Object) this.f20692c, 0, this.b.length);
                    int[] iArr2 = this.f20692c;
                    this.b = iArr2;
                    iArr2[gifFrame.h] = 0;
                    if (gifFrame.g == 2 && this.l == 0) {
                        this.t = true;
                    }
                }
                return a(gifFrame, gifFrame2);
            }
            if (Log.isLoggable(f20691a, 3)) {
                String str3 = f20691a;
                Log.d(str3, "Unable to decode frame, status=" + this.p);
            }
            return null;
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void j() {
        this.m = null;
        byte[] bArr = this.j;
        if (bArr != null) {
            this.d.a(bArr);
        }
        int[] iArr = this.k;
        if (iArr != null) {
            this.d.a(iArr);
        }
        Bitmap bitmap = this.n;
        if (bitmap != null) {
            this.d.a(bitmap);
        }
        this.n = null;
        this.e = null;
        this.t = null;
        byte[] bArr2 = this.f;
        if (bArr2 != null) {
            this.d.a(bArr2);
        }
    }
}
