package com.tencent.cloud.huiyansdkface.okhttp3;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okio.BufferedSink;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import com.tencent.cloud.huiyansdkface.okio.Okio;
import com.tencent.cloud.huiyansdkface.okio.Source;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/RequestBody.class */
public abstract class RequestBody {
    public static RequestBody create(final MediaType mediaType, final ByteString byteString) {
        return new RequestBody() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.RequestBody.1
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
            public long contentLength() throws IOException {
                return byteString.size();
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
            public MediaType contentType() {
                return MediaType.this;
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                bufferedSink.write(byteString);
            }
        };
    }

    public static RequestBody create(final MediaType mediaType, final File file) {
        if (file != null) {
            return new RequestBody() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.RequestBody.3
                @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
                public long contentLength() {
                    return file.length();
                }

                @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
                public MediaType contentType() {
                    return MediaType.this;
                }

                @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
                public void writeTo(BufferedSink bufferedSink) throws IOException {
                    Source source = null;
                    try {
                        Source source2 = Okio.source(file);
                        source = source2;
                        bufferedSink.writeAll(source2);
                        Util.closeQuietly(source2);
                    } catch (Throwable th) {
                        Util.closeQuietly(source);
                        throw th;
                    }
                }
            };
        }
        throw new NullPointerException("file == null");
    }

    public static RequestBody create(MediaType mediaType, String str) {
        Charset charset = Util.e;
        MediaType mediaType2 = mediaType;
        if (mediaType != null) {
            Charset charset2 = mediaType.charset();
            charset = charset2;
            mediaType2 = mediaType;
            if (charset2 == null) {
                charset = Util.e;
                mediaType2 = MediaType.parse(mediaType + "; charset=utf-8");
            }
        }
        return create(mediaType2, str.getBytes(charset));
    }

    public static RequestBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(final MediaType mediaType, final byte[] bArr, final int i, final int i2) {
        if (bArr != null) {
            Util.checkOffsetAndCount(bArr.length, i, i2);
            return new RequestBody() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.RequestBody.2
                @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
                public long contentLength() {
                    return i2;
                }

                @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
                public MediaType contentType() {
                    return MediaType.this;
                }

                @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
                public void writeTo(BufferedSink bufferedSink) throws IOException {
                    bufferedSink.write(bArr, i, i2);
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract MediaType contentType();

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;
}
