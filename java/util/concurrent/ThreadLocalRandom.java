package java.util.concurrent;

import java.util.Random;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ThreadLocalRandom.class */
public class ThreadLocalRandom extends Random {
    private static final long addend = 11;
    private static final ThreadLocal<ThreadLocalRandom> localRandom = new ThreadLocal<ThreadLocalRandom>() { // from class: java.util.concurrent.ThreadLocalRandom.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ThreadLocalRandom initialValue() {
            return new ThreadLocalRandom();
        }
    };
    private static final long mask = 281474976710655L;
    private static final long multiplier = 25214903917L;
    private static final long serialVersionUID = -5851777807851030925L;
    boolean initialized = true;
    private long pad0;
    private long pad1;
    private long pad2;
    private long pad3;
    private long pad4;
    private long pad5;
    private long pad6;
    private long pad7;
    private long rnd;

    ThreadLocalRandom() {
    }

    public static ThreadLocalRandom current() {
        return localRandom.get();
    }

    @Override // java.util.Random
    protected int next(int i) {
        this.rnd = ((this.rnd * multiplier) + 11) & mask;
        return (int) (this.rnd >>> (48 - i));
    }

    public double nextDouble(double d) {
        if (d <= 0.0d) {
            throw new IllegalArgumentException("n must be positive");
        }
        return nextDouble() * d;
    }

    public double nextDouble(double d, double d2) {
        if (d >= d2) {
            throw new IllegalArgumentException();
        }
        return (nextDouble() * (d2 - d)) + d;
    }

    public int nextInt(int i, int i2) {
        if (i >= i2) {
            throw new IllegalArgumentException();
        }
        return nextInt(i2 - i) + i;
    }

    public long nextLong(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("n must be positive");
        }
        long j2 = 0;
        while (true) {
            long j3 = j2;
            long j4 = j;
            if (j4 < 2147483647L) {
                return nextInt((int) j4) + j3;
            }
            int next = next(2);
            j = j4 >>> 1;
            if ((next & 2) != 0) {
                j = j4 - j;
            }
            long j5 = j3;
            if ((next & 1) == 0) {
                j5 = j3 + (j4 - j);
            }
            j2 = j5;
        }
    }

    public long nextLong(long j, long j2) {
        if (j >= j2) {
            throw new IllegalArgumentException();
        }
        return nextLong(j2 - j) + j;
    }

    @Override // java.util.Random
    public void setSeed(long j) {
        if (this.initialized) {
            throw new UnsupportedOperationException();
        }
        this.rnd = (multiplier ^ j) & mask;
    }
}
