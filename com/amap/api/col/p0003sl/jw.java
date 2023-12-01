package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.kb;

/* renamed from: com.amap.api.col.3sl.jw  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jw.class */
public class jw {

    /* renamed from: a  reason: collision with root package name */
    private jy f5233a;
    private kb b;

    /* renamed from: c  reason: collision with root package name */
    private long f5234c;
    private long d;

    /* renamed from: com.amap.api.col.3sl.jw$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jw$a.class */
    public interface a {
        void onDownload(byte[] bArr, long j);

        void onException(Throwable th);

        void onFinish();

        void onStop();
    }

    public jw(kb kbVar) {
        this(kbVar, (byte) 0);
    }

    private jw(kb kbVar, byte b) {
        this(kbVar, 0L, -1L, false);
    }

    public jw(kb kbVar, long j, long j2, boolean z) {
        this.b = kbVar;
        this.f5234c = j;
        this.d = j2;
        kbVar.setHttpProtocol(z ? kb.c.HTTPS : kb.c.HTTP);
        this.b.setDegradeAbility(kb.a.SINGLE);
    }

    public final void a() {
        jy jyVar = this.f5233a;
        if (jyVar != null) {
            jyVar.a();
        }
    }

    public final void a(a aVar) {
        try {
            jy jyVar = new jy();
            this.f5233a = jyVar;
            jyVar.b(this.d);
            this.f5233a.a(this.f5234c);
            ju.a();
            if (ju.b(this.b)) {
                this.b.setDegradeType(kb.b.NEVER_GRADE);
                this.f5233a.a(this.b, aVar);
                return;
            }
            this.b.setDegradeType(kb.b.DEGRADE_ONLY);
            this.f5233a.a(this.b, aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
