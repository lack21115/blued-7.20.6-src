package com.squareup.wire;

import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/PackedProtoAdapter.class */
public final class PackedProtoAdapter<E> extends ProtoAdapter<List<? extends E>> {
    private final ProtoAdapter<E> originalAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PackedProtoAdapter(ProtoAdapter<E> originalAdapter) {
        super(FieldEncoding.LENGTH_DELIMITED, Reflection.b(List.class), (String) null, originalAdapter.getSyntax(), CollectionsKt.b());
        Intrinsics.e(originalAdapter, "originalAdapter");
        this.originalAdapter = originalAdapter;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public List<E> decode(ProtoReader reader) throws IOException {
        Intrinsics.e(reader, "reader");
        return CollectionsKt.a(this.originalAdapter.decode(reader));
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Object obj) {
        encode(protoWriter, (List) ((List) obj));
    }

    public void encode(ProtoWriter writer, List<? extends E> value) throws IOException {
        Intrinsics.e(writer, "writer");
        Intrinsics.e(value, "value");
        int size = value.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.originalAdapter.encode(writer, (ProtoWriter) value.get(i2));
            i = i2 + 1;
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Object obj) {
        encode(reverseProtoWriter, (List) ((List) obj));
    }

    public void encode(ReverseProtoWriter writer, List<? extends E> value) throws IOException {
        Intrinsics.e(writer, "writer");
        Intrinsics.e(value, "value");
        int size = value.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i = size - 1;
            this.originalAdapter.encode(writer, (ReverseProtoWriter) value.get(size));
            if (i < 0) {
                return;
            }
            size = i;
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encodeWithTag(ProtoWriter protoWriter, int i, Object obj) {
        encodeWithTag(protoWriter, i, (List) ((List) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void encodeWithTag(ProtoWriter writer, int i, List<? extends E> list) throws IOException {
        Intrinsics.e(writer, "writer");
        if (list == 0 || !(!list.isEmpty())) {
            return;
        }
        super.encodeWithTag(writer, i, (int) list);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encodeWithTag(ReverseProtoWriter reverseProtoWriter, int i, Object obj) {
        encodeWithTag(reverseProtoWriter, i, (List) ((List) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void encodeWithTag(ReverseProtoWriter writer, int i, List<? extends E> list) throws IOException {
        Intrinsics.e(writer, "writer");
        if (list == 0 || !(!list.isEmpty())) {
            return;
        }
        super.encodeWithTag(writer, i, (int) list);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object obj) {
        return encodedSize((List) ((List) obj));
    }

    public int encodedSize(List<? extends E> value) {
        Intrinsics.e(value, "value");
        int size = value.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.originalAdapter.encodedSize(value.get(i2));
        }
        return i;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSizeWithTag(int i, Object obj) {
        return encodedSizeWithTag(i, (List) ((List) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int encodedSizeWithTag(int i, List<? extends E> list) {
        if (list == 0 || list.isEmpty()) {
            return 0;
        }
        return super.encodedSizeWithTag(i, (int) list);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object redact(Object obj) {
        return redact((List) ((List) obj));
    }

    public List<E> redact(List<? extends E> value) {
        Intrinsics.e(value, "value");
        return CollectionsKt.b();
    }
}
