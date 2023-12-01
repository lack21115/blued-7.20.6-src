package com.squareup.wire;

import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/RepeatedProtoAdapter.class */
public final class RepeatedProtoAdapter<E> extends ProtoAdapter<List<? extends E>> {
    private final ProtoAdapter<E> originalAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RepeatedProtoAdapter(ProtoAdapter<E> protoAdapter) {
        super(protoAdapter.getFieldEncoding$wire_runtime(), Reflection.b(List.class), (String) null, protoAdapter.getSyntax(), CollectionsKt.b());
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

    public void encode(ProtoWriter protoWriter, List<? extends E> list) {
        Intrinsics.e(protoWriter, "writer");
        Intrinsics.e(list, "value");
        throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Object obj) {
        encode(reverseProtoWriter, (List) ((List) obj));
    }

    public void encode(ReverseProtoWriter reverseProtoWriter, List<? extends E> list) {
        Intrinsics.e(reverseProtoWriter, "writer");
        Intrinsics.e(list, "value");
        throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encodeWithTag(ProtoWriter protoWriter, int i, Object obj) {
        encodeWithTag(protoWriter, i, (List) ((List) obj));
    }

    public void encodeWithTag(ProtoWriter protoWriter, int i, List<? extends E> list) throws IOException {
        Intrinsics.e(protoWriter, "writer");
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.originalAdapter.encodeWithTag(protoWriter, i, (int) list.get(i2));
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encodeWithTag(ReverseProtoWriter reverseProtoWriter, int i, Object obj) {
        encodeWithTag(reverseProtoWriter, i, (List) ((List) obj));
    }

    public void encodeWithTag(ReverseProtoWriter reverseProtoWriter, int i, List<? extends E> list) throws IOException {
        Intrinsics.e(reverseProtoWriter, "writer");
        if (list == null) {
            return;
        }
        int size = list.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i2 = size - 1;
            this.originalAdapter.encodeWithTag(reverseProtoWriter, i, (int) list.get(size));
            if (i2 < 0) {
                return;
            }
            size = i2;
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object obj) {
        return encodedSize((List) ((List) obj));
    }

    public int encodedSize(List<? extends E> list) {
        Intrinsics.e(list, "value");
        throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSizeWithTag(int i, Object obj) {
        return encodedSizeWithTag(i, (List) ((List) obj));
    }

    public int encodedSizeWithTag(int i, List<? extends E> list) {
        if (list == null) {
            return 0;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += this.originalAdapter.encodedSizeWithTag(i, list.get(i3));
        }
        return i2;
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
