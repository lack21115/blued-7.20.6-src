package com.kwad.sdk.kwai.kwai;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;
import com.kwad.sdk.kwai.kwai.b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/kwai/kwai/c.class */
public final class c {
    private e YK;
    private final Map<String, Integer> YL;
    private final Map<String, Integer> YM;
    private final Stack<AdTemplate> YN;
    private volatile boolean YO;
    public volatile boolean YP;
    public volatile boolean YQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/kwai/kwai/c$a.class */
    public static final class a {
        static final c YV = new c((byte) 0);
    }

    private c() {
        this.YL = new HashMap();
        this.YM = new HashMap();
        this.YN = new Stack<>();
        this.YO = false;
        this.YP = false;
        this.YQ = false;
    }

    /* synthetic */ c(byte b) {
        this();
    }

    static /* synthetic */ e a(c cVar, e eVar) {
        cVar.YK = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdTemplate adTemplate, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        if (com.kwad.sdk.kwai.kwai.a.mF()) {
            return;
        }
        com.kwad.sdk.core.b.b.vS();
        Activity currentActivity = com.kwad.sdk.core.b.b.getCurrentActivity();
        if (currentActivity != null && com.kwad.sdk.kwai.kwai.a.a(currentActivity, adTemplate, onDismissListener, onClickListener)) {
            a(adTemplate, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdTemplate adTemplate, boolean z, int i, boolean z2) {
        if (this.YK != null || com.kwad.components.core.d.a.b.mF()) {
            return;
        }
        boolean z3 = true;
        if (!z || i != 1) {
            z3 = false;
        }
        a(adTemplate, z, z3, z2);
    }

    private void a(AdTemplate adTemplate, boolean z, boolean z2) {
        int i;
        String valueOf = String.valueOf(com.kwad.sdk.core.response.a.d.cl(adTemplate));
        if (!z) {
            com.kwad.sdk.core.report.a.c(adTemplate, 93, (JSONObject) null);
            a(this.YM, valueOf);
            return;
        }
        a(this.YL, valueOf);
        i iVar = new i();
        if (z2) {
            iVar.bp(23);
            i = 191;
        } else {
            i = 92;
        }
        iVar.bl(i);
        com.kwad.sdk.core.report.a.d(adTemplate, (JSONObject) null, iVar);
    }

    private void a(final AdTemplate adTemplate, boolean z, boolean z2, boolean z3) {
        Context context;
        Context wrapContextIfNeed;
        com.kwad.sdk.core.b.b.vS();
        Activity currentActivity = com.kwad.sdk.core.b.b.getCurrentActivity();
        if (currentActivity == null || (context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext()) == null || (wrapContextIfNeed = k.wrapContextIfNeed(context)) == null) {
            return;
        }
        e eVar = new e(wrapContextIfNeed, adTemplate, z, z2, z3);
        View findViewById = currentActivity.getWindow().getDecorView().findViewById(16908290);
        if (findViewById instanceof FrameLayout) {
            eVar.a((FrameLayout) findViewById);
            this.YK = eVar;
            a(adTemplate, z, z3);
        }
        if (z3) {
            com.kwad.sdk.core.b.b.vS();
            com.kwad.sdk.kwai.kwai.kwai.b.J(com.kwad.sdk.core.b.b.getCurrentActivity());
            bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.9
                @Override // java.lang.Runnable
                public final void run() {
                    if (c.this.YK != null) {
                        c.this.YK.dismiss();
                        c.a(c.this, (e) null);
                        c cVar = c.this;
                        c.h(adTemplate, 2);
                    }
                }
            }, 5000L);
        }
    }

    private static void a(Map<String, Integer> map, String str) {
        map.put(str, map.containsKey(str) ? Integer.valueOf(map.get(str).intValue() + 1) : 1);
    }

