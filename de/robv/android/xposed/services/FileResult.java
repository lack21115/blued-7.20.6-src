package de.robv.android.xposed.services;

import com.alipay.sdk.util.i;
import java.io.InputStream;

/* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/services/FileResult.class */
public final class FileResult {
    public final byte[] content;
    public final long mtime;
    public final long size;
    public final InputStream stream;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileResult(long j, long j2) {
        this.content = null;
        this.stream = null;
        this.size = j;
        this.mtime = j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileResult(InputStream inputStream, long j, long j2) {
        this.content = null;
        this.stream = inputStream;
        this.size = j;
        this.mtime = j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileResult(byte[] bArr, long j, long j2) {
        this.content = bArr;
        this.stream = null;
        this.size = j;
        this.mtime = j2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (this.content != null) {
            sb.append("content.length: ");
            sb.append(this.content.length);
            sb.append(", ");
        }
        if (this.stream != null) {
            sb.append("stream: ");
            sb.append(this.stream.toString());
            sb.append(", ");
        }
        sb.append("size: ");
        sb.append(this.size);
        sb.append(", mtime: ");
        sb.append(this.mtime);
        sb.append(i.d);
        return sb.toString();
    }
}
