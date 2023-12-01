package com.bytedance.bdtracker;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.provider.ContactsContract;
import com.bytedance.applog.UriConfig;
import com.bytedance.applog.alink.IALinkListener;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/f.class */
public final class f implements Application.ActivityLifecycleCallbacks, Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public boolean f7608a;
    public Handler b;

    /* renamed from: c  reason: collision with root package name */
    public v f7609c;
    public e d;
    public int e;
    public m f;
    public int g;
    public String h;
    public final List<String> i;
    public final List<String> j;

    public f(v vVar) {
        Intrinsics.d(vVar, "engine");
        this.f7609c = vVar;
        this.g = 10;
        this.i = CollectionsKt.b(new String[]{"utm_campaign", "utm_source", "utm_term", "utm_medium", "utm_content"});
        this.j = CollectionsKt.b(new String[]{"tr_shareuser", "tr_admaster", "tr_param1", "tr_param2", "tr_param3", "tr_param4", "reengagement_window", "reengagement_time", "is_retargeting"});
        HandlerThread handlerThread = new HandlerThread("bd_tracker_alink");
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper(), this);
        String a2 = b.a(vVar.f7719c, "ALINK_CACHE_SP");
        Context a3 = vVar.a();
        if (a3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.app.Application");
        }
        Intrinsics.b(a2, "spName");
        this.d = new e((Application) a3, a2);
        c cVar = vVar.f7719c;
        Intrinsics.b(cVar, "engine.appLog");
        this.f = new m(cVar);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public final void a() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        i<j> iVar;
        j a2;
        g a3;
        Integer valueOf = message != null ? Integer.valueOf(message.what) : null;
        if (valueOf != null && valueOf.intValue() == 1) {
            Object obj = message.obj;
            if (obj != null) {
                h hVar = (h) obj;
                String d = hVar.d();
                if (d == null || d.length() == 0) {
                    return true;
                }
                hVar.l = "android";
                c cVar = this.f7609c.f7719c;
                Intrinsics.b(cVar, "mEngine.appLog");
                hVar.a(cVar.l);
                c cVar2 = this.f7609c.f7719c;
                Intrinsics.b(cVar2, "mEngine.appLog");
                hVar.b(cVar2.getDid());
                c cVar3 = this.f7609c.f7719c;
                Intrinsics.b(cVar3, "mEngine.appLog");
                hVar.c(cVar3.getSsid());
                c cVar4 = this.f7609c.f7719c;
                Intrinsics.b(cVar4, "mEngine.appLog");
                hVar.d(cVar4.getUserUniqueID());
                n0 n0Var = this.f7609c.h;
                hVar.h = n0Var != null ? n0Var.g() : null;
                n0 n0Var2 = this.f7609c.h;
                hVar.i = n0Var2 != null ? n0Var2.j() : null;
                n0 n0Var3 = this.f7609c.h;
                hVar.n = n0Var3 != null ? (String) n0Var3.a("device_model", (String) null, String.class) : null;
                n0 n0Var4 = this.f7609c.h;
                hVar.m = n0Var4 != null ? (String) n0Var4.a("os_version", (String) null, String.class) : null;
                n0 n0Var5 = this.f7609c.h;
                JSONObject jSONObject = n0Var5 != null ? (JSONObject) n0Var5.a("oaid", (String) null, JSONObject.class) : null;
                hVar.j = jSONObject != null ? jSONObject.optString("id") : null;
                n0 n0Var6 = this.f7609c.h;
                hVar.k = n0Var6 != null ? (String) n0Var6.a("google_aid", (String) null, String.class) : null;
                UriConfig c2 = this.f7609c.c();
                Intrinsics.b(c2, "mEngine.uriConfig");
                String alinkQueryUri = c2.getAlinkQueryUri();
                i<g> a4 = alinkQueryUri != null ? this.f.a(alinkQueryUri, hVar) : null;
                if (a4 == null || (a3 = a4.a()) == null) {
                    return true;
                }
                a3.s = d;
                this.d.a(com.anythink.expressad.foundation.d.c.O, a3, ContactsContract.DeletedContacts.DAYS_KEPT_MILLISECONDS);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("$link_type", "direct");
                jSONObject2.put("$deeplink_url", this.h);
                this.f7609c.f7719c.onEventV3("$invoke", jSONObject2, 0);
                a();
                c cVar5 = this.f7609c.f7719c;
                Intrinsics.b(cVar5, "mEngine.appLog");
                IALinkListener aLinkListener = cVar5.getALinkListener();
                if (aLinkListener != null) {
                    aLinkListener.onALinkData(a3.b(), null);
                    return true;
                }
                return true;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.bytedance.applog.alink.model.ALinkQueryParam");
        } else if (valueOf != null && valueOf.intValue() == 0) {
            n0 n0Var7 = this.f7609c.h;
            if (n0Var7 == null || n0Var7.h() != 0) {
                JSONObject jSONObject3 = (!this.f7608a || this.e >= this.g) ? new JSONObject() : n.f7657a.a(this.f7609c.a());
                if (jSONObject3 != null) {
                    h hVar2 = (h) l.f7639a.a(jSONObject3, h.class);
                    if (hVar2 != null) {
                        Intrinsics.d(hVar2, "queryParam");
                        c cVar6 = this.f7609c.f7719c;
                        Intrinsics.b(cVar6, "mEngine.appLog");
                        hVar2.a(cVar6.l);
                        c cVar7 = this.f7609c.f7719c;
                        Intrinsics.b(cVar7, "mEngine.appLog");
                        hVar2.b(cVar7.getDid());
                        c cVar8 = this.f7609c.f7719c;
                        Intrinsics.b(cVar8, "mEngine.appLog");
                        hVar2.c(cVar8.getSsid());
                        c cVar9 = this.f7609c.f7719c;
                        Intrinsics.b(cVar9, "mEngine.appLog");
                        hVar2.d(cVar9.getUserUniqueID());
                        String c3 = hVar2.c();
                        if (!(c3 == null || c3.length() == 0)) {
                            this.f7609c.f7719c.setExternalAbVersion(hVar2.c());
                        }
                        String e = hVar2.e();
                        if (!(e == null || e.length() == 0)) {
                            this.d.a("tr_web_ssid", hVar2.e(), 31536000000L);
                        }
                        UriConfig c4 = this.f7609c.c();
                        Intrinsics.b(c4, "mEngine.uriConfig");
                        String alinkAttributionUri = c4.getAlinkAttributionUri();
                        if (alinkAttributionUri != null) {
                            m mVar = this.f;
                            k kVar = new k();
                            n0 n0Var8 = this.f7609c.h;
                            if (n0Var8 != null) {
                                kVar.b = n0Var8.a();
                                kVar.f = "android";
                                kVar.e = n0Var8.e();
                                kVar.l = n0Var8.g();
                                kVar.m = n0Var8.j();
                                JSONObject jSONObject4 = (JSONObject) n0Var8.a("oaid", (String) null, JSONObject.class);
                                kVar.d = n0Var8.b();
                                kVar.n = jSONObject4 != null ? jSONObject4.optString("id") : null;
                                kVar.o = (String) n0Var8.a("google_aid", (String) null, String.class);
                                kVar.q = (String) n0Var8.a("user_agent", (String) null, String.class);
                                kVar.r = (String) n0Var8.a("device_model", (String) null, String.class);
                                kVar.s = (String) n0Var8.a("os_version", (String) null, String.class);
                                kVar.h = n0Var8.n();
                                String a5 = this.d.a("app_cache");
                                kVar.i = !(a5 == null || a5.length() == 0);
                                kVar.j = n0Var8.m();
                                kVar.k = (String) n0Var8.a("channel", (String) null, String.class);
                            }
                            iVar = mVar.a(alinkAttributionUri, kVar, hVar2);
                        } else {
                            iVar = null;
                        }
                        String a6 = this.d.a("app_cache");
                        if (a6 == null || a6.length() == 0) {
                            this.d.a("app_cache", "app_cache", -1L);
                        }
                        if (iVar == null || (a2 = iVar.a()) == null || !a2.G) {
                            return true;
                        }
                        a2.G = false;
                        this.d.a("deferred_deep_link", a2, -1L);
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("$link_type", "deferred");
                        this.f7609c.f7719c.onEventV3("$invoke", jSONObject5, 0);
                        c cVar10 = this.f7609c.f7719c;
                        Intrinsics.b(cVar10, "mEngine.appLog");
                        IALinkListener aLinkListener2 = cVar10.getALinkListener();
                        if (aLinkListener2 != null) {
                            aLinkListener2.onAttributionData(a2.b(), null);
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
            }
            int i = this.e;
            if (i < this.g) {
                this.e = i + 1;
                Handler handler = this.b;
                if (handler != null) {
                    handler.sendEmptyMessageDelayed(message.what, 500L);
                    return true;
                }
                return true;
            }
            return true;
        } else {
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00da, code lost:
        if ((r0 == null || r0.length() == 0) == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0158, code lost:
        if (r8 != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x015b, code lost:
        r5.e = 0;
        r0 = r5.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0166, code lost:
        if (r0 == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0169, code lost:
        r0.sendEmptyMessage(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x016f, code lost:
        r0 = r5.f7609c.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0178, code lost:
        if (r0 == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x017b, code lost:
        ((android.app.Application) r0).unregisterActivityLifecycleCallbacks(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0183, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x018d, code lost:
        throw new kotlin.TypeCastException("null cannot be cast to non-null type android.app.Application");
     */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityCreated(android.app.Activity r6, android.os.Bundle r7) {
        /*
            Method dump skipped, instructions count: 402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.f.onActivityCreated(android.app.Activity, android.os.Bundle):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
