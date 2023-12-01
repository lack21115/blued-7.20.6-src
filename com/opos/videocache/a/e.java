package com.opos.videocache.a;

import android.text.TextUtils;

/* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/a/e.class */
public class e implements c {
    private String b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || (lastIndexOf + 2) + 4 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    @Override // com.opos.videocache.a.c
    public String a(String str) {
        String b = b(str);
        String d = com.opos.videocache.h.d(str);
        if (TextUtils.isEmpty(b)) {
            return d;
        }
        return d + "." + b;
    }
}
