package com.opos.exoplayer.core.c.f;

import android.util.SparseArray;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/u.class */
public interface u {

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/u$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f11543a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f11544c;

        public a(String str, int i, byte[] bArr) {
            this.f11543a = str;
            this.b = i;
            this.f11544c = bArr;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/u$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f11545a;
        public final String b;

        /* renamed from: c  reason: collision with root package name */
        public final List<a> f11546c;
        public final byte[] d;

        public b(int i, String str, List<a> list, byte[] bArr) {
            this.f11545a = i;
            this.b = str;
            this.f11546c = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.d = bArr;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/u$c.class */
    public interface c {
        SparseArray<u> a();

        u a(int i, b bVar);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/u$d.class */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final String f11547a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final int f11548c;
        private int d;
        private String e;

        public d(int i, int i2) {
            this(Integer.MIN_VALUE, i, i2);
        }

        public d(int i, int i2, int i3) {
            String str;
            if (i != Integer.MIN_VALUE) {
                str = i + "/";
            } else {
                str = "";
            }
            this.f11547a = str;
            this.b = i2;
            this.f11548c = i3;
            this.d = Integer.MIN_VALUE;
        }

        private void d() {
            if (this.d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public void a() {
            int i = this.d;
            this.d = i == Integer.MIN_VALUE ? this.b : i + this.f11548c;
            this.e = this.f11547a + this.d;
        }

        public int b() {
            d();
            return this.d;
        }

        public String c() {
            d();
            return this.e;
        }
    }

    void a();

    void a(com.opos.exoplayer.core.i.m mVar, boolean z);

    void a(com.opos.exoplayer.core.i.s sVar, com.opos.exoplayer.core.c.g gVar, d dVar);
}
