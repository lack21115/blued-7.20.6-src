package android.util;

import java.io.Writer;

/* loaded from: source-9557208-dex2jar.jar:android/util/LogWriter.class */
public class LogWriter extends Writer {
    private final int mBuffer;
    private StringBuilder mBuilder;
    private final int mPriority;
    private final String mTag;

    public LogWriter(int i, String str) {
        this.mBuilder = new StringBuilder(128);
        this.mPriority = i;
        this.mTag = str;
        this.mBuffer = 0;
    }

    public LogWriter(int i, String str, int i2) {
        this.mBuilder = new StringBuilder(128);
        this.mPriority = i;
        this.mTag = str;
        this.mBuffer = i2;
    }

    private void flushBuilder() {
        if (this.mBuilder.length() > 0) {
            Log.println_native(this.mBuffer, this.mPriority, this.mTag, this.mBuilder.toString());
            this.mBuilder.delete(0, this.mBuilder.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        flushBuilder();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        flushBuilder();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return;
            }
            char c2 = cArr[i + i4];
            if (c2 == '\n') {
                flushBuilder();
            } else {
                this.mBuilder.append(c2);
            }
            i3 = i4 + 1;
        }
    }
}
