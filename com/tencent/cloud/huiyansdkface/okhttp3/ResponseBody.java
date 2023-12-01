package com.tencent.cloud.huiyansdkface.okhttp3;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/ResponseBody.class */
public abstract class ResponseBody implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private Reader f22202a;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/ResponseBody$BomAwareReader.class */
    static final class BomAwareReader extends Reader {

        /* renamed from: a  reason: collision with root package name */
        private final BufferedSource f22205a;
        private final Charset b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f22206c;
        private Reader d;

        BomAwareReader(BufferedSource bufferedSource, Charset charset) {
            this.f22205a = bufferedSource;
            this.b = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f22206c = true;
            Reader reader = this.d;
            if (reader != null) {
                reader.close();
            } else {
                this.f22205a.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            if (this.f22206c) {
                throw new IOException("Stream closed");
            }
            Reader reader = this.d;
            InputStreamReader inputStreamReader = reader;
            if (reader == null) {
                inputStreamReader = new InputStreamReader(this.f22205a.inputStream(), Util.bomAwareCharset(this.f22205a, this.b));
                this.d = inputStreamReader;
            }
            return inputStreamReader.read(cArr, i, i2);
        }
    }

    private Charset a() {
        MediaType contentType = contentType();
        return contentType != null ? contentType.charset(Util.e) : Util.e;
    }

    public static ResponseBody create(final MediaType mediaType, final long j, final BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            return new ResponseBody() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody.1
                @Override // com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody
                public long contentLength() {
                    return j;
                }

                @Override // com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody
                public MediaType contentType() {
                    return MediaType.this;
                }

                @Override // com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody
                public BufferedSource source() {
                    return bufferedSource;
                }
            };
        }
        throw new NullPointerException("source == null");
    }

    public static ResponseBody create(MediaType mediaType, ByteString byteString) {
        return create(mediaType, byteString.size(), new Buffer().write(byteString));
    }

    public static ResponseBody create(MediaType mediaType, String str) {
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
        Buffer writeString = new Buffer().writeString(str, charset);
        return create(mediaType2, writeString.size(), writeString);
    }

    public static ResponseBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr.length, new Buffer().write(bArr));
    }

    public final InputStream byteStream() {
        return source().inputStream();
    }

    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
        BufferedSource source = source();
        try {
            byte[] readByteArray = source.readByteArray();
            Util.closeQuietly(source);
            if (contentLength != -1 && contentLength != readByteArray.length) {
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + readByteArray.length + ") disagree");
            }
            return readByteArray;
        } catch (Throwable th) {
            Util.closeQuietly(source);
            throw th;
        }
    }

    public final Reader charStream() {
        Reader reader = this.f22202a;
        if (reader != null) {
            return reader;
        }
        BomAwareReader bomAwareReader = new BomAwareReader(source(), a());
        this.f22202a = bomAwareReader;
        return bomAwareReader;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.closeQuietly(source());
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract BufferedSource source();

    public final String string() throws IOException {
        BufferedSource source = source();
        try {
            return source.readString(Util.bomAwareCharset(source, a()));
        } finally {
            Util.closeQuietly(source);
        }
    }
}
