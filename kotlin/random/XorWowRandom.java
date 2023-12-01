package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/random/XorWowRandom.class */
public final class XorWowRandom extends Random implements Serializable {
    private static final Companion b = new Companion(null);
    @Deprecated
    private static final long serialVersionUID = 0;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/random/XorWowRandom$Companion.class */
    static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // kotlin.random.Random
    public int a(int i) {
        return RandomKt.a(b(), i);
    }

    @Override // kotlin.random.Random
    public int b() {
        int i = this.c;
        int i2 = i ^ (i >>> 2);
        this.c = this.d;
        this.d = this.e;
        this.e = this.f;
        int i3 = this.g;
        this.f = i3;
        int i4 = ((i2 ^ (i2 << 1)) ^ i3) ^ (i3 << 4);
        this.g = i4;
        int i5 = this.h + 362437;
        this.h = i5;
        return i4 + i5;
    }
}
