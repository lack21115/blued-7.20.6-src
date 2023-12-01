package okhttp3.internal.http;

import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http/RealResponseBody.class */
public final class RealResponseBody extends ResponseBody {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f43890a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final BufferedSource f43891c;

    public RealResponseBody(@Nullable String str, long j, BufferedSource bufferedSource) {
        this.f43890a = str;
        this.b = j;
        this.f43891c = bufferedSource;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.b;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        String str = this.f43890a;
        if (str != null) {
            return MediaType.parse(str);
        }
        return null;
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        return this.f43891c;
    }
}
