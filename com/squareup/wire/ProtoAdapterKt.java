package com.squareup.wire;

import com.squareup.wire.WireField;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Utf8;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/ProtoAdapterKt.class */
public final class ProtoAdapterKt {
    private static final int FIXED_32_SIZE = 4;
    private static final int FIXED_64_SIZE = 8;
    private static final int FIXED_BOOL_SIZE = 1;

    public static final ProtoAdapter<Boolean> commonBool() {
        final FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        final KClass b = Reflection.b(Boolean.TYPE);
        final Syntax syntax = Syntax.PROTO_2;
        return new ProtoAdapter<Boolean>(fieldEncoding, b, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonBool$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Boolean decode(ProtoReader protoReader) throws IOException {
                Intrinsics.e(protoReader, "reader");
                return Boolean.valueOf(protoReader.readVarint32() != 0);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ void encode(ProtoWriter protoWriter, Boolean bool) {
                encode(protoWriter, bool.booleanValue());
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
            public void encode(ProtoWriter protoWriter, boolean z) throws IOException {
                throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Boolean bool) {
                encode(reverseProtoWriter, bool.booleanValue());
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
            public void encode(ReverseProtoWriter reverseProtoWriter, boolean z) throws IOException {
                throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ int encodedSize(Boolean bool) {
                return encodedSize(bool.booleanValue());
            }

            public int encodedSize(boolean z) {
                return 1;
            }

            public Boolean redact(boolean z) {
                throw new UnsupportedOperationException();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ Boolean redact(Boolean bool) {
                return redact(bool.booleanValue());
            }
        };
    }

    public static final ProtoAdapter<ByteString> commonBytes() {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass b = Reflection.b(ByteString.class);
        final Syntax syntax = Syntax.PROTO_2;
        final ByteString byteString = ByteString.EMPTY;
        return new ProtoAdapter<ByteString>(fieldEncoding, b, syntax, byteString) { // from class: com.squareup.wire.ProtoAdapterKt$commonBytes$1
            @Override // com.squareup.wire.ProtoAdapter
            public ByteString decode(ProtoReader protoReader) throws IOException {
                Intrinsics.e(protoReader, "reader");
                return protoReader.readBytes();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, ByteString byteString2) throws IOException {
                Intrinsics.e(protoWriter, "writer");
                Intrinsics.e(byteString2, "value");
                protoWriter.writeBytes(byteString2);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ReverseProtoWriter reverseProtoWriter, ByteString byteString2) throws IOException {
                Intrinsics.e(reverseProtoWriter, "writer");
                Intrinsics.e(byteString2, "value");
                reverseProtoWriter.writeBytes(byteString2);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(ByteString byteString2) {
                Intrinsics.e(byteString2, "value");
                return byteString2.size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public ByteString redact(ByteString byteString2) {
                Intrinsics.e(byteString2, "value");
                throw new UnsupportedOperationException();
            }
        };
    }

    public static final <E> ProtoAdapter<List<E>> commonCreatePacked(ProtoAdapter<E> protoAdapter) {
        Intrinsics.e(protoAdapter, "<this>");
        if (protoAdapter.getFieldEncoding$wire_runtime() != FieldEncoding.LENGTH_DELIMITED) {
            return new PackedProtoAdapter(protoAdapter);
        }
        throw new IllegalArgumentException("Unable to pack a length-delimited type.".toString());
    }

    public static final <E> ProtoAdapter<List<E>> commonCreateRepeated(ProtoAdapter<E> protoAdapter) {
        Intrinsics.e(protoAdapter, "<this>");
        return new RepeatedProtoAdapter(protoAdapter);
    }

    public static final <E> E commonDecode(ProtoAdapter<E> protoAdapter, BufferedSource bufferedSource) {
        Intrinsics.e(protoAdapter, "<this>");
        Intrinsics.e(bufferedSource, "source");
        return protoAdapter.decode(new ProtoReader(bufferedSource));
    }

    public static final <E> E commonDecode(ProtoAdapter<E> protoAdapter, ByteString byteString) {
        Intrinsics.e(protoAdapter, "<this>");
        Intrinsics.e(byteString, "bytes");
        return protoAdapter.decode(new Buffer().write(byteString));
    }

    public static final <E> E commonDecode(ProtoAdapter<E> protoAdapter, byte[] bArr) {
        Intrinsics.e(protoAdapter, "<this>");
        Intrinsics.e(bArr, "bytes");
        return protoAdapter.decode(new Buffer().write(bArr));
    }

    public static final ProtoAdapter<Double> commonDouble() {
        final FieldEncoding fieldEncoding = FieldEncoding.FIXED64;
        final KClass b = Reflection.b(Double.TYPE);
        final Syntax syntax = Syntax.PROTO_2;
        return new ProtoAdapter<Double>(fieldEncoding, b, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonDouble$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                Double valueOf = Double.valueOf(0.0d);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Double decode(ProtoReader protoReader) throws IOException {
                Intrinsics.e(protoReader, "reader");
                DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.a;
                return Double.valueOf(Double.longBitsToDouble(protoReader.readFixed64()));
            }

            public void encode(ProtoWriter protoWriter, double d) throws IOException {
                Intrinsics.e(protoWriter, "writer");
                protoWriter.writeFixed64(Double.doubleToLongBits(d));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ void encode(ProtoWriter protoWriter, Double d) {
                encode(protoWriter, d.doubleValue());
            }

            public void encode(ReverseProtoWriter reverseProtoWriter, double d) throws IOException {
                Intrinsics.e(reverseProtoWriter, "writer");
                reverseProtoWriter.writeFixed64(Double.doubleToLongBits(d));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Double d) {
                encode(reverseProtoWriter, d.doubleValue());
            }

            public int encodedSize(double d) {
                return 8;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ int encodedSize(Double d) {
                return encodedSize(d.doubleValue());
            }

            public Double redact(double d) {
                throw new UnsupportedOperationException();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ Double redact(Double d) {
                return redact(d.doubleValue());
            }
        };
    }

    public static final ProtoAdapter<Duration> commonDuration() {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass b = Reflection.b(Duration.class);
        final Syntax syntax = Syntax.PROTO_3;
        return new ProtoAdapter<Duration>(fieldEncoding, b, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonDuration$1
            private final int getSameSignNanos(Duration duration) {
                return (duration.getSeconds() >= 0 || duration.getNano() == 0) ? duration.getNano() : duration.getNano() - 1000000000;
            }

            private final long getSameSignSeconds(Duration duration) {
                return (duration.getSeconds() >= 0 || duration.getNano() == 0) ? duration.getSeconds() : duration.getSeconds() + 1;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Duration decode(ProtoReader protoReader) {
                Intrinsics.e(protoReader, "reader");
                long beginMessage = protoReader.beginMessage();
                long j = 0;
                int i = 0;
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag == -1) {
                        protoReader.endMessageAndGetUnknownFields(beginMessage);
                        Duration ofSeconds = Duration.ofSeconds(j, i);
                        Intrinsics.c(ofSeconds, "ofSeconds(seconds, nano)");
                        return ofSeconds;
                    } else if (nextTag == 1) {
                        j = ProtoAdapter.INT64.decode(protoReader).longValue();
                    } else if (nextTag != 2) {
                        protoReader.readUnknownField(nextTag);
                    } else {
                        i = ProtoAdapter.INT32.decode(protoReader).intValue();
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Duration duration) {
                Intrinsics.e(protoWriter, "writer");
                Intrinsics.e(duration, "value");
                long sameSignSeconds = getSameSignSeconds(duration);
                if (sameSignSeconds != 0) {
                    ProtoAdapter.INT64.encodeWithTag(protoWriter, 1, (int) Long.valueOf(sameSignSeconds));
                }
                int sameSignNanos = getSameSignNanos(duration);
                if (sameSignNanos != 0) {
                    ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, (int) Integer.valueOf(sameSignNanos));
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ReverseProtoWriter reverseProtoWriter, Duration duration) {
                Intrinsics.e(reverseProtoWriter, "writer");
                Intrinsics.e(duration, "value");
                int sameSignNanos = getSameSignNanos(duration);
                if (sameSignNanos != 0) {
                    ProtoAdapter.INT32.encodeWithTag(reverseProtoWriter, 2, (int) Integer.valueOf(sameSignNanos));
                }
                long sameSignSeconds = getSameSignSeconds(duration);
                if (sameSignSeconds != 0) {
                    ProtoAdapter.INT64.encodeWithTag(reverseProtoWriter, 1, (int) Long.valueOf(sameSignSeconds));
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Duration duration) {
                Intrinsics.e(duration, "value");
                long sameSignSeconds = getSameSignSeconds(duration);
                int i = 0;
                if (sameSignSeconds != 0) {
                    i = 0 + ProtoAdapter.INT64.encodedSizeWithTag(1, Long.valueOf(sameSignSeconds));
                }
                int sameSignNanos = getSameSignNanos(duration);
                int i2 = i;
                if (sameSignNanos != 0) {
                    i2 = i + ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(sameSignNanos));
                }
                return i2;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Duration redact(Duration duration) {
                Intrinsics.e(duration, "value");
                return duration;
            }
        };
    }

    public static final ProtoAdapter<Unit> commonEmpty() {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass b = Reflection.b(Unit.class);
        final Syntax syntax = Syntax.PROTO_3;
        return new ProtoAdapter<Unit>(fieldEncoding, b, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonEmpty$1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Unit decode(ProtoReader protoReader) {
                decode2(protoReader);
                return Unit.a;
            }

            /* renamed from: decode  reason: avoid collision after fix types in other method */
            public void decode2(ProtoReader protoReader) {
                Intrinsics.e(protoReader, "reader");
                long beginMessage = protoReader.beginMessage();
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag == -1) {
                        protoReader.endMessageAndGetUnknownFields(beginMessage);
                        return;
                    }
                    protoReader.readUnknownField(nextTag);
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Unit unit) {
                Intrinsics.e(protoWriter, "writer");
                Intrinsics.e(unit, "value");
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ReverseProtoWriter reverseProtoWriter, Unit unit) {
                Intrinsics.e(reverseProtoWriter, "writer");
                Intrinsics.e(unit, "value");
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Unit unit) {
                Intrinsics.e(unit, "value");
                return 0;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Unit redact(Unit unit) {
                redact2(unit);
                return Unit.a;
            }

            /* renamed from: redact  reason: avoid collision after fix types in other method */
            public void redact2(Unit unit) {
                Intrinsics.e(unit, "value");
            }
        };
    }

    public static final <E> void commonEncode(ProtoAdapter<E> protoAdapter, BufferedSink bufferedSink, E e) {
        Intrinsics.e(protoAdapter, "<this>");
        Intrinsics.e(bufferedSink, "sink");
        ReverseProtoWriter reverseProtoWriter = new ReverseProtoWriter();
        protoAdapter.encode(reverseProtoWriter, (ReverseProtoWriter) e);
        reverseProtoWriter.writeTo(bufferedSink);
    }

    public static final <E> byte[] commonEncode(ProtoAdapter<E> protoAdapter, E e) {
        Intrinsics.e(protoAdapter, "<this>");
        BufferedSink buffer = new Buffer();
        protoAdapter.encode(buffer, (BufferedSink) e);
        return buffer.readByteArray();
    }

    public static final <E> ByteString commonEncodeByteString(ProtoAdapter<E> protoAdapter, E e) {
        Intrinsics.e(protoAdapter, "<this>");
        BufferedSink buffer = new Buffer();
        protoAdapter.encode(buffer, (BufferedSink) e);
        return buffer.readByteString();
    }

    public static final <E> void commonEncodeWithTag(ProtoAdapter<E> protoAdapter, ProtoWriter protoWriter, int i, E e) {
        Intrinsics.e(protoAdapter, "<this>");
        Intrinsics.e(protoWriter, "writer");
        if (e == null) {
            return;
        }
        protoWriter.writeTag(i, protoAdapter.getFieldEncoding$wire_runtime());
        if (protoAdapter.getFieldEncoding$wire_runtime() == FieldEncoding.LENGTH_DELIMITED) {
            protoWriter.writeVarint32(protoAdapter.encodedSize(e));
        }
        protoAdapter.encode(protoWriter, (ProtoWriter) e);
    }

    public static final <E> void commonEncodeWithTag(ProtoAdapter<E> protoAdapter, ReverseProtoWriter reverseProtoWriter, int i, E e) {
        Intrinsics.e(protoAdapter, "<this>");
        Intrinsics.e(reverseProtoWriter, "writer");
        if (e == null) {
            return;
        }
        if (protoAdapter.getFieldEncoding$wire_runtime() == FieldEncoding.LENGTH_DELIMITED) {
            int byteCount = reverseProtoWriter.getByteCount();
            protoAdapter.encode(reverseProtoWriter, (ReverseProtoWriter) e);
            reverseProtoWriter.writeVarint32(reverseProtoWriter.getByteCount() - byteCount);
        } else {
            protoAdapter.encode(reverseProtoWriter, (ReverseProtoWriter) e);
        }
        reverseProtoWriter.writeTag(i, protoAdapter.getFieldEncoding$wire_runtime());
    }

    public static final <E> int commonEncodedSizeWithTag(ProtoAdapter<E> protoAdapter, int i, E e) {
        Intrinsics.e(protoAdapter, "<this>");
        if (e == null) {
            return 0;
        }
        int encodedSize = protoAdapter.encodedSize(e);
        int i2 = encodedSize;
        if (protoAdapter.getFieldEncoding$wire_runtime() == FieldEncoding.LENGTH_DELIMITED) {
            i2 = encodedSize + ProtoWriter.Companion.varint32Size$wire_runtime(encodedSize);
        }
        return i2 + ProtoWriter.Companion.tagSize$wire_runtime(i);
    }

    public static final ProtoAdapter<Integer> commonFixed32() {
        final FieldEncoding fieldEncoding = FieldEncoding.FIXED32;
        final KClass b = Reflection.b(Integer.TYPE);
        final Syntax syntax = Syntax.PROTO_2;
        return new ProtoAdapter<Integer>(fieldEncoding, b, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonFixed32$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Integer decode(ProtoReader protoReader) throws IOException {
                Intrinsics.e(protoReader, "reader");
                return Integer.valueOf(protoReader.readFixed32());
            }

            public void encode(ProtoWriter protoWriter, int i) throws IOException {
                Intrinsics.e(protoWriter, "writer");
                protoWriter.writeFixed32(i);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ void encode(ProtoWriter protoWriter, Integer num) {
                encode(protoWriter, num.intValue());
            }

            public void encode(ReverseProtoWriter reverseProtoWriter, int i) throws IOException {
                Intrinsics.e(reverseProtoWriter, "writer");
                reverseProtoWriter.writeFixed32(i);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Integer num) {
                encode(reverseProtoWriter, num.intValue());
            }

            public int encodedSize(int i) {
                return 4;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ int encodedSize(Integer num) {
                return encodedSize(num.intValue());
            }

            public Integer redact(int i) {
                throw new UnsupportedOperationException();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ Integer redact(Integer num) {
                return redact(num.intValue());
            }
        };
    }

    public static final ProtoAdapter<Long> commonFixed64() {
        final FieldEncoding fieldEncoding = FieldEncoding.FIXED64;
        final KClass b = Reflection.b(Long.TYPE);
        final Syntax syntax = Syntax.PROTO_2;
        return new ProtoAdapter<Long>(fieldEncoding, b, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonFixed64$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Long decode(ProtoReader protoReader) throws IOException {
                Intrinsics.e(protoReader, "reader");
                return Long.valueOf(protoReader.readFixed64());
            }

            public void encode(ProtoWriter protoWriter, long j) throws IOException {
                Intrinsics.e(protoWriter, "writer");
                protoWriter.writeFixed64(j);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ void encode(ProtoWriter protoWriter, Long l) {
                encode(protoWriter, l.longValue());
            }

            public void encode(ReverseProtoWriter reverseProtoWriter, long j) throws IOException {
                Intrinsics.e(reverseProtoWriter, "writer");
                reverseProtoWriter.writeFixed64(j);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Long l) {
                encode(reverseProtoWriter, l.longValue());
            }

            public int encodedSize(long j) {
                return 8;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ int encodedSize(Long l) {
                return encodedSize(l.longValue());
            }

            public Long redact(long j) {
                throw new UnsupportedOperationException();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ Long redact(Long l) {
                return redact(l.longValue());
            }
        };
    }

    public static final ProtoAdapter<Float> commonFloat() {
        final FieldEncoding fieldEncoding = FieldEncoding.FIXED32;
        final KClass b = Reflection.b(Float.TYPE);
        final Syntax syntax = Syntax.PROTO_2;
        return new ProtoAdapter<Float>(fieldEncoding, b, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonFloat$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                Float valueOf = Float.valueOf(0.0f);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Float decode(ProtoReader protoReader) throws IOException {
                Intrinsics.e(protoReader, "reader");
                FloatCompanionObject floatCompanionObject = FloatCompanionObject.a;
                return Float.valueOf(Float.intBitsToFloat(protoReader.readFixed32()));
            }

            public void encode(ProtoWriter protoWriter, float f) throws IOException {
                Intrinsics.e(protoWriter, "writer");
                protoWriter.writeFixed32(Float.floatToIntBits(f));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ void encode(ProtoWriter protoWriter, Float f) {
                encode(protoWriter, f.floatValue());
            }

            public void encode(ReverseProtoWriter reverseProtoWriter, float f) throws IOException {
                Intrinsics.e(reverseProtoWriter, "writer");
                reverseProtoWriter.writeFixed32(Float.floatToIntBits(f));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Float f) {
                encode(reverseProtoWriter, f.floatValue());
            }

            public int encodedSize(float f) {
                return 4;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ int encodedSize(Float f) {
                return encodedSize(f.floatValue());
            }

            public Float redact(float f) {
                throw new UnsupportedOperationException();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ Float redact(Float f) {
                return redact(f.floatValue());
            }
        };
    }

    public static final ProtoAdapter<Instant> commonInstant() {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass b = Reflection.b(Instant.class);
        final Syntax syntax = Syntax.PROTO_3;
        return new ProtoAdapter<Instant>(fieldEncoding, b, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonInstant$1
            @Override // com.squareup.wire.ProtoAdapter
            public Instant decode(ProtoReader protoReader) {
                Intrinsics.e(protoReader, "reader");
                long beginMessage = protoReader.beginMessage();
                long j = 0;
                int i = 0;
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag == -1) {
                        protoReader.endMessageAndGetUnknownFields(beginMessage);
                        Instant ofEpochSecond = Instant.ofEpochSecond(j, i);
                        Intrinsics.c(ofEpochSecond, "ofEpochSecond(epochSecond, nano)");
                        return ofEpochSecond;
                    } else if (nextTag == 1) {
                        j = ProtoAdapter.INT64.decode(protoReader).longValue();
                    } else if (nextTag != 2) {
                        protoReader.readUnknownField(nextTag);
                    } else {
                        i = ProtoAdapter.INT32.decode(protoReader).intValue();
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Instant instant) {
                Intrinsics.e(protoWriter, "writer");
                Intrinsics.e(instant, "value");
                long epochSecond = instant.getEpochSecond();
                if (epochSecond != 0) {
                    ProtoAdapter.INT64.encodeWithTag(protoWriter, 1, (int) Long.valueOf(epochSecond));
                }
                int nano = instant.getNano();
                if (nano != 0) {
                    ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, (int) Integer.valueOf(nano));
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ReverseProtoWriter reverseProtoWriter, Instant instant) {
                Intrinsics.e(reverseProtoWriter, "writer");
                Intrinsics.e(instant, "value");
                int nano = instant.getNano();
                if (nano != 0) {
                    ProtoAdapter.INT32.encodeWithTag(reverseProtoWriter, 2, (int) Integer.valueOf(nano));
                }
                long epochSecond = instant.getEpochSecond();
                if (epochSecond != 0) {
                    ProtoAdapter.INT64.encodeWithTag(reverseProtoWriter, 1, (int) Long.valueOf(epochSecond));
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Instant instant) {
                Intrinsics.e(instant, "value");
                long epochSecond = instant.getEpochSecond();
                int i = 0;
                if (epochSecond != 0) {
                    i = 0 + ProtoAdapter.INT64.encodedSizeWithTag(1, Long.valueOf(epochSecond));
                }
                int nano = instant.getNano();
                int i2 = i;
                if (nano != 0) {
                    i2 = i + ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(nano));
                }
                return i2;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Instant redact(Instant instant) {
                Intrinsics.e(instant, "value");
                return instant;
            }
        };
    }

    public static final ProtoAdapter<Integer> commonInt32() {
        final FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        final KClass b = Reflection.b(Integer.TYPE);
        final Syntax syntax = Syntax.PROTO_2;
        return new ProtoAdapter<Integer>(fieldEncoding, b, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonInt32$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Integer decode(ProtoReader protoReader) throws IOException {
                Intrinsics.e(protoReader, "reader");
                return Integer.valueOf(protoReader.readVarint32());
            }

            public void encode(ProtoWriter protoWriter, int i) throws IOException {
                Intrinsics.e(protoWriter, "writer");
                protoWriter.writeSignedVarint32$wire_runtime(i);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ void encode(ProtoWriter protoWriter, Integer num) {
                encode(protoWriter, num.intValue());
            }

            public void encode(ReverseProtoWriter reverseProtoWriter, int i) throws IOException {
                Intrinsics.e(reverseProtoWriter, "writer");
                reverseProtoWriter.writeSignedVarint32$wire_runtime(i);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Integer num) {
                encode(reverseProtoWriter, num.intValue());
            }

            public int encodedSize(int i) {
                return ProtoWriter.Companion.int32Size$wire_runtime(i);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ int encodedSize(Integer num) {
                return encodedSize(num.intValue());
            }

            public Integer redact(int i) {
                throw new UnsupportedOperationException();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ Integer redact(Integer num) {
                return redact(num.intValue());
            }
        };
    }

    public static final ProtoAdapter<Long> commonInt64() {
        final FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        final KClass b = Reflection.b(Long.TYPE);
        final Syntax syntax = Syntax.PROTO_2;
        return new ProtoAdapter<Long>(fieldEncoding, b, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonInt64$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Long decode(ProtoReader protoReader) throws IOException {
                Intrinsics.e(protoReader, "reader");
                return Long.valueOf(protoReader.readVarint64());
            }

            public void encode(ProtoWriter protoWriter, long j) throws IOException {
                Intrinsics.e(protoWriter, "writer");
                protoWriter.writeVarint64(j);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ void encode(ProtoWriter protoWriter, Long l) {
                encode(protoWriter, l.longValue());
            }

            public void encode(ReverseProtoWriter reverseProtoWriter, long j) throws IOException {
                Intrinsics.e(reverseProtoWriter, "writer");
                reverseProtoWriter.writeVarint64(j);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Long l) {
                encode(reverseProtoWriter, l.longValue());
            }

            public int encodedSize(long j) {
                return ProtoWriter.Companion.varint64Size$wire_runtime(j);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ int encodedSize(Long l) {
                return encodedSize(l.longValue());
            }

            public Long redact(long j) {
                throw new UnsupportedOperationException();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ Long redact(Long l) {
                return redact(l.longValue());
            }
        };
    }

    public static final <K, V> ProtoAdapter<Map<K, V>> commonNewMapAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
        Intrinsics.e(protoAdapter, "keyAdapter");
        Intrinsics.e(protoAdapter2, "valueAdapter");
        return new MapProtoAdapter(protoAdapter, protoAdapter2);
    }

    public static final ProtoAdapter<Integer> commonSfixed32() {
        return commonFixed32();
    }

    public static final ProtoAdapter<Long> commonSfixed64() {
        return commonFixed64();
    }

    public static final ProtoAdapter<Integer> commonSint32() {
        final FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        final KClass b = Reflection.b(Integer.TYPE);
        final Syntax syntax = Syntax.PROTO_2;
        return new ProtoAdapter<Integer>(fieldEncoding, b, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonSint32$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Integer decode(ProtoReader protoReader) throws IOException {
                Intrinsics.e(protoReader, "reader");
                return Integer.valueOf(ProtoWriter.Companion.decodeZigZag32$wire_runtime(protoReader.readVarint32()));
            }

            public void encode(ProtoWriter protoWriter, int i) throws IOException {
                Intrinsics.e(protoWriter, "writer");
                protoWriter.writeVarint32(ProtoWriter.Companion.encodeZigZag32$wire_runtime(i));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ void encode(ProtoWriter protoWriter, Integer num) {
                encode(protoWriter, num.intValue());
            }

            public void encode(ReverseProtoWriter reverseProtoWriter, int i) throws IOException {
                Intrinsics.e(reverseProtoWriter, "writer");
                reverseProtoWriter.writeVarint32(ProtoWriter.Companion.encodeZigZag32$wire_runtime(i));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Integer num) {
                encode(reverseProtoWriter, num.intValue());
            }

            public int encodedSize(int i) {
                return ProtoWriter.Companion.varint32Size$wire_runtime(ProtoWriter.Companion.encodeZigZag32$wire_runtime(i));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ int encodedSize(Integer num) {
                return encodedSize(num.intValue());
            }

            public Integer redact(int i) {
                throw new UnsupportedOperationException();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ Integer redact(Integer num) {
                return redact(num.intValue());
            }
        };
    }

    public static final ProtoAdapter<Long> commonSint64() {
        final FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        final KClass b = Reflection.b(Long.TYPE);
        final Syntax syntax = Syntax.PROTO_2;
        return new ProtoAdapter<Long>(fieldEncoding, b, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonSint64$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Long decode(ProtoReader protoReader) throws IOException {
                Intrinsics.e(protoReader, "reader");
                return Long.valueOf(ProtoWriter.Companion.decodeZigZag64$wire_runtime(protoReader.readVarint64()));
            }

            public void encode(ProtoWriter protoWriter, long j) throws IOException {
                Intrinsics.e(protoWriter, "writer");
                protoWriter.writeVarint64(ProtoWriter.Companion.encodeZigZag64$wire_runtime(j));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ void encode(ProtoWriter protoWriter, Long l) {
                encode(protoWriter, l.longValue());
            }

            public void encode(ReverseProtoWriter reverseProtoWriter, long j) throws IOException {
                Intrinsics.e(reverseProtoWriter, "writer");
                reverseProtoWriter.writeVarint64(ProtoWriter.Companion.encodeZigZag64$wire_runtime(j));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Long l) {
                encode(reverseProtoWriter, l.longValue());
            }

            public int encodedSize(long j) {
                return ProtoWriter.Companion.varint64Size$wire_runtime(ProtoWriter.Companion.encodeZigZag64$wire_runtime(j));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ int encodedSize(Long l) {
                return encodedSize(l.longValue());
            }

            public Long redact(long j) {
                throw new UnsupportedOperationException();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ Long redact(Long l) {
                return redact(l.longValue());
            }
        };
    }

    public static final ProtoAdapter<String> commonString() {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass b = Reflection.b(String.class);
        final Syntax syntax = Syntax.PROTO_2;
        return new ProtoAdapter<String>(fieldEncoding, b, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonString$1
            @Override // com.squareup.wire.ProtoAdapter
            public String decode(ProtoReader protoReader) throws IOException {
                Intrinsics.e(protoReader, "reader");
                return protoReader.readString();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, String str) throws IOException {
                Intrinsics.e(protoWriter, "writer");
                Intrinsics.e(str, "value");
                protoWriter.writeString(str);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ReverseProtoWriter reverseProtoWriter, String str) throws IOException {
                Intrinsics.e(reverseProtoWriter, "writer");
                Intrinsics.e(str, "value");
                reverseProtoWriter.writeString(str);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(String str) {
                Intrinsics.e(str, "value");
                return (int) Utf8.size$default(str, 0, 0, 3, (Object) null);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public String redact(String str) {
                Intrinsics.e(str, "value");
                throw new UnsupportedOperationException();
            }
        };
    }

    public static final ProtoAdapter<List<?>> commonStructList() {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass b = Reflection.b(Map.class);
        final Syntax syntax = Syntax.PROTO_3;
        return new ProtoAdapter<List<?>>(fieldEncoding, b, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonStructList$1
            @Override // com.squareup.wire.ProtoAdapter
            public List<?> decode(ProtoReader protoReader) {
                Intrinsics.e(protoReader, "reader");
                ArrayList arrayList = new ArrayList();
                long beginMessage = protoReader.beginMessage();
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag == -1) {
                        protoReader.endMessageAndGetUnknownFields(beginMessage);
                        return arrayList;
                    } else if (nextTag != 1) {
                        protoReader.skip();
                    } else {
                        arrayList.add(ProtoAdapter.STRUCT_VALUE.decode(protoReader));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, List<?> list) {
                Intrinsics.e(protoWriter, "writer");
                if (list == null) {
                    return;
                }
                Iterator<?> it = list.iterator();
                while (it.hasNext()) {
                    ProtoAdapter.STRUCT_VALUE.encodeWithTag(protoWriter, 1, (int) it.next());
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ReverseProtoWriter reverseProtoWriter, List<?> list) {
                Intrinsics.e(reverseProtoWriter, "writer");
                if (list == null) {
                    return;
                }
                int size = list.size() - 1;
                if (size < 0) {
                    return;
                }
                while (true) {
                    int i = size - 1;
                    ProtoAdapter.STRUCT_VALUE.encodeWithTag(reverseProtoWriter, 1, (int) list.get(size));
                    if (i < 0) {
                        return;
                    }
                    size = i;
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(List<?> list) {
                int i = 0;
                if (list == null) {
                    return 0;
                }
                Iterator<?> it = list.iterator();
                while (it.hasNext()) {
                    i += ProtoAdapter.STRUCT_VALUE.encodedSizeWithTag(1, it.next());
                }
                return i;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public List<Object> redact(List<?> list) {
                if (list == null) {
                    return null;
                }
                List<?> list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.a(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(ProtoAdapter.STRUCT_VALUE.redact(it.next()));
                }
                return arrayList;
            }
        };
    }

    public static final ProtoAdapter<Map<String, ?>> commonStructMap() {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass b = Reflection.b(Map.class);
        final Syntax syntax = Syntax.PROTO_3;
        return new ProtoAdapter<Map<String, ?>>(fieldEncoding, b, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonStructMap$1
            @Override // com.squareup.wire.ProtoAdapter
            public Map<String, ?> decode(ProtoReader protoReader) {
                Intrinsics.e(protoReader, "reader");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                long beginMessage = protoReader.beginMessage();
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag == -1) {
                        protoReader.endMessageAndGetUnknownFields(beginMessage);
                        return linkedHashMap;
                    } else if (nextTag != 1) {
                        protoReader.skip();
                    } else {
                        long beginMessage2 = protoReader.beginMessage();
                        String str = null;
                        Object obj = null;
                        while (true) {
                            int nextTag2 = protoReader.nextTag();
                            if (nextTag2 == -1) {
                                break;
                            } else if (nextTag2 == 1) {
                                str = ProtoAdapter.STRING.decode(protoReader);
                            } else if (nextTag2 != 2) {
                                protoReader.readUnknownField(nextTag2);
                            } else {
                                obj = ProtoAdapter.STRUCT_VALUE.decode(protoReader);
                            }
                        }
                        protoReader.endMessageAndGetUnknownFields(beginMessage2);
                        if (str != null) {
                            linkedHashMap.put(str, obj);
                        }
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Map<String, ?> map) {
                Intrinsics.e(protoWriter, "writer");
                if (map == null) {
                    return;
                }
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    int encodedSizeWithTag = ProtoAdapter.STRING.encodedSizeWithTag(1, key);
                    int encodedSizeWithTag2 = ProtoAdapter.STRUCT_VALUE.encodedSizeWithTag(2, value);
                    protoWriter.writeTag(1, FieldEncoding.LENGTH_DELIMITED);
                    protoWriter.writeVarint32(encodedSizeWithTag + encodedSizeWithTag2);
                    ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, (int) key);
                    ProtoAdapter.STRUCT_VALUE.encodeWithTag(protoWriter, 2, (int) value);
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ReverseProtoWriter reverseProtoWriter, Map<String, ?> map) {
                Intrinsics.e(reverseProtoWriter, "writer");
                if (map == null) {
                    return;
                }
                int i = 0;
                Object[] array = map.entrySet().toArray(new Map.Entry[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
                Map.Entry[] entryArr = (Map.Entry[]) array;
                ArraysKt.c(entryArr);
                int length = entryArr.length;
                while (i < length) {
                    Map.Entry entry = entryArr[i];
                    i++;
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    int byteCount = reverseProtoWriter.getByteCount();
                    ProtoAdapter.STRUCT_VALUE.encodeWithTag(reverseProtoWriter, 2, (int) value);
                    ProtoAdapter.STRING.encodeWithTag(reverseProtoWriter, 1, (int) str);
                    reverseProtoWriter.writeVarint32(reverseProtoWriter.getByteCount() - byteCount);
                    reverseProtoWriter.writeTag(1, FieldEncoding.LENGTH_DELIMITED);
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Map<String, ?> map) {
                int i = 0;
                if (map == null) {
                    return 0;
                }
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    int encodedSizeWithTag = ProtoAdapter.STRING.encodedSizeWithTag(1, entry.getKey()) + ProtoAdapter.STRUCT_VALUE.encodedSizeWithTag(2, entry.getValue());
                    i += ProtoWriter.Companion.tagSize$wire_runtime(1) + ProtoWriter.Companion.varint32Size$wire_runtime(encodedSizeWithTag) + encodedSizeWithTag;
                }
                return i;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Map<String, Object> redact(Map<String, ?> map) {
                if (map == null) {
                    return null;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.b(map.size()));
                Iterator<T> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    linkedHashMap.put(entry.getKey(), ProtoAdapter.STRUCT_VALUE.redact(entry));
                }
                return linkedHashMap;
            }
        };
    }

    public static final ProtoAdapter commonStructNull() {
        final FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        final KClass b = Reflection.b(Void.class);
        final Syntax syntax = Syntax.PROTO_3;
        return new ProtoAdapter(fieldEncoding, b, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonStructNull$1
            @Override // com.squareup.wire.ProtoAdapter
            public Void decode(ProtoReader protoReader) {
                Intrinsics.e(protoReader, "reader");
                int readVarint32 = protoReader.readVarint32();
                if (readVarint32 == 0) {
                    return null;
                }
                throw new IOException(Intrinsics.a("expected 0 but was ", Integer.valueOf(readVarint32)));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Void r5) {
                Intrinsics.e(protoWriter, "writer");
                protoWriter.writeVarint32(0);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ReverseProtoWriter reverseProtoWriter, Void r5) {
                Intrinsics.e(reverseProtoWriter, "writer");
                reverseProtoWriter.writeVarint32(0);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encodeWithTag(ProtoWriter protoWriter, int i, Void r7) {
                Intrinsics.e(protoWriter, "writer");
                protoWriter.writeTag(i, getFieldEncoding$wire_runtime());
                encode(protoWriter, r7);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encodeWithTag(ReverseProtoWriter reverseProtoWriter, int i, Void r7) {
                Intrinsics.e(reverseProtoWriter, "writer");
                encode(reverseProtoWriter, r7);
                reverseProtoWriter.writeTag(i, getFieldEncoding$wire_runtime());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Void r4) {
                return ProtoWriter.Companion.varint32Size$wire_runtime(0);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSizeWithTag(int i, Void r6) {
                return ProtoWriter.Companion.tagSize$wire_runtime(i) + ProtoWriter.Companion.varint32Size$wire_runtime(encodedSize(r6));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Void redact(Void r3) {
                return null;
            }
        };
    }

    public static final ProtoAdapter<Object> commonStructValue() {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass b = Reflection.b(Object.class);
        final Syntax syntax = Syntax.PROTO_3;
        return new ProtoAdapter<Object>(fieldEncoding, b, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonStructValue$1
            @Override // com.squareup.wire.ProtoAdapter
            public Object decode(ProtoReader protoReader) {
                Intrinsics.e(protoReader, "reader");
                long beginMessage = protoReader.beginMessage();
                List<?> list = null;
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag != -1) {
                        switch (nextTag) {
                            case 1:
                                list = ProtoAdapter.STRUCT_NULL.decode(protoReader);
                                break;
                            case 2:
                                list = ProtoAdapter.DOUBLE.decode(protoReader);
                                break;
                            case 3:
                                list = ProtoAdapter.STRING.decode(protoReader);
                                break;
                            case 4:
                                list = ProtoAdapter.BOOL.decode(protoReader);
                                break;
                            case 5:
                                list = ProtoAdapter.STRUCT_MAP.decode(protoReader);
                                break;
                            case 6:
                                list = ProtoAdapter.STRUCT_LIST.decode(protoReader);
                                break;
                            default:
                                protoReader.skip();
                                break;
                        }
                    } else {
                        protoReader.endMessageAndGetUnknownFields(beginMessage);
                        return list;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, Object obj) {
                Intrinsics.e(protoWriter, "writer");
                if (obj == null) {
                    ProtoAdapter.STRUCT_NULL.encodeWithTag(protoWriter, 1, (int) obj);
                } else if (obj instanceof Number) {
                    ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 2, (int) Double.valueOf(((Number) obj).doubleValue()));
                } else if (obj instanceof String) {
                    ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, (int) obj);
                } else if (obj instanceof Boolean) {
                    ProtoAdapter.BOOL.encodeWithTag(protoWriter, 4, (int) obj);
                } else if (!(obj instanceof Map)) {
                    if (!(obj instanceof List)) {
                        throw new IllegalArgumentException(Intrinsics.a("unexpected struct value: ", obj));
                    }
                    ProtoAdapter.STRUCT_LIST.encodeWithTag(protoWriter, 6, (int) obj);
                } else {
                    ProtoAdapter<Map<String, ?>> protoAdapter = ProtoAdapter.STRUCT_MAP;
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
                    }
                    protoAdapter.encodeWithTag(protoWriter, 5, (int) ((Map) obj));
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ReverseProtoWriter reverseProtoWriter, Object obj) {
                Intrinsics.e(reverseProtoWriter, "writer");
                if (obj == null) {
                    ProtoAdapter.STRUCT_NULL.encodeWithTag(reverseProtoWriter, 1, (int) obj);
                } else if (obj instanceof Number) {
                    ProtoAdapter.DOUBLE.encodeWithTag(reverseProtoWriter, 2, (int) Double.valueOf(((Number) obj).doubleValue()));
                } else if (obj instanceof String) {
                    ProtoAdapter.STRING.encodeWithTag(reverseProtoWriter, 3, (int) obj);
                } else if (obj instanceof Boolean) {
                    ProtoAdapter.BOOL.encodeWithTag(reverseProtoWriter, 4, (int) obj);
                } else if (!(obj instanceof Map)) {
                    if (!(obj instanceof List)) {
                        throw new IllegalArgumentException(Intrinsics.a("unexpected struct value: ", obj));
                    }
                    ProtoAdapter.STRUCT_LIST.encodeWithTag(reverseProtoWriter, 6, (int) obj);
                } else {
                    ProtoAdapter<Map<String, ?>> protoAdapter = ProtoAdapter.STRUCT_MAP;
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
                    }
                    protoAdapter.encodeWithTag(reverseProtoWriter, 5, (int) ((Map) obj));
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encodeWithTag(ProtoWriter protoWriter, int i, Object obj) {
                Intrinsics.e(protoWriter, "writer");
                if (obj != null) {
                    super.encodeWithTag(protoWriter, i, (int) obj);
                    return;
                }
                protoWriter.writeTag(i, getFieldEncoding$wire_runtime());
                protoWriter.writeVarint32(encodedSize(obj));
                encode(protoWriter, obj);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encodeWithTag(ReverseProtoWriter reverseProtoWriter, int i, Object obj) {
                Intrinsics.e(reverseProtoWriter, "writer");
                if (obj != null) {
                    super.encodeWithTag(reverseProtoWriter, i, (int) obj);
                    return;
                }
                int byteCount = reverseProtoWriter.getByteCount();
                encode(reverseProtoWriter, obj);
                reverseProtoWriter.writeVarint32(reverseProtoWriter.getByteCount() - byteCount);
                reverseProtoWriter.writeTag(i, getFieldEncoding$wire_runtime());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Object obj) {
                if (obj == null) {
                    return ProtoAdapter.STRUCT_NULL.encodedSizeWithTag(1, obj);
                }
                if (obj instanceof Number) {
                    return ProtoAdapter.DOUBLE.encodedSizeWithTag(2, Double.valueOf(((Number) obj).doubleValue()));
                }
                if (obj instanceof String) {
                    return ProtoAdapter.STRING.encodedSizeWithTag(3, obj);
                }
                if (obj instanceof Boolean) {
                    return ProtoAdapter.BOOL.encodedSizeWithTag(4, obj);
                }
                if (!(obj instanceof Map)) {
                    if (obj instanceof List) {
                        return ProtoAdapter.STRUCT_LIST.encodedSizeWithTag(6, obj);
                    }
                    throw new IllegalArgumentException(Intrinsics.a("unexpected struct value: ", obj));
                }
                ProtoAdapter<Map<String, ?>> protoAdapter = ProtoAdapter.STRUCT_MAP;
                if (obj != null) {
                    return protoAdapter.encodedSizeWithTag(5, (Map) obj);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSizeWithTag(int i, Object obj) {
                if (obj == null) {
                    int encodedSize = encodedSize(obj);
                    return ProtoWriter.Companion.tagSize$wire_runtime(i) + ProtoWriter.Companion.varint32Size$wire_runtime(encodedSize) + encodedSize;
                }
                return super.encodedSizeWithTag(i, obj);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Object redact(Object obj) {
                if (obj == null) {
                    return ProtoAdapter.STRUCT_NULL.redact(obj);
                }
                if (obj instanceof Number) {
                    return obj;
                }
                if (obj instanceof String) {
                    return null;
                }
                if (obj instanceof Boolean) {
                    return obj;
                }
                if (!(obj instanceof Map)) {
                    if (obj instanceof List) {
                        return ProtoAdapter.STRUCT_LIST.redact(obj);
                    }
                    throw new IllegalArgumentException(Intrinsics.a("unexpected struct value: ", obj));
                }
                ProtoAdapter<Map<String, ?>> protoAdapter = ProtoAdapter.STRUCT_MAP;
                if (obj != null) {
                    return protoAdapter.redact((Map) obj);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
            }
        };
    }

    public static final <E> String commonToString(E e) {
        return String.valueOf(e);
    }

    public static final ProtoAdapter<Integer> commonUint32() {
        final FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        final KClass b = Reflection.b(Integer.TYPE);
        final Syntax syntax = Syntax.PROTO_2;
        return new ProtoAdapter<Integer>(fieldEncoding, b, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonUint32$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Integer decode(ProtoReader protoReader) throws IOException {
                Intrinsics.e(protoReader, "reader");
                return Integer.valueOf(protoReader.readVarint32());
            }

            public void encode(ProtoWriter protoWriter, int i) throws IOException {
                Intrinsics.e(protoWriter, "writer");
                protoWriter.writeVarint32(i);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ void encode(ProtoWriter protoWriter, Integer num) {
                encode(protoWriter, num.intValue());
            }

            public void encode(ReverseProtoWriter reverseProtoWriter, int i) throws IOException {
                Intrinsics.e(reverseProtoWriter, "writer");
                reverseProtoWriter.writeVarint32(i);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Integer num) {
                encode(reverseProtoWriter, num.intValue());
            }

            public int encodedSize(int i) {
                return ProtoWriter.Companion.varint32Size$wire_runtime(i);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ int encodedSize(Integer num) {
                return encodedSize(num.intValue());
            }

            public Integer redact(int i) {
                throw new UnsupportedOperationException();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ Integer redact(Integer num) {
                return redact(num.intValue());
            }
        };
    }

    public static final ProtoAdapter<Long> commonUint64() {
        final FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        final KClass b = Reflection.b(Long.TYPE);
        final Syntax syntax = Syntax.PROTO_2;
        return new ProtoAdapter<Long>(fieldEncoding, b, syntax) { // from class: com.squareup.wire.ProtoAdapterKt$commonUint64$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Long decode(ProtoReader protoReader) throws IOException {
                Intrinsics.e(protoReader, "reader");
                return Long.valueOf(protoReader.readVarint64());
            }

            public void encode(ProtoWriter protoWriter, long j) throws IOException {
                Intrinsics.e(protoWriter, "writer");
                protoWriter.writeVarint64(j);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ void encode(ProtoWriter protoWriter, Long l) {
                encode(protoWriter, l.longValue());
            }

            public void encode(ReverseProtoWriter reverseProtoWriter, long j) throws IOException {
                Intrinsics.e(reverseProtoWriter, "writer");
                reverseProtoWriter.writeVarint64(j);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Long l) {
                encode(reverseProtoWriter, l.longValue());
            }

            public int encodedSize(long j) {
                return ProtoWriter.Companion.varint64Size$wire_runtime(j);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ int encodedSize(Long l) {
                return encodedSize(l.longValue());
            }

            public Long redact(long j) {
                throw new UnsupportedOperationException();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ Long redact(Long l) {
                return redact(l.longValue());
            }
        };
    }

    public static final <E> ProtoAdapter<?> commonWithLabel(ProtoAdapter<E> protoAdapter, WireField.Label label) {
        Intrinsics.e(protoAdapter, "<this>");
        Intrinsics.e(label, "label");
        ProtoAdapter<List<E>> protoAdapter2 = protoAdapter;
        if (label.isRepeated()) {
            if (label.isPacked()) {
                return protoAdapter.asPacked();
            }
            protoAdapter2 = protoAdapter.asRepeated();
        }
        return protoAdapter2;
    }

    public static final <T> ProtoAdapter<T> commonWrapper(final ProtoAdapter<T> protoAdapter, final String str) {
        Intrinsics.e(protoAdapter, "delegate");
        Intrinsics.e(str, "typeUrl");
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass<?> type = protoAdapter.getType();
        final Syntax syntax = Syntax.PROTO_3;
        final T identity = protoAdapter.getIdentity();
        return new ProtoAdapter<T>(str, protoAdapter, fieldEncoding, type, syntax, identity) { // from class: com.squareup.wire.ProtoAdapterKt$commonWrapper$1
            final /* synthetic */ ProtoAdapter<T> $delegate;
            final /* synthetic */ String $typeUrl;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(fieldEncoding, type, str, syntax, identity);
                this.$typeUrl = str;
                this.$delegate = protoAdapter;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public T decode(ProtoReader protoReader) {
                Intrinsics.e(protoReader, "reader");
                T identity2 = this.$delegate.getIdentity();
                ProtoAdapter<T> protoAdapter2 = this.$delegate;
                long beginMessage = protoReader.beginMessage();
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag == -1) {
                        protoReader.endMessageAndGetUnknownFields(beginMessage);
                        return identity2;
                    } else if (nextTag == 1) {
                        identity2 = protoAdapter2.decode(protoReader);
                    } else {
                        protoReader.readUnknownField(nextTag);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, T t) {
                Intrinsics.e(protoWriter, "writer");
                if (t == null || Intrinsics.a(t, this.$delegate.getIdentity())) {
                    return;
                }
                this.$delegate.encodeWithTag(protoWriter, 1, (int) t);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ReverseProtoWriter reverseProtoWriter, T t) {
                Intrinsics.e(reverseProtoWriter, "writer");
                if (t == null || Intrinsics.a(t, this.$delegate.getIdentity())) {
                    return;
                }
                this.$delegate.encodeWithTag(reverseProtoWriter, 1, (int) t);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(T t) {
                if (t == null || Intrinsics.a(t, this.$delegate.getIdentity())) {
                    return 0;
                }
                return this.$delegate.encodedSizeWithTag(1, t);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public T redact(T t) {
                if (t == null) {
                    return null;
                }
                return this.$delegate.redact(t);
            }
        };
    }

    public static final <E> void delegateEncode(ProtoAdapter<E> protoAdapter, ReverseProtoWriter reverseProtoWriter, E e) {
        Intrinsics.e(protoAdapter, "<this>");
        Intrinsics.e(reverseProtoWriter, "writer");
        reverseProtoWriter.writeForward$wire_runtime(new ProtoAdapterKt$delegateEncode$1(protoAdapter, e));
    }
}
