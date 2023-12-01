package com.heytap.msp.mobad.api.ad;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.heytap.msp.mobad.api.listener.ISplashAdListener;
import com.heytap.msp.mobad.api.params.SplashAdParams;
import com.opos.mobad.ad.e.b;
import com.opos.mobad.ad.e.c;
import com.opos.mobad.ad.e.f;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/LandSplashAd.class */
public class LandSplashAd {
    private static final String TAG = "SplashAd";
    private Activity mActivity;
    private volatile b mLandSplashAdImpl;
    private a mListener;
    private String mPosId;
    private SplashAdParams mSplashAdParams;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/LandSplashAd$a.class */
    public static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private ISplashAdListener f22233a;

        public a(ISplashAdListener iSplashAdListener) {
            this.f22233a = iSplashAdListener;
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            ISplashAdListener iSplashAdListener = this.f22233a;
            StringBuilder sb = new StringBuilder();
            sb.append("code=");
            sb.append(i);
            sb.append(",msg=");
            sb.append(str != null ? str : "");
            iSplashAdListener.onAdFailed(sb.toString());
            this.f22233a.onAdFailed(i, str);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j) {
            this.f22233a.onAdClick();
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            this.f22233a.onAdShow(str);
            this.f22233a.onAdShow();
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            this.f22233a.onAdDismissed();
        }
    }

    public LandSplashAd(Activity activity, String str, ISplashAdListener iSplashAdListener, SplashAdParams splashAdParams) throws NullPointerException {
        if (activity == null || TextUtils.isEmpty(str) || iSplashAdListener == null || splashAdParams == null) {
            Log.e(TAG, "SplashAd Constructor param activity or posId or iSplashAdListener or splashAdParams is null.");
            return;
        }
        this.mActivity = activity;
        this.mPosId = str;
        if (splashAdParams != null) {
            this.mSplashAdParams = splashAdParams;
        } else {
            this.mSplashAdParams = new SplashAdParams.Builder().build();
        }
        this.mListener = new a(iSplashAdListener);
        if (initImplIfNeed()) {
            this.mLandSplashAdImpl.a((int) this.mSplashAdParams.fetchTimeout);
        } else {
            this.mListener.a(-1, "inter ad create fail");
        }
    }

    private boolean initImplIfNeed() {
        if (this.mLandSplashAdImpl != null) {
            return true;
        }
        if (this.mActivity == null || TextUtils.isEmpty(this.mPosId)) {
            return false;
        }
        synchronized (this) {
            if (this.mLandSplashAdImpl == null) {
                this.mLandSplashAdImpl = com.heytap.msp.mobad.api.a.a().a(this.mActivity, this.mPosId, (c) this.mListener, new f.a(this.mActivity).b(this.mSplashAdParams.desc).a(this.mSplashAdParams.fetchTimeout).a(this.mSplashAdParams.showPreLoadPage).b(this.mSplashAdParams.isUseSurfaceView).a(this.mSplashAdParams.title).c(false).a());
                if (this.mLandSplashAdImpl == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void destroyAd() {
        if (this.mLandSplashAdImpl != null) {
            this.mLandSplashAdImpl.b();
        }
        this.mActivity = null;
        this.mPosId = null;
        this.mSplashAdParams = null;
    }
}
