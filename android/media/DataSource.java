package android.media;

import java.io.Closeable;

/* loaded from: source-9557208-dex2jar.jar:android/media/DataSource.class */
public interface DataSource extends Closeable {
    long getSize();

    int readAt(long j, byte[] bArr, int i);
}
