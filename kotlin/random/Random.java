package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/random/Random.class */
public abstract class Random {
    public static final Default a = new Default(null);
    private static final Random b = PlatformImplementationsKt.a.a();

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/random/Random$Default.class */
    public static final class Default extends Random implements Serializable {

        @Metadata
        /* loaded from: source-3503164-dex2jar.jar:kotlin/random/Random$Default$Serialized.class */
        static final class Serialized implements Serializable {
            public static final Serialized a = new Serialized();
            private static final long serialVersionUID = 0;

            private Serialized() {
            }

            private final Object readResolve() {
                return Random.a;
            }
        }

        private Default() {
        }

        public /* synthetic */ Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Object writeReplace() {
            return Serialized.a;
        }

        @Override // kotlin.random.Random
        public int a(int i) {
            return Random.b.a(i);
        }

        @Override // kotlin.random.Random
        public int a(int i, int i2) {
            return Random.b.a(i, i2);
        }

        @Override // kotlin.random.Random
        public byte[] a(byte[] array) {
            Intrinsics.e(array, "array");
            return Random.b.a(array);
        }

        @Override // kotlin.random.Random
        public byte[] a(byte[] array, int i, int i2) {
            Intrinsics.e(array, "array");
            return Random.b.a(array, i, i2);
        }

        @Override // kotlin.random.Random
        public int b() {
            return Random.b.b();
        }

        @Override // kotlin.random.Random
        public int b(int i) {
            return Random.b.b(i);
        }

        @Override // kotlin.random.Random
        public long c() {
            return Random.b.c();
        }

        @Override // kotlin.random.Random
        public boolean d() {
            return Random.b.d();
        }

        @Override // kotlin.random.Random
        public double e() {
            return Random.b.e();
        }

        @Override // kotlin.random.Random
        public float f() {
            return Random.b.f();
        }
    }

    public abstract int a(int i);

    public int a(int i, int i2) {
        int b2;
        int i3;
        int b3;
        boolean z;
        RandomKt.b(i, i2);
        int i4 = i2 - i;
        if (i4 > 0 || i4 == Integer.MIN_VALUE) {
            if (((-i4) & i4) == i4) {
                i3 = a(RandomKt.a(i4));
            } else {
                do {
                    b2 = b() >>> 1;
                    i3 = b2 % i4;
                } while ((b2 - i3) + (i4 - 1) < 0);
            }
            return i + i3;
        }
        do {
            b3 = b();
            z = false;
            if (i <= b3) {
                z = false;
                if (b3 < i2) {
                    z = true;
                }
            }
        } while (!z);
        return b3;
    }

    public byte[] a(byte[] array) {
        Intrinsics.e(array, "array");
        return a(array, 0, array.length);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] a(byte[] r7, int r8, int r9) {
        /*
            Method dump skipped, instructions count: 351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.random.Random.a(byte[], int, int):byte[]");
    }

    public int b() {
        return a(32);
    }

    public int b(int i) {
        return a(0, i);
    }

    public long c() {
        return (b() << 32) + b();
    }

    public boolean d() {
        return a(1) != 0;
    }

    public double e() {
        return PlatformRandomKt.a(a(26), a(27));
    }

    public float f() {
        return a(24) / 1.6777216E7f;
    }
}
