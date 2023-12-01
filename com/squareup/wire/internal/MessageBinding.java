package com.squareup.wire.internal;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Syntax;
import java.util.Map;
import kotlin.Metadata;
import kotlin.reflect.KClass;
import okio.ByteString;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/MessageBinding.class */
public interface MessageBinding<M, B> {
    void addUnknownField(B b, int i, FieldEncoding fieldEncoding, Object obj);

    M build(B b);

    void clearUnknownFields(B b);

    int getCachedSerializedSize(M m);

    Map<Integer, FieldOrOneOfBinding<M, B>> getFields();

    KClass<? super M> getMessageType();

    Syntax getSyntax();

    String getTypeUrl();

    B newBuilder();

    void setCachedSerializedSize(M m, int i);

    ByteString unknownFields(M m);
}
