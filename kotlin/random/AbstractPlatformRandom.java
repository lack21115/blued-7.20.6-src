package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/random/AbstractPlatformRandom.class */
public abstract class AbstractPlatformRandom extends Random {
    @Override // kotlin.random.Random
    public int a(int i) {
        return RandomKt.a(a().nextInt(), i);
    }

    public abstract java.util.Random a();

    @Override // kotlin.random.Random
    public byte[] a(byte[] array) {
        Intrinsics.e(array, "array");
        a().nextBytes(array);
        return array;
    }

    @Override // kotlin.random.Random
    public int b() {
        return a().nextInt();
    }

    @Override // kotlin.random.Random
    public int b(int i) {
        return a().nextInt(i);
    }

    @Override // kotlin.random.Random
    public long c() {
        return a().nextLong();
    }

    @Override // kotlin.random.Random
    public boolean d() {
        return a().nextBoolean();
    }

    @Override // kotlin.random.Random
    public double e() {
        return a().nextDouble();
    }

    @Override // kotlin.random.Random
    public float f() {
        return a().nextFloat();
    }
}
