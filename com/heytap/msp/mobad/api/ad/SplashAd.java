package com.heytap.msp.mobad.api.ad;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.heytap.msp.mobad.api.listener.ISplashAdListener;
import com.heytap.msp.mobad.api.params.SplashAdParams;
import com.opos.mobad.ad.e.b;
import com.opos.mobad.ad.e.c;
import com.opos.mobad.ad.e.d;
import com.opos.mobad.ad.e.e;
import com.opos.mobad.ad.e.f;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/SplashAd.class */
public class SplashAd {
    private static final int INIT_DELAY_TIME = 50;
    private Activity mActivity;
    private volatile boolean mHasDestroyed = false;
    private a mListener;
    private String mPosId;
    private volatile b mSplashAdImpl;
    private SplashAdParams mSplashAdParams;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/SplashAd$a.class */
    public static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private ISplashAdListener f8643a;

        public a(ISplashAdListener iSplashAdListener) {
            this.f8643a = iSplashAdListener;
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            ISplashAdListener iSplashAdListener = this.f8643a;
            if (iSplashAdListener != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("code=");
                sb.append(i);
                sb.append(",msg=");
                sb.append(str != null ? str : "");
                iSplashAdListener.onAdFailed(sb.toString());
                this.f8643a.onAdFailed(i, str);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j) {
            ISplashAdListener iSplashAdListener = this.f8643a;
            if (iSplashAdListener != null) {
                iSplashAdListener.onAdClick();
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            ISplashAdListener iSplashAdListener = this.f8643a;
            if (iSplashAdListener != null) {
                iSplashAdListener.onAdShow(str);
                this.f8643a.onAdShow();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            ISplashAdListener iSplashAdListener = this.f8643a;
            if (iSplashAdListener != null) {
                iSplashAdListener.onAdDismissed();
            }
        }
    }

    public SplashAd(Activity activity, String str, ISplashAdListener iSplashAdListener, SplashAdParams splashAdParams) throws NullPointerException {
        if (activity == null || TextUtils.isEmpty(str) || iSplashAdListener == null || splashAdParams == null) {
            Log.e("", "SplashAd Constructor param activity or posId or iSplashAdListener or splashAdParams is null");
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
        if (splashAdParams != null && splashAdParams.bottomArea != null && splashAdParams.bottomArea.getParent() != null) {
            this.mListener.a(10502, "The bottomArea view already has a parent..please not attachToRoot");
        } else if (initImplIfNeed()) {
            this.mSplashAdImpl.a((int) this.mSplashAdParams.fetchTimeout);
        } else {
            new Handler(activity.getMainLooper()).postDelayed(new Runnable() { // from class: com.heytap.msp.mobad.api.ad.SplashAd.1
                @Override // java.lang.Runnable
                public void run() {
                    if (SplashAd.this.mHasDestroyed) {
                        return;
                    }
                    if (SplashAd.this.initImplIfNeed()) {
                        SplashAd.this.mSplashAdImpl.a((int) SplashAd.this.mSplashAdParams.fetchTimeout);
                    } else {
                        SplashAd.this.mListener.a(-1, "inter ad create fail");
                    }
                }
            }, 50L);
        }
    }

    private e getISkipView() {
        if (this.mSplashAdParams.splashSkipView == null || this.mSplashAdParams.clickViews == null || this.mSplashAdParams.clickViews.size() <= 0) {
            return null;
        }
        return new e() { // from class: com.heytap.msp.mobad.api.ad.SplashAd.3
            @Override // com.opos.mobad.ad.e.e
            public View a() {
                return SplashAd.this.mSplashAdParams.splashSkipView;
            }

            @Override // com.opos.mobad.ad.e.e
            public void a(int i) {
                SplashAd.this.mSplashAdParams.splashSkipView.onSkipCountDown(i);
            }

            @Override // com.opos.mobad.ad.e.e
            public List<View> b() {
                return SplashAd.this.mSplashAdParams.clickViews;
            }
        };
    }

    private d getISplashBottomArea(final View view) {
        if (view != null) {
            return new d() { // from class: com.heytap.msp.mobad.api.ad.SplashAd.2
                @Override // com.opos.mobad.ad.e.d
                public View a() {
                    return view;
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean initImplIfNeed() {
        if (this.mSplashAdImpl != null) {
            return true;
        }
        if (this.mActivity == null || TextUtils.isEmpty(this.mPosId)) {
            return false;
        }
        synchronized (this) {
            if (this.mSplashAdImpl == null) {
                this.mSplashAdImpl = com.heytap.msp.mobad.api.a.a().b(this.mActivity, this.mPosId, this.mListener, new f.a(this.mActivity).a(getISplashBottomArea(this.mSplashAdParams.bottomArea)).b(this.mSplashAdParams.desc).a(this.mSplashAdParams.fetchTimeout).a(this.mSplashAdParams.showPreLoadPage).b(this.mSplashAdParams.isUseSurfaceView).a(this.mSplashAdParams.title).c(true).a(getISkipView()).a());
                if (this.mSplashAdImpl == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void destroyAd() {
        if (this.mSplashAdImpl != null) {
            this.mSplashAdImpl.b();
        }
        this.mActivity = null;
        this.mPosId = null;
        this.mHasDestroyed = true;
    }
}
