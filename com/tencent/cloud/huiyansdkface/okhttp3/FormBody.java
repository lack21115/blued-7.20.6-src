package com.tencent.cloud.huiyansdkface.okhttp3;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSink;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/FormBody.class */
public final class FormBody extends RequestBody {

    /* renamed from: a  reason: collision with root package name */
    private static final MediaType f35851a = MediaType.get("application/x-www-form-urlencoded");
    private final List<String> b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f35852c;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/FormBody$Builder.class */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f35853a;
        private final List<String> b;

        /* renamed from: c  reason: collision with root package name */
        private final Charset f35854c;

        public Builder() {
            this(null);
        }

        public Builder(Charset charset) {
            this.f35853a = new ArrayList();
            this.b = new ArrayList();
            this.f35854c = charset;
        }

        public Builder add(String str, String str2) {
            if (str != null) {
                if (str2 != null) {
                    this.f35853a.add(HttpUrl.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f35854c));
                    this.b.add(HttpUrl.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f35854c));
                    return this;
                }
                throw new NullPointerException("value == null");
            }
            throw new NullPointerException("name == null");
        }

        public Builder addEncoded(String str, String str2) {
            if (str != null) {
                if (str2 != null) {
                    this.f35853a.add(HttpUrl.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f35854c));
                    this.b.add(HttpUrl.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f35854c));
                    return this;
                }
                throw new NullPointerException("value == null");
            }
            throw new NullPointerException("name == null");
        }

        public FormBody build() {
            return new FormBody(this.f35853a, this.b);
        }
    }

    FormBody(List<String> list, List<String> list2) {
        this.b = Util.immutableList(list);
        this.f35852c = Util.immutableList(list2);
    }

    private long a(BufferedSink bufferedSink, boolean z) {
        Buffer buffer = z ? new Buffer() : bufferedSink.buffer();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8(this.b.get(i));
            buffer.writeByte(61);
            buffer.writeUtf8(this.f35852c.get(i));
        }
        if (z) {
            long size2 = buffer.size();
            buffer.clear();
            return size2;
        }
        return 0L;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
    public long contentLength() {
        return a(null, true);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
    public MediaType contentType() {
        return f35851a;
    }

    public String encodedName(int i) {
        return this.b.get(i);
    }

    public String encodedValue(int i) {
        return this.f35852c.get(i);
    }

    public String name(int i) {
        return HttpUrl.a(encodedName(i), true);
    }

    public int size() {
        return this.b.size();
    }

    public String value(int i) {
        return HttpUrl.a(encodedValue(i), true);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        a(bufferedSink, false);
    }
}
