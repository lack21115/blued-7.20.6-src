package com.igexin.push.core.d;

import android.content.Context;
import android.text.TextUtils;
import com.getui.gtc.api.GtcManager;
import com.getui.gtc.api.SdkInfo;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.config.a;
import com.igexin.push.core.d.f;
import com.igexin.push.core.m;
import com.igexin.push.core.n;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/d/a.class */
public final class a implements e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9865a = "DycSdkConfig";
    private Map<String, String> b = new HashMap();

    private int a(String str, int i) {
        if (b(str)) {
            try {
                return Integer.valueOf(a(str)).intValue();
            } catch (Exception e) {
                return i;
            }
        }
        return i;
    }

    private Boolean a(String str, Boolean bool) {
        if (b(str)) {
            try {
                return Boolean.valueOf(a(str));
            } catch (Exception e) {
                return bool;
            }
        }
        return bool;
    }

    private Long a(String str, Long l) {
        if (b(str)) {
            try {
                return Long.valueOf(a(str));
            } catch (Exception e) {
                return l;
            }
        }
        return l;
    }

    private String a(String str) {
        return this.b.get(str);
    }

    private String a(String str, String str2) {
        if (b(str)) {
            try {
                return a(str);
            } catch (Exception e) {
                return str2;
            }
        }
        return str2;
    }

    private static Map<String, String> a(Context context, f fVar) {
        return com.getui.gtc.dyc.b.a.a(context, fVar.f9884a);
    }

    private boolean b(String str) {
        Map<String, String> map = this.b;
        if (map == null) {
            return false;
        }
        return map.containsKey(str);
    }

    private static void c() {
        String str = com.igexin.push.core.e.f9887a;
        String str2 = com.igexin.push.core.e.A;
        GtcManager.getInstance().loadSdk(new SdkInfo.Builder().appid(com.igexin.push.core.e.f9887a).cid(com.igexin.push.core.e.A).moduleName(com.igexin.push.core.b.i).version("3.2.14.0").build());
    }

    private static /* synthetic */ void d() {
        String str = com.igexin.push.core.e.f9887a;
        String str2 = com.igexin.push.core.e.A;
        GtcManager.getInstance().loadSdk(new SdkInfo.Builder().appid(com.igexin.push.core.e.f9887a).cid(com.igexin.push.core.e.A).moduleName(com.igexin.push.core.b.i).version("3.2.14.0").build());
    }

    @Override // com.igexin.push.core.d.e
    public final Map<String, String> a() {
        SDKUrlConfig.getConfigServiceUrl();
        String str = com.igexin.push.core.e.f9887a;
        f.a aVar = new f.a();
        aVar.f9885a.b(com.igexin.push.core.b.i);
        aVar.f9885a.a(SDKUrlConfig.getConfigServiceUrl());
        aVar.f9885a.f("3.2.14.0");
        aVar.f9885a.c(com.igexin.push.core.e.f9887a);
        aVar.f9885a.d(com.igexin.push.core.e.A);
        aVar.f9885a.e(com.getui.gtc.dyc.b.b.f8367a);
        aVar.f9885a.g(86400000L);
        aVar.f9885a.h(new g() { // from class: com.igexin.push.core.d.a.1
            @Override // com.igexin.push.core.d.g
            public final void a(String str2) {
                com.igexin.c.a.c.a.a(a.f9865a, str2);
                com.igexin.c.a.c.a.a("DycSdkConfig| get gtc config error ,message is : ".concat(String.valueOf(str2)), new Object[0]);
            }

            @Override // com.igexin.push.core.d.g
            public final void a(Map<String, String> map) {
                a.this.a(map);
                String str2 = com.igexin.push.core.e.f9887a;
                String str3 = com.igexin.push.core.e.A;
                GtcManager.getInstance().loadSdk(new SdkInfo.Builder().appid(com.igexin.push.core.e.f9887a).cid(com.igexin.push.core.e.A).moduleName(com.igexin.push.core.b.i).version("3.2.14.0").build());
            }
        }.b);
        Map<String, String> a2 = com.getui.gtc.dyc.b.a.a(com.igexin.push.core.e.l, new f(aVar, (byte) 0).f9884a);
        a(a2);
        return a2;
    }

    @Override // com.igexin.push.core.d.e
    public final boolean a(Map<String, String> map) {
        if (map != null) {
            try {
                if (map.size() == 0) {
                    return false;
                }
                this.b = map;
                com.igexin.c.a.c.a.a("DycSdkConfig|parse sdk config from server resp = " + this.b.toString(), new Object[0]);
                com.igexin.push.config.d.j = a("sdk.feature.sendmessage.enable", Boolean.valueOf(com.igexin.push.config.d.j)).booleanValue();
                com.igexin.push.config.d.h = a("sdk.readlocalcell.enable", Boolean.valueOf(com.igexin.push.config.d.h)).booleanValue();
                com.igexin.push.config.d.g = a("sdk.domainbackup.enable", Boolean.valueOf(com.igexin.push.config.d.g)).booleanValue();
                boolean booleanValue = a("sdk.feature.setsilenttime.enable", Boolean.valueOf(com.igexin.push.config.d.l)).booleanValue();
                com.igexin.push.config.d.l = booleanValue;
                if (!booleanValue && com.igexin.push.config.d.f9768c != 0) {
                    m.a();
                    m.a(12, 0);
                }
                com.igexin.push.config.d.k = a("sdk.feature.settag.enable", Boolean.valueOf(com.igexin.push.config.d.k)).booleanValue();
                com.igexin.push.config.d.m = a("sdk.feature.setheartbeatinterval.enable", Boolean.valueOf(com.igexin.push.config.d.m)).booleanValue();
                com.igexin.push.config.d.n = a("sdk.feature.setsockettimeout.enable", Boolean.valueOf(com.igexin.push.config.d.n)).booleanValue();
                com.igexin.push.config.d.q = a("sdk.report.initialize.enable", Boolean.valueOf(com.igexin.push.config.d.q)).booleanValue();
                com.igexin.push.config.d.o = a("sdk.feature.feedback.enable", Boolean.valueOf(com.igexin.push.config.d.o)).booleanValue();
                com.igexin.push.config.d.p = a("sdk.daemon.enable", Boolean.valueOf(com.igexin.push.config.d.p)).booleanValue();
                com.igexin.push.config.d.x = a("sdk.polling.dis.cnt", com.igexin.push.config.d.x);
                com.igexin.push.config.d.y = a("sdk.polling.login.interval", Long.valueOf(com.igexin.push.config.d.y)).longValue();
                com.igexin.push.config.d.z = a("sdk.polling.exit.heartbeat.cnt", com.igexin.push.config.d.z);
                com.igexin.push.config.d.N = a("sdk.ral.send.maxcnt", com.igexin.push.config.d.N);
                com.igexin.push.config.d.A = a("sdk.httpdata.maxsize", com.igexin.push.config.d.A);
                com.igexin.push.config.d.B = a("sdk.hide.righticon.blacklist", com.igexin.push.config.d.B);
                String a2 = a("sdk.taskid.blacklist", com.igexin.push.config.d.C);
                com.igexin.push.config.d.C = a2;
                if (TextUtils.isEmpty(a2)) {
                    com.igexin.push.config.d.C = "none";
                } else {
                    n.a();
                    n.c();
                }
                com.igexin.push.config.d.E = a("sdk.applink.feedback.enable", Boolean.valueOf(com.igexin.push.config.d.E)).booleanValue();
                String a3 = a("sdk.applink.domains", com.igexin.push.config.d.F);
                com.igexin.push.config.d.F = a3;
                if (TextUtils.isEmpty(a3)) {
                    com.igexin.push.config.d.F = "none";
                }
                String a4 = a("sdk.del.alarm.brand", com.igexin.push.config.d.G);
                com.igexin.push.config.d.G = a4;
                if (TextUtils.isEmpty(a4)) {
                    com.igexin.push.config.d.G = "none";
                }
                com.igexin.push.config.d.L = a("sdk.vivopush.enable", Boolean.valueOf(com.igexin.push.config.d.L)).booleanValue();
                com.igexin.push.config.d.O = a("sdk.upload.gzip.limit", Long.valueOf(com.igexin.push.config.d.O)).longValue();
                com.igexin.push.config.d.M = a("sdk.multiPuh.stoplist", com.igexin.push.config.d.M);
                com.igexin.push.config.d.P = a("sdk.startservice.limit", com.igexin.push.config.d.P);
                com.igexin.push.config.d.D = a("sdk.miui.wakeup.enable", Boolean.valueOf(com.igexin.push.config.d.D)).booleanValue();
                com.igexin.push.config.d.f9767a = a("sdk.querytag.interval", Long.valueOf(com.igexin.push.config.d.f9767a)).longValue();
                com.igexin.push.config.d.Q = a("sdk.zxsdk.enable", Boolean.valueOf(com.igexin.push.config.d.Q)).booleanValue();
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new a.AnonymousClass9(com.igexin.push.config.d.Q), true, false);
                com.igexin.push.config.d.R = a("sdk.type253.enable", com.igexin.push.config.d.R);
                com.igexin.push.config.d.S = a("sdk.type253.interval", Long.valueOf(com.igexin.push.config.d.S)).longValue();
                com.igexin.push.config.d.T = a("sdk.dud.enable", Boolean.valueOf(com.igexin.push.config.d.T)).booleanValue();
                com.igexin.push.config.d.U = a("sdk.honorpush.enable", Boolean.valueOf(com.igexin.push.config.d.U)).booleanValue();
                com.igexin.push.config.d.V = a("sdk.type144.enable", Boolean.valueOf(com.igexin.push.config.d.V)).booleanValue();
                com.igexin.push.config.d.W = a("sdk.type144.interval", Long.valueOf(com.igexin.push.config.d.W)).longValue();
                com.igexin.push.config.d.X = a("sdk.use.gtwf.enable", Boolean.valueOf(com.igexin.push.config.d.X)).booleanValue();
                com.igexin.push.config.d.Y = a("sdk.type145.enable", Boolean.valueOf(com.igexin.push.config.d.Y)).booleanValue();
                com.igexin.push.config.d.Z = a("sdk.type145.delay.ms", Long.valueOf(com.igexin.push.config.d.Z)).longValue();
                com.igexin.push.config.d.aa = a("sdk.type145.picc.enable", Boolean.valueOf(com.igexin.push.config.d.aa)).booleanValue();
                com.igexin.push.config.d.ab = a("sdk.type145.ipp.enable", Boolean.valueOf(com.igexin.push.config.d.ab)).booleanValue();
                com.igexin.push.config.d.ac = a("sdk.type145.gploc.enable", Boolean.valueOf(com.igexin.push.config.d.ac)).booleanValue();
                com.igexin.push.config.d.ad = a("sdk.type145.netloc.enable", Boolean.valueOf(com.igexin.push.config.d.ad)).booleanValue();
                com.igexin.push.config.d.ae = a("sdk.type145.ceinfo.enable", Boolean.valueOf(com.igexin.push.config.d.ae)).booleanValue();
                com.igexin.push.config.d.af = a("sdk.type10.cidnull.delay", com.igexin.push.config.d.af);
                com.igexin.push.config.d.ag = a("sdk.newhostad.enable", Boolean.valueOf(com.igexin.push.config.d.ag)).booleanValue();
                return true;
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
                com.igexin.c.a.c.a.a(f9865a, th.toString());
                return true;
            }
        }
        return false;
    }

    @Override // com.igexin.push.core.d.e
    public final boolean b() {
        com.igexin.c.a.c.a.a("DycSdkConfig| parse config success", new Object[0]);
        return true;
    }
}
