package java.io;

import java.nio.ByteOrder;
import java.nio.charset.ModifiedUtf8;
import libcore.io.Memory;
import libcore.io.Streams;

/* loaded from: source-2895416-dex2jar.jar:java/io/DataInputStream.class */
public class DataInputStream extends FilterInputStream implements DataInput {
    private final byte[] scratch;

    public DataInputStream(InputStream inputStream) {
        super(inputStream);
        this.scratch = new byte[8];
    }

    private static String decodeUTF(int i, DataInput dataInput) throws IOException {
        byte[] bArr = new byte[i];
        dataInput.readFully(bArr, 0, i);
        return ModifiedUtf8.decode(bArr, new char[i], 0, i);
    }

    public static final String readUTF(DataInput dataInput) throws IOException {
        return decodeUTF(dataInput.readUnsignedShort(), dataInput);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String decodeUTF(int i) throws IOException {
        return decodeUTF(i, this);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        return super.read(bArr);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        return this.f42254in.read(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() throws IOException {
        int read = this.f42254in.read();
        if (read < 0) {
            throw new EOFException();
        }
        return read != 0;
    }

    @Override // java.io.DataInput
    public final byte readByte() throws IOException {
        int read = this.f42254in.read();
        if (read < 0) {
            throw new EOFException();
        }
        return (byte) read;
    }

    @Override // java.io.DataInput
    public final char readChar() throws IOException {
        return (char) readShort();
    }

    @Override // java.io.DataInput
    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) throws IOException {
        readFully(bArr, 0, bArr.length);
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i, int i2) throws IOException {
        Streams.readFully(this.f42254in, bArr, i, i2);
    }

    @Override // java.io.DataInput
    public final int readInt() throws IOException {
        Streams.readFully(this.f42254in, this.scratch, 0, 4);
        return Memory.peekInt(this.scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    @Override // java.io.DataInput
    @Deprecated
    public final String readLine() throws IOException {
        StringBuilder sb = new StringBuilder(80);
        boolean z = false;
        while (true) {
            int read = this.f42254in.read();
            switch (read) {
                case -1:
                    if (sb.length() != 0 || z) {
                        return sb.toString();
                    }
                    return null;
                case 10:
                    return sb.toString();
                case 13:
                    if (!z) {
                        z = true;
                        if (this.f42254in.getClass() == PushbackInputStream.class) {
                            break;
                        } else {
                            this.f42254in = new PushbackInputStream(this.f42254in);
                            z = true;
                            break;
                        }
                    } else {
                        ((PushbackInputStream) this.f42254in).unread(read);
                        return sb.toString();
                    }
                default:
                    if (!z) {
                        sb.append((char) read);
                        break;
                    } else {
                        ((PushbackInputStream) this.f42254in).unread(read);
                        return sb.toString();
                    }
            }
        }
    }

    @Override // java.io.DataInput
    public final long readLong() throws IOException {
        Streams.readFully(this.f42254in, this.scratch, 0, 8);
        return Memory.peekLong(this.scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    @Override // java.io.DataInput
    public final short readShort() throws IOException {
        Streams.readFully(this.f42254in, this.scratch, 0, 2);
        return Memory.peekShort(this.scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    @Override // java.io.DataInput
    public final String readUTF() throws IOException {
        return decodeUTF(readUnsignedShort());
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() throws IOException {
        int read = this.f42254in.read();
        if (read < 0) {
            throw new EOFException();
        }
        return read;
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() throws IOException {
        return readShort() & 65535;
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i) throws IOException {
        int i2;
        int i3 = 0;
        while (true) {
            i2 = i3;
            if (i2 >= i) {
                break;
            }
            long skip = this.f42254in.skip(i - i2);
            if (skip == 0) {
                break;
            }
            i3 = (int) (i2 + skip);
        }
        return i2;
    }
}
