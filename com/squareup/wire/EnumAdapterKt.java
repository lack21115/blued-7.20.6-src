package com.squareup.wire;

import com.squareup.wire.ProtoAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/EnumAdapterKt.class */
public final class EnumAdapterKt {
    public static final <E extends WireEnum> E commonDecode(EnumAdapter<E> enumAdapter, ProtoReader protoReader, Function1<? super Integer, ? extends E> function1) {
        Intrinsics.e(enumAdapter, "<this>");
        Intrinsics.e(protoReader, "reader");
        Intrinsics.e(function1, "fromValue");
        int readVarint32 = protoReader.readVarint32();
        E e = (E) function1.invoke(Integer.valueOf(readVarint32));
        if (e != null) {
            return e;
        }
        throw new ProtoAdapter.EnumConstantNotFoundException(readVarint32, enumAdapter.getType());
    }

    public static final <E extends WireEnum> void commonEncode(ProtoWriter protoWriter, E e) {
        Intrinsics.e(protoWriter, "writer");
        Intrinsics.e(e, "value");
        protoWriter.writeVarint32(e.getValue());
    }

    public static final <E extends WireEnum> void commonEncode(ReverseProtoWriter reverseProtoWriter, E e) {
        Intrinsics.e(reverseProtoWriter, "writer");
        Intrinsics.e(e, "value");
        reverseProtoWriter.writeVarint32(e.getValue());
    }

    public static final <E extends WireEnum> int commonEncodedSize(E e) {
        Intrinsics.e(e, "value");
        return ProtoWriter.Companion.varint32Size$wire_runtime(e.getValue());
    }

    public static final <E extends WireEnum> E commonRedact(E e) {
        Intrinsics.e(e, "value");
        throw new UnsupportedOperationException();
    }
}
