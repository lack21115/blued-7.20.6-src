package com.squareup.wire;

import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/MapProtoAdapter.class */
public final class MapProtoAdapter<K, V> extends ProtoAdapter<Map<K, ? extends V>> {
    private final MapEntryProtoAdapter<K, V> entryAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapProtoAdapter(ProtoAdapter<K> keyAdapter, ProtoAdapter<V> valueAdapter) {
        super(FieldEncoding.LENGTH_DELIMITED, Reflection.b(Map.class), (String) null, valueAdapter.getSyntax(), MapsKt.a());
        Intrinsics.e(keyAdapter, "keyAdapter");
        Intrinsics.e(valueAdapter, "valueAdapter");
        this.entryAdapter = new MapEntryProtoAdapter<>(keyAdapter, valueAdapter);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public Map<K, V> decode(ProtoReader reader) throws IOException {
        Intrinsics.e(reader, "reader");
        K identity = this.entryAdapter.getKeyAdapter$wire_runtime().getIdentity();
        V identity2 = this.entryAdapter.getValueAdapter$wire_runtime().getIdentity();
        long beginMessage = reader.beginMessage();
        while (true) {
            int nextTag = reader.nextTag();
            if (nextTag == -1) {
                break;
            } else if (nextTag == 1) {
                identity = this.entryAdapter.getKeyAdapter$wire_runtime().decode(reader);
            } else if (nextTag == 2) {
                identity2 = this.entryAdapter.getValueAdapter$wire_runtime().decode(reader);
            }
        }
        reader.endMessageAndGetUnknownFields(beginMessage);
        if (identity != null) {
            if (identity2 != null) {
                return MapsKt.a(TuplesKt.a(identity, identity2));
            }
            throw new IllegalStateException("Map entry with null value".toString());
        }
        throw new IllegalStateException("Map entry with null key".toString());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Object obj) {
        encode(protoWriter, (Map) ((Map) obj));
    }

    public void encode(ProtoWriter writer, Map<K, ? extends V> value) {
        Intrinsics.e(writer, "writer");
        Intrinsics.e(value, "value");
        throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Object obj) {
        encode(reverseProtoWriter, (Map) ((Map) obj));
    }

    public void encode(ReverseProtoWriter writer, Map<K, ? extends V> value) {
        Intrinsics.e(writer, "writer");
        Intrinsics.e(value, "value");
        throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encodeWithTag(ProtoWriter protoWriter, int i, Object obj) {
        encodeWithTag(protoWriter, i, (Map) ((Map) obj));
    }

    public void encodeWithTag(ProtoWriter writer, int i, Map<K, ? extends V> map) throws IOException {
        Intrinsics.e(writer, "writer");
        if (map == null) {
            return;
        }
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            this.entryAdapter.encodeWithTag(writer, i, (int) entry);
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encodeWithTag(ReverseProtoWriter reverseProtoWriter, int i, Object obj) {
        encodeWithTag(reverseProtoWriter, i, (Map) ((Map) obj));
    }

    public void encodeWithTag(ReverseProtoWriter writer, int i, Map<K, ? extends V> map) throws IOException {
        Intrinsics.e(writer, "writer");
        if (map == null) {
            return;
        }
        int i2 = 0;
        Object[] array = map.entrySet().toArray(new Map.Entry[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        Map.Entry[] entryArr = (Map.Entry[]) array;
        ArraysKt.c(entryArr);
        int length = entryArr.length;
        while (i2 < length) {
            Map.Entry entry = entryArr[i2];
            i2++;
            this.entryAdapter.encodeWithTag(writer, i, (int) entry);
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object obj) {
        return encodedSize((Map) ((Map) obj));
    }

    public int encodedSize(Map<K, ? extends V> value) {
        Intrinsics.e(value, "value");
        throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSizeWithTag(int i, Object obj) {
        return encodedSizeWithTag(i, (Map) ((Map) obj));
    }

    public int encodedSizeWithTag(int i, Map<K, ? extends V> map) {
        int i2 = 0;
        if (map == null) {
            return 0;
        }
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            i2 += this.entryAdapter.encodedSizeWithTag(i, entry);
        }
        return i2;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object redact(Object obj) {
        return redact((Map) ((Map) obj));
    }

    public Map<K, V> redact(Map<K, ? extends V> value) {
        Intrinsics.e(value, "value");
        return MapsKt.a();
    }
}
