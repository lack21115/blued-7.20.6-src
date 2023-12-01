package com.amap.api.col.p0003sl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* renamed from: com.amap.api.col.3sl.km  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/km.class */
public final class km extends ks {

    /* renamed from: a  reason: collision with root package name */
    ByteArrayOutputStream f5282a;

    public km() {
        this.f5282a = new ByteArrayOutputStream();
    }

    public km(ks ksVar) {
        super(ksVar);
        this.f5282a = new ByteArrayOutputStream();
    }

    @Override // com.amap.api.col.p0003sl.ks
    protected final byte[] a(byte[] bArr) {
        byte[] byteArray = this.f5282a.toByteArray();
        try {
            this.f5282a.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f5282a = new ByteArrayOutputStream();
        return byteArray;
    }

    @Override // com.amap.api.col.p0003sl.ks
    public final void b(byte[] bArr) {
        try {
            this.f5282a.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
