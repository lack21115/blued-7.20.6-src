package com.squareup.wire;

import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/MessageSource.class */
public interface MessageSource<T> extends Closeable {
    T read() throws IOException;
}
