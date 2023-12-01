package com.sina.weibo.sdk.net;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.sina.weibo.sdk.utils.LogUtil;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.RedirectHandler;
import org.apache.http.protocol.HttpContext;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/net/CustomRedirectHandler.class */
public abstract class CustomRedirectHandler implements RedirectHandler {
    private static final int MAX_REDIRECT_COUNT = 15;
    private static final String TAG = CustomRedirectHandler.class.getCanonicalName();
    int redirectCount;
    String redirectUrl;
    private String tempRedirectUrl;

    public URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        String str = TAG;
        LogUtil.d(str, "CustomRedirectHandler getLocationURI getRedirectUrl : " + this.tempRedirectUrl);
        if (TextUtils.isEmpty(this.tempRedirectUrl)) {
            return null;
        }
        return URI.create(this.tempRedirectUrl);
    }

    public int getRedirectCount() {
        return this.redirectCount;
    }

    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode != 301 && statusCode != 302) {
            if (statusCode == 200) {
                this.redirectUrl = this.tempRedirectUrl;
                return false;
            }
            onReceivedException();
            return false;
        }
        String value = httpResponse.getFirstHeader(HttpHeaders.LOCATION).getValue();
        this.tempRedirectUrl = value;
        if (TextUtils.isEmpty(value) || this.redirectCount >= 15 || !shouldRedirectUrl(this.tempRedirectUrl)) {
            return false;
        }
        this.redirectCount++;
        return true;
    }

    public abstract void onReceivedException();

    public abstract boolean shouldRedirectUrl(String str);
}
