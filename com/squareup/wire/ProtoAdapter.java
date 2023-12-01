package com.squareup.wire;

import android.app.Instrumentation;
import com.squareup.wire.Message;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.ReflectionKt;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/ProtoAdapter.class */
public abstract class ProtoAdapter<E> {
    public static final ProtoAdapter<Duration> DURATION;
    public static final ProtoAdapter<Instant> INSTANT;
    private final FieldEncoding fieldEncoding;
    private final E identity;
    private final ProtoAdapter<List<E>> packedAdapter;
    private final ProtoAdapter<List<E>> repeatedAdapter;
    private final String sourceFile;
    private final Syntax syntax;
    private final KClass<?> type;
    private final String typeUrl;
    public static final Companion Companion = new Companion(null);
    public static final ProtoAdapter<Boolean> BOOL = ProtoAdapterKt.commonBool();
    public static final ProtoAdapter<Integer> INT32 = ProtoAdapterKt.commonInt32();
    public static final ProtoAdapter<Integer> UINT32 = ProtoAdapterKt.commonUint32();
    public static final ProtoAdapter<Integer> SINT32 = ProtoAdapterKt.commonSint32();
    public static final ProtoAdapter<Integer> FIXED32 = ProtoAdapterKt.commonFixed32();
    public static final ProtoAdapter<Integer> SFIXED32 = ProtoAdapterKt.commonSfixed32();
    public static final ProtoAdapter<Long> INT64 = ProtoAdapterKt.commonInt64();
    public static final ProtoAdapter<Long> UINT64 = ProtoAdapterKt.commonUint64();
    public static final ProtoAdapter<Long> SINT64 = ProtoAdapterKt.commonSint64();
    public static final ProtoAdapter<Long> FIXED64 = ProtoAdapterKt.commonFixed64();
    public static final ProtoAdapter<Long> SFIXED64 = ProtoAdapterKt.commonSfixed64();
    public static final ProtoAdapter<Float> FLOAT = ProtoAdapterKt.commonFloat();
    public static final ProtoAdapter<Double> DOUBLE = ProtoAdapterKt.commonDouble();
    public static final ProtoAdapter<ByteString> BYTES = ProtoAdapterKt.commonBytes();
    public static final ProtoAdapter<String> STRING = ProtoAdapterKt.commonString();
    public static final ProtoAdapter<Unit> EMPTY = ProtoAdapterKt.commonEmpty();
    public static final ProtoAdapter<Map<String, ?>> STRUCT_MAP = ProtoAdapterKt.commonStructMap();
    public static final ProtoAdapter<List<?>> STRUCT_LIST = ProtoAdapterKt.commonStructList();
    public static final ProtoAdapter STRUCT_NULL = ProtoAdapterKt.commonStructNull();
    public static final ProtoAdapter<Object> STRUCT_VALUE = ProtoAdapterKt.commonStructValue();
    public static final ProtoAdapter<Double> DOUBLE_VALUE = ProtoAdapterKt.commonWrapper(DOUBLE, "type.googleapis.com/google.protobuf.DoubleValue");
    public static final ProtoAdapter<Float> FLOAT_VALUE = ProtoAdapterKt.commonWrapper(FLOAT, "type.googleapis.com/google.protobuf.FloatValue");
    public static final ProtoAdapter<Long> INT64_VALUE = ProtoAdapterKt.commonWrapper(INT64, "type.googleapis.com/google.protobuf.Int64Value");
    public static final ProtoAdapter<Long> UINT64_VALUE = ProtoAdapterKt.commonWrapper(UINT64, "type.googleapis.com/google.protobuf.UInt64Value");
    public static final ProtoAdapter<Integer> INT32_VALUE = ProtoAdapterKt.commonWrapper(INT32, "type.googleapis.com/google.protobuf.Int32Value");
    public static final ProtoAdapter<Integer> UINT32_VALUE = ProtoAdapterKt.commonWrapper(UINT32, "type.googleapis.com/google.protobuf.UInt32Value");
    public static final ProtoAdapter<Boolean> BOOL_VALUE = ProtoAdapterKt.commonWrapper(BOOL, "type.googleapis.com/google.protobuf.BoolValue");
    public static final ProtoAdapter<String> STRING_VALUE = ProtoAdapterKt.commonWrapper(STRING, "type.googleapis.com/google.protobuf.StringValue");
    public static final ProtoAdapter<ByteString> BYTES_VALUE = ProtoAdapterKt.commonWrapper(BYTES, "type.googleapis.com/google.protobuf.BytesValue");

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/ProtoAdapter$Companion.class */
    public static final class Companion {

