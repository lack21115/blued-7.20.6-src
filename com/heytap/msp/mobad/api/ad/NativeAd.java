package com.heytap.msp.mobad.api.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.heytap.msp.mobad.api.listener.INativeAdListener;
import com.heytap.msp.mobad.api.listener.INativeRewardAdListener;
import com.heytap.msp.mobad.api.params.INativeAdData;
import com.heytap.msp.mobad.api.params.INativeAdFile;
import com.heytap.msp.mobad.api.params.INativeComplianceInfo;
import com.heytap.msp.mobad.api.params.NativeAdError;
import com.heytap.msp.mobad.api.params.NativeAdParams;
import com.opos.mobad.ad.c.e;
import com.opos.mobad.ad.c.f;
import com.opos.mobad.ad.c.m;
import com.opos.mobad.ad.c.q;
import com.opos.mobad.ad.c.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/NativeAd.class */
public class NativeAd {
    public static final int REWARD_SCENE_INSTALL_COMPLETE = 1;
    public static final int REWARD_SCENE_LAUNCH_APP = 2;
    public static final int REWARD_SCENE_NO = 0;
    public static final String TAG = "NativeAd";
    private Context mContext;
    private c mListener;
    private volatile com.opos.mobad.ad.c.c mNativeAdImpl;
    private String mPosId;
    private d mRewardListener;
    private int mRewardScene;

    /* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/NativeAd$a.class */
    static class a implements INativeAdData {

        /* renamed from: a  reason: collision with root package name */
        private final com.opos.mobad.ad.c.d f8626a;
        private final INativeComplianceInfo b;

