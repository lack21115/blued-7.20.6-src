package com.squareup.wire;

import java.time.Duration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/DurationKt.class */
public final class DurationKt {
    public static final Duration durationOfSeconds(long j, long j2) {
        Duration ofSeconds = Duration.ofSeconds(j, j2);
        Intrinsics.c(ofSeconds, "ofSeconds(seconds, nano)");
        return ofSeconds;
    }
}
