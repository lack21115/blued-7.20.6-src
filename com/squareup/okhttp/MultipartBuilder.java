package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* loaded from: source-8457232-dex2jar.jar:com/squareup/okhttp/MultipartBuilder.class */
public final class MultipartBuilder {
    private final ByteString boundary;
    private final List<RequestBody> partBodies;
    private final List<Headers> partHeaders;
    private MediaType type;
    public static final MediaType MIXED = MediaType.parse("multipart/mixed");
    public static final MediaType ALTERNATIVE = MediaType.parse("multipart/alternative");
    public static final MediaType DIGEST = MediaType.parse("multipart/digest");
    public static final MediaType PARALLEL = MediaType.parse("multipart/parallel");
    public static final MediaType FORM = MediaType.parse(HttpConstants.ContentType.MULTIPART_FORM_DATA);
    private static final byte[] COLONSPACE = {58, 32};
    private static final byte[] CRLF = {13, 10};
    private static final byte[] DASHDASH = {45, 45};

    /* loaded from: source-8457232-dex2jar.jar:com/squareup/okhttp/MultipartBuilder$MultipartRequestBody.class */
    static final class MultipartRequestBody extends RequestBody {
        private final ByteString boundary;
        private long contentLength = -1;
        private final MediaType contentType;
        private final List<RequestBody> partBodies;
        private final List<Headers> partHeaders;

        public MultipartRequestBody(MediaType mediaType, ByteString byteString, List<Headers> list, List<RequestBody> list2) {
            if (mediaType == null) {
                throw new NullPointerException("type == null");
            }
            this.boundary = byteString;
            this.contentType = MediaType.parse(mediaType + "; boundary=" + byteString.utf8());
            this.partHeaders = Util.immutableList(list);
            this.partBodies = Util.immutableList(list2);
        }

        private long writeOrCountBytes(BufferedSink bufferedSink, boolean z) throws IOException {
            Buffer buffer;
            Buffer buffer2;
            if (z) {
                buffer = new Buffer();
                buffer2 = buffer;
            } else {
                buffer = bufferedSink;
                buffer2 = null;
            }
            int size = this.partHeaders.size();
            long j = 0;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    buffer.write(MultipartBuilder.DASHDASH);
                    buffer.write(this.boundary);
                    buffer.write(MultipartBuilder.DASHDASH);
                    buffer.write(MultipartBuilder.CRLF);
                    long j2 = j;
                    if (z) {
                        j2 = j + buffer2.size();
                        buffer2.clear();
                    }
                    return j2;
                }
                Headers headers = this.partHeaders.get(i2);
                RequestBody requestBody = this.partBodies.get(i2);
                buffer.write(MultipartBuilder.DASHDASH);
                buffer.write(this.boundary);
                buffer.write(MultipartBuilder.CRLF);
                if (headers != null) {
                    int size2 = headers.size();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= size2) {
                            break;
                        }
                        buffer.writeUtf8(headers.name(i4)).write(MultipartBuilder.COLONSPACE).writeUtf8(headers.value(i4)).write(MultipartBuilder.CRLF);
                        i3 = i4 + 1;
                    }
                }
                MediaType contentType = requestBody.contentType();
                if (contentType != null) {
                    buffer.writeUtf8("Content-Type: ").writeUtf8(contentType.toString()).write(MultipartBuilder.CRLF);
                }
                long contentLength = requestBody.contentLength();
                if (contentLength != -1) {
                    buffer.writeUtf8("Content-Length: ").writeDecimalLong(contentLength).write(MultipartBuilder.CRLF);
                } else if (z) {
                    buffer2.clear();
                    return -1L;
                }
                buffer.write(MultipartBuilder.CRLF);
                if (z) {
                    j += contentLength;
                } else {
                    this.partBodies.get(i2).writeTo(buffer);
                }
                buffer.write(MultipartBuilder.CRLF);
                i = i2 + 1;
            }
        }

        @Override // com.squareup.okhttp.RequestBody
        public long contentLength() throws IOException {
            long j = this.contentLength;
            if (j != -1) {
                return j;
            }
            long writeOrCountBytes = writeOrCountBytes(null, true);
            this.contentLength = writeOrCountBytes;
            return writeOrCountBytes;
        }

        @Override // com.squareup.okhttp.RequestBody
        public MediaType contentType() {
            return this.contentType;
        }

        @Override // com.squareup.okhttp.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            writeOrCountBytes(bufferedSink, false);
        }
    }

    public MultipartBuilder() {
        this(UUID.randomUUID().toString());
    }

    public MultipartBuilder(String str) {
        this.type = MIXED;
        this.partHeaders = new ArrayList();
        this.partBodies = new ArrayList();
        this.boundary = ByteString.encodeUtf8(str);
    }

    private static StringBuilder appendQuotedString(StringBuilder sb, String str) {
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
                sb.append("%0A");
            } else if (charAt == '\r') {
                sb.append("%0D");
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                sb.append("%22");
            }
            i = i2 + 1;
        }
    }

    public MultipartBuilder addFormDataPart(String str, String str2) {
        return addFormDataPart(str, null, RequestBody.create((MediaType) null, str2));
    }

    public MultipartBuilder addFormDataPart(String str, String str2, RequestBody requestBody) {
        if (str != null) {
            StringBuilder sb = new StringBuilder("form-data; name=");
            appendQuotedString(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                appendQuotedString(sb, str2);
            }
            return addPart(Headers.of("Content-Disposition", sb.toString()), requestBody);
        }
        throw new NullPointerException("name == null");
    }

    public MultipartBuilder addPart(Headers headers, RequestBody requestBody) {
        if (requestBody != null) {
            if (headers == null || headers.get("Content-Type") == null) {
                if (headers == null || headers.get("Content-Length") == null) {
                    this.partHeaders.add(headers);
                    this.partBodies.add(requestBody);
                    return this;
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
            throw new IllegalArgumentException("Unexpected header: Content-Type");
        }
        throw new NullPointerException("body == null");
    }

    public MultipartBuilder addPart(RequestBody requestBody) {
        return addPart(null, requestBody);
    }

    public RequestBody build() {
        if (this.partHeaders.isEmpty()) {
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
        return new MultipartRequestBody(this.type, this.boundary, this.partHeaders, this.partBodies);
    }

    public MultipartBuilder type(MediaType mediaType) {
        if (mediaType != null) {
            if (mediaType.type().equals("multipart")) {
                this.type = mediaType;
                return this;
            }
            throw new IllegalArgumentException("multipart != " + mediaType);
        }
        throw new NullPointerException("type == null");
    }
}
