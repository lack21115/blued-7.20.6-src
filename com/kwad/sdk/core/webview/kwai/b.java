package com.kwad.sdk.core.webview.kwai;

import android.graphics.Bitmap;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/kwai/b.class */
public final class b extends WebChromeClient {
    @Override // android.webkit.WebChromeClient
    public final Bitmap getDefaultVideoPoster() {
        Bitmap defaultVideoPoster = super.getDefaultVideoPoster();
        Bitmap bitmap = defaultVideoPoster;
        if (defaultVideoPoster == null) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
            bitmap.eraseColor(0);
        }
        return bitmap;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        Tracker.onProgressChanged(this, webView, i);
        super.onProgressChanged(webView, i);
    }
}
