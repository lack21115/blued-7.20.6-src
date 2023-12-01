package com.tencent.cloud.huiyansdkface.okhttp3.internal.cache2;

import com.tencent.cloud.huiyansdkface.okio.Buffer;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/cache2/FileOperator.class */
final class FileOperator {

    /* renamed from: a  reason: collision with root package name */
    private final FileChannel f35927a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileOperator(FileChannel fileChannel) {
        this.f35927a = fileChannel;
    }

    public void read(long j, Buffer buffer, long j2) throws IOException {
        if (j2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (j2 > 0) {
            long transferTo = this.f35927a.transferTo(j, j2, buffer);
            j += transferTo;
            j2 -= transferTo;
        }
    }

    public void write(long j, Buffer buffer, long j2) throws IOException {
        if (j2 < 0 || j2 > buffer.size()) {
            throw new IndexOutOfBoundsException();
        }
        long j3 = j;
        long j4 = j2;
        while (true) {
            long j5 = j4;
            if (j5 <= 0) {
                return;
            }
            long transferFrom = this.f35927a.transferFrom(buffer, j3, j5);
            j3 += transferFrom;
            j4 = j5 - transferFrom;
        }
    }
}
