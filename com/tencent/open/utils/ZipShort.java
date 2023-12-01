package com.tencent.open.utils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/utils/ZipShort.class */
public final class ZipShort implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private int f38292a;

    public ZipShort(int i) {
        this.f38292a = i;
    }

    public ZipShort(byte[] bArr) {
        this(bArr, 0);
    }

    public ZipShort(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] << 8) & 65280;
        this.f38292a = i2;
        this.f38292a = i2 + (bArr[i] & 255);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            if (!(obj instanceof ZipShort)) {
                return false;
            }
            z = false;
            if (this.f38292a == ((ZipShort) obj).getValue()) {
                z = true;
            }
        }
        return z;
    }

    public byte[] getBytes() {
        int i = this.f38292a;
        return new byte[]{(byte) (i & 255), (byte) ((i & 65280) >> 8)};
    }

    public int getValue() {
        return this.f38292a;
    }

    public int hashCode() {
        return this.f38292a;
    }
}
