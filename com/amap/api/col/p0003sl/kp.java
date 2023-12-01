package com.amap.api.col.p0003sl;

/* renamed from: com.amap.api.col.3sl.kp  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/kp.class */
public final class kp extends ks {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f5285a;
    private boolean b;

    public kp() {
        this.f5285a = new StringBuilder();
        this.b = true;
    }

    public kp(ks ksVar) {
        super(ksVar);
        this.f5285a = new StringBuilder();
        this.b = true;
    }

    @Override // com.amap.api.col.p0003sl.ks
    protected final byte[] a(byte[] bArr) {
        byte[] a2 = ib.a(this.f5285a.toString());
        this.d = a2;
        this.b = true;
        StringBuilder sb = this.f5285a;
        sb.delete(0, sb.length());
        return a2;
    }

    @Override // com.amap.api.col.p0003sl.ks
    public final void b(byte[] bArr) {
        String a2 = ib.a(bArr);
        if (this.b) {
            this.b = false;
        } else {
            this.f5285a.append(",");
        }
        StringBuilder sb = this.f5285a;
        sb.append("{\"log\":\"");
        sb.append(a2);
        sb.append("\"}");
    }
}
