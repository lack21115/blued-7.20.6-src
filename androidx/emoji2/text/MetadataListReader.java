package androidx.emoji2.text;

import android.content.res.AssetManager;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/MetadataListReader.class */
class MetadataListReader {

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/MetadataListReader$ByteBufferReader.class */
    static class ByteBufferReader implements OpenTypeReader {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f2790a;

        ByteBufferReader(ByteBuffer byteBuffer) {
            this.f2790a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long getPosition() {
            return this.f2790a.position();
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readTag() throws IOException {
            return this.f2790a.getInt();
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long readUnsignedInt() throws IOException {
            return MetadataListReader.a(this.f2790a.getInt());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readUnsignedShort() throws IOException {
            return MetadataListReader.a(this.f2790a.getShort());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public void skip(int i) throws IOException {
            ByteBuffer byteBuffer = this.f2790a;
            byteBuffer.position(byteBuffer.position() + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/MetadataListReader$InputStreamOpenTypeReader.class */
    public static class InputStreamOpenTypeReader implements OpenTypeReader {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f2791a;
        private final ByteBuffer b;

        /* renamed from: c  reason: collision with root package name */
        private final InputStream f2792c;
        private long d = 0;

        InputStreamOpenTypeReader(InputStream inputStream) {
            this.f2792c = inputStream;
            byte[] bArr = new byte[4];
            this.f2791a = bArr;
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.b = wrap;
            wrap.order(ByteOrder.BIG_ENDIAN);
        }

        private void a(int i) throws IOException {
            if (this.f2792c.read(this.f2791a, 0, i) != i) {
                throw new IOException("read failed");
            }
            this.d += i;
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long getPosition() {
            return this.d;
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readTag() throws IOException {
            this.b.position(0);
            a(4);
            return this.b.getInt();
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long readUnsignedInt() throws IOException {
            this.b.position(0);
            a(4);
            return MetadataListReader.a(this.b.getInt());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readUnsignedShort() throws IOException {
            this.b.position(0);
            a(2);
            return MetadataListReader.a(this.b.getShort());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public void skip(int i) throws IOException {
            while (i > 0) {
                int skip = (int) this.f2792c.skip(i);
                if (skip < 1) {
                    throw new IOException("Skip didn't move at least 1 byte forward");
                }
                i -= skip;
                this.d += skip;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/MetadataListReader$OffsetInfo.class */
    public static class OffsetInfo {

        /* renamed from: a  reason: collision with root package name */
        private final long f2793a;
        private final long b;

        OffsetInfo(long j, long j2) {
            this.f2793a = j;
            this.b = j2;
        }

        long a() {
            return this.f2793a;
        }

        long b() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/MetadataListReader$OpenTypeReader.class */
    public interface OpenTypeReader {
        public static final int UINT16_BYTE_COUNT = 2;
        public static final int UINT32_BYTE_COUNT = 4;

        long getPosition();

        int readTag() throws IOException;

        long readUnsignedInt() throws IOException;

        int readUnsignedShort() throws IOException;

        void skip(int i) throws IOException;
    }

    private MetadataListReader() {
    }

    static int a(short s) {
        return s & 65535;
    }

    static long a(int i) {
        return i & 4294967295L;
    }

    private static OffsetInfo a(OpenTypeReader openTypeReader) throws IOException {
        long j;
        long readUnsignedInt;
        long readUnsignedInt2;
        openTypeReader.skip(4);
        int readUnsignedShort = openTypeReader.readUnsignedShort();
        if (readUnsignedShort <= 100) {
            openTypeReader.skip(6);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readUnsignedShort) {
                    j = -1;
                    break;
                }
                int readTag = openTypeReader.readTag();
                openTypeReader.skip(4);
                j = openTypeReader.readUnsignedInt();
                openTypeReader.skip(4);
                if (1835365473 == readTag) {
                    break;
                }
                i = i2 + 1;
            }
            if (j != -1) {
                openTypeReader.skip((int) (j - openTypeReader.getPosition()));
                openTypeReader.skip(12);
                long readUnsignedInt3 = openTypeReader.readUnsignedInt();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= readUnsignedInt3) {
                        break;
                    }
                    int readTag2 = openTypeReader.readTag();
                    readUnsignedInt = openTypeReader.readUnsignedInt();
                    readUnsignedInt2 = openTypeReader.readUnsignedInt();
                    if (1164798569 == readTag2 || 1701669481 == readTag2) {
                        break;
                    }
                    i3 = i4 + 1;
                }
                return new OffsetInfo(readUnsignedInt + j, readUnsignedInt2);
            }
            throw new IOException("Cannot read metadata.");
        }
        throw new IOException("Cannot read metadata.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MetadataList a(AssetManager assetManager, String str) throws IOException {
        InputStream open = assetManager.open(str);
        try {
            MetadataList a2 = a(open);
            if (open != null) {
                open.close();
            }
            return a2;
        } catch (Throwable th) {
            if (open != null) {
                try {
                    open.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MetadataList a(InputStream inputStream) throws IOException {
        InputStreamOpenTypeReader inputStreamOpenTypeReader = new InputStreamOpenTypeReader(inputStream);
        OffsetInfo a2 = a(inputStreamOpenTypeReader);
        inputStreamOpenTypeReader.skip((int) (a2.a() - inputStreamOpenTypeReader.getPosition()));
        ByteBuffer allocate = ByteBuffer.allocate((int) a2.b());
        int read = inputStream.read(allocate.array());
        if (read == a2.b()) {
            return MetadataList.getRootAsMetadataList(allocate);
        }
        throw new IOException("Needed " + a2.b() + " bytes, got " + read);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MetadataList a(ByteBuffer byteBuffer) throws IOException {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position((int) a(new ByteBufferReader(duplicate)).a());
        return MetadataList.getRootAsMetadataList(duplicate);
    }
}
