package com.anythink.expressad.advanced.view;

import android.content.Context;
import android.content.IntentFilter;
import com.anythink.expressad.advanced.a.c;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.foundation.h.o;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/view/ATNativeAdvancedWebview.class */
public class ATNativeAdvancedWebview extends WindVaneWebView {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4213a = ATNativeAdvancedWebview.class.getSimpleName();
    private c b;

    public ATNativeAdvancedWebview(Context context) {
        super(context);
        setBackgroundColor(0);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerNetWorkReceiver();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        unregisterNetWorkReceiver();
    }

    public void registerNetWorkReceiver() {
        try {
            if (this.b == null) {
                this.b = new c(this);
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            getContext().registerReceiver(this.b, intentFilter);
        } catch (Throwable th) {
            o.a(f4213a, th.getMessage());
        }
    }

    public void unregisterNetWorkReceiver() {
        try {
            if (this.b != null) {
                this.b.a();
                getContext().unregisterReceiver(this.b);
            }
        } catch (Throwable th) {
            o.a(f4213a, th.getMessage());
        }
    }
}
