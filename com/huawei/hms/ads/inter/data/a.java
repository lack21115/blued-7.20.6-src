package com.huawei.hms.ads.inter.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.ads.d;
import com.huawei.hms.ads.e;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener;
import com.huawei.hms.ads.kl;
import com.huawei.hms.ads.reward.RewardAdListener;
import com.huawei.openalliance.ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.ad.constant.at;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.listeners.INonwifiActionListener;
import com.huawei.openalliance.ad.ipc.g;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.v;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/inter/data/a.class */
public class a extends com.huawei.openalliance.ad.inter.data.a implements IInterstitialAd {
    private transient INonwifiActionListener B;
    private RewardAdListener C;
    private List<ImageInfo> F;
    private VideoInfo S;
    private transient IInterstitialAdStatusListener Z;

    public a(AdContentData adContentData) {
        super(adContentData);
    }

    private void Code(Activity activity) {
        ge.V("InnerInterstitialAd", "startInterstitialViaActivity");
        Intent intent = new Intent();
        intent.setAction(t.aj);
        intent.setPackage(v.Z(activity));
        intent.putExtra("content_id", D());
        intent.putExtra("sdk_version", "13.4.61.304");
        intent.putExtra(at.g, h_());
        intent.putExtra(at.e, o());
        intent.putExtra(at.N, E());
        intent.putExtra(at.O, G());
        if (this.B != null) {
            VideoInfo Q = Q();
            if (Q != null) {
                intent.putExtra("reward_key_nonwifi_action_play", this.B.Code(Q.Z()));
            }
            AppInfo v = v();
            if (v != null) {
                intent.putExtra("reward_key_nonwifi_action_download", this.B.Code(v, v.B()));
            }
        }
        AppInfo v2 = v();
        if (v2 != null && !TextUtils.isEmpty(v2.e())) {
            intent.putExtra("unique_id", v2.e());
        }
        intent.setClipData(t.cF);
        activity.startActivityForResult(intent, 1);
    }

    private void Code(IInterstitialAdStatusListener iInterstitialAdStatusListener) {
        this.Z = iInterstitialAdStatusListener;
    }

    private VideoInfo Q() {
        MetaData k;
        if (this.S == null && (k = k()) != null) {
            this.S = k.V();
        }
        return this.S;
    }

    private void V(Context context) {
        ge.V("InnerInterstitialAd", "startInterstitialViaAidl");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content_id", D());
            jSONObject.put("sdk_version", "13.4.61.304");
            jSONObject.put(at.g, h_());
            jSONObject.put(at.e, o());
            jSONObject.put(at.N, E());
            jSONObject.put(at.O, G());
            if (this.B != null) {
                VideoInfo Q = Q();
                if (Q != null) {
                    jSONObject.put("reward_key_nonwifi_action_play", this.B.Code(Q.Z()));
                }
                AppInfo v = v();
                if (v != null) {
                    jSONObject.put("reward_key_nonwifi_action_download", this.B.Code(v, v.B()));
                }
            }
            AppInfo v2 = v();
            if (v2 != null && !TextUtils.isEmpty(v2.e())) {
                jSONObject.put("unique_id", v2.e());
            }
            g.V(context).Code("interstitial_ad_show", jSONObject.toString(), null, null);
        } catch (JSONException e) {
            ge.I("InnerInterstitialAd", "startInterstitialViaAidl, e:" + e.getClass().getSimpleName());
        }
    }

    public RewardAdListener Code() {
        return this.C;
    }

    public IInterstitialAdStatusListener I() {
        return this.Z;
    }

    @Override // com.huawei.openalliance.ad.inter.data.a, com.huawei.openalliance.ad.inter.data.e
    public boolean V() {
        boolean z = false;
        if (this.Code != null) {
            this.S = this.Code.p();
            MetaData Z = this.Code.Z();
            if (Z != null) {
                this.F = Z.b();
            }
            if (this.Code.h() == 9) {
                if (this.S != null) {
                    z = true;
                }
                return z;
            } else if (this.Code.h() == 2 || this.Code.h() == 4) {
                return !aa.Code(this.F);
            } else {
                return false;
            }
        }
        return false;
    }

    @Override // com.huawei.hms.ads.inter.data.IInterstitialAd
    public void setNonwifiActionListener(INonwifiActionListener iNonwifiActionListener) {
        this.B = iNonwifiActionListener;
    }

    @Override // com.huawei.hms.ads.inter.data.IInterstitialAd
    public void setRewardAdListener(RewardAdListener rewardAdListener) {
        this.C = rewardAdListener;
    }

    @Override // com.huawei.hms.ads.inter.data.IInterstitialAd
    public void show(Context context, IInterstitialAdStatusListener iInterstitialAdStatusListener) {
        if (context == null) {
            return;
        }
        V(true);
        Code(iInterstitialAdStatusListener);
        d.Code(context).Code();
        e.Code(this);
        AppInfo v = v();
        if (v != null) {
            ge.Code("InnerInterstitialAd", "appName:" + v.L() + ", uniqueId:" + u() + ", appuniqueId:" + v.e());
        }
        if (!(context instanceof Activity)) {
            V(context);
            return;
        }
        Code((Activity) context);
        kl.Code(context).V(context);
    }
}
