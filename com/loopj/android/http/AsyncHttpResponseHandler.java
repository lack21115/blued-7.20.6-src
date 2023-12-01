package com.loopj.android.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.ByteArrayBuffer;

/* loaded from: source-7994992-dex2jar.jar:com/loopj/android/http/AsyncHttpResponseHandler.class */
public abstract class AsyncHttpResponseHandler implements ResponseHandlerInterface {
    protected static final int BUFFER_SIZE = 4096;
    protected static final int CANCEL_MESSAGE = 6;
    public static final String DEFAULT_CHARSET = "UTF-8";
    protected static final int FAILURE_MESSAGE = 1;
    protected static final int FINISH_MESSAGE = 3;
    private static final String LOG_TAG = "AsyncHttpResponseHandler";
    protected static final int PROGRESS_MESSAGE = 4;
    protected static final int RETRY_MESSAGE = 5;
    protected static final int START_MESSAGE = 2;
    protected static final int SUCCESS_MESSAGE = 0;
    public static final String UTF8_BOM = "\ufeff";
    private Handler handler;
    private Looper looper;
    private Header[] requestHeaders;
    private URI requestURI;
    private String responseCharset;
    private boolean useSynchronousMode;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/loopj/android/http/AsyncHttpResponseHandler$ResponderHandler.class */
    public static class ResponderHandler extends Handler {
        private final AsyncHttpResponseHandler mResponder;

        ResponderHandler(AsyncHttpResponseHandler asyncHttpResponseHandler, Looper looper) {
            super(looper);
            this.mResponder = asyncHttpResponseHandler;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.mResponder.handleMessage(message);
        }
    }

    public AsyncHttpResponseHandler() {
        this(null);
    }

    public AsyncHttpResponseHandler(Looper looper) {
        this.responseCharset = "UTF-8";
        this.requestURI = null;
        this.requestHeaders = null;
        this.looper = null;
        this.looper = looper == null ? Looper.myLooper() : looper;
        setUseSynchronousMode(false);
    }

