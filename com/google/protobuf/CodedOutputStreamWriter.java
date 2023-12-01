package com.google.protobuf;

import android.provider.MediaStore;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/CodedOutputStreamWriter.class */
public final class CodedOutputStreamWriter implements Writer {
    private final CodedOutputStream output;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.protobuf.CodedOutputStreamWriter$1  reason: invalid class name */
    /* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/CodedOutputStreamWriter$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0095 -> B:61:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0099 -> B:55:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x009d -> B:73:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00a1 -> B:65:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00a5 -> B:59:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00a9 -> B:53:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00ad -> B:71:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00b1 -> B:63:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00b5 -> B:57:0x0070). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00b9 -> B:51:0x007c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00bd -> B:69:0x0088). Please submit an issue!!! */
        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    private CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) Internal.checkNotNull(codedOutputStream, MediaStore.EXTRA_OUTPUT);
        this.output = codedOutputStream2;
        codedOutputStream2.wrapper = this;
    }

    public static CodedOutputStreamWriter forCodedOutput(CodedOutputStream codedOutputStream) {
        return codedOutputStream.wrapper != null ? codedOutputStream.wrapper : new CodedOutputStreamWriter(codedOutputStream);
    }

    private <V> void writeDeterministicBooleanMapEntry(int i, boolean z, V v, MapEntryLite.Metadata<Boolean, V> metadata) throws IOException {
        this.output.writeTag(i, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Boolean.valueOf(z), v));
        MapEntryLite.writeTo(this.output, metadata, Boolean.valueOf(z), v);
    }

    private <V> void writeDeterministicIntegerMap(int i, MapEntryLite.Metadata<Integer, V> metadata, Map<Integer, V> map) throws IOException {
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                break;
            }
            iArr[i3] = it.next().intValue();
            i2 = i3 + 1;
        }
        Arrays.sort(iArr);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= size) {
                return;
            }
            int i6 = iArr[i5];
            V v = map.get(Integer.valueOf(i6));
            this.output.writeTag(i, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Integer.valueOf(i6), v));
            MapEntryLite.writeTo(this.output, metadata, Integer.valueOf(i6), v);
            i4 = i5 + 1;
        }
    }

    private <V> void writeDeterministicLongMap(int i, MapEntryLite.Metadata<Long, V> metadata, Map<Long, V> map) throws IOException {
        int size = map.size();
        long[] jArr = new long[size];
        Iterator<Long> it = map.keySet().iterator();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                break;
            }
            jArr[i3] = it.next().longValue();
            i2 = i3 + 1;
        }
        Arrays.sort(jArr);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= size) {
                return;
            }
            long j = jArr[i5];
            V v = map.get(Long.valueOf(j));
            this.output.writeTag(i, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Long.valueOf(j), v));
            MapEntryLite.writeTo(this.output, metadata, Long.valueOf(j), v);
            i4 = i5 + 1;
        }
    }

    private <K, V> void writeDeterministicMap(int i, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[metadata.keyType.ordinal()]) {
            case 1:
                V v = map.get(Boolean.FALSE);
                if (v != null) {
                    writeDeterministicBooleanMapEntry(i, false, v, metadata);
                }
                V v2 = map.get(Boolean.TRUE);
                if (v2 != null) {
                    writeDeterministicBooleanMapEntry(i, true, v2, metadata);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                writeDeterministicIntegerMap(i, metadata, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                writeDeterministicLongMap(i, metadata, map);
                return;
            case 12:
                writeDeterministicStringMap(i, metadata, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + metadata.keyType);
        }
    }

    private <V> void writeDeterministicStringMap(int i, MapEntryLite.Metadata<String, V> metadata, Map<String, V> map) throws IOException {
        int size = map.size();
        String[] strArr = new String[size];
        Iterator<String> it = map.keySet().iterator();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                break;
            }
            strArr[i3] = it.next();
            i2 = i3 + 1;
        }
        Arrays.sort(strArr);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= size) {
                return;
            }
            String str = strArr[i5];
            V v = map.get(str);
            this.output.writeTag(i, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, str, v));
            MapEntryLite.writeTo(this.output, metadata, str, v);
            i4 = i5 + 1;
        }
    }

    private void writeLazyString(int i, Object obj) throws IOException {
        if (obj instanceof String) {
            this.output.writeString(i, (String) obj);
        } else {
            this.output.writeBytes(i, (ByteString) obj);
        }
    }

    @Override // com.google.protobuf.Writer
    public Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.ASCENDING;
    }

    public int getTotalBytesWritten() {
        return this.output.getTotalBytesWritten();
    }

    @Override // com.google.protobuf.Writer
    public void writeBool(int i, boolean z) throws IOException {
        this.output.writeBool(i, z);
    }

    @Override // com.google.protobuf.Writer
    public void writeBoolList(int i, List<Boolean> list, boolean z) throws IOException {
        if (!z) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.output.writeBool(i, list.get(i2).booleanValue());
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += CodedOutputStream.computeBoolSizeNoTag(list.get(i4).booleanValue());
        }
        this.output.writeUInt32NoTag(i3);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= list.size()) {
                return;
            }
            this.output.writeBoolNoTag(list.get(i6).booleanValue());
            i5 = i6 + 1;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeBytes(int i, ByteString byteString) throws IOException {
        this.output.writeBytes(i, byteString);
    }

    @Override // com.google.protobuf.Writer
    public void writeBytesList(int i, List<ByteString> list) throws IOException {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                return;
            }
            this.output.writeBytes(i, list.get(i3));
            i2 = i3 + 1;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeDouble(int i, double d) throws IOException {
        this.output.writeDouble(i, d);
    }

    @Override // com.google.protobuf.Writer
    public void writeDoubleList(int i, List<Double> list, boolean z) throws IOException {
        if (!z) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.output.writeDouble(i, list.get(i2).doubleValue());
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += CodedOutputStream.computeDoubleSizeNoTag(list.get(i4).doubleValue());
        }
        this.output.writeUInt32NoTag(i3);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= list.size()) {
                return;
            }
            this.output.writeDoubleNoTag(list.get(i6).doubleValue());
            i5 = i6 + 1;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeEndGroup(int i) throws IOException {
        this.output.writeTag(i, 4);
    }

    @Override // com.google.protobuf.Writer
    public void writeEnum(int i, int i2) throws IOException {
        this.output.writeEnum(i, i2);
    }

    @Override // com.google.protobuf.Writer
    public void writeEnumList(int i, List<Integer> list, boolean z) throws IOException {
        if (!z) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.output.writeEnum(i, list.get(i2).intValue());
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += CodedOutputStream.computeEnumSizeNoTag(list.get(i4).intValue());
        }
        this.output.writeUInt32NoTag(i3);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= list.size()) {
                return;
            }
            this.output.writeEnumNoTag(list.get(i6).intValue());
            i5 = i6 + 1;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed32(int i, int i2) throws IOException {
        this.output.writeFixed32(i, i2);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed32List(int i, List<Integer> list, boolean z) throws IOException {
        if (!z) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.output.writeFixed32(i, list.get(i2).intValue());
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += CodedOutputStream.computeFixed32SizeNoTag(list.get(i4).intValue());
        }
        this.output.writeUInt32NoTag(i3);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= list.size()) {
                return;
            }
            this.output.writeFixed32NoTag(list.get(i6).intValue());
            i5 = i6 + 1;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed64(int i, long j) throws IOException {
        this.output.writeFixed64(i, j);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed64List(int i, List<Long> list, boolean z) throws IOException {
        if (!z) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.output.writeFixed64(i, list.get(i2).longValue());
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += CodedOutputStream.computeFixed64SizeNoTag(list.get(i4).longValue());
        }
        this.output.writeUInt32NoTag(i3);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= list.size()) {
                return;
            }
            this.output.writeFixed64NoTag(list.get(i6).longValue());
            i5 = i6 + 1;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeFloat(int i, float f) throws IOException {
        this.output.writeFloat(i, f);
    }

    @Override // com.google.protobuf.Writer
    public void writeFloatList(int i, List<Float> list, boolean z) throws IOException {
        if (!z) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.output.writeFloat(i, list.get(i2).floatValue());
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += CodedOutputStream.computeFloatSizeNoTag(list.get(i4).floatValue());
        }
        this.output.writeUInt32NoTag(i3);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= list.size()) {
                return;
            }
            this.output.writeFloatNoTag(list.get(i6).floatValue());
            i5 = i6 + 1;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeGroup(int i, Object obj) throws IOException {
        this.output.writeGroup(i, (MessageLite) obj);
    }

    @Override // com.google.protobuf.Writer
    public void writeGroup(int i, Object obj, Schema schema) throws IOException {
        this.output.writeGroup(i, (MessageLite) obj, schema);
    }

    @Override // com.google.protobuf.Writer
    public void writeGroupList(int i, List<?> list) throws IOException {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                return;
            }
            writeGroup(i, list.get(i3));
            i2 = i3 + 1;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeGroupList(int i, List<?> list, Schema schema) throws IOException {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                return;
            }
            writeGroup(i, list.get(i3), schema);
            i2 = i3 + 1;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeInt32(int i, int i2) throws IOException {
        this.output.writeInt32(i, i2);
    }

    @Override // com.google.protobuf.Writer
    public void writeInt32List(int i, List<Integer> list, boolean z) throws IOException {
        if (!z) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.output.writeInt32(i, list.get(i2).intValue());
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += CodedOutputStream.computeInt32SizeNoTag(list.get(i4).intValue());
        }
        this.output.writeUInt32NoTag(i3);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= list.size()) {
                return;
            }
            this.output.writeInt32NoTag(list.get(i6).intValue());
            i5 = i6 + 1;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeInt64(int i, long j) throws IOException {
        this.output.writeInt64(i, j);
    }

    @Override // com.google.protobuf.Writer
    public void writeInt64List(int i, List<Long> list, boolean z) throws IOException {
        if (!z) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.output.writeInt64(i, list.get(i2).longValue());
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += CodedOutputStream.computeInt64SizeNoTag(list.get(i4).longValue());
        }
        this.output.writeUInt32NoTag(i3);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= list.size()) {
                return;
            }
            this.output.writeInt64NoTag(list.get(i6).longValue());
            i5 = i6 + 1;
        }
    }

    @Override // com.google.protobuf.Writer
    public <K, V> void writeMap(int i, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        if (this.output.isSerializationDeterministic()) {
            writeDeterministicMap(i, metadata, map);
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.output.writeTag(i, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, entry.getKey(), entry.getValue()));
            MapEntryLite.writeTo(this.output, metadata, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeMessage(int i, Object obj) throws IOException {
        this.output.writeMessage(i, (MessageLite) obj);
    }

    @Override // com.google.protobuf.Writer
    public void writeMessage(int i, Object obj, Schema schema) throws IOException {
        this.output.writeMessage(i, (MessageLite) obj, schema);
    }

    @Override // com.google.protobuf.Writer
    public void writeMessageList(int i, List<?> list) throws IOException {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                return;
            }
            writeMessage(i, list.get(i3));
            i2 = i3 + 1;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeMessageList(int i, List<?> list, Schema schema) throws IOException {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                return;
            }
            writeMessage(i, list.get(i3), schema);
            i2 = i3 + 1;
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageSetItem(int i, Object obj) throws IOException {
        if (obj instanceof ByteString) {
            this.output.writeRawMessageSetExtension(i, (ByteString) obj);
        } else {
            this.output.writeMessageSetExtension(i, (MessageLite) obj);
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed32(int i, int i2) throws IOException {
        this.output.writeSFixed32(i, i2);
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed32List(int i, List<Integer> list, boolean z) throws IOException {
        if (!z) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.output.writeSFixed32(i, list.get(i2).intValue());
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += CodedOutputStream.computeSFixed32SizeNoTag(list.get(i4).intValue());
        }
        this.output.writeUInt32NoTag(i3);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= list.size()) {
                return;
            }
            this.output.writeSFixed32NoTag(list.get(i6).intValue());
            i5 = i6 + 1;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed64(int i, long j) throws IOException {
        this.output.writeSFixed64(i, j);
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed64List(int i, List<Long> list, boolean z) throws IOException {
        if (!z) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.output.writeSFixed64(i, list.get(i2).longValue());
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += CodedOutputStream.computeSFixed64SizeNoTag(list.get(i4).longValue());
        }
        this.output.writeUInt32NoTag(i3);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= list.size()) {
                return;
            }
            this.output.writeSFixed64NoTag(list.get(i6).longValue());
            i5 = i6 + 1;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt32(int i, int i2) throws IOException {
        this.output.writeSInt32(i, i2);
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt32List(int i, List<Integer> list, boolean z) throws IOException {
        if (!z) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.output.writeSInt32(i, list.get(i2).intValue());
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += CodedOutputStream.computeSInt32SizeNoTag(list.get(i4).intValue());
        }
        this.output.writeUInt32NoTag(i3);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= list.size()) {
                return;
            }
            this.output.writeSInt32NoTag(list.get(i6).intValue());
            i5 = i6 + 1;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt64(int i, long j) throws IOException {
        this.output.writeSInt64(i, j);
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt64List(int i, List<Long> list, boolean z) throws IOException {
        if (!z) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.output.writeSInt64(i, list.get(i2).longValue());
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += CodedOutputStream.computeSInt64SizeNoTag(list.get(i4).longValue());
        }
        this.output.writeUInt32NoTag(i3);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= list.size()) {
                return;
            }
            this.output.writeSInt64NoTag(list.get(i6).longValue());
            i5 = i6 + 1;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeStartGroup(int i) throws IOException {
        this.output.writeTag(i, 3);
    }

    @Override // com.google.protobuf.Writer
    public void writeString(int i, String str) throws IOException {
        this.output.writeString(i, str);
    }

    @Override // com.google.protobuf.Writer
    public void writeStringList(int i, List<String> list) throws IOException {
        if (!(list instanceof LazyStringList)) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.output.writeString(i, list.get(i2));
            }
            return;
        }
        LazyStringList lazyStringList = (LazyStringList) list;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= list.size()) {
                return;
            }
            writeLazyString(i, lazyStringList.getRaw(i4));
            i3 = i4 + 1;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt32(int i, int i2) throws IOException {
        this.output.writeUInt32(i, i2);
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt32List(int i, List<Integer> list, boolean z) throws IOException {
        if (!z) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.output.writeUInt32(i, list.get(i2).intValue());
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += CodedOutputStream.computeUInt32SizeNoTag(list.get(i4).intValue());
        }
        this.output.writeUInt32NoTag(i3);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= list.size()) {
                return;
            }
            this.output.writeUInt32NoTag(list.get(i6).intValue());
            i5 = i6 + 1;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt64(int i, long j) throws IOException {
        this.output.writeUInt64(i, j);
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt64List(int i, List<Long> list, boolean z) throws IOException {
        if (!z) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.output.writeUInt64(i, list.get(i2).longValue());
            }
            return;
        }
        this.output.writeTag(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += CodedOutputStream.computeUInt64SizeNoTag(list.get(i4).longValue());
        }
        this.output.writeUInt32NoTag(i3);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= list.size()) {
                return;
            }
            this.output.writeUInt64NoTag(list.get(i6).longValue());
            i5 = i6 + 1;
        }
    }
}
