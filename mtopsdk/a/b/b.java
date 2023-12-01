package mtopsdk.a.b;

import java.util.Map;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/a/b/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f43659a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f43660c;
    private final d d;
    private final String e;
    private final int f;
    private final int g;
    private final int h;

    private b(c cVar) {
        this.f43659a = c.a(cVar);
        this.b = c.b(cVar);
        this.f43660c = c.c(cVar);
        this.d = c.d(cVar);
        this.e = c.e(cVar);
        this.f = c.f(cVar);
        this.g = c.g(cVar);
        this.h = c.h(cVar);
        c.i(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(c cVar, byte b) {
        this(cVar);
    }

    public final String a() {
        return this.f43659a;
    }

    public final String b() {
        return this.b;
    }

    public final Map c() {
        return this.f43660c;
    }

    public final d d() {
        return this.d;
    }

    public final int e() {
        return this.f;
    }

    public final int f() {
        return this.g;
    }

    public final int g() {
        return this.h;
    }

    public final String toString() {
        return "Request{body=" + this.d + ", url='" + this.f43659a + "', method='" + this.b + "', headers=" + this.f43660c + ", seqNo='" + this.e + "', connectTimeoutMills=" + this.f + ", readTimeoutMills=" + this.g + ", retryTimes=" + this.h + '}';
    }
}
