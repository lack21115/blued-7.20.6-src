package com.heytap.msp.mobad.api.ad;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.heytap.msp.mobad.api.listener.IInterstitialVideoAdListener;
import com.opos.mobad.ad.b.c;
import com.opos.mobad.ad.b.d;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/InterstitialVideoAd.class */
public class InterstitialVideoAd implements IBidding {
    private static final String TAG = InterstitialVideoAd.class.getSimpleName();
    private Activity mActivity;
    private volatile c mInstance;
    private a mListener;
    private String mPosId;

    /* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/InterstitialVideoAd$a.class */
    public static class a implements d {

        /* renamed from: a  reason: collision with root package name */
        private IInterstitialVideoAdListener f22232a;

        public a(IInterstitialVideoAdListener iInterstitialVideoAdListener) {
            this.f22232a = iInterstitialVideoAdListener;
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            IInterstitialVideoAdListener iInterstitialVideoAdListener = this.f22232a;
            if (iInterstitialVideoAdListener != null) {
                iInterstitialVideoAdListener.onAdReady();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            IInterstitialVideoAdListener iInterstitialVideoAdListener = this.f22232a;
            if (iInterstitialVideoAdListener != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("code=");
                sb.append(i);
                sb.append(",msg=");
                sb.append(str != null ? str : "");
                iInterstitialVideoAdListener.onAdFailed(sb.toString());
                this.f22232a.onAdFailed(i, str);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j) {
            IInterstitialVideoAdListener iInterstitialVideoAdListener = this.f22232a;
            if (iInterstitialVideoAdListener != null) {
                iInterstitialVideoAdListener.onAdClick();
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            IInterstitialVideoAdListener iInterstitialVideoAdListener = this.f22232a;
            if (iInterstitialVideoAdListener != null) {
                iInterstitialVideoAdListener.onAdShow();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            IInterstitialVideoAdListener iInterstitialVideoAdListener = this.f22232a;
            if (iInterstitialVideoAdListener != null) {
                iInterstitialVideoAdListener.onAdClose();
            }
        }

        @Override // com.opos.mobad.ad.b.d
        public void c() {
            IInterstitialVideoAdListener iInterstitialVideoAdListener = this.f22232a;
            if (iInterstitialVideoAdListener != null) {
                iInterstitialVideoAdListener.onVideoPlayComplete();
            }
        }
    }

    public InterstitialVideoAd(Activity activity, String str, IInterstitialVideoAdListener iInterstitialVideoAdListener) {
        if (activity == null || TextUtils.isEmpty(str)) {
            Log.e(TAG, "InterstitialAd Constructor param activity and posId can't be null.");
            return;
        }
        this.mActivity = activity;
        this.mPosId = str;
        this.mListener = new a(iInterstitialVideoAdListener);
        initImplIfNeed();
    }

    private boolean initImplIfNeed() {
        if (this.mInstance != null) {
            return true;
        }
        if (this.mActivity == null || TextUtils.isEmpty(this.mPosId)) {
            return false;
        }
        synchronized (this) {
            if (this.mInstance == null) {
                this.mInstance = com.heytap.msp.mobad.api.a.a().a(this.mActivity, this.mPosId, this.mListener);
                if (this.mInstance == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void destroyAd() {
        if (this.mInstance != null) {
            this.mInstance.b();
        }
        this.mActivity = null;
        this.mPosId = null;
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public int getECPM() {
        if (this.mInstance != null) {
            return this.mInstance.g();
        }
        return 0;
    }

    public void loadAd() {
        if (initImplIfNeed()) {
            this.mInstance.a();
            return;
        }
        a aVar = this.mListener;
        if (aVar != null) {
            aVar.a(-1, "inter ad create fail");
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankLoss(int i, String str, int i2) {
        if (this.mInstance != null) {
            this.mInstance.a(i, str, i2);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankWin(int i) {
        if (this.mInstance != null) {
            this.mInstance.b(i);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void setBidECPM(int i) {
        if (this.mInstance != null) {
            this.mInstance.c(i);
        }
    }

    public void showAd() {
        if (initImplIfNeed()) {
            this.mInstance.a(this.mActivity);
            return;
        }
        a aVar = this.mListener;
        if (aVar != null) {
            aVar.a(-1, "inter ad create fail");
        }
    }
}
