package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ob.class */
public class ob extends ib {
    @Override // com.tencent.mapsdk.internal.ib
    public byte[] e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        NetResponse doGet = NetManager.getInstance().builder().url(str).doGet();
        return (doGet == null || !doGet.available()) ? super.e(str) : doGet.data;
    }
}
