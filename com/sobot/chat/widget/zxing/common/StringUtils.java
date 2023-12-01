package com.sobot.chat.widget.zxing.common;

import java.nio.charset.Charset;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/common/StringUtils.class */
public final class StringUtils {
    private static final boolean ASSUME_SHIFT_JIS;
    private static final String EUC_JP = "EUC_JP";
    public static final String GB2312 = "GB2312";
    private static final String ISO88591 = "ISO8859_1";
    private static final String PLATFORM_DEFAULT_ENCODING;
    public static final String SHIFT_JIS = "SJIS";
    private static final String UTF8 = "UTF8";

    static {
        String name = Charset.defaultCharset().name();
        PLATFORM_DEFAULT_ENCODING = name;
        ASSUME_SHIFT_JIS = "SJIS".equalsIgnoreCase(name) || EUC_JP.equalsIgnoreCase(PLATFORM_DEFAULT_ENCODING);
    }

    private StringUtils() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x01ce, code lost:
        if (r0 == 247) goto L119;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String guessEncoding(byte[] r3, java.util.Map<com.sobot.chat.widget.zxing.DecodeHintType, ?> r4) {
        /*
            Method dump skipped, instructions count: 968
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.zxing.common.StringUtils.guessEncoding(byte[], java.util.Map):java.lang.String");
    }
}
