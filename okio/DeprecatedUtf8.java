package okio;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Deprecated
@Metadata
/* renamed from: okio.-DeprecatedUtf8  reason: invalid class name */
/* loaded from: source-3503164-dex2jar.jar:okio/-DeprecatedUtf8.class */
public final class DeprecatedUtf8 {
    public static final DeprecatedUtf8 INSTANCE = new DeprecatedUtf8();

    private DeprecatedUtf8() {
    }

    @Deprecated
    public final long size(String string) {
        Intrinsics.e(string, "string");
        return Utf8.size$default(string, 0, 0, 3, null);
    }

    @Deprecated
    public final long size(String string, int i, int i2) {
        Intrinsics.e(string, "string");
        return Utf8.size(string, i, i2);
    }
}
