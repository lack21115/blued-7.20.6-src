package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/PushObserver.class */
public interface PushObserver {
    public static final PushObserver a = new PushObserver() { // from class: okhttp3.internal.http2.PushObserver.1
        @Override // okhttp3.internal.http2.PushObserver
        public void a(int i, ErrorCode errorCode) {
        }

        @Override // okhttp3.internal.http2.PushObserver
        public boolean a(int i, List<Header> list) {
            return true;
        }

        @Override // okhttp3.internal.http2.PushObserver
        public boolean a(int i, List<Header> list, boolean z) {
            return true;
        }

        @Override // okhttp3.internal.http2.PushObserver
        public boolean a(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
            bufferedSource.skip(i2);
            return true;
        }
    };

    void a(int i, ErrorCode errorCode);

    boolean a(int i, List<Header> list);

    boolean a(int i, List<Header> list, boolean z);

    boolean a(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException;
}
