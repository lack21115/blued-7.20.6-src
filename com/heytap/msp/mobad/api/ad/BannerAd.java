package com.heytap.msp.mobad.api.ad;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.heytap.msp.mobad.api.listener.IBannerAdListener;
import com.opos.mobad.ad.a.b;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/BannerAd.class */
public class BannerAd implements IBidding {
    private static final String TAG = "BannerAd";
    private Activity mActivity;
    private com.opos.mobad.ad.a.a mBannerAdImpl;
    private a mListenerWrapper;
    private String mPosId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/BannerAd$a.class */
    public static class a implements b {
        private IBannerAdListener b;

        public a(IBannerAdListener iBannerAdListener) {
            this.b = iBannerAdListener;
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            IBannerAdListener iBannerAdListener = this.b;
            if (iBannerAdListener != null) {
                iBannerAdListener.onAdReady();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            IBannerAdListener iBannerAdListener = this.b;
            if (iBannerAdListener != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("code=");
                sb.append(i);
                sb.append(",msg=");
                sb.append(str != null ? str : "");
                iBannerAdListener.onAdFailed(sb.toString());
            }
            IBannerAdListener iBannerAdListener2 = this.b;
            if (iBannerAdListener2 != null) {
                iBannerAdListener2.onAdFailed(i, str);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j) {
            IBannerAdListener iBannerAdListener = this.b;
            if (iBannerAdListener != null) {
                iBannerAdListener.onAdClick();
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            IBannerAdListener iBannerAdListener = this.b;
            if (iBannerAdListener != null) {
                iBannerAdListener.onAdShow();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            IBannerAdListener iBannerAdListener = this.b;
            if (iBannerAdListener != null) {
                iBannerAdListener.onAdClose();
            }
        }
    }

    public BannerAd(Activity activity, String str) {
        if (activity == null || TextUtils.isEmpty(str)) {
            Log.e(TAG, "BannerAd Constructor param activity and posId can't be null.");
            return;
        }
        this.mListenerWrapper = new a(null);
        this.mActivity = activity;
        this.mPosId = str;
        initImplIfNeed();
    }

    private boolean initImplIfNeed() {
        boolean z = false;
        if (this.mBannerAdImpl == null) {
            if (this.mActivity != null) {
                if (TextUtils.isEmpty(this.mPosId)) {
                    return false;
                }
                com.opos.mobad.ad.a.a a2 = com.heytap.msp.mobad.api.a.a().a(this.mActivity, this.mPosId, this.mListenerWrapper);
                this.mBannerAdImpl = a2;
                if (a2 == null) {
                    return false;
                }
            }
            return z;
        }
        z = true;
        return z;
    }

    public void destroyAd() {
        com.opos.mobad.ad.a.a aVar = this.mBannerAdImpl;
        if (aVar != null) {
            aVar.b();
        }
        this.mBannerAdImpl = null;
        this.mActivity = null;
        this.mPosId = null;
    }

    public View getAdView() {
        if (initImplIfNeed()) {
            return this.mBannerAdImpl.h();
        }
        a aVar = this.mListenerWrapper;
        if (aVar != null) {
            aVar.a(-1, "inter ad create fail");
            return null;
        }
        return null;
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public int getECPM() {
        com.opos.mobad.ad.a.a aVar = this.mBannerAdImpl;
        if (aVar != null) {
            return aVar.g();
        }
        return 0;
    }

    public void loadAd() {
        if (initImplIfNeed()) {
            this.mBannerAdImpl.a();
            return;
        }
        a aVar = this.mListenerWrapper;
        if (aVar != null) {
            aVar.a(-1, "inter ad create fail");
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankLoss(int i, String str, int i2) {
        com.opos.mobad.ad.a.a aVar = this.mBannerAdImpl;
        if (aVar != null) {
            aVar.a(i, str, i2);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankWin(int i) {
        com.opos.mobad.ad.a.a aVar = this.mBannerAdImpl;
        if (aVar != null) {
            aVar.b(i);
        }
    }

    public void setAdListener(IBannerAdListener iBannerAdListener) {
        a aVar = this.mListenerWrapper;
        if (aVar != null) {
            aVar.b = iBannerAdListener;
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void setBidECPM(int i) {
        com.opos.mobad.ad.a.a aVar = this.mBannerAdImpl;
        if (aVar != null) {
            aVar.c(i);
        }
    }
}
