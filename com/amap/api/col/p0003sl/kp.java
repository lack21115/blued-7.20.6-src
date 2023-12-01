package com.amap.api.col.p0003sl;

/* renamed from: com.amap.api.col.3sl.kp  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/kp.class */
public final class kp extends ks {
    private StringBuilder a;
    private boolean b;

    public kp() {
        this.a = new StringBuilder();
        this.b = true;
    }

    public kp(ks ksVar) {
        super(ksVar);
        this.a = new StringBuilder();
        this.b = true;
    }

    @Override // com.amap.api.col.p0003sl.ks
    protected final byte[] a(byte[] bArr) {
        byte[] a = ib.a(this.a.toString());
        this.d = a;
        this.b = true;
        StringBuilder sb = this.a;
        sb.delete(0, sb.length());
        return a;
    }

    @Override // com.amap.api.col.p0003sl.ks
    public final void b(byte[] bArr) {
        String a = ib.a(bArr);
        if (this.b) {
            this.b = false;
        } else {
            this.a.append(",");
        }
        StringBuilder sb = this.a;
        sb.append("{\"log\":\"");
        sb.append(a);
        sb.append("\"}");
    }
}
