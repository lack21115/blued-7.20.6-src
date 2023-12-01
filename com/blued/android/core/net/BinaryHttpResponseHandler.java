package com.blued.android.core.net;

import com.android.internal.http.multipart.FilePart;
import com.blued.android.core.AppMethods;
import java.io.FilterInputStream;
import java.io.IOException;
import okhttp3.ResponseBody;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/BinaryHttpResponseHandler.class */
public abstract class BinaryHttpResponseHandler extends HttpResponseHandler<byte[]> {
    public BinaryHttpResponseHandler() {
    }

    public BinaryHttpResponseHandler(boolean z) {
        super(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.core.net.http.AbstractHttpResponseHandler
    /* renamed from: a */
    public byte[] parseResponse(int i, ResponseBody responseBody) throws IOException {
        if (responseBody != null) {
            final long contentLength = responseBody.contentLength();
            byte[] a = AppMethods.a(new FilterInputStream(responseBody.byteStream()) { // from class: com.blued.android.core.net.BinaryHttpResponseHandler.1
                int a = 0;

                @Override // java.io.FilterInputStream, java.io.InputStream
                public int read() throws IOException {
                    int read = super.read();
                    if (read > 0) {
                        int i2 = this.a + read;
                        this.a = i2;
                        BinaryHttpResponseHandler.this.sendProgressMessage((int) ((i2 * 100.0f) / ((float) contentLength)), i2);
                    }
                    return read;
                }

                @Override // java.io.FilterInputStream, java.io.InputStream
                public int read(byte[] bArr, int i2, int i3) throws IOException {
                    int read = super.read(bArr, i2, i3);
                    if (read > 0) {
                        int i4 = this.a + read;
                        this.a = i4;
                        BinaryHttpResponseHandler.this.sendProgressMessage((int) ((i4 * 100.0f) / ((float) contentLength)), i4);
                    }
                    return read;
                }
            }, (int) contentLength);
            responseBody.close();
            return a;
        }
        return null;
    }

    @Override // com.blued.android.core.net.http.AbstractHttpResponseHandler
    /* renamed from: b */
    public long getResponseLength(byte[] bArr) {
        if (bArr == null) {
            return 0L;
        }
        return bArr.length;
    }

    @Override // com.blued.android.core.net.http.AbstractHttpResponseHandler
    public String getResponseType() {
        return FilePart.DEFAULT_TRANSFER_ENCODING;
    }
}
