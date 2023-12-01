package com.anythink.expressad.exoplayer.j;

import android.net.Uri;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/k.class */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final int f7583a = 1;
    public static final int b = 2;

    /* renamed from: c  reason: collision with root package name */
    public final Uri f7584c;
    public final byte[] d;
    public final long e;
    public final long f;
    public final long g;
    public final String h;
    public final int i;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/k$a.class */
    public @interface a {
    }

    public k(Uri uri) {
        this(uri, 0);
    }

    public k(Uri uri, int i) {
        this(uri, 0L, -1L, null, i);
    }

    public k(Uri uri, long j, long j2, long j3, String str, int i) {
        this(uri, null, j, j2, j3, str, i);
    }

    public k(Uri uri, long j, long j2, String str, int i) {
        this(uri, j, j, j2, str, i);
    }

    public k(Uri uri, long j, String str) {
        this(uri, j, j, -1L, str, 0);
    }

    public k(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i) {
        com.anythink.expressad.exoplayer.k.a.a(j >= 0);
        com.anythink.expressad.exoplayer.k.a.a(j2 >= 0);
        com.anythink.expressad.exoplayer.k.a.a(j3 <= 0 ? j3 == -1 : true);
        this.f7584c = uri;
        this.d = bArr;
        this.e = j;
        this.f = j2;
        this.g = j3;
        this.h = str;
        this.i = i;
    }

    private k a(long j, long j2) {
        return (j == 0 && this.g == j2) ? this : new k(this.f7584c, this.d, this.e + j, this.f + j, j2, this.h, this.i);
    }

    private k a(Uri uri) {
        return new k(uri, this.d, this.e, this.f, this.g, this.h, this.i);
    }

    public final k a(long j) {
        long j2 = this.g;
        long j3 = -1;
        if (j2 != -1) {
            j3 = j2 - j;
        }
        return (j == 0 && this.g == j3) ? this : new k(this.f7584c, this.d, this.e + j, this.f + j, j3, this.h, this.i);
    }

    public final boolean a(int i) {
        return (this.i & i) == i;
    }

    public final String toString() {
        return "DataSpec[" + this.f7584c + ", " + Arrays.toString(this.d) + ", " + this.e + ", " + this.f + ", " + this.g + ", " + this.h + ", " + this.i + "]";
    }
}
