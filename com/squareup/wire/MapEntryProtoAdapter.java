package com.squareup.wire;

import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/MapEntryProtoAdapter.class */
public final class MapEntryProtoAdapter<K, V> extends ProtoAdapter<Map.Entry<? extends K, ? extends V>> {
    private final ProtoAdapter<K> keyAdapter;
    private final ProtoAdapter<V> valueAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapEntryProtoAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
        super(FieldEncoding.LENGTH_DELIMITED, Reflection.b(Map.Entry.class), (String) null, protoAdapter2.getSyntax());
        Intrinsics.e(protoAdapter, "keyAdapter");
        Intrinsics.e(protoAdapter2, "valueAdapter");
        this.keyAdapter = protoAdapter;
        this.valueAdapter = protoAdapter2;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public Map.Entry<K, V> decode(ProtoReader protoReader) {
        Intrinsics.e(protoReader, "reader");
        throw new UnsupportedOperationException();
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Object obj) {
        encode(protoWriter, (Map.Entry) ((Map.Entry) obj));
    }

    public void encode(ProtoWriter protoWriter, Map.Entry<? extends K, ? extends V> entry) throws IOException {
        Intrinsics.e(protoWriter, "writer");
        Intrinsics.e(entry, "value");
        this.keyAdapter.encodeWithTag(protoWriter, 1, (int) entry.getKey());
        this.valueAdapter.encodeWithTag(protoWriter, 2, (int) entry.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Object obj) {
        encode(reverseProtoWriter, (Map.Entry) ((Map.Entry) obj));
    }

    public void encode(ReverseProtoWriter reverseProtoWriter, Map.Entry<? extends K, ? extends V> entry) throws IOException {
        Intrinsics.e(reverseProtoWriter, "writer");
        Intrinsics.e(entry, "value");
        this.valueAdapter.encodeWithTag(reverseProtoWriter, 2, (int) entry.getValue());
        this.keyAdapter.encodeWithTag(reverseProtoWriter, 1, (int) entry.getKey());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object obj) {
        return encodedSize((Map.Entry) ((Map.Entry) obj));
    }

    public int encodedSize(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.e(entry, "value");
        return this.keyAdapter.encodedSizeWithTag(1, entry.getKey()) + this.valueAdapter.encodedSizeWithTag(2, entry.getValue());
    }

    public final ProtoAdapter<K> getKeyAdapter$wire_runtime() {
        return this.keyAdapter;
    }

    public final ProtoAdapter<V> getValueAdapter$wire_runtime() {
        return this.valueAdapter;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object redact(Object obj) {
        return redact((Map.Entry) ((Map.Entry) obj));
    }

    public Map.Entry<K, V> redact(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.e(entry, "value");
        throw new UnsupportedOperationException();
    }
}
