package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.internal.BackoffPolicy;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ExponentialBackoffPolicy.class */
public final class ExponentialBackoffPolicy implements BackoffPolicy {
    private Random random = new Random();
    private long initialBackoffNanos = TimeUnit.SECONDS.toNanos(1);
    private long maxBackoffNanos = TimeUnit.MINUTES.toNanos(2);
    private double multiplier = 1.6d;
    private double jitter = 0.2d;
    private long nextBackoffNanos = this.initialBackoffNanos;

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ExponentialBackoffPolicy$Provider.class */
    public static final class Provider implements BackoffPolicy.Provider {
        @Override // io.grpc.internal.BackoffPolicy.Provider
        public BackoffPolicy get() {
            return new ExponentialBackoffPolicy();
        }
    }

    private long uniformRandom(double d, double d2) {
        Preconditions.checkArgument(d2 >= d);
        return (long) ((this.random.nextDouble() * (d2 - d)) + d);
    }

    @Override // io.grpc.internal.BackoffPolicy
    public long nextBackoffNanos() {
        long j = this.nextBackoffNanos;
        double d = j;
        this.nextBackoffNanos = Math.min((long) (this.multiplier * d), this.maxBackoffNanos);
        double d2 = this.jitter;
        return j + uniformRandom((-d2) * d, d2 * d);
    }

    ExponentialBackoffPolicy setInitialBackoffNanos(long j) {
        this.initialBackoffNanos = j;
        return this;
    }

    ExponentialBackoffPolicy setJitter(double d) {
        this.jitter = d;
        return this;
    }

    ExponentialBackoffPolicy setMaxBackoffNanos(long j) {
        this.maxBackoffNanos = j;
        return this;
    }

    ExponentialBackoffPolicy setMultiplier(double d) {
        this.multiplier = d;
        return this;
    }

    ExponentialBackoffPolicy setRandom(Random random) {
        this.random = random;
        return this;
    }
}
