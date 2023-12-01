package java.util;

import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/util/Random.class */
public class Random implements Serializable {
    private static final long multiplier = 25214903917L;
    private static volatile long seedBase = 0;
    private static final long serialVersionUID = 3905348978240129619L;
    private boolean haveNextNextGaussian;
    private double nextNextGaussian;
    private long seed;

    public Random() {
        setSeed(System.nanoTime() + seedBase);
        seedBase++;
    }

    public Random(long j) {
        setSeed(j);
    }

    protected int next(int i) {
        int i2;
        synchronized (this) {
            this.seed = ((this.seed * multiplier) + 11) & 281474976710655L;
            i2 = (int) (this.seed >>> (48 - i));
        }
        return i2;
    }

    public boolean nextBoolean() {
        return next(1) != 0;
    }

    public void nextBytes(byte[] bArr) {
        int i;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < bArr.length; i4++) {
            if (i3 == 0) {
                i2 = nextInt();
                i = 3;
            } else {
                i = i3 - 1;
            }
            i3 = i;
            bArr[i4] = (byte) i2;
            i2 >>= 8;
        }
    }

    public double nextDouble() {
        return ((next(26) << 27) + next(27)) / 9.007199254740992E15d;
    }

    public float nextFloat() {
        return next(24) / 1.6777216E7f;
    }

    public double nextGaussian() {
        double nextDouble;
        double nextDouble2;
        double d;
        double d2;
        synchronized (this) {
            if (this.haveNextNextGaussian) {
                this.haveNextNextGaussian = false;
                d2 = this.nextNextGaussian;
            } else {
                while (true) {
                    nextDouble = (2.0d * nextDouble()) - 1.0d;
                    nextDouble2 = (2.0d * nextDouble()) - 1.0d;
                    d = (nextDouble * nextDouble) + (nextDouble2 * nextDouble2);
                    if (d < 1.0d && d != 0.0d) {
                        break;
                    }
                }
                double sqrt = StrictMath.sqrt(((-2.0d) * StrictMath.log(d)) / d);
                this.nextNextGaussian = nextDouble2 * sqrt;
                this.haveNextNextGaussian = true;
                d2 = nextDouble * sqrt;
            }
        }
        return d2;
    }

    public int nextInt() {
        return next(32);
    }

    public int nextInt(int i) {
        int next;
        int i2;
        if (i <= 0) {
            throw new IllegalArgumentException("n <= 0: " + i);
        }
        if (((-i) & i) == i) {
            return (int) ((i * next(31)) >> 31);
        }
        do {
            next = next(31);
            i2 = next % i;
        } while ((next - i2) + (i - 1) < 0);
        return i2;
    }

    public long nextLong() {
        return (next(32) << 32) + next(32);
    }

    public void setSeed(long j) {
        synchronized (this) {
            this.seed = (multiplier ^ j) & 281474976710655L;
            this.haveNextNextGaussian = false;
        }
    }
}
