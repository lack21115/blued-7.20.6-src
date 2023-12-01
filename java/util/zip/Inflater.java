package java.util.zip;

import dalvik.system.CloseGuard;
import java.io.FileDescriptor;
import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/util/zip/Inflater.class */
public class Inflater {
    private boolean finished;
    private final CloseGuard guard;
    private int inLength;
    private int inRead;
    private boolean needsDictionary;
    private long streamHandle;

    public Inflater() {
        this(false);
    }

    public Inflater(boolean z) {
        this.streamHandle = -1L;
        this.guard = CloseGuard.get();
        this.streamHandle = createStream(z);
        this.guard.open("end");
    }

    private void checkOpen() {
        if (this.streamHandle == -1) {
            throw new IllegalStateException("attempt to use Inflater after calling end");
        }
    }

    private native long createStream(boolean z);

    private native void endImpl(long j);

    private native int getAdlerImpl(long j);

    private native long getTotalInImpl(long j);

    private native long getTotalOutImpl(long j);

    private native int inflateImpl(byte[] bArr, int i, int i2, long j);

    private native void resetImpl(long j);

    private native void setDictionaryImpl(byte[] bArr, int i, int i2, long j);

    private native int setFileInputImpl(FileDescriptor fileDescriptor, long j, int i, long j2);

    private native void setInputImpl(byte[] bArr, int i, int i2, long j);

    public void end() {
        synchronized (this) {
            this.guard.close();
            if (this.streamHandle != -1) {
                endImpl(this.streamHandle);
                this.inRead = 0;
                this.inLength = 0;
                this.streamHandle = -1L;
            }
        }
    }

    protected void finalize() {
        AssertionError assertionError;
        try {
            if (this.guard != null) {
                this.guard.warnIfOpen();
            }
            end();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentOffset() {
        int i;
        synchronized (this) {
            i = this.inRead;
        }
        return i;
    }

    public int getRemaining() {
        int i;
        int i2;
        synchronized (this) {
            i = this.inLength;
            i2 = this.inRead;
        }
        return i - i2;
    }

    public int getTotalIn() {
        int min;
        synchronized (this) {
            checkOpen();
            min = (int) Math.min(getTotalInImpl(this.streamHandle), 2147483647L);
        }
        return min;
    }

    public int getTotalOut() {
        int min;
        synchronized (this) {
            checkOpen();
            min = (int) Math.min(getTotalOutImpl(this.streamHandle), 2147483647L);
        }
        return min;
    }

    public int inflate(byte[] bArr) throws DataFormatException {
        return inflate(bArr, 0, bArr.length);
    }

    public int inflate(byte[] bArr, int i, int i2) throws DataFormatException {
        int i3;
        synchronized (this) {
            Arrays.checkOffsetAndCount(bArr.length, i, i2);
            checkOpen();
            if (needsInput()) {
                i3 = 0;
            } else {
                boolean z = this.needsDictionary;
                this.needsDictionary = false;
                int inflateImpl = inflateImpl(bArr, i, i2, this.streamHandle);
                i3 = inflateImpl;
                if (this.needsDictionary) {
                    i3 = inflateImpl;
                    if (z) {
                        throw new DataFormatException("Needs dictionary");
                    }
                }
            }
        }
        return i3;
    }

    public boolean needsDictionary() {
        boolean z;
        synchronized (this) {
            z = this.needsDictionary;
        }
        return z;
    }

    public boolean needsInput() {
        boolean z;
        synchronized (this) {
            z = this.inRead == this.inLength;
        }
        return z;
    }

    public void reset() {
        synchronized (this) {
            checkOpen();
            this.finished = false;
            this.needsDictionary = false;
            this.inRead = 0;
            this.inLength = 0;
            resetImpl(this.streamHandle);
        }
    }

    public void setDictionary(byte[] bArr) {
        synchronized (this) {
            setDictionary(bArr, 0, bArr.length);
        }
    }

    public void setDictionary(byte[] bArr, int i, int i2) {
        synchronized (this) {
            checkOpen();
            Arrays.checkOffsetAndCount(bArr.length, i, i2);
            setDictionaryImpl(bArr, i, i2, this.streamHandle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int setFileInput(FileDescriptor fileDescriptor, long j, int i) {
        int i2;
        synchronized (this) {
            checkOpen();
            this.inRead = 0;
            this.inLength = setFileInputImpl(fileDescriptor, j, i, this.streamHandle);
            i2 = this.inLength;
        }
        return i2;
    }

    public void setInput(byte[] bArr) {
        synchronized (this) {
            setInput(bArr, 0, bArr.length);
        }
    }

    public void setInput(byte[] bArr, int i, int i2) {
        synchronized (this) {
            checkOpen();
            Arrays.checkOffsetAndCount(bArr.length, i, i2);
            this.inRead = 0;
            this.inLength = i2;
            setInputImpl(bArr, i, i2, this.streamHandle);
        }
    }
}
