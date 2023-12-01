package com.kwad.sdk.crash.utils;

import java.nio.charset.Charset;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/utils/a.class */
public final class a {
    public static final Charset US_ASCII = Charset.forName("US-ASCII");
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static Charset a(Charset charset) {
        Charset charset2 = charset;
        if (charset == null) {
            charset2 = Charset.defaultCharset();
        }
        return charset2;
    }
}
