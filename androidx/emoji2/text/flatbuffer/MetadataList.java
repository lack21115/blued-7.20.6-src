package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.MetadataItem;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/MetadataList.class */
public final class MetadataList extends Table {

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/MetadataList$Vector.class */
    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            a(i, i2, byteBuffer);
            return this;
        }

        public MetadataList get(int i) {
            return get(new MetadataList(), i);
        }

        public MetadataList get(MetadataList metadataList, int i) {
            return metadataList.__assign(MetadataList.b(a(i), this.f2849a), this.f2849a);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_12_0();
    }

    public static void addList(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    public static void addSourceSha(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(2, i, 0);
    }

    public static void addVersion(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addInt(0, i, 0);
    }

    public static int createListVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        int length = iArr.length;
        while (true) {
            int i = length - 1;
            if (i < 0) {
                return flatBufferBuilder.endVector();
            }
            flatBufferBuilder.addOffset(iArr[i]);
            length = i;
        }
    }

    public static int createMetadataList(FlatBufferBuilder flatBufferBuilder, int i, int i2, int i3) {
        flatBufferBuilder.startTable(3);
        addSourceSha(flatBufferBuilder, i3);
        addList(flatBufferBuilder, i2);
        addVersion(flatBufferBuilder, i);
        return endMetadataList(flatBufferBuilder);
    }

    public static int endMetadataList(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static void finishMetadataListBuffer(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finish(i);
    }

    public static void finishSizePrefixedMetadataListBuffer(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finishSizePrefixed(i);
    }

    public static MetadataList getRootAsMetadataList(ByteBuffer byteBuffer) {
        return getRootAsMetadataList(byteBuffer, new MetadataList());
    }

    public static MetadataList getRootAsMetadataList(ByteBuffer byteBuffer, MetadataList metadataList) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return metadataList.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public static void startListVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void startMetadataList(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(3);
    }

    public MetadataList __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        c(i, byteBuffer);
    }

    public MetadataItem list(int i) {
        return list(new MetadataItem(), i);
    }

    public MetadataItem list(MetadataItem metadataItem, int i) {
        int a2 = a(6);
        if (a2 != 0) {
            return metadataItem.__assign(b(e(a2) + (i * 4)), this.b);
        }
        return null;
    }

    public int listLength() {
        int a2 = a(6);
        if (a2 != 0) {
            return d(a2);
        }
        return 0;
    }

    public MetadataItem.Vector listVector() {
        return listVector(new MetadataItem.Vector());
    }

    public MetadataItem.Vector listVector(MetadataItem.Vector vector) {
        int a2 = a(6);
        if (a2 != 0) {
            return vector.__assign(e(a2), 4, this.b);
        }
        return null;
    }

    public String sourceSha() {
        int a2 = a(8);
        if (a2 != 0) {
            return c(a2 + this.f2871a);
        }
        return null;
    }

    public ByteBuffer sourceShaAsByteBuffer() {
        return a(8, 1);
    }

    public ByteBuffer sourceShaInByteBuffer(ByteBuffer byteBuffer) {
        return a(byteBuffer, 8, 1);
    }

    public int version() {
        int a2 = a(4);
        if (a2 != 0) {
            return this.b.getInt(a2 + this.f2871a);
        }
        return 0;
    }
}
