package com.anythink.expressad.atsignalcommon.bridge;

import android.content.ContentResolver;
import android.content.Context;
import com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.foundation.h.o;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/bridge/BannerJSPlugin.class */
public class BannerJSPlugin extends AbsFeedBackForH5 {
    private final String h = "BannerJSBridge";
    private IBannerJSBridge i;

    public void cai(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "cai");
            if (this.i != null) {
                this.i.cai(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "cai", th);
        }
    }

    public void click(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "click");
            if (this.i != null) {
                this.i.click(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "click", th);
        }
    }

    public void getFileInfo(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "getFileInfo");
            if (this.i != null) {
                this.i.getFileInfo(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "getFileInfo", th);
        }
    }

    public void getNetstat(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "getNetstat");
            if (this.i != null) {
                this.i.getNetstat(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "getNetstat", th);
        }
    }

    public void gial(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "gial");
            if (this.i != null) {
                this.i.gial(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "gial", th);
        }
    }

    public void handlerH5Exception(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "handlerH5Exception");
            if (this.i != null) {
                this.i.handlerH5Exception(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "handlerH5Exception", th);
        }
    }

    public void increaseOfferFrequence(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "increaseOfferFrequence");
            if (this.i != null) {
                this.i.increaseOfferFrequence(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "increaseOfferFrequence", th);
        }
    }

    public void init(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "init");
            if (this.i != null) {
                this.i.init(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "init", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.l
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (context instanceof IBannerJSBridge) {
                this.i = (IBannerJSBridge) context;
            } else if (windVaneWebView.getObject() == null || !(windVaneWebView.getObject() instanceof IBannerJSBridge)) {
            } else {
                this.i = (IBannerJSBridge) windVaneWebView.getObject();
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", ContentResolver.SYNC_EXTRAS_INITIALIZE, th);
        }
    }

    public void install(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "install");
            if (this.i != null) {
                this.i.install(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "install", th);
        }
    }

    public void onJSBridgeConnect(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "onJSBridgeConnect");
            if (this.i != null) {
                this.i.onJSBridgeConnect(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "onJSBridgeConnect", th);
        }
    }

    public void openURL(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "openURL");
            if (this.i != null) {
                this.i.openURL(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "openURL", th);
        }
    }

    public void readyStatus(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "readyStatus");
            if (this.i != null) {
                this.i.readyStatus(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "readyStatus", th);
        }
    }

    public void reportUrls(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "reportUrls");
            if (this.i != null) {
                this.i.reportUrls(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "reportUrls", th);
        }
    }

    public void resetCountdown(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "resetCountdown");
            if (this.i != null) {
                this.i.resetCountdown(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "resetCountdown", th);
        }
    }

    public void sendImpressions(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "sendImpressions");
            if (this.i != null) {
                this.i.sendImpressions(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "sendImpressions", th);
        }
    }

    public void toggleCloseBtn(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "toggleCloseBtn");
            if (this.i != null) {
                this.i.toggleCloseBtn(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "toggleCloseBtn", th);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "triggerCloseBtn");
            if (this.i != null) {
                this.i.triggerCloseBtn(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "triggerCloseBtn", th);
        }
    }
}
