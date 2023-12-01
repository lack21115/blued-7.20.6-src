package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/random/KotlinRandom.class */
final class KotlinRandom extends java.util.Random {

    /* renamed from: a  reason: collision with root package name */
    private static final Companion f42562a = new Companion(null);
    @Deprecated
    private static final long serialVersionUID = 0;
    private final Random b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f42563c;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/random/KotlinRandom$Companion.class */
    static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // java.util.Random
    protected int next(int i) {
        return this.b.a(i);
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return this.b.d();
    }

    @Override // java.util.Random
    public void nextBytes(byte[] bytes) {
        Intrinsics.e(bytes, "bytes");
        this.b.a(bytes);
    }

    @Override // java.util.Random
    public double nextDouble() {
        return this.b.e();
    }

    @Override // java.util.Random
    public float nextFloat() {
        return this.b.f();
    }

    @Override // java.util.Random
    public int nextInt() {
        return this.b.b();
    }

    @Override // java.util.Random
    public int nextInt(int i) {
        return this.b.b(i);
    }

    @Override // java.util.Random
    public long nextLong() {
        return this.b.c();
    }

    @Override // java.util.Random
    public void setSeed(long j) {
        if (this.f42563c) {
            throw new UnsupportedOperationException("Setting seed is not supported.");
        }
        this.f42563c = true;
    }
}
