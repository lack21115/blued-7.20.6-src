package com.squareup.wire;

import com.squareup.wire.OneOf.Key;
import com.squareup.wire.internal.Internal;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/OneOf.class */
public final class OneOf<K extends Key<T>, T> {
    private final K key;
    private final T value;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/OneOf$Key.class */
    public static abstract class Key<T> {
        private final ProtoAdapter<T> adapter;
        private final String declaredName;
        private final String jsonName;
        private final boolean redacted;
        private final int tag;

        public Key(int i, ProtoAdapter<T> adapter, String declaredName, boolean z, String jsonName) {
            Intrinsics.e(adapter, "adapter");
            Intrinsics.e(declaredName, "declaredName");
            Intrinsics.e(jsonName, "jsonName");
            this.tag = i;
            this.adapter = adapter;
            this.declaredName = declaredName;
            this.redacted = z;
            this.jsonName = jsonName;
        }

        public /* synthetic */ Key(int i, ProtoAdapter protoAdapter, String str, boolean z, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, protoAdapter, str, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? "" : str2);
        }

        public final ProtoAdapter<T> getAdapter() {
            return this.adapter;
        }

        public final String getDeclaredName() {
            return this.declaredName;
        }

        public final String getJsonName() {
            return this.jsonName;
        }

        public final boolean getRedacted() {
            return this.redacted;
        }

        public final int getTag() {
            return this.tag;
        }
    }

    public OneOf(K key, T t) {
        Intrinsics.e(key, "key");
        this.key = key;
        this.value = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OneOf copy$default(OneOf oneOf, Key key, Object obj, int i, Object obj2) {
        K k = key;
        if ((i & 1) != 0) {
            k = oneOf.key;
        }
        T t = obj;
        if ((i & 2) != 0) {
            t = oneOf.value;
        }
        return oneOf.copy(k, t);
    }

    public final K component1() {
        return this.key;
    }

    public final T component2() {
        return this.value;
    }

    public final OneOf<K, T> copy(K key, T t) {
        Intrinsics.e(key, "key");
        return new OneOf<>(key, t);
    }

    public final void encodeWithTag(ProtoWriter writer) {
        Intrinsics.e(writer, "writer");
        this.key.getAdapter().encodeWithTag(writer, this.key.getTag(), (int) this.value);
    }

    public final void encodeWithTag(ReverseProtoWriter writer) {
        Intrinsics.e(writer, "writer");
        this.key.getAdapter().encodeWithTag(writer, this.key.getTag(), (int) this.value);
    }

    public final int encodedSizeWithTag() {
        return this.key.getAdapter().encodedSizeWithTag(this.key.getTag(), this.value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OneOf) {
            OneOf oneOf = (OneOf) obj;
            return Intrinsics.a(this.key, oneOf.key) && Intrinsics.a(this.value, oneOf.value);
        }
        return false;
    }

    public final K getKey() {
        return this.key;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [T, X] */
    public final <X> X getOrNull(Key<X> key) {
        Intrinsics.e(key, "key");
        if (Intrinsics.a(this.key, key)) {
            return this.value;
        }
        return null;
    }

    public final T getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode = this.key.hashCode();
        T t = this.value;
        return (hashCode * 31) + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        ProtoAdapter<T> adapter = this.key.getAdapter();
        String sanitize = Intrinsics.a(adapter, ProtoAdapter.STRING) ? true : Intrinsics.a(adapter, ProtoAdapter.STRING_VALUE) ? Internal.sanitize(String.valueOf(this.value)) : String.valueOf(this.value);
        return this.key.getDeclaredName() + '=' + sanitize;
    }
}
