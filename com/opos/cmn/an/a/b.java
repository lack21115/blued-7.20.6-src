package com.opos.cmn.an.a;

import android.util.Base64;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/a/b.class */
public final class b {
    public static String a(String str) {
        return !com.opos.cmn.an.c.a.a(str) ? a(str.getBytes()) : "";
    }

    public static String a(byte[] bArr) {
        return bArr != null ? new String(Base64.decode(bArr, 2)) : "";
    }
}