    public String getCharset() {
        String str = this.responseCharset;
        String str2 = str;
        if (str == null) {
            str2 = "UTF-8";
        }
        return str2;
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public Header[] getRequestHeaders() {
        return this.requestHeaders;
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public URI getRequestURI() {
        return this.requestURI;
    }

    byte[] getResponseData(HttpEntity httpEntity) throws IOException {
        InputStream content;
        if (httpEntity == null || (content = httpEntity.getContent()) == null) {
            return null;
        }
        long contentLength = httpEntity.getContentLength();
        if (contentLength <= 2147483647L) {
            int i = (contentLength > 0L ? 1 : (contentLength == 0L ? 0 : -1));
            try {
                ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(i <= 0 ? 4096 : (int) contentLength);
                byte[] bArr = new byte[4096];
                int i2 = 0;
                while (true) {
                    int read = content.read(bArr);
                    if (read == -1 || Thread.currentThread().isInterrupted()) {
                        break;
                    }
                    i2 += read;
                    byteArrayBuffer.append(bArr, 0, read);
                    sendProgressMessage(i2, (int) (i <= 0 ? 1L : contentLength));
                }
                AsyncHttpClient.silentCloseInputStream(content);
                AsyncHttpClient.endEntityViaReflection(httpEntity);
                return byteArrayBuffer.toByteArray();
            } catch (OutOfMemoryError e) {
                System.gc();
                throw new IOException("File too large to fit into available memory");
            }
        }
        throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public boolean getUseSynchronousMode() {
        return this.useSynchronousMode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                Object[] objArr = (Object[]) message.obj;
                if (objArr == null || objArr.length < 3) {
                    Log.e(LOG_TAG, "SUCCESS_MESSAGE didn't got enough params");
                    return;
                } else {
                    onSuccess(((Integer) objArr[0]).intValue(), (Header[]) objArr[1], (byte[]) objArr[2]);
                    return;
                }
            case 1:
                Object[] objArr2 = (Object[]) message.obj;
                if (objArr2 == null || objArr2.length < 4) {
                    Log.e(LOG_TAG, "FAILURE_MESSAGE didn't got enough params");
                    return;
                } else {
                    onFailure(((Integer) objArr2[0]).intValue(), (Header[]) objArr2[1], (byte[]) objArr2[2], (Throwable) objArr2[3]);
                    return;
                }
            case 2:
                onStart();
                return;
            case 3:
                onFinish();
                return;
            case 4:
                Object[] objArr3 = (Object[]) message.obj;
                if (objArr3 == null || objArr3.length < 2) {
                    Log.e(LOG_TAG, "PROGRESS_MESSAGE didn't got enough params");
                    return;
                }
                try {
                    onProgress(((Integer) objArr3[0]).intValue(), ((Integer) objArr3[1]).intValue());
                    return;
                } catch (Throwable th) {
                    Log.e(LOG_TAG, "custom onProgress contains an error", th);
                    return;
                }
            case 5:
                Object[] objArr4 = (Object[]) message.obj;
                if (objArr4 == null || objArr4.length != 1) {
                    Log.e(LOG_TAG, "RETRY_MESSAGE didn't get enough params");
                    return;
                } else {
                    onRetry(((Integer) objArr4[0]).intValue());
                    return;
                }
            case 6:
                onCancel();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Message obtainMessage(int i, Object obj) {
        return Message.obtain(this.handler, i, obj);
    }

    public void onCancel() {
        Log.d(LOG_TAG, "Request got cancelled");
    }

    public abstract void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th);

    public void onFinish() {
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public void onPostProcessResponse(ResponseHandlerInterface responseHandlerInterface, HttpResponse httpResponse) {
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public void onPreProcessResponse(ResponseHandlerInterface responseHandlerInterface, HttpResponse httpResponse) {
    }

    public void onProgress(int i, int i2) {
        Log.v(LOG_TAG, String.format("Progress %d from %d (%2.0f%%)", Integer.valueOf(i), Integer.valueOf(i2), Double.valueOf(i2 > 0 ? ((i * 1.0d) / i2) * 100.0d : -1.0d)));
    }

    public void onRetry(int i) {
        Log.d(LOG_TAG, String.format("Request retry no. %d", Integer.valueOf(i)));
    }

    public void onStart() {
    }

    public abstract void onSuccess(int i, Header[] headerArr, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public void postRunnable(Runnable runnable) {
        Handler handler;
        if (runnable != null) {
            if (getUseSynchronousMode() || (handler = this.handler) == null) {
                runnable.run();
                return;
            }
            AssertUtils.asserts(handler != null, "handler should not be null!");
            this.handler.post(runnable);
        }
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public final void sendCancelMessage() {
        sendMessage(obtainMessage(6, null));
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public final void sendFailureMessage(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        sendMessage(obtainMessage(1, new Object[]{Integer.valueOf(i), headerArr, bArr, th}));
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public final void sendFinishMessage() {
        sendMessage(obtainMessage(3, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendMessage(Message message) {
        if (getUseSynchronousMode() || this.handler == null) {
            handleMessage(message);
        } else if (Thread.currentThread().isInterrupted()) {
        } else {
            AssertUtils.asserts(this.handler != null, "handler should not be null!");
            this.handler.sendMessage(message);
        }
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public final void sendProgressMessage(int i, int i2) {
        sendMessage(obtainMessage(4, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public void sendResponseMessage(HttpResponse httpResponse) throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        StatusLine statusLine = httpResponse.getStatusLine();
        byte[] responseData = getResponseData(httpResponse.getEntity());
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        if (statusLine.getStatusCode() >= 300) {
            sendFailureMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), responseData, new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()));
        } else {
            sendSuccessMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), responseData);
        }
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public final void sendRetryMessage(int i) {
        sendMessage(obtainMessage(5, new Object[]{Integer.valueOf(i)}));
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public final void sendStartMessage() {
        sendMessage(obtainMessage(2, null));
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public final void sendSuccessMessage(int i, Header[] headerArr, byte[] bArr) {
        sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i), headerArr, bArr}));
    }

    public void setCharset(String str) {
        this.responseCharset = str;
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public void setRequestHeaders(Header[] headerArr) {
        this.requestHeaders = headerArr;
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public void setRequestURI(URI uri) {
        this.requestURI = uri;
    }

    @Override // com.loopj.android.http.ResponseHandlerInterface
    public void setUseSynchronousMode(boolean z) {
        boolean z2 = z;
        if (!z) {
            z2 = z;
            if (this.looper == null) {
                z2 = true;
                Log.w(LOG_TAG, "Current thread has not called Looper.prepare(). Forcing synchronous mode.");
            }
        }
        if (!z2 && this.handler == null) {
            this.handler = new ResponderHandler(this, this.looper);
        } else if (z2 && this.handler != null) {
            this.handler = null;
        }
        this.useSynchronousMode = z2;
    }
}
