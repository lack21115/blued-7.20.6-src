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
    public EnumAdapter(Class<E> cls) {
        this(JvmClassMappingKt.a(cls), Syntax.PROTO_2, Internal.getIdentityOrNull(cls));
        Intrinsics.e(cls, "type");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EnumAdapter(Class<E> cls, Syntax syntax) {
        this(JvmClassMappingKt.a(cls), syntax, Internal.getIdentityOrNull(cls));
        Intrinsics.e(cls, "type");
        Intrinsics.e(syntax, "syntax");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EnumAdapter(Class<E> cls, Syntax syntax, E e) {
        this(JvmClassMappingKt.a(cls), syntax, e);
        Intrinsics.e(cls, "type");
        Intrinsics.e(syntax, "syntax");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EnumAdapter(KClass<E> kClass) {
        this(kClass, Syntax.PROTO_2, Internal.getIdentityOrNull(JvmClassMappingKt.a(kClass)));
        Intrinsics.e(kClass, "type");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EnumAdapter(KClass<E> kClass, Syntax syntax) {
        this(kClass, syntax, Internal.getIdentityOrNull(JvmClassMappingKt.a(kClass)));
        Intrinsics.e(kClass, "type");
        Intrinsics.e(syntax, "syntax");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnumAdapter(KClass<E> kClass, Syntax syntax, E e) {
        super(FieldEncoding.VARINT, (KClass<?>) kClass, (String) null, syntax, e);
        Intrinsics.e(kClass, "type");
        Intrinsics.e(syntax, "syntax");
    }

    @Override // com.squareup.wire.ProtoAdapter
    public E decode(ProtoReader protoReader) throws IOException {
        Intrinsics.e(protoReader, "reader");
        int readVarint32 = protoReader.readVarint32();
        E fromValue = fromValue(readVarint32);
        if (fromValue != null) {
            return fromValue;
        }
        throw new ProtoAdapter.EnumConstantNotFoundException(readVarint32, getType());
    }

    public void encode(ProtoWriter protoWriter, E e) throws IOException {
        Intrinsics.e(protoWriter, "writer");
        Intrinsics.e(e, "value");
        protoWriter.writeVarint32(e.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Object obj) {
        encode(protoWriter, (ProtoWriter) ((WireEnum) obj));
    }

    public void encode(ReverseProtoWriter reverseProtoWriter, E e) {
        Intrinsics.e(reverseProtoWriter, "writer");
        Intrinsics.e(e, "value");
        reverseProtoWriter.writeVarint32(e.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Object obj) {
        encode(reverseProtoWriter, (ReverseProtoWriter) ((WireEnum) obj));
    }

    public int encodedSize(E e) {
        Intrinsics.e(e, "value");
        return ProtoWriter.Companion.varint32Size$wire_runtime(e.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object obj) {
        return encodedSize((EnumAdapter<E>) ((WireEnum) obj));
    }

    protected abstract E fromValue(int i);

    public E redact(E e) {
        Intrinsics.e(e, "value");
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object redact(Object obj) {
        return redact((EnumAdapter<E>) ((WireEnum) obj));
    }
}
