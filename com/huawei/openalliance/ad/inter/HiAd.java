package com.huawei.openalliance.ad.inter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import android.util.Log;
import com.huawei.hag.abilitykit.api.KitSdkManager;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.consent.inter.Consent;
import com.huawei.hms.ads.ei;
import com.huawei.hms.ads.fk;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.kk;
import com.huawei.openalliance.ad.constant.at;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.ad.inter.listeners.ExtensionActionListener;
import com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.media.IMultiMediaPlayingManager;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.an;
import com.huawei.openalliance.ad.utils.ar;
import com.huawei.openalliance.ad.utils.as;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.l;
import com.huawei.openalliance.ad.utils.q;
import com.huawei.openalliance.ad.utils.v;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/HiAd.class */
public final class HiAd implements IHiAd {
    private static HiAd I;
    private static final String V = "HiAd";
    private static final byte[] Z = new byte[0];
    private Context B;
    private fk C;
    private AppDownloadListener D;
    private IMultiMediaPlayingManager F;
    private IAppDownloadManager L;

    /* renamed from: a  reason: collision with root package name */
    private ExtensionActionListener f9362a;

    /* renamed from: c  reason: collision with root package name */
    private Integer f9363c;
    private boolean d;
    private Map<BroadcastReceiver, IntentFilter> S = new HashMap();
    private int b = -1;
    private BroadcastReceiver e = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.inter.HiAd.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                try {
                    if (intent.getExtras() == null) {
                        return;
                    }
                    if (!intent.getExtras().getBoolean("connected")) {
                        HiAd.this.d = false;
                        return;
                    }
                    HiAd.this.d = true;
                    kk.Code();
                } catch (Throwable th) {
                    ge.I(HiAd.V, "onReceive error:" + th.getClass().getSimpleName());
                }
            }
        }
    };
    private BroadcastReceiver f = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.inter.HiAd.10
        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context context, final Intent intent) {
            if (intent == null) {
                return;
            }
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.10.1
                @Override // java.lang.Runnable
                public void run() {
                    String action = intent.getAction();
                    for (Map.Entry entry : HiAd.this.S.entrySet()) {
                        BroadcastReceiver broadcastReceiver = (BroadcastReceiver) entry.getKey();
                        IntentFilter intentFilter = (IntentFilter) entry.getValue();
                        if (intentFilter != null && intentFilter.matchAction(action)) {
                            broadcastReceiver.onReceive(context, intent);
                        }
                    }
                }
            });
        }
    };
    RequestOptions Code = new RequestOptions.Builder().build();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/HiAd$a.class */
    public static class a implements RemoteCallResultCallback<String> {
        private a() {
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            if (callResult.getCode() == 200) {
                ge.Code(HiAd.V, "success: set install permission in hms, %s", str);
            } else {
                ge.I(HiAd.V, "error: set install permission in hms, %s", str);
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/HiAd$b.class */
    static class b implements Runnable {
        private final AppDownloadListener Code;

        b(AppDownloadListener appDownloadListener) {
            this.Code = appDownloadListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.huawei.openalliance.ad.download.a.Code().Code(this.Code);
        }
    }

    private HiAd(Context context) {
        this.B = context.getApplicationContext();
        D();
        L();
        this.C = fk.Code(this.B);
        a();
        as.Code(this.B);
        B();
        if (isEnableUserInfo()) {
            F();
        }
        S();
        C();
    }

    private void B() {
        if (v.C()) {
            com.huawei.openalliance.ad.utils.f.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.5
                @Override // java.lang.Runnable
                public void run() {
                    Consent.getInstance(HiAd.this.B).getNpaAccordingToServerConsent();
                }
            });
        }
    }

    private void C() {
        if (q.Code()) {
            com.huawei.openalliance.ad.utils.f.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.6
                @Override // java.lang.Runnable
                public void run() {
                    ge.V(HiAd.V, "init abilitySDK retCode is %s", Integer.valueOf(KitSdkManager.getInstance().initSync(HiAd.this.B)));
                }
            });
        }
    }

    public static HiAd Code(Context context) {
        return V(context);
    }

    private void Code(final String str) {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.11
            @Override // java.lang.Runnable
            public void run() {
                Object Code;
                Class Code2 = an.Code(t.ae);
                if (Code2 == null || (Code = an.Code(null, Code2, "getInstance", new Class[]{Context.class}, new Object[]{HiAd.this.B})) == null) {
                    return;
                }
                an.Code(Code, Code2, str, null, null);
            }
        });
    }

    private void D() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.B.registerReceiver(this.f, intentFilter);
    }

    private void F() {
        com.huawei.openalliance.ad.utils.f.V(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.8
            @Override // java.lang.Runnable
            public void run() {
                int ad = HiAd.this.C.ad();
                boolean V2 = l.V(HiAd.this.B);
                ge.V(HiAd.V, "preRequest, type: %s, isTv: %s", Integer.valueOf(ad), Boolean.valueOf(V2));
                if (ad != 0 || V2) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(at.ae, ad);
                        jSONObject.put(at.af, V2);
                        com.huawei.openalliance.ad.ipc.g.V(HiAd.this.B.getApplicationContext()).Code(com.huawei.openalliance.ad.constant.p.u, jSONObject.toString(), null, null);
                    } catch (JSONException e) {
                        ge.I(HiAd.V, "preRequest error.");
                    }
                }
            }
        });
    }

    private void I(Context context) {
        boolean a2 = ay.a(context);
        ge.Code(V, "has install permission is: %s", Boolean.valueOf(a2));
        com.huawei.openalliance.ad.download.app.c.V(context.getApplicationContext(), a2, new a(), String.class);
    }

    private void L() {
        ge.Code(V, "registerUSBObserver");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.hardware.usb.action.USB_STATE");
        this.B.registerReceiver(this.e, intentFilter);
    }

    private void S() {
        com.huawei.openalliance.ad.utils.f.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.7
            @Override // java.lang.Runnable
            public void run() {
                ei.Code(HiAd.this.B);
                com.huawei.hms.ads.f.Code(HiAd.this.B);
            }
        });
    }

    private static HiAd V(Context context) {
        HiAd hiAd;
        synchronized (Z) {
            if (I == null) {
                I = new HiAd(context);
            }
            hiAd = I;
        }
        return hiAd;
    }

    private void a() {
        com.huawei.openalliance.ad.download.app.g.Code(this.B);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        c();
        d();
    }

    private void c() {
        String str = ar.Z(this.B) + File.separator + t.i + File.separator;
        if (au.Code(str)) {
            return;
        }
        com.huawei.openalliance.ad.utils.p.Code(str);
    }

    private void d() {
        String str = ar.B(this.B) + File.separator + t.i + File.separator;
        if (au.Code(str)) {
            return;
        }
        com.huawei.openalliance.ad.utils.p.Code(str);
    }

    public static void disableUserInfo(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("disableUserInfo, context ");
        sb.append(context == null ? "is null" : "not null");
        Log.i(V, sb.toString());
        if (context == null) {
            return;
        }
        fk.Code(context).Code(false);
        getInstance(context).enableUserInfo(false);
    }

    public static IHiAd getInstance(Context context) {
        return V(context);
    }

    public AppDownloadListener Code() {
        return this.D;
    }

    public void Code(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver == null) {
            return;
        }
        this.S.remove(broadcastReceiver);
    }

    public void Code(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (broadcastReceiver == null) {
            return;
        }
        this.S.put(broadcastReceiver, intentFilter);
    }

    public Integer I() {
        return this.f9363c;
    }

    public IMultiMediaPlayingManager V() {
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.F;
        return iMultiMediaPlayingManager != null ? iMultiMediaPlayingManager : com.huawei.openalliance.ad.media.d.Code(this.B);
    }

    public boolean Z() {
        return this.d;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void enableSharePd(boolean z) {
        if (v.Code(this.B)) {
            this.C.V(z);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void enableUserInfo(boolean z) {
        if (v.Code(this.B)) {
            this.C.Code(z);
            if (z) {
                return;
            }
            com.huawei.openalliance.ad.utils.f.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.9
                @Override // java.lang.Runnable
                public void run() {
                    HiAd.this.b();
                }
            });
        }
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public int getAppActivateStyle() {
        return fk.Code(this.B).Y();
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public IAppDownloadManager getAppDownloadManager() {
        if (this.L == null) {
            this.L = (IAppDownloadManager) an.V(t.ad);
        }
        return this.L;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public ExtensionActionListener getExtensionActionListener() {
        return this.f9362a;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public RequestOptions getRequestConfiguration() {
        return this.Code;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void informReady() {
        e.Code(this.B).V();
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void initGrs(String str) {
        try {
            ge.V(V, "initGrs, appName: %s", str);
            Class<?> cls = Class.forName("com.huawei.openalliance.ad.ppskit.utils.ServerConfig");
            an.Code(null, cls, "setGrsAppName", new Class[]{String.class}, new Object[]{str});
            an.Code(null, cls, "init", new Class[]{Context.class}, new Object[]{this.B});
        } catch (Throwable th) {
            ge.I(V, "fail to find ServerConfig in adscore");
        }
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void initGrs(String str, String str2) {
        initGrs(str);
        try {
            ge.V(V, "initGrs, appName: %s, countryCode: %s", str, str2);
            an.Code(null, Class.forName("com.huawei.openalliance.ad.ppskit.utils.ServerConfig"), "setRouterCountryCode", new Class[]{String.class}, new Object[]{str2});
            this.C.Z(str2);
        } catch (Throwable th) {
            ge.I(V, "fail to find ServerConfig in adscore");
        }
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void initLog(boolean z, int i) {
        initLog(z, i, null);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void initLog(boolean z, int i, String str) {
        if (v.Code(this.B) && z) {
            ad.Code(this.B, i, str);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public boolean isAppAutoOpenForbidden() {
        return fk.Code(this.B).ac();
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public boolean isAppInstalledNotify() {
        return fk.Code(this.B).X();
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public boolean isEnableUserInfo() {
        if (v.Code(this.B)) {
            return this.C.f();
        }
        return false;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public boolean isNewProcess() {
        boolean z = this.b != Process.myPid();
        if (z) {
            this.b = Process.myPid();
        }
        ge.V(V, "isNewProcess:" + z);
        return z;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void onBackground() {
        Code("stopTimer");
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void onForeground() {
        Code("startTimer");
        Context context = this.B;
        if (context != null) {
            I(context);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setAppActivateStyle(final int i) {
        com.huawei.openalliance.ad.download.app.c.Code(this.B, isAppInstalledNotify(), i, at.U, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.HiAd.3
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult.getCode() == 200) {
                    fk.Code(HiAd.this.B).F(i);
                }
            }
        }, String.class);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setAppAutoOpenForbidden(final boolean z) {
        ge.V(V, "set app AutoOpenForbidden: " + z);
        com.huawei.openalliance.ad.download.app.c.Code(this.B, z, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.HiAd.4
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult.getCode() == 200) {
                    ge.V(HiAd.V, "set app AutoOpenForbidden: " + z);
                    fk.Code(HiAd.this.B).Z(z);
                }
            }
        }, String.class);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setAppDownloadListener(AppDownloadListener appDownloadListener) {
        this.D = appDownloadListener;
        ba.Code(new b(appDownloadListener));
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setAppInstalledNotify(final boolean z) {
        ge.Code(V, "set app installed notify: " + z);
        com.huawei.openalliance.ad.download.app.c.Code(this.B, z, getAppActivateStyle(), at.T, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.HiAd.2
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult.getCode() == 200) {
                    fk.Code(HiAd.this.B).I(z);
                }
            }
        }, String.class);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setAppMuted(boolean z) {
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setAppVolume(float f) {
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setApplicationCode(String str) {
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setBrand(int i) {
        this.f9363c = Integer.valueOf(i);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setConsent(final String str) {
        ge.V(V, "set TCF consent string");
        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.12
            @Override // java.lang.Runnable
            public void run() {
                com.huawei.openalliance.ad.ipc.d.Code(HiAd.this.B).Code(com.huawei.openalliance.ad.constant.p.n, str, null, null);
            }
        });
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setCountryCode(String str) {
        this.C.Code(str);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setExtensionActionListener(ExtensionActionListener extensionActionListener) {
        this.f9362a = extensionActionListener;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setMultiMediaPlayingManager(IMultiMediaPlayingManager iMultiMediaPlayingManager) {
        this.F = iMultiMediaPlayingManager;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setRequestConfiguration(RequestOptions requestOptions) {
        this.Code = requestOptions;
    }
}
