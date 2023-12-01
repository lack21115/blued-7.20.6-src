package com.heytap.msp.mobad.api.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.heytap.msp.mobad.api.listener.INativeTempletAdListener;
import com.heytap.msp.mobad.api.params.INativeTempletAdView;
import com.heytap.msp.mobad.api.params.NativeAdError;
import com.heytap.msp.mobad.api.params.NativeAdParams;
import com.heytap.msp.mobad.api.params.NativeAdSize;
import com.opos.mobad.ad.c.n;
import com.opos.mobad.ad.c.o;
import com.opos.mobad.ad.c.p;
import com.opos.mobad.ad.c.q;
import com.opos.mobad.ad.c.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/NativeTempletAd.class */
public class NativeTempletAd {
    private static final String TAG = "NativeTempletAd";
    private Context mContext;
    private a mListener;
    private NativeAdSize mNativeAdSize;
    private volatile n mNativeTempletAdImpl;
    private String mPosId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/NativeTempletAd$a.class */
    public static class a implements o {
        private final INativeTempletAdListener b;

        /* renamed from: com.heytap.msp.mobad.api.ad.NativeTempletAd$a$a  reason: collision with other inner class name */
        /* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/NativeTempletAd$a$a.class */
        static class C0383a implements INativeTempletAdView {

            /* renamed from: a  reason: collision with root package name */
            private final p f22247a;

            public C0383a(p pVar) {
                this.f22247a = pVar;
            }

            @Override // com.heytap.msp.mobad.api.params.INativeTempletAdView
            public void destroy() {
                this.f22247a.c();
            }

            @Override // com.heytap.msp.mobad.api.params.INativeTempletAdView
            public View getAdView() {
                return this.f22247a.a();
            }

            @Override // com.heytap.msp.mobad.api.ad.IBidding
            public int getECPM() {
                return this.f22247a.g();
            }

            @Override // com.heytap.msp.mobad.api.ad.IBidding
            public void notifyRankLoss(int i, String str, int i2) {
                this.f22247a.a(i, str, i2);
            }

            @Override // com.heytap.msp.mobad.api.ad.IBidding
            public void notifyRankWin(int i) {
                this.f22247a.b(i);
            }

            @Override // com.heytap.msp.mobad.api.params.INativeTempletAdView
            public void render() {
                this.f22247a.b();
            }

            @Override // com.heytap.msp.mobad.api.ad.IBidding
            public void setBidECPM(int i) {
                this.f22247a.c(i);
            }
        }

        public a(INativeTempletAdListener iNativeTempletAdListener) {
            this.b = iNativeTempletAdListener;
        }

        @Override // com.opos.mobad.ad.c.a
        public void a(int i, String str) {
            INativeTempletAdListener iNativeTempletAdListener = this.b;
            if (iNativeTempletAdListener == null) {
                return;
            }
            iNativeTempletAdListener.onAdFailed(new NativeAdError(i, str));
        }

        @Override // com.opos.mobad.ad.c.o
        public void a(p pVar) {
            if (this.b == null) {
                return;
            }
            INativeTempletAdView iNativeTempletAdView = null;
            if (pVar != null) {
                iNativeTempletAdView = (INativeTempletAdView) pVar.d();
            }
            this.b.onAdClick(iNativeTempletAdView);
        }

        @Override // com.opos.mobad.ad.c.o
        public void a(q qVar, p pVar) {
            if (this.b == null) {
                return;
            }
            NativeAdError nativeAdError = null;
            INativeTempletAdView iNativeTempletAdView = pVar != null ? (INativeTempletAdView) pVar.d() : null;
            if (qVar != null) {
                nativeAdError = new NativeAdError(qVar.f25673a, qVar.b);
            }
            this.b.onRenderFailed(nativeAdError, iNativeTempletAdView);
        }

        @Override // com.opos.mobad.ad.c.a
        public void a(List<p> list) {
            if (this.b == null) {
                return;
            }
            ArrayList arrayList = null;
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<p> it = list.iterator();
                while (true) {
                    arrayList = arrayList2;
                    if (!it.hasNext()) {
                        break;
                    }
                    p next = it.next();
                    if (next != null) {
                        C0383a c0383a = new C0383a(next);
                        next.a(c0383a);
                        arrayList2.add(c0383a);
                    }
                }
            }
            this.b.onAdSuccess(arrayList);
        }

        @Override // com.opos.mobad.ad.c.o
        public void b(p pVar) {
            if (this.b == null) {
                return;
            }
            INativeTempletAdView iNativeTempletAdView = null;
            if (pVar != null) {
                iNativeTempletAdView = (INativeTempletAdView) pVar.d();
            }
            this.b.onAdShow(iNativeTempletAdView);
        }

        @Override // com.opos.mobad.ad.c.o
        public void c(p pVar) {
            if (this.b == null) {
                return;
            }
            INativeTempletAdView iNativeTempletAdView = null;
            if (pVar != null) {
                iNativeTempletAdView = (INativeTempletAdView) pVar.d();
            }
            this.b.onAdClose(iNativeTempletAdView);
        }

        @Override // com.opos.mobad.ad.c.o
        public void d(p pVar) {
            if (this.b == null) {
                return;
            }
            INativeTempletAdView iNativeTempletAdView = null;
            if (pVar != null) {
                iNativeTempletAdView = (INativeTempletAdView) pVar.d();
            }
            this.b.onRenderSuccess(iNativeTempletAdView);
        }
    }

    public NativeTempletAd(Context context, String str, NativeAdSize nativeAdSize, INativeTempletAdListener iNativeTempletAdListener) {
        if (context == null || TextUtils.isEmpty(str) || iNativeTempletAdListener == null) {
            Log.e(TAG, "NativeTempletAd Constructor param context and posId and iNativeTempletAdListener can't be null.");
            return;
        }
        this.mContext = context;
        this.mPosId = str;
        this.mNativeAdSize = nativeAdSize;
        this.mListener = new a(iNativeTempletAdListener);
        initImplIfNeed();
    }

    private boolean initImplIfNeed() {
        int i;
        int i2;
        if (this.mNativeTempletAdImpl != null) {
            return true;
        }
        if (this.mContext == null || TextUtils.isEmpty(this.mPosId)) {
            return false;
        }
        synchronized (this) {
            if (this.mNativeTempletAdImpl != null) {
                return true;
            }
            if (this.mNativeAdSize != null) {
                i = this.mNativeAdSize.widthInDp;
                i2 = this.mNativeAdSize.heightInDp;
            } else {
                i = 0;
                i2 = 0;
            }
            this.mNativeTempletAdImpl = com.heytap.msp.mobad.api.a.a().a(this.mContext.getApplicationContext(), this.mPosId, new s.a().a(i).b(i2).a(), this.mListener);
            return this.mNativeTempletAdImpl != null;
        }
    }

    public void destroyAd() {
        if (this.mNativeTempletAdImpl != null) {
            this.mNativeTempletAdImpl.b();
        }
        this.mContext = null;
        this.mPosId = null;
    }

    public void loadAd() {
        loadAd(null);
    }

    public void loadAd(NativeAdParams nativeAdParams) {
        if (initImplIfNeed()) {
            if (nativeAdParams != null) {
                this.mNativeTempletAdImpl.a((int) nativeAdParams.fetchTimeout);
                return;
            } else {
                this.mNativeTempletAdImpl.a();
                return;
            }
        }
        a aVar = this.mListener;
        if (aVar != null) {
            aVar.a(-1, "inter ad create fail");
        }
    }
}
