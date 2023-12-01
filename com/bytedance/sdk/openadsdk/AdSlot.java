package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.mb;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/AdSlot.class */
public class AdSlot implements TTAdSlot {
    private int b;
    private String df;
    private String e;
    private String g;
    private String gm;
    private float h;
    private float hj;

    /* renamed from: io  reason: collision with root package name */
    private int[] f7903io;
    private int jb;
    private int je;
    private TTAdLoadType jq;
    private boolean ko;
    private int l;
    private boolean lc;
    private String lz;
    private String m;
    private String mb;
    private int nk;
    private int o;
    private String on;
    private int ox;
    private String r;
    private int u;
    private boolean ww;
    private String x;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/AdSlot$Builder.class */
    public static class Builder {
        private String df;
        private int e;
        private String gm;

        /* renamed from: io  reason: collision with root package name */
        private int[] f7904io;
        private String jb;
        private int je;
        private String ko;
        private String l;
        private String m;
        private String mb;
        private float nk;
        private float o;
        private String on;
        private String r;
        private int x;
        private int ox = 640;
        private int b = 320;
        private boolean hj = true;
        private boolean h = false;
        private int u = 1;
        private String ww = "defaultUser";
        private int lz = 2;
        private boolean lc = true;
        private TTAdLoadType g = TTAdLoadType.UNKNOWN;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.mb = this.mb;
            adSlot.u = this.u;
            adSlot.ko = this.hj;
            adSlot.ww = this.h;
            adSlot.ox = this.ox;
            adSlot.b = this.b;
            float f = this.nk;
            if (f <= 0.0f) {
                adSlot.hj = this.ox;
                adSlot.h = this.b;
            } else {
                adSlot.hj = f;
                adSlot.h = this.o;
            }
            adSlot.lz = this.ko;
            adSlot.x = this.ww;
            adSlot.jb = this.lz;
            adSlot.nk = this.x;
            adSlot.lc = this.lc;
            adSlot.f7903io = this.f7904io;
            adSlot.l = this.e;
            adSlot.m = this.l;
            adSlot.e = this.jb;
            adSlot.g = this.df;
            adSlot.df = this.r;
            adSlot.r = this.on;
            adSlot.je = this.je;
            adSlot.gm = this.m;
            adSlot.on = this.gm;
            adSlot.jq = this.g;
            return adSlot;
        }

        public Builder setAdCount(int i) {
            int i2 = i;
            if (i <= 0) {
                i2 = 1;
                mb.b(TTAdConstant.TAG, "setAdCount: adCount must greater than 0 ");
            }
            int i3 = i2;
            if (i2 > 20) {
                mb.b(TTAdConstant.TAG, "setAdCount: adCount must less than or equal to 20 ");
                i3 = 20;
            }
            this.u = i3;
            return this;
        }

        public Builder setAdId(String str) {
            this.df = str;
            return this;
        }

        public Builder setAdLoadType(TTAdLoadType tTAdLoadType) {
            this.g = tTAdLoadType;
            return this;
        }

        public Builder setAdType(int i) {
            this.je = i;
            return this;
        }

        public Builder setAdloadSeq(int i) {
            this.e = i;
            return this;
        }

        public Builder setCodeId(String str) {
            this.mb = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.r = str;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f, float f2) {
            this.nk = f;
            this.o = f2;
            return this;
        }

        public Builder setExt(String str) {
            this.on = str;
            return this;
        }

        public Builder setExternalABVid(int... iArr) {
            this.f7904io = iArr;
            return this;
        }

        public Builder setExtraParam(String str) {
            this.jb = str;
            return this;
        }

        public Builder setImageAcceptedSize(int i, int i2) {
            this.ox = i;
            this.b = i2;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.lc = z;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.ko = str;
            return this;
        }

        public Builder setNativeAdType(int i) {
            this.x = i;
            return this;
        }

        public Builder setOrientation(int i) {
            this.lz = i;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.l = str;
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            this.hj = z;
            return this;
        }

        public Builder setUserData(String str) {
            this.gm = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.ww = str;
            return this;
        }

        public Builder supportRenderControl() {
            this.h = true;
            return this;
        }

