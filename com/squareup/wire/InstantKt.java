package com.squareup.wire;

import java.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/InstantKt.class */
public final class InstantKt {
    public static final Instant ofEpochSecond(long j, long j2) {
        Instant ofEpochSecond = Instant.ofEpochSecond(j, j2);
        Intrinsics.c(ofEpochSecond, "ofEpochSecond(epochSecond, nano)");
        return ofEpochSecond;
    }
}
