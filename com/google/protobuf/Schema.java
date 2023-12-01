package com.google.protobuf;

import com.google.protobuf.ArrayDecoders;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/Schema.class */
public interface Schema<T> {
    boolean equals(T t, T t2);

    int getSerializedSize(T t);

    int hashCode(T t);

    boolean isInitialized(T t);

    void makeImmutable(T t);

    void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    void mergeFrom(T t, T t2);

    void mergeFrom(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers) throws IOException;

    T newInstance();

    void writeTo(T t, Writer writer) throws IOException;
}