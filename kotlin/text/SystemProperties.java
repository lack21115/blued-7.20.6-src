package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/SystemProperties.class */
final class SystemProperties {
    public static final SystemProperties a = new SystemProperties();
    public static final String b;

    static {
        String property = System.getProperty("line.separator");
        Intrinsics.a((Object) property);
        b = property;
    }

    private SystemProperties() {
    }
}
