package java.io;

import android.system.ErrnoException;
import android.system.OsConstants;
import dalvik.system.CloseGuard;
import java.nio.ByteOrder;
import java.nio.NioUtils;
import java.nio.channels.FileChannel;
import java.nio.charset.ModifiedUtf8;
import java.util.Arrays;
import libcore.io.IoBridge;
import libcore.io.Libcore;
import libcore.io.Memory;
import org.apache.commons.codec.CharEncoding;

/* loaded from: source-2895416-dex2jar.jar:java/io/RandomAccessFile.class */
public class RandomAccessFile implements DataInput, DataOutput, Closeable {
    private FileChannel channel;
    private FileDescriptor fd;
    private final CloseGuard guard;
    private int mode;
    private final byte[] scratch;
    private boolean syncMetadata;

    public RandomAccessFile(File file, String str) throws FileNotFoundException {
        int i;
        this.syncMetadata = false;
        this.guard = CloseGuard.get();
        this.scratch = new byte[8];
        if (str.equals("r")) {
            i = OsConstants.O_RDONLY;
        } else if (!str.equals("rw") && !str.equals("rws") && !str.equals("rwd")) {
            throw new IllegalArgumentException("Invalid mode: " + str);
        } else {
            int i2 = OsConstants.O_RDWR | OsConstants.O_CREAT;
            if (str.equals("rws")) {
                this.syncMetadata = true;
                i = i2;
            } else {
                i = i2;
                if (str.equals("rwd")) {
                    i = i2 | OsConstants.O_SYNC;
                }
            }
        }
        this.mode = i;
        this.fd = IoBridge.open(file.getPath(), i);
        if (this.syncMetadata) {
            try {
                this.fd.sync();
            } catch (IOException e) {
            }
        }
        this.guard.open("close");
    }

