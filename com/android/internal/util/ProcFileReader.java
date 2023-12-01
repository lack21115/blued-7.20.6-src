package com.android.internal.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.nio.charset.StandardCharsets;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/ProcFileReader.class */
public class ProcFileReader implements Closeable {
    private final byte[] mBuffer;
    private boolean mLineFinished;
    private final InputStream mStream;
    private int mTail;

    public ProcFileReader(InputStream inputStream) throws IOException {
        this(inputStream, 4096);
    }

    public ProcFileReader(InputStream inputStream, int i) throws IOException {
        this.mStream = inputStream;
        this.mBuffer = new byte[i];
        fillBuf();
    }

    private void consumeBuf(int i) throws IOException {
        System.arraycopy(this.mBuffer, i, this.mBuffer, 0, this.mTail - i);
        this.mTail -= i;
        if (this.mTail == 0) {
            fillBuf();
        }
    }

    private int fillBuf() throws IOException {
        int length = this.mBuffer.length - this.mTail;
        if (length == 0) {
            throw new IOException("attempting to fill already-full buffer");
        }
        int read = this.mStream.read(this.mBuffer, this.mTail, length);
        if (read != -1) {
            this.mTail += read;
        }
        return read;
    }

    private NumberFormatException invalidLong(int i) {
        return new NumberFormatException("invalid long: " + new String(this.mBuffer, 0, i, StandardCharsets.US_ASCII));
    }

    private int nextTokenIndex() throws IOException {
        int i;
        if (this.mLineFinished) {
            i = -1;
        } else {
            int i2 = 0;
            while (true) {
                if (i2 < this.mTail) {
                    byte b = this.mBuffer[i2];
                    if (b != 10) {
                        i = i2;
                        if (b == 32) {
                            break;
                        }
                        i2++;
                    } else {
                        this.mLineFinished = true;
                        return i2;
                    }
                } else if (fillBuf() <= 0) {
                    throw new ProtocolException("End of stream while looking for token boundary");
                }
            }
        }
        return i;
    }

    private long parseAndConsumeLong(int i) throws IOException {
        int i2 = 1;
        boolean z = this.mBuffer[0] == 45;
        long j = 0;
        if (!z) {
            i2 = 0;
        }
        while (i2 < i) {
            int i3 = this.mBuffer[i2] - 48;
            if (i3 < 0 || i3 > 9) {
                throw invalidLong(i);
            }
            long j2 = (10 * j) - i3;
            if (j2 > j) {
                throw invalidLong(i);
            }
            j = j2;
            i2++;
        }
        consumeBuf(i + 1);
        return z ? j : -j;
    }

    private String parseAndConsumeString(int i) throws IOException {
        String str = new String(this.mBuffer, 0, i, StandardCharsets.US_ASCII);
        consumeBuf(i + 1);
        return str;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mStream.close();
    }

    public void finishLine() throws IOException {
        if (this.mLineFinished) {
            this.mLineFinished = false;
            return;
        }
        int i = 0;
        while (true) {
            if (i < this.mTail) {
                if (this.mBuffer[i] == 10) {
                    consumeBuf(i + 1);
                    return;
                }
                i++;
            } else if (fillBuf() <= 0) {
                throw new ProtocolException("End of stream while looking for line boundary");
            }
        }
    }

    public boolean hasMoreData() {
        return this.mTail > 0;
    }

    public int nextInt() throws IOException {
        long nextLong = nextLong();
        if (nextLong > 2147483647L || nextLong < -2147483648L) {
            throw new NumberFormatException("parsed value larger than integer");
        }
        return (int) nextLong;
    }

    public long nextLong() throws IOException {
        int nextTokenIndex = nextTokenIndex();
        if (nextTokenIndex == -1) {
            throw new ProtocolException("Missing required long");
        }
        return parseAndConsumeLong(nextTokenIndex);
    }

    public long nextOptionalLong(long j) throws IOException {
        int nextTokenIndex = nextTokenIndex();
        return nextTokenIndex == -1 ? j : parseAndConsumeLong(nextTokenIndex);
    }

    public String nextString() throws IOException {
        int nextTokenIndex = nextTokenIndex();
        if (nextTokenIndex == -1) {
            throw new ProtocolException("Missing required string");
        }
        return parseAndConsumeString(nextTokenIndex);
    }
}
