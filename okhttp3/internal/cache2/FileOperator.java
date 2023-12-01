package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import okio.Buffer;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/cache2/FileOperator.class */
final class FileOperator {

    /* renamed from: a  reason: collision with root package name */
    private final FileChannel f43863a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileOperator(FileChannel fileChannel) {
        this.f43863a = fileChannel;
    }

    public void a(long j, Buffer buffer, long j2) throws IOException {
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
            long transferFrom = this.f43863a.transferFrom(buffer, j3, j5);
            j3 += transferFrom;
            j4 = j5 - transferFrom;
        }
    }

    public void b(long j, Buffer buffer, long j2) throws IOException {
        if (j2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (j2 > 0) {
            long transferTo = this.f43863a.transferTo(j, j2, buffer);
            j += transferTo;
            j2 -= transferTo;
        }
    }
}
