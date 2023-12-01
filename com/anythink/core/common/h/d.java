package com.anythink.core.common.h;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.AdError;
import com.anythink.core.c.d;
import com.anythink.core.common.b.j;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.e;
import com.anythink.core.common.g.i;
import com.huawei.openalliance.ad.constant.at;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/h/d.class */
public final class d implements com.anythink.core.common.f.c {
    /* JADX INFO: Access modifiers changed from: private */
    public static String b(long j, long j2, e eVar, ATBaseAdAdapter aTBaseAdAdapter) {
        String str;
        Map<String, Object> networkInfoMap;
        try {
            networkInfoMap = aTBaseAdAdapter.getNetworkInfoMap();
        } catch (Throwable th) {
        }
        try {
            if (networkInfoMap != null) {
                str = new JSONObject(networkInfoMap).toString();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pl_id", eVar.W());
                jSONObject.put("req_id", eVar.X());
                jSONObject.put(at.e, eVar.l());
                jSONObject.put("unit_id", eVar.x());
                jSONObject.put("nw_firm_id", eVar.H());
                jSONObject.put("scenario_id", eVar.C);
                jSONObject.put("rv_start_ts", j);
                jSONObject.put("r_callback_ts", j2);
                jSONObject.put("rv_play_dur", j2 - j);
                jSONObject.put("tp_bid_id", eVar.e());
                jSONObject.put("extra_info", str);
                jSONObject.put("user_id", aTBaseAdAdapter.getUserId());
                jSONObject.put("extra_data", aTBaseAdAdapter.getUserCustomData());
                jSONObject.put("curr_ts", System.currentTimeMillis());
                jSONObject.put(d.a.i, j.a(eVar, aTBaseAdAdapter).toString());
                return jSONObject.toString();
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pl_id", eVar.W());
            jSONObject2.put("req_id", eVar.X());
            jSONObject2.put(at.e, eVar.l());
            jSONObject2.put("unit_id", eVar.x());
            jSONObject2.put("nw_firm_id", eVar.H());
            jSONObject2.put("scenario_id", eVar.C);
            jSONObject2.put("rv_start_ts", j);
            jSONObject2.put("r_callback_ts", j2);
            jSONObject2.put("rv_play_dur", j2 - j);
            jSONObject2.put("tp_bid_id", eVar.e());
            jSONObject2.put("extra_info", str);
            jSONObject2.put("user_id", aTBaseAdAdapter.getUserId());
            jSONObject2.put("extra_data", aTBaseAdAdapter.getUserCustomData());
            jSONObject2.put("curr_ts", System.currentTimeMillis());
            jSONObject2.put(d.a.i, j.a(eVar, aTBaseAdAdapter).toString());
            return jSONObject2.toString();
        } catch (Throwable th2) {
            return "";
        }
        str = "";
    }

    @Override // com.anythink.core.common.f.c
    public final void a(final long j, final long j2, final ATBaseAdAdapter aTBaseAdAdapter, final e eVar) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.h.d.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (aTBaseAdAdapter.getUnitGroupInfo().S() != 1) {
                        return;
                    }
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j3 = elapsedRealtime;
                    if (j2 != 0) {
                        j3 = elapsedRealtime;
                        if (elapsedRealtime >= j2) {
                            j3 = j2;
                        }
                    }
                    final String W = eVar.W();
                    com.anythink.core.c.d a2 = com.anythink.core.c.e.a(n.a().g()).a(W);
                    JSONObject jSONObject = new JSONObject(a.a(a2.u()));
                    int optInt = jSONObject.optInt("a");
                    b a3 = a.a(jSONObject.optString("b"), d.b(j, j3, eVar, aTBaseAdAdapter));
                    if (TextUtils.isEmpty(a3.a())) {
                        com.anythink.core.common.j.c.a(eVar, a2, "", a3.b());
                    } else {
                        new c(n.a().g(), optInt, a3.a(), eVar, a2).a(0, new i() { // from class: com.anythink.core.common.h.d.1.1
                            @Override // com.anythink.core.common.g.i
                            public final void onLoadCanceled(int i) {
                            }

                            @Override // com.anythink.core.common.g.i
                            public final void onLoadError(int i, String str, AdError adError) {
                                Log.e("anythink_s2s_reward", "S2S reward error! PlacementId: " + W + ", " + adError.printStackTrace());
                            }

                            @Override // com.anythink.core.common.g.i
                            public final void onLoadFinish(int i, Object obj) {
                                if (n.a().A()) {
                                    Log.i("anythink_s2s_reward", "S2S reward succeeded. PlacementId: " + W);
                                }
                            }

                            @Override // com.anythink.core.common.g.i
                            public final void onLoadStart(int i) {
                            }
                        });
                    }
                } catch (Throwable th) {
                }
            }
        });
    }
}
