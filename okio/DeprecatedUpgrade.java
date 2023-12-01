package okio;

import kotlin.Metadata;

@Metadata
/* renamed from: okio.-DeprecatedUpgrade  reason: invalid class name */
/* loaded from: source-3503164-dex2jar.jar:okio/-DeprecatedUpgrade.class */
public final class DeprecatedUpgrade {
    private static final DeprecatedOkio Okio = DeprecatedOkio.INSTANCE;
    private static final DeprecatedUtf8 Utf8 = DeprecatedUtf8.INSTANCE;

    public static final DeprecatedOkio getOkio() {
        return Okio;
    }

    public static final DeprecatedUtf8 getUtf8() {
        return Utf8;
    }
}
