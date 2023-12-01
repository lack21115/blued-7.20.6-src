package com.anythink.core.common.b;

import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATCustomRuleKeys;
import com.anythink.core.api.ATRewardInfo;
import com.anythink.core.api.BaseAd;
import com.anythink.core.c.d;
import com.anythink.core.common.b.g;
import com.anythink.core.common.c.k;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/b/j.class */
public final class j extends ATAdInfo {
    private Map<String, Object> C;
    private ATBaseAdAdapter a;
    private Map<String, Object> x;
    private int b = -1;
    private String c = "";
    private int d = -1;
    private double e = 0.0d;
    private int f = 0;
    private String g = "";
    private Double h = Double.valueOf(0.0d);
    private String i = "";
    private String j = "";
    private String k = "";
    private String l = "";
    private String m = "unknow";
    private String n = "Network";
    private String o = "";
    private int p = 1;
    private int q = 0;
    private String r = "";
    private String s = "";
    private int t = 0;
    private String u = "";
    private String v = "";
    private Map<String, Object> w = null;
    private String y = "";
    private int z = 0;
    private String A = "";
    private int B = 0;

    public static j a(BaseAd baseAd) {
        if (baseAd != null) {
            j a = a(baseAd.getDetail());
            a.x = baseAd.getNetworkInfoMap();
            return a;
        }
        return new j();
    }

    public static j a(d dVar) {
        return dVar != null ? a(a(dVar.getTrackingInfo()), dVar) : new j();
    }

    private static j a(j jVar, d dVar) {
        if (dVar != null && (dVar instanceof ATBaseAdAdapter)) {
            ATBaseAdAdapter aTBaseAdAdapter = (ATBaseAdAdapter) dVar;
            jVar.a = aTBaseAdAdapter;
            jVar.x = aTBaseAdAdapter.getNetworkInfoMap();
        }
        return jVar;
    }

    private static j a(j jVar, com.anythink.core.common.e.e eVar) {
        ATRewardInfo r;
        ATRewardInfo aTRewardInfo;
        jVar.b = eVar.H();
        jVar.c = eVar.x();
        jVar.d = eVar.A();
        jVar.f = eVar.v();
        jVar.e = eVar.f();
        jVar.i = eVar.h();
        jVar.g = eVar.l();
        jVar.h = Double.valueOf(jVar.e / 1000.0d);
        jVar.j = eVar.o();
        jVar.l = com.anythink.core.common.k.g.d(eVar.Y());
        jVar.k = eVar.W();
        jVar.m = eVar.n();
        if (eVar.H() == 35) {
            jVar.n = "Cross_Promotion";
        } else if (eVar.H() == 66) {
            jVar.n = "Adx";
        } else {
            jVar.n = "Network";
        }
        jVar.o = eVar.k();
        jVar.p = eVar.m();
        jVar.q = eVar.I();
        jVar.r = eVar.C;
        if (TextUtils.equals(g.C0060g.b, jVar.l)) {
            Map<String, ATRewardInfo> q = eVar.q();
            if (q != null && q.containsKey(jVar.r) && (aTRewardInfo = q.get(jVar.r)) != null) {
                jVar.s = aTRewardInfo.rewardName;
                jVar.t = aTRewardInfo.rewardNumber;
            }
            if ((TextUtils.isEmpty(jVar.s) || jVar.t == 0) && (r = eVar.r()) != null) {
                jVar.s = r.rewardName;
                jVar.t = r.rewardNumber;
            }
        }
        jVar.v = n.a().n();
        jVar.u = n.a().o();
        jVar.w = eVar.s();
        jVar.y = eVar.e();
        jVar.z = eVar.M();
        jVar.A = eVar.P();
        jVar.B = eVar.U();
        Map<String, Object> a = eVar.a();
        if (a != null) {
            jVar.C = new HashMap(a);
        }
        return jVar;
    }

    private static j a(com.anythink.core.common.e.e eVar) {
        j jVar = new j();
        return eVar != null ? a(jVar, eVar) : jVar;
    }

