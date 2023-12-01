package com.anythink.core.api;

import android.content.Context;
import android.location.Location;
import android.util.Log;
import com.anythink.core.common.b.n;
import com.anythink.core.common.b.p;
import com.anythink.core.common.g.e;
import com.anythink.core.common.g.i;
import com.anythink.core.common.k.b.a;
import com.anythink.core.common.k.g;
import com.anythink.core.common.u;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATSDK.class */
public class ATSDK {
    private static boolean HAS_INIT = false;
    public static final int NONPERSONALIZED = 1;
    public static final int PERSONALIZED = 0;
    public static final int UNKNOWN = 2;

    private ATSDK() {
    }

    public static void addCustomAdapterConfig(String str, ATCustomAdapterConfig aTCustomAdapterConfig) {
        n.a().a(str, aTCustomAdapterConfig);
    }

    public static void checkIsEuTraffic(Context context, NetTrafficeCallback netTrafficeCallback) {
        p.a(context).a(netTrafficeCallback);
    }

    public static void deniedUploadDeviceInfo(String... strArr) {
        n.a().a(strArr);
    }

    public static void getArea(final ATAreaCallback aTAreaCallback) {
        if (aTAreaCallback == null) {
            return;
        }
        new e().a(0, new i() { // from class: com.anythink.core.api.ATSDK.2
            @Override // com.anythink.core.common.g.i
            public final void onLoadCanceled(int i) {
                ATAreaCallback.this.onErrorCallback("Request cancel");
            }

            @Override // com.anythink.core.common.g.i
            public final void onLoadError(int i, String str, AdError adError) {
                ATAreaCallback.this.onErrorCallback(adError.printStackTrace());
            }

            @Override // com.anythink.core.common.g.i
            public final void onLoadFinish(int i, Object obj) {
                try {
                    if (obj == null) {
                        ATAreaCallback.this.onErrorCallback("There is no result.");
                        return;
                    }
                    JSONObject jSONObject = new JSONObject((String) obj);
                    if (!jSONObject.has("area")) {
                        ATAreaCallback.this.onErrorCallback("There is no result.");
                        return;
                    }
                    ATAreaCallback.this.onResultCallback(jSONObject.optString("area"));
                } catch (Throwable th) {
                    ATAreaCallback.this.onErrorCallback("Internal error");
                }
            }

            @Override // com.anythink.core.common.g.i
            public final void onLoadStart(int i) {
            }
        });
    }

    public static int getGDPRDataLevel(Context context) {
        return p.a(context).a();
    }

    public static int getPersionalizedAdStatus() {
        return n.a().e();
    }

    public static String getSDKVersionName() {
        return g.a();
    }

    public static void init(Context context, String str, String str2) {
        init(context, str, str2, null);
    }

    public static void init(Context context, String str, String str2, ATNetworkConfig aTNetworkConfig) {
        init(context, str, str2, aTNetworkConfig, null);
    }

    @Deprecated
    public static void init(Context context, String str, String str2, ATNetworkConfig aTNetworkConfig, ATSDKInitListener aTSDKInitListener) {
        try {
            if (context == null) {
                if (aTSDKInitListener != null) {
                    aTSDKInitListener.onFail("init: Context is null!");
                }
                Log.e(com.anythink.core.common.b.g.n, "init: Context is null!");
                return;
            }
            n.a().a(context, str, str2, aTNetworkConfig);
            if (aTSDKInitListener != null) {
                aTSDKInitListener.onSuccess();
            }
            a.a().a(new Runnable() { // from class: com.anythink.core.api.ATSDK.1
                @Override // java.lang.Runnable
                public final void run() {
                    u.a().b();
                }
            });
        } catch (Error | Exception e) {
        }
    }

    public static void initCustomMap(Map<String, Object> map) {
        n.a().a(map);
    }

    public static void initPlacementCustomMap(String str, Map<String, Object> map) {
        n.a().a(str, map);
    }

    public static void integrationChecking(Context context) {
        n.a().b(context);
    }

    public static boolean isCnSDK() {
        return n.a().b() != null;
    }

    public static boolean isEUTraffic(Context context) {
        return p.a(context).d();
    }

    public static boolean isNetworkLogDebug() {
        return n.a().A();
    }

    public static void setATAdFilter(String[] strArr, IATAdFilter iATAdFilter) {
        n.a().a(strArr, iATAdFilter);
    }

    public static void setATPrivacyConfig(ATPrivacyConfig aTPrivacyConfig) {
        n.a().a(aTPrivacyConfig);
    }

    public static void setAdLogoVisible(boolean z) {
        n.a().c(z);
    }

    public static void setChannel(String str) {
        if (g.a(str)) {
            n.a().e(str);
        }
    }

    public static void setDebuggerConfig(Context context, String str, ATDebuggerConfig aTDebuggerConfig) {
        n.a().a(context, str, aTDebuggerConfig);
    }

    public static void setExcludePackageList(List<String> list) {
        n.a().a(list);
    }

    public static void setFilterAdSourceIdList(String str, List<String> list) {
        n.a().a(str, list);
    }

    public static void setFilterNetworkFirmIdList(String str, List<String> list) {
        n.a().b(str, list);
    }

    public static void setGDPRUploadDataLevel(Context context, int i) {
        if (context == null) {
            Log.e(com.anythink.core.common.b.g.n, "setGDPRUploadDataLevel: context should not be null");
        } else if (i == 0 || i == 1) {
            p.a(context).a(i);
        } else {
            Log.e(com.anythink.core.common.b.g.n, "GDPR level setting error!!! Level must be PERSONALIZED or NONPERSONALIZED.");
        }
    }

    public static void setInitType(int i) {
        n.a().b(i);
    }

    public static void setLocation(Location location) {
        n.a().a(location);
    }

    public static void setNetworkLogDebug(boolean z) {
        n.a().b(z);
    }

    public static void setPersonalizedAdStatus(int i) {
        n.a().a(i);
    }

    public static void setSubChannel(String str) {
        if (g.b(str)) {
            n.a().f(str);
        }
    }

    public static void setSystemDevFragmentType(String str) {
        n.a().p(str);
    }

    public static void setUseHTTP(boolean z) {
        n.a().d(z);
    }

    public static void setWXAppId(String str) {
        n.a().a(str);
    }

    public static void setWXStatus(boolean z) {
        n.a().a(z);
    }

    public static void showGdprAuth(Context context) {
        p.a(context).a(context, null);
    }

    public static void showGdprAuth(Context context, ATGDPRAuthCallback aTGDPRAuthCallback) {
        p.a(context).a(context, aTGDPRAuthCallback);
    }

    public static void testModeDeviceInfo(Context context, DeviceInfoCallback deviceInfoCallback) {
        n.a().a(context, deviceInfoCallback);
    }
}
