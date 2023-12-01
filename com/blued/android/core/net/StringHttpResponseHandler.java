package com.blued.android.core.net;

import android.text.TextUtils;
import java.io.IOException;
import okhttp3.ResponseBody;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/StringHttpResponseHandler.class */
public abstract class StringHttpResponseHandler extends HttpResponseHandler<String> {
    public StringHttpResponseHandler() {
    }

    public StringHttpResponseHandler(boolean z) {
        super(z);
    }

    @Override // com.blued.android.core.net.http.AbstractHttpResponseHandler
    public long getResponseLength(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return str.length();
    }

    @Override // com.blued.android.core.net.http.AbstractHttpResponseHandler
    public String getResponseType() {
        return "string";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.core.net.http.AbstractHttpResponseHandler
    public String parseResponse(int i, ResponseBody responseBody) throws IOException {
        if (responseBody == null) {
            return null;
        }
        return responseBody.string();
    }
}
