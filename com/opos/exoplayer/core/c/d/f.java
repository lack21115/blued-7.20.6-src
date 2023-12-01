package com.opos.exoplayer.core.c.d;

import com.opos.exoplayer.core.c.n;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/d/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f11438a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final n.a f11439c;
    public final int d;
    public final byte[] e;

    public f(boolean z, String str, int i, byte[] bArr, int i2, int i3, byte[] bArr2) {
        com.opos.exoplayer.core.i.a.a((bArr2 == null) ^ (i == 0));
        this.f11438a = z;
        this.b = str;
        this.d = i;
        this.e = bArr2;
        this.f11439c = new n.a(a(str), bArr, i2, i3);
    }

    private static int a(String str) {
        int i;
        if (str != null) {
            boolean z = true;
            switch (str.hashCode()) {
                case 3046605:
                    if (str.equals(com.anythink.expressad.exoplayer.b.be)) {
                        z = true;
                        break;
                    }
                    break;
                case 3046671:
                    if (str.equals(com.anythink.expressad.exoplayer.b.bg)) {
                        z = true;
                        break;
                    }
                    break;
                case 3049879:
                    if (str.equals(com.anythink.expressad.exoplayer.b.bd)) {
                        z = false;
                        break;
                    }
                    break;
                case 3049895:
                    if (str.equals(com.anythink.expressad.exoplayer.b.bf)) {
                        z = true;
                        break;
                    }
                    break;
            }
            if (z && !z) {
                i = 2;
                if (!z) {
                    i = 2;
                    if (!z) {
                        com.opos.cmn.an.f.a.c("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
                    }
                }
                return i;
            }
        }
        i = 1;
        return i;
    }
}
