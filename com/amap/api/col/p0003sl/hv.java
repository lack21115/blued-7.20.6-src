package com.amap.api.col.p0003sl;

import android.net.Uri;
import android.text.TextUtils;

/* renamed from: com.amap.api.col.3sl.hv  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hv.class */
public abstract class hv extends kb {
    @Override // com.amap.api.col.p0003sl.kb
    public String getIPV6URL() {
        if (TextUtils.isEmpty(getURL())) {
            return getURL();
        }
        String url = getURL();
        Uri parse = Uri.parse(url);
        if (parse.getAuthority().startsWith("dualstack-")) {
            return url;
        }
        if (parse.getAuthority().startsWith("restsdk.amap.com")) {
            return parse.buildUpon().authority("dualstack-arestapi.amap.com").build().toString();
        }
        Uri.Builder buildUpon = parse.buildUpon();
        return buildUpon.authority("dualstack-" + parse.getAuthority()).build().toString();
    }

    @Override // com.amap.api.col.p0003sl.kb
    public boolean isSupportIPV6() {
        return true;
    }
}
