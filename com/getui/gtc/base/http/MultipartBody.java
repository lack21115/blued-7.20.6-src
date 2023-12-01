package com.getui.gtc.base.http;

import com.getui.gtc.base.http.Headers;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/MultipartBody.class */
public final class MultipartBody extends RequestBody {
    private final String boundary;
    private long contentLength = -1;
    private final MediaType contentType;
    private final MediaType originalType;
    private final List<Part> parts;
    public static final MediaType MIXED = MediaType.get("multipart/mixed");
    public static final MediaType ALTERNATIVE = MediaType.get("multipart/alternative");
    public static final MediaType DIGEST = MediaType.get("multipart/digest");
    public static final MediaType PARALLEL = MediaType.get("multipart/parallel");
    public static final MediaType FORM = MediaType.get(HttpConstants.ContentType.MULTIPART_FORM_DATA);
    private static final byte[] COLONSPACE = {58, 32};
    private static final byte[] CRLF = {13, 10};
    private static final byte[] DASHDASH = {45, 45};

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/MultipartBody$Builder.class */
    public static final class Builder {
        private final String boundary;
        private final List<Part> parts;
        private MediaType type;

        public Builder() {
            this(UUID.randomUUID().toString());
        }

        public Builder(String str) {
            this.type = MultipartBody.FORM;
            this.parts = new ArrayList();
            this.boundary = str;
        }

        public final Builder addFormDataPart(String str, String str2) {
            return addPart(Part.createFormData(str, str2));
        }

        public final Builder addFormDataPart(String str, String str2, RequestBody requestBody) {
            return addPart(Part.createFormData(str, str2, requestBody));
        }

        public final Builder addPart(Headers headers, RequestBody requestBody) {
            return addPart(Part.create(headers, requestBody));
        }

        public final Builder addPart(Part part) {
            if (part != null) {
                this.parts.add(part);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        public final Builder addPart(RequestBody requestBody) {
            return addPart(Part.create(requestBody));
        }

        public final MultipartBody build() {
            if (this.parts.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new MultipartBody(this.boundary, this.type, this.parts);
        }

        public final Builder setType(MediaType mediaType) {
            if (mediaType != null) {
                if (mediaType.type().equals("multipart")) {
                    this.type = mediaType;
                    return this;
                }
                throw new IllegalArgumentException("multipart != ".concat(String.valueOf(mediaType)));
            }
            throw new NullPointerException("type == null");
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/MultipartBody$Part.class */
    public static final class Part {
        final RequestBody body;
        final Headers headers;

        private Part(Headers headers, RequestBody requestBody) {
            this.headers = headers;
            this.body = requestBody;
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
            return createFormData(str, str2, requestBody, null);
        }

        public static Part createFormData(String str, String str2, RequestBody requestBody, String str3) {
            if (str != null) {
                StringBuilder sb = new StringBuilder("form-data; name=");
                MultipartBody.appendQuotedString(sb, str);
                if (str2 != null) {
                    sb.append("; filename=");
                    MultipartBody.appendQuotedString(sb, str2);
                }
                Headers.Builder addUnsafeNonAscii = new Headers.Builder().addUnsafeNonAscii("Content-Disposition", sb.toString());
                if (str3 != null) {
                    addUnsafeNonAscii.add("Content-Transfer-Encoding", str3);
                }
                return create(addUnsafeNonAscii.build(), requestBody);
            }
            throw new NullPointerException("name == null");
        }

        public final RequestBody body() {
            return this.body;
        }

        public final Headers headers() {
            return this.headers;
        }
    }

    MultipartBody(String str, MediaType mediaType, List<Part> list) {
        this.boundary = str;
        this.originalType = mediaType;
        this.contentType = MediaType.get(mediaType + "; boundary=" + str);
        this.parts = Collections.unmodifiableList(new ArrayList(list));
    }

    static void appendQuotedString(StringBuilder sb, String str) {
        String str2;
        sb.append('\"');
        int length = str.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                sb.append('\"');
                return;
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

    private long writeOrCountBytes(OutputStream outputStream, boolean z) throws IOException {
        BufferedSink bufferedSink;
        BufferedSink bufferedSink2;
        if (z) {
            bufferedSink = new BufferedSink(new ByteArrayOutputStream());
            bufferedSink2 = bufferedSink;
        } else {
            bufferedSink = new BufferedSink(outputStream);
            bufferedSink2 = null;
        }
        int size = this.parts.size();
        long j = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                bufferedSink.write(DASHDASH);
                bufferedSink.write(this.boundary);
                bufferedSink.write(DASHDASH);
                bufferedSink.write(CRLF);
                long j2 = j;
                if (z) {
                    j2 = j + bufferedSink2.size();
                    bufferedSink2.close();
                }
                return j2;
            }
            Part part = this.parts.get(i2);
            Headers headers = part.headers;
            RequestBody requestBody = part.body;
            bufferedSink.write(DASHDASH);
            bufferedSink.write(this.boundary);
            bufferedSink.write(CRLF);
            if (headers != null) {
                int size2 = headers.size();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= size2) {
                        break;
                    }
                    bufferedSink.writeUtf8(headers.name(i4)).write(COLONSPACE).writeUtf8(headers.value(i4)).write(CRLF);
                    i3 = i4 + 1;
                }
            }
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                bufferedSink.writeUtf8("Content-Type: ").writeUtf8(contentType.toString()).write(CRLF);
            }
            long contentLength = requestBody.contentLength();
            if (contentLength != -1) {
                bufferedSink.writeUtf8("Content-Length: ").writeLong(contentLength).write(CRLF);
            } else if (z) {
                bufferedSink2.close();
                return -1L;
            }
            bufferedSink.write(CRLF);
            if (z) {
                j += contentLength;
            } else {
                requestBody.writeTo(outputStream);
            }
            bufferedSink.write(CRLF);
            i = i2 + 1;
        }
    }

    public final String boundary() {
        return this.boundary;
    }

    @Override // com.getui.gtc.base.http.RequestBody
    public final long contentLength() {
        long j = this.contentLength;
        if (j != -1) {
            return j;
        }
        try {
            long writeOrCountBytes = writeOrCountBytes(null, true);
            this.contentLength = writeOrCountBytes;
            return writeOrCountBytes;
        } catch (IOException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // com.getui.gtc.base.http.RequestBody
    public final MediaType contentType() {
        return this.contentType;
    }

    public final Part part(int i) {
        return this.parts.get(i);
    }

    public final List<Part> parts() {
        return this.parts;
    }

    public final int size() {
        return this.parts.size();
    }

    public final MediaType type() {
        return this.originalType;
    }

    @Override // com.getui.gtc.base.http.RequestBody
    public final void writeTo(OutputStream outputStream) throws IOException {
        writeOrCountBytes(outputStream, false);
    }
}
