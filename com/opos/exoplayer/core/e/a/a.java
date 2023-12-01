package com.opos.exoplayer.core.e.a;

import android.net.Uri;
import com.anythink.expressad.exoplayer.b;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/e/a/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f11588a = new a(new long[0]);
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f11589c;
    public final C0488a[] d;
    public final long e;
    public final long f;

    /* renamed from: com.opos.exoplayer.core.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/e/a/a$a.class */
    public static final class C0488a {

        /* renamed from: a  reason: collision with root package name */
        public final int f11592a;
        public final Uri[] b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f11593c;
        public final long[] d;

        public C0488a() {
            this(-1, new int[0], new Uri[0], new long[0]);
        }

        private C0488a(int i, int[] iArr, Uri[] uriArr, long[] jArr) {
            com.opos.exoplayer.core.i.a.a(iArr.length == uriArr.length);
            this.f11592a = i;
            this.f11593c = iArr;
            this.b = uriArr;
            this.d = jArr;
        }

        public int a() {
            return a(-1);
        }

        public int a(int i) {
            while (true) {
                i++;
                int[] iArr = this.f11593c;
                if (i >= iArr.length || iArr[i] == 0) {
                    break;
                } else if (iArr[i] == 1) {
                    return i;
                }
            }
            return i;
        }

        public boolean b() {
            return this.f11592a == -1 || a() < this.f11592a;
        }
    }

    public a(long... jArr) {
        int length = jArr.length;
        this.b = length;
        this.f11589c = Arrays.copyOf(jArr, length);
        this.d = new C0488a[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.e = 0L;
                this.f = b.b;
                return;
            }
            this.d[i2] = new C0488a();
            i = i2 + 1;
        }
    }

    public int a(long j) {
        int i;
        int length = this.f11589c.length;
        while (true) {
            i = length - 1;
            if (i < 0) {
                break;
            }
            long[] jArr = this.f11589c;
            if (jArr[i] != Long.MIN_VALUE && jArr[i] <= j) {
                break;
            }
            length = i;
        }
        if (i < 0 || !this.d[i].b()) {
            return -1;
        }
        return i;
    }

    public int b(long j) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            long[] jArr = this.f11589c;
            if (i >= jArr.length || jArr[i] == Long.MIN_VALUE || (j < jArr[i] && this.d[i].b())) {
                break;
            }
            i2 = i + 1;
        }
        if (i < this.f11589c.length) {
            return i;
        }
        return -1;
    }
}
