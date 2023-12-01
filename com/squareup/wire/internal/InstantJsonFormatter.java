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
    public Instant fromString(String value) {
        Intrinsics.e(value, "value");
        Instant from = Instant.from(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(value));
        Intrinsics.c(from, "from(parsed)");
        return from;
    }

    @Override // com.squareup.wire.internal.JsonFormatter
    public Object toStringOrNumber(Instant value) {
        Intrinsics.e(value, "value");
        String format = DateTimeFormatter.ISO_INSTANT.format(value);
        Intrinsics.c(format, "ISO_INSTANT.format(value)");
        return format;
    }
}
