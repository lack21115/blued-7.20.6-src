package com.tencent.tmsbeacon.event.open;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.opos.acs.st.utils.ErrorContants;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.tmsbeacon.a.b.d;
import com.tencent.tmsbeacon.a.c.f;
import com.tencent.tmsbeacon.base.net.b.b;
import com.tencent.tmsbeacon.base.util.BeaconLogger;
import com.tencent.tmsbeacon.base.util.c;
import com.tencent.tmsbeacon.base.util.e;
import com.tencent.tmsbeacon.core.info.BeaconPubParams;
import com.tencent.tmsbeacon.event.immediate.IBeaconImmediateReport;
import com.tencent.tmsbeacon.event.open.EventResult;
import com.tencent.tmsbeacon.module.BeaconModule;
import com.tencent.tmsbeacon.module.EventModule;
import com.tencent.tmsbeacon.module.ModuleName;
import com.tencent.tmsbeacon.qimei.IAsyncQimeiListener;
import com.tencent.tmsbeacon.qimei.Qimei;
import com.tencent.tmsbeacon.qimei.QimeiSDK;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/open/BeaconReport.class */
public final class BeaconReport {

    /* renamed from: a  reason: collision with root package name */
    private static volatile BeaconReport f39590a;
    private static String b = "";

    /* renamed from: c  reason: collision with root package name */
    private Context f39591c;
    private boolean d;
    private String e;
    private BeaconConfig f;
    private boolean g;
    private String h;
    private IBeaconImmediateReport i;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/open/BeaconReport$a.class */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BeaconReport.this.b();
                BeaconReport.this.a();
                BeaconReport.this.c();
                e.a(BeaconReport.this.f39591c);
                c.a("BeaconReport", "App: %s start success!", BeaconReport.this.e);
            } catch (Throwable th) {
                d b = d.b();
                b.a(ErrorContants.REALTIME_LOADAD_ERROR, "sdk init error! msg:" + th.getMessage(), th);
                c.b("BeaconReport init error: " + th.getMessage(), new Object[0]);
                c.a(th);
            }
        }
    }

    private BeaconReport() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        c.a(this.g);
        BeaconConfig beaconConfig = this.f;
        if (beaconConfig != null) {
            c.a("BeaconReport", beaconConfig.toString(), new Object[0]);
            b.a(this.f.getConfigHost(), this.f.getUploadHost());
            d();
            com.tencent.tmsbeacon.a.c.c.d().a(this.f.isEnableQmsp());
        }
        com.tencent.tmsbeacon.base.net.c c2 = com.tencent.tmsbeacon.base.net.c.c();
        Context context = this.f39591c;
        BeaconConfig beaconConfig2 = this.f;
        c2.a(context, beaconConfig2 == null ? null : beaconConfig2.getHttpAdapter());
        com.tencent.tmsbeacon.a.d.a.a().a(this.f39591c);
        com.tencent.tmsbeacon.a.c.b.f();
        com.tencent.tmsbeacon.a.c.e.l().B();
    }

    private void a(BeaconConfig beaconConfig) {
        f e = f.e();
        if (!TextUtils.isEmpty(beaconConfig.getAndroidID())) {
            e.a(beaconConfig.getAndroidID());
        }
        if (!TextUtils.isEmpty(beaconConfig.getImei())) {
            e.b(beaconConfig.getImei());
        }
        if (!TextUtils.isEmpty(beaconConfig.getImei2())) {
            e.c(beaconConfig.getImei2());
        }
        if (!TextUtils.isEmpty(beaconConfig.getImsi())) {
            e.d(beaconConfig.getImsi());
        }
        if (!TextUtils.isEmpty(beaconConfig.getMeid())) {
            e.f(beaconConfig.getMeid());
        }
        if (!TextUtils.isEmpty(beaconConfig.getModel())) {
            e.g(beaconConfig.getModel());
        }
        if (!TextUtils.isEmpty(beaconConfig.getMac())) {
            e.e(beaconConfig.getMac());
        }
        if (!TextUtils.isEmpty(beaconConfig.getWifiMacAddress())) {
            e.i(beaconConfig.getWifiMacAddress());
        }
        if (!TextUtils.isEmpty(beaconConfig.getWifiSSID())) {
            e.j(beaconConfig.getWifiSSID());
        }
        if (TextUtils.isEmpty(beaconConfig.getOaid())) {
            return;
        }
        e.h(beaconConfig.getOaid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.tencent.tmsbeacon.a.c.c d = com.tencent.tmsbeacon.a.c.c.d();
        d.a(this.f39591c);
        d.c(this.e);
        QimeiSDK.getInstance().setAppKey(this.e);
        d.a(this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        ModuleName[] values = ModuleName.values();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 5) {
                break;
            }
            ModuleName moduleName = values[i2];
            try {
                BeaconModule.f39592a.put(moduleName, com.tencent.tmsbeacon.event.c.d.f(moduleName.getClassName()));
            } catch (Exception e) {
                c.b("init Module error: " + e.getMessage(), new Object[0]);
                c.a(e);
            }
            i = i2 + 1;
        }
        int length = values.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                QimeiSDK.getInstance().init(this.f39591c);
                return;
            }
            BeaconModule beaconModule = BeaconModule.f39592a.get(values[i4]);
            if (beaconModule != null) {
                beaconModule.a(this.f39591c);
            }
            i3 = i4 + 1;
        }
    }

    private void d() {
        HashMap hashMap = new HashMap();
        hashMap.put("u_c_a_e", Boolean.valueOf(this.f.isAuditEnable()));
        hashMap.put("u_c_b_e", Boolean.valueOf(this.f.isBidEnable()));
        hashMap.put("u_c_d_s", Integer.valueOf(this.f.getMaxDBCount()));
        hashMap.put("u_c_p_s", Boolean.valueOf(this.f.isPagePathEnable()));
        hashMap.put("u_s_o_h", Boolean.valueOf(this.f.isSocketMode()));
        com.tencent.tmsbeacon.a.a.b.a().b(new com.tencent.tmsbeacon.a.a.c(8, hashMap));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("s_e_e", Boolean.valueOf(this.f.isEventReportEnable()));
        com.tencent.tmsbeacon.a.a.b.a().b(new com.tencent.tmsbeacon.a.a.c(7, hashMap2));
        HashMap hashMap3 = new HashMap();
        hashMap3.put("u_c_r_p", Long.valueOf(this.f.getRealtimePollingTime()));
        hashMap3.put("u_c_n_p", Long.valueOf(this.f.getNormalPollingTIme()));
        com.tencent.tmsbeacon.a.a.b.a().b(new com.tencent.tmsbeacon.a.a.c(11, hashMap3));
    }

    public static BeaconReport getInstance() {
        if (f39590a == null) {
            synchronized (BeaconReport.class) {
                try {
                    if (f39590a == null) {
                        f39590a = new BeaconReport();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f39590a;
    }

    public static String getSoPath() {
        return b;
    }

    public static void setSoPath(String str) {
        b = str;
    }

    public BeaconPubParams getCommonParams(Context context) {
        if (context == null) {
            return null;
        }
        return BeaconPubParams.getPubParams(context);
    }

    public IBeaconImmediateReport getImmediateReport() {
        return this.i;
    }

    @Deprecated
    public String getOAID() {
        c.b("this method do not collect OAID, use method in qmsp instead", new Object[0]);
        return f.e().i();
    }

    public Qimei getQimei() {
        return QimeiSDK.getInstance().getQimei();
    }

    public void getQimei(IAsyncQimeiListener iAsyncQimeiListener) {
        QimeiSDK.getInstance().getQimei(iAsyncQimeiListener);
    }

    public Qimei getRtQimei(Context context) {
        if (context == null) {
            return null;
        }
        com.tencent.tmsbeacon.a.c.c.d().a(context.getApplicationContext());
        return QimeiSDK.getInstance().getQimei();
    }

    public String getSDKVersion() {
        return "4.1.26.5-hf";
    }

    public EventResult report(BeaconEvent beaconEvent) {
        try {
            if (TextUtils.isEmpty(beaconEvent.getCode())) {
                return EventResult.a.a(106);
            }
            BeaconEvent build = BeaconEvent.newBuilder(beaconEvent).build();
            EventModule eventModule = (EventModule) com.tencent.tmsbeacon.a.c.c.d().a(ModuleName.EVENT);
            if (eventModule == null || !eventModule.d()) {
                HashMap hashMap = new HashMap();
                hashMap.put("b_e", build);
                com.tencent.tmsbeacon.a.a.b.a().a(new com.tencent.tmsbeacon.a.a.c(6, hashMap));
                return new EventResult(0, -1L, "Beacon SDK not init beaconEvent add to cache!");
            }
            return eventModule.a(build);
        } catch (Throwable th) {
            c.a(th);
            d.b().a("598", "error while report", th);
            return new EventResult(199, -1L, "REPORT ERROR");
        }
    }

    public void resumeReport() {
        c.a("BeaconReport", "resume report by user.", new Object[0]);
        com.tencent.tmsbeacon.a.b.a.a().c();
        com.tencent.tmsbeacon.base.net.c.c().e();
    }

    public void setAdditionalParams(String str, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("i_c_ad", new HashMap(map));
        hashMap.put("i_c_ak", str);
        com.tencent.tmsbeacon.a.a.b.a().b(new com.tencent.tmsbeacon.a.a.c(3, hashMap));
    }

    public void setAdditionalParams(Map<String, String> map) {
        setAdditionalParams(this.e, map);
    }

    public void setAndroidID(String str) {
        f.e().a(str);
    }

    public void setAppVersion(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.tmsbeacon.a.c.b.f39471a = str;
    }

    public void setChannelID(String str) {
        this.h = str;
        com.tencent.tmsbeacon.a.c.c.d().a(str);
    }

    @Deprecated
    public void setCollectAndroidID(boolean z) {
        c.b("setCollectAndroidID has been Deprecated since 4.1.24", new Object[0]);
    }

    @Deprecated
    public void setCollectImei(boolean z) {
        c.b("setCollectImei has been Deprecated since 4.1.24", new Object[0]);
    }

    @Deprecated
    public void setCollectMac(boolean z) {
        c.b("setCollectMac has been Deprecated since 4.1.24", new Object[0]);
    }

    @Deprecated
    public void setCollectModel(boolean z) {
        c.b("setCollectModel has been Deprecated since 4.1.24", new Object[0]);
    }

    @Deprecated
    public void setCollectOAID(boolean z) {
        c.b("setCollectOAID has been Deprecated since 4.1.24", new Object[0]);
    }

    @Deprecated
    public void setCollectPersonalInfo(boolean z) {
        c.b("setCollectPersonalInfo has been Deprecated since 4.1.24", new Object[0]);
    }

    public void setCollectProcessInfo(boolean z) {
        com.tencent.tmsbeacon.d.b.a().a(z);
    }

    public void setImei(String str) {
        f.e().b(str);
    }

    public void setImei2(String str) {
        f.e().c(str);
    }

    public void setImmediateReport(IBeaconImmediateReport iBeaconImmediateReport) {
        this.i = iBeaconImmediateReport;
    }

    public void setImsi(String str) {
        f.e().d(str);
    }

    public void setLogAble(boolean z) {
        this.g = z;
        c.a(z);
    }

    public void setLogger(BeaconLogger beaconLogger) {
        c.a(beaconLogger);
    }

    public void setMac(String str) {
        f.e().e(str);
    }

    public void setMeid(String str) {
        f.e().f(str);
    }

    public void setModel(String str) {
        f.e().g(str);
    }

    public void setOAID(String str) {
        f.e().h(str);
    }

    @Deprecated
    public void setOaid(String str) {
        f.e().h(str);
        c.b("setOaid has been Deprecated since 4.1.24, please use setOAID", new Object[0]);
    }

    public void setOmgID(String str) {
        QimeiSDK.getInstance().setOmgId(str);
    }

    public void setQQ(String str) {
        com.tencent.tmsbeacon.a.c.b.a(str);
    }

    public void setStrictMode(boolean z) {
        e.f39530a.set(z);
    }

    public void setUserID(String str) {
        setUserID(this.e, str);
    }

    public void setUserID(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("i_c_ak", str);
        hashMap.put("i_c_u_i", str2);
        com.tencent.tmsbeacon.a.a.b.a().b(new com.tencent.tmsbeacon.a.a.c(4, hashMap));
    }

    public void setWifiMacAddress(String str) {
        f.e().i(str);
    }

    public void setWifiSSID(String str) {
        f.e().j(str);
    }

    public void start(Context context, String str, BeaconConfig beaconConfig) {
        synchronized (this) {
            if (this.d) {
                return;
            }
            e.a("Context", context);
            this.f39591c = context.getApplicationContext();
            e.a(TbsCoreSettings.TBS_SETTINGS_APP_KEY, str);
            this.e = str;
            this.f = beaconConfig;
            com.tencent.tmsbeacon.a.c.c.d().a(context);
            d.b().a(beaconConfig != null && beaconConfig.isForceEnableAtta());
            ((Application) this.f39591c).registerActivityLifecycleCallbacks(new com.tencent.tmsbeacon.b.b());
            if (beaconConfig != null) {
                a(beaconConfig);
            }
            com.tencent.tmsbeacon.a.b.a.a().a(new a());
            this.d = true;
        }
    }

    public void stopReport(boolean z) {
        c.a("BeaconReport", "stop report by user.", new Object[0]);
        com.tencent.tmsbeacon.a.b.a.a().a(z);
        com.tencent.tmsbeacon.base.net.c.c().close();
    }
}
