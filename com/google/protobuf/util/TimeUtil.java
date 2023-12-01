package com.google.protobuf.util;

import com.google.protobuf.Duration;
import com.google.protobuf.Timestamp;
import java.math.BigInteger;
import java.text.ParseException;

@Deprecated
/* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/util/TimeUtil.class */
public final class TimeUtil {
    public static final long DURATION_SECONDS_MAX = 315576000000L;
    public static final long DURATION_SECONDS_MIN = -315576000000L;
    private static final long NANOS_PER_SECOND = 1000000000;
    private static final BigInteger NANOS_PER_SECOND_BIG_INTEGER = new BigInteger(String.valueOf(1000000000L));
    public static final long TIMESTAMP_SECONDS_MAX = 253402300799L;
    public static final long TIMESTAMP_SECONDS_MIN = -62135596800L;

    private TimeUtil() {
    }

    @Deprecated
    public static Duration add(Duration duration, Duration duration2) {
        return Durations.add(duration, duration2);
    }

    @Deprecated
    public static Timestamp add(Timestamp timestamp, Duration duration) {
        return Timestamps.add(timestamp, duration);
    }

    private static Duration createDurationFromBigInteger(BigInteger bigInteger) {
        return normalizedDuration(bigInteger.divide(new BigInteger(String.valueOf(1000000000L))).longValue(), bigInteger.remainder(new BigInteger(String.valueOf(1000000000L))).intValue());
    }

    @Deprecated
    public static Duration createDurationFromMicros(long j) {
        return Durations.fromMicros(j);
    }

    @Deprecated
    public static Duration createDurationFromMillis(long j) {
        return Durations.fromMillis(j);
    }

    @Deprecated
    public static Duration createDurationFromNanos(long j) {
        return Durations.fromNanos(j);
    }

    @Deprecated
    public static Timestamp createTimestampFromMicros(long j) {
        return Timestamps.fromMicros(j);
    }

    @Deprecated
    public static Timestamp createTimestampFromMillis(long j) {
        return Timestamps.fromMillis(j);
    }

    @Deprecated
    public static Timestamp createTimestampFromNanos(long j) {
        return Timestamps.fromNanos(j);
    }

    @Deprecated
    public static Duration distance(Timestamp timestamp, Timestamp timestamp2) {
        return Timestamps.between(timestamp, timestamp2);
    }

    public static long divide(Duration duration, Duration duration2) {
        return toBigInteger(duration).divide(toBigInteger(duration2)).longValue();
    }

    public static Duration divide(Duration duration, double d) {
        return multiply(duration, 1.0d / d);
    }

    public static Duration divide(Duration duration, long j) {
        return createDurationFromBigInteger(toBigInteger(duration).divide(toBigInteger(j)));
    }

    @Deprecated
    public static Timestamp getCurrentTime() {
        return Timestamps.fromMillis(System.currentTimeMillis());
    }

    @Deprecated
    public static Timestamp getEpoch() {
        return Timestamp.getDefaultInstance();
    }

    public static Duration multiply(Duration duration, double d) {
        double seconds = (duration.getSeconds() * d) + ((duration.getNanos() * d) / 1.0E9d);
        if (seconds < -9.223372036854776E18d || seconds > 9.223372036854776E18d) {
            throw new IllegalArgumentException("Result is out of valid range.");
        }
        long j = (long) seconds;
        return normalizedDuration(j, (int) ((seconds - j) * 1.0E9d));
    }

