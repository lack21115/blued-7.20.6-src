package java.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/io/InputStreamReader.class */
public class InputStreamReader extends Reader {
    private final ByteBuffer bytes;
    private CharsetDecoder decoder;
    private boolean endOfInput;

    /* renamed from: in  reason: collision with root package name */
    private InputStream f42256in;

    public InputStreamReader(InputStream inputStream) {
        this(inputStream, Charset.defaultCharset());
    }

    public InputStreamReader(InputStream inputStream, String str) throws UnsupportedEncodingException {
        super(inputStream);
        this.endOfInput = false;
        this.bytes = ByteBuffer.allocate(8192);
        if (str == null) {
            throw new NullPointerException("charsetName == null");
        }
        this.f42256in = inputStream;
        try {
            this.decoder = Charset.forName(str).newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
            this.bytes.limit(0);
        } catch (IllegalArgumentException e) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e));
        }
    }

    public InputStreamReader(InputStream inputStream, Charset charset) {
        super(inputStream);
        this.endOfInput = false;
        this.bytes = ByteBuffer.allocate(8192);
        this.f42256in = inputStream;
        this.decoder = charset.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        this.bytes.limit(0);
    }

    public InputStreamReader(InputStream inputStream, CharsetDecoder charsetDecoder) {
        super(inputStream);
        this.endOfInput = false;
        this.bytes = ByteBuffer.allocate(8192);
        charsetDecoder.averageCharsPerByte();
        this.f42256in = inputStream;
        this.decoder = charsetDecoder;
        this.bytes.limit(0);
    }

    private boolean isOpen() {
        return this.f42256in != null;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.lock) {
            if (this.decoder != null) {
                this.decoder.reset();
            }
            this.decoder = null;
            if (this.f42256in != null) {
                this.f42256in.close();
                this.f42256in = null;
            }
        }
    }

    public String getEncoding() {
        if (isOpen()) {
            return this.decoder.charset().name();
        }
        return null;
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        char c2 = 65535;
        synchronized (this.lock) {
            if (!isOpen()) {
                throw new IOException("InputStreamReader is closed");
            }
            char[] cArr = new char[1];
            if (read(cArr, 0, 1) != -1) {
                c2 = cArr[0];
            }
        }
        return c2;
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        CoderResult coderResult;
        synchronized (this.lock) {
            if (isOpen()) {
                Arrays.checkOffsetAndCount(cArr.length, i, i2);
                if (i2 == 0) {
                    return 0;
                }
                CharBuffer wrap = CharBuffer.wrap(cArr, i, i2);
                CoderResult coderResult2 = CoderResult.UNDERFLOW;
                boolean z = !this.bytes.hasRemaining();
                while (true) {
                    boolean z2 = z;
                    coderResult = coderResult2;
                    if (!wrap.hasRemaining()) {
                        break;
                    }
                    if (z2) {
                        try {
                            if (this.f42256in.available() == 0 && wrap.position() > i) {
                                coderResult = coderResult2;
                                break;
                            }
                        } catch (IOException e) {
                        }
                        int read = this.f42256in.read(this.bytes.array(), this.bytes.arrayOffset() + this.bytes.limit(), this.bytes.capacity() - this.bytes.limit());
                        if (read != -1) {
                            coderResult = coderResult2;
                            if (read == 0) {
                                break;
                            }
                            this.bytes.limit(this.bytes.limit() + read);
                        } else {
                            this.endOfInput = true;
                            coderResult = coderResult2;
                            break;
                        }
                    }
                    coderResult2 = this.decoder.decode(this.bytes, wrap, false);
                    coderResult = coderResult2;
                    if (!coderResult2.isUnderflow()) {
                        break;
                    }
                    if (this.bytes.limit() == this.bytes.capacity()) {
                        this.bytes.compact();
                        this.bytes.limit(this.bytes.position());
                        this.bytes.position(0);
                    }
                    z = true;
                }
                CoderResult coderResult3 = coderResult;
                if (coderResult == CoderResult.UNDERFLOW) {
                    coderResult3 = coderResult;
                    if (this.endOfInput) {
                        CoderResult decode = this.decoder.decode(this.bytes, wrap, true);
                        CoderResult coderResult4 = decode;
                        if (decode == CoderResult.UNDERFLOW) {
                            coderResult4 = this.decoder.flush(wrap);
                        }
                        this.decoder.reset();
                        coderResult3 = coderResult4;
                    }
                }
                if (coderResult3.isMalformed() || coderResult3.isUnmappable()) {
                    coderResult3.throwException();
                }
                return wrap.position() - i == 0 ? -1 : wrap.position() - i;
            }
            throw new IOException("InputStreamReader is closed");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
        if (r4.f42256in.available() > 0) goto L19;
     */
    @Override // java.io.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean ready() throws java.io.IOException {
        /*
            r4 = this;
            r0 = 0
            r6 = r0
            r0 = r4
            java.lang.Object r0 = r0.lock
            r7 = r0
            r0 = r7
            monitor-enter(r0)
            r0 = r4
            java.io.InputStream r0 = r0.f42256in     // Catch: java.lang.Throwable -> L1a
            if (r0 != 0) goto L21
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> L1a
            r1 = r0
            java.lang.String r2 = "InputStreamReader is closed"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L1a
            throw r0     // Catch: java.lang.Throwable -> L1a
        L1a:
            r8 = move-exception
            r0 = r7
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1a
            r0 = r8
            throw r0
        L21:
            r0 = r4
            java.nio.ByteBuffer r0 = r0.bytes     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L3d
            boolean r0 = r0.hasRemaining()     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L3d
            if (r0 != 0) goto L37
            r0 = r4
            java.io.InputStream r0 = r0.f42256in     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L3d
            int r0 = r0.available()     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L3d
            r5 = r0
            r0 = r5
            if (r0 <= 0) goto L39
        L37:
            r0 = 1
            r6 = r0
        L39:
            r0 = r7
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1a
            r0 = r6
            return r0
        L3d:
            r8 = move-exception
            r0 = r7
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1a
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.InputStreamReader.ready():boolean");
    }
}
