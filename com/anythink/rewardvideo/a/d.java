package com.anythink.rewardvideo.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.j;
import com.anythink.core.common.b.n;
import com.anythink.core.common.v;
import com.anythink.rewardvideo.api.ATRewardVideoAutoEventListener;
import com.anythink.rewardvideo.api.ATRewardVideoAutoLoadListener;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/rewardvideo/a/d.class */
public class d {

    /* renamed from: c  reason: collision with root package name */
    private static volatile d f6338c;

    /* renamed from: a  reason: collision with root package name */
    String f6339a = "RewardVideoAuto";
    ATRewardVideoAutoLoadListener b = new ATRewardVideoAutoLoadListener() { // from class: com.anythink.rewardvideo.a.d.1
        @Override // com.anythink.rewardvideo.api.ATRewardVideoAutoLoadListener
        public final void onRewardVideoAutoLoadFail(final String str, final AdError adError) {
            n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.a.d.1.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (d.this.d != null) {
                        d.this.d.onRewardVideoAutoLoadFail(str, adError);
                    }
                }
            });
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoAutoLoadListener
        public final void onRewardVideoAutoLoaded(final String str) {
            n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.a.d.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (d.this.d != null) {
                        d.this.d.onRewardVideoAutoLoaded(str);
                    }
                }
            });
        }
    };
    private ATRewardVideoAutoLoadListener d;

    public static d a() {
        if (f6338c == null) {
            synchronized (d.class) {
                try {
                    if (f6338c == null) {
                        f6338c = new d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6338c;
    }

    private void a(Activity activity, String str, ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener) {
        a(activity, str, "", aTRewardVideoAutoEventListener);
    }

    public static void a(String str, String str2, Map<String, Object> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        n.a().a(str, str2, "1", map);
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

    private ATRewardVideoAutoLoadListener b() {
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

    private ATAdStatusInfo d(String str) {
        if (n.a().g() == null || TextUtils.isEmpty(n.a().p()) || TextUtils.isEmpty(n.a().q())) {
            Log.e(this.f6339a, "SDK init error!");
            return null;
        }
        a a2 = a.a(n.a().E(), str);
        if (a2 != null) {
            return a2.a(n.a().E(), (Map<String, Object>) null);
        }
        return null;
    }

    public final void a(Activity activity, String str, String str2, ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener) {
        com.anythink.core.common.k.n.b(str, g.i.o, g.i.s, g.i.h, "");
        if (TextUtils.isEmpty(str)) {
            AdError errorCode = ErrorCode.getErrorCode("9999", "", "placementId is empty.");
            if (aTRewardVideoAutoEventListener != null) {
                aTRewardVideoAutoEventListener.onRewardedVideoAdPlayFailed(errorCode, j.a((com.anythink.core.common.b.d) null));
            }
            Log.e(this.f6339a, "PlacementId is Empty!");
        }
        if (n.a().g() != null && !TextUtils.isEmpty(n.a().p()) && !TextUtils.isEmpty(n.a().q())) {
            if (activity == null) {
                Log.e(this.f6339a, "RewardedVideo Show Activity is null.");
            }
            a.a(activity, str).a(activity, str2, new c(aTRewardVideoAutoEventListener), (ATEventInterface) null, (Map<String, Object>) null);
            return;
        }
        AdError errorCode2 = ErrorCode.getErrorCode("9999", "", "sdk init error");
        if (aTRewardVideoAutoEventListener != null) {
            aTRewardVideoAutoEventListener.onRewardedVideoAdPlayFailed(errorCode2, j.a((com.anythink.core.common.b.d) null));
        }
        Log.e(this.f6339a, "SDK init error!");
    }

    public final void a(Context context, String[] strArr, ATRewardVideoAutoLoadListener aTRewardVideoAutoLoadListener) {
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
                if (!TextUtils.isEmpty(str) && !v.a().f(str)) {
                    v.a().a(str, true);
                    a.a(context, str).a(context, 3, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, (Map<String, Object>) null);
                }
                i = i2 + 1;
            }
        }
        this.d = aTRewardVideoAutoLoadListener;
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
        com.anythink.core.common.k.n.b(str, g.i.o, g.i.t, String.valueOf(z), "");
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
        com.anythink.core.common.k.n.b(str, g.i.o, g.i.u, aTAdStatusInfo.toString(), "");
        return aTAdStatusInfo;
    }

    public final List<ATAdInfo> c(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(this.f6339a, "PlacementId is empty.");
            return null;
        }
        a a2 = a.a(n.a().E(), str);
        if (a2 != null) {
            return a2.a(n.a().E());
        }
        return null;
    }
}
