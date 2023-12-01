package com.tencent.qcloud.core.http;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.common.QCloudProgressListener;
import com.tencent.qcloud.core.common.QCloudServiceException;
import com.tencent.qcloud.core.util.QCloudHttpUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import okhttp3.internal.Util;
import okio.Buffer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/ResponseFileConverter.class */
public class ResponseFileConverter<T> extends ResponseBodyConverter<T> implements ProgressBody {
    private ContentResolver contentResolver;
    private Uri contentUri;
    private CountingSink countingSink;
    private String filePath;
    private InputStream inputStream;
    protected boolean isQuic = false;
    private long offset;
    protected QCloudProgressListener progressListener;

    public ResponseFileConverter() {
    }

    public ResponseFileConverter(Uri uri, ContentResolver contentResolver, long j) {
        this.contentUri = uri;
        this.contentResolver = contentResolver;
        this.offset = j;
    }

    public ResponseFileConverter(String str, long j) {
        this.filePath = str;
        this.offset = j;
    }

    private T downloadToAbsolutePath(HttpResponse<T> httpResponse, long j) throws QCloudClientException, QCloudServiceException {
        File file = new File(this.filePath);
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
            if (httpResponse.response.body() != null) {
                try {
                    writeRandomAccessFile(file, httpResponse.byteStream(), j);
                    return null;
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new QCloudClientException("write local file error for " + e.toString(), e);
                }
            }
            throw new QCloudServiceException("response body is empty !");
        }
        throw new QCloudClientException(new IOException("local file directory can not create."));
    }

    /* JADX WARN: Finally extract failed */
    private T pipeToContentUri(HttpResponse<T> httpResponse, long j) throws QCloudClientException, QCloudServiceException {
        OutputStream outputStream = getOutputStream();
        InputStream byteStream = httpResponse.byteStream();
        byte[] bArr = new byte[8192];
        this.countingSink = new CountingSink(new Buffer(), j, this.progressListener);
        while (true) {
            try {
                try {
                    int read = byteStream.read(bArr);
                    if (read == -1) {
                        Util.a(outputStream);
                        return null;
                    }
                    outputStream.write(bArr, 0, read);
                    this.countingSink.writeBytesInternal(read);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new QCloudClientException("write local uri error for " + e.toString(), e);
                }
            } catch (Throwable th) {
                Util.a(outputStream);
                throw th;
            }
        }
    }

    private void writeRandomAccessFile(File file, InputStream inputStream, long j) throws IOException, QCloudClientException {
        RandomAccessFile randomAccessFile;
        if (inputStream == null) {
            throw new QCloudClientException(new IOException("response body stream is null"));
        }
        try {
            randomAccessFile = new RandomAccessFile(file, "rws");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            if (this.offset > 0) {
                randomAccessFile.seek(this.offset);
            }
            byte[] bArr = new byte[8192];
            this.countingSink = new CountingSink(new Buffer(), j, this.progressListener);
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    Util.a(randomAccessFile);
                    return;
                } else {
                    randomAccessFile.write(bArr, 0, read);
                    this.countingSink.writeBytesInternal(read);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile != null) {
                Util.a(randomAccessFile);
            }
            throw th;
        }
    }

    @Override // com.tencent.qcloud.core.http.ResponseBodyConverter
    public T convert(HttpResponse<T> httpResponse) throws QCloudClientException, QCloudServiceException {
        if (this.isQuic) {
            return null;
        }
        HttpResponse.checkResponseSuccessful(httpResponse);
        long[] parseContentRange = QCloudHttpUtils.parseContentRange(httpResponse.header("Content-Range"));
        long contentLength = parseContentRange != null ? (parseContentRange[1] - parseContentRange[0]) + 1 : httpResponse.contentLength();
        if (TextUtils.isEmpty(this.filePath)) {
            if (this.contentUri != null) {
                return pipeToContentUri(httpResponse, contentLength);
            }
            throw new QCloudClientException(new IllegalArgumentException("filePath or ContentUri are both null"));
        }
        return downloadToAbsolutePath(httpResponse, contentLength);
    }

    public void enableQuic(boolean z) {
        this.isQuic = z;
    }

    @Override // com.tencent.qcloud.core.http.ProgressBody
    public long getBytesTransferred() {
        CountingSink countingSink = this.countingSink;
        if (countingSink != null) {
            return countingSink.getTotalTransferred();
        }
        return 0L;
    }

    public OutputStream getOutputStream() throws QCloudClientException {
        if (TextUtils.isEmpty(this.filePath)) {
            Uri uri = this.contentUri;
            if (uri != null) {
                try {
                    return this.contentResolver.openOutputStream(uri);
                } catch (FileNotFoundException e) {
                    throw new QCloudClientException(e);
                }
            }
            throw new QCloudClientException(new IllegalArgumentException("filePath or ContentUri are both null"));
        }
        File file = new File(this.filePath);
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
            try {
                return new FileOutputStream(file);
            } catch (FileNotFoundException e2) {
                throw new QCloudClientException(e2);
            }
        }
        throw new QCloudClientException(new IOException("local file directory can not create."));
    }

    public QCloudProgressListener getProgressListener() {
        return this.progressListener;
    }

    @Override // com.tencent.qcloud.core.http.ProgressBody
    public void setProgressListener(QCloudProgressListener qCloudProgressListener) {
        this.progressListener = qCloudProgressListener;
    }
}