        @Metadata
        /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/ProtoAdapter$Companion$UnsupportedTypeProtoAdapter.class */
        public static final class UnsupportedTypeProtoAdapter extends ProtoAdapter {
            public UnsupportedTypeProtoAdapter() {
                super(FieldEncoding.LENGTH_DELIMITED, Reflection.b(Void.class));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Void decode(ProtoReader protoReader) {
                Intrinsics.e(protoReader, "reader");
                throw new IllegalStateException("Operation not supported.");
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Void encode(ProtoWriter protoWriter, Void r6) {
                Intrinsics.e(protoWriter, "writer");
                Intrinsics.e(r6, "value");
                throw new IllegalStateException("Operation not supported.");
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Void encode(ReverseProtoWriter reverseProtoWriter, Void r6) {
                Intrinsics.e(reverseProtoWriter, "writer");
                Intrinsics.e(r6, "value");
                throw new IllegalStateException("Operation not supported.");
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ int encodedSize(Object obj) {
                return ((Number) encodedSize((Void) obj)).intValue();
            }

            public Void encodedSize(Void r5) {
                Intrinsics.e(r5, "value");
                throw new IllegalStateException("Operation not supported.");
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Void redact(Void r5) {
                Intrinsics.e(r5, "value");
                throw new IllegalStateException("Operation not supported.");
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final <M extends Message<?, ?>> ProtoAdapter<M> get(M m) {
            Intrinsics.e(m, "message");
            return get(m.getClass());
        }

        @JvmStatic
        public final <M> ProtoAdapter<M> get(Class<M> cls) {
            Intrinsics.e(cls, "type");
            try {
                Object obj = cls.getField("ADAPTER").get(null);
                if (obj != null) {
                    return (ProtoAdapter) obj;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<M of com.squareup.wire.ProtoAdapter.Companion.get>");
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException("failed to access " + ((Object) cls.getName()) + "#ADAPTER", e);
            } catch (NoSuchFieldException e2) {
                throw new IllegalArgumentException("failed to access " + ((Object) cls.getName()) + "#ADAPTER", e2);
            }
        }

        @JvmStatic
        public final ProtoAdapter<?> get(String str) {
            Intrinsics.e(str, "adapterString");
            try {
                int a2 = StringsKt.a(str, '#', 0, false, 6, (Object) null);
                String substring = str.substring(0, a2);
                Intrinsics.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String substring2 = str.substring(a2 + 1);
                Intrinsics.c(substring2, "this as java.lang.String).substring(startIndex)");
                Object obj = Class.forName(substring).getField(substring2).get(null);
                if (obj != null) {
                    return (ProtoAdapter) obj;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
            } catch (ClassNotFoundException e) {
                throw new IllegalArgumentException(Intrinsics.a("failed to access ", str), e);
            } catch (IllegalAccessException e2) {
                throw new IllegalArgumentException(Intrinsics.a("failed to access ", str), e2);
            } catch (NoSuchFieldException e3) {
                throw new IllegalArgumentException(Intrinsics.a("failed to access ", str), e3);
            }
        }

        @JvmStatic
        public final <E extends WireEnum> EnumAdapter<E> newEnumAdapter(Class<E> cls) {
            Intrinsics.e(cls, "type");
            return new RuntimeEnumAdapter(cls);
        }

        @JvmStatic
        public final <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
            Intrinsics.e(protoAdapter, "keyAdapter");
            Intrinsics.e(protoAdapter2, "valueAdapter");
            return new MapProtoAdapter(protoAdapter, protoAdapter2);
        }

        @JvmStatic
        public final <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> cls) {
            Intrinsics.e(cls, "type");
            return ReflectionKt.createRuntimeMessageAdapter$default(cls, null, Syntax.PROTO_2, false, 8, null);
        }

        @JvmStatic
        public final <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> cls, String str) {
            Intrinsics.e(cls, "type");
            Intrinsics.e(str, "typeUrl");
            return ReflectionKt.createRuntimeMessageAdapter$default(cls, str, Syntax.PROTO_2, false, 8, null);
        }

        @JvmStatic
        public final <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> cls, String str, Syntax syntax) {
            Intrinsics.e(cls, "type");
            Intrinsics.e(str, "typeUrl");
            Intrinsics.e(syntax, "syntax");
            return ReflectionKt.createRuntimeMessageAdapter$default(cls, str, syntax, false, 8, null);
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/ProtoAdapter$EnumConstantNotFoundException.class */
    public static final class EnumConstantNotFoundException extends IllegalArgumentException {
        public final int value;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public EnumConstantNotFoundException(int i, Class<?> cls) {
            this(i, JvmClassMappingKt.a(cls));
            Intrinsics.e(cls, "type");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public EnumConstantNotFoundException(int r4, kotlin.reflect.KClass<?> r5) {
            /*
                r3 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = r0
                r1.<init>()
                r7 = r0
                r0 = r7
                java.lang.String r1 = "Unknown enum tag "
                java.lang.StringBuilder r0 = r0.append(r1)
                r0 = r7
                r1 = r4
                java.lang.StringBuilder r0 = r0.append(r1)
                r0 = r7
                java.lang.String r1 = " for "
                java.lang.StringBuilder r0 = r0.append(r1)
                r0 = 0
                r6 = r0
                r0 = r5
                if (r0 != 0) goto L2b
                r0 = r6
                r5 = r0
                goto L3e
            L2b:
                r0 = r5
                java.lang.Class r0 = kotlin.jvm.JvmClassMappingKt.a(r0)
                r5 = r0
                r0 = r5
                if (r0 != 0) goto L39
                r0 = r6
                r5 = r0
                goto L3e
            L39:
                r0 = r5
                java.lang.String r0 = r0.getName()
                r5 = r0
            L3e:
                r0 = r7
                r1 = r5
                java.lang.StringBuilder r0 = r0.append(r1)
                r0 = r3
                r1 = r7
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                r0 = r3
                r1 = r4
                r0.value = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.ProtoAdapter.EnumConstantNotFoundException.<init>(int, kotlin.reflect.KClass):void");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        ProtoAdapter unsupportedTypeProtoAdapter;
        ProtoAdapter unsupportedTypeProtoAdapter2;
        try {
            unsupportedTypeProtoAdapter = ProtoAdapterKt.commonDuration();
        } catch (NoClassDefFoundError e) {
            unsupportedTypeProtoAdapter = new Companion.UnsupportedTypeProtoAdapter();
        }
        DURATION = unsupportedTypeProtoAdapter;
        try {
            unsupportedTypeProtoAdapter2 = ProtoAdapterKt.commonInstant();
        } catch (NoClassDefFoundError e2) {
            unsupportedTypeProtoAdapter2 = new Companion.UnsupportedTypeProtoAdapter();
        }
        INSTANT = unsupportedTypeProtoAdapter2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(FieldEncoding fieldEncoding, Class<?> cls) {
        this(fieldEncoding, JvmClassMappingKt.a(cls));
        Intrinsics.e(fieldEncoding, "fieldEncoding");
        Intrinsics.e(cls, "type");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(FieldEncoding fieldEncoding, Class<?> cls, String str) {
        this(fieldEncoding, JvmClassMappingKt.a(cls), str, Syntax.PROTO_2);
        Intrinsics.e(fieldEncoding, "fieldEncoding");
        Intrinsics.e(cls, "type");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(FieldEncoding fieldEncoding, Class<?> cls, String str, Syntax syntax) {
        this(fieldEncoding, JvmClassMappingKt.a(cls), str, syntax);
        Intrinsics.e(fieldEncoding, "fieldEncoding");
        Intrinsics.e(cls, "type");
        Intrinsics.e(syntax, "syntax");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(FieldEncoding fieldEncoding, Class<?> cls, String str, Syntax syntax, E e) {
        this(fieldEncoding, JvmClassMappingKt.a(cls), str, syntax, e, (String) null);
        Intrinsics.e(fieldEncoding, "fieldEncoding");
        Intrinsics.e(cls, "type");
        Intrinsics.e(syntax, "syntax");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(FieldEncoding fieldEncoding, Class<?> cls, String str, Syntax syntax, E e, String str2) {
        this(fieldEncoding, JvmClassMappingKt.a(cls), str, syntax, e, str2);
        Intrinsics.e(fieldEncoding, "fieldEncoding");
        Intrinsics.e(cls, "type");
        Intrinsics.e(syntax, "syntax");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(FieldEncoding fieldEncoding, KClass<?> kClass) {
        this(fieldEncoding, kClass, (String) null, Syntax.PROTO_2);
        Intrinsics.e(fieldEncoding, "fieldEncoding");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(FieldEncoding fieldEncoding, KClass<?> kClass, String str) {
        this(fieldEncoding, kClass, str, Syntax.PROTO_2);
        Intrinsics.e(fieldEncoding, "fieldEncoding");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(FieldEncoding fieldEncoding, KClass<?> kClass, String str, Syntax syntax) {
        this(fieldEncoding, kClass, str, syntax, (Object) null);
        Intrinsics.e(fieldEncoding, "fieldEncoding");
        Intrinsics.e(syntax, "syntax");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProtoAdapter(FieldEncoding fieldEncoding, KClass<?> kClass, String str, Syntax syntax, E e) {
        this(fieldEncoding, kClass, str, syntax, e, (String) null);
        Intrinsics.e(fieldEncoding, "fieldEncoding");
        Intrinsics.e(syntax, "syntax");
    }

    public ProtoAdapter(FieldEncoding fieldEncoding, KClass<?> kClass, String str, Syntax syntax, E e, String str2) {
        PackedProtoAdapter packedProtoAdapter;
        Intrinsics.e(fieldEncoding, "fieldEncoding");
        Intrinsics.e(syntax, "syntax");
        this.fieldEncoding = fieldEncoding;
        this.type = kClass;
        this.typeUrl = str;
        this.syntax = syntax;
        this.identity = e;
        this.sourceFile = str2;
        boolean z = this instanceof PackedProtoAdapter;
        if (z || (this instanceof RepeatedProtoAdapter) || fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
            packedProtoAdapter = null;
        } else {
            if (!(getFieldEncoding$wire_runtime() != FieldEncoding.LENGTH_DELIMITED)) {
                throw new IllegalArgumentException("Unable to pack a length-delimited type.".toString());
            }
            packedProtoAdapter = new PackedProtoAdapter(this);
        }
        this.packedAdapter = packedProtoAdapter;
        this.repeatedAdapter = this instanceof RepeatedProtoAdapter ? null : z ? null : new RepeatedProtoAdapter(this);
    }

    public /* synthetic */ ProtoAdapter(FieldEncoding fieldEncoding, KClass kClass, String str, Syntax syntax, Object obj, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fieldEncoding, kClass, str, syntax, (i & 16) != 0 ? null : obj, (i & 32) != 0 ? null : str2);
    }

    @JvmStatic
    public static final <M extends Message<?, ?>> ProtoAdapter<M> get(M m) {
        return Companion.get((Companion) m);
    }

    @JvmStatic
    public static final <M> ProtoAdapter<M> get(Class<M> cls) {
        return Companion.get(cls);
    }

    @JvmStatic
    public static final ProtoAdapter<?> get(String str) {
        return Companion.get(str);
    }

    @JvmStatic
    public static final <E extends WireEnum> EnumAdapter<E> newEnumAdapter(Class<E> cls) {
        return Companion.newEnumAdapter(cls);
    }

    @JvmStatic
    public static final <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
        return Companion.newMapAdapter(protoAdapter, protoAdapter2);
    }

    @JvmStatic
    public static final <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> cls) {
        return Companion.newMessageAdapter(cls);
    }

    @JvmStatic
    public static final <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> cls, String str) {
        return Companion.newMessageAdapter(cls, str);
    }

    @JvmStatic
    public static final <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> cls, String str, Syntax syntax) {
        return Companion.newMessageAdapter(cls, str, syntax);
    }

    public final ProtoAdapter<List<E>> asPacked() {
        if (this.fieldEncoding != FieldEncoding.LENGTH_DELIMITED) {
            ProtoAdapter<List<E>> protoAdapter = this.packedAdapter;
            if (protoAdapter != null) {
                return protoAdapter;
            }
            throw new UnsupportedOperationException("Can't create a packed adapter from a packed or repeated adapter.");
        }
        throw new IllegalArgumentException("Unable to pack a length-delimited type.".toString());
    }

    public final ProtoAdapter<List<E>> asRepeated() {
        ProtoAdapter<List<E>> protoAdapter = this.repeatedAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        throw new UnsupportedOperationException("Can't create a repeated adapter from a repeated or packed adapter.");
    }

    public abstract E decode(ProtoReader protoReader) throws IOException;

    public final E decode(InputStream inputStream) throws IOException {
        Intrinsics.e(inputStream, Instrumentation.REPORT_KEY_STREAMRESULT);
        return decode(Okio.buffer(Okio.source(inputStream)));
    }

    public final E decode(BufferedSource bufferedSource) throws IOException {
        Intrinsics.e(bufferedSource, "source");
        return decode(new ProtoReader(bufferedSource));
    }

    public final E decode(ByteString byteString) throws IOException {
        Intrinsics.e(byteString, "bytes");
        return decode(new Buffer().write(byteString));
    }

    public final E decode(byte[] bArr) throws IOException {
        Intrinsics.e(bArr, "bytes");
        return decode(new Buffer().write(bArr));
    }

    public abstract void encode(ProtoWriter protoWriter, E e) throws IOException;

    public void encode(ReverseProtoWriter reverseProtoWriter, E e) throws IOException {
        Intrinsics.e(reverseProtoWriter, "writer");
        reverseProtoWriter.writeForward$wire_runtime(new ProtoAdapterKt$delegateEncode$1(this, e));
    }

    public final void encode(OutputStream outputStream, E e) throws IOException {
        Intrinsics.e(outputStream, Instrumentation.REPORT_KEY_STREAMRESULT);
        BufferedSink buffer = Okio.buffer(Okio.sink(outputStream));
        encode(buffer, (BufferedSink) e);
        buffer.emit();
    }

    public final void encode(BufferedSink bufferedSink, E e) throws IOException {
        Intrinsics.e(bufferedSink, "sink");
        ReverseProtoWriter reverseProtoWriter = new ReverseProtoWriter();
        encode(reverseProtoWriter, (ReverseProtoWriter) e);
        reverseProtoWriter.writeTo(bufferedSink);
    }

    public final byte[] encode(E e) {
        BufferedSink buffer = new Buffer();
        encode(buffer, (BufferedSink) e);
        return buffer.readByteArray();
    }

    public final ByteString encodeByteString(E e) {
        BufferedSink buffer = new Buffer();
        encode(buffer, (BufferedSink) e);
        return buffer.readByteString();
    }

    public void encodeWithTag(ProtoWriter protoWriter, int i, E e) throws IOException {
        Intrinsics.e(protoWriter, "writer");
        if (e == null) {
            return;
        }
        protoWriter.writeTag(i, getFieldEncoding$wire_runtime());
        if (getFieldEncoding$wire_runtime() == FieldEncoding.LENGTH_DELIMITED) {
            protoWriter.writeVarint32(encodedSize(e));
        }
        encode(protoWriter, (ProtoWriter) e);
    }

    public void encodeWithTag(ReverseProtoWriter reverseProtoWriter, int i, E e) throws IOException {
        Intrinsics.e(reverseProtoWriter, "writer");
        if (e == null) {
            return;
        }
        if (getFieldEncoding$wire_runtime() == FieldEncoding.LENGTH_DELIMITED) {
            int byteCount = reverseProtoWriter.getByteCount();
            encode(reverseProtoWriter, (ReverseProtoWriter) e);
            reverseProtoWriter.writeVarint32(reverseProtoWriter.getByteCount() - byteCount);
        } else {
            encode(reverseProtoWriter, (ReverseProtoWriter) e);
        }
        reverseProtoWriter.writeTag(i, getFieldEncoding$wire_runtime());
    }

    public abstract int encodedSize(E e);

    public int encodedSizeWithTag(int i, E e) {
        if (e == null) {
            return 0;
        }
        int encodedSize = encodedSize(e);
        int i2 = encodedSize;
        if (getFieldEncoding$wire_runtime() == FieldEncoding.LENGTH_DELIMITED) {
            i2 = encodedSize + ProtoWriter.Companion.varint32Size$wire_runtime(encodedSize);
        }
        return ProtoWriter.Companion.tagSize$wire_runtime(i) + i2;
    }

    public final FieldEncoding getFieldEncoding$wire_runtime() {
        return this.fieldEncoding;
    }

    public final E getIdentity() {
        return this.identity;
    }

    public final ProtoAdapter<List<E>> getPackedAdapter$wire_runtime() {
        return this.packedAdapter;
    }

    public final ProtoAdapter<List<E>> getRepeatedAdapter$wire_runtime() {
        return this.repeatedAdapter;
    }

    public final String getSourceFile() {
        return this.sourceFile;
    }

    public final Syntax getSyntax() {
        return this.syntax;
    }

    public final KClass<?> getType() {
        return this.type;
    }

    public final String getTypeUrl() {
        return this.typeUrl;
    }

    public final boolean isStruct$wire_runtime() {
        return Intrinsics.a(this, STRUCT_MAP) || Intrinsics.a(this, STRUCT_LIST) || Intrinsics.a(this, STRUCT_VALUE) || Intrinsics.a(this, STRUCT_NULL);
    }

    public abstract E redact(E e);

    public String toString(E e) {
        return String.valueOf(e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ProtoAdapter<?> withLabel$wire_runtime(WireField.Label label) {
        Intrinsics.e(label, "label");
        return label.isRepeated() ? label.isPacked() ? asPacked() : asRepeated() : this;
    }
}
