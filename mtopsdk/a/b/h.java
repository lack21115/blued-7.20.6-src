package mtopsdk.a.b;

import java.util.Map;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/a/b/h.class */
public final class h {

    /* renamed from: a */
    private b f43668a;
    private int b = -1;

    /* renamed from: c */
    private String f43669c;
    private Map d;
    private i e;

    public final g a() {
        if (this.f43668a != null) {
            return new g(this, (byte) 0);
        }
        throw new IllegalStateException("request == null");
    }

    public final h a(int i) {
        this.b = i;
        return this;
    }

    public final h a(String str) {
        this.f43669c = str;
        return this;
    }

    public final h a(Map map) {
        this.d = map;
        return this;
    }

    public final h a(b bVar) {
        this.f43668a = bVar;
        return this;
    }

    public final h a(i iVar) {
        this.e = iVar;
        return this;
    }
}
