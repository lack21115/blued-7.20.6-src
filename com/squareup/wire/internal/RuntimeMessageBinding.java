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

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/RuntimeMessageBinding.class */
final class RuntimeMessageBinding<M extends Message<M, B>, B extends Message.Builder<M, B>> implements MessageBinding<M, B> {
    private final Class<B> builderType;
    private final Function0<B> createBuilder;
    private final Map<Integer, FieldOrOneOfBinding<M, B>> fields;
    private final KClass<M> messageType;
    private final Syntax syntax;
    private final String typeUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public RuntimeMessageBinding(KClass<M> kClass, Class<B> cls, Function0<? extends B> function0, Map<Integer, ? extends FieldOrOneOfBinding<M, B>> map, String str, Syntax syntax) {
        Intrinsics.e(kClass, "messageType");
        Intrinsics.e(cls, "builderType");
        Intrinsics.e(function0, "createBuilder");
        Intrinsics.e(map, "fields");
        Intrinsics.e(syntax, "syntax");
        this.messageType = kClass;
        this.builderType = cls;
        this.createBuilder = function0;
        this.fields = map;
        this.typeUrl = str;
        this.syntax = syntax;
    }

    public void addUnknownField(B b, int i, FieldEncoding fieldEncoding, Object obj) {
        Intrinsics.e(b, "builder");
        Intrinsics.e(fieldEncoding, "fieldEncoding");
        b.addUnknownField(i, fieldEncoding, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.internal.MessageBinding
    public /* bridge */ /* synthetic */ void addUnknownField(Object obj, int i, FieldEncoding fieldEncoding, Object obj2) {
        addUnknownField((RuntimeMessageBinding<M, B>) ((Message.Builder) obj), i, fieldEncoding, obj2);
    }

    public M build(B b) {
        Intrinsics.e(b, "builder");
        return (M) b.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.internal.MessageBinding
    public /* bridge */ /* synthetic */ Object build(Object obj) {
        return build((RuntimeMessageBinding<M, B>) ((Message.Builder) obj));
    }

    public void clearUnknownFields(B b) {
        Intrinsics.e(b, "builder");
        b.clearUnknownFields();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.internal.MessageBinding
    public /* bridge */ /* synthetic */ void clearUnknownFields(Object obj) {
        clearUnknownFields((RuntimeMessageBinding<M, B>) ((Message.Builder) obj));
    }

    public int getCachedSerializedSize(M m) {
        Intrinsics.e(m, "message");
        return m.getCachedSerializedSize$wire_runtime();
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
        return (B) this.createBuilder.invoke();
    }

    public void setCachedSerializedSize(M m, int i) {
        Intrinsics.e(m, "message");
        m.setCachedSerializedSize$wire_runtime(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.internal.MessageBinding
    public /* bridge */ /* synthetic */ void setCachedSerializedSize(Object obj, int i) {
        setCachedSerializedSize((RuntimeMessageBinding<M, B>) ((Message) obj), i);
    }

    public ByteString unknownFields(M m) {
        Intrinsics.e(m, "message");
        return m.unknownFields();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.internal.MessageBinding
    public /* bridge */ /* synthetic */ ByteString unknownFields(Object obj) {
        return unknownFields((RuntimeMessageBinding<M, B>) ((Message) obj));
    }
}
