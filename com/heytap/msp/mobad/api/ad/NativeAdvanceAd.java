package com.heytap.msp.mobad.api.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceLoadListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener;
import com.heytap.msp.mobad.api.params.INativeAdFile;
import com.heytap.msp.mobad.api.params.INativeAdvanceComplianceInfo;
import com.heytap.msp.mobad.api.params.INativeAdvanceData;
import com.heytap.msp.mobad.api.params.INativeComplianceListener;
import com.heytap.msp.mobad.api.params.MediaView;
import com.heytap.msp.mobad.api.params.NativeAdvanceContainer;
import com.opos.mobad.ad.c.g;
import com.opos.mobad.ad.c.h;
import com.opos.mobad.ad.c.i;
import com.opos.mobad.ad.c.j;
import com.opos.mobad.ad.c.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/NativeAdvanceAd.class */
public class NativeAdvanceAd {
    private static final String TAG = "NativeAdvanceAd";
    private Context mContext;
    private c mListener;
    private volatile g mNativeAdImpl;
    private String mPosId;

    /* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/NativeAdvanceAd$a.class */
    static class a implements INativeAdvanceData {

        /* renamed from: a  reason: collision with root package name */
        private h f22239a;
        private INativeAdvanceComplianceInfo b;

        public a(h hVar) {
            this.f22239a = hVar;
            if (hVar.n() != null) {
                this.b = new INativeAdvanceComplianceInfo() { // from class: com.heytap.msp.mobad.api.ad.NativeAdvanceAd.a.3
                    @Override // com.heytap.msp.mobad.api.params.INativeAdvanceComplianceInfo
                    public String getAppVersion() {
                        return a.this.f22239a.n().a();
                    }

                    @Override // com.heytap.msp.mobad.api.params.INativeAdvanceComplianceInfo
                    public String getDeveloperName() {
                        return a.this.f22239a.n().b();
                    }
                };
            }
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public void bindMediaView(Context context, MediaView mediaView, INativeAdvanceMediaListener iNativeAdvanceMediaListener) {
            this.f22239a.a(context, mediaView, new d(iNativeAdvanceMediaListener));
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public void bindToComplianceView(Context context, List<View> list, final INativeComplianceListener iNativeComplianceListener, List<View> list2, final INativeComplianceListener iNativeComplianceListener2) {
            this.f22239a.a(context, list, new h.a() { // from class: com.heytap.msp.mobad.api.ad.NativeAdvanceAd.a.1
                @Override // com.opos.mobad.ad.c.h.a
                public void a() {
                    INativeComplianceListener iNativeComplianceListener3 = iNativeComplianceListener;
                    if (iNativeComplianceListener3 == null) {
                        return;
                    }
                    iNativeComplianceListener3.onClose();
                }

                @Override // com.opos.mobad.ad.c.h.a
                public void a(View view) {
                    INativeComplianceListener iNativeComplianceListener3 = iNativeComplianceListener;
                    if (iNativeComplianceListener3 == null) {
                        return;
                    }
                    iNativeComplianceListener3.onClick(view);
                }
            }, list2, new h.a() { // from class: com.heytap.msp.mobad.api.ad.NativeAdvanceAd.a.2
                @Override // com.opos.mobad.ad.c.h.a
                public void a() {
                    INativeComplianceListener iNativeComplianceListener3 = iNativeComplianceListener2;
                    if (iNativeComplianceListener3 == null) {
                        return;
                    }
                    iNativeComplianceListener3.onClose();
                }

                @Override // com.opos.mobad.ad.c.h.a
                public void a(View view) {
                    INativeComplianceListener iNativeComplianceListener3 = iNativeComplianceListener2;
                    if (iNativeComplianceListener3 == null) {
                        return;
                    }
                    iNativeComplianceListener3.onClick(view);
                }
            });
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public void bindToView(Context context, NativeAdvanceContainer nativeAdvanceContainer, List<View> list) {
            this.f22239a.a(context, nativeAdvanceContainer, list);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public String getClickBnText() {
            return this.f22239a.l();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public INativeAdvanceComplianceInfo getComplianceInfo() {
            return this.b;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public int getCreativeType() {
            return this.f22239a.e();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public String getDesc() {
            return this.f22239a.b();
        }

        @Override // com.heytap.msp.mobad.api.ad.IBidding
        public int getECPM() {
            return this.f22239a.g();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public String getExtra() {
            return this.f22239a.k();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public List<INativeAdFile> getIconFiles() {
            ArrayList arrayList;
            List<com.opos.mobad.ad.c.e> c2 = this.f22239a.c();
            if (c2 != null) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<com.opos.mobad.ad.c.e> it = c2.iterator();
                while (true) {
                    arrayList = arrayList2;
                    if (!it.hasNext()) {
                        break;
                    }
                    com.opos.mobad.ad.c.e next = it.next();
                    if (next != null) {
                        arrayList2.add(new e(next));
                    }
                }
            } else {
                arrayList = null;
            }
            return arrayList;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public List<INativeAdFile> getImgFiles() {
            ArrayList arrayList;
            List<com.opos.mobad.ad.c.e> d = this.f22239a.d();
            if (d != null) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<com.opos.mobad.ad.c.e> it = d.iterator();
                while (true) {
                    arrayList = arrayList2;
                    if (!it.hasNext()) {
                        break;
                    }
                    com.opos.mobad.ad.c.e next = it.next();
                    if (next != null) {
                        arrayList2.add(new e(next));
                    }
                }
            } else {
                arrayList = null;
            }
            return arrayList;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public INativeAdFile getLogoFile() {
            com.opos.mobad.ad.c.e i = this.f22239a.i();
            if (i == null) {
                return null;
            }
            return new e(i);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public String getTitle() {
            return this.f22239a.a();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public int getVideoDuration() {
            return this.f22239a.h();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public boolean isAdValid() {
            return this.f22239a.j();
        }

        @Override // com.heytap.msp.mobad.api.ad.IBidding
        public void notifyRankLoss(int i, String str, int i2) {
            this.f22239a.a(i, str, i2);
        }

        @Override // com.heytap.msp.mobad.api.ad.IBidding
        public void notifyRankWin(int i) {
            this.f22239a.b(i);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public void release() {
            this.f22239a.m();
        }

        @Override // com.heytap.msp.mobad.api.ad.IBidding
        public void setBidECPM(int i) {
            this.f22239a.c(i);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public void setInteractListener(INativeAdvanceInteractListener iNativeAdvanceInteractListener) {
            this.f22239a.a(new b(iNativeAdvanceInteractListener));
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/NativeAdvanceAd$b.class */
    static class b implements i {

        /* renamed from: a  reason: collision with root package name */
        private INativeAdvanceInteractListener f22243a;

        public b(INativeAdvanceInteractListener iNativeAdvanceInteractListener) {
            this.f22243a = iNativeAdvanceInteractListener;
        }

        @Override // com.opos.mobad.ad.c.i
        public void a() {
            INativeAdvanceInteractListener iNativeAdvanceInteractListener = this.f22243a;
            if (iNativeAdvanceInteractListener != null) {
                iNativeAdvanceInteractListener.onClick();
            }
        }

        @Override // com.opos.mobad.ad.c.i
        public void a(int i, String str) {
            INativeAdvanceInteractListener iNativeAdvanceInteractListener = this.f22243a;
            if (iNativeAdvanceInteractListener != null) {
                iNativeAdvanceInteractListener.onError(i, str);
            }
        }

        @Override // com.opos.mobad.ad.c.i
        public void b() {
            INativeAdvanceInteractListener iNativeAdvanceInteractListener = this.f22243a;
            if (iNativeAdvanceInteractListener != null) {
                iNativeAdvanceInteractListener.onShow();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/NativeAdvanceAd$c.class */
    public static class c implements j {

        /* renamed from: a  reason: collision with root package name */
        private INativeAdvanceLoadListener f22244a;

        public c(INativeAdvanceLoadListener iNativeAdvanceLoadListener) {
            this.f22244a = iNativeAdvanceLoadListener;
        }

        @Override // com.opos.mobad.ad.c.a
        public void a(int i, String str) {
            INativeAdvanceLoadListener iNativeAdvanceLoadListener = this.f22244a;
            if (iNativeAdvanceLoadListener != null) {
                iNativeAdvanceLoadListener.onAdFailed(i, str);
            }
        }

        @Override // com.opos.mobad.ad.c.a
        public void a(List<h> list) {
            if (this.f22244a != null) {
                ArrayList arrayList = null;
                if (list != null) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<h> it = list.iterator();
                    while (true) {
                        arrayList = arrayList2;
                        if (!it.hasNext()) {
                            break;
                        }
                        arrayList2.add(new a(it.next()));
                    }
                }
                this.f22244a.onAdSuccess(arrayList);
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/NativeAdvanceAd$d.class */
    static class d implements k {

        /* renamed from: a  reason: collision with root package name */
        private INativeAdvanceMediaListener f22245a;

        public d(INativeAdvanceMediaListener iNativeAdvanceMediaListener) {
            this.f22245a = iNativeAdvanceMediaListener;
        }

        @Override // com.opos.mobad.ad.c.k
        public void a() {
            INativeAdvanceMediaListener iNativeAdvanceMediaListener = this.f22245a;
            if (iNativeAdvanceMediaListener != null) {
                iNativeAdvanceMediaListener.onVideoPlayStart();
            }
        }

        @Override // com.opos.mobad.ad.c.k
        public void a(int i, String str) {
            INativeAdvanceMediaListener iNativeAdvanceMediaListener = this.f22245a;
            if (iNativeAdvanceMediaListener != null) {
                iNativeAdvanceMediaListener.onVideoPlayError(i, str);
            }
        }

        @Override // com.opos.mobad.ad.c.k
        public void b() {
            INativeAdvanceMediaListener iNativeAdvanceMediaListener = this.f22245a;
            if (iNativeAdvanceMediaListener != null) {
                iNativeAdvanceMediaListener.onVideoPlayComplete();
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/ad/NativeAdvanceAd$e.class */
    static class e implements INativeAdFile {

        /* renamed from: a  reason: collision with root package name */
        private com.opos.mobad.ad.c.e f22246a;

        public e(com.opos.mobad.ad.c.e eVar) {
            this.f22246a = eVar;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdFile
        public String getMd5() {
            return this.f22246a.a();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdFile
        public String getUrl() {
            return this.f22246a.a();
        }
    }

    public NativeAdvanceAd(Context context, String str, INativeAdvanceLoadListener iNativeAdvanceLoadListener) {
        if (context == null || TextUtils.isEmpty(str) || iNativeAdvanceLoadListener == null) {
            Log.e(TAG, "NativeAd Constructor param context and posId and iNativeAdListener can't be null.");
            return;
        }
        this.mContext = context;
        this.mPosId = str;
        this.mListener = new c(iNativeAdvanceLoadListener);
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
            if (this.mNativeAdImpl == null) {
                this.mNativeAdImpl = com.heytap.msp.mobad.api.a.a().a(this.mContext.getApplicationContext(), this.mPosId, this.mListener);
                if (this.mNativeAdImpl == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void destroyAd() {
        if (this.mNativeAdImpl != null) {
            this.mNativeAdImpl.b();
        }
        this.mContext = null;
        this.mPosId = null;
    }

    public void loadAd() {
        if (initImplIfNeed()) {
            this.mNativeAdImpl.a();
            return;
        }
        c cVar = this.mListener;
        if (cVar != null) {
            cVar.a(-1, "inter ad create fail");
        }
    }
}
