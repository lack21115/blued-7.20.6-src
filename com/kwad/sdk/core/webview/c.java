package com.kwad.sdk.core.webview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import com.kwad.sdk.j.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bn;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/c.class */
public class c extends WebView {
    private boolean apu;
    private com.kwad.sdk.core.webview.kwai.a apv;

    public c(Context context) {
        super(be(context));
        this.apu = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet) {
        super(be(context), attributeSet);
        this.apu = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(be(context), attributeSet, i);
        this.apu = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet, int i, int i2) {
        super(be(context), attributeSet, i, i2);
        this.apu = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(be(context), attributeSet, i, z);
        this.apu = true;
        init();
    }

    private static Context be(Context context) {
        Context context2 = context;
        if (Build.VERSION.SDK_INT >= 21) {
            context2 = context;
            if (Build.VERSION.SDK_INT < 23) {
                context2 = context.createConfigurationContext(new Configuration());
            }
        }
        Context dl = k.dl(context2);
        Context context3 = dl;
        if (!k.m7853do(dl)) {
            ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(new IllegalArgumentException("KSApiWebView context not except--context:" + dl.getClass().getName() + "--classloader:" + dl.getClass().getClassLoader() + "--context2:" + k.dl(ServiceProvider.CA()).getClass().getName()));
            context3 = k.dl(ServiceProvider.CA());
        }
        return context3;
    }

    private void init() {
        bn.a(this);
        com.kwad.sdk.core.webview.kwai.a aVar = new com.kwad.sdk.core.webview.kwai.a();
        this.apv = aVar;
        setWebViewClient(aVar);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        if (this.apu) {
            release();
        }
    }

    public final void release() {
        try {
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this);
            }
            removeAllViews();
            super.destroy();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
    }

    public void setEnableDestroy(boolean z) {
        this.apu = z;
    }

    public void setNeedHybridLoad(boolean z) {
        this.apv.setNeedHybridLoad(z);
    }
}
