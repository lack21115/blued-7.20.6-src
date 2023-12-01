package kotlin.random.jdk8;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.AbstractPlatformRandom;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/random/jdk8/PlatformThreadLocalRandom.class */
public final class PlatformThreadLocalRandom extends AbstractPlatformRandom {
    @Override // kotlin.random.Random
    public int a(int i, int i2) {
        return ThreadLocalRandom.current().nextInt(i, i2);
    }

    @Override // kotlin.random.AbstractPlatformRandom
    public Random a() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        Intrinsics.c(current, "current()");
        return current;
    }
}