    public static Duration multiply(Duration duration, long j) {
        return createDurationFromBigInteger(toBigInteger(duration).multiply(toBigInteger(j)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0018, code lost:
        if (r0 >= 1000000000) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.protobuf.Duration normalizedDuration(long r7, int r9) {
        /*
            r0 = r9
            long r0 = (long) r0
            r13 = r0
            r0 = r13
            r1 = -1000000000(0xffffffffc4653600, double:NaN)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L1b
            r0 = r7
            r11 = r0
            r0 = r9
            r10 = r0
            r0 = r13
            r1 = 1000000000(0x3b9aca00, double:4.94065646E-315)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L2d
        L1b:
            r0 = r7
            r1 = r13
            r2 = 1000000000(0x3b9aca00, double:4.94065646E-315)
            long r1 = r1 / r2
            long r0 = r0 + r1
            r11 = r0
            r0 = r13
            r1 = 1000000000(0x3b9aca00, double:4.94065646E-315)
            long r0 = r0 % r1
            int r0 = (int) r0
            r10 = r0
        L2d:
            r0 = r11
            r7 = r0
            r0 = r10
            r9 = r0
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L4f
            r0 = r11
            r7 = r0
            r0 = r10
            r9 = r0
            r0 = r10
            if (r0 >= 0) goto L4f
            r0 = r10
            long r0 = (long) r0
            r1 = 1000000000(0x3b9aca00, double:4.94065646E-315)
            long r0 = r0 + r1
            int r0 = (int) r0
            r9 = r0
            r0 = r11
            r1 = 1
            long r0 = r0 - r1
            r7 = r0
        L4f:
            r0 = r7
            r11 = r0
            r0 = r9
            r10 = r0
            r0 = r7
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L70
            r0 = r7
            r11 = r0
            r0 = r9
            r10 = r0
            r0 = r9
            if (r0 <= 0) goto L70
            r0 = r9
            long r0 = (long) r0
            r1 = 1000000000(0x3b9aca00, double:4.94065646E-315)
            long r0 = r0 - r1
            int r0 = (int) r0
            r10 = r0
            r0 = r7
            r1 = 1
            long r0 = r0 + r1
            r11 = r0
        L70:
            r0 = r11
            r1 = -315576000000(0xffffffb686346200, double:NaN)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L92
            r0 = r11
            r1 = 315576000000(0x4979cb9e00, double:1.55915260252E-312)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L92
            com.google.protobuf.Duration$Builder r0 = com.google.protobuf.Duration.newBuilder()
            r1 = r11
            com.google.protobuf.Duration$Builder r0 = r0.setSeconds(r1)
            r1 = r10
            com.google.protobuf.Duration$Builder r0 = r0.setNanos(r1)
            com.google.protobuf.Duration r0 = r0.build()
            return r0
        L92:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.String r2 = "Duration is out of valid range."
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.util.TimeUtil.normalizedDuration(long, int):com.google.protobuf.Duration");
    }

    @Deprecated
    public static Duration parseDuration(String str) throws ParseException {
        return Durations.parse(str);
    }

    @Deprecated
    public static Timestamp parseTimestamp(String str) throws ParseException {
        return Timestamps.parse(str);
    }

    public static Duration remainder(Duration duration, Duration duration2) {
        return createDurationFromBigInteger(toBigInteger(duration).remainder(toBigInteger(duration2)));
    }

    @Deprecated
    public static Duration subtract(Duration duration, Duration duration2) {
        return Durations.subtract(duration, duration2);
    }

    @Deprecated
    public static Timestamp subtract(Timestamp timestamp, Duration duration) {
        return Timestamps.subtract(timestamp, duration);
    }

    private static BigInteger toBigInteger(long j) {
        return new BigInteger(String.valueOf(j));
    }

    private static BigInteger toBigInteger(Duration duration) {
        return toBigInteger(duration.getSeconds()).multiply(NANOS_PER_SECOND_BIG_INTEGER).add(toBigInteger(duration.getNanos()));
    }

    @Deprecated
    public static long toMicros(Duration duration) {
        return Durations.toMicros(duration);
    }

    @Deprecated
    public static long toMicros(Timestamp timestamp) {
        return Timestamps.toMicros(timestamp);
    }

    @Deprecated
    public static long toMillis(Duration duration) {
        return Durations.toMillis(duration);
    }

    @Deprecated
    public static long toMillis(Timestamp timestamp) {
        return Timestamps.toMillis(timestamp);
    }

    @Deprecated
    public static long toNanos(Duration duration) {
        return Durations.toNanos(duration);
    }

    @Deprecated
    public static long toNanos(Timestamp timestamp) {
        return Timestamps.toNanos(timestamp);
    }

    @Deprecated
    public static String toString(Duration duration) {
        return Durations.toString(duration);
    }

    @Deprecated
    public static String toString(Timestamp timestamp) {
        return Timestamps.toString(timestamp);
    }
}
