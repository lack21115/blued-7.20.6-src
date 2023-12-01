package java.util.concurrent;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/TimeUnit.class */
public enum TimeUnit {
    NANOSECONDS { // from class: java.util.concurrent.TimeUnit.1
        @Override // java.util.concurrent.TimeUnit
        public long convert(long j, TimeUnit timeUnit) {
            return timeUnit.toNanos(j);
        }

        @Override // java.util.concurrent.TimeUnit
        int excessNanos(long j, long j2) {
            return (int) (j - (TimeUnit.C2 * j2));
        }

        @Override // java.util.concurrent.TimeUnit
        public long toDays(long j) {
            return j / TimeUnit.C6;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toHours(long j) {
            return j / TimeUnit.C5;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toMicros(long j) {
            return j / 1000;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toMillis(long j) {
            return j / TimeUnit.C2;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toMinutes(long j) {
            return j / TimeUnit.C4;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toNanos(long j) {
            return j;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toSeconds(long j) {
            return j / TimeUnit.C3;
        }
    },
    MICROSECONDS { // from class: java.util.concurrent.TimeUnit.2
        @Override // java.util.concurrent.TimeUnit
        public long convert(long j, TimeUnit timeUnit) {
            return timeUnit.toMicros(j);
        }

        @Override // java.util.concurrent.TimeUnit
        int excessNanos(long j, long j2) {
            return (int) ((1000 * j) - (TimeUnit.C2 * j2));
        }

        @Override // java.util.concurrent.TimeUnit
        public long toDays(long j) {
            return j / 86400000000L;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toHours(long j) {
            return j / 3600000000L;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toMicros(long j) {
            return j;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toMillis(long j) {
            return j / 1000;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toMinutes(long j) {
            return j / 60000000;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toNanos(long j) {
            return x(j, 1000L, 9223372036854775L);
        }

        @Override // java.util.concurrent.TimeUnit
        public long toSeconds(long j) {
            return j / TimeUnit.C2;
        }
    },
    MILLISECONDS { // from class: java.util.concurrent.TimeUnit.3
        @Override // java.util.concurrent.TimeUnit
        public long convert(long j, TimeUnit timeUnit) {
            return timeUnit.toMillis(j);
        }

        @Override // java.util.concurrent.TimeUnit
        int excessNanos(long j, long j2) {
            return 0;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toDays(long j) {
            return j / 86400000;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toHours(long j) {
            return j / 3600000;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toMicros(long j) {
            return x(j, 1000L, 9223372036854775L);
        }

        @Override // java.util.concurrent.TimeUnit
        public long toMillis(long j) {
            return j;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toMinutes(long j) {
            return j / 60000;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toNanos(long j) {
            return x(j, TimeUnit.C2, 9223372036854L);
        }

        @Override // java.util.concurrent.TimeUnit
        public long toSeconds(long j) {
            return j / 1000;
        }
    },
    SECONDS { // from class: java.util.concurrent.TimeUnit.4
        @Override // java.util.concurrent.TimeUnit
        public long convert(long j, TimeUnit timeUnit) {
            return timeUnit.toSeconds(j);
        }

        @Override // java.util.concurrent.TimeUnit
        int excessNanos(long j, long j2) {
            return 0;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toDays(long j) {
            return j / 86400;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toHours(long j) {
            return j / 3600;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toMicros(long j) {
            return x(j, TimeUnit.C2, 9223372036854L);
        }

        @Override // java.util.concurrent.TimeUnit
        public long toMillis(long j) {
            return x(j, 1000L, 9223372036854775L);
        }

        @Override // java.util.concurrent.TimeUnit
        public long toMinutes(long j) {
            return j / 60;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toNanos(long j) {
            return x(j, TimeUnit.C3, 9223372036L);
        }

        @Override // java.util.concurrent.TimeUnit
        public long toSeconds(long j) {
            return j;
        }
    },
    MINUTES { // from class: java.util.concurrent.TimeUnit.5
        @Override // java.util.concurrent.TimeUnit
        public long convert(long j, TimeUnit timeUnit) {
            return timeUnit.toMinutes(j);
        }

        @Override // java.util.concurrent.TimeUnit
        int excessNanos(long j, long j2) {
            return 0;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toDays(long j) {
            return j / 1440;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toHours(long j) {
            return j / 60;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toMicros(long j) {
            return x(j, 60000000L, 153722867280L);
        }

        @Override // java.util.concurrent.TimeUnit
        public long toMillis(long j) {
            return x(j, 60000L, 153722867280912L);
        }

        @Override // java.util.concurrent.TimeUnit
        public long toMinutes(long j) {
            return j;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toNanos(long j) {
            return x(j, TimeUnit.C4, 153722867L);
        }

        @Override // java.util.concurrent.TimeUnit
        public long toSeconds(long j) {
            return x(j, 60L, 153722867280912930L);
        }
    },
    HOURS { // from class: java.util.concurrent.TimeUnit.6
        @Override // java.util.concurrent.TimeUnit
        public long convert(long j, TimeUnit timeUnit) {
            return timeUnit.toHours(j);
        }

        @Override // java.util.concurrent.TimeUnit
        int excessNanos(long j, long j2) {
            return 0;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toDays(long j) {
            return j / 24;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toHours(long j) {
            return j;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toMicros(long j) {
            return x(j, 3600000000L, 2562047788L);
        }

        @Override // java.util.concurrent.TimeUnit
        public long toMillis(long j) {
            return x(j, 3600000L, 2562047788015L);
        }

        @Override // java.util.concurrent.TimeUnit
        public long toMinutes(long j) {
            return x(j, 60L, 153722867280912930L);
        }

        @Override // java.util.concurrent.TimeUnit
        public long toNanos(long j) {
            return x(j, TimeUnit.C5, 2562047L);
        }

        @Override // java.util.concurrent.TimeUnit
        public long toSeconds(long j) {
            return x(j, 3600L, 2562047788015215L);
        }
    },
    DAYS { // from class: java.util.concurrent.TimeUnit.7
        @Override // java.util.concurrent.TimeUnit
        public long convert(long j, TimeUnit timeUnit) {
            return timeUnit.toDays(j);
        }

        @Override // java.util.concurrent.TimeUnit
        int excessNanos(long j, long j2) {
            return 0;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toDays(long j) {
            return j;
        }

        @Override // java.util.concurrent.TimeUnit
        public long toHours(long j) {
            return x(j, 24L, 384307168202282325L);
        }

        @Override // java.util.concurrent.TimeUnit
        public long toMicros(long j) {
            return x(j, 86400000000L, 106751991L);
        }

        @Override // java.util.concurrent.TimeUnit
        public long toMillis(long j) {
            return x(j, 86400000L, 106751991167L);
        }

        @Override // java.util.concurrent.TimeUnit
        public long toMinutes(long j) {
            return x(j, 1440L, 6405119470038038L);
        }

        @Override // java.util.concurrent.TimeUnit
        public long toNanos(long j) {
            return x(j, TimeUnit.C6, 106751L);
        }

        @Override // java.util.concurrent.TimeUnit
        public long toSeconds(long j) {
            return x(j, 86400L, 106751991167300L);
        }
    };
    
    static final long C0 = 1;
    static final long C1 = 1000;
    static final long C2 = 1000000;
    static final long C3 = 1000000000;
    static final long C4 = 60000000000L;
    static final long C5 = 3600000000000L;
    static final long C6 = 86400000000000L;
    static final long MAX = Long.MAX_VALUE;

    static long x(long j, long j2, long j3) {
        if (j > j3) {
            return Long.MAX_VALUE;
        }
        if (j < (-j3)) {
            return Long.MIN_VALUE;
        }
        return j * j2;
    }

    public long convert(long j, TimeUnit timeUnit) {
        throw new AbstractMethodError();
    }

    abstract int excessNanos(long j, long j2);

    public void sleep(long j) throws InterruptedException {
        if (j > 0) {
            long millis = toMillis(j);
            Thread.sleep(millis, excessNanos(j, millis));
        }
    }

    public void timedJoin(Thread thread, long j) throws InterruptedException {
        if (j > 0) {
            long millis = toMillis(j);
            thread.join(millis, excessNanos(j, millis));
        }
    }

    public void timedWait(Object obj, long j) throws InterruptedException {
        if (j > 0) {
            long millis = toMillis(j);
            obj.wait(millis, excessNanos(j, millis));
        }
    }

    public long toDays(long j) {
        throw new AbstractMethodError();
    }

    public long toHours(long j) {
        throw new AbstractMethodError();
    }

    public long toMicros(long j) {
        throw new AbstractMethodError();
    }

    public long toMillis(long j) {
        throw new AbstractMethodError();
    }

    public long toMinutes(long j) {
        throw new AbstractMethodError();
    }

    public long toNanos(long j) {
        throw new AbstractMethodError();
    }

    public long toSeconds(long j) {
        throw new AbstractMethodError();
    }
}
