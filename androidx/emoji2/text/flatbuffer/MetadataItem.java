package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/MetadataItem.class */
public final class MetadataItem extends Table {

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/MetadataItem$Vector.class */
    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            a(i, i2, byteBuffer);
            return this;
        }

        public MetadataItem get(int i) {
            return get(new MetadataItem(), i);
        }

        public MetadataItem get(MetadataItem metadataItem, int i) {
            return metadataItem.__assign(MetadataItem.b(a(i), this.f2849a), this.f2849a);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_12_0();
    }

    public static void addCodepoints(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(6, i, 0);
    }

    public static void addCompatAdded(FlatBufferBuilder flatBufferBuilder, short s) {
        flatBufferBuilder.addShort(3, s, 0);
    }

    public static void addEmojiStyle(FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.addBoolean(1, z, false);
    }

    public static void addHeight(FlatBufferBuilder flatBufferBuilder, short s) {
        flatBufferBuilder.addShort(5, s, 0);
    }

    public static void addId(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addInt(0, i, 0);
    }

    public static void addSdkAdded(FlatBufferBuilder flatBufferBuilder, short s) {
        flatBufferBuilder.addShort(2, s, 0);
    }

    public static void addWidth(FlatBufferBuilder flatBufferBuilder, short s) {
        flatBufferBuilder.addShort(4, s, 0);
    }

    public static int createCodepointsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        int length = iArr.length;
        while (true) {
            int i = length - 1;
            if (i < 0) {
                return flatBufferBuilder.endVector();
            }
            flatBufferBuilder.addInt(iArr[i]);
            length = i;
        }
    }

    public static int createMetadataItem(FlatBufferBuilder flatBufferBuilder, int i, boolean z, short s, short s2, short s3, short s4, int i2) {
        flatBufferBuilder.startTable(7);
        addCodepoints(flatBufferBuilder, i2);
        addId(flatBufferBuilder, i);
        addHeight(flatBufferBuilder, s4);
        addWidth(flatBufferBuilder, s3);
        addCompatAdded(flatBufferBuilder, s2);
        addSdkAdded(flatBufferBuilder, s);
        addEmojiStyle(flatBufferBuilder, z);
        return endMetadataItem(flatBufferBuilder);
    }

    public static int endMetadataItem(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static MetadataItem getRootAsMetadataItem(ByteBuffer byteBuffer) {
        return getRootAsMetadataItem(byteBuffer, new MetadataItem());
    }

    public static MetadataItem getRootAsMetadataItem(ByteBuffer byteBuffer, MetadataItem metadataItem) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return metadataItem.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public static void startCodepointsVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void startMetadataItem(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(7);
    }

    public MetadataItem __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        c(i, byteBuffer);
    }

    public int codepoints(int i) {
        int a2 = a(16);
        if (a2 != 0) {
            return this.b.getInt(e(a2) + (i * 4));
        }
        return 0;
    }

    public ByteBuffer codepointsAsByteBuffer() {
        return a(16, 4);
    }

    public ByteBuffer codepointsInByteBuffer(ByteBuffer byteBuffer) {
        return a(byteBuffer, 16, 4);
    }

    public int codepointsLength() {
        int a2 = a(16);
        if (a2 != 0) {
            return d(a2);
        }
        return 0;
    }

    public IntVector codepointsVector() {
        return codepointsVector(new IntVector());
    }

    public IntVector codepointsVector(IntVector intVector) {
        int a2 = a(16);
        if (a2 != 0) {
            return intVector.__assign(e(a2), this.b);
        }
        return null;
    }

    public short compatAdded() {
        int a2 = a(10);
        if (a2 != 0) {
            return this.b.getShort(a2 + this.f2871a);
        }
        return (short) 0;
    }

    public boolean emojiStyle() {
        int a2 = a(6);
        boolean z = false;
        if (a2 != 0) {
            z = false;
            if (this.b.get(a2 + this.f2871a) != 0) {
                z = true;
            }
        }
        return z;
    }

    public short height() {
        int a2 = a(14);
        if (a2 != 0) {
            return this.b.getShort(a2 + this.f2871a);
        }
        return (short) 0;
    }

    public int id() {
        int a2 = a(4);
        if (a2 != 0) {
            return this.b.getInt(a2 + this.f2871a);
        }
        return 0;
    }

    public short sdkAdded() {
        int a2 = a(8);
        if (a2 != 0) {
            return this.b.getShort(a2 + this.f2871a);
        }
        return (short) 0;
    }

    public short width() {
        int a2 = a(12);
        if (a2 != 0) {
            return this.b.getShort(a2 + this.f2871a);
        }
        return (short) 0;
    }
}
