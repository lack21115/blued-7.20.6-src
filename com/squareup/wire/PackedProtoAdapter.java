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
    public PackedProtoAdapter(ProtoAdapter<E> protoAdapter) {
        super(FieldEncoding.LENGTH_DELIMITED, Reflection.b(List.class), (String) null, protoAdapter.getSyntax(), CollectionsKt.b());
        Intrinsics.e(protoAdapter, "originalAdapter");
        this.originalAdapter = protoAdapter;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public List<E> decode(ProtoReader protoReader) throws IOException {
        Intrinsics.e(protoReader, "reader");
        return CollectionsKt.a(this.originalAdapter.decode(protoReader));
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Object obj) {
        encode(protoWriter, (List) ((List) obj));
    }

    public void encode(ProtoWriter protoWriter, List<? extends E> list) throws IOException {
        Intrinsics.e(protoWriter, "writer");
        Intrinsics.e(list, "value");
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.originalAdapter.encode(protoWriter, (ProtoWriter) list.get(i2));
            i = i2 + 1;
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Object obj) {
        encode(reverseProtoWriter, (List) ((List) obj));
    }

    public void encode(ReverseProtoWriter reverseProtoWriter, List<? extends E> list) throws IOException {
        Intrinsics.e(reverseProtoWriter, "writer");
        Intrinsics.e(list, "value");
        int size = list.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i = size - 1;
            this.originalAdapter.encode(reverseProtoWriter, (ReverseProtoWriter) list.get(size));
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
    public void encodeWithTag(ProtoWriter protoWriter, int i, List<? extends E> list) throws IOException {
        Intrinsics.e(protoWriter, "writer");
        if (list == 0 || !(!list.isEmpty())) {
            return;
        }
        super.encodeWithTag(protoWriter, i, (int) list);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encodeWithTag(ReverseProtoWriter reverseProtoWriter, int i, Object obj) {
        encodeWithTag(reverseProtoWriter, i, (List) ((List) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void encodeWithTag(ReverseProtoWriter reverseProtoWriter, int i, List<? extends E> list) throws IOException {
        Intrinsics.e(reverseProtoWriter, "writer");
        if (list == 0 || !(!list.isEmpty())) {
            return;
        }
        super.encodeWithTag(reverseProtoWriter, i, (int) list);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object obj) {
        return encodedSize((List) ((List) obj));
    }

    public int encodedSize(List<? extends E> list) {
        Intrinsics.e(list, "value");
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.originalAdapter.encodedSize(list.get(i2));
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

    public List<E> redact(List<? extends E> list) {
        Intrinsics.e(list, "value");
        return CollectionsKt.b();
    }
}
