package com.squareup.wire.internal;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/JsonIntegration.class */
public abstract class JsonIntegration<F, A> {

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/JsonIntegration$ByteStringJsonFormatter.class */
    public static final class ByteStringJsonFormatter implements JsonFormatter<ByteString> {
        public static final ByteStringJsonFormatter INSTANCE = new ByteStringJsonFormatter();

        private ByteStringJsonFormatter() {
        }

        @Override // com.squareup.wire.internal.JsonFormatter
        public ByteString fromString(String value) {
            Intrinsics.e(value, "value");
            return ByteString.Companion.decodeBase64(value);
        }

        @Override // com.squareup.wire.internal.JsonFormatter
        public String toStringOrNumber(ByteString value) {
            Intrinsics.e(value, "value");
            return value.base64();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/JsonIntegration$IntAsStringJsonFormatter.class */
    public static final class IntAsStringJsonFormatter implements JsonFormatter<Integer> {
        public static final IntAsStringJsonFormatter INSTANCE = new IntAsStringJsonFormatter();

        private IntAsStringJsonFormatter() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.internal.JsonFormatter
        public Integer fromString(String value) {
            Intrinsics.e(value, "value");
            return Integer.valueOf(Integer.parseInt(value));
        }

        @Override // com.squareup.wire.internal.JsonFormatter
        public /* synthetic */ Object toStringOrNumber(Integer num) {
            return toStringOrNumber(num.intValue());
        }

        public String toStringOrNumber(int i) {
            return String.valueOf(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/JsonIntegration$LongAsStringJsonFormatter.class */
    public static final class LongAsStringJsonFormatter implements JsonFormatter<Long> {
        public static final LongAsStringJsonFormatter INSTANCE = new LongAsStringJsonFormatter();

        private LongAsStringJsonFormatter() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.internal.JsonFormatter
        public Long fromString(String value) {
            long longValueExact;
            Intrinsics.e(value, "value");
            try {
                longValueExact = Long.parseLong(value);
            } catch (Exception e) {
                longValueExact = new BigDecimal(value).longValueExact();
            }
            return Long.valueOf(longValueExact);
        }

        @Override // com.squareup.wire.internal.JsonFormatter
        public /* synthetic */ Object toStringOrNumber(Long l) {
            return toStringOrNumber(l.longValue());
        }

        public String toStringOrNumber(long j) {
            return String.valueOf(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/JsonIntegration$StringJsonFormatter.class */
    public static final class StringJsonFormatter implements JsonFormatter<String> {
        public static final StringJsonFormatter INSTANCE = new StringJsonFormatter();

        private StringJsonFormatter() {
        }

        @Override // com.squareup.wire.internal.JsonFormatter
        public String fromString(String value) {
            Intrinsics.e(value, "value");
            return value;
        }

        @Override // com.squareup.wire.internal.JsonFormatter
        public String toStringOrNumber(String value) {
            Intrinsics.e(value, "value");
            return value;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/JsonIntegration$UnsignedIntAsNumberJsonFormatter.class */
    public static final class UnsignedIntAsNumberJsonFormatter implements JsonFormatter<Integer> {
        public static final UnsignedIntAsNumberJsonFormatter INSTANCE = new UnsignedIntAsNumberJsonFormatter();
        private static final long maxInt = 2147483647L;
        private static final long power32 = 4294967296L;

        private UnsignedIntAsNumberJsonFormatter() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.internal.JsonFormatter
        public Integer fromString(String value) {
            Intrinsics.e(value, "value");
            long parseDouble = (long) Double.parseDouble(value);
            long j = parseDouble;
            if (parseDouble >= maxInt) {
                j = parseDouble - 4294967296L;
            }
            return Integer.valueOf((int) j);
        }

        public Object toStringOrNumber(int i) {
            return i < 0 ? Long.valueOf(i + 4294967296L) : Integer.valueOf(i);
        }

        @Override // com.squareup.wire.internal.JsonFormatter
        public /* synthetic */ Object toStringOrNumber(Integer num) {
            return toStringOrNumber(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/JsonIntegration$UnsignedIntAsStringJsonFormatter.class */
    public static final class UnsignedIntAsStringJsonFormatter implements JsonFormatter<Integer> {
        public static final UnsignedIntAsStringJsonFormatter INSTANCE = new UnsignedIntAsStringJsonFormatter();
        private static final long power32 = 4294967296L;

        private UnsignedIntAsStringJsonFormatter() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.internal.JsonFormatter
        public Integer fromString(String value) {
            Intrinsics.e(value, "value");
            return Integer.valueOf((int) Long.parseLong(value));
        }

        public Object toStringOrNumber(int i) {
            return i < 0 ? String.valueOf(i + 4294967296L) : String.valueOf(i);
        }

        @Override // com.squareup.wire.internal.JsonFormatter
        public /* synthetic */ Object toStringOrNumber(Integer num) {
            return toStringOrNumber(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/JsonIntegration$UnsignedLongAsNumberJsonFormatter.class */
    public static final class UnsignedLongAsNumberJsonFormatter implements JsonFormatter<Long> {
        public static final UnsignedLongAsNumberJsonFormatter INSTANCE = new UnsignedLongAsNumberJsonFormatter();
        private static final BigInteger power64 = new BigInteger("18446744073709551616");
        private static final BigInteger maxLong = BigInteger.valueOf(Long.MAX_VALUE);

        private UnsignedLongAsNumberJsonFormatter() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.internal.JsonFormatter
        public Long fromString(String value) {
            BigInteger bigInteger;
            Intrinsics.e(value, "value");
            try {
                bigInteger = new BigInteger(value);
            } catch (Exception e) {
                bigInteger = new BigDecimal(value).toBigInteger();
            }
            return Long.valueOf(bigInteger.compareTo(maxLong) > 0 ? bigInteger.subtract(power64).longValue() : bigInteger.longValue());
        }

        public Object toStringOrNumber(long j) {
            BigInteger add = j < 0 ? power64.add(BigInteger.valueOf(j)) : Long.valueOf(j);
            Intrinsics.c(add, "when {\n        value < 0…    else -> value\n      }");
            return add;
        }

        @Override // com.squareup.wire.internal.JsonFormatter
        public /* synthetic */ Object toStringOrNumber(Long l) {
            return toStringOrNumber(l.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/JsonIntegration$UnsignedLongAsStringJsonFormatter.class */
    public static final class UnsignedLongAsStringJsonFormatter implements JsonFormatter<Long> {
        public static final UnsignedLongAsStringJsonFormatter INSTANCE = new UnsignedLongAsStringJsonFormatter();

        private UnsignedLongAsStringJsonFormatter() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.internal.JsonFormatter
        public Long fromString(String value) {
            Intrinsics.e(value, "value");
            return UnsignedLongAsNumberJsonFormatter.INSTANCE.fromString(value);
        }

        @Override // com.squareup.wire.internal.JsonFormatter
        public /* synthetic */ Object toStringOrNumber(Long l) {
            return toStringOrNumber(l.longValue());
        }

        public String toStringOrNumber(long j) {
            return UnsignedLongAsNumberJsonFormatter.INSTANCE.toStringOrNumber(j).toString();
        }
    }

    private final <M, B> A jsonAdapter(F f, Syntax syntax, FieldOrOneOfBinding<M, B> fieldOrOneOfBinding) {
        A frameworkAdapter;
        if (fieldOrOneOfBinding.getSingleAdapter().isStruct$wire_runtime()) {
            return structAdapter(f);
        }
        JsonFormatter<?> jsonFormatter = jsonFormatter(syntax, fieldOrOneOfBinding.getSingleAdapter());
        if (jsonFormatter != null) {
            frameworkAdapter = formatterAdapter(jsonFormatter);
        } else {
            KClass<?> type = fieldOrOneOfBinding.getSingleAdapter().getType();
            Class b = type == null ? null : JvmClassMappingKt.b(type);
            if (b == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Type");
            }
            frameworkAdapter = frameworkAdapter(f, b);
        }
        if (fieldOrOneOfBinding.getLabel().isRepeated()) {
            return listAdapter(frameworkAdapter);
        }
        A a2 = frameworkAdapter;
        if (fieldOrOneOfBinding.isMap()) {
            a2 = mapAdapter(f, mapKeyJsonFormatter(fieldOrOneOfBinding.getKeyAdapter()), frameworkAdapter);
        }
        return a2;
    }

    private final JsonFormatter<?> jsonFormatter(Syntax syntax, ProtoAdapter<?> protoAdapter) {
        if (Intrinsics.a(protoAdapter, ProtoAdapter.BYTES) ? true : Intrinsics.a(protoAdapter, ProtoAdapter.BYTES_VALUE)) {
            return ByteStringJsonFormatter.INSTANCE;
        }
        if (Intrinsics.a(protoAdapter, ProtoAdapter.DURATION)) {
            return DurationJsonFormatter.INSTANCE;
        }
        if (Intrinsics.a(protoAdapter, ProtoAdapter.INSTANT)) {
            return InstantJsonFormatter.INSTANCE;
        }
        if (protoAdapter instanceof EnumAdapter) {
            return new EnumJsonFormatter((EnumAdapter) protoAdapter);
        }
        if (syntax == Syntax.PROTO_2) {
            UnsignedLongAsNumberJsonFormatter unsignedLongAsNumberJsonFormatter = null;
            if (Intrinsics.a(protoAdapter, ProtoAdapter.UINT64) ? true : Intrinsics.a(protoAdapter, ProtoAdapter.UINT64_VALUE)) {
                unsignedLongAsNumberJsonFormatter = UnsignedLongAsNumberJsonFormatter.INSTANCE;
            }
            return unsignedLongAsNumberJsonFormatter;
        }
        if (Intrinsics.a(protoAdapter, ProtoAdapter.UINT32) ? true : Intrinsics.a(protoAdapter, ProtoAdapter.FIXED32) ? true : Intrinsics.a(protoAdapter, ProtoAdapter.UINT32_VALUE)) {
            return UnsignedIntAsNumberJsonFormatter.INSTANCE;
        }
        if (Intrinsics.a(protoAdapter, ProtoAdapter.INT64) ? true : Intrinsics.a(protoAdapter, ProtoAdapter.SFIXED64) ? true : Intrinsics.a(protoAdapter, ProtoAdapter.SINT64) ? true : Intrinsics.a(protoAdapter, ProtoAdapter.INT64_VALUE)) {
            return LongAsStringJsonFormatter.INSTANCE;
        }
        UnsignedLongAsStringJsonFormatter unsignedLongAsStringJsonFormatter = null;
        if (Intrinsics.a(protoAdapter, ProtoAdapter.FIXED64) ? true : Intrinsics.a(protoAdapter, ProtoAdapter.UINT64) ? true : Intrinsics.a(protoAdapter, ProtoAdapter.UINT64_VALUE)) {
            unsignedLongAsStringJsonFormatter = UnsignedLongAsStringJsonFormatter.INSTANCE;
        }
        return unsignedLongAsStringJsonFormatter;
    }

    private final JsonFormatter<?> mapKeyJsonFormatter(ProtoAdapter<?> protoAdapter) {
        if (Intrinsics.a(protoAdapter, ProtoAdapter.STRING)) {
            return StringJsonFormatter.INSTANCE;
        }
        if (Intrinsics.a(protoAdapter, ProtoAdapter.INT32) ? true : Intrinsics.a(protoAdapter, ProtoAdapter.SINT32) ? true : Intrinsics.a(protoAdapter, ProtoAdapter.SFIXED32)) {
            return IntAsStringJsonFormatter.INSTANCE;
        }
        if (Intrinsics.a(protoAdapter, ProtoAdapter.FIXED32) ? true : Intrinsics.a(protoAdapter, ProtoAdapter.UINT32)) {
            return UnsignedIntAsStringJsonFormatter.INSTANCE;
        }
        if (Intrinsics.a(protoAdapter, ProtoAdapter.INT64) ? true : Intrinsics.a(protoAdapter, ProtoAdapter.SFIXED64) ? true : Intrinsics.a(protoAdapter, ProtoAdapter.SINT64)) {
            return LongAsStringJsonFormatter.INSTANCE;
        }
        if (Intrinsics.a(protoAdapter, ProtoAdapter.FIXED64) ? true : Intrinsics.a(protoAdapter, ProtoAdapter.UINT64)) {
            return UnsignedLongAsStringJsonFormatter.INSTANCE;
        }
        throw new IllegalStateException(Intrinsics.a("Unexpected map key type: ", (Object) protoAdapter.getType()).toString());
    }

    public abstract A formatterAdapter(JsonFormatter<?> jsonFormatter);

    public abstract A frameworkAdapter(F f, Type type);

    public final <M, B> List<A> jsonAdapters(RuntimeMessageAdapter<M, B> adapter, F f) {
        Intrinsics.e(adapter, "adapter");
        int i = 0;
        Object[] array = adapter.getFields().values().toArray(new FieldOrOneOfBinding[0]);
        if (array != null) {
            FieldOrOneOfBinding<M, B>[] fieldOrOneOfBindingArr = (FieldOrOneOfBinding[]) array;
            ArrayList arrayList = new ArrayList(fieldOrOneOfBindingArr.length);
            int length = fieldOrOneOfBindingArr.length;
            while (i < length) {
                FieldOrOneOfBinding<M, B> fieldOrOneOfBinding = fieldOrOneOfBindingArr[i];
                i++;
                arrayList.add(jsonAdapter(f, adapter.getSyntax(), fieldOrOneOfBinding));
            }
            return arrayList;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public abstract A listAdapter(A a2);

    public abstract A mapAdapter(F f, JsonFormatter<?> jsonFormatter, A a2);

    public abstract A structAdapter(F f);
}
