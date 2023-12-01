package com.opos.exoplayer.core.b;

import android.media.MediaCodec;
import com.opos.exoplayer.core.i.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/b/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f25068a;
    public byte[] b;

    /* renamed from: c  reason: collision with root package name */
    public int f25069c;
    public int[] d;
    public int[] e;
    public int f;
    public int g;
    public int h;
    private final MediaCodec.CryptoInfo i;
    private final a j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/b/b$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final MediaCodec.CryptoInfo f25070a;
        private final MediaCodec.CryptoInfo.Pattern b;

        private a(MediaCodec.CryptoInfo cryptoInfo) {
            this.f25070a = cryptoInfo;
            this.b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2) {
            this.b.set(i, i2);
            this.f25070a.setPattern(this.b);
        }
    }

    public b() {
        this.i = u.f25510a >= 16 ? b() : null;
        this.j = u.f25510a >= 24 ? new a(this.i) : null;
    }

    private MediaCodec.CryptoInfo b() {
        return new MediaCodec.CryptoInfo();
    }

    private void c() {
        this.i.numSubSamples = this.f;
        this.i.numBytesOfClearData = this.d;
        this.i.numBytesOfEncryptedData = this.e;
        this.i.key = this.b;
        this.i.iv = this.f25068a;
        this.i.mode = this.f25069c;
        if (u.f25510a >= 24) {
            this.j.a(this.g, this.h);
        }
    }

    public MediaCodec.CryptoInfo a() {
        return this.i;
    }

    public void a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.f = i;
        this.d = iArr;
        this.e = iArr2;
        this.b = bArr;
        this.f25068a = bArr2;
        this.f25069c = i2;
        this.g = i3;
        this.h = i4;
        if (u.f25510a >= 16) {
            c();
        }
    }
}