    public RandomAccessFile(String str, String str2) throws FileNotFoundException {
        this(new File(str), str2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.guard.close();
        synchronized (this) {
            if (this.channel != null && this.channel.isOpen()) {
                this.channel.close();
                this.channel = null;
            }
            IoBridge.closeAndSignalBlockedThreads(this.fd);
        }
    }

    protected void finalize() throws Throwable {
        try {
            if (this.guard != null) {
                this.guard.warnIfOpen();
            }
            close();
        } finally {
            super.finalize();
        }
    }

    public final FileChannel getChannel() {
        FileChannel fileChannel;
        synchronized (this) {
            if (this.channel == null) {
                this.channel = NioUtils.newFileChannel(this, this.fd, this.mode);
            }
            fileChannel = this.channel;
        }
        return fileChannel;
    }

    public final FileDescriptor getFD() throws IOException {
        return this.fd;
    }

    public long getFilePointer() throws IOException {
        try {
            return Libcore.os.lseek(this.fd, 0L, OsConstants.SEEK_CUR);
        } catch (ErrnoException e) {
            throw e.rethrowAsIOException();
        }
    }

    public long length() throws IOException {
        try {
            return Libcore.os.fstat(this.fd).st_size;
        } catch (ErrnoException e) {
            throw e.rethrowAsIOException();
        }
    }

    public int read() throws IOException {
        int i = -1;
        if (read(this.scratch, 0, 1) != -1) {
            i = this.scratch[0] & 255;
        }
        return i;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        return IoBridge.read(this.fd, bArr, i, i2);
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() throws IOException {
        int read = read();
        if (read < 0) {
            throw new EOFException();
        }
        return read != 0;
    }

    @Override // java.io.DataInput
    public final byte readByte() throws IOException {
        int read = read();
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
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        while (i2 > 0) {
            int read = read(bArr, i, i2);
            if (read < 0) {
                throw new EOFException();
            }
            i += read;
            i2 -= read;
        }
    }

    @Override // java.io.DataInput
    public final int readInt() throws IOException {
        readFully(this.scratch, 0, 4);
        return Memory.peekInt(this.scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    @Override // java.io.DataInput
    public final String readLine() throws IOException {
        StringBuilder sb = new StringBuilder(80);
        boolean z = false;
        long j = 0;
        while (true) {
            int read = read();
            switch (read) {
                case -1:
                    if (sb.length() != 0) {
                        return sb.toString();
                    }
                    return null;
                case 10:
                    return sb.toString();
                case 13:
                    if (!z) {
                        z = true;
                        j = getFilePointer();
                        break;
                    } else {
                        seek(j);
                        return sb.toString();
                    }
                default:
                    if (!z) {
                        sb.append((char) read);
                        break;
                    } else {
                        seek(j);
                        return sb.toString();
                    }
            }
        }
    }

    @Override // java.io.DataInput
    public final long readLong() throws IOException {
        readFully(this.scratch, 0, 8);
        return Memory.peekLong(this.scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    @Override // java.io.DataInput
    public final short readShort() throws IOException {
        readFully(this.scratch, 0, 2);
        return Memory.peekShort(this.scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    @Override // java.io.DataInput
    public final String readUTF() throws IOException {
        int readUnsignedShort = readUnsignedShort();
        if (readUnsignedShort == 0) {
            return "";
        }
        byte[] bArr = new byte[readUnsignedShort];
        if (read(bArr, 0, bArr.length) != bArr.length) {
            throw new EOFException();
        }
        return ModifiedUtf8.decode(bArr, new char[readUnsignedShort], 0, readUnsignedShort);
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() throws IOException {
        int read = read();
        if (read < 0) {
            throw new EOFException();
        }
        return read;
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() throws IOException {
        return readShort() & 65535;
    }

    public void seek(long j) throws IOException {
        if (j < 0) {
            throw new IOException("offset < 0: " + j);
        }
        try {
            Libcore.os.lseek(this.fd, j, OsConstants.SEEK_SET);
        } catch (ErrnoException e) {
            throw e.rethrowAsIOException();
        }
    }

    public void setLength(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("newLength < 0");
        }
        try {
            Libcore.os.ftruncate(this.fd, j);
            if (getFilePointer() > j) {
                seek(j);
            }
            if (this.syncMetadata) {
                this.fd.sync();
            }
        } catch (ErrnoException e) {
            throw e.rethrowAsIOException();
        }
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) throws IOException {
        if (i > 0) {
            long filePointer = getFilePointer();
            long length = length();
            int i2 = (int) (((long) i) + filePointer > length ? length - filePointer : i);
            seek(i2 + filePointer);
            return i2;
        }
        return 0;
    }

    @Override // java.io.DataOutput
    public void write(int i) throws IOException {
        this.scratch[0] = (byte) (i & 255);
        write(this.scratch, 0, 1);
    }

    @Override // java.io.DataOutput
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.DataOutput
    public void write(byte[] bArr, int i, int i2) throws IOException {
        IoBridge.write(this.fd, bArr, i, i2);
        if (this.syncMetadata) {
            this.fd.sync();
        }
    }

    @Override // java.io.DataOutput
    public final void writeBoolean(boolean z) throws IOException {
        write(z ? 1 : 0);
    }

    @Override // java.io.DataOutput
    public final void writeByte(int i) throws IOException {
        write(i & 255);
    }

    @Override // java.io.DataOutput
    public final void writeBytes(String str) throws IOException {
        byte[] bArr = new byte[str.length()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                write(bArr);
                return;
            } else {
                bArr[i2] = (byte) (str.charAt(i2) & 255);
                i = i2 + 1;
            }
        }
    }

    @Override // java.io.DataOutput
    public final void writeChar(int i) throws IOException {
        writeShort(i);
    }

    @Override // java.io.DataOutput
    public final void writeChars(String str) throws IOException {
        write(str.getBytes(CharEncoding.UTF_16BE));
    }

    @Override // java.io.DataOutput
    public final void writeDouble(double d) throws IOException {
        writeLong(Double.doubleToLongBits(d));
    }

    @Override // java.io.DataOutput
    public final void writeFloat(float f) throws IOException {
        writeInt(Float.floatToIntBits(f));
    }

    @Override // java.io.DataOutput
    public final void writeInt(int i) throws IOException {
        Memory.pokeInt(this.scratch, 0, i, ByteOrder.BIG_ENDIAN);
        write(this.scratch, 0, 4);
    }

    @Override // java.io.DataOutput
    public final void writeLong(long j) throws IOException {
        Memory.pokeLong(this.scratch, 0, j, ByteOrder.BIG_ENDIAN);
        write(this.scratch, 0, 8);
    }

    @Override // java.io.DataOutput
    public final void writeShort(int i) throws IOException {
        Memory.pokeShort(this.scratch, 0, (short) i, ByteOrder.BIG_ENDIAN);
        write(this.scratch, 0, 2);
    }

    @Override // java.io.DataOutput
    public final void writeUTF(String str) throws IOException {
        write(ModifiedUtf8.encode(str));
    }
}
