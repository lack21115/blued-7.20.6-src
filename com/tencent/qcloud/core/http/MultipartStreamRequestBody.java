package com.tencent.qcloud.core.http;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.tencent.qcloud.core.common.QCloudDigistListener;
import com.tencent.qcloud.core.common.QCloudProgressListener;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/MultipartStreamRequestBody.class */
public class MultipartStreamRequestBody extends RequestBody implements QCloudDigistListener, ProgressBody, ReactiveBody {
    private Map<String, String> bodyParameters = new LinkedHashMap();
    private String fileName;
    MultipartBody multipartBody;
    private String name;
    StreamingRequestBody streamingRequestBody;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/MultipartStreamRequestBody$ExStreamingRequestBody.class */
    static class ExStreamingRequestBody extends StreamingRequestBody {
        protected ExStreamingRequestBody() {
        }

        static StreamingRequestBody bytes(byte[] bArr, String str, long j, long j2) {
            ExStreamingRequestBody exStreamingRequestBody = new ExStreamingRequestBody();
            exStreamingRequestBody.bytes = bArr;
            exStreamingRequestBody.contentType = str;
            long j3 = j;
            if (j < 0) {
                j3 = 0;
            }
            exStreamingRequestBody.offset = j3;
            exStreamingRequestBody.requiredLength = j2;
            return exStreamingRequestBody;
        }

        static StreamingRequestBody file(File file, String str) {
            return file(file, str, 0L, Long.MAX_VALUE);
        }

        static StreamingRequestBody file(File file, String str, long j, long j2) {
            ExStreamingRequestBody exStreamingRequestBody = new ExStreamingRequestBody();
            exStreamingRequestBody.file = file;
            exStreamingRequestBody.contentType = str;
            long j3 = j;
            if (j < 0) {
                j3 = 0;
            }
            exStreamingRequestBody.offset = j3;
            exStreamingRequestBody.requiredLength = j2;
            return exStreamingRequestBody;
        }

        static StreamingRequestBody steam(InputStream inputStream, File file, String str, long j, long j2) {
            ExStreamingRequestBody exStreamingRequestBody = new ExStreamingRequestBody();
            exStreamingRequestBody.stream = inputStream;
            exStreamingRequestBody.contentType = str;
            exStreamingRequestBody.file = file;
            long j3 = j;
            if (j < 0) {
                j3 = 0;
            }
            exStreamingRequestBody.offset = j3;
            exStreamingRequestBody.requiredLength = j2;
            return exStreamingRequestBody;
        }

        static StreamingRequestBody uri(Uri uri, ContentResolver contentResolver, String str, long j, long j2) {
            ExStreamingRequestBody exStreamingRequestBody = new ExStreamingRequestBody();
            exStreamingRequestBody.uri = uri;
            exStreamingRequestBody.contentResolver = contentResolver;
            exStreamingRequestBody.contentType = str;
            long j3 = j;
            if (j < 0) {
                j3 = 0;
            }
            exStreamingRequestBody.offset = j3;
            exStreamingRequestBody.requiredLength = j2;
            return exStreamingRequestBody;
        }

        static StreamingRequestBody url(URL url, String str, long j, long j2) {
            ExStreamingRequestBody exStreamingRequestBody = new ExStreamingRequestBody();
            exStreamingRequestBody.url = url;
            exStreamingRequestBody.contentType = str;
            long j3 = j;
            if (j < 0) {
                j3 = 0;
            }
            exStreamingRequestBody.offset = j3;
            exStreamingRequestBody.requiredLength = j2;
            return exStreamingRequestBody;
        }

