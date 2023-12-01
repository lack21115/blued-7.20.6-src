package com.google.protobuf.util;

import com.google.common.math.IntMath;
import com.google.common.math.LongMath;
import com.google.protobuf.Duration;
import java.text.ParseException;
import java.util.Comparator;

/* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/util/Durations.class */
public final class Durations {
    static final long DURATION_SECONDS_MAX = 315576000000L;
    static final long DURATION_SECONDS_MIN = -315576000000L;
    public static final Duration MIN_VALUE = Duration.newBuilder().setSeconds(-315576000000L).setNanos(-999999999).build();
    public static final Duration MAX_VALUE = Duration.newBuilder().setSeconds(315576000000L).setNanos(999999999).build();
    private static final Comparator<Duration> COMPARATOR = new Comparator<Duration>() { // from class: com.google.protobuf.util.Durations.1
        @Override // java.util.Comparator
        public int compare(Duration duration, Duration duration2) {
            Durations.checkValid(duration);
            Durations.checkValid(duration2);
            int compare = Long.compare(duration.getSeconds(), duration2.getSeconds());
            return compare != 0 ? compare : Integer.compare(duration.getNanos(), duration2.getNanos());
        }
    };

    private Durations() {
    }

    public static Duration add(Duration duration, Duration duration2) {
        checkValid(duration);
        checkValid(duration2);
        return normalizedDuration(LongMath.checkedAdd(duration.getSeconds(), duration2.getSeconds()), IntMath.checkedAdd(duration.getNanos(), duration2.getNanos()));
    }

    public static Duration checkValid(Duration duration) {
        long seconds = duration.getSeconds();
        int nanos = duration.getNanos();
        if (isValid(seconds, nanos)) {
            return duration;
        }
        throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", Long.valueOf(seconds), Integer.valueOf(nanos)));
    }

    public static Comparator<Duration> comparator() {
        return COMPARATOR;
    }

    public static int compare(Duration duration, Duration duration2) {
        return COMPARATOR.compare(duration, duration2);
    }

    public static Duration fromMicros(long j) {
        return normalizedDuration(j / 1000000, (int) ((j % 1000000) * 1000));
    }

    public static Duration fromMillis(long j) {
        return normalizedDuration(j / 1000, (int) ((j % 1000) * 1000000));
    }

    public static Duration fromNanos(long j) {
        return normalizedDuration(j / 1000000000, (int) (j % 1000000000));
    }

    public static Duration fromSeconds(long j) {
        return normalizedDuration(j, 0);
    }

