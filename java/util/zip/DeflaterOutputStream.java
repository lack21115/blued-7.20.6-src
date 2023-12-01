package java.util.zip;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import libcore.io.Streams;

/* loaded from: source-2895416-dex2jar.jar:java/util/zip/DeflaterOutputStream.class */
public class DeflaterOutputStream extends FilterOutputStream {
    static final int BUF_SIZE = 512;
    protected byte[] buf;
    protected Deflater def;
    boolean done;
    private final boolean syncFlush;

    public DeflaterOutputStream(OutputStream outputStream) {
        this(outputStream, new Deflater(), 512, false);
    }

    public DeflaterOutputStream(OutputStream outputStream, Deflater deflater) {
        this(outputStream, deflater, 512, false);
    }

    public DeflaterOutputStream(OutputStream outputStream, Deflater deflater, int i) {
        this(outputStream, deflater, i, false);
    }

    public DeflaterOutputStream(OutputStream outputStream, Deflater deflater, int i, boolean z) {
        super(outputStream);
        this.done = false;
        if (outputStream == null) {
            throw new NullPointerException("os == null");
        }
        if (deflater == null) {
            throw new NullPointerException("def == null");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("bufferSize <= 0: " + i);
        }
        this.def = deflater;
        this.syncFlush = z;
        this.buf = new byte[i];
    }

    public DeflaterOutputStream(OutputStream outputStream, Deflater deflater, boolean z) {
        this(outputStream, deflater, 512, z);
    }

    public DeflaterOutputStream(OutputStream outputStream, boolean z) {
        this(outputStream, new Deflater(), 512, z);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.def.finished()) {
            finish();
        }
        this.def.end();
        this.out.close();
    }

    protected void deflate() throws IOException {
        while (true) {
            int deflate = this.def.deflate(this.buf);
            if (deflate == 0) {
                return;
            }
            this.out.write(this.buf, 0, deflate);
        }
    }

    public void finish() throws IOException {
        if (this.done) {
            return;
        }
        this.def.finish();
        while (!this.def.finished()) {
            this.out.write(this.buf, 0, this.def.deflate(this.buf));
        }
        this.done = true;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.syncFlush && !this.done) {
            while (true) {
                int deflate = this.def.deflate(this.buf, 0, this.buf.length, 2);
                if (deflate == 0) {
                    break;
                }
                this.out.write(this.buf, 0, deflate);
            }
        }
        this.out.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        Streams.writeSingleByte(this, i);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.done) {
            throw new IOException("attempt to write after finish");
        }
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        if (!this.def.needsInput()) {
            throw new IOException();
        }
        this.def.setInput(bArr, i, i2);
        deflate();
    }
}
