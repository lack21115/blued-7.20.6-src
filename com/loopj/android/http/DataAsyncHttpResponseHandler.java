package com.loopj.android.http;

import android.os.Message;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.util.ByteArrayBuffer;

/* loaded from: source-7994992-dex2jar.jar:com/loopj/android/http/DataAsyncHttpResponseHandler.class */
public abstract class DataAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
    private static final String LOG_TAG = "DataAsyncHttpResponseHandler";
    protected static final int PROGRESS_DATA_MESSAGE = 6;

    public static byte[] copyOfRange(byte[] bArr, int i, int i2) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NullPointerException {
        if (i <= i2) {
            int length = bArr.length;
            if (i < 0 || i > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = i2 - i;
            int min = Math.min(i3, length - i);
            byte[] bArr2 = new byte[i3];
            System.arraycopy((Object) bArr, i, (Object) bArr2, 0, min);
            return bArr2;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    byte[] getResponseData(HttpEntity httpEntity) throws IOException {
        InputStream content;
        if (httpEntity == null || (content = httpEntity.getContent()) == null) {
            return null;
        }
        long contentLength = httpEntity.getContentLength();
        if (contentLength <= 2147483647L) {
            long j = contentLength;
            if (contentLength < 0) {
                j = 4096;
            }
            try {
                ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer((int) j);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = content.read(bArr);
                    if (read == -1 || Thread.currentThread().isInterrupted()) {
                        break;
                    }
                    byteArrayBuffer.append(bArr, 0, read);
                    sendProgressDataMessage(copyOfRange(bArr, 0, read));
                }
                AsyncHttpClient.silentCloseInputStream(content);
                return byteArrayBuffer.toByteArray();
            } catch (OutOfMemoryError e) {
                System.gc();
                throw new IOException("File too large to fit into available memory");
            }
        }
        throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what != 6) {
            return;
        }
        Object[] objArr = (Object[]) message.obj;
        if (objArr == null || objArr.length < 1) {
            Log.e(LOG_TAG, "PROGRESS_DATA_MESSAGE didn't got enough params");
            return;
        }
        try {
            onProgressData((byte[]) objArr[0]);
        } catch (Throwable th) {
            Log.e(LOG_TAG, "custom onProgressData contains an error", th);
        }
    }

    public void onProgressData(byte[] bArr) {
        Log.d(LOG_TAG, "onProgressData(byte[]) was not overriden, but callback was received");
    }

    public final void sendProgressDataMessage(byte[] bArr) {
        sendMessage(obtainMessage(6, new Object[]{bArr}));
    }
}
