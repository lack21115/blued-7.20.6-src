package com.tencent.qcloud.core.http;

import android.content.ContentResolver;
import android.net.Uri;
import com.tencent.qcloud.core.common.QCloudDigistListener;
import com.tencent.qcloud.core.common.QCloudProgressListener;
import com.tencent.qcloud.core.logger.QCloudLogger;
import com.tencent.qcloud.core.util.Base64Utils;
import com.tencent.qcloud.core.util.QCloudUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/StreamingRequestBody.class */
public class StreamingRequestBody extends RequestBody implements QCloudDigistListener, ProgressBody {
    protected byte[] bytes;
    protected ContentResolver contentResolver;
    protected String contentType;
    protected CountingSink countingSink;
    protected File file;
    protected QCloudProgressListener progressListener;
    protected InputStream stream;
    protected Uri uri;
    protected URL url;
    protected long offset = 0;
    protected long requiredLength = -1;
    protected long contentRawLength = -1;
    private boolean deleteFileWhenComplete = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StreamingRequestBody bytes(byte[] bArr, String str, long j, long j2) {
        StreamingRequestBody streamingRequestBody = new StreamingRequestBody();
        streamingRequestBody.bytes = bArr;
        streamingRequestBody.contentType = str;
        long j3 = j;
        if (j < 0) {
            j3 = 0;
        }
        streamingRequestBody.offset = j3;
        streamingRequestBody.requiredLength = j2;
        return streamingRequestBody;
    }

