package com.huawei.openalliance.ad.inter.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.ads.eo;
import com.huawei.hms.ads.eq;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.kl;
import com.huawei.hms.ads.km;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.ad.constant.at;
import com.huawei.openalliance.ad.inter.listeners.INonwifiActionListener;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/data/s.class */
public class s extends a implements i {
    private VideoInfo B;
    private boolean C;
    private boolean D;
    private transient INonwifiActionListener F;
    private RewardItem L;
    private transient com.huawei.openalliance.ad.inter.listeners.f S;

    /* renamed from: c  reason: collision with root package name */
    private com.huawei.openalliance.ad.inter.listeners.g f9369c;
    private int d;
    private boolean e;
    private boolean f;

    public s(AdContentData adContentData) {
        super(adContentData);
        this.C = false;
        this.d = 1;
        this.e = true;
        this.f = true;
        if (adContentData.G() == null || adContentData.H() == 0) {
            return;
        }
        this.L = new RewardItem(adContentData.G(), adContentData.H());
    }

    private void Code(Activity activity) {
        ge.V("RewardAd", "startRewardViaActivity");
        Intent intent = new Intent();
        intent.setAction(com.huawei.openalliance.ad.constant.t.af);
        intent.setPackage(com.huawei.openalliance.ad.utils.v.Z(activity));
        intent.putExtra("content_id", D());
        intent.putExtra("sdk_version", "13.4.61.304");
        intent.putExtra(at.g, h_());
        intent.putExtra(at.i, this.d);
        intent.putExtra(at.j, this.e);
        intent.putExtra(at.e, o());
        intent.putExtra(at.J, R());
        intent.putExtra(at.N, E());
        intent.putExtra(at.O, G());
        if (this.F != null) {
            VideoInfo T = T();
            if (T != null) {
                intent.putExtra("reward_key_nonwifi_action_play", this.F.Code(T.Z()));
            }
            AppInfo v = v();
            if (v != null) {
                intent.putExtra("reward_key_nonwifi_action_download", this.F.Code(v, v.B()));
            }
        }
        Code(activity, intent);
        AppInfo v2 = v();
        if (v2 != null && !TextUtils.isEmpty(v2.e())) {
            intent.putExtra("unique_id", v2.e());
        }
        intent.setClipData(com.huawei.openalliance.ad.constant.t.cF);
        activity.startActivityForResult(intent, 1);
    }

    private void Code(Context context, Intent intent) {
        String r = this.Code.r();
        if (com.huawei.openalliance.ad.utils.v.B(context) && r != null && km.F(r)) {
            intent.addFlags(268959744);
            intent.putExtra(at.ag, true);
        }
    }

    private VideoInfo T() {
        MetaData k;
        if (this.B == null && (k = k()) != null) {
            this.B = k.V();
        }
        return this.B;
    }

    private void V(Context context) {
        ge.V("RewardAd", "startRewardViaAidl");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content_id", D());
            jSONObject.put("sdk_version", "13.4.61.304");
            jSONObject.put(at.g, h_());
            jSONObject.put(at.i, this.d);
            jSONObject.put(at.j, this.e);
            jSONObject.put(at.e, o());
            jSONObject.put(at.N, E());
            jSONObject.put(at.O, G());
            if (this.F != null) {
                VideoInfo T = T();
                if (T != null) {
                    jSONObject.put("reward_key_nonwifi_action_play", this.F.Code(T.Z()));
                }
                AppInfo v = v();
                if (v != null) {
                    jSONObject.put("reward_key_nonwifi_action_download", this.F.Code(v, v.B()));
                }
            }
            AppInfo v2 = v();
            if (v2 != null && !TextUtils.isEmpty(v2.e())) {
                jSONObject.put("unique_id", v2.e());
            }
            com.huawei.openalliance.ad.ipc.g.V(context).Code("showReward", jSONObject.toString(), null, null);
        } catch (JSONException e) {
            ge.I("RewardAd", "startRewardViaAidl, e:" + e.getClass().getSimpleName());
        }
    }

    private void V(Context context, com.huawei.openalliance.ad.inter.listeners.f fVar) {
        ge.V("RewardAd", "showAd");
        if (context == null) {
            return;
        }
        Code(fVar);
        eq.Code(context).Code();
        eo.Code(this);
        AppInfo v = v();
        if (v != null) {
            ge.Code("RewardAd", "appName:" + v.L() + ", uniqueId:" + u() + ", appuniqueId:" + v.e());
        }
        if (!(context instanceof Activity)) {
            V(context);
            return;
        }
        Code((Activity) context);
        kl.Code(context).V(context);
    }

    @Override // com.huawei.openalliance.ad.inter.data.a, com.huawei.openalliance.ad.inter.data.e
    public RewardItem B() {
        return this.L;
    }

    @Override // com.huawei.openalliance.ad.inter.data.a
    public boolean C() {
        return this.D;
    }

    public void Code(int i) {
        this.d = i;
    }

    public void Code(Activity activity, com.huawei.openalliance.ad.inter.listeners.f fVar) {
        V(activity, fVar);
    }

    public void Code(Context context, com.huawei.openalliance.ad.inter.listeners.f fVar) {
        V(context, fVar);
    }

    public void Code(com.huawei.openalliance.ad.inter.listeners.f fVar) {
        this.S = fVar;
    }

    public void Code(com.huawei.openalliance.ad.inter.listeners.g gVar) {
        this.f9369c = gVar;
    }

    @Override // com.huawei.openalliance.ad.inter.data.a
    public void Code(boolean z) {
        this.D = z;
    }

    public com.huawei.openalliance.ad.inter.listeners.g I() {
        return this.f9369c;
    }

    public com.huawei.openalliance.ad.inter.listeners.f Q() {
        return this.S;
    }

    public boolean R() {
        return this.f;
    }

    @Override // com.huawei.openalliance.ad.inter.data.a
    public void V(boolean z) {
        this.C = z;
    }

    @Override // com.huawei.openalliance.ad.inter.data.a, com.huawei.openalliance.ad.inter.data.e
    public boolean V() {
        if (this.Code != null) {
            this.B = this.Code.p();
        }
        return this.B != null;
    }

    public void Z(boolean z) {
        this.f = z;
    }

    @Override // com.huawei.openalliance.ad.inter.data.a, com.huawei.openalliance.ad.inter.data.e
    public boolean Z() {
        return this.C;
    }

    public void a_(boolean z) {
        this.e = z;
    }
}
