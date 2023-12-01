package java.io;

import java.nio.ByteOrder;
import java.nio.charset.ModifiedUtf8;
import libcore.io.Memory;
import org.apache.commons.codec.CharEncoding;

/* loaded from: source-2895416-dex2jar.jar:java/io/DataOutputStream.class */
public class DataOutputStream extends FilterOutputStream implements DataOutput {
    private final byte[] scratch;
    protected int written;

    public DataOutputStream(OutputStream outputStream) {
        super(outputStream);
        this.scratch = new byte[8];
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        super.flush();
    }

    public final int size() {
        if (this.written < 0) {
            this.written = Integer.MAX_VALUE;
        }
        return this.written;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        this.out.write(i);
        this.written++;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (bArr == null) {
            throw new NullPointerException("buffer == null");
        }
        this.out.write(bArr, i, i2);
        this.written += i2;
    }

    @Override // java.io.DataOutput
    public final void writeBoolean(boolean z) throws IOException {
        this.out.write(z ? 1 : 0);
        this.written++;
    }

    @Override // java.io.DataOutput
    public final void writeByte(int i) throws IOException {
        this.out.write(i);
        this.written++;
    }

    @Override // java.io.DataOutput
    public final void writeBytes(String str) throws IOException {
        if (str.length() == 0) {
            return;
        }
        byte[] bArr = new byte[str.length()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                this.out.write(bArr);
                this.written += bArr.length;
                return;
            }
            bArr[i2] = (byte) str.charAt(i2);
            i = i2 + 1;
        }
    }

    @Override // java.io.DataOutput
    public final void writeChar(int i) throws IOException {
        writeShort(i);
    }

    @Override // java.io.DataOutput
    public final void writeChars(String str) throws IOException {
        byte[] bytes = str.getBytes(CharEncoding.UTF_16BE);
        this.out.write(bytes);
        this.written += bytes.length;
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
        this.out.write(this.scratch, 0, 4);
        this.written += 4;
    }

    @Override // java.io.DataOutput
    public final void writeLong(long j) throws IOException {
        Memory.pokeLong(this.scratch, 0, j, ByteOrder.BIG_ENDIAN);
        this.out.write(this.scratch, 0, 8);
        this.written += 8;
    }

    @Override // java.io.DataOutput
    public final void writeShort(int i) throws IOException {
        Memory.pokeShort(this.scratch, 0, (short) i, ByteOrder.BIG_ENDIAN);
        this.out.write(this.scratch, 0, 2);
        this.written += 2;
    }

    @Override // java.io.DataOutput
    public final void writeUTF(String str) throws IOException {
        write(ModifiedUtf8.encode(str));
    }
}