    public static boolean isValid(long j, int i) {
        if (j < -315576000000L || j > 315576000000L) {
            return false;
        }
        long j2 = i;
        if (j2 < -999999999 || j2 >= 1000000000) {
            return false;
        }
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 < 0 || i < 0) {
            return i2 <= 0 && i <= 0;
        }
        return true;
    }

    public static boolean isValid(Duration duration) {
        return isValid(duration.getSeconds(), duration.getNanos());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0018, code lost:
        if (r0 >= 1000000000) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.protobuf.Duration normalizedDuration(long r7, int r9) {
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
            if (r0 < 0) goto L2f
        L1b:
            r0 = r7
            r1 = r13
            r2 = 1000000000(0x3b9aca00, double:4.94065646E-315)
            long r1 = r1 / r2
            long r0 = com.google.common.math.LongMath.checkedAdd(r0, r1)
            r11 = r0
            r0 = r13
            r1 = 1000000000(0x3b9aca00, double:4.94065646E-315)
            long r0 = r0 % r1
            int r0 = (int) r0
            r10 = r0
        L2f:
            r0 = r11
            r7 = r0
            r0 = r10
            r9 = r0
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L51
            r0 = r11
            r7 = r0
            r0 = r10
            r9 = r0
            r0 = r10
            if (r0 >= 0) goto L51
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
        L51:
            r0 = r7
            r11 = r0
            r0 = r9
            r10 = r0
            r0 = r7
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L72
            r0 = r7
            r11 = r0
            r0 = r9
            r10 = r0
            r0 = r9
            if (r0 <= 0) goto L72
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
        L72:
            com.google.protobuf.Duration$Builder r0 = com.google.protobuf.Duration.newBuilder()
            r1 = r11
            com.google.protobuf.Duration$Builder r0 = r0.setSeconds(r1)
            r1 = r10
            com.google.protobuf.Duration$Builder r0 = r0.setNanos(r1)
            com.google.protobuf.Duration r0 = r0.build()
            com.google.protobuf.Duration r0 = checkValid(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.util.Durations.normalizedDuration(long, int):com.google.protobuf.Duration");
    }

    public static Duration parse(String str) throws ParseException {
        boolean z;
        String str2;
        if (str.isEmpty() || str.charAt(str.length() - 1) != 's') {
            throw new ParseException("Invalid duration string: " + str, 0);
        }
        if (str.charAt(0) == '-') {
            str = str.substring(1);
            z = true;
        } else {
            z = false;
        }
        String substring = str.substring(0, str.length() - 1);
        int indexOf = substring.indexOf(46);
        if (indexOf != -1) {
            str2 = substring.substring(indexOf + 1);
            substring = substring.substring(0, indexOf);
        } else {
            str2 = "";
        }
        long parseLong = Long.parseLong(substring);
        int parseNanos = str2.isEmpty() ? 0 : Timestamps.parseNanos(str2);
        if (parseLong < 0) {
            throw new ParseException("Invalid duration string: " + str, 0);
        }
        long j = parseLong;
        int i = parseNanos;
        if (z) {
            j = -parseLong;
            i = -parseNanos;
        }
        try {
            return normalizedDuration(j, i);
        } catch (IllegalArgumentException e) {
            throw new ParseException("Duration value is out of range.", 0);
        }
    }

    public static Duration subtract(Duration duration, Duration duration2) {
        checkValid(duration);
        checkValid(duration2);
        return normalizedDuration(LongMath.checkedSubtract(duration.getSeconds(), duration2.getSeconds()), IntMath.checkedSubtract(duration.getNanos(), duration2.getNanos()));
    }

    public static long toMicros(Duration duration) {
        checkValid(duration);
        return LongMath.checkedAdd(LongMath.checkedMultiply(duration.getSeconds(), 1000000L), duration.getNanos() / 1000);
    }

    public static long toMillis(Duration duration) {
        checkValid(duration);
        return LongMath.checkedAdd(LongMath.checkedMultiply(duration.getSeconds(), 1000L), duration.getNanos() / 1000000);
    }

    public static long toNanos(Duration duration) {
        checkValid(duration);
        return LongMath.checkedAdd(LongMath.checkedMultiply(duration.getSeconds(), 1000000000L), duration.getNanos());
    }

    public static long toSeconds(Duration duration) {
        return checkValid(duration).getSeconds();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0025, code lost:
        if (r0 < 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String toString(com.google.protobuf.Duration r5) {
        /*
            r0 = r5
            com.google.protobuf.Duration r0 = checkValid(r0)
            r0 = r5
            long r0 = r0.getSeconds()
            r10 = r0
            r0 = r5
            int r0 = r0.getNanos()
            r7 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r5 = r0
            r0 = r10
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L28
            r0 = r10
            r8 = r0
            r0 = r7
            r6 = r0
            r0 = r7
            if (r0 >= 0) goto L36
        L28:
            r0 = r5
            java.lang.String r1 = "-"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            long r0 = -r0
            r8 = r0
            r0 = r7
            int r0 = -r0
            r6 = r0
        L36:
            r0 = r5
            r1 = r8
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            if (r0 == 0) goto L50
            r0 = r5
            java.lang.String r1 = "."
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r6
            java.lang.String r1 = com.google.protobuf.util.Timestamps.formatNanos(r1)
            java.lang.StringBuilder r0 = r0.append(r1)
        L50:
            r0 = r5
            java.lang.String r1 = "s"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.util.Durations.toString(com.google.protobuf.Duration):java.lang.String");
    }
}
