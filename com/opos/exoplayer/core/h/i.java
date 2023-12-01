package com.opos.exoplayer.core.h;

import android.net.Uri;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/i.class */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f11761a;
    public final byte[] b;

    /* renamed from: c  reason: collision with root package name */
    public final long f11762c;
    public final long d;
    public final long e;
    public final String f;
    public final int g;

    public i(Uri uri, long j, long j2, long j3, String str, int i) {
        this(uri, null, j, j2, j3, str, i);
    }

    public i(Uri uri, long j, long j2, String str) {
        this(uri, j, j, j2, str, 0);
    }

    public i(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i) {
        com.opos.exoplayer.core.i.a.a(j >= 0);
        com.opos.exoplayer.core.i.a.a(j2 >= 0);
        com.opos.exoplayer.core.i.a.a(j3 <= 0 ? j3 == -1 : true);
        this.f11761a = uri;
        this.b = bArr;
        this.f11762c = j;
        this.d = j2;
        this.e = j3;
        this.f = str;
        this.g = i;
    }

    public boolean a(int i) {
        return (this.g & i) == i;
    }

    public String toString() {
        return "DataSpec[" + this.f11761a + ", " + Arrays.toString(this.b) + ", " + this.f11762c + ", " + this.d + ", " + this.e + ", " + this.f + ", " + this.g + "]";
    }
}
