package com.anythink.expressad.atsignalcommon.webEnvCheck;

import android.content.ClipDescription;
import android.content.Context;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.d.b.b;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/webEnvCheck/WebEnvCheckEntry.class */
public class WebEnvCheckEntry {
    public void check(Context context) {
        try {
            WindVaneWebView windVaneWebView = new WindVaneWebView(context);
            windVaneWebView.loadDataWithBaseURL(null, "<html><script>" + b.a().b() + "</script></html>", ClipDescription.MIMETYPE_TEXT_HTML, "utf-8", null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
