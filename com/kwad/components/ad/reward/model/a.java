package com.kwad.components.ad.reward.model;

import android.text.TextUtils;
import com.kwad.components.ad.reward.k.v;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/model/a.class */
public final class a {
    private String liveStartTime;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private String originPrice;
    private int playableStyle;
    private String price;
    private String qh;
    private String qi;
    private List<String> rC;
    private String rD;
    private String rE;
    private String rF;
    private boolean rG;
    private String rH;
    private String rI = "查看详情";
    private String rJ = "立即预约";
    private List<String> rK;
    private AdTemplate rL;
    private String title;

    private void U(String str) {
        this.rE = str;
    }

    private void V(String str) {
        this.rF = str;
    }

    public static a a(v vVar, boolean z) {
        AdTemplate adTemplate;
        if (vVar == null || (adTemplate = vVar.getAdTemplate()) == null) {
            return null;
        }
        AdInfo cb = d.cb(adTemplate);
        a aVar = new a();
        aVar.title = com.kwad.sdk.core.response.a.a.bK(cb);
        aVar.qh = com.kwad.sdk.core.response.a.a.bM(cb);
        aVar.qi = com.kwad.sdk.core.response.a.a.an(cb);
        aVar.rC = com.kwad.sdk.core.response.a.c.bS(adTemplate);
        aVar.rD = com.kwad.sdk.core.response.a.a.aw(cb);
        aVar.playableStyle = d.h(adTemplate, z);
        aVar.rL = adTemplate;
        aVar.mApkDownloadHelper = vVar.hb();
        return aVar;
    }

    public static a t(AdTemplate adTemplate) {
        CouponInfo firstCouponList;
        if (adTemplate == null) {
            return null;
        }
        AdInfo cb = d.cb(adTemplate);
        AdProductInfo ct = com.kwad.sdk.core.response.a.a.ct(cb);
        a aVar = new a();
        String name = ct.getName();
        aVar.title = name;
        if (TextUtils.isEmpty(name)) {
            aVar.title = com.kwad.sdk.core.response.a.a.ap(cb);
        }
        aVar.qh = ct.getIcon();
        aVar.qi = com.kwad.sdk.core.response.a.a.an(cb);
        aVar.price = ct.getPrice();
        aVar.originPrice = ct.getOriginPrice();
        if (!ct.isCouponListEmpty() && (firstCouponList = ct.getFirstCouponList()) != null) {
            aVar.V(CouponInfo.jinniuFormatCoupon(firstCouponList));
            aVar.U(firstCouponList.getFormattedJinniuPrefix());
        }
        return aVar;
    }

    public static a u(AdTemplate adTemplate) {
        AdMatrixInfo.MerchantLiveReservationInfo bI = com.kwad.sdk.core.response.a.b.bI(adTemplate);
        a aVar = new a();
        aVar.qh = bI.userHeadUrl;
        aVar.liveStartTime = bI.liveStartTime;
        aVar.title = bI.title;
        aVar.rG = bI.needShowSubscriberCount();
        aVar.rH = bI.getFormattedLiveSubscribeCount();
        aVar.rK = bI.bookUserUrlList;
        aVar.rI = bI.playEndCard.detailBtnTitle;
        aVar.rJ = bI.playEndCard.reservationBtnTitle;
        aVar.rL = adTemplate;
        return aVar;
    }

    public final String gY() {
        return this.rF;
    }

    public final String gZ() {
        return this.rE;
    }

    public final String getOriginPrice() {
        return this.originPrice;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String gm() {
        return this.qh;
    }

    public final String gn() {
        return this.qi;
    }

    public final AdTemplate ha() {
        return this.rL;
    }

    public final com.kwad.components.core.d.b.c hb() {
        return this.mApkDownloadHelper;
    }

    public final List<String> hc() {
        return this.rC;
    }

    public final boolean hd() {
        List<String> list = this.rC;
        return list == null || list.size() == 0;
    }

    public final int he() {
        return this.playableStyle;
    }

    public final String hf() {
        return this.rH;
    }

    public final String hg() {
        return this.rJ;
    }

    public final boolean hh() {
        return this.rG;
    }

    public final List<String> hi() {
        return this.rK;
    }

    public final String hj() {
        return this.liveStartTime;
    }
}
