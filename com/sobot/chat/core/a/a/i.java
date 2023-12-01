package com.sobot.chat.core.a.a;

import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/a/a/i.class */
public class i {
    private i b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f28213c;
    private c d;
    private byte[] e;
    private int f;
    private boolean g;
    private long h;
    private boolean i;
    private byte[] k;
    private int l;
    private b m;
    private byte[] n;
    private int o;
    private boolean p;
    private long q;
    private boolean r;

    /* renamed from: a  reason: collision with root package name */
    final i f28212a = this;
    private a j = a.Manually;

    /* renamed from: com.sobot.chat.core.a.a.i$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/a/a/i$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28214a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[a.values().length];
            f28214a = iArr;
            try {
                iArr[a.Manually.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f28214a[a.AutoReadToTrailer.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f28214a[a.AutoReadByLength.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/a/a/i$a.class */
    public enum a {
        Manually,
        AutoReadToTrailer,
        AutoReadByLength
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/a/a/i$b.class */
    public interface b {
        int a(i iVar, byte[] bArr);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/a/a/i$c.class */
    public interface c {
        byte[] a(i iVar, int i);
    }

    public int a(byte[] bArr) {
        if (k() != a.AutoReadByLength || n() == null) {
            return 0;
        }
        return n().a(c(), bArr);
    }

    public i a() {
        i iVar = new i();
        iVar.a(this);
        iVar.b(d());
        iVar.a(e());
        iVar.c(f());
        iVar.b(g());
        iVar.a(h());
        iVar.a(i());
        iVar.b(j());
        iVar.a(k());
        iVar.d(l());
        iVar.c(m());
        iVar.a(n());
        iVar.e(o());
        iVar.d(p());
        iVar.c(q());
        iVar.b(r());
        iVar.d(s());
        return iVar;
    }

    public i a(long j) {
        this.h = j;
        return this;
    }

    public i a(a aVar) {
        this.j = aVar;
        return this;
    }

    public i a(b bVar) {
        this.m = bVar;
        return this;
    }

    public i a(c cVar) {
        this.d = cVar;
        return this;
    }

    protected i a(i iVar) {
        this.b = iVar;
        return this;
    }

    public i a(boolean z) {
        this.g = z;
        return this;
    }

    public byte[] a(int i) {
        if (e() != null) {
            return e().a(c(), i);
        }
        return null;
    }

    public i b(int i) {
        this.f = i;
        return this;
    }

    public i b(long j) {
        this.q = j;
        return this;
    }

    public i b(boolean z) {
        this.i = z;
        return this;
    }

    public i b(byte[] bArr) {
        if (bArr != null) {
            this.f28213c = Arrays.copyOf(bArr, bArr.length);
            return this;
        }
        this.f28213c = null;
        return this;
    }

    public void b() {
        int i = AnonymousClass1.f28214a[k().ordinal()];
        if (i != 1) {
            if (i == 2) {
                if (o() == null || o().length <= 0) {
                    throw new IllegalArgumentException("we need ReceiveTrailerData for AutoReadToTrailer");
                }
            } else if (i != 3) {
                throw new IllegalArgumentException("we need a correct ReadStrategy");
            } else {
                if (m() <= 0 || n() == null) {
                    throw new IllegalArgumentException("we need ReceivePacketLengthDataLength and ReceivePacketDataLengthConvertor for AutoReadByLength");
                }
            }
        }
    }

    public i c() {
        i iVar = this.b;
        return iVar == null ? this : iVar;
    }

    public i c(int i) {
        this.l = i;
        return this;
    }

    public i c(boolean z) {
        this.p = z;
        return this;
    }

    public i c(byte[] bArr) {
        if (bArr != null) {
            this.e = Arrays.copyOf(bArr, bArr.length);
            return this;
        }
        this.e = null;
        return this;
    }

    public i d(int i) {
        this.o = i;
        return this;
    }

    public i d(boolean z) {
        this.r = z;
        return this;
    }

    public i d(byte[] bArr) {
        if (bArr != null) {
            this.k = Arrays.copyOf(bArr, bArr.length);
            return this;
        }
        this.k = null;
        return this;
    }

    public byte[] d() {
        return this.f28213c;
    }

    public c e() {
        return this.d;
    }

    public i e(byte[] bArr) {
        if (bArr != null) {
            this.n = Arrays.copyOf(bArr, bArr.length);
            return this;
        }
        this.n = null;
        return this;
    }

    public byte[] f() {
        return this.e;
    }

    public int g() {
        return this.f;
    }

    public boolean h() {
        if (g() <= 0) {
            return false;
        }
        return this.g;
    }

    public long i() {
        return this.h;
    }

    public boolean j() {
        return this.i;
    }

    public a k() {
        return this.j;
    }

    public byte[] l() {
        return this.k;
    }

    public int m() {
        return this.l;
    }

    public b n() {
        return this.m;
    }

    public byte[] o() {
        return this.n;
    }

    public int p() {
        return this.o;
    }

    public boolean q() {
        if (p() <= 0) {
            return false;
        }
        return this.p;
    }

    public long r() {
        return this.q;
    }

    public boolean s() {
        return this.r;
    }
}
