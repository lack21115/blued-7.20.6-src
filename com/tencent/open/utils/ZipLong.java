package com.tencent.open.utils;

import android.text.Spanned;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/utils/ZipLong.class */
public final class ZipLong implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private long f38291a;

    public ZipLong(long j) {
        this.f38291a = j;
    }

    public ZipLong(byte[] bArr) {
        this(bArr, 0);
    }

    public ZipLong(byte[] bArr, int i) {
        long j = (bArr[i + 3] << 24) & 4278190080L;
        this.f38291a = j;
        long j2 = j + ((bArr[i + 2] << 16) & Spanned.SPAN_PRIORITY);
        this.f38291a = j2;
        long j3 = j2 + ((bArr[i + 1] << 8) & 65280);
        this.f38291a = j3;
        this.f38291a = j3 + (bArr[i] & 255);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            if (!(obj instanceof ZipLong)) {
                return false;
            }
            z = false;
            if (this.f38291a == ((ZipLong) obj).getValue()) {
                z = true;
            }
        }
        return z;
    }

    public byte[] getBytes() {
        long j = this.f38291a;
        return new byte[]{(byte) (255 & j), (byte) ((65280 & j) >> 8), (byte) ((16711680 & j) >> 16), (byte) ((j & 4278190080L) >> 24)};
    }

    public long getValue() {
        return this.f38291a;
    }

    public int hashCode() {
        return (int) this.f38291a;
    }
}
