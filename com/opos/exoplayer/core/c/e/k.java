package com.opos.exoplayer.core.c.e;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.e.b;
import com.opos.exoplayer.core.c.e.i;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.o;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/e/k.class */
final class k extends i {

    /* renamed from: a  reason: collision with root package name */
    private a f25179a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f25180c;
    private b.d d;
    private b.C0653b e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/e/k$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final b.d f25181a;
        public final b.C0653b b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f25182c;
        public final b.c[] d;
        public final int e;

        public a(b.d dVar, b.C0653b c0653b, byte[] bArr, b.c[] cVarArr, int i) {
            this.f25181a = dVar;
            this.b = c0653b;
            this.f25182c = bArr;
            this.d = cVarArr;
            this.e = i;
        }
    }

    static int a(byte b, int i, int i2) {
        return (b >> i2) & (255 >>> (8 - i));
    }

    private static int a(byte b, a aVar) {
        return !aVar.d[a(b, aVar.e, 1)].f25158a ? aVar.f25181a.g : aVar.f25181a.h;
    }

    static void a(m mVar, long j) {
        mVar.b(mVar.c() + 4);
        mVar.f25496a[mVar.c() - 4] = (byte) (j & 255);
        mVar.f25496a[mVar.c() - 3] = (byte) ((j >>> 8) & 255);
        mVar.f25496a[mVar.c() - 2] = (byte) ((j >>> 16) & 255);
        mVar.f25496a[mVar.c() - 1] = (byte) ((j >>> 24) & 255);
    }

    public static boolean a(m mVar) {
        try {
            return b.a(1, mVar, true);
        } catch (o e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.c.e.i
    public void a(boolean z) {
        super.a(z);
        if (z) {
            this.f25179a = null;
            this.d = null;
            this.e = null;
        }
        this.b = 0;
        this.f25180c = false;
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected boolean a(m mVar, long j, i.a aVar) {
        if (this.f25179a != null) {
            return false;
        }
        a c2 = c(mVar);
        this.f25179a = c2;
        if (c2 == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f25179a.f25181a.j);
        arrayList.add(this.f25179a.f25182c);
        aVar.f25176a = Format.a(null, "audio/vorbis", null, this.f25179a.f25181a.e, -1, this.f25179a.f25181a.b, (int) this.f25179a.f25181a.f25161c, arrayList, null, 0, null);
        return true;
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected long b(m mVar) {
        int i = 0;
        if ((mVar.f25496a[0] & 1) == 1) {
            return -1L;
        }
        int a2 = a(mVar.f25496a[0], this.f25179a);
        if (this.f25180c) {
            i = (this.b + a2) / 4;
        }
        long j = i;
        a(mVar, j);
        this.f25180c = true;
        this.b = a2;
        return j;
    }

    a c(m mVar) {
        if (this.d == null) {
            this.d = b.a(mVar);
            return null;
        } else if (this.e == null) {
            this.e = b.b(mVar);
            return null;
        } else {
            byte[] bArr = new byte[mVar.c()];
            System.arraycopy((Object) mVar.f25496a, 0, (Object) bArr, 0, mVar.c());
            b.c[] a2 = b.a(mVar, this.d.b);
            return new a(this.d, this.e, bArr, a2, b.a(a2.length - 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.c.e.i
    public void c(long j) {
        super.c(j);
        int i = 0;
        this.f25180c = j != 0;
        b.d dVar = this.d;
        if (dVar != null) {
            i = dVar.g;
        }
        this.b = i;
    }
}
