package com.tencent.cloud.huiyansdkface.okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okio/Okio.class */
public final class Okio {
    static final Logger logger = Logger.getLogger(Okio.class.getName());

    private Okio() {
    }

    public static Sink appendingSink(File file) throws FileNotFoundException {
        if (file != null) {
            return sink(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink blackhole() {
        return new Sink() { // from class: com.tencent.cloud.huiyansdkface.okio.Okio.3
            @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
            }

            @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Flushable
            public void flush() throws IOException {
            }

            @Override // com.tencent.cloud.huiyansdkface.okio.Sink
            public Timeout timeout() {
                return Timeout.NONE;
            }

            @Override // com.tencent.cloud.huiyansdkface.okio.Sink
            public void write(Buffer buffer, long j) throws IOException {
                buffer.skip(j);
            }
        };
    }

    public static BufferedSink buffer(Sink sink) {
        return new RealBufferedSink(sink);
    }

    public static BufferedSource buffer(Source source) {
        return new RealBufferedSource(source);
    }

    static boolean isAndroidGetsocknameError(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static Sink sink(File file) throws FileNotFoundException {
        if (file != null) {
            return sink(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink sink(OutputStream outputStream) {
        return sink(outputStream, new Timeout());
    }

    private static Sink sink(final OutputStream outputStream, final Timeout timeout) {
        if (outputStream != null) {
            if (timeout != null) {
                return new Sink() { // from class: com.tencent.cloud.huiyansdkface.okio.Okio.1
                    @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                    public void close() throws IOException {
                        outputStream.close();
                    }

                    @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Flushable
                    public void flush() throws IOException {
                        outputStream.flush();
                    }

                    @Override // com.tencent.cloud.huiyansdkface.okio.Sink
                    public Timeout timeout() {
                        return Timeout.this;
                    }

                    public String toString() {
                        return "sink(" + outputStream + ")";
                    }

                    @Override // com.tencent.cloud.huiyansdkface.okio.Sink
                    public void write(Buffer buffer, long j) throws IOException {
                        Util.checkOffsetAndCount(buffer.size, 0L, j);
                        while (j > 0) {
                            Timeout.this.throwIfReached();
                            Segment segment = buffer.head;
                            int min = (int) Math.min(j, segment.limit - segment.pos);
                            outputStream.write(segment.data, segment.pos, min);
                            segment.pos += min;
                            long j2 = min;
                            long j3 = j - j2;
                            buffer.size -= j2;
                            j = j3;
                            if (segment.pos == segment.limit) {
                                buffer.head = segment.pop();
                                SegmentPool.recycle(segment);
                                j = j3;
                            }
                        }
                    }
                };
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("out == null");
    }

    public static Sink sink(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getOutputStream() != null) {
                AsyncTimeout timeout = timeout(socket);
                return timeout.sink(sink(socket.getOutputStream(), timeout));
            }
            throw new IOException("socket's output stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static Sink sink(Path path, OpenOption... openOptionArr) throws IOException {
        if (path != null) {
            return sink(Files.newOutputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    public static Source source(File file) throws FileNotFoundException {
        if (file != null) {
            return source(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Source source(InputStream inputStream) {
        return source(inputStream, new Timeout());
    }

    private static Source source(final InputStream inputStream, final Timeout timeout) {
        if (inputStream != null) {
            if (timeout != null) {
                return new Source() { // from class: com.tencent.cloud.huiyansdkface.okio.Okio.2
                    @Override // com.tencent.cloud.huiyansdkface.okio.Source, java.io.Closeable, java.lang.AutoCloseable
                    public void close() throws IOException {
                        inputStream.close();
                    }

                    @Override // com.tencent.cloud.huiyansdkface.okio.Source
                    public long read(Buffer buffer, long j) throws IOException {
                        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                        if (i < 0) {
                            throw new IllegalArgumentException("byteCount < 0: " + j);
                        } else if (i == 0) {
                            return 0L;
                        } else {
                            try {
                                Timeout.this.throwIfReached();
                                Segment writableSegment = buffer.writableSegment(1);
                                int read = inputStream.read(writableSegment.data, writableSegment.limit, (int) Math.min(j, 8192 - writableSegment.limit));
                                if (read == -1) {
                                    return -1L;
                                }
                                writableSegment.limit += read;
                                long j2 = read;
                                buffer.size += j2;
                                return j2;
                            } catch (AssertionError e) {
                                if (Okio.isAndroidGetsocknameError(e)) {
                                    throw new IOException(e);
                                }
                                throw e;
                            }
                        }
                    }

                    @Override // com.tencent.cloud.huiyansdkface.okio.Source
                    public Timeout timeout() {
                        return Timeout.this;
                    }

                    public String toString() {
                        return "source(" + inputStream + ")";
                    }
                };
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("in == null");
    }

    public static Source source(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getInputStream() != null) {
                AsyncTimeout timeout = timeout(socket);
                return timeout.source(source(socket.getInputStream(), timeout));
            }
            throw new IOException("socket's input stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static Source source(Path path, OpenOption... openOptionArr) throws IOException {
        if (path != null) {
            return source(Files.newInputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    private static AsyncTimeout timeout(final Socket socket) {
        return new AsyncTimeout() { // from class: com.tencent.cloud.huiyansdkface.okio.Okio.4
            @Override // com.tencent.cloud.huiyansdkface.okio.AsyncTimeout
            protected IOException newTimeoutException(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.cloud.huiyansdkface.okio.AsyncTimeout
            protected void timedOut() {
                Logger logger2;
                Level level;
                StringBuilder sb;
                Exception exc;
                try {
                    socket.close();
                } catch (AssertionError e) {
                    if (!Okio.isAndroidGetsocknameError(e)) {
                        throw e;
                    }
                    logger2 = Okio.logger;
                    level = Level.WARNING;
                    sb = new StringBuilder();
                    exc = e;
                    sb.append("Failed to close timed out socket ");
                    sb.append(socket);
                    logger2.log(level, sb.toString(), (Throwable) exc);
                } catch (Exception e2) {
                    logger2 = Okio.logger;
                    level = Level.WARNING;
                    sb = new StringBuilder();
                    exc = e2;
                    sb.append("Failed to close timed out socket ");
                    sb.append(socket);
                    logger2.log(level, sb.toString(), (Throwable) exc);
                }
            }
        };
    }
}
