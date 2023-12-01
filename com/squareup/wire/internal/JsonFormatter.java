package com.squareup.wire.internal;

import kotlin.Metadata;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/JsonFormatter.class */
public interface JsonFormatter<W> {
    W fromString(String str);

    Object toStringOrNumber(W w);
}
