package io.grpc;

import java.util.Arrays;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/Deadline.class */
public final class Deadline implements Comparable<Deadline> {
    private static final long MAX_OFFSET;
    private static final long MIN_OFFSET;
    private static final long NANOS_PER_SECOND;
    private static final SystemTicker SYSTEM_TICKER = new SystemTicker();
    private final long deadlineNanos;
    private volatile boolean expired;
    private final Ticker ticker;

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/Deadline$SystemTicker.class */
    static class SystemTicker extends Ticker {
        private SystemTicker() {
        }

        @Override // io.grpc.Deadline.Ticker
        public long nanoTime() {
            return System.nanoTime();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/Deadline$Ticker.class */
    public static abstract class Ticker {
        public abstract long nanoTime();
    }

    static {
        long nanos = TimeUnit.DAYS.toNanos(36500L);
        MAX_OFFSET = nanos;
        MIN_OFFSET = -nanos;
        NANOS_PER_SECOND = TimeUnit.SECONDS.toNanos(1L);
    }

    private Deadline(Ticker ticker, long j, long j2, boolean z) {
        this.ticker = ticker;
        long min = Math.min(MAX_OFFSET, Math.max(MIN_OFFSET, j2));
        this.deadlineNanos = j + min;
        this.expired = z && min <= 0;
    }

    private Deadline(Ticker ticker, long j, boolean z) {
        this(ticker, ticker.nanoTime(), j, z);
    }

    public static Deadline after(long j, TimeUnit timeUnit) {
        return after(j, timeUnit, SYSTEM_TICKER);
    }

    public static Deadline after(long j, TimeUnit timeUnit, Ticker ticker) {
        checkNotNull(timeUnit, "units");
        return new Deadline(ticker, timeUnit.toNanos(j), true);
    }

    private static <T> T checkNotNull(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    private void checkTicker(Deadline deadline) {
        if (this.ticker == deadline.ticker) {
            return;
        }
        throw new AssertionError("Tickers (" + this.ticker + " and " + deadline.ticker + ") don't match. Custom Ticker should only be used in tests!");
    }

    public static Ticker getSystemTicker() {
        return SYSTEM_TICKER;
    }

    @Override // java.lang.Comparable
    public int compareTo(Deadline deadline) {
        checkTicker(deadline);
        int i = ((this.deadlineNanos - deadline.deadlineNanos) > 0L ? 1 : ((this.deadlineNanos - deadline.deadlineNanos) == 0L ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Deadline) {
            Deadline deadline = (Deadline) obj;
            Ticker ticker = this.ticker;
            if (ticker == null) {
                if (deadline.ticker != null) {
                    return false;
                }
            } else if (ticker != deadline.ticker) {
                return false;
            }
            return this.deadlineNanos == deadline.deadlineNanos;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.asList(this.ticker, Long.valueOf(this.deadlineNanos)).hashCode();
    }

    public boolean isBefore(Deadline deadline) {
        checkTicker(deadline);
        return this.deadlineNanos - deadline.deadlineNanos < 0;
    }

    public boolean isExpired() {
        if (this.expired) {
            return true;
        }
        if (this.deadlineNanos - this.ticker.nanoTime() <= 0) {
            this.expired = true;
            return true;
        }
        return false;
    }

    public Deadline minimum(Deadline deadline) {
        checkTicker(deadline);
        Deadline deadline2 = deadline;
        if (isBefore(deadline)) {
            deadline2 = this;
        }
        return deadline2;
    }

    public Deadline offset(long j, TimeUnit timeUnit) {
        return j == 0 ? this : new Deadline(this.ticker, this.deadlineNanos, timeUnit.toNanos(j), isExpired());
    }

    public ScheduledFuture<?> runOnExpiration(Runnable runnable, ScheduledExecutorService scheduledExecutorService) {
        checkNotNull(runnable, "task");
        checkNotNull(scheduledExecutorService, "scheduler");
        return scheduledExecutorService.schedule(runnable, this.deadlineNanos - this.ticker.nanoTime(), TimeUnit.NANOSECONDS);
    }

    public long timeRemaining(TimeUnit timeUnit) {
        long nanoTime = this.ticker.nanoTime();
        if (!this.expired && this.deadlineNanos - nanoTime <= 0) {
            this.expired = true;
        }
        return timeUnit.convert(this.deadlineNanos - nanoTime, TimeUnit.NANOSECONDS);
    }

    public String toString() {
        long timeRemaining = timeRemaining(TimeUnit.NANOSECONDS);
        long abs = Math.abs(timeRemaining) / NANOS_PER_SECOND;
        long abs2 = Math.abs(timeRemaining) % NANOS_PER_SECOND;
        StringBuilder sb = new StringBuilder();
        if (timeRemaining < 0) {
            sb.append('-');
        }
        sb.append(abs);
        if (abs2 > 0) {
            sb.append(String.format(".%09d", Long.valueOf(abs2)));
        }
        sb.append("s from now");
        if (this.ticker != SYSTEM_TICKER) {
            sb.append(" (ticker=" + this.ticker + ")");
        }
        return sb.toString();
    }
}
