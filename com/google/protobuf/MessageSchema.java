package com.google.protobuf;

import com.google.protobuf.ArrayDecoders;
import com.google.protobuf.ByteString;
import com.google.protobuf.Internal;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/MessageSchema.class */
public final class MessageSchema<T> implements Schema<T> {
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int INTS_PER_FIELD = 3;
    private static final int NO_PRESENCE_SENTINEL = 1048575;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_MASK = 268435456;
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final boolean proto3;
    private final int repeatedFieldOffsetStart;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.protobuf.MessageSchema$1  reason: invalid class name */
    /* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/MessageSchema$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00d1 -> B:81:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00d5 -> B:95:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00d9 -> B:91:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00dd -> B:103:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00e1 -> B:99:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00e5 -> B:77:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00e9 -> B:73:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00ed -> B:85:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00f1 -> B:79:0x0070). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00f5 -> B:93:0x007c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00f9 -> B:89:0x0088). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x00fd -> B:101:0x0094). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0101 -> B:97:0x00a0). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x0105 -> B:75:0x00ac). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0109 -> B:71:0x00b8). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x010d -> B:83:0x00c4). Please submit an issue!!! */
        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
        }
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i, int i2, MessageLite messageLite, boolean z, boolean z2, int[] iArr2, int i3, int i4, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i;
        this.maxFieldNumber = i2;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.proto3 = z;
        this.hasExtensions = extensionSchema != null && extensionSchema.hasExtensions(messageLite);
        this.useCachedSizeField = z2;
        this.intArray = iArr2;
        this.checkInitializedCount = i3;
        this.repeatedFieldOffsetStart = i4;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema;
    }

    private boolean arePresentForEquals(T t, T t2, int i) {
        return isFieldPresent(t, i) == isFieldPresent(t2, i);
    }

    private static <T> boolean booleanAt(T t, long j) {
        return UnsafeUtil.getBoolean(t, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v34, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v41, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v45, types: [int] */
    private <K, V> int decodeMapEntry(byte[] bArr, int i, int i2, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map, ArrayDecoders.Registers registers) throws IOException {
        int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
        int i3 = registers.int1;
        if (i3 < 0 || i3 > i2 - decodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i4 = decodeVarint32 + i3;
        K k = metadata.defaultKey;
        V v = metadata.defaultValue;
        while (decodeVarint32 < i4) {
            int i5 = decodeVarint32 + 1;
            byte b = bArr[decodeVarint32];
            if (b < 0) {
                i5 = ArrayDecoders.decodeVarint32(b, bArr, i5, registers);
                b = registers.int1;
            }
            int i6 = b >>> 3;
            int i7 = b & 7;
            if (i6 != 1) {
                if (i6 == 2 && i7 == metadata.valueType.getWireType()) {
                    decodeVarint32 = decodeMapEntryValue(bArr, i5, i2, metadata.valueType, metadata.defaultValue.getClass(), registers);
                    v = registers.object1;
                }
                decodeVarint32 = ArrayDecoders.skipField(b, bArr, i5, i2, registers);
            } else if (i7 == metadata.keyType.getWireType()) {
                decodeVarint32 = decodeMapEntryValue(bArr, i5, i2, metadata.keyType, null, registers);
                k = registers.object1;
            } else {
                decodeVarint32 = ArrayDecoders.skipField(b, bArr, i5, i2, registers);
            }
        }
        if (decodeVarint32 == i4) {
            map.put(k, v);
            return i4;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    private int decodeMapEntryValue(byte[] bArr, int i, int i2, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int decodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Boolean.valueOf(registers.long1 != 0);
                return decodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(bArr, i, registers);
            case 3:
                registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(bArr, i));
                return i + 8;
            case 4:
            case 5:
                registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i));
                return i + 4;
            case 6:
            case 7:
                registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i));
                return i + 8;
            case 8:
                registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                return decodeVarint32;
            case 12:
            case 13:
                int decodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(registers.long1);
                return decodeVarint642;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) cls), bArr, i, i2, registers);
            case 15:
                int decodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                return decodeVarint322;
            case 16:
                int decodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                return decodeVarint643;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(bArr, i, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static <T> double doubleAt(T t, long j) {
        return UnsafeUtil.getDouble(t, j);
    }

    private boolean equals(T t, T t2, int i) {
        int typeAndOffsetAt = typeAndOffsetAt(i);
        long offset = offset(typeAndOffsetAt);
        switch (type(typeAndOffsetAt)) {
            case 0:
                boolean z = false;
                if (arePresentForEquals(t, t2, i)) {
                    z = false;
                    if (Double.doubleToLongBits(UnsafeUtil.getDouble(t, offset)) == Double.doubleToLongBits(UnsafeUtil.getDouble(t2, offset))) {
                        z = true;
                    }
                }
                return z;
            case 1:
                boolean z2 = false;
                if (arePresentForEquals(t, t2, i)) {
                    z2 = false;
                    if (Float.floatToIntBits(UnsafeUtil.getFloat(t, offset)) == Float.floatToIntBits(UnsafeUtil.getFloat(t2, offset))) {
                        z2 = true;
                    }
                }
                return z2;
            case 2:
                boolean z3 = false;
                if (arePresentForEquals(t, t2, i)) {
                    z3 = false;
                    if (UnsafeUtil.getLong(t, offset) == UnsafeUtil.getLong(t2, offset)) {
                        z3 = true;
                    }
                }
                return z3;
            case 3:
                boolean z4 = false;
                if (arePresentForEquals(t, t2, i)) {
                    z4 = false;
                    if (UnsafeUtil.getLong(t, offset) == UnsafeUtil.getLong(t2, offset)) {
                        z4 = true;
                    }
                }
                return z4;
            case 4:
                boolean z5 = false;
                if (arePresentForEquals(t, t2, i)) {
                    z5 = false;
                    if (UnsafeUtil.getInt(t, offset) == UnsafeUtil.getInt(t2, offset)) {
                        z5 = true;
                    }
                }
                return z5;
            case 5:
                boolean z6 = false;
                if (arePresentForEquals(t, t2, i)) {
                    z6 = false;
                    if (UnsafeUtil.getLong(t, offset) == UnsafeUtil.getLong(t2, offset)) {
                        z6 = true;
                    }
                }
                return z6;
            case 6:
                boolean z7 = false;
                if (arePresentForEquals(t, t2, i)) {
                    z7 = false;
                    if (UnsafeUtil.getInt(t, offset) == UnsafeUtil.getInt(t2, offset)) {
                        z7 = true;
                    }
                }
                return z7;
            case 7:
                boolean z8 = false;
                if (arePresentForEquals(t, t2, i)) {
                    z8 = false;
                    if (UnsafeUtil.getBoolean(t, offset) == UnsafeUtil.getBoolean(t2, offset)) {
                        z8 = true;
                    }
                }
                return z8;
            case 8:
                boolean z9 = false;
                if (arePresentForEquals(t, t2, i)) {
                    z9 = false;
                    if (SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset))) {
                        z9 = true;
                    }
                }
                return z9;
            case 9:
                boolean z10 = false;
                if (arePresentForEquals(t, t2, i)) {
                    z10 = false;
                    if (SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset))) {
                        z10 = true;
                    }
                }
                return z10;
            case 10:
                boolean z11 = false;
                if (arePresentForEquals(t, t2, i)) {
                    z11 = false;
                    if (SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset))) {
                        z11 = true;
                    }
                }
                return z11;
            case 11:
                boolean z12 = false;
                if (arePresentForEquals(t, t2, i)) {
                    z12 = false;
                    if (UnsafeUtil.getInt(t, offset) == UnsafeUtil.getInt(t2, offset)) {
                        z12 = true;
                    }
                }
                return z12;
            case 12:
                boolean z13 = false;
                if (arePresentForEquals(t, t2, i)) {
                    z13 = false;
                    if (UnsafeUtil.getInt(t, offset) == UnsafeUtil.getInt(t2, offset)) {
                        z13 = true;
                    }
                }
                return z13;
            case 13:
                boolean z14 = false;
                if (arePresentForEquals(t, t2, i)) {
                    z14 = false;
                    if (UnsafeUtil.getInt(t, offset) == UnsafeUtil.getInt(t2, offset)) {
                        z14 = true;
                    }
                }
                return z14;
            case 14:
                boolean z15 = false;
                if (arePresentForEquals(t, t2, i)) {
                    z15 = false;
                    if (UnsafeUtil.getLong(t, offset) == UnsafeUtil.getLong(t2, offset)) {
                        z15 = true;
                    }
                }
                return z15;
            case 15:
                boolean z16 = false;
                if (arePresentForEquals(t, t2, i)) {
                    z16 = false;
                    if (UnsafeUtil.getInt(t, offset) == UnsafeUtil.getInt(t2, offset)) {
                        z16 = true;
                    }
                }
                return z16;
            case 16:
                boolean z17 = false;
                if (arePresentForEquals(t, t2, i)) {
                    z17 = false;
                    if (UnsafeUtil.getLong(t, offset) == UnsafeUtil.getLong(t2, offset)) {
                        z17 = true;
                    }
                }
                return z17;
            case 17:
                boolean z18 = false;
                if (arePresentForEquals(t, t2, i)) {
                    z18 = false;
                    if (SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset))) {
                        z18 = true;
                    }
                }
                return z18;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset));
            case 50:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset));
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                boolean z19 = false;
                if (isOneofCaseEqual(t, t2, i)) {
                    z19 = false;
                    if (SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset))) {
                        z19 = true;
                    }
                }
                return z19;
            default:
                return true;
        }
    }

    private final <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        Internal.EnumVerifier enumFieldVerifier;
        int numberAt = numberAt(i);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i)));
        if (object != null && (enumFieldVerifier = getEnumFieldVerifier(i)) != null) {
            return (UB) filterUnknownEnumMap(i, numberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema);
        }
        return ub;
    }

    private final <K, V, UT, UB> UB filterUnknownEnumMap(int i, int i2, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        MapEntryLite.Metadata<?, ?> forMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                UB ub2 = ub;
                if (ub == null) {
                    ub2 = unknownFieldSchema.newBuilder();
                }
                ByteString.CodedBuilder newCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(forMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(newCodedBuilder.getCodedOutput(), forMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema.addLengthDelimited(ub2, i2, newCodedBuilder.build());
                    it.remove();
                    ub = ub2;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private static <T> float floatAt(T t, long j) {
        return UnsafeUtil.getFloat(t, j);
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int i) {
        return (Internal.EnumVerifier) this.objects[((i / 3) * 2) + 1];
    }

    private Object getMapFieldDefaultEntry(int i) {
        return this.objects[(i / 3) * 2];
    }

    private Schema getMessageFieldSchema(int i) {
        int i2 = (i / 3) * 2;
        Schema schema = (Schema) this.objects[i2];
        if (schema != null) {
            return schema;
        }
        Schema<T> schemaFor = Protobuf.getInstance().schemaFor((Class) ((Class) this.objects[i2 + 1]));
        this.objects[i2] = schemaFor;
        return schemaFor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UnknownFieldSetLite getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        UnknownFieldSetLite unknownFieldSetLite2 = unknownFieldSetLite;
        if (unknownFieldSetLite == UnknownFieldSetLite.getDefaultInstance()) {
            unknownFieldSetLite2 = UnknownFieldSetLite.newInstance();
            generatedMessageLite.unknownFields = unknownFieldSetLite2;
        }
        return unknownFieldSetLite2;
    }

    private int getSerializedSizeProto2(T t) {
        int i;
        int i2;
        int i3;
        int i4;
        int computeDoubleSize;
        int computeBoolSize;
        int computeSFixed32Size;
        int computeTagSize;
        int computeUInt32SizeNoTag;
        int i5;
        Unsafe unsafe = UNSAFE;
        int i6 = 0;
        int i7 = 0;
        int i8 = 1048575;
        int i9 = 0;
        while (i6 < this.buffer.length) {
            int typeAndOffsetAt = typeAndOffsetAt(i6);
            int numberAt = numberAt(i6);
            int type = type(typeAndOffsetAt);
            if (type <= 17) {
                int i10 = this.buffer[i6 + 2];
                int i11 = i10 & 1048575;
                int i12 = 1 << (i10 >>> 20);
                i3 = i8;
                i2 = i10;
                i = i12;
                if (i11 != i8) {
                    i9 = unsafe.getInt(t, i11);
                    i3 = i11;
                    i2 = i10;
                    i = i12;
                }
            } else {
                i = 0;
                i2 = (!this.useCachedSizeField || type < FieldType.DOUBLE_LIST_PACKED.id() || type > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.buffer[i6 + 2] & 1048575;
                i3 = i8;
            }
            long offset = offset(typeAndOffsetAt);
            switch (type) {
                case 0:
                    i4 = i7;
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeDoubleSize(numberAt, 0.0d);
                        i4 = i7 + computeDoubleSize;
                        break;
                    }
                case 1:
                    i4 = i7;
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeFloatSize(numberAt, 0.0f);
                        i4 = i7 + computeDoubleSize;
                        break;
                    }
                case 2:
                    i4 = i7;
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeInt64Size(numberAt, unsafe.getLong(t, offset));
                        i4 = i7 + computeDoubleSize;
                        break;
                    }
                case 3:
                    i4 = i7;
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeUInt64Size(numberAt, unsafe.getLong(t, offset));
                        i4 = i7 + computeDoubleSize;
                        break;
                    }
                case 4:
                    i4 = i7;
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeInt32Size(numberAt, unsafe.getInt(t, offset));
                        i4 = i7 + computeDoubleSize;
                        break;
                    }
                case 5:
                    i4 = i7;
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeFixed64Size(numberAt, 0L);
                        i4 = i7 + computeDoubleSize;
                        break;
                    }
                case 6:
                    i4 = i7;
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeFixed32Size(numberAt, 0);
                        i4 = i7 + computeDoubleSize;
                        break;
                    }
                case 7:
                    i4 = i7;
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        computeBoolSize = CodedOutputStream.computeBoolSize(numberAt, true);
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                case 8:
                    i4 = i7;
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        Object object = unsafe.getObject(t, offset);
                        computeBoolSize = object instanceof ByteString ? CodedOutputStream.computeBytesSize(numberAt, (ByteString) object) : CodedOutputStream.computeStringSize(numberAt, (String) object);
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                case 9:
                    i4 = i7;
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        computeBoolSize = SchemaUtil.computeSizeMessage(numberAt, unsafe.getObject(t, offset), getMessageFieldSchema(i6));
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                case 10:
                    i4 = i7;
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        computeBoolSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) unsafe.getObject(t, offset));
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                case 11:
                    i4 = i7;
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        computeBoolSize = CodedOutputStream.computeUInt32Size(numberAt, unsafe.getInt(t, offset));
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                case 12:
                    i4 = i7;
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        computeBoolSize = CodedOutputStream.computeEnumSize(numberAt, unsafe.getInt(t, offset));
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                case 13:
                    i4 = i7;
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        computeSFixed32Size = CodedOutputStream.computeSFixed32Size(numberAt, 0);
                        i4 = i7 + computeSFixed32Size;
                        break;
                    }
                case 14:
                    i4 = i7;
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        computeBoolSize = CodedOutputStream.computeSFixed64Size(numberAt, 0L);
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                case 15:
                    i4 = i7;
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        computeBoolSize = CodedOutputStream.computeSInt32Size(numberAt, unsafe.getInt(t, offset));
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                case 16:
                    i4 = i7;
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        computeBoolSize = CodedOutputStream.computeSInt64Size(numberAt, unsafe.getLong(t, offset));
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                case 17:
                    i4 = i7;
                    if ((i9 & i) == 0) {
                        break;
                    } else {
                        computeBoolSize = CodedOutputStream.computeGroupSize(numberAt, (MessageLite) unsafe.getObject(t, offset), getMessageFieldSchema(i6));
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                case 18:
                    computeBoolSize = SchemaUtil.computeSizeFixed64List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i4 = i7 + computeBoolSize;
                    break;
                case 19:
                    computeBoolSize = SchemaUtil.computeSizeFixed32List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i4 = i7 + computeBoolSize;
                    break;
                case 20:
                    computeBoolSize = SchemaUtil.computeSizeInt64List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i4 = i7 + computeBoolSize;
                    break;
                case 21:
                    computeBoolSize = SchemaUtil.computeSizeUInt64List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i4 = i7 + computeBoolSize;
                    break;
                case 22:
                    computeBoolSize = SchemaUtil.computeSizeInt32List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i4 = i7 + computeBoolSize;
                    break;
                case 23:
                    computeBoolSize = SchemaUtil.computeSizeFixed64List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i4 = i7 + computeBoolSize;
                    break;
                case 24:
                    computeBoolSize = SchemaUtil.computeSizeFixed32List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i4 = i7 + computeBoolSize;
                    break;
                case 25:
                    computeBoolSize = SchemaUtil.computeSizeBoolList(numberAt, (List) unsafe.getObject(t, offset), false);
                    i4 = i7 + computeBoolSize;
                    break;
                case 26:
                    computeBoolSize = SchemaUtil.computeSizeStringList(numberAt, (List) unsafe.getObject(t, offset));
                    i4 = i7 + computeBoolSize;
                    break;
                case 27:
                    computeBoolSize = SchemaUtil.computeSizeMessageList(numberAt, (List) unsafe.getObject(t, offset), getMessageFieldSchema(i6));
                    i4 = i7 + computeBoolSize;
                    break;
                case 28:
                    computeBoolSize = SchemaUtil.computeSizeByteStringList(numberAt, (List) unsafe.getObject(t, offset));
                    i4 = i7 + computeBoolSize;
                    break;
                case 29:
                    computeBoolSize = SchemaUtil.computeSizeUInt32List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i4 = i7 + computeBoolSize;
                    break;
                case 30:
                    computeBoolSize = SchemaUtil.computeSizeEnumList(numberAt, (List) unsafe.getObject(t, offset), false);
                    i4 = i7 + computeBoolSize;
                    break;
                case 31:
                    computeBoolSize = SchemaUtil.computeSizeFixed32List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i4 = i7 + computeBoolSize;
                    break;
                case 32:
                    computeBoolSize = SchemaUtil.computeSizeFixed64List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i4 = i7 + computeBoolSize;
                    break;
                case 33:
                    computeBoolSize = SchemaUtil.computeSizeSInt32List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i4 = i7 + computeBoolSize;
                    break;
                case 34:
                    computeBoolSize = SchemaUtil.computeSizeSInt64List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i4 = i7 + computeBoolSize;
                    break;
                case 35:
                    int computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, offset));
                    i4 = i7;
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        i5 = computeSizeFixed64ListNoTag;
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i5;
                        i4 = i7 + computeSFixed32Size;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    int computeSizeFixed32ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, offset));
                    i4 = i7;
                    if (computeSizeFixed32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, computeSizeFixed32ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i5 = computeSizeFixed32ListNoTag;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed32ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i5;
                        i4 = i7 + computeSFixed32Size;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    int computeSizeInt64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t, offset));
                    i4 = i7;
                    if (computeSizeInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, computeSizeInt64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i5 = computeSizeInt64ListNoTag;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeInt64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i5;
                        i4 = i7 + computeSFixed32Size;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    int computeSizeUInt64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t, offset));
                    i4 = i7;
                    if (computeSizeUInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, computeSizeUInt64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i5 = computeSizeUInt64ListNoTag;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeUInt64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i5;
                        i4 = i7 + computeSFixed32Size;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    int computeSizeInt32ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t, offset));
                    i4 = i7;
                    if (computeSizeInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, computeSizeInt32ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i5 = computeSizeInt32ListNoTag;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeInt32ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i5;
                        i4 = i7 + computeSFixed32Size;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    int computeSizeFixed64ListNoTag2 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, offset));
                    i4 = i7;
                    if (computeSizeFixed64ListNoTag2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, computeSizeFixed64ListNoTag2);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i5 = computeSizeFixed64ListNoTag2;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag2);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i5;
                        i4 = i7 + computeSFixed32Size;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    int computeSizeFixed32ListNoTag2 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, offset));
                    i4 = i7;
                    if (computeSizeFixed32ListNoTag2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, computeSizeFixed32ListNoTag2);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i5 = computeSizeFixed32ListNoTag2;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed32ListNoTag2);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i5;
                        i4 = i7 + computeSFixed32Size;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    int computeSizeBoolListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t, offset));
                    i4 = i7;
                    if (computeSizeBoolListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, computeSizeBoolListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i5 = computeSizeBoolListNoTag;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeBoolListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i5;
                        i4 = i7 + computeSFixed32Size;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    int computeSizeUInt32ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t, offset));
                    i4 = i7;
                    if (computeSizeUInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, computeSizeUInt32ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i5 = computeSizeUInt32ListNoTag;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeUInt32ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i5;
                        i4 = i7 + computeSFixed32Size;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    int computeSizeEnumListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t, offset));
                    i4 = i7;
                    if (computeSizeEnumListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, computeSizeEnumListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i5 = computeSizeEnumListNoTag;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeEnumListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i5;
                        i4 = i7 + computeSFixed32Size;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    int computeSizeFixed32ListNoTag3 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, offset));
                    i4 = i7;
                    if (computeSizeFixed32ListNoTag3 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, computeSizeFixed32ListNoTag3);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i5 = computeSizeFixed32ListNoTag3;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed32ListNoTag3);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i5;
                        i4 = i7 + computeSFixed32Size;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    int computeSizeFixed64ListNoTag3 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, offset));
                    i4 = i7;
                    if (computeSizeFixed64ListNoTag3 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, computeSizeFixed64ListNoTag3);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i5 = computeSizeFixed64ListNoTag3;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag3);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i5;
                        i4 = i7 + computeSFixed32Size;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    int computeSizeSInt32ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t, offset));
                    i4 = i7;
                    if (computeSizeSInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, computeSizeSInt32ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i5 = computeSizeSInt32ListNoTag;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeSInt32ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i5;
                        i4 = i7 + computeSFixed32Size;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    int computeSizeSInt64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t, offset));
                    i4 = i7;
                    if (computeSizeSInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, computeSizeSInt64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i5 = computeSizeSInt64ListNoTag;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeSInt64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + i5;
                        i4 = i7 + computeSFixed32Size;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    computeBoolSize = SchemaUtil.computeSizeGroupList(numberAt, (List) unsafe.getObject(t, offset), getMessageFieldSchema(i6));
                    i4 = i7 + computeBoolSize;
                    break;
                case 50:
                    computeBoolSize = this.mapFieldSchema.getSerializedSize(numberAt, unsafe.getObject(t, offset), getMapFieldDefaultEntry(i6));
                    i4 = i7 + computeBoolSize;
                    break;
                case 51:
                    i4 = i7;
                    if (!isOneofPresent(t, numberAt, i6)) {
                        break;
                    } else {
                        computeBoolSize = CodedOutputStream.computeDoubleSize(numberAt, 0.0d);
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                case 52:
                    i4 = i7;
                    if (!isOneofPresent(t, numberAt, i6)) {
                        break;
                    } else {
                        computeBoolSize = CodedOutputStream.computeFloatSize(numberAt, 0.0f);
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                case 53:
                    i4 = i7;
                    if (!isOneofPresent(t, numberAt, i6)) {
                        break;
                    } else {
                        computeBoolSize = CodedOutputStream.computeInt64Size(numberAt, oneofLongAt(t, offset));
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                case 54:
                    i4 = i7;
                    if (!isOneofPresent(t, numberAt, i6)) {
                        break;
                    } else {
                        computeBoolSize = CodedOutputStream.computeUInt64Size(numberAt, oneofLongAt(t, offset));
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                case 55:
                    i4 = i7;
                    if (!isOneofPresent(t, numberAt, i6)) {
                        break;
                    } else {
                        computeBoolSize = CodedOutputStream.computeInt32Size(numberAt, oneofIntAt(t, offset));
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                case 56:
                    i4 = i7;
                    if (!isOneofPresent(t, numberAt, i6)) {
                        break;
                    } else {
                        computeBoolSize = CodedOutputStream.computeFixed64Size(numberAt, 0L);
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                case 57:
                    i4 = i7;
                    if (!isOneofPresent(t, numberAt, i6)) {
                        break;
                    } else {
                        computeSFixed32Size = CodedOutputStream.computeFixed32Size(numberAt, 0);
                        i4 = i7 + computeSFixed32Size;
                        break;
                    }
                case 58:
                    i4 = i7;
                    if (!isOneofPresent(t, numberAt, i6)) {
                        break;
                    } else {
                        computeBoolSize = CodedOutputStream.computeBoolSize(numberAt, true);
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                case 59:
                    i4 = i7;
                    if (!isOneofPresent(t, numberAt, i6)) {
                        break;
                    } else {
                        Object object2 = unsafe.getObject(t, offset);
                        computeBoolSize = object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(numberAt, (ByteString) object2) : CodedOutputStream.computeStringSize(numberAt, (String) object2);
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                case 60:
                    i4 = i7;
                    if (!isOneofPresent(t, numberAt, i6)) {
                        break;
                    } else {
                        computeBoolSize = SchemaUtil.computeSizeMessage(numberAt, unsafe.getObject(t, offset), getMessageFieldSchema(i6));
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                case 61:
                    i4 = i7;
                    if (!isOneofPresent(t, numberAt, i6)) {
                        break;
                    } else {
                        computeBoolSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) unsafe.getObject(t, offset));
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                case 62:
                    i4 = i7;
                    if (!isOneofPresent(t, numberAt, i6)) {
                        break;
                    } else {
                        computeBoolSize = CodedOutputStream.computeUInt32Size(numberAt, oneofIntAt(t, offset));
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                case 63:
                    i4 = i7;
                    if (!isOneofPresent(t, numberAt, i6)) {
                        break;
                    } else {
                        computeBoolSize = CodedOutputStream.computeEnumSize(numberAt, oneofIntAt(t, offset));
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                case 64:
                    i4 = i7;
                    if (!isOneofPresent(t, numberAt, i6)) {
                        break;
                    } else {
                        computeSFixed32Size = CodedOutputStream.computeSFixed32Size(numberAt, 0);
                        i4 = i7 + computeSFixed32Size;
                        break;
                    }
                case 65:
                    i4 = i7;
                    if (!isOneofPresent(t, numberAt, i6)) {
                        break;
                    } else {
                        computeBoolSize = CodedOutputStream.computeSFixed64Size(numberAt, 0L);
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                case 66:
                    i4 = i7;
                    if (!isOneofPresent(t, numberAt, i6)) {
                        break;
                    } else {
                        computeBoolSize = CodedOutputStream.computeSInt32Size(numberAt, oneofIntAt(t, offset));
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                case 67:
                    i4 = i7;
                    if (!isOneofPresent(t, numberAt, i6)) {
                        break;
                    } else {
                        computeBoolSize = CodedOutputStream.computeSInt64Size(numberAt, oneofLongAt(t, offset));
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                case 68:
                    i4 = i7;
                    if (!isOneofPresent(t, numberAt, i6)) {
                        break;
                    } else {
                        computeBoolSize = CodedOutputStream.computeGroupSize(numberAt, (MessageLite) unsafe.getObject(t, offset), getMessageFieldSchema(i6));
                        i4 = i7 + computeBoolSize;
                        break;
                    }
                default:
                    i4 = i7;
                    break;
            }
            i6 += 3;
            i7 = i4;
            i8 = i3;
        }
        int unknownFieldsSerializedSize = i7 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t);
        int i13 = unknownFieldsSerializedSize;
        if (this.hasExtensions) {
            i13 = unknownFieldsSerializedSize + this.extensionSchema.getExtensions(t).getSerializedSize();
        }
        return i13;
    }

    private int getSerializedSizeProto3(T t) {
        int i;
        int computeDoubleSize;
        int computeTagSize;
        int computeUInt32SizeNoTag;
        int i2;
        Unsafe unsafe = UNSAFE;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i3 >= this.buffer.length) {
                return i5 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t);
            }
            int typeAndOffsetAt = typeAndOffsetAt(i3);
            int type = type(typeAndOffsetAt);
            int numberAt = numberAt(i3);
            long offset = offset(typeAndOffsetAt);
            int i6 = (type < FieldType.DOUBLE_LIST_PACKED.id() || type > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.buffer[i3 + 2] & 1048575;
            switch (type) {
                case 0:
                    i = i5;
                    if (isFieldPresent(t, i3)) {
                        computeDoubleSize = CodedOutputStream.computeDoubleSize(numberAt, 0.0d);
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 1:
                    i = i5;
                    if (isFieldPresent(t, i3)) {
                        computeDoubleSize = CodedOutputStream.computeFloatSize(numberAt, 0.0f);
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 2:
                    i = i5;
                    if (isFieldPresent(t, i3)) {
                        computeDoubleSize = CodedOutputStream.computeInt64Size(numberAt, UnsafeUtil.getLong(t, offset));
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 3:
                    i = i5;
                    if (isFieldPresent(t, i3)) {
                        computeDoubleSize = CodedOutputStream.computeUInt64Size(numberAt, UnsafeUtil.getLong(t, offset));
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 4:
                    i = i5;
                    if (isFieldPresent(t, i3)) {
                        computeDoubleSize = CodedOutputStream.computeInt32Size(numberAt, UnsafeUtil.getInt(t, offset));
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 5:
                    i = i5;
                    if (isFieldPresent(t, i3)) {
                        computeDoubleSize = CodedOutputStream.computeFixed64Size(numberAt, 0L);
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 6:
                    i = i5;
                    if (isFieldPresent(t, i3)) {
                        computeDoubleSize = CodedOutputStream.computeFixed32Size(numberAt, 0);
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 7:
                    i = i5;
                    if (isFieldPresent(t, i3)) {
                        computeDoubleSize = CodedOutputStream.computeBoolSize(numberAt, true);
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 8:
                    i = i5;
                    if (isFieldPresent(t, i3)) {
                        Object object = UnsafeUtil.getObject(t, offset);
                        if (!(object instanceof ByteString)) {
                            computeDoubleSize = CodedOutputStream.computeStringSize(numberAt, (String) object);
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) object);
                            break;
                        }
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 9:
                    i = i5;
                    if (isFieldPresent(t, i3)) {
                        computeDoubleSize = SchemaUtil.computeSizeMessage(numberAt, UnsafeUtil.getObject(t, offset), getMessageFieldSchema(i3));
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 10:
                    i = i5;
                    if (isFieldPresent(t, i3)) {
                        computeDoubleSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) UnsafeUtil.getObject(t, offset));
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 11:
                    i = i5;
                    if (isFieldPresent(t, i3)) {
                        computeDoubleSize = CodedOutputStream.computeUInt32Size(numberAt, UnsafeUtil.getInt(t, offset));
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 12:
                    i = i5;
                    if (isFieldPresent(t, i3)) {
                        computeDoubleSize = CodedOutputStream.computeEnumSize(numberAt, UnsafeUtil.getInt(t, offset));
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 13:
                    i = i5;
                    if (isFieldPresent(t, i3)) {
                        computeDoubleSize = CodedOutputStream.computeSFixed32Size(numberAt, 0);
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 14:
                    i = i5;
                    if (isFieldPresent(t, i3)) {
                        computeDoubleSize = CodedOutputStream.computeSFixed64Size(numberAt, 0L);
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 15:
                    i = i5;
                    if (isFieldPresent(t, i3)) {
                        computeDoubleSize = CodedOutputStream.computeSInt32Size(numberAt, UnsafeUtil.getInt(t, offset));
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 16:
                    i = i5;
                    if (isFieldPresent(t, i3)) {
                        computeDoubleSize = CodedOutputStream.computeSInt64Size(numberAt, UnsafeUtil.getLong(t, offset));
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 17:
                    i = i5;
                    if (isFieldPresent(t, i3)) {
                        computeDoubleSize = CodedOutputStream.computeGroupSize(numberAt, (MessageLite) UnsafeUtil.getObject(t, offset), getMessageFieldSchema(i3));
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 18:
                    computeDoubleSize = SchemaUtil.computeSizeFixed64List(numberAt, listAt(t, offset), false);
                    break;
                case 19:
                    computeDoubleSize = SchemaUtil.computeSizeFixed32List(numberAt, listAt(t, offset), false);
                    break;
                case 20:
                    computeDoubleSize = SchemaUtil.computeSizeInt64List(numberAt, listAt(t, offset), false);
                    break;
                case 21:
                    computeDoubleSize = SchemaUtil.computeSizeUInt64List(numberAt, listAt(t, offset), false);
                    break;
                case 22:
                    computeDoubleSize = SchemaUtil.computeSizeInt32List(numberAt, listAt(t, offset), false);
                    break;
                case 23:
                    computeDoubleSize = SchemaUtil.computeSizeFixed64List(numberAt, listAt(t, offset), false);
                    break;
                case 24:
                    computeDoubleSize = SchemaUtil.computeSizeFixed32List(numberAt, listAt(t, offset), false);
                    break;
                case 25:
                    computeDoubleSize = SchemaUtil.computeSizeBoolList(numberAt, listAt(t, offset), false);
                    break;
                case 26:
                    computeDoubleSize = SchemaUtil.computeSizeStringList(numberAt, listAt(t, offset));
                    break;
                case 27:
                    computeDoubleSize = SchemaUtil.computeSizeMessageList(numberAt, listAt(t, offset), getMessageFieldSchema(i3));
                    break;
                case 28:
                    computeDoubleSize = SchemaUtil.computeSizeByteStringList(numberAt, listAt(t, offset));
                    break;
                case 29:
                    computeDoubleSize = SchemaUtil.computeSizeUInt32List(numberAt, listAt(t, offset), false);
                    break;
                case 30:
                    computeDoubleSize = SchemaUtil.computeSizeEnumList(numberAt, listAt(t, offset), false);
                    break;
                case 31:
                    computeDoubleSize = SchemaUtil.computeSizeFixed32List(numberAt, listAt(t, offset), false);
                    break;
                case 32:
                    computeDoubleSize = SchemaUtil.computeSizeFixed64List(numberAt, listAt(t, offset), false);
                    break;
                case 33:
                    computeDoubleSize = SchemaUtil.computeSizeSInt32List(numberAt, listAt(t, offset), false);
                    break;
                case 34:
                    computeDoubleSize = SchemaUtil.computeSizeSInt64List(numberAt, listAt(t, offset), false);
                    break;
                case 35:
                    int computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, offset));
                    i = i5;
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i6, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        i2 = computeSizeFixed64ListNoTag;
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i2;
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 36:
                    int computeSizeFixed32ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, offset));
                    i = i5;
                    if (computeSizeFixed32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i6, computeSizeFixed32ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i2 = computeSizeFixed32ListNoTag;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed32ListNoTag);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i2;
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 37:
                    int computeSizeInt64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t, offset));
                    i = i5;
                    if (computeSizeInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i6, computeSizeInt64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i2 = computeSizeInt64ListNoTag;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeInt64ListNoTag);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i2;
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 38:
                    int computeSizeUInt64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t, offset));
                    i = i5;
                    if (computeSizeUInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i6, computeSizeUInt64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i2 = computeSizeUInt64ListNoTag;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeUInt64ListNoTag);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i2;
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 39:
                    int computeSizeInt32ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t, offset));
                    i = i5;
                    if (computeSizeInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i6, computeSizeInt32ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i2 = computeSizeInt32ListNoTag;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeInt32ListNoTag);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i2;
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 40:
                    int computeSizeFixed64ListNoTag2 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, offset));
                    i = i5;
                    if (computeSizeFixed64ListNoTag2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i6, computeSizeFixed64ListNoTag2);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i2 = computeSizeFixed64ListNoTag2;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag2);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i2;
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 41:
                    int computeSizeFixed32ListNoTag2 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, offset));
                    i = i5;
                    if (computeSizeFixed32ListNoTag2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i6, computeSizeFixed32ListNoTag2);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i2 = computeSizeFixed32ListNoTag2;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed32ListNoTag2);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i2;
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 42:
                    int computeSizeBoolListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t, offset));
                    i = i5;
                    if (computeSizeBoolListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i6, computeSizeBoolListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i2 = computeSizeBoolListNoTag;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeBoolListNoTag);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i2;
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 43:
                    int computeSizeUInt32ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t, offset));
                    i = i5;
                    if (computeSizeUInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i6, computeSizeUInt32ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i2 = computeSizeUInt32ListNoTag;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeUInt32ListNoTag);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i2;
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 44:
                    int computeSizeEnumListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t, offset));
                    i = i5;
                    if (computeSizeEnumListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i6, computeSizeEnumListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i2 = computeSizeEnumListNoTag;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeEnumListNoTag);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i2;
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 45:
                    int computeSizeFixed32ListNoTag3 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, offset));
                    i = i5;
                    if (computeSizeFixed32ListNoTag3 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i6, computeSizeFixed32ListNoTag3);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i2 = computeSizeFixed32ListNoTag3;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed32ListNoTag3);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i2;
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 46:
                    int computeSizeFixed64ListNoTag3 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, offset));
                    i = i5;
                    if (computeSizeFixed64ListNoTag3 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i6, computeSizeFixed64ListNoTag3);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i2 = computeSizeFixed64ListNoTag3;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag3);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i2;
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 47:
                    int computeSizeSInt32ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t, offset));
                    i = i5;
                    if (computeSizeSInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i6, computeSizeSInt32ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i2 = computeSizeSInt32ListNoTag;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeSInt32ListNoTag);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i2;
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 48:
                    int computeSizeSInt64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t, offset));
                    i = i5;
                    if (computeSizeSInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i6, computeSizeSInt64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        i2 = computeSizeSInt64ListNoTag;
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeSInt64ListNoTag);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + i2;
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 49:
                    computeDoubleSize = SchemaUtil.computeSizeGroupList(numberAt, listAt(t, offset), getMessageFieldSchema(i3));
                    break;
                case 50:
                    computeDoubleSize = this.mapFieldSchema.getSerializedSize(numberAt, UnsafeUtil.getObject(t, offset), getMapFieldDefaultEntry(i3));
                    break;
                case 51:
                    i = i5;
                    if (isOneofPresent(t, numberAt, i3)) {
                        computeDoubleSize = CodedOutputStream.computeDoubleSize(numberAt, 0.0d);
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 52:
                    i = i5;
                    if (isOneofPresent(t, numberAt, i3)) {
                        computeDoubleSize = CodedOutputStream.computeFloatSize(numberAt, 0.0f);
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 53:
                    i = i5;
                    if (isOneofPresent(t, numberAt, i3)) {
                        computeDoubleSize = CodedOutputStream.computeInt64Size(numberAt, oneofLongAt(t, offset));
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 54:
                    i = i5;
                    if (isOneofPresent(t, numberAt, i3)) {
                        computeDoubleSize = CodedOutputStream.computeUInt64Size(numberAt, oneofLongAt(t, offset));
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 55:
                    i = i5;
                    if (isOneofPresent(t, numberAt, i3)) {
                        computeDoubleSize = CodedOutputStream.computeInt32Size(numberAt, oneofIntAt(t, offset));
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 56:
                    i = i5;
                    if (isOneofPresent(t, numberAt, i3)) {
                        computeDoubleSize = CodedOutputStream.computeFixed64Size(numberAt, 0L);
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 57:
                    i = i5;
                    if (isOneofPresent(t, numberAt, i3)) {
                        computeDoubleSize = CodedOutputStream.computeFixed32Size(numberAt, 0);
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 58:
                    i = i5;
                    if (isOneofPresent(t, numberAt, i3)) {
                        computeDoubleSize = CodedOutputStream.computeBoolSize(numberAt, true);
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 59:
                    i = i5;
                    if (isOneofPresent(t, numberAt, i3)) {
                        Object object2 = UnsafeUtil.getObject(t, offset);
                        if (!(object2 instanceof ByteString)) {
                            computeDoubleSize = CodedOutputStream.computeStringSize(numberAt, (String) object2);
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) object2);
                            break;
                        }
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 60:
                    i = i5;
                    if (isOneofPresent(t, numberAt, i3)) {
                        computeDoubleSize = SchemaUtil.computeSizeMessage(numberAt, UnsafeUtil.getObject(t, offset), getMessageFieldSchema(i3));
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 61:
                    i = i5;
                    if (isOneofPresent(t, numberAt, i3)) {
                        computeDoubleSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) UnsafeUtil.getObject(t, offset));
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 62:
                    i = i5;
                    if (isOneofPresent(t, numberAt, i3)) {
                        computeDoubleSize = CodedOutputStream.computeUInt32Size(numberAt, oneofIntAt(t, offset));
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 63:
                    i = i5;
                    if (isOneofPresent(t, numberAt, i3)) {
                        computeDoubleSize = CodedOutputStream.computeEnumSize(numberAt, oneofIntAt(t, offset));
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 64:
                    i = i5;
                    if (isOneofPresent(t, numberAt, i3)) {
                        computeDoubleSize = CodedOutputStream.computeSFixed32Size(numberAt, 0);
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 65:
                    i = i5;
                    if (isOneofPresent(t, numberAt, i3)) {
                        computeDoubleSize = CodedOutputStream.computeSFixed64Size(numberAt, 0L);
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 66:
                    i = i5;
                    if (isOneofPresent(t, numberAt, i3)) {
                        computeDoubleSize = CodedOutputStream.computeSInt32Size(numberAt, oneofIntAt(t, offset));
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 67:
                    i = i5;
                    if (isOneofPresent(t, numberAt, i3)) {
                        computeDoubleSize = CodedOutputStream.computeSInt64Size(numberAt, oneofLongAt(t, offset));
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                case 68:
                    i = i5;
                    if (isOneofPresent(t, numberAt, i3)) {
                        computeDoubleSize = CodedOutputStream.computeGroupSize(numberAt, (MessageLite) UnsafeUtil.getObject(t, offset), getMessageFieldSchema(i3));
                        break;
                    } else {
                        continue;
                        i3 += 3;
                        i4 = i;
                    }
                default:
                    i = i5;
                    continue;
                    i3 += 3;
                    i4 = i;
            }
            i = i5 + computeDoubleSize;
            i3 += 3;
            i4 = i;
        }
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t) {
        return unknownFieldSchema.getSerializedSize(unknownFieldSchema.getFromMessage(t));
    }

    private static <T> int intAt(T t, long j) {
        return UnsafeUtil.getInt(t, j);
    }

    private static boolean isEnforceUtf8(int i) {
        return (i & 536870912) != 0;
    }

    private boolean isFieldPresent(T t, int i) {
        int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        long j = 1048575 & presenceMaskAndOffsetAt;
        boolean z = false;
        if (j != 1048575) {
            boolean z2 = false;
            if ((UnsafeUtil.getInt(t, j) & (1 << (presenceMaskAndOffsetAt >>> 20))) != 0) {
                z2 = true;
            }
            return z2;
        }
        int typeAndOffsetAt = typeAndOffsetAt(i);
        long offset = offset(typeAndOffsetAt);
        switch (type(typeAndOffsetAt)) {
            case 0:
                boolean z3 = false;
                if (UnsafeUtil.getDouble(t, offset) != 0.0d) {
                    z3 = true;
                }
                return z3;
            case 1:
                boolean z4 = false;
                if (UnsafeUtil.getFloat(t, offset) != 0.0f) {
                    z4 = true;
                }
                return z4;
            case 2:
                boolean z5 = false;
                if (UnsafeUtil.getLong(t, offset) != 0) {
                    z5 = true;
                }
                return z5;
            case 3:
                boolean z6 = false;
                if (UnsafeUtil.getLong(t, offset) != 0) {
                    z6 = true;
                }
                return z6;
            case 4:
                boolean z7 = false;
                if (UnsafeUtil.getInt(t, offset) != 0) {
                    z7 = true;
                }
                return z7;
            case 5:
                boolean z8 = false;
                if (UnsafeUtil.getLong(t, offset) != 0) {
                    z8 = true;
                }
                return z8;
            case 6:
                boolean z9 = false;
                if (UnsafeUtil.getInt(t, offset) != 0) {
                    z9 = true;
                }
                return z9;
            case 7:
                return UnsafeUtil.getBoolean(t, offset);
            case 8:
                Object object = UnsafeUtil.getObject(t, offset);
                if (object instanceof String) {
                    return !((String) object).isEmpty();
                }
                if (object instanceof ByteString) {
                    return !ByteString.EMPTY.equals(object);
                }
                throw new IllegalArgumentException();
            case 9:
                boolean z10 = false;
                if (UnsafeUtil.getObject(t, offset) != null) {
                    z10 = true;
                }
                return z10;
            case 10:
                return !ByteString.EMPTY.equals(UnsafeUtil.getObject(t, offset));
            case 11:
                boolean z11 = false;
                if (UnsafeUtil.getInt(t, offset) != 0) {
                    z11 = true;
                }
                return z11;
            case 12:
                boolean z12 = false;
                if (UnsafeUtil.getInt(t, offset) != 0) {
                    z12 = true;
                }
                return z12;
            case 13:
                boolean z13 = false;
                if (UnsafeUtil.getInt(t, offset) != 0) {
                    z13 = true;
                }
                return z13;
            case 14:
                boolean z14 = false;
                if (UnsafeUtil.getLong(t, offset) != 0) {
                    z14 = true;
                }
                return z14;
            case 15:
                boolean z15 = false;
                if (UnsafeUtil.getInt(t, offset) != 0) {
                    z15 = true;
                }
                return z15;
            case 16:
                boolean z16 = false;
                if (UnsafeUtil.getLong(t, offset) != 0) {
                    z16 = true;
                }
                return z16;
            case 17:
                if (UnsafeUtil.getObject(t, offset) != null) {
                    z = true;
                }
                return z;
            default:
                throw new IllegalArgumentException();
        }
    }

    private boolean isFieldPresent(T t, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? isFieldPresent(t, i) : (i3 & i4) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object obj, int i, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(obj, offset(i)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object obj, int i, int i2) {
        List list = (List) UnsafeUtil.getObject(obj, offset(i));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(i2);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= list.size()) {
                return true;
            }
            if (!messageFieldSchema.isInitialized(list.get(i4))) {
                return false;
            }
            i3 = i4 + 1;
        }
    }

    private boolean isMapInitialized(T t, int i, int i2) {
        Map<?, ?> forMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(t, offset(i)));
        if (forMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        Schema<T> schema = null;
        for (Object obj : forMapData.values()) {
            Schema<T> schema2 = schema;
            if (schema == null) {
                schema2 = Protobuf.getInstance().schemaFor((Class) obj.getClass());
            }
            schema = schema2;
            if (!schema2.isInitialized(obj)) {
                return false;
            }
        }
        return true;
    }

    private boolean isOneofCaseEqual(T t, T t2, int i) {
        long presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i) & 1048575;
        return UnsafeUtil.getInt(t, presenceMaskAndOffsetAt) == UnsafeUtil.getInt(t2, presenceMaskAndOffsetAt);
    }

    private boolean isOneofPresent(T t, int i, int i2) {
        return UnsafeUtil.getInt(t, (long) (presenceMaskAndOffsetAt(i2) & 1048575)) == i;
    }

    private static boolean isRequired(int i) {
        return (i & 268435456) != 0;
    }

    private static List<?> listAt(Object obj, long j) {
        return (List) UnsafeUtil.getObject(obj, j);
    }

    private static <T> long longAt(T t, long j) {
        return UnsafeUtil.getLong(t, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x010f, code lost:
        r0 = r8.checkInitializedCount;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0115, code lost:
        r14 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x011b, code lost:
        if (r14 >= r8.repeatedFieldOffsetStart) goto L534;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x011e, code lost:
        r22 = filterMapUnknownEnumValues(r11, r8.intArray[r14], r22, r9);
        r0 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:581:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x013a, code lost:
        if (r22 == null) goto L539;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x013d, code lost:
        r9.setBuilderToMessage(r11, r22);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0144, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <UT, UB, ET extends com.google.protobuf.FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(com.google.protobuf.UnknownFieldSchema<UT, UB> r9, com.google.protobuf.ExtensionSchema<ET> r10, T r11, com.google.protobuf.Reader r12, com.google.protobuf.ExtensionRegistryLite r13) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 4093
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.mergeFromHelper(com.google.protobuf.UnknownFieldSchema, com.google.protobuf.ExtensionSchema, java.lang.Object, com.google.protobuf.Reader, com.google.protobuf.ExtensionRegistryLite):void");
    }

    private final <K, V> void mergeMap(Object obj, int i, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) throws IOException {
        Object obj3;
        long offset = offset(typeAndOffsetAt(i));
        Object object = UnsafeUtil.getObject(obj, offset);
        if (object == null) {
            obj3 = this.mapFieldSchema.newMapField(obj2);
            UnsafeUtil.putObject(obj, offset, obj3);
        } else {
            obj3 = object;
            if (this.mapFieldSchema.isImmutable(object)) {
                obj3 = this.mapFieldSchema.newMapField(obj2);
                this.mapFieldSchema.mergeFrom(obj3, object);
                UnsafeUtil.putObject(obj, offset, obj3);
            }
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(obj3), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    private void mergeMessage(T t, T t2, int i) {
        long offset = offset(typeAndOffsetAt(i));
        if (isFieldPresent(t2, i)) {
            Object object = UnsafeUtil.getObject(t, offset);
            Object object2 = UnsafeUtil.getObject(t2, offset);
            if (object != null && object2 != null) {
                UnsafeUtil.putObject(t, offset, Internal.mergeMessage(object, object2));
                setFieldPresent(t, i);
            } else if (object2 != null) {
                UnsafeUtil.putObject(t, offset, object2);
                setFieldPresent(t, i);
            }
        }
    }

    private void mergeOneofMessage(T t, T t2, int i) {
        int typeAndOffsetAt = typeAndOffsetAt(i);
        int numberAt = numberAt(i);
        long offset = offset(typeAndOffsetAt);
        if (isOneofPresent(t2, numberAt, i)) {
            Object object = UnsafeUtil.getObject(t, offset);
            Object object2 = UnsafeUtil.getObject(t2, offset);
            if (object != null && object2 != null) {
                UnsafeUtil.putObject(t, offset, Internal.mergeMessage(object, object2));
                setOneofPresent(t, numberAt, i);
            } else if (object2 != null) {
                UnsafeUtil.putObject(t, offset, object2);
                setOneofPresent(t, numberAt, i);
            }
        }
    }

    private void mergeSingleField(T t, T t2, int i) {
        int typeAndOffsetAt = typeAndOffsetAt(i);
        long offset = offset(typeAndOffsetAt);
        int numberAt = numberAt(i);
        switch (type(typeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putDouble(t, offset, UnsafeUtil.getDouble(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 1:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putFloat(t, offset, UnsafeUtil.getFloat(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 2:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, offset, UnsafeUtil.getLong(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 3:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, offset, UnsafeUtil.getLong(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 4:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, offset, UnsafeUtil.getInt(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 5:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, offset, UnsafeUtil.getLong(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 6:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, offset, UnsafeUtil.getInt(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 7:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putBoolean(t, offset, UnsafeUtil.getBoolean(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 8:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject(t, offset, UnsafeUtil.getObject(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 9:
                mergeMessage(t, t2, i);
                return;
            case 10:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject(t, offset, UnsafeUtil.getObject(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 11:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, offset, UnsafeUtil.getInt(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 12:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, offset, UnsafeUtil.getInt(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 13:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, offset, UnsafeUtil.getInt(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 14:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, offset, UnsafeUtil.getLong(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 15:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, offset, UnsafeUtil.getInt(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 16:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, offset, UnsafeUtil.getLong(t2, offset));
                    setFieldPresent(t, i);
                    return;
                }
                return;
            case 17:
                mergeMessage(t, t2, i);
                return;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.listFieldSchema.mergeListsAt(t, t2, offset);
                return;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t, t2, offset);
                return;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(t2, numberAt, i)) {
                    UnsafeUtil.putObject(t, offset, UnsafeUtil.getObject(t2, offset));
                    setOneofPresent(t, numberAt, i);
                    return;
                }
                return;
            case 60:
                mergeOneofMessage(t, t2, i);
                return;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (isOneofPresent(t2, numberAt, i)) {
                    UnsafeUtil.putObject(t, offset, UnsafeUtil.getObject(t2, offset));
                    setOneofPresent(t, numberAt, i);
                    return;
                }
                return;
            case 68:
                mergeOneofMessage(t, t2, i);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        return messageInfo instanceof RawMessageInfo ? newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema) : newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int fieldNumber;
        int fieldNumber2;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z = structuralMessageInfo.getSyntax() == ProtoSyntax.PROTO3;
        FieldInfo[] fields = structuralMessageInfo.getFields();
        if (fields.length == 0) {
            fieldNumber = 0;
            fieldNumber2 = 0;
        } else {
            fieldNumber = fields[0].getFieldNumber();
            fieldNumber2 = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        int length2 = fields.length;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            i = i7;
            if (i5 >= length2) {
                break;
            }
            FieldInfo fieldInfo = fields[i5];
            if (fieldInfo.getType() == FieldType.MAP) {
                i3 = i6 + 1;
                i4 = i;
            } else {
                i3 = i6;
                i4 = i;
                if (fieldInfo.getType().id() >= 18) {
                    i3 = i6;
                    i4 = i;
                    if (fieldInfo.getType().id() <= 49) {
                        i4 = i + 1;
                        i3 = i6;
                    }
                }
            }
            i5++;
            i6 = i3;
            i7 = i4;
        }
        int[] iArr2 = null;
        int[] iArr3 = i6 > 0 ? new int[i6] : null;
        if (i > 0) {
            iArr2 = new int[i];
        }
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        int[] iArr4 = checkInitialized;
        if (checkInitialized == null) {
            iArr4 = EMPTY_INT_ARRAY;
        }
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i8 < fields.length) {
            FieldInfo fieldInfo2 = fields[i8];
            int fieldNumber3 = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr, i9, objArr);
            int i13 = i10;
            if (i10 < iArr4.length) {
                i13 = i10;
                if (iArr4[i10] == fieldNumber3) {
                    iArr4[i10] = i9;
                    i13 = i10 + 1;
                }
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr3[i11] = i9;
                i2 = i11 + 1;
            } else {
                i2 = i11;
                if (fieldInfo2.getType().id() >= 18) {
                    i2 = i11;
                    if (fieldInfo2.getType().id() <= 49) {
                        iArr2[i12] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                        i12++;
                        i8++;
                        i9 += 3;
                        i10 = i13;
                    }
                }
            }
            i11 = i2;
            i8++;
            i9 += 3;
            i10 = i13;
        }
        int[] iArr5 = iArr3;
        if (iArr3 == null) {
            iArr5 = EMPTY_INT_ARRAY;
        }
        int[] iArr6 = iArr2;
        if (iArr2 == null) {
            iArr6 = EMPTY_INT_ARRAY;
        }
        int[] iArr7 = new int[iArr4.length + iArr5.length + iArr6.length];
        System.arraycopy(iArr4, 0, iArr7, 0, iArr4.length);
        System.arraycopy(iArr5, 0, iArr7, iArr4.length, iArr5.length);
        System.arraycopy(iArr6, 0, iArr7, iArr4.length + iArr5.length, iArr6.length);
        return new MessageSchema<>(iArr, objArr, fieldNumber, fieldNumber2, structuralMessageInfo.getDefaultInstance(), z, true, iArr7, iArr4.length, iArr4.length + iArr5.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:125:0x06eb  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x06f5  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0727  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0731  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0881  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0887  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0967  */
    /* JADX WARN: Type inference failed for: r0v173, types: [int] */
    /* JADX WARN: Type inference failed for: r0v190, types: [int] */
    /* JADX WARN: Type inference failed for: r0v207, types: [int] */
    /* JADX WARN: Type inference failed for: r0v224, types: [int] */
    /* JADX WARN: Type inference failed for: r0v342, types: [int] */
    /* JADX WARN: Type inference failed for: r0v480, types: [int] */
    /* JADX WARN: Type inference failed for: r0v499, types: [int] */
    /* JADX WARN: Type inference failed for: r0v515, types: [int] */
    /* JADX WARN: Type inference failed for: r0v541, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static <T> com.google.protobuf.MessageSchema<T> newSchemaForRawMessageInfo(com.google.protobuf.RawMessageInfo r18, com.google.protobuf.NewInstanceSchema r19, com.google.protobuf.ListFieldSchema r20, com.google.protobuf.UnknownFieldSchema<?, ?> r21, com.google.protobuf.ExtensionSchema<?> r22, com.google.protobuf.MapFieldSchema r23) {
        /*
            Method dump skipped, instructions count: 2609
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.newSchemaForRawMessageInfo(com.google.protobuf.RawMessageInfo, com.google.protobuf.NewInstanceSchema, com.google.protobuf.ListFieldSchema, com.google.protobuf.UnknownFieldSchema, com.google.protobuf.ExtensionSchema, com.google.protobuf.MapFieldSchema):com.google.protobuf.MessageSchema");
    }

    private int numberAt(int i) {
        return this.buffer[i];
    }

    private static long offset(int i) {
        return i & 1048575;
    }

    private static <T> boolean oneofBooleanAt(T t, long j) {
        return ((Boolean) UnsafeUtil.getObject(t, j)).booleanValue();
    }

    private static <T> double oneofDoubleAt(T t, long j) {
        return ((Double) UnsafeUtil.getObject(t, j)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t, long j) {
        return ((Float) UnsafeUtil.getObject(t, j)).floatValue();
    }

    private static <T> int oneofIntAt(T t, long j) {
        return ((Integer) UnsafeUtil.getObject(t, j)).intValue();
    }

    private static <T> long oneofLongAt(T t, long j) {
        return ((Long) UnsafeUtil.getObject(t, j)).longValue();
    }

    private <K, V> int parseMapField(T t, byte[] bArr, int i, int i2, int i3, long j, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i3);
        Object object = unsafe.getObject(t, j);
        Object obj = object;
        if (this.mapFieldSchema.isImmutable(object)) {
            obj = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(obj, object);
            unsafe.putObject(t, j, obj);
        }
        return decodeMapEntry(bArr, i, i2, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(obj), registers);
    }

    private int parseOneofField(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        long j2 = this.buffer[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(ArrayDecoders.decodeDouble(bArr, i)));
                    unsafe.putInt(t, j2, i4);
                    return i + 8;
                }
                break;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(ArrayDecoders.decodeFloat(bArr, i)));
                    unsafe.putInt(t, j2, i4);
                    return i + 4;
                }
                break;
            case 53:
            case 54:
                if (i5 == 0) {
                    int decodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                    unsafe.putObject(t, j, Long.valueOf(registers.long1));
                    unsafe.putInt(t, j2, i4);
                    return decodeVarint64;
                }
                break;
            case 55:
            case 62:
                if (i5 == 0) {
                    int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                    unsafe.putObject(t, j, Integer.valueOf(registers.int1));
                    unsafe.putInt(t, j2, i4);
                    return decodeVarint32;
                }
                break;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i)));
                    unsafe.putInt(t, j2, i4);
                    return i + 8;
                }
                break;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i)));
                    unsafe.putInt(t, j2, i4);
                    return i + 4;
                }
                break;
            case 58:
                if (i5 == 0) {
                    int decodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                    unsafe.putObject(t, j, Boolean.valueOf(registers.long1 != 0));
                    unsafe.putInt(t, j2, i4);
                    return decodeVarint642;
                }
                break;
            case 59:
                if (i5 == 2) {
                    int decodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                    int i9 = registers.int1;
                    if (i9 == 0) {
                        unsafe.putObject(t, j, "");
                    } else if ((i6 & 536870912) != 0 && !Utf8.isValidUtf8(bArr, decodeVarint322, decodeVarint322 + i9)) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    } else {
                        unsafe.putObject(t, j, new String(bArr, decodeVarint322, i9, Internal.UTF_8));
                        decodeVarint322 += i9;
                    }
                    unsafe.putInt(t, j2, i4);
                    return decodeVarint322;
                }
                break;
            case 60:
                if (i5 == 2) {
                    int decodeMessageField = ArrayDecoders.decodeMessageField(getMessageFieldSchema(i8), bArr, i, i2, registers);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, registers.object1);
                    } else {
                        unsafe.putObject(t, j, Internal.mergeMessage(object, registers.object1));
                    }
                    unsafe.putInt(t, j2, i4);
                    return decodeMessageField;
                }
                break;
            case 61:
                if (i5 == 2) {
                    int decodeBytes = ArrayDecoders.decodeBytes(bArr, i, registers);
                    unsafe.putObject(t, j, registers.object1);
                    unsafe.putInt(t, j2, i4);
                    return decodeBytes;
                }
                break;
            case 63:
                if (i5 == 0) {
                    int decodeVarint323 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                    int i10 = registers.int1;
                    Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i8);
                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i10)) {
                        unsafe.putObject(t, j, Integer.valueOf(i10));
                        unsafe.putInt(t, j2, i4);
                    } else {
                        getMutableUnknownFields(t).storeField(i3, Long.valueOf(i10));
                    }
                    return decodeVarint323;
                }
                break;
            case 66:
                if (i5 == 0) {
                    int decodeVarint324 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                    unsafe.putObject(t, j, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1)));
                    unsafe.putInt(t, j2, i4);
                    return decodeVarint324;
                }
                break;
            case 67:
                if (i5 == 0) {
                    int decodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                    unsafe.putObject(t, j, Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1)));
                    unsafe.putInt(t, j2, i4);
                    return decodeVarint643;
                }
                break;
            case 68:
                if (i5 == 3) {
                    int decodeGroupField = ArrayDecoders.decodeGroupField(getMessageFieldSchema(i8), bArr, i, i2, (i3 & (-8)) | 4, registers);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, registers.object1);
                    } else {
                        unsafe.putObject(t, j, Internal.mergeMessage(object2, registers.object1));
                    }
                    unsafe.putInt(t, j2, i4);
                    return decodeGroupField;
                }
                break;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x0495, code lost:
        if (r24 != r0) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x04c2, code lost:
        if (r24 != r0) goto L148;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v200, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int parseProto3Message(T r17, byte[] r18, int r19, int r20, com.google.protobuf.ArrayDecoders.Registers r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.parseProto3Message(java.lang.Object, byte[], int, int, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    private int parseRepeatedField(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, ArrayDecoders.Registers registers) throws IOException {
        int decodeVarint32List;
        Internal.ProtobufList protobufList = (Internal.ProtobufList) UNSAFE.getObject(t, j2);
        Internal.ProtobufList protobufList2 = protobufList;
        if (!protobufList.isModifiable()) {
            int size = protobufList.size();
            protobufList2 = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            UNSAFE.putObject(t, j2, protobufList2);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedDoubleList(bArr, i, protobufList2, registers);
                }
                if (i5 == 1) {
                    return ArrayDecoders.decodeDoubleList(i3, bArr, i, i2, protobufList2, registers);
                }
                break;
            case 19:
            case 36:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFloatList(bArr, i, protobufList2, registers);
                }
                if (i5 == 5) {
                    return ArrayDecoders.decodeFloatList(i3, bArr, i, i2, protobufList2, registers);
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedVarint64List(bArr, i, protobufList2, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeVarint64List(i3, bArr, i, i2, protobufList2, registers);
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedVarint32List(bArr, i, protobufList2, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeVarint32List(i3, bArr, i, i2, protobufList2, registers);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFixed64List(bArr, i, protobufList2, registers);
                }
                if (i5 == 1) {
                    return ArrayDecoders.decodeFixed64List(i3, bArr, i, i2, protobufList2, registers);
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFixed32List(bArr, i, protobufList2, registers);
                }
                if (i5 == 5) {
                    return ArrayDecoders.decodeFixed32List(i3, bArr, i, i2, protobufList2, registers);
                }
                break;
            case 25:
            case 42:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedBoolList(bArr, i, protobufList2, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeBoolList(i3, bArr, i, i2, protobufList2, registers);
                }
                break;
            case 26:
                if (i5 == 2) {
                    return (j & 536870912) == 0 ? ArrayDecoders.decodeStringList(i3, bArr, i, i2, protobufList2, registers) : ArrayDecoders.decodeStringListRequireUtf8(i3, bArr, i, i2, protobufList2, registers);
                }
                break;
            case 27:
                if (i5 == 2) {
                    return ArrayDecoders.decodeMessageList(getMessageFieldSchema(i6), i3, bArr, i, i2, protobufList2, registers);
                }
                break;
            case 28:
                if (i5 == 2) {
                    return ArrayDecoders.decodeBytesList(i3, bArr, i, i2, protobufList2, registers);
                }
                break;
            case 30:
            case 44:
                if (i5 == 2) {
                    decodeVarint32List = ArrayDecoders.decodePackedVarint32List(bArr, i, protobufList2, registers);
                } else if (i5 == 0) {
                    decodeVarint32List = ArrayDecoders.decodeVarint32List(i3, bArr, i, i2, protobufList2, registers);
                }
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t;
                UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
                UnknownFieldSetLite unknownFieldSetLite2 = unknownFieldSetLite;
                if (unknownFieldSetLite == UnknownFieldSetLite.getDefaultInstance()) {
                    unknownFieldSetLite2 = null;
                }
                UnknownFieldSetLite unknownFieldSetLite3 = (UnknownFieldSetLite) SchemaUtil.filterUnknownEnumList(i4, (List<Integer>) protobufList2, getEnumFieldVerifier(i6), unknownFieldSetLite2, (UnknownFieldSchema<UT, UnknownFieldSetLite>) this.unknownFieldSchema);
                if (unknownFieldSetLite3 != null) {
                    generatedMessageLite.unknownFields = unknownFieldSetLite3;
                }
                return decodeVarint32List;
            case 33:
            case 47:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedSInt32List(bArr, i, protobufList2, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeSInt32List(i3, bArr, i, i2, protobufList2, registers);
                }
                break;
            case 34:
            case 48:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedSInt64List(bArr, i, protobufList2, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeSInt64List(i3, bArr, i, i2, protobufList2, registers);
                }
                break;
            case 49:
                if (i5 == 3) {
                    return ArrayDecoders.decodeGroupList(getMessageFieldSchema(i6), i3, bArr, i, i2, protobufList2, registers);
                }
                break;
        }
        return i;
    }

    private int positionForFieldNumber(int i) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, 0);
    }

    private int positionForFieldNumber(int i, int i2) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, i2);
    }

    private int presenceMaskAndOffsetAt(int i) {
        return this.buffer[i + 2];
    }

    private <E> void readGroupList(Object obj, long j, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j), schema, extensionRegistryLite);
    }

    private <E> void readMessageList(Object obj, int i, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i)), schema, extensionRegistryLite);
    }

    private void readString(Object obj, int i, Reader reader) throws IOException {
        if (isEnforceUtf8(i)) {
            UnsafeUtil.putObject(obj, offset(i), reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(obj, offset(i), reader.readString());
        } else {
            UnsafeUtil.putObject(obj, offset(i), reader.readBytes());
        }
    }

    private void readStringList(Object obj, int i, Reader reader) throws IOException {
        if (isEnforceUtf8(i)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, offset(i)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(obj, offset(i)));
        }
    }

    private static java.lang.reflect.Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
            int length = declaredFields.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
                }
                java.lang.reflect.Field field = declaredFields[i2];
                if (str.equals(field.getName())) {
                    return field;
                }
                i = i2 + 1;
            }
        }
    }

    private void setFieldPresent(T t, int i) {
        int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        long j = 1048575 & presenceMaskAndOffsetAt;
        if (j == 1048575) {
            return;
        }
        UnsafeUtil.putInt(t, j, (1 << (presenceMaskAndOffsetAt >>> 20)) | UnsafeUtil.getInt(t, j));
    }

    private void setOneofPresent(T t, int i, int i2) {
        UnsafeUtil.putInt(t, presenceMaskAndOffsetAt(i2) & 1048575, i);
    }

    private int slowPositionForFieldNumber(int i, int i2) {
        int length = (this.buffer.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int numberAt = numberAt(i4);
            if (i == numberAt) {
                return i4;
            }
            if (i < numberAt) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void storeFieldData(com.google.protobuf.FieldInfo r6, int[] r7, int r8, java.lang.Object[] r9) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.storeFieldData(com.google.protobuf.FieldInfo, int[], int, java.lang.Object[]):void");
    }

    private static int type(int i) {
        return (i & FIELD_TYPE_MASK) >>> 20;
    }

    private int typeAndOffsetAt(int i) {
        return this.buffer[i + 1];
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x096f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void writeFieldsInAscendingOrderProto2(T r9, com.google.protobuf.Writer r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2472
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.writeFieldsInAscendingOrderProto2(java.lang.Object, com.google.protobuf.Writer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x094d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void writeFieldsInAscendingOrderProto3(T r8, com.google.protobuf.Writer r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.writeFieldsInAscendingOrderProto3(java.lang.Object, com.google.protobuf.Writer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0951 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void writeFieldsInDescendingOrder(T r8, com.google.protobuf.Writer r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2432
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.writeFieldsInDescendingOrder(java.lang.Object, com.google.protobuf.Writer):void");
    }

    private <K, V> void writeMapHelper(Writer writer, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            writer.writeMap(i, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private void writeString(int i, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.writeString(i, (String) obj);
        } else {
            writer.writeBytes(i, (ByteString) obj);
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t, Writer writer) throws IOException {
        unknownFieldSchema.writeTo(unknownFieldSchema.getFromMessage(t), writer);
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T t, T t2) {
        int length = this.buffer.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                if (this.unknownFieldSchema.getFromMessage(t).equals(this.unknownFieldSchema.getFromMessage(t2))) {
                    if (this.hasExtensions) {
                        return this.extensionSchema.getExtensions(t).equals(this.extensionSchema.getExtensions(t2));
                    }
                    return true;
                }
                return false;
            } else if (!equals(t, t2, i2)) {
                return false;
            } else {
                i = i2 + 3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSchemaSize() {
        return this.buffer.length * 3;
    }

    @Override // com.google.protobuf.Schema
    public int getSerializedSize(T t) {
        return this.proto3 ? getSerializedSizeProto3(t) : getSerializedSizeProto2(t);
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T t) {
        int i;
        int hashLong;
        int i2;
        int length = this.buffer.length;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i3 >= length) {
                int hashCode = (i5 * 53) + this.unknownFieldSchema.getFromMessage(t).hashCode();
                int i6 = hashCode;
                if (this.hasExtensions) {
                    i6 = (hashCode * 53) + this.extensionSchema.getExtensions(t).hashCode();
                }
                return i6;
            }
            int typeAndOffsetAt = typeAndOffsetAt(i3);
            int numberAt = numberAt(i3);
            long offset = offset(typeAndOffsetAt);
            int i7 = 37;
            switch (type(typeAndOffsetAt)) {
                case 0:
                    i = i5 * 53;
                    hashLong = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(t, offset)));
                    i2 = i + hashLong;
                    break;
                case 1:
                    i = i5 * 53;
                    hashLong = Float.floatToIntBits(UnsafeUtil.getFloat(t, offset));
                    i2 = i + hashLong;
                    break;
                case 2:
                    i = i5 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.getLong(t, offset));
                    i2 = i + hashLong;
                    break;
                case 3:
                    i = i5 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.getLong(t, offset));
                    i2 = i + hashLong;
                    break;
                case 4:
                    i = i5 * 53;
                    hashLong = UnsafeUtil.getInt(t, offset);
                    i2 = i + hashLong;
                    break;
                case 5:
                    i = i5 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.getLong(t, offset));
                    i2 = i + hashLong;
                    break;
                case 6:
                    i = i5 * 53;
                    hashLong = UnsafeUtil.getInt(t, offset);
                    i2 = i + hashLong;
                    break;
                case 7:
                    i = i5 * 53;
                    hashLong = Internal.hashBoolean(UnsafeUtil.getBoolean(t, offset));
                    i2 = i + hashLong;
                    break;
                case 8:
                    i = i5 * 53;
                    hashLong = ((String) UnsafeUtil.getObject(t, offset)).hashCode();
                    i2 = i + hashLong;
                    break;
                case 9:
                    Object object = UnsafeUtil.getObject(t, offset);
                    if (object != null) {
                        i7 = object.hashCode();
                    }
                    i2 = (i5 * 53) + i7;
                    break;
                case 10:
                    i = i5 * 53;
                    hashLong = UnsafeUtil.getObject(t, offset).hashCode();
                    i2 = i + hashLong;
                    break;
                case 11:
                    i = i5 * 53;
                    hashLong = UnsafeUtil.getInt(t, offset);
                    i2 = i + hashLong;
                    break;
                case 12:
                    i = i5 * 53;
                    hashLong = UnsafeUtil.getInt(t, offset);
                    i2 = i + hashLong;
                    break;
                case 13:
                    i = i5 * 53;
                    hashLong = UnsafeUtil.getInt(t, offset);
                    i2 = i + hashLong;
                    break;
                case 14:
                    i = i5 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.getLong(t, offset));
                    i2 = i + hashLong;
                    break;
                case 15:
                    i = i5 * 53;
                    hashLong = UnsafeUtil.getInt(t, offset);
                    i2 = i + hashLong;
                    break;
                case 16:
                    i = i5 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.getLong(t, offset));
                    i2 = i + hashLong;
                    break;
                case 17:
                    Object object2 = UnsafeUtil.getObject(t, offset);
                    if (object2 != null) {
                        i7 = object2.hashCode();
                    }
                    i2 = (i5 * 53) + i7;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i5 * 53;
                    hashLong = UnsafeUtil.getObject(t, offset).hashCode();
                    i2 = i + hashLong;
                    break;
                case 50:
                    i = i5 * 53;
                    hashLong = UnsafeUtil.getObject(t, offset).hashCode();
                    i2 = i + hashLong;
                    break;
                case 51:
                    i2 = i5;
                    if (!isOneofPresent(t, numberAt, i3)) {
                        break;
                    } else {
                        i = i5 * 53;
                        hashLong = Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(t, offset)));
                        i2 = i + hashLong;
                        break;
                    }
                case 52:
                    i2 = i5;
                    if (!isOneofPresent(t, numberAt, i3)) {
                        break;
                    } else {
                        i = i5 * 53;
                        hashLong = Float.floatToIntBits(oneofFloatAt(t, offset));
                        i2 = i + hashLong;
                        break;
                    }
                case 53:
                    i2 = i5;
                    if (!isOneofPresent(t, numberAt, i3)) {
                        break;
                    } else {
                        i = i5 * 53;
                        hashLong = Internal.hashLong(oneofLongAt(t, offset));
                        i2 = i + hashLong;
                        break;
                    }
                case 54:
                    i2 = i5;
                    if (!isOneofPresent(t, numberAt, i3)) {
                        break;
                    } else {
                        i = i5 * 53;
                        hashLong = Internal.hashLong(oneofLongAt(t, offset));
                        i2 = i + hashLong;
                        break;
                    }
                case 55:
                    i2 = i5;
                    if (!isOneofPresent(t, numberAt, i3)) {
                        break;
                    } else {
                        i = i5 * 53;
                        hashLong = oneofIntAt(t, offset);
                        i2 = i + hashLong;
                        break;
                    }
                case 56:
                    i2 = i5;
                    if (!isOneofPresent(t, numberAt, i3)) {
                        break;
                    } else {
                        i = i5 * 53;
                        hashLong = Internal.hashLong(oneofLongAt(t, offset));
                        i2 = i + hashLong;
                        break;
                    }
                case 57:
                    i2 = i5;
                    if (!isOneofPresent(t, numberAt, i3)) {
                        break;
                    } else {
                        i = i5 * 53;
                        hashLong = oneofIntAt(t, offset);
                        i2 = i + hashLong;
                        break;
                    }
                case 58:
                    i2 = i5;
                    if (!isOneofPresent(t, numberAt, i3)) {
                        break;
                    } else {
                        i = i5 * 53;
                        hashLong = Internal.hashBoolean(oneofBooleanAt(t, offset));
                        i2 = i + hashLong;
                        break;
                    }
                case 59:
                    i2 = i5;
                    if (!isOneofPresent(t, numberAt, i3)) {
                        break;
                    } else {
                        i = i5 * 53;
                        hashLong = ((String) UnsafeUtil.getObject(t, offset)).hashCode();
                        i2 = i + hashLong;
                        break;
                    }
                case 60:
                    i2 = i5;
                    if (!isOneofPresent(t, numberAt, i3)) {
                        break;
                    } else {
                        i = i5 * 53;
                        hashLong = UnsafeUtil.getObject(t, offset).hashCode();
                        i2 = i + hashLong;
                        break;
                    }
                case 61:
                    i2 = i5;
                    if (!isOneofPresent(t, numberAt, i3)) {
                        break;
                    } else {
                        i = i5 * 53;
                        hashLong = UnsafeUtil.getObject(t, offset).hashCode();
                        i2 = i + hashLong;
                        break;
                    }
                case 62:
                    i2 = i5;
                    if (!isOneofPresent(t, numberAt, i3)) {
                        break;
                    } else {
                        i = i5 * 53;
                        hashLong = oneofIntAt(t, offset);
                        i2 = i + hashLong;
                        break;
                    }
                case 63:
                    i2 = i5;
                    if (!isOneofPresent(t, numberAt, i3)) {
                        break;
                    } else {
                        i = i5 * 53;
                        hashLong = oneofIntAt(t, offset);
                        i2 = i + hashLong;
                        break;
                    }
                case 64:
                    i2 = i5;
                    if (!isOneofPresent(t, numberAt, i3)) {
                        break;
                    } else {
                        i = i5 * 53;
                        hashLong = oneofIntAt(t, offset);
                        i2 = i + hashLong;
                        break;
                    }
                case 65:
                    i2 = i5;
                    if (!isOneofPresent(t, numberAt, i3)) {
                        break;
                    } else {
                        i = i5 * 53;
                        hashLong = Internal.hashLong(oneofLongAt(t, offset));
                        i2 = i + hashLong;
                        break;
                    }
                case 66:
                    i2 = i5;
                    if (!isOneofPresent(t, numberAt, i3)) {
                        break;
                    } else {
                        i = i5 * 53;
                        hashLong = oneofIntAt(t, offset);
                        i2 = i + hashLong;
                        break;
                    }
                case 67:
                    i2 = i5;
                    if (!isOneofPresent(t, numberAt, i3)) {
                        break;
                    } else {
                        i = i5 * 53;
                        hashLong = Internal.hashLong(oneofLongAt(t, offset));
                        i2 = i + hashLong;
                        break;
                    }
                case 68:
                    i2 = i5;
                    if (!isOneofPresent(t, numberAt, i3)) {
                        break;
                    } else {
                        i = i5 * 53;
                        hashLong = UnsafeUtil.getObject(t, offset).hashCode();
                        i2 = i + hashLong;
                        break;
                    }
                default:
                    i2 = i5;
                    break;
            }
            i3 += 3;
            i4 = i2;
        }
    }

    @Override // com.google.protobuf.Schema
    public final boolean isInitialized(T t) {
        int i = 1048575;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.checkInitializedCount) {
                return !this.hasExtensions || this.extensionSchema.getExtensions(t).isInitialized();
            }
            int i5 = this.intArray[i4];
            int numberAt = numberAt(i5);
            int typeAndOffsetAt = typeAndOffsetAt(i5);
            int i6 = this.buffer[i5 + 2];
            int i7 = i6 & 1048575;
            int i8 = 1 << (i6 >>> 20);
            if (i7 != i) {
                if (i7 != 1048575) {
                    i2 = UNSAFE.getInt(t, i7);
                }
                i = i7;
            }
            if (isRequired(typeAndOffsetAt) && !isFieldPresent(t, i5, i, i2, i8)) {
                return false;
            }
            int type = type(typeAndOffsetAt);
            if (type != 9 && type != 17) {
                if (type != 27) {
                    if (type == 60 || type == 68) {
                        if (isOneofPresent(t, numberAt, i5) && !isInitialized(t, typeAndOffsetAt, getMessageFieldSchema(i5))) {
                            return false;
                        }
                    } else if (type != 49) {
                        if (type == 50 && !isMapInitialized(t, typeAndOffsetAt, i5)) {
                            return false;
                        }
                    }
                }
                if (!isListInitialized(t, typeAndOffsetAt, i5)) {
                    return false;
                }
            } else if (isFieldPresent(t, i5, i, i2, i8) && !isInitialized(t, typeAndOffsetAt, getMessageFieldSchema(i5))) {
                return false;
            }
            i3 = i4 + 1;
        }
    }

    @Override // com.google.protobuf.Schema
    public void makeImmutable(T t) {
        int i;
        int i2 = this.checkInitializedCount;
        while (true) {
            int i3 = i2;
            i = this.repeatedFieldOffsetStart;
            if (i3 >= i) {
                break;
            }
            long offset = offset(typeAndOffsetAt(this.intArray[i3]));
            Object object = UnsafeUtil.getObject(t, offset);
            if (object != null) {
                UnsafeUtil.putObject(t, offset, this.mapFieldSchema.toImmutable(object));
            }
            i2 = i3 + 1;
        }
        int length = this.intArray.length;
        int i4 = i;
        while (true) {
            int i5 = i4;
            if (i5 >= length) {
                break;
            }
            this.listFieldSchema.makeImmutableListAt(t, this.intArray[i5]);
            i4 = i5 + 1;
        }
        this.unknownFieldSchema.makeImmutable(t);
        if (this.hasExtensions) {
            this.extensionSchema.makeImmutable(t);
        }
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        if (extensionRegistryLite == null) {
            throw null;
        }
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t, reader, extensionRegistryLite);
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t, T t2) {
        if (t2 == null) {
            throw null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.buffer.length) {
                break;
            }
            mergeSingleField(t, t2, i2);
            i = i2 + 3;
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t, t2);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t, t2);
        }
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers) throws IOException {
        if (this.proto3) {
            parseProto3Message(t, bArr, i, i2, registers);
        } else {
            parseProto2Message(t, bArr, i, i2, 0, registers);
        }
    }

    @Override // com.google.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int parseProto2Message(T t, byte[] bArr, int i, int i2, int i3, ArrayDecoders.Registers registers) throws IOException {
        MessageSchema<T> messageSchema;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int decodeVarint64;
        int i12;
        int i13;
        int i14;
        int i15;
        T t2 = t;
        int i16 = i2;
        int i17 = i3;
        Unsafe unsafe = UNSAFE;
        int i18 = -1;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 1048575;
        while (true) {
            if (i < i16) {
                int i23 = i + 1;
                int i24 = bArr[i];
                if (i24 < 0) {
                    i23 = ArrayDecoders.decodeVarint32(i24, bArr, i23, registers);
                    i24 = registers.int1;
                }
                int i25 = i24 >>> 3;
                int i26 = i24 & 7;
                int positionForFieldNumber = i25 > i18 ? positionForFieldNumber(i25, i19 / 3) : positionForFieldNumber(i25);
                if (positionForFieldNumber == -1) {
                    int i27 = i24;
                    i5 = i21;
                    i6 = i17;
                    i7 = i23;
                    i8 = i27;
                    i9 = 0;
                } else {
                    int i28 = this.buffer[positionForFieldNumber + 1];
                    int type = type(i28);
                    long offset = offset(i28);
                    if (type <= 17) {
                        int i29 = this.buffer[positionForFieldNumber + 2];
                        int i30 = 1 << (i29 >>> 20);
                        int i31 = i29 & 1048575;
                        if (i31 != i22) {
                            if (i22 != 1048575) {
                                unsafe.putInt(t2, i22, i21);
                            }
                            i22 = i31;
                            i10 = unsafe.getInt(t2, i31);
                        } else {
                            i10 = i21;
                        }
                        switch (type) {
                            case 0:
                                if (i26 != 1) {
                                    int i32 = i10;
                                    i8 = i24;
                                    i6 = i3;
                                    i7 = i23;
                                    i9 = positionForFieldNumber;
                                    i5 = i32;
                                    break;
                                } else {
                                    UnsafeUtil.putDouble(t2, offset, ArrayDecoders.decodeDouble(bArr, i23));
                                    i11 = i23 + 8;
                                    i10 |= i30;
                                    int i33 = i24;
                                    i14 = i25;
                                    i12 = positionForFieldNumber;
                                    i20 = i33;
                                    i18 = i14;
                                    i = i11;
                                    i19 = i12;
                                    i21 = i10;
                                    i17 = i3;
                                    i16 = i2;
                                    break;
                                }
                            case 1:
                                if (i26 != 5) {
                                    int i322 = i10;
                                    i8 = i24;
                                    i6 = i3;
                                    i7 = i23;
                                    i9 = positionForFieldNumber;
                                    i5 = i322;
                                    break;
                                } else {
                                    UnsafeUtil.putFloat(t2, offset, ArrayDecoders.decodeFloat(bArr, i23));
                                    i11 = i23 + 4;
                                    i10 |= i30;
                                    int i332 = i24;
                                    i14 = i25;
                                    i12 = positionForFieldNumber;
                                    i20 = i332;
                                    i18 = i14;
                                    i = i11;
                                    i19 = i12;
                                    i21 = i10;
                                    i17 = i3;
                                    i16 = i2;
                                    break;
                                }
                            case 2:
                            case 3:
                                if (i26 != 0) {
                                    int i3222 = i10;
                                    i8 = i24;
                                    i6 = i3;
                                    i7 = i23;
                                    i9 = positionForFieldNumber;
                                    i5 = i3222;
                                    break;
                                } else {
                                    decodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i23, registers);
                                    unsafe.putLong(t, offset, registers.long1);
                                    i10 |= i30;
                                    int i34 = i24;
                                    i = decodeVarint64;
                                    i18 = i25;
                                    i12 = positionForFieldNumber;
                                    i20 = i34;
                                    i19 = i12;
                                    i21 = i10;
                                    i17 = i3;
                                    i16 = i2;
                                    break;
                                }
                            case 4:
                            case 11:
                                if (i26 != 0) {
                                    int i32222 = i10;
                                    i8 = i24;
                                    i6 = i3;
                                    i7 = i23;
                                    i9 = positionForFieldNumber;
                                    i5 = i32222;
                                    break;
                                } else {
                                    i11 = ArrayDecoders.decodeVarint32(bArr, i23, registers);
                                    unsafe.putInt(t2, offset, registers.int1);
                                    i10 |= i30;
                                    int i3322 = i24;
                                    i14 = i25;
                                    i12 = positionForFieldNumber;
                                    i20 = i3322;
                                    i18 = i14;
                                    i = i11;
                                    i19 = i12;
                                    i21 = i10;
                                    i17 = i3;
                                    i16 = i2;
                                    break;
                                }
                            case 5:
                            case 14:
                                if (i26 != 1) {
                                    int i322222 = i10;
                                    i8 = i24;
                                    i6 = i3;
                                    i7 = i23;
                                    i9 = positionForFieldNumber;
                                    i5 = i322222;
                                    break;
                                } else {
                                    unsafe.putLong(t, offset, ArrayDecoders.decodeFixed64(bArr, i23));
                                    decodeVarint64 = i23 + 8;
                                    i10 |= i30;
                                    int i342 = i24;
                                    i = decodeVarint64;
                                    i18 = i25;
                                    i12 = positionForFieldNumber;
                                    i20 = i342;
                                    i19 = i12;
                                    i21 = i10;
                                    i17 = i3;
                                    i16 = i2;
                                    break;
                                }
                            case 6:
                            case 13:
                                if (i26 != 5) {
                                    int i3222222 = i10;
                                    i8 = i24;
                                    i6 = i3;
                                    i7 = i23;
                                    i9 = positionForFieldNumber;
                                    i5 = i3222222;
                                    break;
                                } else {
                                    unsafe.putInt(t2, offset, ArrayDecoders.decodeFixed32(bArr, i23));
                                    i13 = i23 + 4;
                                    int i35 = i24;
                                    i = i13;
                                    i18 = i25;
                                    i19 = positionForFieldNumber;
                                    i20 = i35;
                                    i21 = i10 | i30;
                                    i17 = i3;
                                    i16 = i2;
                                    break;
                                }
                            case 7:
                                if (i26 != 0) {
                                    int i32222222 = i10;
                                    i8 = i24;
                                    i6 = i3;
                                    i7 = i23;
                                    i9 = positionForFieldNumber;
                                    i5 = i32222222;
                                    break;
                                } else {
                                    i13 = ArrayDecoders.decodeVarint64(bArr, i23, registers);
                                    UnsafeUtil.putBoolean(t2, offset, registers.long1 != 0);
                                    int i352 = i24;
                                    i = i13;
                                    i18 = i25;
                                    i19 = positionForFieldNumber;
                                    i20 = i352;
                                    i21 = i10 | i30;
                                    i17 = i3;
                                    i16 = i2;
                                    break;
                                }
                            case 8:
                                if (i26 != 2) {
                                    int i322222222 = i10;
                                    i8 = i24;
                                    i6 = i3;
                                    i7 = i23;
                                    i9 = positionForFieldNumber;
                                    i5 = i322222222;
                                    break;
                                } else {
                                    i13 = (i28 & 536870912) == 0 ? ArrayDecoders.decodeString(bArr, i23, registers) : ArrayDecoders.decodeStringRequireUtf8(bArr, i23, registers);
                                    unsafe.putObject(t2, offset, registers.object1);
                                    int i3522 = i24;
                                    i = i13;
                                    i18 = i25;
                                    i19 = positionForFieldNumber;
                                    i20 = i3522;
                                    i21 = i10 | i30;
                                    i17 = i3;
                                    i16 = i2;
                                    break;
                                }
                            case 9:
                                T t3 = t2;
                                if (i26 != 2) {
                                    int i3222222222 = i10;
                                    i8 = i24;
                                    i6 = i3;
                                    i7 = i23;
                                    i9 = positionForFieldNumber;
                                    i5 = i3222222222;
                                    break;
                                } else {
                                    i13 = ArrayDecoders.decodeMessageField(getMessageFieldSchema(positionForFieldNumber), bArr, i23, i2, registers);
                                    if ((i10 & i30) == 0) {
                                        unsafe.putObject(t3, offset, registers.object1);
                                    } else {
                                        unsafe.putObject(t3, offset, Internal.mergeMessage(unsafe.getObject(t3, offset), registers.object1));
                                    }
                                    int i35222 = i24;
                                    i = i13;
                                    i18 = i25;
                                    i19 = positionForFieldNumber;
                                    i20 = i35222;
                                    i21 = i10 | i30;
                                    i17 = i3;
                                    i16 = i2;
                                    break;
                                }
                            case 10:
                                if (i26 != 2) {
                                    int i32222222222 = i10;
                                    i8 = i24;
                                    i6 = i3;
                                    i7 = i23;
                                    i9 = positionForFieldNumber;
                                    i5 = i32222222222;
                                    break;
                                } else {
                                    i11 = ArrayDecoders.decodeBytes(bArr, i23, registers);
                                    unsafe.putObject(t2, offset, registers.object1);
                                    i10 |= i30;
                                    int i33222 = i24;
                                    i14 = i25;
                                    i12 = positionForFieldNumber;
                                    i20 = i33222;
                                    i18 = i14;
                                    i = i11;
                                    i19 = i12;
                                    i21 = i10;
                                    i17 = i3;
                                    i16 = i2;
                                    break;
                                }
                            case 12:
                                if (i26 != 0) {
                                    int i322222222222 = i10;
                                    i8 = i24;
                                    i6 = i3;
                                    i7 = i23;
                                    i9 = positionForFieldNumber;
                                    i5 = i322222222222;
                                    break;
                                } else {
                                    i11 = ArrayDecoders.decodeVarint32(bArr, i23, registers);
                                    int i36 = registers.int1;
                                    Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(positionForFieldNumber);
                                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i36)) {
                                        unsafe.putInt(t2, offset, i36);
                                        i10 |= i30;
                                        int i332222 = i24;
                                        i14 = i25;
                                        i12 = positionForFieldNumber;
                                        i20 = i332222;
                                        i18 = i14;
                                        i = i11;
                                        i19 = i12;
                                        i21 = i10;
                                        i17 = i3;
                                        i16 = i2;
                                        break;
                                    } else {
                                        getMutableUnknownFields(t).storeField(i24, Long.valueOf(i36));
                                        int i3322222 = i24;
                                        i14 = i25;
                                        i12 = positionForFieldNumber;
                                        i20 = i3322222;
                                        i18 = i14;
                                        i = i11;
                                        i19 = i12;
                                        i21 = i10;
                                        i17 = i3;
                                        i16 = i2;
                                    }
                                }
                                break;
                            case 15:
                                if (i26 != 0) {
                                    int i3222222222222 = i10;
                                    i8 = i24;
                                    i6 = i3;
                                    i7 = i23;
                                    i9 = positionForFieldNumber;
                                    i5 = i3222222222222;
                                    break;
                                } else {
                                    i11 = ArrayDecoders.decodeVarint32(bArr, i23, registers);
                                    t2 = t;
                                    unsafe.putInt(t2, offset, CodedInputStream.decodeZigZag32(registers.int1));
                                    i10 |= i30;
                                    int i33222222 = i24;
                                    i14 = i25;
                                    i12 = positionForFieldNumber;
                                    i20 = i33222222;
                                    i18 = i14;
                                    i = i11;
                                    i19 = i12;
                                    i21 = i10;
                                    i17 = i3;
                                    i16 = i2;
                                    break;
                                }
                            case 16:
                                if (i26 != 0) {
                                    int i32222222222222 = i10;
                                    i8 = i24;
                                    i6 = i3;
                                    i7 = i23;
                                    i9 = positionForFieldNumber;
                                    i5 = i32222222222222;
                                    break;
                                } else {
                                    i11 = ArrayDecoders.decodeVarint64(bArr, i23, registers);
                                    unsafe.putLong(t, offset, CodedInputStream.decodeZigZag64(registers.long1));
                                    i10 |= i30;
                                    t2 = t;
                                    int i332222222 = i24;
                                    i14 = i25;
                                    i12 = positionForFieldNumber;
                                    i20 = i332222222;
                                    i18 = i14;
                                    i = i11;
                                    i19 = i12;
                                    i21 = i10;
                                    i17 = i3;
                                    i16 = i2;
                                    break;
                                }
                            case 17:
                                if (i26 != 3) {
                                    int i322222222222222 = i10;
                                    i8 = i24;
                                    i6 = i3;
                                    i7 = i23;
                                    i9 = positionForFieldNumber;
                                    i5 = i322222222222222;
                                    break;
                                } else {
                                    int decodeGroupField = ArrayDecoders.decodeGroupField(getMessageFieldSchema(positionForFieldNumber), bArr, i23, i2, (i25 << 3) | 4, registers);
                                    if ((i10 & i30) == 0) {
                                        unsafe.putObject(t2, offset, registers.object1);
                                    } else {
                                        unsafe.putObject(t2, offset, Internal.mergeMessage(unsafe.getObject(t2, offset), registers.object1));
                                    }
                                    int i37 = i10 | i30;
                                    i17 = i3;
                                    int i38 = i24;
                                    i = decodeGroupField;
                                    i18 = i25;
                                    i19 = positionForFieldNumber;
                                    i20 = i38;
                                    i21 = i37;
                                    i16 = i2;
                                    break;
                                }
                            default:
                                int i3222222222222222 = i10;
                                i8 = i24;
                                i6 = i3;
                                i7 = i23;
                                i9 = positionForFieldNumber;
                                i5 = i3222222222222222;
                                break;
                        }
                    } else {
                        i18 = i25;
                        if (type != 27) {
                            i19 = positionForFieldNumber;
                            if (type <= 49) {
                                int parseRepeatedField = parseRepeatedField(t, bArr, i23, i2, i24, i18, i26, i19, i28, type, offset, registers);
                                i7 = parseRepeatedField;
                                if (parseRepeatedField != i23) {
                                    i15 = parseRepeatedField;
                                    int i39 = i15;
                                    t2 = t;
                                    i16 = i2;
                                    i17 = i3;
                                    int i40 = i24;
                                    i = i39;
                                    i20 = i40;
                                } else {
                                    int i41 = i21;
                                    int i42 = i24;
                                    i6 = i3;
                                    i8 = i42;
                                    i9 = positionForFieldNumber;
                                    i5 = i41;
                                }
                            } else {
                                int i43 = i23;
                                if (type != 50) {
                                    int parseOneofField = parseOneofField(t, bArr, i43, i2, i24, i18, i26, i28, type, offset, i19, registers);
                                    i7 = parseOneofField;
                                    if (parseOneofField != i43) {
                                        i15 = parseOneofField;
                                        int i392 = i15;
                                        t2 = t;
                                        i16 = i2;
                                        i17 = i3;
                                        int i402 = i24;
                                        i = i392;
                                        i20 = i402;
                                    } else {
                                        int i412 = i21;
                                        int i422 = i24;
                                        i6 = i3;
                                        i8 = i422;
                                        i9 = positionForFieldNumber;
                                        i5 = i412;
                                    }
                                } else if (i26 == 2) {
                                    int parseMapField = parseMapField(t, bArr, i43, i2, i19, offset, registers);
                                    i7 = parseMapField;
                                    if (parseMapField != i43) {
                                        i15 = parseMapField;
                                        int i3922 = i15;
                                        t2 = t;
                                        i16 = i2;
                                        i17 = i3;
                                        int i4022 = i24;
                                        i = i3922;
                                        i20 = i4022;
                                    } else {
                                        int i4122 = i21;
                                        int i4222 = i24;
                                        i6 = i3;
                                        i8 = i4222;
                                        i9 = positionForFieldNumber;
                                        i5 = i4122;
                                    }
                                }
                            }
                        } else if (i26 == 2) {
                            Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe.getObject(t2, offset);
                            Internal.ProtobufList protobufList2 = protobufList;
                            if (!protobufList.isModifiable()) {
                                int size = protobufList.size();
                                protobufList2 = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
                                unsafe.putObject(t2, offset, protobufList2);
                            }
                            int decodeMessageList = ArrayDecoders.decodeMessageList(getMessageFieldSchema(positionForFieldNumber), i24, bArr, i23, i2, protobufList2, registers);
                            t2 = t;
                            int i44 = i24;
                            i14 = i18;
                            int i45 = positionForFieldNumber;
                            i10 = i21;
                            i20 = i44;
                            i12 = i45;
                            i11 = decodeMessageList;
                            i18 = i14;
                            i = i11;
                            i19 = i12;
                            i21 = i10;
                            i17 = i3;
                            i16 = i2;
                        }
                        i7 = i23;
                        int i41222 = i21;
                        int i42222 = i24;
                        i6 = i3;
                        i8 = i42222;
                        i9 = positionForFieldNumber;
                        i5 = i41222;
                    }
                }
                if (i8 != i6 || i6 == 0) {
                    t2 = t;
                    int i46 = i9;
                    int i47 = i5;
                    int i48 = i6;
                    i = (!this.hasExtensions || registers.extensionRegistry == ExtensionRegistryLite.getEmptyRegistry()) ? ArrayDecoders.decodeUnknownField(i8, bArr, i7, i2, getMutableUnknownFields(t), registers) : ArrayDecoders.decodeExtensionOrUnknownField(i8, bArr, i7, i2, t, this.defaultInstance, this.unknownFieldSchema, registers);
                    i18 = i25;
                    i19 = i46;
                    i20 = i8;
                    i21 = i47;
                    i17 = i48;
                    i16 = i2;
                } else {
                    messageSchema = this;
                    i4 = i7;
                    int i49 = i5;
                    i20 = i8;
                    i21 = i49;
                    i17 = i6;
                }
            } else {
                messageSchema = this;
                i4 = i;
            }
        }
        if (i22 != 1048575) {
            unsafe.putInt(t, i22, i21);
        }
        UnknownFieldSetLite unknownFieldSetLite = null;
        int i50 = messageSchema.checkInitializedCount;
        while (true) {
            int i51 = i50;
            if (i51 >= messageSchema.repeatedFieldOffsetStart) {
                if (unknownFieldSetLite != null) {
                    messageSchema.unknownFieldSchema.setBuilderToMessage(t, unknownFieldSetLite);
                }
                if (i17 == 0) {
                    if (i4 == i2) {
                        return i4;
                    }
                    throw InvalidProtocolBufferException.parseFailure();
                } else if (i4 > i2 || i20 != i17) {
                    throw InvalidProtocolBufferException.parseFailure();
                } else {
                    return i4;
                }
            }
            unknownFieldSetLite = (UnknownFieldSetLite) messageSchema.filterMapUnknownEnumValues(t, messageSchema.intArray[i51], unknownFieldSetLite, messageSchema.unknownFieldSchema);
            i50 = i51 + 1;
        }
    }

    @Override // com.google.protobuf.Schema
    public void writeTo(T t, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t, writer);
        } else if (this.proto3) {
            writeFieldsInAscendingOrderProto3(t, writer);
        } else {
            writeFieldsInAscendingOrderProto2(t, writer);
        }
    }
}
