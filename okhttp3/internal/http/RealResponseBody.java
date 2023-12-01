package okhttp3.internal.http;

import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http/RealResponseBody.class */
public final class RealResponseBody extends ResponseBody {
    @Nullable
    private final String a;
    private final long b;
    private final BufferedSource c;

    public RealResponseBody(@Nullable String str, long j, BufferedSource bufferedSource) {
        this.a = str;
        this.b = j;
        this.c = bufferedSource;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.b;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        String str = this.a;
        if (str != null) {
            return MediaType.parse(str);
        }
        return null;
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        return this.c;
    }
}
