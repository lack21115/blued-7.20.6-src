package com.anythink.basead.mraid;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge;
import java.lang.ref.WeakReference;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/mraid/a.class */
public final class a implements IBannerJSBridge {
    c a;
    WeakReference<Activity> b;
    private b c;

    private void a(Activity activity) {
        this.b = new WeakReference<>(activity);
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.c = bVar;
        }
    }

    public final void cai(Object obj, String str) {
    }

    public final void click(Object obj, String str) {
    }

    public final void close() {
        b bVar = this.c;
        if (bVar != null) {
            bVar.close();
        }
    }

    public final void expand(String str, boolean z) {
        Activity activity;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putBoolean("shouldUseCustomClose", z);
            if (this.b == null || (activity = this.b.get()) == null) {
                return;
            }
            if (this.a == null || !this.a.isShowing()) {
                c cVar = new c(activity, bundle, this.c);
                this.a = cVar;
                cVar.show();
            }
        } catch (Throwable th) {
        }
    }

    public final void getFileInfo(Object obj, String str) {
    }

    public final com.anythink.expressad.foundation.d.c getMraidCampaign() {
        return null;
    }

    public final void getNetstat(Object obj, String str) {
    }

    public final void gial(Object obj, String str) {
    }

    public final void handlerH5Exception(Object obj, String str) {
    }

    public final void increaseOfferFrequence(Object obj, String str) {
    }

    public final void init(Object obj, String str) {
    }

    public final void install(Object obj, String str) {
    }

    public final void onJSBridgeConnect(Object obj, String str) {
    }

    public final void open(String str) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.open(str);
        }
    }

    public final void openURL(Object obj, String str) {
    }

    public final void readyStatus(Object obj, String str) {
    }

    public final void reportUrls(Object obj, String str) {
    }

    public final void resetCountdown(Object obj, String str) {
    }

    public final void sendImpressions(Object obj, String str) {
    }

    public final void toggleCloseBtn(Object obj, String str) {
    }

    public final void triggerCloseBtn(Object obj, String str) {
    }

    public final void unload() {
        close();
    }

    public final void useCustomClose(boolean z) {
        try {
            if (this.c != null) {
                this.c.useCustomClose(z);
            }
        } catch (Throwable th) {
        }
    }
}
