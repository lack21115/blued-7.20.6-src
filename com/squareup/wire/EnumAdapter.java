package com.squareup.wire;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/EnumAdapter.class */
public abstract class EnumAdapter<E extends WireEnum> extends ProtoAdapter<E> {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EnumAdapter(Class<E> type) {
        this(JvmClassMappingKt.a(type), Syntax.PROTO_2, Internal.getIdentityOrNull(type));
        Intrinsics.e(type, "type");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EnumAdapter(Class<E> type, Syntax syntax) {
        this(JvmClassMappingKt.a(type), syntax, Internal.getIdentityOrNull(type));
        Intrinsics.e(type, "type");
        Intrinsics.e(syntax, "syntax");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EnumAdapter(Class<E> type, Syntax syntax, E e) {
        this(JvmClassMappingKt.a(type), syntax, e);
        Intrinsics.e(type, "type");
        Intrinsics.e(syntax, "syntax");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EnumAdapter(KClass<E> type) {
        this(type, Syntax.PROTO_2, Internal.getIdentityOrNull(JvmClassMappingKt.a(type)));
        Intrinsics.e(type, "type");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EnumAdapter(KClass<E> type, Syntax syntax) {
        this(type, syntax, Internal.getIdentityOrNull(JvmClassMappingKt.a(type)));
        Intrinsics.e(type, "type");
        Intrinsics.e(syntax, "syntax");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnumAdapter(KClass<E> type, Syntax syntax, E e) {
        super(FieldEncoding.VARINT, (KClass<?>) type, (String) null, syntax, e);
        Intrinsics.e(type, "type");
        Intrinsics.e(syntax, "syntax");
    }

    @Override // com.squareup.wire.ProtoAdapter
    public E decode(ProtoReader reader) throws IOException {
        Intrinsics.e(reader, "reader");
        int readVarint32 = reader.readVarint32();
        E fromValue = fromValue(readVarint32);
        if (fromValue != null) {
            return fromValue;
        }
        throw new ProtoAdapter.EnumConstantNotFoundException(readVarint32, getType());
    }

    public void encode(ProtoWriter writer, E value) throws IOException {
        Intrinsics.e(writer, "writer");
        Intrinsics.e(value, "value");
        writer.writeVarint32(value.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Object obj) {
        encode(protoWriter, (ProtoWriter) ((WireEnum) obj));
    }

    public void encode(ReverseProtoWriter writer, E value) {
        Intrinsics.e(writer, "writer");
        Intrinsics.e(value, "value");
        writer.writeVarint32(value.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Object obj) {
        encode(reverseProtoWriter, (ReverseProtoWriter) ((WireEnum) obj));
    }

    public int encodedSize(E value) {
        Intrinsics.e(value, "value");
        return ProtoWriter.Companion.varint32Size$wire_runtime(value.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object obj) {
        return encodedSize((EnumAdapter<E>) ((WireEnum) obj));
    }

    protected abstract E fromValue(int i);

    public E redact(E value) {
        Intrinsics.e(value, "value");
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object redact(Object obj) {
        return redact((EnumAdapter<E>) ((WireEnum) obj));
    }
}
