package java.util.zip;

import dalvik.system.CloseGuard;
import java.util.Arrays;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:java/util/zip/Deflater.class */
public class Deflater {
    public static final int BEST_COMPRESSION = 9;
    public static final int BEST_SPEED = 1;
    public static final int DEFAULT_COMPRESSION = -1;
    public static final int DEFAULT_STRATEGY = 0;
    public static final int DEFLATED = 8;
    public static final int FILTERED = 1;
    private static final int FINISH = 4;
    public static final int FULL_FLUSH = 3;
    public static final int HUFFMAN_ONLY = 2;
    public static final int NO_COMPRESSION = 0;
    public static final int NO_FLUSH = 0;
    public static final int SYNC_FLUSH = 2;
    private int compressLevel;
    private boolean finished;
    private int flushParm;
    private final CloseGuard guard;
    private int inLength;
    private int inRead;
    private byte[] inputBuffer;
    private int strategy;
    private long streamHandle;

    public Deflater() {
        this(-1, false);
    }

    public Deflater(int i) {
        this(i, false);
    }

    public Deflater(int i, boolean z) {
        this.flushParm = 0;
        this.compressLevel = -1;
        this.strategy = 0;
        this.streamHandle = -1L;
        this.guard = CloseGuard.get();
        if (i < -1 || i > 9) {
            throw new IllegalArgumentException("Bad level: " + i);
        }
        this.compressLevel = i;
        this.streamHandle = createStream(this.compressLevel, this.strategy, z);
        this.guard.open("end");
    }

    private void checkOpen() {
        if (this.streamHandle == -1) {
            throw new IllegalStateException("attempt to use Deflater after calling end");
        }
    }

    private native long createStream(int i, int i2, boolean z);

    private int deflateImpl(byte[] bArr, int i, int i2, int i3) {
        int deflateImpl;
        synchronized (this) {
            checkOpen();
            Arrays.checkOffsetAndCount(bArr.length, i, i2);
            if (this.inputBuffer == null) {
                setInput(EmptyArray.BYTE);
            }
            deflateImpl = deflateImpl(bArr, i, i2, this.streamHandle, i3);
        }
        return deflateImpl;
    }

    private native int deflateImpl(byte[] bArr, int i, int i2, long j, int i3);

    private void endImpl() {
        if (this.streamHandle != -1) {
            endImpl(this.streamHandle);
            this.inputBuffer = null;
            this.streamHandle = -1L;
        }
    }

    private native void endImpl(long j);

    private native int getAdlerImpl(long j);

    private native long getTotalInImpl(long j);

    private native long getTotalOutImpl(long j);

    private native void resetImpl(long j);

    private native void setDictionaryImpl(byte[] bArr, int i, int i2, long j);

    private native void setInputImpl(byte[] bArr, int i, int i2, long j);

    private native void setLevelsImpl(int i, int i2, long j);

    public int deflate(byte[] bArr) {
        return deflate(bArr, 0, bArr.length);
    }

    public int deflate(byte[] bArr, int i, int i2) {
        int deflateImpl;
        synchronized (this) {
            deflateImpl = deflateImpl(bArr, i, i2, this.flushParm);
        }
        return deflateImpl;
    }

    public int deflate(byte[] bArr, int i, int i2, int i3) {
        int deflateImpl;
        synchronized (this) {
            if (i3 != 0 && i3 != 2 && i3 != 3) {
                throw new IllegalArgumentException("Bad flush value: " + i3);
            }
            deflateImpl = deflateImpl(bArr, i, i2, i3);
        }
        return deflateImpl;
    }

    public void end() {
        synchronized (this) {
            this.guard.close();
            endImpl();
        }
    }

    protected void finalize() {
        AssertionError assertionError;
        try {
            if (this.guard != null) {
                this.guard.warnIfOpen();
            }
            synchronized (this) {
                end();
                endImpl();
            }
            try {
                super.finalize();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.finalize();
                throw th;
            } finally {
            }
        }
    }

    public void finish() {
        synchronized (this) {
            this.flushParm = 4;
        }
    }

    public boolean finished() {
        boolean z;
        synchronized (this) {
            z = this.finished;
        }
        return z;
    }

    public int getAdler() {
        int adlerImpl;
        synchronized (this) {
            checkOpen();
            adlerImpl = getAdlerImpl(this.streamHandle);
        }
        return adlerImpl;
    }

    public long getBytesRead() {
        long totalInImpl;
        synchronized (this) {
            checkOpen();
            totalInImpl = getTotalInImpl(this.streamHandle);
        }
        return totalInImpl;
    }

    public long getBytesWritten() {
        long totalOutImpl;
        synchronized (this) {
            checkOpen();
            totalOutImpl = getTotalOutImpl(this.streamHandle);
        }
        return totalOutImpl;
    }

    public int getTotalIn() {
        int totalInImpl;
        synchronized (this) {
            checkOpen();
            totalInImpl = (int) getTotalInImpl(this.streamHandle);
        }
        return totalInImpl;
    }

    public int getTotalOut() {
        int totalOutImpl;
        synchronized (this) {
            checkOpen();
            totalOutImpl = (int) getTotalOutImpl(this.streamHandle);
        }
        return totalOutImpl;
    }

    public boolean needsInput() {
        boolean z = true;
        synchronized (this) {
            if (this.inputBuffer != null) {
                if (this.inRead != this.inLength) {
                    z = false;
                }
            }
        }
        return z;
    }

    public void reset() {
        synchronized (this) {
            checkOpen();
            this.flushParm = 0;
            this.finished = false;
            resetImpl(this.streamHandle);
            this.inputBuffer = null;
        }
    }

    public void setDictionary(byte[] bArr) {
        setDictionary(bArr, 0, bArr.length);
    }

    public void setDictionary(byte[] bArr, int i, int i2) {
        synchronized (this) {
            checkOpen();
            Arrays.checkOffsetAndCount(bArr.length, i, i2);
            setDictionaryImpl(bArr, i, i2, this.streamHandle);
        }
    }

    public void setInput(byte[] bArr) {
        setInput(bArr, 0, bArr.length);
    }

    public void setInput(byte[] bArr, int i, int i2) {
        synchronized (this) {
            checkOpen();
            Arrays.checkOffsetAndCount(bArr.length, i, i2);
            this.inLength = i2;
            this.inRead = 0;
            if (this.inputBuffer == null) {
                setLevelsImpl(this.compressLevel, this.strategy, this.streamHandle);
            }
            this.inputBuffer = bArr;
            setInputImpl(bArr, i, i2, this.streamHandle);
        }
    }

    public void setLevel(int i) {
        synchronized (this) {
            if (i < -1 || i > 9) {
                throw new IllegalArgumentException("Bad level: " + i);
            }
            if (this.inputBuffer != null) {
                throw new IllegalStateException("setLevel cannot be called after setInput");
            }
            this.compressLevel = i;
        }
    }

    public void setStrategy(int i) {
        synchronized (this) {
            if (i < 0 || i > 2) {
                throw new IllegalArgumentException("Bad strategy: " + i);
            }
            if (this.inputBuffer != null) {
                throw new IllegalStateException("setStrategy cannot be called after setInput");
            }
            this.strategy = i;
        }
    }
}
