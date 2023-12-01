package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.UploadInfo;

/* renamed from: com.amap.api.col.3sl.fs  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fs.class */
public final class fs extends ex<UploadInfo, Integer> {
    private Context k;
    private UploadInfo l;

    public fs(Context context, UploadInfo uploadInfo) {
        super(context, uploadInfo);
        this.k = context;
        this.l = uploadInfo;
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
        stringBuffer.append(this.l.getUserID());
        LatLonPoint point = this.l.getPoint();
        int longitude = (int) (point.getLongitude() * 1000000.0d);
        stringBuffer.append("&location=");
        stringBuffer.append(longitude / 1000000.0f);
        stringBuffer.append(",");
        stringBuffer.append(((int) (point.getLatitude() * 1000000.0d)) / 1000000.0f);
        stringBuffer.append("&coordtype=");
        stringBuffer.append(this.l.getCoordType());
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getURL() {
        return fd.d() + "/nearby/data/create";
    }
}
