package com.tencent.liteav.videoconsumer.renderer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    protected long f36820a = 0;
    protected long b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected long f36821c = 0;
    protected long d = 0;
    protected long e = 0;
    protected final long f = Math.max(200L, 200L);
    private a g;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/e$a.class */
    public interface a {
        void a(long j);
    }

    public e(a aVar) {
        this.g = aVar;
    }

    public final void a(long j) {
        if (j == 0) {
            this.e = 0L;
            return;
        }
        long j2 = this.e;
        if (j2 != 0) {
            long j3 = j - j2;
            if (j3 > this.f) {
                this.b++;
                a aVar = this.g;
                if (aVar != null) {
                    aVar.a(j3);
                }
                this.f36821c += j3;
                if (this.f36820a < j3) {
                    this.f36820a = j3;
                }
                long j4 = this.b;
                if (j4 != 0) {
                    this.d = this.f36821c / j4;
                }
            }
        }
        this.e = j;
    }
}