        public Builder withBid(String str) {
            if (str == null) {
                return this;
            }
            this.m = str;
            return this;
        }
    }

    private AdSlot() {
        this.jb = 2;
        this.lc = true;
    }

    private String mb(String str, int i) {
        if (i < 1) {
            return str;
        }
        try {
            JSONObject jSONObject = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
            jSONObject.put("_tt_group_load_more", i);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return str;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getAdCount() {
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getAdId() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public TTAdLoadType getAdLoadType() {
        return this.jq;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getAdType() {
        return this.je;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getAdloadSeq() {
        return this.l;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getBidAdm() {
        return this.gm;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getCodeId() {
        return this.mb;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getCreativeId() {
        return this.df;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getDurationSlotType() {
        return this.o;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public float getExpressViewAcceptedHeight() {
        return this.h;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public float getExpressViewAcceptedWidth() {
        return this.hj;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getExt() {
        return this.r;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int[] getExternalABVid() {
        return this.f7903io;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getExtraSmartLookParam() {
        return this.e;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getImgAcceptedHeight() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getImgAcceptedWidth() {
        return this.ox;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getMediaExtra() {
        return this.lz;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getNativeAdType() {
        return this.nk;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public int getOrientation() {
        return this.jb;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getPrimeRit() {
        String str = this.m;
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getUserData() {
        return this.on;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public String getUserID() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isAutoPlay() {
        return this.lc;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isSupportDeepLink() {
        return this.ko;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public boolean isSupportRenderConrol() {
        return this.ww;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setAdCount(int i) {
        this.u = i;
    }

    public void setAdLoadType(TTAdLoadType tTAdLoadType) {
        this.jq = tTAdLoadType;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setDurationSlotType(int i) {
        this.o = i;
    }

    public void setExternalABVid(int... iArr) {
        this.f7903io = iArr;
    }

    public void setGroupLoadMore(int i) {
        this.lz = mb(this.lz, i);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdSlot
    public void setNativeAdType(int i) {
        this.nk = i;
    }

    public void setUserData(String str) {
        this.on = str;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.mb);
            jSONObject.put("mIsAutoPlay", this.lc);
            jSONObject.put("mImgAcceptedWidth", this.ox);
            jSONObject.put("mImgAcceptedHeight", this.b);
            jSONObject.put("mExpressViewAcceptedWidth", this.hj);
            jSONObject.put("mExpressViewAcceptedHeight", this.h);
            jSONObject.put("mAdCount", this.u);
            jSONObject.put("mSupportDeepLink", this.ko);
            jSONObject.put("mSupportRenderControl", this.ww);
            jSONObject.put("mMediaExtra", this.lz);
            jSONObject.put("mUserID", this.x);
            jSONObject.put("mOrientation", this.jb);
            jSONObject.put("mNativeAdType", this.nk);
            jSONObject.put("mAdloadSeq", this.l);
            jSONObject.put("mPrimeRit", this.m);
            jSONObject.put("mExtraSmartLookParam", this.e);
            jSONObject.put("mAdId", this.g);
            jSONObject.put("mCreativeId", this.df);
            jSONObject.put("mExt", this.r);
            jSONObject.put("mBidAdm", this.gm);
            jSONObject.put("mUserData", this.on);
            jSONObject.put("mAdLoadType", this.jq);
            return jSONObject;
        } catch (Exception e) {
            return jSONObject;
        }
    }

    public String toString() {
        return "AdSlot{mCodeId='" + this.mb + "', mImgAcceptedWidth=" + this.ox + ", mImgAcceptedHeight=" + this.b + ", mExpressViewAcceptedWidth=" + this.hj + ", mExpressViewAcceptedHeight=" + this.h + ", mAdCount=" + this.u + ", mSupportDeepLink=" + this.ko + ", mSupportRenderControl=" + this.ww + ", mMediaExtra='" + this.lz + "', mUserID='" + this.x + "', mOrientation=" + this.jb + ", mNativeAdType=" + this.nk + ", mIsAutoPlay=" + this.lc + ", mPrimeRit" + this.m + ", mAdloadSeq" + this.l + ", mAdId" + this.g + ", mCreativeId" + this.df + ", mExt" + this.r + ", mUserData" + this.on + ", mAdLoadType" + this.jq + '}';
    }
}
