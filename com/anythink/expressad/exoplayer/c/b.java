package com.anythink.expressad.exoplayer.c;

import android.media.MediaCodec;
import com.anythink.expressad.exoplayer.k.af;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/c/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f4382a;
    public byte[] b;

    /* renamed from: c  reason: collision with root package name */
    public int f4383c;
    public int[] d;
    public int[] e;
    public int f;
    public int g;
    public int h;
    private final MediaCodec.CryptoInfo i;
    private final a j;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/c/b$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final MediaCodec.CryptoInfo f4384a;
        private final MediaCodec.CryptoInfo.Pattern b;

        private a(MediaCodec.CryptoInfo cryptoInfo) {
            this.f4384a = cryptoInfo;
            this.b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        /* synthetic */ a(MediaCodec.CryptoInfo cryptoInfo, byte b) {
            this(cryptoInfo);
        }

        private void a(int i, int i2) {
            this.b.set(i, i2);
            this.f4384a.setPattern(this.b);
        }

        static /* synthetic */ void a(a aVar, int i, int i2) {
            aVar.b.set(i, i2);
            aVar.f4384a.setPattern(aVar.b);
        }
    }

    public b() {
        this.i = af.f4793a >= 16 ? new MediaCodec.CryptoInfo() : null;
        this.j = af.f4793a >= 24 ? new a(this.i, (byte) 0) : null;
    }

    private static MediaCodec.CryptoInfo b() {
        return new MediaCodec.CryptoInfo();
    }

    private void c() {
        this.i.numSubSamples = this.f;
        this.i.numBytesOfClearData = this.d;
        this.i.numBytesOfEncryptedData = this.e;
        this.i.key = this.b;
        this.i.iv = this.f4382a;
        this.i.mode = this.f4383c;
        if (af.f4793a >= 24) {
            a.a(this.j, this.g, this.h);
        }
    }

    public final MediaCodec.CryptoInfo a() {
        return this.i;
    }

    public final void a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.f = i;
        this.d = iArr;
        this.e = iArr2;
        this.b = bArr;
        this.f4382a = bArr2;
        this.f4383c = i2;
        this.g = i3;
        this.h = i4;
        if (af.f4793a >= 16) {
            this.i.numSubSamples = this.f;
            this.i.numBytesOfClearData = this.d;
            this.i.numBytesOfEncryptedData = this.e;
            this.i.key = this.b;
            this.i.iv = this.f4382a;
            this.i.mode = this.f4383c;
            if (af.f4793a >= 24) {
                a.a(this.j, this.g, this.h);
            }
        }
    }
}
