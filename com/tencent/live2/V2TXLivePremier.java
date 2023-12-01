package com.tencent.live2;

import android.content.Context;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.impl.a;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/live2/V2TXLivePremier.class */
public class V2TXLivePremier {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/live2/V2TXLivePremier$V2TXLivePremierObserver.class */
    public static abstract class V2TXLivePremierObserver {
        public void onLicenceLoaded(int i, String str) {
        }

        public void onLog(int i, String str) {
        }
    }

    public static String getSDKVersionStr() {
        return a.a();
    }

    public static void setEnvironment(String str) {
        a.a(str);
    }

    public static void setLicence(Context context, String str, String str2) {
        a.a(context, str, str2);
    }

    public static void setLogConfig(V2TXLiveDef.V2TXLiveLogConfig v2TXLiveLogConfig) {
        a.a(v2TXLiveLogConfig);
    }

    public static void setObserver(V2TXLivePremierObserver v2TXLivePremierObserver) {
        a.a(v2TXLivePremierObserver);
    }

    public static void setSocks5Proxy(String str, int i, String str2, String str3) {
        a.a(str, i, str2, str3);
    }
}
