package com.anythink.expressad.atsignalcommon.windvane;

import android.content.Context;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/windvane/l.class */
public abstract class l {
    protected Context e;
    protected Object f;
    protected WindVaneWebView g;

    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        this.e = context;
        this.g = windVaneWebView;
    }

    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        this.f = obj;
        this.g = windVaneWebView;
    }
}
