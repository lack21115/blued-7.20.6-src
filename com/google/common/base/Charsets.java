package com.google.common.base;

import java.nio.charset.Charset;
import org.apache.commons.codec.CharEncoding;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/base/Charsets.class */
public final class Charsets {
    public static final Charset US_ASCII = Charset.forName("US-ASCII");
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final Charset UTF_16BE = Charset.forName(CharEncoding.UTF_16BE);
    public static final Charset UTF_16LE = Charset.forName(CharEncoding.UTF_16LE);
    public static final Charset UTF_16 = Charset.forName("UTF-16");

    private Charsets() {
    }
}