    public static j a(com.anythink.core.common.e.e eVar, d dVar) {
        return a(a(eVar), dVar);
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getABTestId() {
        return 0;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getAdNetworkType() {
        return this.n;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getAdsourceId() {
        return this.c;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getAdsourceIndex() {
        return this.d;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getChannel() {
        return this.v;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getCountry() {
        return this.j;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getCurrency() {
        return this.i;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getCustomRule() {
        return this.w != null ? new JSONObject(this.w).toString() : "";
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getDismissType() {
        return this.z;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final double getEcpm() {
        return this.e;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getEcpmLevel() {
        return this.p;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getEcpmPrecision() {
        return this.m;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final Map<String, Object> getExtInfoMap() {
        return this.x;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final Map<String, Object> getLocalExtra() {
        return this.C;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getNetworkFirmId() {
        return this.b;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getNetworkPlacementId() {
        return this.o;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final Double getPublisherRevenue() {
        return this.h;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getRewardUserCustomData() {
        ATBaseAdAdapter aTBaseAdAdapter = this.a;
        return aTBaseAdAdapter != null ? aTBaseAdAdapter.getUserCustomData() : "";
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getScenarioId() {
        return this.r;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getScenarioRewardName() {
        return this.s;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getScenarioRewardNumber() {
        return this.t;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getSegmentId() {
        return this.q;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getShowId() {
        return this.g;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getSubChannel() {
        return this.u;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getTopOnAdFormat() {
        return this.l;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getTopOnPlacementId() {
        return this.k;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getTpBidId() {
        return this.y;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int isHeaderBiddingAdsource() {
        return this.f;
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.g);
            jSONObject.put("publisher_revenue", this.h);
            jSONObject.put("currency", this.i);
            jSONObject.put(DistrictSearchQuery.KEYWORDS_COUNTRY, this.j);
            jSONObject.put("adunit_id", this.k);
            jSONObject.put("adunit_format", this.l);
            jSONObject.put(com.anythink.core.common.l.P, this.m);
            jSONObject.put("network_type", this.n);
            jSONObject.put("network_placement_id", this.o);
            jSONObject.put(com.anythink.core.common.l.O, this.p);
            jSONObject.put(ATCustomRuleKeys.SEGMENT_ID, this.q);
            if (!TextUtils.isEmpty(this.r)) {
                jSONObject.put("scenario_id", this.r);
            }
            if (!TextUtils.isEmpty(this.s) && this.t != 0) {
                jSONObject.put("scenario_reward_name", this.s);
                jSONObject.put("scenario_reward_number", this.t);
            }
            if (!TextUtils.isEmpty(this.v)) {
                jSONObject.put("channel", this.v);
            }
            if (!TextUtils.isEmpty(this.u)) {
                jSONObject.put("sub_channel", this.u);
            }
            if (this.w != null && this.w.size() > 0) {
                jSONObject.put("custom_rule", new JSONObject(this.w));
            }
            jSONObject.put(k.a.d, this.b);
            jSONObject.put("adsource_id", this.c);
            jSONObject.put("adsource_index", this.d);
            jSONObject.put("adsource_price", this.e);
            jSONObject.put("adsource_isheaderbidding", this.f);
            if (this.x != null && this.x.size() > 0) {
                jSONObject.put("ext_info", new JSONObject(this.x));
            }
            if (this.a != null) {
                jSONObject.put("reward_custom_data", this.a.getUserCustomData());
            }
            if (!TextUtils.isEmpty(this.y)) {
                jSONObject.put("tp_bid_id", this.y);
            }
            if (this.z != 0) {
                jSONObject.put("dismiss_type", this.z);
            }
            if (!TextUtils.isEmpty(this.A)) {
                jSONObject.put(d.a.U, this.A);
            }
            jSONObject.put(com.anythink.core.common.g.c.I, this.B);
            if (this.C != null && this.C.size() > 0) {
                jSONObject.put("user_load_extra_data", new JSONObject(this.C));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }
}
