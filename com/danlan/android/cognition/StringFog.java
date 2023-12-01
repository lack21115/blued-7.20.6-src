package com.danlan.android.cognition;

import com.danlan.android.security.obfuscator.StringFogImpl;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/StringFog.class */
public final class StringFog {
    private static final StringFogImpl IMPL = new StringFogImpl();

    public static String decrypt(String str) {
        return IMPL.a(str, "!#$#!#$!");
    }

    public static boolean overflow(String str) {
        return IMPL.b(str, "!#$#!#$!");
    }
}
