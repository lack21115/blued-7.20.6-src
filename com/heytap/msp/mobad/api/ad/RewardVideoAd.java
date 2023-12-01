package com.heytap.msp.mobad.api.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.heytap.msp.mobad.api.listener.IRewardVideoAdListener;
import com.heytap.msp.mobad.api.params.RewardVideoAdParams;
import com.opos.mobad.ad.d.b;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/RewardVideoAd.class */
public class RewardVideoAd implements IBidding {
    public static final int REWARD_SCENE_AD_CLICK = 5;
    public static final int REWARD_SCENE_INSTALL_COMPLETE = 2;
    public static final int REWARD_SCENE_LAUNCH_APP = 3;
    public static final int REWARD_SCENE_NO = 0;
    public static final int REWARD_SCENE_PLAY_COMPLETE = 1;
    public static final int REWARD_SCENE_PLAY_INTERACTION = 4;
    private static final String TAG = "RewardVideoAd";
    private Context mContext;
    private a mListener;
    private String mPosId;
    private volatile com.opos.mobad.ad.d.a mRewardVideoAdImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/RewardVideoAd$a.class */
    public static class a implements b {
        private IRewardVideoAdListener b;

        public a(IRewardVideoAdListener iRewardVideoAdListener) {
            this.b = iRewardVideoAdListener;
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            this.b.onAdSuccess();
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            IRewardVideoAdListener iRewardVideoAdListener = this.b;
            StringBuilder sb = new StringBuilder();
            sb.append("code=");
            sb.append(i);
            sb.append(",msg=");
            sb.append(str != null ? str : "");
            iRewardVideoAdListener.onAdFailed(sb.toString());
            this.b.onAdFailed(i, str);
        }

        @Override // com.opos.mobad.ad.d.b, com.opos.mobad.ad.i.b
        public void a(long j) {
            this.b.onAdClick(j);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
        }

        @Override // com.opos.mobad.ad.h
        public void a(Object... objArr) {
            this.b.onReward(objArr);
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
        }

        @Override // com.opos.mobad.ad.d.b
        public void b(long j) {
            this.b.onVideoPlayClose(j);
        }

        @Override // com.opos.mobad.ad.d.b
        public void b(String str) {
            this.b.onVideoPlayError(str);
        }

        @Override // com.opos.mobad.ad.d.b
        public void c() {
            this.b.onVideoPlayStart();
        }

        @Override // com.opos.mobad.ad.d.b
        public void d() {
            this.b.onVideoPlayComplete();
        }

        @Override // com.opos.mobad.ad.d.b
        public void e() {
            this.b.onLandingPageOpen();
        }

        @Override // com.opos.mobad.ad.d.b
        public void f() {
            this.b.onLandingPageClose();
        }
    }

    public RewardVideoAd(Context context, String str, IRewardVideoAdListener iRewardVideoAdListener) {
        if (context == null || TextUtils.isEmpty(str) || iRewardVideoAdListener == null) {
            Log.e(TAG, "RewardVideoAd Constructor param context and posId and iRewardVideoAdListener can't be null.");
            return;
        }
        this.mContext = context;
        this.mPosId = str;
        this.mListener = new a(iRewardVideoAdListener);
        initImplIfNeed();
    }

    private boolean initImplIfNeed() {
        if (this.mRewardVideoAdImpl != null) {
            return true;
        }
        if (this.mContext == null || TextUtils.isEmpty(this.mPosId)) {
            return false;
        }
        synchronized (this) {
            if (this.mRewardVideoAdImpl == null) {
                this.mRewardVideoAdImpl = com.heytap.msp.mobad.api.a.a().a(this.mContext, this.mPosId, this.mListener);
                if (this.mRewardVideoAdImpl == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void destroyAd() {
        if (this.mRewardVideoAdImpl != null) {
            this.mRewardVideoAdImpl.b();
        }
        this.mContext = null;
        this.mPosId = null;
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public int getECPM() {
        if (this.mRewardVideoAdImpl != null) {
            return this.mRewardVideoAdImpl.g();
        }
        return 0;
    }

    @Deprecated
    public int getRewardScene() {
        return 1;
    }

    public boolean isReady() {
        if (this.mRewardVideoAdImpl != null) {
            return this.mRewardVideoAdImpl.e();
        }
        return false;
    }

    public void loadAd() {
        loadAd(null);
    }

    public void loadAd(RewardVideoAdParams rewardVideoAdParams) {
        if (initImplIfNeed()) {
            if (rewardVideoAdParams != null) {
                this.mRewardVideoAdImpl.a((int) rewardVideoAdParams.fetchTimeout);
                return;
            } else {
                this.mRewardVideoAdImpl.a();
                return;
            }
        }
        a aVar = this.mListener;
        if (aVar != null) {
            aVar.a(-1, "inter ad create fail");
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankLoss(int i, String str, int i2) {
        if (this.mRewardVideoAdImpl != null) {
            this.mRewardVideoAdImpl.a(i, str, i2);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankWin(int i) {
        if (this.mRewardVideoAdImpl != null) {
            this.mRewardVideoAdImpl.b(i);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void setBidECPM(int i) {
        if (this.mRewardVideoAdImpl != null) {
            this.mRewardVideoAdImpl.c(i);
        }
    }

    public void showAd() {
        showAd(false);
    }

    public void showAd(boolean z) {
        if (initImplIfNeed()) {
            this.mRewardVideoAdImpl.a(z);
            return;
        }
        a aVar = this.mListener;
        if (aVar != null) {
            aVar.a(-1, "inter ad create fail");
        }
    }
}
