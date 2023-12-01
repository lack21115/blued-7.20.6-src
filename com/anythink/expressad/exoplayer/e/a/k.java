package com.anythink.expressad.exoplayer.e.a;

import android.util.Log;
import com.anythink.expressad.exoplayer.e.m;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/a/k.class */
public final class k {
    private static final String f = "TrackEncryptionBox";

    /* renamed from: a  reason: collision with root package name */
    public final boolean f4467a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final m.a f4468c;
    public final int d;
    public final byte[] e;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public k(boolean z, String str, int i, byte[] bArr, int i2, int i3, byte[] bArr2) {
        boolean z2;
        int i4;
        com.anythink.expressad.exoplayer.k.a.a((i == 0) ^ (bArr2 == null));
        this.f4467a = z;
        this.b = str;
        this.d = i;
        this.e = bArr2;
        if (str == null) {
            i4 = 1;
        } else {
            switch (str.hashCode()) {
                case 3046605:
                    if (str.equals(com.anythink.expressad.exoplayer.b.be)) {
                        z2 = true;
                        break;
                    }
                    z2 = true;
                    break;
                case 3046671:
                    if (str.equals(com.anythink.expressad.exoplayer.b.bg)) {
                        z2 = true;
                        break;
                    }
                    z2 = true;
                    break;
                case 3049879:
                    if (str.equals(com.anythink.expressad.exoplayer.b.bd)) {
                        z2 = false;
                        break;
                    }
                    z2 = true;
                    break;
                case 3049895:
                    if (str.equals(com.anythink.expressad.exoplayer.b.bf)) {
                        z2 = true;
                        break;
                    }
                    z2 = true;
                    break;
                default:
                    z2 = true;
                    break;
            }
            i4 = 1;
            if (z2) {
                i4 = 1;
                if (!z2) {
                    if (z2 || z2) {
                        i4 = 2;
                    } else {
                        Log.w(f, "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
                        i4 = 1;
                    }
                }
            }
        }
        this.f4468c = new m.a(i4, bArr, i2, i3);
    }

    private static int a(String str) {
        if (str == null) {
            return 1;
        }
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
        if (!z || z) {
            return 1;
        }
        if (z || z) {
            return 2;
        }
        Log.w(f, "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
        return 1;
    }
}
