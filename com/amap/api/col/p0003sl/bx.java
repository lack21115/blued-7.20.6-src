package com.amap.api.col.p0003sl;

/* renamed from: com.amap.api.col.3sl.bx  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/bx.class */
public interface bx {

    /* renamed from: com.amap.api.col.3sl.bx$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/bx$a.class */
    public enum a {
        amap_exception(-1),
        network_exception(-1),
        file_io_exception(0),
        success_no_exception(1),
        cancel_no_exception(2);
        
        private int f;

        a(int i) {
            this.f = i;
        }
    }

    void a(long j, long j2);

    void a(a aVar);

    void m();

    void n();

    void o();
}
