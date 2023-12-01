package com.loopj.android.http;

import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpUriRequest;

/* loaded from: source-7994992-dex2jar.jar:com/loopj/android/http/RangeFileAsyncHttpResponseHandler.class */
public abstract class RangeFileAsyncHttpResponseHandler extends FileAsyncHttpResponseHandler {
    private static final String LOG_TAG = "RangeFileAsyncHttpResponseHandler";
    private boolean append;
    private long current;

    public RangeFileAsyncHttpResponseHandler(File file) {
        super(file);
        this.current = 0L;
        this.append = false;
    }

    @Override // com.loopj.android.http.FileAsyncHttpResponseHandler, com.loopj.android.http.AsyncHttpResponseHandler
    protected byte[] getResponseData(HttpEntity httpEntity) throws IOException {
        if (httpEntity != null) {
            InputStream content = httpEntity.getContent();
            long contentLength = httpEntity.getContentLength() + this.current;
            FileOutputStream fileOutputStream = new FileOutputStream(getTargetFile(), this.append);
            if (content != null) {
                try {
                    byte[] bArr = new byte[4096];
                    while (this.current < contentLength) {
                        int read = content.read(bArr);
                        if (read == -1 || Thread.currentThread().isInterrupted()) {
                            break;
                        }
                        this.current += read;
                        fileOutputStream.write(bArr, 0, read);
                        sendProgressMessage((int) this.current, (int) contentLength);
                    }
                    return null;
                } finally {
                    content.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler, com.loopj.android.http.ResponseHandlerInterface
    public void sendResponseMessage(HttpResponse httpResponse) throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        StatusLine statusLine = httpResponse.getStatusLine();
        if (statusLine.getStatusCode() == 416) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            sendSuccessMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), null);
        } else if (statusLine.getStatusCode() >= 300) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            sendFailureMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), null, new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()));
        } else if (Thread.currentThread().isInterrupted()) {
        } else {
            Header firstHeader = httpResponse.getFirstHeader("Content-Range");
            if (firstHeader == null) {
                this.append = false;
                this.current = 0L;
            } else {
                Log.v(LOG_TAG, "Content-Range: " + firstHeader.getValue());
            }
            sendSuccessMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), getResponseData(httpResponse.getEntity()));
        }
    }

    public void updateRequestHeaders(HttpUriRequest httpUriRequest) {
        if (this.mFile.exists() && this.mFile.canWrite()) {
            this.current = this.mFile.length();
        }
        if (this.current > 0) {
            this.append = true;
            httpUriRequest.setHeader("Range", "bytes=" + this.current + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
    }
}
