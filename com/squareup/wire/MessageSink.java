package com.squareup.wire;

import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/MessageSink.class */
public interface MessageSink<T> extends Closeable {
    void cancel() throws IOException;

    void write(T t) throws IOException;
}
