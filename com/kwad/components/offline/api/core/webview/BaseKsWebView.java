package com.kwad.components.offline.api.core.webview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.kwad.sdk.widget.h;
import java.util.UUID;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/webview/BaseKsWebView.class */
public abstract class BaseKsWebView extends FrameLayout {
    private boolean enableScroll;
    public DeepLinkListener mDeeplinkListener;
    protected String mUniqueId;
    private h mViewRCHelper;
    public WebLoadListener mWebLoadListener;
    protected WebViewStateListener mWebViewStateListener;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/webview/BaseKsWebView$DeepLinkListener.class */
    public interface DeepLinkListener {
        void onFailed();

        void onSuccess();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/webview/BaseKsWebView$WebLoadListener.class */
    public interface WebLoadListener {
        void onDownloadStart(String str, String str2, String str3, String str4, long j);

        void onPageFinished();

        void onPageStart();

        void onReceivedHttpError(int i, String str, String str2);

        boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/webview/BaseKsWebView$WebViewStateListener.class */
    public interface WebViewStateListener {
        void onFocusChanged(boolean z, int i, Rect rect);

        void onScrollChanged(int i, int i2, int i3, int i4);

        void onSizeChanged(int i, int i2, int i3, int i4);

        void onVisibilityChanged(View view, int i);

        void onWindowFocusChanged(boolean z);
    }

    public BaseKsWebView(Context context) {
        super(context);
        this.enableScroll = true;
        init(context, null);
    }

    public BaseKsWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.enableScroll = true;
        init(context, attributeSet);
    }

    public BaseKsWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.enableScroll = true;
        init(context, attributeSet);
    }

    private float[] getRadius(float f, float f2, float f3, float f4) {
        return new float[]{f, f, f2, f2, f3, f3, f4, f4};
    }

    private void init(Context context, AttributeSet attributeSet) {
        h hVar = new h();
        this.mViewRCHelper = hVar;
        hVar.initAttrs(context, attributeSet);
    }

    public abstract void addJavascriptInterface(Object obj, String str);

    public abstract void callJs(String str);

    public abstract void callJs(String str, String str2);

    public abstract void destroy();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.mViewRCHelper.beforeDispatchDraw(canvas);
        super.dispatchDraw(canvas);
        this.mViewRCHelper.afterDispatchDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void draw(Canvas canvas) {
        this.mViewRCHelper.beforeDraw(canvas);
        super.draw(canvas);
        this.mViewRCHelper.afterDraw(canvas);
    }

    public String getUniqueId() {
        if (this.mUniqueId == null) {
            this.mUniqueId = UUID.randomUUID().toString();
        }
        return this.mUniqueId;
    }

    public abstract void loadUrl(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        WebViewStateListener webViewStateListener = this.mWebViewStateListener;
        if (webViewStateListener != null) {
            webViewStateListener.onFocusChanged(z, i, rect);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        WebViewStateListener webViewStateListener = this.mWebViewStateListener;
        if (webViewStateListener != null) {
            webViewStateListener.onScrollChanged(i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mViewRCHelper.onSizeChanged(i, i2);
        WebViewStateListener webViewStateListener = this.mWebViewStateListener;
        if (webViewStateListener != null) {
            webViewStateListener.onSizeChanged(i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        WebViewStateListener webViewStateListener = this.mWebViewStateListener;
        if (webViewStateListener != null) {
            webViewStateListener.onVisibilityChanged(view, i);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        WebViewStateListener webViewStateListener = this.mWebViewStateListener;
        if (webViewStateListener != null) {
            webViewStateListener.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
    public abstract void scrollBy(int i, int i2);

    @Override // android.view.View
    public abstract void scrollTo(int i, int i2);

    public abstract void setAcceptThirdPartyCookies(boolean z);

    public abstract void setAllowContentAccess(boolean z);

    public abstract void setAllowFileAccess(boolean z);

    public abstract void setAllowFileAccessFromFileURLs(boolean z);

    public abstract void setAllowUniversalAccessFromFileURLs(boolean z);

    public abstract void setCacheMode(int i);

    public abstract void setContextUniqId(int i);

    public abstract void setDebugEnabled(boolean z);

    public abstract void setDeeplinkEnabled(boolean z);

    public void setDeeplinkListener(DeepLinkListener deepLinkListener) {
        this.mDeeplinkListener = deepLinkListener;
    }

    public abstract void setEnableScroll(boolean z);

    public abstract void setEnableWebCache(boolean z);

    public abstract void setInnerDownloadEnabled(boolean z);

    public abstract void setJavaScriptEnabled(boolean z);

    public abstract void setMixedContentMode(int i);

    public void setRadius(float f, float f2, float f3, float f4) {
        this.mViewRCHelper.setRadius(getRadius(f, f2, f3, f4));
        postInvalidate();
    }

    public abstract void setSavePassword(boolean z);

    public abstract void setTextZoom(int i);

    public void setWebLoadListener(WebLoadListener webLoadListener) {
        this.mWebLoadListener = webLoadListener;
    }

    public void setWebViewStateListener(WebViewStateListener webViewStateListener) {
        this.mWebViewStateListener = webViewStateListener;
    }
}
