package com.blued.android.core.image.http;

import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.utils.Log;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.ResponseBody;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/http/InputStreamHttpResponseHandler.class */
public abstract class InputStreamHttpResponseHandler extends HttpResponseHandler<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private ResponseBody f9560a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.core.net.http.AbstractHttpResponseHandler
    /* renamed from: a */
    public InputStream parseResponse(int i, ResponseBody responseBody) {
        this.f9560a = responseBody;
        if (responseBody != null) {
            return new FilterInputStream(responseBody.byteStream()) { // from class: com.blued.android.core.image.http.InputStreamHttpResponseHandler.1
                @Override // java.io.FilterInputStream, java.io.InputStream
                public int read() throws IOException {
                    return super.read();
                }

                @Override // java.io.FilterInputStream, java.io.InputStream
                public int read(byte[] bArr, int i2, int i3) throws IOException {
                    return super.read(bArr, i2, i3);
                }
            };
        }
        return null;
    }

    public void a() {
        if (ImageLoader.a()) {
            Log.e("IMAGE", "InputStreamHttpResponseHandler : close");
        }
        ResponseBody responseBody = this.f9560a;
        if (responseBody != null) {
            responseBody.close();
            this.f9560a = null;
        }
    }

    @Override // com.blued.android.core.net.http.AbstractHttpResponseHandler
    /* renamed from: b */
    public long getResponseLength(InputStream inputStream) {
        if (inputStream != null) {
            try {
                return inputStream.available();
            } catch (Exception e) {
                return 0L;
            }
        }
        return 0L;
    }

    @Override // com.blued.android.core.net.http.AbstractHttpResponseHandler
    public String getResponseType() {
        return "inputstream";
    }
}
