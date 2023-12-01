package com.squareup.wire;

import com.squareup.wire.ProtoAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/EnumAdapterKt.class */
public final class EnumAdapterKt {
    public static final <E extends WireEnum> E commonDecode(EnumAdapter<E> enumAdapter, ProtoReader reader, Function1<? super Integer, ? extends E> fromValue) {
        Intrinsics.e(enumAdapter, "<this>");
        Intrinsics.e(reader, "reader");
        Intrinsics.e(fromValue, "fromValue");
        int readVarint32 = reader.readVarint32();
        E invoke = fromValue.invoke(Integer.valueOf(readVarint32));
        if (invoke != null) {
            return invoke;
        }
        throw new ProtoAdapter.EnumConstantNotFoundException(readVarint32, enumAdapter.getType());
    }

    public static final <E extends WireEnum> void commonEncode(ProtoWriter writer, E value) {
        Intrinsics.e(writer, "writer");
        Intrinsics.e(value, "value");
        writer.writeVarint32(value.getValue());
    }

    public static final <E extends WireEnum> void commonEncode(ReverseProtoWriter writer, E value) {
        Intrinsics.e(writer, "writer");
        Intrinsics.e(value, "value");
        writer.writeVarint32(value.getValue());
    }

    public static final <E extends WireEnum> int commonEncodedSize(E value) {
        Intrinsics.e(value, "value");
        return ProtoWriter.Companion.varint32Size$wire_runtime(value.getValue());
    }

    public static final <E extends WireEnum> E commonRedact(E value) {
        Intrinsics.e(value, "value");
        throw new UnsupportedOperationException();
    }
}
