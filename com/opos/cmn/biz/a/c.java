package com.opos.cmn.biz.a;

import android.content.Context;
import android.provider.BrowserContract;
import com.cdo.oaps.ad.af;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/a/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f24604a = "com." + com.opos.cmn.an.a.a.f24484c + ".market";
    private static final String b = "com." + com.opos.cmn.an.a.a.f24483a + ".market";

    /* renamed from: c  reason: collision with root package name */
    private static final String f24605c = "com." + com.opos.cmn.an.a.a.d + ".browser";

    public static String a(Context context) {
        return com.opos.cmn.an.h.d.a.d(context, af.e) ? af.e : com.opos.cmn.an.h.d.a.d(context, f24604a) ? f24604a : com.opos.cmn.an.h.d.a.d(context, b) ? b : "";
    }

    public static String b(Context context) {
        return com.opos.cmn.an.h.d.a.d(context, "com.heytap.browser") ? "com.heytap.browser" : com.opos.cmn.an.h.d.a.d(context, f24605c) ? f24605c : com.opos.cmn.an.h.d.a.d(context, "com.nearme.browser") ? "com.nearme.browser" : com.opos.cmn.an.h.d.a.d(context, BrowserContract.AUTHORITY) ? BrowserContract.AUTHORITY : "";
    }
}