        @Override // com.tencent.qcloud.core.http.StreamingRequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            InputStream inputStream;
            Source source = null;
            Source source2 = null;
            try {
                InputStream stream = getStream();
                if (stream != null) {
                    try {
                        source = Okio.buffer(Okio.source(stream));
                        long contentLength = contentLength();
                        this.countingSink = new CountingSink(bufferedSink, contentLength, this.progressListener);
                        BufferedSink buffer = Okio.buffer(this.countingSink);
                        if (contentLength > 0) {
                            buffer.write(source, contentLength);
                        } else {
                            buffer.writeAll(source);
                        }
                        source2 = source;
                        buffer.flush();
                    } catch (Throwable th) {
                        th = th;
                        inputStream = stream;
                        if (inputStream != null) {
                            Util.a(inputStream);
                        }
                        if (source2 != null) {
                            Util.a(source2);
                        }
                        throw th;
                    }
                }
                if (stream != null) {
                    Util.a(stream);
                }
                if (source != null) {
                    Util.a(source);
                }
            } catch (Throwable th2) {
                th = th2;
                source2 = null;
                inputStream = null;
            }
        }
    }

    public void addMd5() throws IOException {
        try {
            this.bodyParameters.put("Content-MD5", onGetMd5());
        } catch (IOException e) {
            throw e;
        }
    }

    public long contentLength() throws IOException {
        return this.multipartBody.contentLength();
    }

    public MediaType contentType() {
        return this.multipartBody.contentType();
    }

    @Override // com.tencent.qcloud.core.http.ReactiveBody
    public <T> void end(HttpResult<T> httpResult) throws IOException {
    }

    @Override // com.tencent.qcloud.core.http.ProgressBody
    public long getBytesTransferred() {
        StreamingRequestBody streamingRequestBody = this.streamingRequestBody;
        if (streamingRequestBody != null) {
            return streamingRequestBody.getBytesTransferred();
        }
        return 0L;
    }

    @Override // com.tencent.qcloud.core.common.QCloudDigistListener
    public String onGetMd5() throws IOException {
        StreamingRequestBody streamingRequestBody = this.streamingRequestBody;
        if (streamingRequestBody != null) {
            String onGetMd5 = streamingRequestBody.onGetMd5();
            this.bodyParameters.put("Content-MD5", onGetMd5);
            return onGetMd5;
        }
        return null;
    }

    @Override // com.tencent.qcloud.core.http.ReactiveBody
    public void prepare() {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MediaType.parse(HttpConstants.ContentType.MULTIPART_FORM_DATA));
        for (Map.Entry<String, String> entry : this.bodyParameters.entrySet()) {
            builder.addFormDataPart(entry.getKey(), entry.getValue());
        }
        builder.addFormDataPart(this.name, this.fileName, this.streamingRequestBody);
        this.multipartBody = builder.build();
    }

    public void setBodyParameters(Map<String, String> map) {
        if (map != null) {
            this.bodyParameters.putAll(map);
        }
    }

    public void setContent(String str, String str2, String str3, File file, long j, long j2) {
        if (str2 != null) {
            this.name = str2;
        }
        this.fileName = str3;
        String str4 = str;
        if (TextUtils.isEmpty(str)) {
            str4 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(file.getPath()));
        }
        this.streamingRequestBody = ExStreamingRequestBody.file(file, str4, j, j2);
    }

    public void setContent(String str, String str2, String str3, File file, InputStream inputStream, long j, long j2) throws IOException {
        if (str2 != null) {
            this.name = str2;
        }
        this.fileName = str3;
        this.streamingRequestBody = ExStreamingRequestBody.steam(inputStream, file, str, j, j2);
    }

    public void setContent(String str, String str2, String str3, byte[] bArr, long j, long j2) {
        if (str2 != null) {
            this.name = str2;
        }
        this.fileName = str3;
        this.streamingRequestBody = ExStreamingRequestBody.bytes(bArr, str, j, j2);
    }

    @Override // com.tencent.qcloud.core.http.ProgressBody
    public void setProgressListener(QCloudProgressListener qCloudProgressListener) {
        StreamingRequestBody streamingRequestBody = this.streamingRequestBody;
        if (streamingRequestBody != null) {
            streamingRequestBody.setProgressListener(qCloudProgressListener);
        }
    }

    public void setSign(String str) {
        if (str != null) {
            this.bodyParameters.put("Signature", str);
        }
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        try {
            this.multipartBody.writeTo(bufferedSink);
        } finally {
            if (this.streamingRequestBody.countingSink != null) {
                Util.a(this.streamingRequestBody.countingSink);
            }
        }
    }
}
