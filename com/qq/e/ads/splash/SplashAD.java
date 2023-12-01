package com.qq.e.ads.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/splash/SplashAD.class */
public final class SplashAD extends LiteAbstractAD<NSPVI> implements IReward {
    private volatile ViewGroup b;

    /* renamed from: c  reason: collision with root package name */
    private volatile SplashADListener f27898c;
    private volatile ADRewardListener d;
    private volatile LoadAdParams e;
    private volatile boolean f;
    private volatile boolean g;
    private volatile boolean h;
    private volatile int i;
    private volatile byte[] j;
    private volatile ServerSideVerificationOptions k;
    private int l;

    /* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/splash/SplashAD$ADListenerAdapter.class */
    class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            String str;
            if (SplashAD.this.f27898c == null) {
                GDTLogger.d("SplashADListener == null");
                return;
            }
            int type = aDEvent.getType();
            switch (type) {
                case 100:
                    Long l = (Long) aDEvent.getParam(Long.class);
                    if (l != null) {
                        SplashAD.this.f27898c.onADLoaded(l.longValue());
                        return;
                    }
                    return;
                case 101:
                    Integer num = (Integer) aDEvent.getParam(Integer.class);
                    if (num != null) {
                        SplashAD.this.f27898c.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                        return;
                    }
                    return;
                case 102:
                    SplashAD.this.f27898c.onADPresent();
                    return;
                case 103:
                    SplashAD.this.f27898c.onADExposure();
                    return;
                case 104:
                    if (SplashAD.this.d == null || (str = (String) aDEvent.getParam(String.class)) == null) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("transId", str);
                    SplashAD.this.d.onReward(hashMap);
                    return;
                case 105:
                    SplashAD.this.f27898c.onADClicked();
                    return;
                case 106:
                    SplashAD.this.f27898c.onADDismissed();
                    return;
                default:
                    switch (type) {
                        case 112:
                            Long l2 = (Long) aDEvent.getParam(Long.class);
                            if (l2 != null) {
                                SplashAD.this.f27898c.onADTick(l2.longValue());
                                return;
                            }
                            return;
                        case 113:
                            if (SplashAD.this.f27898c instanceof SplashADZoomOutListener) {
                                ((SplashADZoomOutListener) SplashAD.this.f27898c).onZoomOut();
                                return;
                            }
                            return;
                        case 114:
                            if (SplashAD.this.f27898c instanceof SplashADZoomOutListener) {
                                ((SplashADZoomOutListener) SplashAD.this.f27898c).onZoomOutPlayFinish();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
            }
        }
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener) {
        this(context, str, splashADListener, 0);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i) {
        this.f = false;
        this.f27898c = splashADListener;
        this.l = i;
        a(context, str);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i, String str2) {
        this.f = false;
        this.f27898c = splashADListener;
        this.l = i;
        a(context, str, str2);
    }

    private void a(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            GDTLogger.e("传入参数有误：传入container参数为空");
            a(4001);
            return;
        }
        T t = this.f27851a;
        if (t == 0) {
            this.h = z;
            this.b = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t;
        if (z) {
            nspvi.fetchFullScreenAndShowIn(viewGroup);
        } else {
            nspvi.fetchAndShowIn(viewGroup);
        }
    }

    private void a(boolean z) {
        if (a()) {
            if (!b()) {
                this.h = z;
                this.g = true;
                return;
            }
            T t = this.f27851a;
            if (t == 0) {
                a("fetchAdInner");
                return;
            }
            NSPVI nspvi = (NSPVI) t;
            if (z) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
        }
    }

    private void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            GDTLogger.e("传入参数错误，container参数为空");
            a(4001);
            return;
        }
        T t = this.f27851a;
        if (t == 0) {
            this.b = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t;
        if (z) {
            nspvi.showFullScreenAd(viewGroup);
        } else {
            nspvi.showAd(viewGroup);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeSplashAdView(context, str, str2, str3);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        NSPVI nspvi = (NSPVI) obj;
        if (this.e != null) {
            nspvi.setLoadAdParams(this.e);
        }
        if (this.i != 0) {
            nspvi.setDeveloperLogo(this.i);
        }
        if (this.j != null) {
            nspvi.setDeveloperLogo(this.j);
        }
        nspvi.setFetchDelay(this.l);
        nspvi.setAdListener(new ADListenerAdapter());
        nspvi.setServerSideVerificationOptions(this.k);
        if ((this.f27898c instanceof SplashADZoomOutListener) && ((SplashADZoomOutListener) this.f27898c).isSupportZoomOut()) {
            nspvi.setSupportZoomOut(true);
        }
        if (this.b != null) {
            if (this.h) {
                fetchFullScreenAndShowIn(this.b);
            } else {
                fetchAndShowIn(this.b);
            }
        }
        if (this.f) {
            nspvi.preload();
            this.f = false;
        }
        if (this.g) {
            if (this.h) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
            this.g = false;
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        if (this.f27898c != null) {
            this.f27898c.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }

    public void fetchAdOnly() {
        a(false);
    }

    public void fetchAndShowIn(ViewGroup viewGroup) {
        a(viewGroup, false);
    }

    public void fetchFullScreenAdOnly() {
        a(true);
    }

    public void fetchFullScreenAndShowIn(ViewGroup viewGroup) {
        a(viewGroup, true);
    }

    public String getAdNetWorkName() {
        T t = this.f27851a;
        if (t != 0) {
            return ((NSPVI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public Bitmap getZoomOutBitmap() {
        T t = this.f27851a;
        if (t != 0) {
            return ((NSPVI) t).getZoomOutBitmap();
        }
        a("getZoomOutBitmap");
        return null;
    }

    public void preLoad() {
        if (a()) {
            if (!b()) {
                this.f = true;
                return;
            }
            T t = this.f27851a;
            if (t != 0) {
                ((NSPVI) t).preload();
            } else {
                a("preLoad");
            }
        }
    }

    @Deprecated
    public void setAdLogoMargin(int i, int i2) {
    }

    public void setDeveloperLogo(int i) {
        T t = this.f27851a;
        if (t == 0) {
            this.i = i;
        } else {
            ((NSPVI) t).setDeveloperLogo(i);
        }
    }

    public void setDeveloperLogo(byte[] bArr) {
        T t = this.f27851a;
        if (t == 0) {
            this.j = bArr;
        } else {
            ((NSPVI) t).setDeveloperLogo(bArr);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        T t = this.f27851a;
        if (t != 0) {
            ((NSPVI) t).setLoadAdParams(loadAdParams);
        } else {
            this.e = loadAdParams;
        }
    }

    @Deprecated
    public void setPreloadView(View view) {
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.d = aDRewardListener;
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.k = serverSideVerificationOptions;
        T t = this.f27851a;
        if (t != 0) {
            ((NSPVI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void showAd(ViewGroup viewGroup) {
        b(viewGroup, false);
    }

    public void showFullScreenAd(ViewGroup viewGroup) {
        b(viewGroup, true);
    }

    public void zoomOutAnimationFinish() {
        T t = this.f27851a;
        if (t != 0) {
            ((NSPVI) t).zoomOutAnimationFinish();
        } else {
            a("zoomOutAnimationFinish");
        }
    }
}
