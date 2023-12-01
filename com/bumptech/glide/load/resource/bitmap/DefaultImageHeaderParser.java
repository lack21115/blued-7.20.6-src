package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/DefaultImageHeaderParser.class */
public final class DefaultImageHeaderParser implements ImageHeaderParser {

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f7337a = "Exif����".getBytes(Charset.forName("UTF-8"));
    private static final int[] b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/DefaultImageHeaderParser$ByteBufferReader.class */
    static final class ByteBufferReader implements Reader {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f7338a;

        ByteBufferReader(ByteBuffer byteBuffer) {
            this.f7338a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int a(byte[] bArr, int i) {
            int min = Math.min(i, this.f7338a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f7338a.get(bArr, 0, min);
            return min;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long a(long j) {
            int min = (int) Math.min(this.f7338a.remaining(), j);
            ByteBuffer byteBuffer = this.f7338a;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short a() throws Reader.EndOfFileException {
            if (this.f7338a.remaining() >= 1) {
                return (short) (this.f7338a.get() & 255);
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int b() throws Reader.EndOfFileException {
            return (a() << 8) | a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/DefaultImageHeaderParser$RandomAccessReader.class */
    public static final class RandomAccessReader {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f7339a;

        RandomAccessReader(byte[] bArr, int i) {
            this.f7339a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        private boolean a(int i, int i2) {
            return this.f7339a.remaining() - i >= i2;
        }

        int a() {
            return this.f7339a.remaining();
        }

        int a(int i) {
            if (a(i, 4)) {
                return this.f7339a.getInt(i);
            }
            return -1;
        }

        void a(ByteOrder byteOrder) {
            this.f7339a.order(byteOrder);
        }

        short b(int i) {
            if (a(i, 2)) {
                return this.f7339a.getShort(i);
            }
            return (short) -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/DefaultImageHeaderParser$Reader.class */
    public interface Reader {

        /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/DefaultImageHeaderParser$Reader$EndOfFileException.class */
        public static final class EndOfFileException extends IOException {
            private static final long serialVersionUID = 1;

            EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        int a(byte[] bArr, int i) throws IOException;

        long a(long j) throws IOException;

        short a() throws IOException;

        int b() throws IOException;
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/DefaultImageHeaderParser$StreamReader.class */
    static final class StreamReader implements Reader {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f7340a;

        StreamReader(InputStream inputStream) {
            this.f7340a = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int a(byte[] bArr, int i) throws IOException {
            int i2;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                i2 = i4;
                if (i3 >= i) {
                    break;
                }
                i4 = this.f7340a.read(bArr, i3, i - i3);
                i2 = i4;
                if (i4 == -1) {
                    break;
                }
                i3 += i4;
            }
            if (i3 == 0 && i2 == -1) {
                throw new Reader.EndOfFileException();
            }
            return i3;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long a(long j) throws IOException {
            long j2;
            if (j < 0) {
                return 0L;
            }
            long j3 = j;
            while (true) {
                j2 = j3;
                if (j2 <= 0) {
                    break;
                }
                long skip = this.f7340a.skip(j2);
                if (skip <= 0) {
                    if (this.f7340a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j3 = j2 - skip;
            }
            return j - j2;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short a() throws IOException {
            int read = this.f7340a.read();
            if (read != -1) {
                return (short) read;
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int b() throws IOException {
            return (a() << 8) | a();
        }
    }

    private static int a(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    private static int a(RandomAccessReader randomAccessReader) {
        ByteOrder byteOrder;
        short b2 = randomAccessReader.b(6);
        if (b2 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (b2 != 19789) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) b2));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        randomAccessReader.a(byteOrder);
        int a2 = randomAccessReader.a(10) + 6;
        int b3 = randomAccessReader.b(a2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= b3) {
                return -1;
            }
            int a3 = a(a2, i2);
            short b4 = randomAccessReader.b(a3);
            if (b4 == 274) {
                short b5 = randomAccessReader.b(a3 + 2);
                if (b5 >= 1 && b5 <= 12) {
                    int a4 = randomAccessReader.a(a3 + 4);
                    if (a4 >= 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i2 + " tagType=" + ((int) b4) + " formatCode=" + ((int) b5) + " componentCount=" + a4);
                        }
                        int i3 = a4 + b[b5];
                        if (i3 <= 4) {
                            int i4 = a3 + 8;
                            if (i4 < 0 || i4 > randomAccessReader.a()) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i4 + " tagType=" + ((int) b4));
                                }
                            } else if (i3 >= 0 && i3 + i4 <= randomAccessReader.a()) {
                                return randomAccessReader.b(i4);
                            } else {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) b4));
                                }
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) b5));
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) b5));
                }
            }
            i = i2 + 1;
        }
    }

    private int a(Reader reader) throws IOException {
        short a2;
        short a3;
        int b2;
        long j;
        long a4;
        do {
            if (reader.a() != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) a2));
                    return -1;
                }
                return -1;
            }
            a3 = reader.a();
            if (a3 == 218) {
                return -1;
            }
            if (a3 == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                    return -1;
                }
                return -1;
            }
            b2 = reader.b() - 2;
            if (a3 == 225) {
                return b2;
            }
            j = b2;
            a4 = reader.a(j);
        } while (a4 == j);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) a3) + ", wanted to skip: " + b2 + ", but actually skipped: " + a4);
            return -1;
        }
        return -1;
    }

    private int a(Reader reader, ArrayPool arrayPool) throws IOException {
        try {
            int b2 = reader.b();
            if (!a(b2)) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + b2);
                    return -1;
                }
                return -1;
            }
            int a2 = a(reader);
            if (a2 == -1) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                    return -1;
                }
                return -1;
            }
            byte[] bArr = (byte[]) arrayPool.a(a2, byte[].class);
            int a3 = a(reader, bArr, a2);
            arrayPool.a((ArrayPool) bArr);
            return a3;
        } catch (Reader.EndOfFileException e) {
            return -1;
        }
    }

    private int a(Reader reader, byte[] bArr, int i) throws IOException {
        int a2 = reader.a(bArr, i);
        if (a2 == i) {
            if (a(bArr, i)) {
                return a(new RandomAccessReader(bArr, i));
            }
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
                return -1;
            }
            return -1;
        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i + ", actually read: " + a2);
            return -1;
        } else {
            return -1;
        }
    }

    private static boolean a(int i) {
        return (i & 65496) == 65496 || i == 19789 || i == 18761;
    }

    private boolean a(byte[] bArr, int i) {
        boolean z = bArr != null && i > f7337a.length;
        if (z) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                byte[] bArr2 = f7337a;
                if (i3 >= bArr2.length) {
                    break;
                } else if (bArr[i3] != bArr2[i3]) {
                    return false;
                } else {
                    i2 = i3 + 1;
                }
            }
        }
        return z;
    }

    private ImageHeaderParser.ImageType getType(Reader reader) throws IOException {
        try {
            int b2 = reader.b();
            if (b2 == 65496) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int a2 = (b2 << 8) | reader.a();
            if (a2 == 4671814) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int a3 = (a2 << 8) | reader.a();
            if (a3 == -1991225785) {
                reader.a(21L);
                try {
                    return reader.a() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
                } catch (Reader.EndOfFileException e) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            } else if (a3 != 1380533830) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            } else {
                reader.a(4L);
                if (((reader.b() << 16) | reader.b()) != 1464156752) {
                    return ImageHeaderParser.ImageType.UNKNOWN;
                }
                int b3 = (reader.b() << 16) | reader.b();
                if ((b3 & (-256)) != 1448097792) {
                    return ImageHeaderParser.ImageType.UNKNOWN;
                }
                int i = b3 & 255;
                if (i == 88) {
                    reader.a(4L);
                    return (reader.a() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
                } else if (i == 76) {
                    reader.a(4L);
                    return (reader.a() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
                } else {
                    return ImageHeaderParser.ImageType.WEBP;
                }
            }
        } catch (Reader.EndOfFileException e2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int a(InputStream inputStream, ArrayPool arrayPool) throws IOException {
        return a(new StreamReader((InputStream) Preconditions.a(inputStream)), (ArrayPool) Preconditions.a(arrayPool));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(InputStream inputStream) throws IOException {
        return getType(new StreamReader((InputStream) Preconditions.a(inputStream)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(ByteBuffer byteBuffer) throws IOException {
        return getType(new ByteBufferReader((ByteBuffer) Preconditions.a(byteBuffer)));
    }
}
