package com.squareup.wire.internal;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/InstantJsonFormatter.class */
public final class InstantJsonFormatter implements JsonFormatter<Instant> {
    public static final InstantJsonFormatter INSTANCE = new InstantJsonFormatter();

    private InstantJsonFormatter() {
    }

    @Override // com.squareup.wire.internal.JsonFormatter
    public Instant fromString(String str) {
        Intrinsics.e(str, "value");
        Instant from = Instant.from(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(str));
        Intrinsics.c(from, "from(parsed)");
        return from;
    }

    @Override // com.squareup.wire.internal.JsonFormatter
    public Object toStringOrNumber(Instant instant) {
        Intrinsics.e(instant, "value");
        String format = DateTimeFormatter.ISO_INSTANT.format(instant);
        Intrinsics.c(format, "ISO_INSTANT.format(value)");
        return format;
    }
}
