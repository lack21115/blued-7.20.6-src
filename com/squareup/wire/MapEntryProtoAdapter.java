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
    public MapEntryProtoAdapter(ProtoAdapter<K> keyAdapter, ProtoAdapter<V> valueAdapter) {
        super(FieldEncoding.LENGTH_DELIMITED, Reflection.b(Map.Entry.class), (String) null, valueAdapter.getSyntax());
        Intrinsics.e(keyAdapter, "keyAdapter");
        Intrinsics.e(valueAdapter, "valueAdapter");
        this.keyAdapter = keyAdapter;
        this.valueAdapter = valueAdapter;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public Map.Entry<K, V> decode(ProtoReader reader) {
        Intrinsics.e(reader, "reader");
        throw new UnsupportedOperationException();
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Object obj) {
        encode(protoWriter, (Map.Entry) ((Map.Entry) obj));
    }

    public void encode(ProtoWriter writer, Map.Entry<? extends K, ? extends V> value) throws IOException {
        Intrinsics.e(writer, "writer");
        Intrinsics.e(value, "value");
        this.keyAdapter.encodeWithTag(writer, 1, (int) value.getKey());
        this.valueAdapter.encodeWithTag(writer, 2, (int) value.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Object obj) {
        encode(reverseProtoWriter, (Map.Entry) ((Map.Entry) obj));
    }

    public void encode(ReverseProtoWriter writer, Map.Entry<? extends K, ? extends V> value) throws IOException {
        Intrinsics.e(writer, "writer");
        Intrinsics.e(value, "value");
        this.valueAdapter.encodeWithTag(writer, 2, (int) value.getValue());
        this.keyAdapter.encodeWithTag(writer, 1, (int) value.getKey());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object obj) {
        return encodedSize((Map.Entry) ((Map.Entry) obj));
    }

    public int encodedSize(Map.Entry<? extends K, ? extends V> value) {
        Intrinsics.e(value, "value");
        return this.keyAdapter.encodedSizeWithTag(1, value.getKey()) + this.valueAdapter.encodedSizeWithTag(2, value.getValue());
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

    public Map.Entry<K, V> redact(Map.Entry<? extends K, ? extends V> value) {
        Intrinsics.e(value, "value");
        throw new UnsupportedOperationException();
    }
}
