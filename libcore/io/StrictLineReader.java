package libcore.io;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: source-2895416-dex2jar.jar:libcore/io/StrictLineReader.class */
public class StrictLineReader implements Closeable {
    private static final byte CR = 13;
    private static final byte LF = 10;
    private byte[] buf;
    private final Charset charset;
    private int end;

    /* renamed from: in  reason: collision with root package name */
    private final InputStream f43649in;
    private int pos;

    public StrictLineReader(InputStream inputStream) {
        this(inputStream, 8192);
    }

    public StrictLineReader(InputStream inputStream, int i) {
        this(inputStream, i, StandardCharsets.US_ASCII);
    }

    public StrictLineReader(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null) {
            throw new NullPointerException("in == null");
        }
        if (charset == null) {
            throw new NullPointerException("charset == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(StandardCharsets.US_ASCII) && !charset.equals(StandardCharsets.UTF_8) && !charset.equals(StandardCharsets.ISO_8859_1)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f43649in = inputStream;
        this.charset = charset;
        this.buf = new byte[i];
    }

    public StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void fillBuf() throws IOException {
        int read = this.f43649in.read(this.buf, 0, this.buf.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.pos = 0;
        this.end = read;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f43649in) {
            if (this.buf != null) {
                this.buf = null;
                this.f43649in.close();
            }
        }
    }

    public boolean hasUnterminatedLine() {
        return this.end == -1;
    }

    public int readInt() throws IOException {
        String readLine = readLine();
        try {
            return Integer.parseInt(readLine);
        } catch (NumberFormatException e) {
            throw new IOException("expected an int but was \"" + readLine + "\"");
        }
    }

    public String readLine() throws IOException {
        int i;
        synchronized (this.f43649in) {
            if (this.buf == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.pos >= this.end) {
                fillBuf();
            }
            int i2 = this.pos;
            while (true) {
                int i3 = i2;
                if (i3 == this.end) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.end - this.pos) + 80) { // from class: libcore.io.StrictLineReader.1
                        @Override // java.io.ByteArrayOutputStream
                        public String toString() {
                            return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count - 1] != 13) ? this.count : this.count - 1, StrictLineReader.this.charset);
                        }
                    };
                    loop1: while (true) {
                        byteArrayOutputStream.write(this.buf, this.pos, this.end - this.pos);
                        this.end = -1;
                        fillBuf();
                        int i4 = this.pos;
                        while (true) {
                            i = i4;
                            if (i != this.end) {
                                if (this.buf[i] == 10) {
                                    break loop1;
                                }
                                i4 = i + 1;
                            }
                        }
                    }
                    if (i != this.pos) {
                        byteArrayOutputStream.write(this.buf, this.pos, i - this.pos);
                    }
                    this.pos = i + 1;
                    return byteArrayOutputStream.toString();
                } else if (this.buf[i3] == 10) {
                    String str = new String(this.buf, this.pos, ((i3 == this.pos || this.buf[i3 - 1] != 13) ? i3 : i3 - 1) - this.pos, this.charset);
                    this.pos = i3 + 1;
                    return str;
                } else {
                    i2 = i3 + 1;
                }
            }
        }
    }
}
