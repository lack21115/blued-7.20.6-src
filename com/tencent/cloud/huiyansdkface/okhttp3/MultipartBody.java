package com.tencent.cloud.huiyansdkface.okhttp3;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSink;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/MultipartBody.class */
public final class MultipartBody extends RequestBody {

    /* renamed from: a  reason: collision with root package name */
    public static final MediaType f22174a = MediaType.get("multipart/mixed");
    public static final MediaType b = MediaType.get("multipart/alternative");

    /* renamed from: c  reason: collision with root package name */
    public static final MediaType f22175c = MediaType.get("multipart/digest");
    public static final MediaType d = MediaType.get("multipart/parallel");
    public static final MediaType e = MediaType.get(HttpConstants.ContentType.MULTIPART_FORM_DATA);
    private static final byte[] f = {58, 32};
    private static final byte[] g = {13, 10};
    private static final byte[] h = {45, 45};
    private final ByteString i;
    private final MediaType j;
    private final MediaType k;
    private final List<Part> l;
    private long m = -1;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/MultipartBody$Builder.class */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final ByteString f22176a;
        private MediaType b;

        /* renamed from: c  reason: collision with root package name */
        private final List<Part> f22177c;

        public Builder() {
            this(UUID.randomUUID().toString());
        }

        public Builder(String str) {
            this.b = MultipartBody.f22174a;
            this.f22177c = new ArrayList();
            this.f22176a = ByteString.encodeUtf8(str);
        }

        public Builder addFormDataPart(String str, String str2) {
            return addPart(Part.createFormData(str, str2));
        }

        public Builder addFormDataPart(String str, String str2, RequestBody requestBody) {
            return addPart(Part.createFormData(str, str2, requestBody));
        }

        public Builder addPart(Headers headers, RequestBody requestBody) {
            return addPart(Part.create(headers, requestBody));
        }

        public Builder addPart(Part part) {
            if (part != null) {
                this.f22177c.add(part);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        public Builder addPart(RequestBody requestBody) {
            return addPart(Part.create(requestBody));
        }

        public MultipartBody build() {
            if (this.f22177c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new MultipartBody(this.f22176a, this.b, this.f22177c);
        }

        public Builder setType(MediaType mediaType) {
            if (mediaType != null) {
                if (mediaType.type().equals("multipart")) {
                    this.b = mediaType;
                    return this;
                }
                throw new IllegalArgumentException("multipart != " + mediaType);
            }
            throw new NullPointerException("type == null");
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/MultipartBody$Part.class */
    public static final class Part {

        /* renamed from: a  reason: collision with root package name */
        final Headers f22178a;
        final RequestBody b;

        private Part(Headers headers, RequestBody requestBody) {
            this.f22178a = headers;
            this.b = requestBody;
        }

        public static Part create(Headers headers, RequestBody requestBody) {
            if (requestBody != null) {
                if (headers == null || headers.get("Content-Type") == null) {
                    if (headers == null || headers.get("Content-Length") == null) {
                        return new Part(headers, requestBody);
                    }
                    throw new IllegalArgumentException("Unexpected header: Content-Length");
                }
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            throw new NullPointerException("body == null");
        }

        public static Part create(RequestBody requestBody) {
            return create(null, requestBody);
        }

        public static Part createFormData(String str, String str2) {
            return createFormData(str, null, RequestBody.create((MediaType) null, str2));
        }

        public static Part createFormData(String str, String str2, RequestBody requestBody) {
            if (str != null) {
                StringBuilder sb = new StringBuilder("form-data; name=");
                MultipartBody.a(sb, str);
                if (str2 != null) {
                    sb.append("; filename=");
                    MultipartBody.a(sb, str2);
                }
                return create(Headers.of("Content-Disposition", sb.toString()), requestBody);
            }
            throw new NullPointerException("name == null");
        }

        public RequestBody body() {
            return this.b;
        }

        public Headers headers() {
            return this.f22178a;
        }
    }

    MultipartBody(ByteString byteString, MediaType mediaType, List<Part> list) {
        this.i = byteString;
        this.j = mediaType;
        this.k = MediaType.get(mediaType + "; boundary=" + byteString.utf8());
        this.l = Util.immutableList(list);
    }

    private long a(BufferedSink bufferedSink, boolean z) throws IOException {
        Buffer buffer;
        Buffer buffer2;
        if (z) {
            buffer = new Buffer();
            buffer2 = buffer;
        } else {
            buffer = bufferedSink;
            buffer2 = null;
        }
        int size = this.l.size();
        long j = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                buffer.write(h);
                buffer.write(this.i);
                buffer.write(h);
                buffer.write(g);
                long j2 = j;
                if (z) {
                    j2 = j + buffer2.size();
                    buffer2.clear();
                }
                return j2;
            }
            Part part = this.l.get(i2);
            Headers headers = part.f22178a;
            RequestBody requestBody = part.b;
            buffer.write(h);
            buffer.write(this.i);
            buffer.write(g);
            if (headers != null) {
                int size2 = headers.size();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= size2) {
                        break;
                    }
                    buffer.writeUtf8(headers.name(i4)).write(f).writeUtf8(headers.value(i4)).write(g);
                    i3 = i4 + 1;
                }
            }
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                buffer.writeUtf8("Content-Type: ").writeUtf8(contentType.toString()).write(g);
            }
            long contentLength = requestBody.contentLength();
            if (contentLength != -1) {
                buffer.writeUtf8("Content-Length: ").writeDecimalLong(contentLength).write(g);
            } else if (z) {
                buffer2.clear();
                return -1L;
            }
            buffer.write(g);
            if (z) {
                j += contentLength;
            } else {
                requestBody.writeTo(buffer);
            }
            buffer.write(g);
            i = i2 + 1;
        }
    }

    static StringBuilder a(StringBuilder sb, String str) {
        String str2;
        sb.append('\"');
        int length = str.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                sb.append('\"');
                return sb;
            }
            char charAt = str.charAt(i2);
            if (charAt == '\n') {
                str2 = "%0A";
            } else if (charAt == '\r') {
                str2 = "%0D";
            } else if (charAt != '\"') {
                sb.append(charAt);
                i = i2 + 1;
            } else {
                str2 = "%22";
            }
            sb.append(str2);
            i = i2 + 1;
        }
    }

    public String boundary() {
        return this.i.utf8();
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
    public long contentLength() throws IOException {
        long j = this.m;
        if (j != -1) {
            return j;
        }
        long a2 = a((BufferedSink) null, true);
        this.m = a2;
        return a2;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
    public MediaType contentType() {
        return this.k;
    }

    public Part part(int i) {
        return this.l.get(i);
    }

    public List<Part> parts() {
        return this.l;
    }

    public int size() {
        return this.l.size();
    }

    public MediaType type() {
        return this.j;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        a(bufferedSink, false);
    }
}
