package com.heytap.msp.mobad.api.ad;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.heytap.msp.mobad.api.listener.IHotSplashListener;
import com.heytap.msp.mobad.api.params.SplashAdParams;
import com.opos.mobad.ad.e.c;
import com.opos.mobad.ad.e.d;
import com.opos.mobad.ad.e.e;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/HotSplashAd.class */
public class HotSplashAd implements IBidding {
    private static final int INIT_DELAY_TIME = 50;
    private Context mContext;
    private final c mListener;
    private String mPosId;
    private com.opos.mobad.ad.e.a mSplashAdImpl;
    private final SplashAdParams mSplashAdParams;
    private boolean mIsReady = false;
    private boolean mHadShowed = false;
    private volatile boolean mHasDestroyed = false;

    /* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/HotSplashAd$a.class */
    class a implements c {

        /* renamed from: c  reason: collision with root package name */
        private IHotSplashListener f22231c;

        public a(IHotSplashListener iHotSplashListener) {
            this.f22231c = iHotSplashListener;
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            HotSplashAd.this.mIsReady = true;
            IHotSplashListener iHotSplashListener = this.f22231c;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdReady();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            IHotSplashListener iHotSplashListener = this.f22231c;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdFailed(i, str);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j) {
            IHotSplashListener iHotSplashListener = this.f22231c;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdClick();
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            HotSplashAd.this.mHadShowed = true;
            IHotSplashListener iHotSplashListener = this.f22231c;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdShow(str);
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            IHotSplashListener iHotSplashListener = this.f22231c;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdDismissed();
            }
        }
    }

    public HotSplashAd(Context context, String str, IHotSplashListener iHotSplashListener, SplashAdParams splashAdParams) throws NullPointerException {
        if (context == null || TextUtils.isEmpty(str) || iHotSplashListener == null || splashAdParams == null) {
            throw new NullPointerException("SplashAd Constructor param context or posId or iSplashAdListener or splashAdParams is null.");
        }
        this.mListener = new a(iHotSplashListener);
        this.mSplashAdParams = splashAdParams;
        this.mContext = context;
        this.mPosId = str;
        if (splashAdParams.bottomArea != null && splashAdParams.bottomArea.getParent() != null) {
            this.mListener.a(10502, "The bottomArea view already has a parent..please not attachToRoot");
        } else if (initImplIfNeed()) {
            this.mSplashAdImpl.a((int) this.mSplashAdParams.fetchTimeout);
        } else {
            new Handler(context.getMainLooper()).postDelayed(new Runnable() { // from class: com.heytap.msp.mobad.api.ad.HotSplashAd.1
                @Override // java.lang.Runnable
                public void run() {
                    if (HotSplashAd.this.mHasDestroyed) {
                        return;
                    }
                    if (HotSplashAd.this.initImplIfNeed()) {
                        HotSplashAd.this.mSplashAdImpl.a((int) HotSplashAd.this.mSplashAdParams.fetchTimeout);
                    } else {
                        HotSplashAd.this.mListener.a(-1, "inter ad create fail");
                    }
                }
            }, 50L);
        }
    }

    private e getISkipView() {
        if (this.mSplashAdParams.splashSkipView == null || this.mSplashAdParams.clickViews == null || this.mSplashAdParams.clickViews.size() <= 0) {
            return null;
        }
        return new e() { // from class: com.heytap.msp.mobad.api.ad.HotSplashAd.3
            @Override // com.opos.mobad.ad.e.e
            public View a() {
                return HotSplashAd.this.mSplashAdParams.splashSkipView;
            }

            @Override // com.opos.mobad.ad.e.e
            public void a(int i) {
                HotSplashAd.this.mSplashAdParams.splashSkipView.onSkipCountDown(i);
            }

            @Override // com.opos.mobad.ad.e.e
            public List<View> b() {
                return HotSplashAd.this.mSplashAdParams.clickViews;
            }
        };
    }

    private d getISplashBottomArea(final View view) {
        if (view != null) {
            return new d() { // from class: com.heytap.msp.mobad.api.ad.HotSplashAd.2
                @Override // com.opos.mobad.ad.e.d
                public View a() {
                    return view;
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00aa, code lost:
        if (r0 == null) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean initImplIfNeed() {
        /*
            r6 = this;
            r0 = r6
            com.opos.mobad.ad.e.a r0 = r0.mSplashAdImpl
            r8 = r0
            r0 = 1
            r7 = r0
            r0 = r8
            if (r0 == 0) goto Ld
            r0 = 1
            return r0
        Ld:
            r0 = r6
            android.content.Context r0 = r0.mContext
            if (r0 == 0) goto Lb5
            r0 = r6
            java.lang.String r0 = r0.mPosId
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L21
            goto Lb5
        L21:
            r0 = r6
            monitor-enter(r0)
            r0 = r6
            com.opos.mobad.ad.e.a r0 = r0.mSplashAdImpl     // Catch: java.lang.Throwable -> Lb0
            if (r0 == 0) goto L2e
            r0 = r6
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb0
            r0 = 1
            return r0
        L2e:
            r0 = r6
            com.opos.mobad.ad.e.e r0 = r0.getISkipView()     // Catch: java.lang.Throwable -> Lb0
            r8 = r0
            com.opos.mobad.ad.e.f$a r0 = new com.opos.mobad.ad.e.f$a     // Catch: java.lang.Throwable -> Lb0
            r1 = r0
            r2 = r6
            android.content.Context r2 = r2.mContext     // Catch: java.lang.Throwable -> Lb0
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lb0
            r1 = r6
            r2 = r6
            com.heytap.msp.mobad.api.params.SplashAdParams r2 = r2.mSplashAdParams     // Catch: java.lang.Throwable -> Lb0
            android.view.View r2 = r2.bottomArea     // Catch: java.lang.Throwable -> Lb0
            com.opos.mobad.ad.e.d r1 = r1.getISplashBottomArea(r2)     // Catch: java.lang.Throwable -> Lb0
            com.opos.mobad.ad.e.f$a r0 = r0.a(r1)     // Catch: java.lang.Throwable -> Lb0
            r1 = r6
            com.heytap.msp.mobad.api.params.SplashAdParams r1 = r1.mSplashAdParams     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r1 = r1.desc     // Catch: java.lang.Throwable -> Lb0
            com.opos.mobad.ad.e.f$a r0 = r0.b(r1)     // Catch: java.lang.Throwable -> Lb0
            r1 = r6
            com.heytap.msp.mobad.api.params.SplashAdParams r1 = r1.mSplashAdParams     // Catch: java.lang.Throwable -> Lb0
            long r1 = r1.fetchTimeout     // Catch: java.lang.Throwable -> Lb0
            com.opos.mobad.ad.e.f$a r0 = r0.a(r1)     // Catch: java.lang.Throwable -> Lb0
            r1 = r6
            com.heytap.msp.mobad.api.params.SplashAdParams r1 = r1.mSplashAdParams     // Catch: java.lang.Throwable -> Lb0
            boolean r1 = r1.showPreLoadPage     // Catch: java.lang.Throwable -> Lb0
            com.opos.mobad.ad.e.f$a r0 = r0.a(r1)     // Catch: java.lang.Throwable -> Lb0
            r1 = r6
            com.heytap.msp.mobad.api.params.SplashAdParams r1 = r1.mSplashAdParams     // Catch: java.lang.Throwable -> Lb0
            boolean r1 = r1.isUseSurfaceView     // Catch: java.lang.Throwable -> Lb0
            com.opos.mobad.ad.e.f$a r0 = r0.b(r1)     // Catch: java.lang.Throwable -> Lb0
            r1 = r6
            com.heytap.msp.mobad.api.params.SplashAdParams r1 = r1.mSplashAdParams     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r1 = r1.title     // Catch: java.lang.Throwable -> Lb0
            com.opos.mobad.ad.e.f$a r0 = r0.a(r1)     // Catch: java.lang.Throwable -> Lb0
            r1 = 1
            com.opos.mobad.ad.e.f$a r0 = r0.c(r1)     // Catch: java.lang.Throwable -> Lb0
            r1 = r8
            com.opos.mobad.ad.e.f$a r0 = r0.a(r1)     // Catch: java.lang.Throwable -> Lb0
            r1 = 0
            com.opos.mobad.ad.e.f$a r0 = r0.d(r1)     // Catch: java.lang.Throwable -> Lb0
            com.opos.mobad.ad.e.f r0 = r0.a()     // Catch: java.lang.Throwable -> Lb0
            r8 = r0
            com.opos.mobad.f.e r0 = com.heytap.msp.mobad.api.a.a()     // Catch: java.lang.Throwable -> Lb0
            r1 = r6
            android.content.Context r1 = r1.mContext     // Catch: java.lang.Throwable -> Lb0
            r2 = r6
            java.lang.String r2 = r2.mPosId     // Catch: java.lang.Throwable -> Lb0
            r3 = r6
            com.opos.mobad.ad.e.c r3 = r3.mListener     // Catch: java.lang.Throwable -> Lb0
            r4 = r8
            com.opos.mobad.ad.e.a r0 = r0.a(r1, r2, r3, r4)     // Catch: java.lang.Throwable -> Lb0
            r8 = r0
            r0 = r6
            r1 = r8
            r0.mSplashAdImpl = r1     // Catch: java.lang.Throwable -> Lb0
            r0 = r6
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb0
            r0 = r8
            if (r0 != 0) goto Lb7
            goto Lb5
        Lb0:
            r8 = move-exception
            r0 = r6
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb0
            r0 = r8
            throw r0
        Lb5:
            r0 = 0
            r7 = r0
        Lb7:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.msp.mobad.api.ad.HotSplashAd.initImplIfNeed():boolean");
    }

    public void destroyAd() {
        com.opos.mobad.ad.e.a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            aVar.b();
        }
        this.mHasDestroyed = true;
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public int getECPM() {
        com.opos.mobad.ad.e.a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            return aVar.g();
        }
        return 0;
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankLoss(int i, String str, int i2) {
        com.opos.mobad.ad.e.a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            aVar.a(i, str, i2);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankWin(int i) {
        com.opos.mobad.ad.e.a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            aVar.b(i);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void setBidECPM(int i) {
        com.opos.mobad.ad.e.a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            aVar.c(i);
        }
    }

    public void showAd(Activity activity) {
        c cVar;
        String str;
        com.opos.mobad.ad.e.a aVar = this.mSplashAdImpl;
        if (aVar == null) {
            cVar = this.mListener;
            str = "inter ad create fail";
        } else if (!this.mIsReady) {
            cVar = this.mListener;
            str = "ad had not ready";
        } else if (!this.mHadShowed) {
            aVar.a(activity);
            return;
        } else {
            cVar = this.mListener;
            str = "splash had showed";
        }
        cVar.a(-1, str);
    }
}