    private static boolean ae(AdTemplate adTemplate) {
        String A;
        if (adTemplate == null) {
            return false;
        }
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null || ak.ah(context, com.kwad.sdk.core.response.a.a.aq(cb)) || (A = com.kwad.sdk.core.download.a.A(cb)) == null || TextUtils.isEmpty(A)) {
            return false;
        }
        return new File(A).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(final AdTemplate adTemplate) {
        a(adTemplate, (DialogInterface.OnDismissListener) null, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.kwai.kwai.c.7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                if (i != -1) {
                    if (i == -2) {
                        c cVar = c.this;
                        c.h(adTemplate, 1);
                        return;
                    }
                    return;
                }
                i iVar = new i();
                iVar.bl(29);
                iVar.bp(23);
                com.kwad.sdk.core.report.a.a(adTemplate, iVar);
                com.kwad.sdk.kwai.kwai.a.sU();
            }
        });
        bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.8
            @Override // java.lang.Runnable
            public final void run() {
                if (com.kwad.sdk.kwai.kwai.a.sU()) {
                    c cVar = c.this;
                    c.h(adTemplate, 2);
                }
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final AdTemplate adTemplate, final boolean z) {
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.3
            @Override // java.lang.Runnable
            public final void run() {
                int uj = com.kwad.sdk.core.config.d.uj();
                if (z && uj == 2) {
                    c.this.a(adTemplate, (DialogInterface.OnDismissListener) null, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.kwai.kwai.c.3.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Tracker.onClick(dialogInterface, i);
                            if (i != -1) {
                                if (i == -2) {
                                    c cVar = c.this;
                                    c.h(adTemplate, 1);
                                    return;
                                }
                                return;
                            }
                            i iVar = new i();
                            iVar.bl(29);
                            iVar.bp(23);
                            com.kwad.sdk.core.report.a.a(adTemplate, iVar);
                            com.kwad.sdk.kwai.kwai.a.sU();
                        }
                    });
                } else {
                    c.this.a(adTemplate, z, uj, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.report.a.a(adTemplate, new i().bl(69).bp(23).bt(i));
    }

    public static c sZ() {
        return a.YV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void td() {
        if (!this.YP && com.kwad.sdk.kwai.kwai.kwai.b.cO() <= 0) {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.6
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        AdTemplate sX = b.sW().sX();
                        if (sX == null || com.kwad.sdk.core.config.d.uk() == 0) {
                            return;
                        }
                        c.this.YP = true;
                        com.kwad.sdk.core.b.b.vS();
                        com.kwad.sdk.kwai.kwai.kwai.b.J(com.kwad.sdk.core.b.b.getCurrentActivity());
                        c.this.aj(sX);
                    } catch (Throwable th) {
                        com.kwad.components.core.c.a.b(th);
                    }
                }
            });
        }
    }

    public final void aU(boolean z) {
        this.YO = z;
    }

    public final void af(AdTemplate adTemplate) {
        if (ae(adTemplate)) {
            this.YN.add(adTemplate);
        }
    }

    public final void ag(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        this.YN.remove(adTemplate);
    }

    public final void ah(final AdTemplate adTemplate) {
        int ui = com.kwad.sdk.core.config.d.ui();
        if (adTemplate == null || ui <= 0) {
            return;
        }
        final AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (adTemplate.mAdScene.getAdStyle() == 0) {
            return;
        }
        String valueOf = String.valueOf(com.kwad.sdk.core.response.a.d.cl(adTemplate));
        int i = 0;
        if (this.YL.containsKey(valueOf)) {
            i = this.YL.get(valueOf).intValue();
            this.YL.put(valueOf, Integer.valueOf(i));
        }
        if (i > 0) {
            return;
        }
        g.schedule(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.1
            @Override // java.lang.Runnable
            public final void run() {
                if (cb.status == 12 || cb.status == 10) {
                    return;
                }
                c.this.f(adTemplate, true);
            }
        }, ui, TimeUnit.SECONDS);
    }

    public final void ai(final AdTemplate adTemplate) {
        int ut = com.kwad.sdk.core.config.d.ut();
        if (ut < 0) {
            return;
        }
        final AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        String valueOf = String.valueOf(cb.adBaseInfo.creativeId);
        int i = 0;
        if (this.YM.containsKey(valueOf)) {
            i = this.YM.get(valueOf).intValue();
            this.YM.put(valueOf, Integer.valueOf(i));
        }
        if (i > 0) {
            return;
        }
        g.schedule(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.2
            @Override // java.lang.Runnable
            public final void run() {
                boolean z = true;
                if (ak.ai(ServiceProvider.getContext(), com.kwad.sdk.core.response.a.a.aq(cb)) != 1) {
                    z = false;
                }
                if (z) {
                    return;
                }
                c.this.f(adTemplate, false);
            }
        }, ut, TimeUnit.SECONDS);
    }

    public final void dismiss() {
        com.kwad.sdk.kwai.kwai.a.sU();
        e eVar = this.YK;
        if (eVar != null) {
            eVar.dismiss();
            this.YK = null;
        }
    }

    public final AdTemplate ta() {
        AdTemplate adTemplate = null;
        while (!this.YN.isEmpty()) {
            AdTemplate pop = this.YN.pop();
            if (ae(pop)) {
                adTemplate = pop;
            }
        }
        if (adTemplate != null) {
            this.YN.add(0, adTemplate);
        }
        return adTemplate;
    }

    public final void tb() {
        b.sW().a(new b.a() { // from class: com.kwad.sdk.kwai.kwai.c.4
            @Override // com.kwad.sdk.kwai.kwai.b.a
            public final void gv() {
                bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (c.this.YO) {
                            c.this.YQ = true;
                        } else {
                            c.this.td();
                        }
                    }
                }, com.kwad.sdk.core.config.d.ul());
            }

            @Override // com.kwad.sdk.kwai.kwai.b.a
            public final void sY() {
                com.kwad.sdk.core.d.b.d("InstallTipsManager", "showInitDelayDialog failed");
            }
        });
    }

    public final void tc() {
        aU(false);
        if (this.YP || !this.YQ) {
            return;
        }
        bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.5
            @Override // java.lang.Runnable
            public final void run() {
                c.this.td();
            }
        }, 5000L);
    }

    public final void te() {
        this.YK = null;
    }
}