        public a(com.opos.mobad.ad.c.d dVar) {
            this.f8626a = dVar;
            this.b = dVar.l() != null ? new INativeComplianceInfo() { // from class: com.heytap.msp.mobad.api.ad.NativeAd.a.1
                @Override // com.heytap.msp.mobad.api.params.INativeComplianceInfo
                public String getAppVersion() {
                    return a.this.f8626a.l().a();
                }

                @Override // com.heytap.msp.mobad.api.params.INativeComplianceInfo
                public String getDeveloperName() {
                    return a.this.f8626a.l().b();
                }

                @Override // com.heytap.msp.mobad.api.params.INativeComplianceInfo
                public String getPermissionUrl() {
                    return a.this.f8626a.l().d();
                }

                @Override // com.heytap.msp.mobad.api.params.INativeComplianceInfo
                public String getPrivacyUrl() {
                    return a.this.f8626a.l().c();
                }
            } : null;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public String getClickBnText() {
            return this.f8626a.j();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public INativeComplianceInfo getComplianceInfo() {
            return this.b;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public int getCreativeType() {
            return this.f8626a.e();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public String getDesc() {
            return this.f8626a.b();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public String getExtra() {
            return this.f8626a.i();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public List<INativeAdFile> getIconFiles() {
            ArrayList arrayList;
            List<e> c2 = this.f8626a.c();
            if (c2 != null) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<e> it = c2.iterator();
                while (true) {
                    arrayList = arrayList2;
                    if (!it.hasNext()) {
                        break;
                    }
                    e next = it.next();
                    if (next != null) {
                        arrayList2.add(new b(next));
                    }
                }
            } else {
                arrayList = null;
            }
            return arrayList;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public List<INativeAdFile> getImgFiles() {
            ArrayList arrayList;
            List<e> d = this.f8626a.d();
            if (d != null) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<e> it = d.iterator();
                while (true) {
                    arrayList = arrayList2;
                    if (!it.hasNext()) {
                        break;
                    }
                    e next = it.next();
                    if (next != null) {
                        arrayList2.add(new b(next));
                    }
                }
            } else {
                arrayList = null;
            }
            return arrayList;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public int getInteractionType() {
            return this.f8626a.f();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public INativeAdFile getLogoFile() {
            e g = this.f8626a.g();
            if (g != null) {
                return new b(g);
            }
            return null;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public String getTitle() {
            return this.f8626a.a();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public boolean isAdValid() {
            return this.f8626a.h();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public boolean isCurrentApp(String str) {
            return this.f8626a.a(str);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public boolean launchApp() {
            return this.f8626a.k();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public void onAdClick(View view) {
            this.f8626a.b(view);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public void onAdShow(View view) {
            this.f8626a.a(view);
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/NativeAd$b.class */
    static class b implements INativeAdFile {

        /* renamed from: a  reason: collision with root package name */
        private final e f8628a;

        public b(e eVar) {
            this.f8628a = eVar;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdFile
        public String getMd5() {
            return this.f8628a.b();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdFile
        public String getUrl() {
            return this.f8628a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/NativeAd$c.class */
    public static class c implements f {

        /* renamed from: a  reason: collision with root package name */
        private final INativeAdListener f8629a;

        public c(INativeAdListener iNativeAdListener) {
            this.f8629a = iNativeAdListener;
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(q qVar) {
            if (this.f8629a == null) {
                return;
            }
            NativeAdError nativeAdError = null;
            if (qVar != null) {
                nativeAdError = new NativeAdError(qVar.f11985a, qVar.b);
            }
            this.f8629a.onAdFailed(nativeAdError);
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(q qVar, com.opos.mobad.ad.c.d dVar) {
            if (this.f8629a == null) {
                return;
            }
            a aVar = null;
            if (dVar != null) {
                aVar = new a(dVar);
            }
            INativeAdListener iNativeAdListener = this.f8629a;
            if (iNativeAdListener != null) {
                iNativeAdListener.onAdError(new NativeAdError(qVar.f11985a, qVar.b), aVar);
            }
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(List<com.opos.mobad.ad.c.d> list) {
            if (this.f8629a == null) {
                return;
            }
            ArrayList arrayList = null;
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<com.opos.mobad.ad.c.d> it = list.iterator();
                while (true) {
                    arrayList = arrayList2;
                    if (!it.hasNext()) {
                        break;
                    }
                    com.opos.mobad.ad.c.d next = it.next();
                    if (next != null) {
                        arrayList2.add(new a(next));
                    }
                }
            }
            this.f8629a.onAdSuccess(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/NativeAd$d.class */
    public static class d implements m {

        /* renamed from: a  reason: collision with root package name */
        public INativeRewardAdListener f8630a;

        public d(INativeRewardAdListener iNativeRewardAdListener) {
            this.f8630a = iNativeRewardAdListener;
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(q qVar) {
            if (this.f8630a == null) {
                return;
            }
            NativeAdError nativeAdError = null;
            if (qVar != null) {
                nativeAdError = new NativeAdError(qVar.f11985a, qVar.b);
            }
            this.f8630a.onAdFailed(nativeAdError);
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(q qVar, com.opos.mobad.ad.c.d dVar) {
            if (this.f8630a == null) {
                return;
            }
            a aVar = null;
            if (dVar != null) {
                aVar = new a(dVar);
            }
            INativeRewardAdListener iNativeRewardAdListener = this.f8630a;
            if (iNativeRewardAdListener != null) {
                iNativeRewardAdListener.onAdError(new NativeAdError(qVar.f11985a, qVar.b), aVar);
            }
        }

        @Override // com.opos.mobad.ad.f
        public void a(String str) {
            INativeRewardAdListener iNativeRewardAdListener = this.f8630a;
            if (iNativeRewardAdListener != null) {
                iNativeRewardAdListener.onInstallCompleted(str);
            }
        }

        @Override // com.opos.mobad.ad.c.f
        public void a(List<com.opos.mobad.ad.c.d> list) {
            if (this.f8630a == null) {
                return;
            }
            ArrayList arrayList = null;
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<com.opos.mobad.ad.c.d> it = list.iterator();
                while (true) {
                    arrayList = arrayList2;
                    if (!it.hasNext()) {
                        break;
                    }
                    com.opos.mobad.ad.c.d next = it.next();
                    if (next != null) {
                        arrayList2.add(new a(next));
                    }
                }
            }
            this.f8630a.onAdSuccess(arrayList);
        }

        @Override // com.opos.mobad.ad.h
        public void a(Object... objArr) {
            INativeRewardAdListener iNativeRewardAdListener = this.f8630a;
            if (iNativeRewardAdListener != null) {
                iNativeRewardAdListener.onReward(objArr);
            }
        }

        @Override // com.opos.mobad.ad.c.m
        public void b(Object... objArr) {
            INativeRewardAdListener iNativeRewardAdListener = this.f8630a;
            if (iNativeRewardAdListener != null) {
                iNativeRewardAdListener.onRewardFail(objArr);
            }
        }
    }

    public NativeAd(Context context, String str, int i, INativeRewardAdListener iNativeRewardAdListener) {
        if (context == null || TextUtils.isEmpty(str) || iNativeRewardAdListener == null) {
            Log.e(TAG, "NativeAd Constructor param context and posId and iNativeRewardAdListener can't be null.");
            return;
        }
        this.mContext = context;
        this.mPosId = str;
        this.mRewardListener = new d(iNativeRewardAdListener);
        this.mRewardScene = i;
        initImplIfNeed();
    }

    public NativeAd(Context context, String str, INativeAdListener iNativeAdListener) {
        if (context == null || TextUtils.isEmpty(str) || iNativeAdListener == null) {
            Log.e(TAG, "NativeAd Constructor param context and posId and iNativeAdListener can't be null.");
            return;
        }
        this.mContext = context;
        this.mPosId = str;
        this.mListener = new c(iNativeAdListener);
        initImplIfNeed();
    }

    private boolean initImplIfNeed() {
        if (this.mNativeAdImpl != null) {
            return true;
        }
        if (this.mContext == null || TextUtils.isEmpty(this.mPosId)) {
            return false;
        }
        synchronized (this) {
            if (this.mNativeAdImpl != null) {
                return true;
            }
            this.mNativeAdImpl = this.mRewardScene > 0 ? com.heytap.msp.mobad.api.a.a().a(this.mContext.getApplicationContext(), this.mPosId, this.mRewardScene, this.mRewardListener) : com.heytap.msp.mobad.api.a.a().a(this.mContext.getApplicationContext(), this.mPosId, this.mListener);
            return this.mNativeAdImpl != null;
        }
    }

    public void destroyAd() {
        if (this.mNativeAdImpl != null) {
            this.mNativeAdImpl.a();
        }
        this.mContext = null;
        this.mPosId = null;
    }

    public void loadAd() {
        loadAd(null);
    }

    public void loadAd(NativeAdParams nativeAdParams) {
        if (initImplIfNeed()) {
            r rVar = null;
            if (nativeAdParams != null) {
                r.a aVar = new r.a();
                aVar.a(nativeAdParams.fetchTimeout);
                rVar = aVar.a();
            }
            this.mNativeAdImpl.a(rVar);
            return;
        }
        c cVar = this.mListener;
        if (cVar != null) {
            cVar.a(new q(-1, "inter ad create fail"));
            return;
        }
        d dVar = this.mRewardListener;
        if (dVar != null) {
            dVar.a(new q(-1, "inter ad create fail"));
        }
    }
}
