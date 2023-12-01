package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.services.core.AMapException;

/* renamed from: com.amap.api.col.3sl.fq  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fq.class */
public final class fq extends ex<String, Integer> {
    private Context k;
    private String l;

    public fq(Context context, String str) {
        super(context, str);
        this.k = context;
        this.l = str;
    }

    private static Integer f() throws AMapException {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew
    public final /* synthetic */ Object a(String str) throws AMapException {
        return f();
    }

    @Override // com.amap.api.col.p0003sl.ex, com.amap.api.col.p0003sl.ew
    protected final String c() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(ho.f(this.k));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.l);
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getURL() {
        return fd.d() + "/nearby/data/delete";
    }
}
