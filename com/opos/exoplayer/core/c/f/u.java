package com.opos.exoplayer.core.c.f;

import android.util.SparseArray;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/u.class */
public interface u {

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/u$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f25231a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f25232c;

        public a(String str, int i, byte[] bArr) {
            this.f25231a = str;
            this.b = i;
            this.f25232c = bArr;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/u$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f25233a;
        public final String b;

        /* renamed from: c  reason: collision with root package name */
        public final List<a> f25234c;
        public final byte[] d;

        public b(int i, String str, List<a> list, byte[] bArr) {
            this.f25233a = i;
            this.b = str;
            this.f25234c = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
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
        private final String f25235a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final int f25236c;
        private int d;
        private String e;

        public d(int i, int i2) {
            this(Integer.MIN_VALUE, i, i2);
        }

        public d(int i, int i2, int i3) {
            String str;
            if (i != Integer.MIN_VALUE) {
                str = i + BridgeUtil.SPLIT_MARK;
            } else {
                str = "";
            }
            this.f25235a = str;
            this.b = i2;
            this.f25236c = i3;
            this.d = Integer.MIN_VALUE;
        }

        private void d() {
            if (this.d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public void a() {
            int i = this.d;
            this.d = i == Integer.MIN_VALUE ? this.b : i + this.f25236c;
            this.e = this.f25235a + this.d;
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
