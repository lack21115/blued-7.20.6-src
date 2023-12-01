package java.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/io/OutputStreamWriter.class */
public class OutputStreamWriter extends Writer {
    private ByteBuffer bytes;
    private CharsetEncoder encoder;
    private final OutputStream out;

    public OutputStreamWriter(OutputStream outputStream) {
        this(outputStream, Charset.defaultCharset());
    }

    public OutputStreamWriter(OutputStream outputStream, String str) throws UnsupportedEncodingException {
        super(outputStream);
        this.bytes = ByteBuffer.allocate(8192);
        if (str == null) {
            throw new NullPointerException("charsetName == null");
        }
        this.out = outputStream;
        try {
            this.encoder = Charset.forName(str).newEncoder();
            this.encoder.onMalformedInput(CodingErrorAction.REPLACE);
            this.encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
        } catch (Exception e) {
            throw new UnsupportedEncodingException(str);
        }
    }

    public OutputStreamWriter(OutputStream outputStream, Charset charset) {
        super(outputStream);
        this.bytes = ByteBuffer.allocate(8192);
        this.out = outputStream;
        this.encoder = charset.newEncoder();
        this.encoder.onMalformedInput(CodingErrorAction.REPLACE);
        this.encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
    }

    public OutputStreamWriter(OutputStream outputStream, CharsetEncoder charsetEncoder) {
        super(outputStream);
        this.bytes = ByteBuffer.allocate(8192);
        charsetEncoder.charset();
        this.out = outputStream;
        this.encoder = charsetEncoder;
    }

    private void checkStatus() throws IOException {
        if (this.encoder == null) {
            throw new IOException("OutputStreamWriter is closed");
        }
    }

    private void convert(CharBuffer charBuffer) throws IOException {
        CoderResult encode;
        while (true) {
            encode = this.encoder.encode(charBuffer, this.bytes, false);
            if (!encode.isOverflow()) {
                break;
            }
            flushBytes(false);
        }
        if (encode.isError()) {
            encode.throwException();
        }
    }

    private void drainEncoder() throws IOException {
        CharBuffer allocate = CharBuffer.allocate(0);
        while (true) {
            CoderResult encode = this.encoder.encode(allocate, this.bytes, true);
            if (!encode.isError()) {
                if (!encode.isOverflow()) {
                    break;
                }
                flushBytes(false);
            } else {
                encode.throwException();
                break;
            }
        }
        CoderResult flush = this.encoder.flush(this.bytes);
        while (!flush.isUnderflow()) {
            if (flush.isOverflow()) {
                flushBytes(false);
                flush = this.encoder.flush(this.bytes);
            } else {
                flush.throwException();
            }
        }
    }

    private void flushBytes(boolean z) throws IOException {
        synchronized (this.lock) {
            checkStatus();
            int position = this.bytes.position();
            if (position > 0) {
                this.bytes.flip();
                this.out.write(this.bytes.array(), this.bytes.arrayOffset(), position);
                this.bytes.clear();
            }
            if (z) {
                this.out.flush();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.io.Writer
    public boolean checkError() {
        return this.out.checkError();
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.lock) {
            if (this.encoder != null) {
                drainEncoder();
                flushBytes(false);
                this.out.close();
                this.encoder = null;
                this.bytes = null;
            }
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        flushBytes(true);
    }

    public String getEncoding() {
        if (this.encoder == null) {
            return null;
        }
        return this.encoder.charset().name();
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        synchronized (this.lock) {
            checkStatus();
            convert(CharBuffer.wrap(new char[]{(char) i}));
        }
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) throws IOException {
        synchronized (this.lock) {
            if (i2 < 0) {
                throw new StringIndexOutOfBoundsException(str, i, i2);
            }
            if (str == null) {
                throw new NullPointerException("str == null");
            }
            if ((i | i2) < 0 || i > str.length() - i2) {
                throw new StringIndexOutOfBoundsException(str, i, i2);
            }
            checkStatus();
            convert(CharBuffer.wrap(str, i, i2 + i));
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        synchronized (this.lock) {
            checkStatus();
            Arrays.checkOffsetAndCount(cArr.length, i, i2);
            convert(CharBuffer.wrap(cArr, i, i2));
        }
    }
}
