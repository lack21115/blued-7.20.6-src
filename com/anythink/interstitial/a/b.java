package com.anythink.interstitial.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.AdError;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.v;
import com.anythink.interstitial.api.ATInterstitialAutoEventListener;
import com.anythink.interstitial.api.ATInterstitialAutoLoadListener;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/interstitial/a/b.class */
public class b {

    /* renamed from: c  reason: collision with root package name */
    private static volatile b f5966c;

    /* renamed from: a  reason: collision with root package name */
    String f5967a = "InterstitialAuto";
    ATInterstitialAutoLoadListener b = new ATInterstitialAutoLoadListener() { // from class: com.anythink.interstitial.a.b.1
        @Override // com.anythink.interstitial.api.ATInterstitialAutoLoadListener
        public final void onInterstitialAutoLoadFail(final String str, final AdError adError) {
            n.a().a(new Runnable() { // from class: com.anythink.interstitial.a.b.1.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (b.this.d != null) {
                        b.this.d.onInterstitialAutoLoadFail(str, adError);
                    }
                }
            });
        }

        @Override // com.anythink.interstitial.api.ATInterstitialAutoLoadListener
        public final void onInterstitialAutoLoaded(final String str) {
            n.a().a(new Runnable() { // from class: com.anythink.interstitial.a.b.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (b.this.d != null) {
                        b.this.d.onInterstitialAutoLoaded(str);
                    }
                }
            });
        }
    };
    private ATInterstitialAutoLoadListener d;

    public static b a() {
        if (f5966c == null) {
            synchronized (b.class) {
                try {
                    if (f5966c == null) {
                        f5966c = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f5966c;
    }

    private void a(Activity activity, String str, ATInterstitialAutoEventListener aTInterstitialAutoEventListener) {
        a(activity, str, "", aTInterstitialAutoEventListener);
    }

    public static void a(String str, String str2, Map<String, Object> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        n.a().a(str, str2, "3", map);
    }

    public static void a(String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        v.a().a(str, map);
    }

    public static void a(String... strArr) {
        if (strArr == null) {
            return;
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str = strArr[i2];
            if (!TextUtils.isEmpty(str) && !v.a().f(str)) {
                v.a().a(str, true);
                a.a(n.a().E(), str).a(n.a().E(), 3, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, (Map<String, Object>) null);
            }
            i = i2 + 1;
        }
    }

    private ATInterstitialAutoLoadListener b() {
        return this.b;
    }

    public static void b(String... strArr) {
        if (strArr == null) {
            return;
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str = strArr[i2];
            if (!TextUtils.isEmpty(str)) {
                v.a().a(str, false);
                a.a(n.a().g(), str).k();
            }
            i = i2 + 1;
        }
    }

    public static List<ATAdInfo> c(String str) {
        a a2 = a.a(n.a().E(), str);
        if (a2 != null) {
            return a2.a(n.a().E());
        }
        return null;
    }

    private ATAdStatusInfo d(String str) {
        if (n.a().g() == null || TextUtils.isEmpty(n.a().p()) || TextUtils.isEmpty(n.a().q())) {
            Log.e(this.f5967a, "SDK init error!");
            return null;
        }
        a a2 = a.a(n.a().E(), str);
        if (a2 != null) {
            return a2.a(n.a().E(), (Map<String, Object>) null);
        }
        return null;
    }

    public final void a(Activity activity, String str, String str2, ATInterstitialAutoEventListener aTInterstitialAutoEventListener) {
        com.anythink.core.common.k.n.b(str, g.i.n, g.i.s, g.i.h, "");
        if (TextUtils.isEmpty(str)) {
            Log.e(this.f5967a, "PlacementId is Empty!");
        } else if (n.a().g() == null || TextUtils.isEmpty(n.a().p()) || TextUtils.isEmpty(n.a().q())) {
            Log.e(this.f5967a, "Show error: SDK init error!");
        } else {
            if (activity == null) {
                Log.e(this.f5967a, "Interstitial Show Activity is null.");
            }
            a.a(activity, str).a(activity, str2, new c(aTInterstitialAutoEventListener), (ATEventInterface) null, (Map<String, Object>) null);
        }
    }

    public final void a(Context context, String[] strArr, ATInterstitialAutoLoadListener aTInterstitialAutoLoadListener) {
        if (context instanceof Activity) {
            n.a().a((Activity) context);
        }
        if (strArr != null) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str = strArr[i2];
                if (!v.a().f(str)) {
                    v.a().a(str, true);
                    a.a(context, str).a(context, 3, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, (Map<String, Object>) null);
                }
                i = i2 + 1;
            }
        }
        this.d = aTInterstitialAutoLoadListener;
    }

    public final boolean a(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            ATAdStatusInfo d = d(str);
            if (d == null) {
                return false;
            }
            z = d.isReady();
        }
        com.anythink.core.common.k.n.b(str, g.i.n, g.i.t, String.valueOf(z), "");
        return z;
    }

    public final ATAdStatusInfo b(String str) {
        ATAdStatusInfo aTAdStatusInfo;
        if (TextUtils.isEmpty(str)) {
            aTAdStatusInfo = new ATAdStatusInfo(false, false, (ATAdInfo) null);
        } else {
            ATAdStatusInfo d = d(str);
            aTAdStatusInfo = d;
            if (d == null) {
                aTAdStatusInfo = new ATAdStatusInfo(false, false, (ATAdInfo) null);
            }
        }
        com.anythink.core.common.k.n.b(str, g.i.n, g.i.u, aTAdStatusInfo.toString(), "");
        return aTAdStatusInfo;
    }
}
