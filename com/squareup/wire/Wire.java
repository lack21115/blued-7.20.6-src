package com.squareup.wire;

import kotlin.Metadata;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/Wire.class */
public final class Wire {
    public static final <T> T get(T t, T t2) {
        T t3 = t;
        if (t == null) {
            t3 = t2;
        }
        return t3;
    }
}
