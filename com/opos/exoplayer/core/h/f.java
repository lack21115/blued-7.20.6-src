package com.opos.exoplayer.core.h;

import android.net.Uri;
import android.util.Base64;
import java.net.URLDecoder;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/f.class */
public final class f implements g {

    /* renamed from: a  reason: collision with root package name */
    private i f25446a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f25447c;

    @Override // com.opos.exoplayer.core.h.g
    public int a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int length = this.f25447c.length - this.b;
        if (length == 0) {
            return -1;
        }
        int min = Math.min(i2, length);
        System.arraycopy((Object) this.f25447c, this.b, (Object) bArr, i, min);
        this.b += min;
        return min;
    }

    @Override // com.opos.exoplayer.core.h.g
    public long a(i iVar) {
        this.f25446a = iVar;
        Uri uri = iVar.f25449a;
        String scheme = uri.getScheme();
        if (!"data".equals(scheme)) {
            throw new com.opos.exoplayer.core.o("Unsupported scheme: " + scheme);
        }
        String[] split = uri.getSchemeSpecificPart().split(",");
        if (split.length > 2) {
            throw new com.opos.exoplayer.core.o("Unexpected URI format: " + uri);
        }
        String str = split[1];
        if (split[0].contains(";base64")) {
            try {
                this.f25447c = Base64.decode(str, 0);
            } catch (IllegalArgumentException e) {
                throw new com.opos.exoplayer.core.o("Error while parsing Base64 encoded string: " + str, e);
            }
        } else {
            this.f25447c = URLDecoder.decode(str, "US-ASCII").getBytes();
        }
        return this.f25447c.length;
    }

    @Override // com.opos.exoplayer.core.h.g
    public Uri a() {
        i iVar = this.f25446a;
        if (iVar != null) {
            return iVar.f25449a;
        }
        return null;
    }

    @Override // com.opos.exoplayer.core.h.g
    public void b() {
        this.f25446a = null;
        this.f25447c = null;
    }
}
