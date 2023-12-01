package com.anythink.expressad.atsignalcommon.communication;

import android.content.ContentResolver;
import android.content.Context;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.l;
import com.anythink.expressad.foundation.h.o;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/communication/BannerSignalPlugin.class */
public class BannerSignalPlugin extends l {

    /* renamed from: a  reason: collision with root package name */
    private final String f7081a = "BannerSignalPlugin";
    private b b;

    public void click(Object obj, String str) {
        try {
            o.d("BannerSignalPlugin", "click");
        } catch (Throwable th) {
            o.b("BannerSignalPlugin", "click", th);
        }
    }

    public void getFileInfo(Object obj, String str) {
        try {
            o.d("BannerSignalPlugin", "getFileInfo");
        } catch (Throwable th) {
            o.b("BannerSignalPlugin", "getFileInfo", th);
        }
    }

    public void getNetstat(Object obj, String str) {
        try {
            o.d("BannerSignalPlugin", "getNetstat");
        } catch (Throwable th) {
            o.b("BannerSignalPlugin", "getNetstat", th);
        }
    }

    public void handlerH5Exception(Object obj, String str) {
        try {
            o.d("BannerSignalPlugin", "handlerH5Exception");
        } catch (Throwable th) {
            o.b("BannerSignalPlugin", "handlerH5Exception", th);
        }
    }

    public void increaseOfferFrequence(Object obj, String str) {
        try {
            o.d("BannerSignalPlugin", "increaseOfferFrequence");
        } catch (Throwable th) {
            o.b("BannerSignalPlugin", "increaseOfferFrequence", th);
        }
    }

    public void init(Object obj, String str) {
        try {
            o.d("BannerSignalPlugin", "init");
        } catch (Throwable th) {
            o.b("BannerSignalPlugin", "init", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.l
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (context instanceof b) {
                this.b = (b) context;
            } else if (windVaneWebView.getObject() == null || !(windVaneWebView.getObject() instanceof b)) {
            } else {
                this.b = (b) windVaneWebView.getObject();
            }
        } catch (Throwable th) {
            o.b("BannerSignalPlugin", ContentResolver.SYNC_EXTRAS_INITIALIZE, th);
        }
    }

    public void install(Object obj, String str) {
        try {
            o.d("BannerSignalPlugin", "install");
        } catch (Throwable th) {
            o.b("BannerSignalPlugin", "install", th);
        }
    }

    public void onSignalCommunication(Object obj, String str) {
        try {
            o.d("BannerSignalPlugin", "onSignalCommunication");
        } catch (Throwable th) {
            o.b("BannerSignalPlugin", "onSignalCommunication", th);
        }
    }

    public void openURL(Object obj, String str) {
        try {
            o.d("BannerSignalPlugin", "openURL");
        } catch (Throwable th) {
            o.b("BannerSignalPlugin", "openURL", th);
        }
    }

    public void readyStatus(Object obj, String str) {
        try {
            o.d("BannerSignalPlugin", "readyStatus");
        } catch (Throwable th) {
            o.b("BannerSignalPlugin", "readyStatus", th);
        }
    }

    public void reportUrls(Object obj, String str) {
        try {
            o.d("BannerSignalPlugin", "reportUrls");
        } catch (Throwable th) {
            o.b("BannerSignalPlugin", "reportUrls", th);
        }
    }

    public void resetCountdown(Object obj, String str) {
        try {
            o.d("BannerSignalPlugin", "resetCountdown");
        } catch (Throwable th) {
            o.b("BannerSignalPlugin", "resetCountdown", th);
        }
    }

    public void sendImpressions(Object obj, String str) {
        try {
            o.d("BannerSignalPlugin", "sendImpressions");
        } catch (Throwable th) {
            o.b("BannerSignalPlugin", "sendImpressions", th);
        }
    }

    public void toggleCloseBtn(Object obj, String str) {
        try {
            o.d("BannerSignalPlugin", "toggleCloseBtn");
        } catch (Throwable th) {
            o.b("BannerSignalPlugin", "toggleCloseBtn", th);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        try {
            o.d("BannerSignalPlugin", "triggerCloseBtn");
        } catch (Throwable th) {
            o.b("BannerSignalPlugin", "triggerCloseBtn", th);
        }
    }
}
