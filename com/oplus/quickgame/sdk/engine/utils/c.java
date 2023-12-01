package com.oplus.quickgame.sdk.engine.utils;

import android.util.Base64;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/utils/c.class */
public class c {
    public static String a(String str) {
        return new String(Base64.decode(str.getBytes(), 0));
    }
}
