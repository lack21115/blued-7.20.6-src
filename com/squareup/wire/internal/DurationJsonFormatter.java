package com.squareup.wire.internal;

import com.xiaomi.mipush.sdk.Constants;
import java.time.Duration;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/DurationJsonFormatter.class */
public final class DurationJsonFormatter implements JsonFormatter<Duration> {
    public static final DurationJsonFormatter INSTANCE = new DurationJsonFormatter();

    private DurationJsonFormatter() {
    }

    @Override // com.squareup.wire.internal.JsonFormatter
    public Duration fromString(String str) {
        int i;
        long j;
        Intrinsics.e(str, "value");
        String str2 = str;
        int a2 = StringsKt.a(str2, 's', 0, false, 6, (Object) null);
        if (a2 == str.length() - 1) {
            int a3 = StringsKt.a(str2, '.', 0, false, 6, (Object) null);
            if (a3 == -1) {
                String substring = str.substring(0, a2);
                Intrinsics.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                Duration ofSeconds = Duration.ofSeconds(Long.parseLong(substring));
                Intrinsics.c(ofSeconds, "ofSeconds(seconds)");
                return ofSeconds;
            }
            String substring2 = str.substring(0, a3);
            Intrinsics.c(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            long parseLong = Long.parseLong(substring2);
            int i2 = a3 + 1;
            String substring3 = str.substring(i2, a2);
            Intrinsics.c(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
            long parseLong2 = Long.parseLong(substring3);
            long j2 = parseLong2;
            if (StringsKt.a(str, Constants.ACCEPT_TIME_SEPARATOR_SERVER, false, 2, (Object) null)) {
                j2 = -parseLong2;
            }
            int i3 = a2 - i2;
            int i4 = i3;
            while (true) {
                i = 9;
                j = j2;
                if (i4 >= 9) {
                    break;
                }
                i4++;
                j2 *= 10;
            }
            while (i < i3) {
                i++;
                j /= 10;
            }
            Duration ofSeconds2 = Duration.ofSeconds(parseLong, j);
            Intrinsics.c(ofSeconds2, "ofSeconds(seconds, nanos)");
            return ofSeconds2;
        }
        throw new NumberFormatException();
    }

    @Override // com.squareup.wire.internal.JsonFormatter
    public String toStringOrNumber(Duration duration) {
        Object obj;
        int i;
        long j;
        Object obj2;
        Intrinsics.e(duration, "value");
        long seconds = duration.getSeconds();
        int nano = duration.getNano();
        if (seconds < 0) {
            if (seconds == Long.MIN_VALUE) {
                j = 8;
                obj2 = "-922337203685477580";
            } else {
                j = -seconds;
                obj2 = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            }
            seconds = j;
            obj = obj2;
            i = nano;
            if (nano != 0) {
                seconds = j - 1;
                i = 1000000000 - nano;
                obj = obj2;
            }
        } else {
            obj = "";
            i = nano;
        }
        if (i == 0) {
            String format = String.format("%s%ds", Arrays.copyOf(new Object[]{obj, Long.valueOf(seconds)}, 2));
            Intrinsics.c(format, "format(this, *args)");
            return format;
        } else if (i % 1000000 == 0) {
            String format2 = String.format("%s%d.%03ds", Arrays.copyOf(new Object[]{obj, Long.valueOf(seconds), Long.valueOf(i / 1000000)}, 3));
            Intrinsics.c(format2, "format(this, *args)");
            return format2;
        } else if (i % 1000 == 0) {
            String format3 = String.format("%s%d.%06ds", Arrays.copyOf(new Object[]{obj, Long.valueOf(seconds), Long.valueOf(i / 1000)}, 3));
            Intrinsics.c(format3, "format(this, *args)");
            return format3;
        } else {
            String format4 = String.format("%s%d.%09ds", Arrays.copyOf(new Object[]{obj, Long.valueOf(seconds), Long.valueOf(i / 1)}, 3));
            Intrinsics.c(format4, "format(this, *args)");
            return format4;
        }
    }
}
