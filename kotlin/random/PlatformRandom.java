package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/random/PlatformRandom.class */
final class PlatformRandom extends AbstractPlatformRandom implements Serializable {
    private static final Companion b = new Companion(null);
    @Deprecated
    private static final long serialVersionUID = 0;
    private final java.util.Random c;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/random/PlatformRandom$Companion.class */
    static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // kotlin.random.AbstractPlatformRandom
    public java.util.Random a() {
        return this.c;
    }
}
