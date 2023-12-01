package com.anythink.expressad.exoplayer.j;

import android.net.Uri;
import android.util.Base64;
import com.anythink.expressad.exoplayer.k.af;
import java.net.URLDecoder;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/f.class */
public final class f implements h {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4739a = "data";
    private k b;

    /* renamed from: c  reason: collision with root package name */
    private int f4740c;
    private byte[] d;

    @Override // com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int length = this.d.length - this.f4740c;
        if (length == 0) {
            return -1;
        }
        int min = Math.min(i2, length);
        System.arraycopy(this.d, this.f4740c, bArr, i, min);
        this.f4740c += min;
        return min;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final long a(k kVar) {
        this.b = kVar;
        Uri uri = kVar.f4745c;
        String scheme = uri.getScheme();
        if ("data".equals(scheme)) {
            String[] a2 = af.a(uri.getSchemeSpecificPart(), ",");
            if (a2.length == 2) {
                String str = a2[1];
                if (a2[0].contains(";base64")) {
                    try {
                        this.d = Base64.decode(str, 0);
                    } catch (IllegalArgumentException e) {
                        throw new com.anythink.expressad.exoplayer.t("Error while parsing Base64 encoded string: ".concat(String.valueOf(str)), e);
                    }
                } else {
                    this.d = URLDecoder.decode(str, com.anythink.expressad.exoplayer.b.i).getBytes();
                }
                return this.d.length;
            }
            throw new com.anythink.expressad.exoplayer.t("Unexpected URI format: ".concat(String.valueOf(uri)));
        }
        throw new com.anythink.expressad.exoplayer.t("Unsupported scheme: ".concat(String.valueOf(scheme)));
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final Uri a() {
        k kVar = this.b;
        if (kVar != null) {
            return kVar.f4745c;
        }
        return null;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final void b() {
        this.b = null;
        this.d = null;
    }
}
