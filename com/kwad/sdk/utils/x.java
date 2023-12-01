package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.d;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/x.class */
public final class x {
    private static volatile boolean azO;
    private static AtomicInteger azN = new AtomicInteger(0);
    private static volatile boolean aya = false;

    private static int Dd() {
        com.kwad.sdk.service.kwai.f fVar = (com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class);
        if (fVar == null) {
            com.kwad.sdk.core.d.b.w("Ks_UnionHelper", "sdkConfigProvider == null");
            return 0;
        }
        int sK = fVar.sK();
        com.kwad.sdk.core.d.b.d("Ks_UnionHelper", "config mode:" + sK);
        return sK;
    }

    private static void De() {
        if (aya) {
            return;
        }
        azN.set(Dh());
        azO = ba.i("kssdk_kv_mode", "downgrade", false);
        aya = true;
    }

    public static void Df() {
        if (Di() || Dd() == 0) {
            return;
        }
        g.execute(new Runnable() { // from class: com.kwad.sdk.utils.x.3
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.utils.a.a Dg = x.Dg();
                if (Dg == null) {
                    return;
                }
                x.c(Dg);
                com.kwad.sdk.utils.a.b bVar = (com.kwad.sdk.utils.a.b) ServiceProvider.get(com.kwad.sdk.utils.a.b.class);
                if (bVar != null) {
                    bVar.a(Dg);
                }
            }
        });
    }

    public static com.kwad.sdk.utils.a.a Dg() {
        com.kwad.sdk.utils.a.a aVar = new com.kwad.sdk.utils.a.a();
        SharedPreferences eN = ba.eN("ksadsdk_kv_perf");
        if (eN == null) {
            return null;
        }
        try {
            Map<String, ?> all = eN.getAll();
            if (all == null) {
                return null;
            }
            int i = 0;
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                i += ((Integer) entry.getValue()).intValue();
            }
            aVar.aCK = i;
            SharedPreferences.Editor edit = eN.edit();
            for (Map.Entry<String, ?> entry2 : all.entrySet()) {
                edit.putInt(entry2.getKey(), 0);
            }
            edit.apply();
            d(aVar);
            e(aVar);
            return aVar;
        } catch (Throwable th) {
            return aVar;
        }
    }

    private static int Dh() {
        int c2 = ba.c("kssdk_kv_mode", "mode", 0);
        com.kwad.sdk.core.d.b.d("Ks_UnionHelper", "local mode:" + c2);
        return c2;
    }

    public static boolean Di() {
        De();
        return azN.get() == 0;
    }

    private static boolean Dj() {
        return Build.VERSION.SDK_INT > 23;
    }

    private static int Dk() {
        De();
        int Dd = (azO || !Dj()) ? 0 : Dd();
        com.kwad.sdk.core.d.b.d("Ks_UnionHelper", "targetMode:" + Dd);
        return Dd;
    }

    public static void Dl() {
        De();
        int i = azN.get();
        int Dk = Dk();
        boolean z = i != Dk;
        com.kwad.sdk.core.d.b.d("Ks_UnionHelper", "needTransfer:" + z);
        if (z) {
            transfer(Dk);
        }
    }

    private static void Dm() {
        g.execute(new Runnable() { // from class: com.kwad.sdk.utils.x.4
            @Override // java.lang.Runnable
            public final void run() {
                Context context;
                try {
                    context = y.getContext();
                } catch (Exception e) {
                    com.kwad.sdk.core.d.b.e("Ks_UnionHelper", Log.getStackTraceString(e));
                }
                if (context == null) {
                    return;
                }
                for (String str : d.a.Yo) {
                    x.J(context, str);
                }
                x.cf(0);
                x.azN.set(0);
            }
        });
    }

    private static void Dn() {
        com.kwad.sdk.core.d.b.d("Ks_UnionHelper", "transferToKv");
        g.execute(new Runnable() { // from class: com.kwad.sdk.utils.x.5
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Context context = y.getContext();
                    if (context != null) {
                        for (String str : d.a.Yo) {
                            x.I(context, str);
                        }
                        x.cf(1);
                        x.azN.set(1);
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.d.b.e("Ks_UnionHelper", Log.getStackTraceString(e));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void I(Context context, String str) {
        SharedPreferences eN;
        com.kwad.sdk.utils.kwai.c aq = com.kwad.sdk.utils.kwai.e.aq(context, str);
        if ("ksadsdk_splash_preload_id_list".equals(str) && (eN = ba.eN(str)) == null) {
            SharedPreferences.Editor edit = eN.edit();
            if (edit != null) {
                edit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
            }
        } else if (aq.contains("sp_to_kv_transfer_flag")) {
        } else {
            SharedPreferences eN2 = ba.eN(str);
            if (eN2 == null) {
                aq.putBoolean("sp_to_kv_transfer_flag", true);
                return;
            }
            aq.putAll(eN2.getAll());
            aq.putBoolean("sp_to_kv_transfer_flag", true);
            ba.ae(str, "kv_to_sp_transfer_flag");
            a(str, aq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void J(Context context, String str) {
        SharedPreferences eN = ba.eN(str);
        if (eN == null) {
            return;
        }
        if ("ksadsdk_splash_preload_id_list".equals(str)) {
            SharedPreferences.Editor edit = eN.edit();
            if (edit != null) {
                edit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
            }
        } else if (eN.contains("kv_to_sp_transfer_flag")) {
        } else {
            com.kwad.sdk.utils.kwai.c aq = com.kwad.sdk.utils.kwai.e.aq(context, str);
            Map<String, Object> all = aq.getAll();
            if (all.isEmpty()) {
                ba.h(str, "kv_to_sp_transfer_flag", true);
                return;
            }
            ba.a(str, all);
            ba.h(str, "kv_to_sp_transfer_flag", true);
            aq.remove("sp_to_kv_transfer_flag");
            aq.release();
        }
    }

    private static void a(String str, com.kwad.sdk.utils.kwai.c cVar) {
        if (d.a.Yp.contains(str)) {
            return;
        }
        cVar.release();
    }

    public static void ac(final String str, final String str2) {
        g.execute(new Runnable() { // from class: com.kwad.sdk.utils.x.1
            @Override // java.lang.Runnable
            public final void run() {
                int c2 = ba.c("ksadsdk_kv_perf", str, 0);
                if (TextUtils.isEmpty(str2)) {
                    ba.ae("ksadsdk_kv_perf", str);
                } else {
                    ba.b("ksadsdk_kv_perf", str, c2 + 1);
                }
            }
        });
    }

    public static void ad(final String str, final String str2) {
        g.execute(new Runnable() { // from class: com.kwad.sdk.utils.x.2
            @Override // java.lang.Runnable
            public final void run() {
                SharedPreferences eN = ba.eN("ksadsdk_kv_perf");
                if (eN != null && eN.contains(str)) {
                    if (TextUtils.isEmpty(str2)) {
                        ba.b("ksadsdk_kv_perf_failed", str, ba.c("ksadsdk_kv_perf_failed", str, 0) + 1);
                        return;
                    }
                    ba.b("ksadsdk_kv_perf_success", str, ba.c("ksadsdk_kv_perf_success", str, 0) + 1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(com.kwad.sdk.utils.a.a aVar) {
        if (aVar.aCL / (aVar.aCL + aVar.aCM) > 0.10000000149011612d) {
            azO = true;
            com.kwad.sdk.core.d.b.d("Ks_UnionHelper", "need downgrade");
            ba.h("kssdk_kv_mode", "downgrade", true);
        }
        if (azO) {
            Dl();
        }
    }

    static void cf(int i) {
        ba.b("kssdk_kv_mode", "mode", i);
    }

    private static void d(com.kwad.sdk.utils.a.a aVar) {
        SharedPreferences eN = ba.eN("ksadsdk_kv_perf_failed");
        int i = 0;
        int i2 = 0;
        if (eN == null) {
            aVar.aCL = 0;
            return;
        }
        Map<String, ?> all = eN.getAll();
        if (all != null) {
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                i2 += ((Integer) it.next().getValue()).intValue();
            }
        }
        aVar.aCL = i;
        SharedPreferences.Editor edit = eN.edit();
        edit.clear();
        edit.apply();
    }

    private static void e(com.kwad.sdk.utils.a.a aVar) {
        SharedPreferences eN = ba.eN("ksadsdk_kv_perf_success");
        int i = 0;
        int i2 = 0;
        if (eN == null) {
            aVar.aCM = 0;
            return;
        }
        Map<String, ?> all = eN.getAll();
        if (all != null) {
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                i2 += ((Integer) it.next().getValue()).intValue();
            }
        }
        aVar.aCM = i;
        SharedPreferences.Editor edit = eN.edit();
        edit.clear();
        edit.apply();
    }

    private static void transfer(int i) {
        if (i == 0) {
            Dm();
        } else if (i == 1) {
            Dn();
        }
    }
}
