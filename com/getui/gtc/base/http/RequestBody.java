package com.getui.gtc.base.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/RequestBody.class */
public abstract class RequestBody {
    public static RequestBody create(final MediaType mediaType, final File file) {
        if (file != null) {
            return new RequestBody() { // from class: com.getui.gtc.base.http.RequestBody.2
                @Override // com.getui.gtc.base.http.RequestBody
                public final long contentLength() {
                    return file.length();
                }

                @Override // com.getui.gtc.base.http.RequestBody
                public final MediaType contentType() {
                    return MediaType.this;
                }

                @Override // com.getui.gtc.base.http.RequestBody
                public final void writeTo(OutputStream outputStream) throws IOException {
                    FileInputStream fileInputStream;
                    FileInputStream fileInputStream2;
                    try {
                        fileInputStream2 = new FileInputStream(file);
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = null;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read == -1) {
                                Util.closeQuietly(fileInputStream2);
                                return;
                            }
                            outputStream.write(bArr, 0, read);
                        }
                    } catch (Throwable th2) {
                        fileInputStream = fileInputStream2;
                        th = th2;
                        Util.closeQuietly(fileInputStream);
                        throw th;
                    }
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    public static RequestBody create(MediaType mediaType, String str) {
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

    public static RequestBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(final MediaType mediaType, final byte[] bArr, final int i, final int i2) {
        if (bArr != null) {
            Util.checkOffsetAndCount(bArr.length, i, i2);
            return new RequestBody() { // from class: com.getui.gtc.base.http.RequestBody.1
                @Override // com.getui.gtc.base.http.RequestBody
                public final long contentLength() {
                    return i2;
                }

                @Override // com.getui.gtc.base.http.RequestBody
                public final MediaType contentType() {
                    return MediaType.this;
                }

                @Override // com.getui.gtc.base.http.RequestBody
                public final void writeTo(OutputStream outputStream) throws IOException {
                    outputStream.write(bArr, i, i2);
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract void writeTo(OutputStream outputStream) throws IOException;
}
