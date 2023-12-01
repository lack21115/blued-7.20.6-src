package androidx.core.util;

import android.util.Log;
import java.io.Writer;

@Deprecated
/* loaded from: source-8756600-dex2jar.jar:androidx/core/util/LogWriter.class */
public class LogWriter extends Writer {

    /* renamed from: a  reason: collision with root package name */
    private final String f2548a;
    private StringBuilder b = new StringBuilder(128);

    public LogWriter(String str) {
        this.f2548a = str;
    }

    private void a() {
        if (this.b.length() > 0) {
            Log.d(this.f2548a, this.b.toString());
            StringBuilder sb = this.b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
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
                a();
            } else {
                this.b.append(c2);
            }
            i3 = i4 + 1;
        }
    }
}
