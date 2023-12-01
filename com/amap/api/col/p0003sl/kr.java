package com.amap.api.col.p0003sl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* renamed from: com.amap.api.col.3sl.kr  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/kr.class */
public final class kr extends ks {
    public kr() {
    }

    public kr(ks ksVar) {
        super(ksVar);
    }

    @Override // com.amap.api.col.p0003sl.ks
    protected final byte[] a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
        stringBuffer.append(" ");
        stringBuffer.append(UUID.randomUUID().toString());
        stringBuffer.append(" ");
        if (stringBuffer.length() != 53) {
            return new byte[0];
        }
        byte[] a = ib.a(stringBuffer.toString());
        byte[] bArr2 = new byte[a.length + bArr.length];
        System.arraycopy((Object) a, 0, (Object) bArr2, 0, a.length);
        System.arraycopy((Object) bArr, 0, (Object) bArr2, a.length, bArr.length);
        return bArr2;
    }
}
