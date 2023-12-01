package com.getui.gtc.base.http;

import com.getui.gtc.base.util.io.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/ResponseBody.class */
public abstract class ResponseBody implements Closeable {
    public static ResponseBody create(final MediaType mediaType, final long j, final InputStream inputStream) {
        if (inputStream != null) {
            return new ResponseBody() { // from class: com.getui.gtc.base.http.ResponseBody.1
                @Override // com.getui.gtc.base.http.ResponseBody
                public final InputStream byteStream() {
                    return inputStream;
                }

                @Override // com.getui.gtc.base.http.ResponseBody
                public final long contentLength() {
                    return j;
                }

                @Override // com.getui.gtc.base.http.ResponseBody
                public final MediaType contentType() {
                    return MediaType.this;
                }
            };
        }
        throw new NullPointerException("byte stream is null");
    }

    public static ResponseBody create(MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        MediaType mediaType2 = mediaType;
        if (mediaType != null) {
            Charset charset2 = mediaType.charset();
            charset = charset2;
            mediaType2 = mediaType;
            if (charset2 == null) {
                charset = Util.UTF_8;
                mediaType2 = MediaType.parse(mediaType + "; charset=utf-8");
            }
        }
        return create(mediaType2, str.getBytes(charset));
    }

    public static ResponseBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr.length, new ByteArrayInputStream(bArr));
    }

    public abstract InputStream byteStream();

    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength <= 2147483647L) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            InputStream byteStream = byteStream();
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    int read = byteStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (Throwable th) {
                    Util.closeQuietly(byteStream);
                    throw th;
                }
            }
            Util.closeQuietly(byteStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (contentLength != -1 && contentLength != byteArray.length) {
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + byteArray.length + ") disagree");
            }
            return byteArray;
        }
        throw new IOException("Cannot buffer entire body for content length: ".concat(String.valueOf(contentLength)));
    }

    public final Reader charStream() {
        return new InputStreamReader(byteStream(), charset());
    }

    public Charset charset() {
        MediaType contentType = contentType();
        return contentType != null ? contentType.charset(Util.UTF_8) : Util.UTF_8;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.closeQuietly(byteStream());
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public final void file(File file) throws IOException {
        IOUtils.saveToFile(byteStream(), file);
    }

    public final String string() throws IOException {
        return new String(bytes(), charset());
    }
}
