package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.co;
import com.baidu.mobads.sdk.internal.cq;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/CpuAdView.class */
public final class CpuAdView extends RelativeLayout {
    private cq mAdProd;

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/CpuAdView$CpuAdViewInternalStatusListener.class */
    public interface CpuAdViewInternalStatusListener {
        void loadDataError(String str);

        void onAdClick();

        void onAdImpression(String str);

        void onContentClick();

        void onContentImpression(String str);

        void onExitLp();

        void onLpContentStatus(Map<String, Object> map);
    }

    public CpuAdView(Context context) {
        super(context);
    }

    public CpuAdView(Context context, String str, int i, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        co coVar = new co(context);
        this.mAdProd = new cq(context, coVar, str, i, cPUWebAdRequestParam);
        addView(coVar, new ViewGroup.LayoutParams(-1, -1));
    }

    public CpuAdView(Context context, String str, int i, CPUWebAdRequestParam cPUWebAdRequestParam, CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener) {
        super(context);
        co coVar = new co(context);
        cq cqVar = new cq(context, coVar, str, i, cPUWebAdRequestParam);
        this.mAdProd = cqVar;
        cqVar.a(cpuAdViewInternalStatusListener);
        addView(coVar, new ViewGroup.LayoutParams(-1, -1));
    }

    protected boolean canGoBack() {
        boolean z = false;
        try {
            WebView webView = (WebView) this.mAdProd.v();
            if (webView != null) {
                z = webView.canGoBack();
            }
            return z;
        } catch (Throwable th) {
            return false;
        }
    }

    protected void goBack() {
        try {
            WebView webView = (WebView) this.mAdProd.v();
            if (webView != null) {
                webView.goBack();
            }
        } catch (Throwable th) {
        }
    }

    public void onDestroy() {
        View v = this.mAdProd.v();
        if (v instanceof WebView) {
            ((WebView) v).destroy();
        }
    }

    public boolean onKeyBackDown(int i, KeyEvent keyEvent) {
        if (i == 4 && canGoBack()) {
            goBack();
            return true;
        }
        return false;
    }

    public void onPause() {
        View v = this.mAdProd.v();
        if (v instanceof WebView) {
            ((WebView) v).onPause();
        }
    }

    public void onResume() {
        View v = this.mAdProd.v();
        if (v instanceof WebView) {
            ((WebView) v).onResume();
        }
    }

    public void requestData() {
        cq cqVar = this.mAdProd;
        if (cqVar != null) {
            cqVar.a();
        }
    }
}