    static StreamingRequestBody file(File file, String str) {
        return file(file, str, 0L, Long.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StreamingRequestBody file(File file, String str, long j, long j2) {
        StreamingRequestBody streamingRequestBody = new StreamingRequestBody();
        streamingRequestBody.file = file;
        streamingRequestBody.contentType = str;
        long j3 = j;
        if (j < 0) {
            j3 = 0;
        }
        streamingRequestBody.offset = j3;
        streamingRequestBody.requiredLength = j2;
        return streamingRequestBody;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StreamingRequestBody steam(InputStream inputStream, File file, String str, long j, long j2) {
        StreamingRequestBody streamingRequestBody = new StreamingRequestBody();
        streamingRequestBody.stream = inputStream;
        streamingRequestBody.contentType = str;
        streamingRequestBody.file = file;
        long j3 = j;
        if (j < 0) {
            j3 = 0;
        }
        streamingRequestBody.offset = j3;
        streamingRequestBody.requiredLength = j2;
        streamingRequestBody.deleteFileWhenComplete = true;
        return streamingRequestBody;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StreamingRequestBody uri(Uri uri, ContentResolver contentResolver, String str, long j, long j2) {
        StreamingRequestBody streamingRequestBody = new StreamingRequestBody();
        streamingRequestBody.uri = uri;
        streamingRequestBody.contentResolver = contentResolver;
        streamingRequestBody.contentType = str;
        long j3 = j;
        if (j < 0) {
            j3 = 0;
        }
        streamingRequestBody.offset = j3;
        streamingRequestBody.requiredLength = j2;
        return streamingRequestBody;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StreamingRequestBody url(URL url, String str, long j, long j2) {
        StreamingRequestBody streamingRequestBody = new StreamingRequestBody();
        streamingRequestBody.url = url;
        streamingRequestBody.contentType = str;
        long j3 = j;
        if (j < 0) {
            j3 = 0;
        }
        streamingRequestBody.offset = j3;
        streamingRequestBody.requiredLength = j2;
        return streamingRequestBody;
    }

    public long contentLength() throws IOException {
        long contentRawLength = getContentRawLength();
        if (contentRawLength <= 0) {
            return Math.max(this.requiredLength, -1L);
        }
        long j = this.requiredLength;
        return j <= 0 ? Math.max(contentRawLength - this.offset, -1L) : Math.min(contentRawLength - this.offset, j);
    }

    public MediaType contentType() {
        String str = this.contentType;
        if (str != null) {
            return MediaType.parse(str);
        }
        return null;
    }

    @Override // com.tencent.qcloud.core.http.ProgressBody
    public long getBytesTransferred() {
        CountingSink countingSink = this.countingSink;
        if (countingSink != null) {
            return countingSink.getTotalTransferred();
        }
        return 0L;
    }

    protected long getContentRawLength() throws IOException {
        if (this.contentRawLength < 0) {
            InputStream inputStream = this.stream;
            if (inputStream != null) {
                this.contentRawLength = inputStream.available();
            } else {
                File file = this.file;
                if (file != null) {
                    this.contentRawLength = file.length();
                } else {
                    byte[] bArr = this.bytes;
                    if (bArr != null) {
                        this.contentRawLength = bArr.length;
                    } else {
                        Uri uri = this.uri;
                        if (uri != null) {
                            this.contentRawLength = QCloudUtils.getUriContentLength2(uri, this.contentResolver);
                        }
                    }
                }
            }
        }
        return this.contentRawLength;
    }

    public QCloudProgressListener getProgressListener() {
        return this.progressListener;
    }

    /* JADX WARN: Finally extract failed */
    public InputStream getStream() throws IOException {
        InputStream inputStream = null;
        if (this.bytes != null) {
            inputStream = new ByteArrayInputStream(this.bytes);
        } else {
            InputStream inputStream2 = this.stream;
            if (inputStream2 != null) {
                try {
                    saveInputStreamToTmpFile(inputStream2, this.file);
                    InputStream inputStream3 = this.stream;
                    if (inputStream3 != null) {
                        Util.a(inputStream3);
                    }
                    this.stream = null;
                    this.offset = 0L;
                    inputStream = new FileInputStream(this.file);
                } catch (Throwable th) {
                    InputStream inputStream4 = this.stream;
                    if (inputStream4 != null) {
                        Util.a(inputStream4);
                    }
                    this.stream = null;
                    this.offset = 0L;
                    throw th;
                }
            } else if (this.file != null) {
                inputStream = new FileInputStream(this.file);
            } else {
                URL url = this.url;
                if (url != null) {
                    URLConnection openConnection = url.openConnection();
                    if (this.offset > 0) {
                        openConnection.setRequestProperty("Range", "bytes=" + this.offset + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.offset + this.requiredLength);
                    }
                    inputStream = this.url.openStream();
                } else {
                    Uri uri = this.uri;
                    if (uri != null) {
                        inputStream = this.contentResolver.openInputStream(uri);
                    }
                }
            }
        }
        if (this.url == null && inputStream != null) {
            long j = this.offset;
            if (j > 0) {
                long skip = inputStream.skip(j);
                if (skip < this.offset) {
                    QCloudLogger.w(QCloudHttpClient.HTTP_LOG_TAG, "skip  %d is small than offset %d", Long.valueOf(skip), Long.valueOf(this.offset));
                }
            }
        }
        return inputStream;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isLargeData() {
        return (this.file == null && this.stream == null) ? false : true;
    }

    @Override // com.tencent.qcloud.core.common.QCloudDigistListener
    public String onGetMd5() throws IOException {
        try {
            try {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    if (this.bytes != null) {
                        messageDigest.update(this.bytes, (int) this.offset, (int) contentLength());
                        return Base64Utils.encode(messageDigest.digest());
                    }
                    InputStream stream = getStream();
                    byte[] bArr = new byte[8192];
                    long contentLength = contentLength();
                    while (contentLength > 0) {
                        int read = stream.read(bArr, 0, ((long) 8192) > contentLength ? (int) contentLength : 8192);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                        contentLength -= read;
                    }
                    String encode = Base64Utils.encode(messageDigest.digest());
                    if (stream != null) {
                        Util.a(stream);
                    }
                    return encode;
                } catch (NoSuchAlgorithmException e) {
                    throw new IOException("unSupport Md5 algorithm", e);
                }
            } catch (IOException e2) {
                throw e2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                Util.a((Closeable) null);
            }
            throw th;
        }
    }

    public void release() {
        File file;
        if (!this.deleteFileWhenComplete || (file = this.file) == null) {
            return;
        }
        file.delete();
    }

    protected void saveInputStreamToTmpFile(InputStream inputStream, File file) throws IOException {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        try {
            fileOutputStream2 = new FileOutputStream(file);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            byte[] bArr = new byte[8192];
            long contentLength = contentLength();
            long j = contentLength;
            if (contentLength < 0) {
                j = Long.MAX_VALUE;
            }
            long j2 = 0;
            if (this.offset > 0) {
                inputStream.skip(this.offset);
                j2 = 0;
            }
            while (j2 < j) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                long j3 = read;
                fileOutputStream2.write(bArr, 0, (int) Math.min(j3, j - j2));
                j2 += j3;
            }
            fileOutputStream2.flush();
            Util.a(fileOutputStream2);
        } catch (Throwable th2) {
            fileOutputStream = fileOutputStream2;
            th = th2;
            if (fileOutputStream != null) {
                Util.a(fileOutputStream);
            }
            throw th;
        }
    }

    @Override // com.tencent.qcloud.core.http.ProgressBody
    public void setProgressListener(QCloudProgressListener qCloudProgressListener) {
        this.progressListener = qCloudProgressListener;
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        InputStream inputStream = null;
        Closeable closeable = null;
        try {
            InputStream stream = getStream();
            Closeable closeable2 = null;
            if (stream != null) {
                try {
                    closeable2 = Okio.buffer(Okio.source(stream));
                    long contentLength = contentLength();
                    CountingSink countingSink = new CountingSink(bufferedSink, contentLength, this.progressListener);
                    this.countingSink = countingSink;
                    BufferedSink buffer = Okio.buffer(countingSink);
                    if (contentLength > 0) {
                        buffer.write(closeable2, contentLength);
                    } else {
                        buffer.writeAll(closeable2);
                    }
                    closeable = closeable2;
                    buffer.flush();
                } catch (Throwable th) {
                    th = th;
                    inputStream = stream;
                    if (inputStream != null) {
                        Util.a(inputStream);
                    }
                    if (closeable != null) {
                        Util.a(closeable);
                    }
                    ForwardingSink forwardingSink = this.countingSink;
                    if (forwardingSink != null) {
                        Util.a(forwardingSink);
                    }
                    throw th;
                }
            }
            if (stream != null) {
                Util.a(stream);
            }
            if (closeable2 != null) {
                Util.a(closeable2);
            }
            ForwardingSink forwardingSink2 = this.countingSink;
            if (forwardingSink2 != null) {
                Util.a(forwardingSink2);
            }
        } catch (Throwable th2) {
            th = th2;
            closeable = null;
        }
    }
}
