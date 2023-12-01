package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/w8.class */
public class w8 extends z8 {
    private a M;
    private long N;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/w8$a.class */
    public interface a {
        void a(w8 w8Var, long j, long j2);
    }

    public w8() {
        super(null);
        this.N = -1L;
    }

    @Override // com.tencent.mapsdk.internal.z8
    public void a(float f) {
    }

    public void a(a aVar) {
        this.M = aVar;
    }

    @Override // com.tencent.mapsdk.internal.z8
    public boolean c(long j) {
        long j2 = 0;
        if (this.j == 0) {
            this.j = 1;
            long j3 = this.d;
            if (j3 < 0) {
                this.f24456c = j;
            } else {
                this.f24456c = j - j3;
                this.d = -1L;
            }
        }
        a aVar = this.M;
        if (aVar != null) {
            long j4 = this.f24456c;
            long j5 = this.N;
            if (j5 >= 0) {
                j2 = j - j5;
            }
            this.N = j;
            aVar.a(this, j - j4, j2);
            return false;
        }
        return false;
    }
}
