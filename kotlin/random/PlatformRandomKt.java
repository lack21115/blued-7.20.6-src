package kotlin.random;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/random/PlatformRandomKt.class */
public final class PlatformRandomKt {
    public static final double a(int i, int i2) {
        return ((i << 27) + i2) / 9.007199254740992E15d;
    }
}
