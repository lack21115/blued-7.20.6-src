package com.anythink.expressad.atsignalcommon.base;

import android.net.Uri;
import android.text.TextUtils;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/base/c.class */
public final class c implements a {
    @Override // com.anythink.expressad.atsignalcommon.base.a
    public final boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String scheme = Uri.parse(str).getScheme();
        if (TextUtils.isEmpty(scheme)) {
            return false;
        }
        scheme.equals("intent");
        return false;
    }
}
