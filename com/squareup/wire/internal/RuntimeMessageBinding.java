package com.squareup.wire.internal;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.Syntax;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/RuntimeMessageBinding.class */
public final class RuntimeMessageBinding<M extends Message<M, B>, B extends Message.Builder<M, B>> implements MessageBinding<M, B> {
    private final Class<B> builderType;
    private final Function0<B> createBuilder;
    private final Map<Integer, FieldOrOneOfBinding<M, B>> fields;
    private final KClass<M> messageType;
    private final Syntax syntax;
    private final String typeUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public RuntimeMessageBinding(KClass<M> messageType, Class<B> builderType, Function0<? extends B> createBuilder, Map<Integer, ? extends FieldOrOneOfBinding<M, B>> fields, String str, Syntax syntax) {
        Intrinsics.e(messageType, "messageType");
        Intrinsics.e(builderType, "builderType");
        Intrinsics.e(createBuilder, "createBuilder");
        Intrinsics.e(fields, "fields");
        Intrinsics.e(syntax, "syntax");
        this.messageType = messageType;
        this.builderType = builderType;
        this.createBuilder = createBuilder;
        this.fields = fields;
        this.typeUrl = str;
        this.syntax = syntax;
    }

    public void addUnknownField(B builder, int i, FieldEncoding fieldEncoding, Object obj) {
        Intrinsics.e(builder, "builder");
        Intrinsics.e(fieldEncoding, "fieldEncoding");
        builder.addUnknownField(i, fieldEncoding, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.internal.MessageBinding
    public /* bridge */ /* synthetic */ void addUnknownField(Object obj, int i, FieldEncoding fieldEncoding, Object obj2) {
        addUnknownField((RuntimeMessageBinding<M, B>) ((Message.Builder) obj), i, fieldEncoding, obj2);
    }

    public M build(B builder) {
        Intrinsics.e(builder, "builder");
        return (M) builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.internal.MessageBinding
    public /* bridge */ /* synthetic */ Object build(Object obj) {
        return build((RuntimeMessageBinding<M, B>) ((Message.Builder) obj));
    }

    public void clearUnknownFields(B builder) {
        Intrinsics.e(builder, "builder");
        builder.clearUnknownFields();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.internal.MessageBinding
    public /* bridge */ /* synthetic */ void clearUnknownFields(Object obj) {
        clearUnknownFields((RuntimeMessageBinding<M, B>) ((Message.Builder) obj));
    }

    public int getCachedSerializedSize(M message) {
        Intrinsics.e(message, "message");
        return message.getCachedSerializedSize$wire_runtime();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.internal.MessageBinding
    public /* bridge */ /* synthetic */ int getCachedSerializedSize(Object obj) {
        return getCachedSerializedSize((RuntimeMessageBinding<M, B>) ((Message) obj));
    }

    @Override // com.squareup.wire.internal.MessageBinding
    public Map<Integer, FieldOrOneOfBinding<M, B>> getFields() {
        return this.fields;
    }

    @Override // com.squareup.wire.internal.MessageBinding
    public KClass<M> getMessageType() {
        return this.messageType;
    }

    @Override // com.squareup.wire.internal.MessageBinding
    public Syntax getSyntax() {
        return this.syntax;
    }

    @Override // com.squareup.wire.internal.MessageBinding
    public String getTypeUrl() {
        return this.typeUrl;
    }

    @Override // com.squareup.wire.internal.MessageBinding
    public B newBuilder() {
        return this.createBuilder.invoke();
    }

    public void setCachedSerializedSize(M message, int i) {
        Intrinsics.e(message, "message");
        message.setCachedSerializedSize$wire_runtime(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.internal.MessageBinding
    public /* bridge */ /* synthetic */ void setCachedSerializedSize(Object obj, int i) {
        setCachedSerializedSize((RuntimeMessageBinding<M, B>) ((Message) obj), i);
    }

    public ByteString unknownFields(M message) {
        Intrinsics.e(message, "message");
        return message.unknownFields();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.internal.MessageBinding
    public /* bridge */ /* synthetic */ ByteString unknownFields(Object obj) {
        return unknownFields((RuntimeMessageBinding<M, B>) ((Message) obj));
    }
}
