package com.kwad.components.core.d.b;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.core.d.a.b;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsApkDownloadListener;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.diskcache.ApkCacheManager;
import com.kwad.sdk.core.download.f;
import com.kwad.sdk.core.report.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.v;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/d/b/c.class */
public final class c implements NetworkMonitor.a, com.kwad.sdk.core.download.d, com.kwad.sdk.core.webview.a {
    private AdTemplate IZ;
    private long Ja;
    private boolean Jb;
    private a Jc;
    private DialogInterface.OnShowListener Jd;
    private List<KsAppDownloadListener> Je;
    private boolean downloadPauseEnable;
    private AdInfo mAdInfo;
    private Handler mHandler;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private JSONObject mReportExtData;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/d/b/c$a.class */
    public interface a {
        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);
    }

    public c(AdTemplate adTemplate) {
        this(adTemplate, null, null);
    }

    public c(AdTemplate adTemplate, KsAppDownloadListener ksAppDownloadListener) {
        this(adTemplate, null, ksAppDownloadListener);
    }

    public c(AdTemplate adTemplate, KsAppDownloadListener ksAppDownloadListener, String str, String str2) {
        this(adTemplate, null, null);
        this.mAdInfo.adConversionInfo.appDownloadUrl = str;
        this.mAdInfo.adBaseInfo.appPackageName = str2;
        this.mAdInfo.downloadId = ad.eC(str);
    }

    public c(AdTemplate adTemplate, JSONObject jSONObject) {
        this(adTemplate, jSONObject, null);
    }

    public c(AdTemplate adTemplate, JSONObject jSONObject, KsAppDownloadListener ksAppDownloadListener) {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.Je = new ArrayList();
        this.IZ = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.mReportExtData = jSONObject;
        if (ksAppDownloadListener != null) {
            b(ksAppDownloadListener);
        }
        na();
        com.kwad.sdk.core.download.c.vu().a(this, this.IZ);
        com.kwad.sdk.core.download.c.vu().al(this.IZ);
        this.downloadPauseEnable = com.kwad.sdk.core.response.a.a.cg(com.kwad.sdk.core.response.a.d.cb(this.IZ));
        if (com.kwad.sdk.core.config.d.uE()) {
            NetworkMonitor.getInstance().a(KsAdSDKImpl.get().getContext(), this);
        }
        com.kwad.sdk.kwai.kwai.c.sZ().af(this.IZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(KsAppDownloadListener ksAppDownloadListener) {
        int i = this.mAdInfo.progress;
        int i2 = this.mAdInfo.status;
        if (i2 == 0) {
            ksAppDownloadListener.onIdle();
        } else if (i2 == 1) {
            ksAppDownloadListener.onProgressUpdate(0);
            if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.kwai.a) {
                ((com.kwad.sdk.core.download.kwai.a) ksAppDownloadListener).onDownloadStarted();
                return;
            }
            try {
                ksAppDownloadListener.onDownloadStarted();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            }
        } else if (i2 == 2 || i2 == 3) {
            ksAppDownloadListener.onProgressUpdate(i);
        } else if (i2 == 4) {
            if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.kwai.a) {
                ((com.kwad.sdk.core.download.kwai.a) ksAppDownloadListener).onPaused(i);
            }
            try {
                if (ksAppDownloadListener instanceof KsApkDownloadListener) {
                    ((KsApkDownloadListener) ksAppDownloadListener).onPaused(i);
                }
            } catch (Throwable th2) {
            }
        } else if (i2 == 7) {
            ksAppDownloadListener.onDownloadFailed();
        } else if (i2 == 8 || i2 == 9) {
            ksAppDownloadListener.onDownloadFinished();
        } else if (i2 != 12) {
        } else {
            ksAppDownloadListener.onInstalled();
        }
    }

    private static void e(Context context, AdTemplate adTemplate) {
        if (context == null || adTemplate == null) {
            return;
        }
        DownloadLandPageActivity.launch(context, adTemplate, false);
    }

    private int n(a.C0519a c0519a) {
        Context context = c0519a.getContext();
        String cu = com.kwad.sdk.core.response.a.a.cu(this.mAdInfo);
        if (com.kwad.sdk.utils.d.a(context, cu, this.IZ)) {
            com.kwad.sdk.core.report.a.l(this.IZ, 1);
            return 0;
        } else if (com.kwad.sdk.utils.d.f(context, cu, com.kwad.sdk.core.response.a.a.aq(this.mAdInfo))) {
            com.kwad.sdk.core.report.a.l(this.IZ, 0);
            return 0;
        } else if (nl()) {
            return 0;
        } else {
            if (!ag.isNetworkConnected(context)) {
                v.H(context, w.bO(context));
                return 0;
            } else if (c0519a.mX() && com.kwad.sdk.core.config.d.uh()) {
                return o(c0519a);
            } else {
                if (com.kwad.sdk.core.response.a.d.cr(this.IZ) && c0519a.mZ() != 2) {
                    e(c0519a.getContext(), c0519a.getAdTemplate());
                    return 0;
                } else if (c0519a.mT()) {
                    return p(c0519a);
                } else {
                    if (q(c0519a)) {
                        return 0;
                    }
                    return np();
                }
            }
        }
    }

    private void na() {
        com.kwad.sdk.core.download.c.vu();
        int bN = com.kwad.sdk.core.download.c.bN(nc());
        if (bN != 0) {
            this.mAdInfo.status = bN;
        }
        ng();
        nf();
    }

    private boolean ne() {
        boolean z = false;
        boolean z2 = false;
        if (Build.VERSION.SDK_INT < 29) {
            if (this.IZ.mIsFromContent && com.kwad.sdk.core.config.d.tV()) {
                boolean nn = nn();
                z2 = nn;
                if (nn) {
                    com.kwad.sdk.core.report.a.at(this.IZ);
                    return nn;
                }
            } else {
                z2 = false;
                if (!this.IZ.mIsFromContent) {
                    z2 = false;
                    if (com.kwad.sdk.core.config.d.us()) {
                        boolean ac = com.kwad.components.core.i.b.ac(KsAdSDKImpl.get().getContext());
                        com.kwad.sdk.core.d.b.d("ApkDownloadHelper", "handleForceOpenApp enableForceOpen: " + ac);
                        if (ac) {
                            z = nn();
                        }
                        z2 = z;
                        if (z) {
                            com.kwad.sdk.core.report.a.au(this.IZ);
                            z2 = z;
                        }
                    }
                }
            }
        }
        return z2;
    }

    private void nf() {
        this.mHandler.post(new Runnable() { // from class: com.kwad.components.core.d.b.c.3
            @Override // java.lang.Runnable
            public final void run() {
                ArrayList<KsAppDownloadListener> arrayList = new ArrayList(c.this.Je.size());
                arrayList.addAll(c.this.Je);
                for (KsAppDownloadListener ksAppDownloadListener : arrayList) {
                    if (ksAppDownloadListener != null) {
                        c.this.a(ksAppDownloadListener);
                    }
                }
            }
        });
    }

    private void ng() {
        String str = this.mAdInfo.adBaseInfo.appPackageName;
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        if (ak.ah(context, str)) {
            this.mAdInfo.status = 12;
            return;
        }
        if (this.mAdInfo.status == 12) {
            this.mAdInfo.status = 0;
            this.mAdInfo.progress = 0;
        }
        if (this.mAdInfo.status == 8 || this.mAdInfo.status == 9) {
            String str2 = this.mAdInfo.downloadFilePath;
            if (TextUtils.isEmpty(str2) || !new File(str2).exists()) {
                this.mAdInfo.status = 0;
                this.mAdInfo.progress = 0;
            }
        }
        if (this.mAdInfo.status == 0) {
            String A = com.kwad.sdk.core.download.a.A(this.mAdInfo);
            if (TextUtils.isEmpty(A) || !new File(A).exists()) {
                return;
            }
            this.mAdInfo.downloadFilePath = A;
            this.mAdInfo.status = 8;
        }
    }

    private boolean ni() {
        String str = this.mAdInfo.adConversionInfo.marketUrl;
        com.kwad.sdk.core.d.b.i("ApkDownloadHelper", "isMarKet URL Schema=" + str);
        boolean f = !TextUtils.isEmpty(str) ? com.kwad.sdk.utils.d.f(KsAdSDKImpl.get().getContext(), str, this.mAdInfo.adBaseInfo.appPackageName) : false;
        if (f) {
            com.kwad.sdk.core.report.a.l(this.IZ, 0);
        }
        return f;
    }

    private boolean nl() {
        a aVar = this.Jc;
        if (aVar != null) {
            return aVar.handleDownloadDialog(new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.d.b.c.4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    if (i == -1) {
                        switch (c.this.mAdInfo.status) {
                            case 0:
                            case 1:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                c.this.np();
                                return;
                            case 2:
                            case 3:
                            case 10:
                            default:
                                return;
                            case 8:
                            case 9:
                            case 11:
                                c.this.no();
                                return;
                            case 12:
                                c.this.nm();
                                return;
                        }
                    }
                }
            });
        }
        return false;
    }

    private boolean nn() {
        Context context = KsAdSDKImpl.get().getContext();
        if (d.b(new a.C0519a(context).I(this.IZ), 1) == 1) {
            return true;
        }
        boolean aj = ak.aj(context, com.kwad.sdk.core.response.a.a.aq(this.mAdInfo));
        if (aj) {
            com.kwad.sdk.core.report.a.as(this.IZ);
        }
        return aj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int np() {
        com.kwad.sdk.core.download.a.B(this.mAdInfo);
        return 1;
    }

    private int o(a.C0519a c0519a) {
        Context context = c0519a.getContext();
        AdTemplate adTemplate = c0519a.getAdTemplate();
        int mY = c0519a.mY();
        if (mY != 1) {
            if (mY == 2 && com.kwad.sdk.core.response.a.b.bB(adTemplate)) {
                com.kwad.components.core.d.a.b.a(context, new b.a().H(adTemplate).ao(com.kwad.sdk.core.response.a.b.bA(adTemplate)).a(this.Jd).c(this.mOnDismissListener).mI());
                return 0;
            }
            return 0;
        }
        return np();
    }

    private int p(a.C0519a c0519a) {
        Context context = c0519a.getContext();
        AdTemplate adTemplate = c0519a.getAdTemplate();
        int s = s(c0519a);
        if (s == 1) {
            if (com.kwad.sdk.core.response.a.b.bB(adTemplate)) {
                com.kwad.components.core.d.a.b.a(context, new b.a().H(adTemplate).ao(com.kwad.sdk.core.response.a.b.bA(adTemplate)).a(this.Jd).c(this.mOnDismissListener).mI());
                return 0;
            }
            return 0;
        } else if (s == 2) {
            e(c0519a.getContext(), c0519a.getAdTemplate());
            return 0;
        } else if (s == 3 || q(c0519a)) {
            return 0;
        } else {
            return np();
        }
    }

    private boolean q(a.C0519a c0519a) {
        if (c0519a.mR() || this.mAdInfo.status == 4 || !com.kwad.sdk.core.response.a.b.bE(this.IZ) || !r(c0519a)) {
            return false;
        }
        return com.kwad.components.core.d.a.b.a(c0519a.getContext(), new b.a().H(this.IZ).ao(com.kwad.sdk.core.response.a.b.bD(this.IZ)).a(this.Jd).c(this.mOnDismissListener).mI());
    }

    private static boolean r(a.C0519a c0519a) {
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(c0519a.getAdTemplate());
        if (com.kwad.sdk.core.response.a.a.bk(cb) && (DownloadLandPageActivity.showingAdWebViewLandPage || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c0519a.getAdTemplate().isWebViewDownload)) {
            return true;
        }
        return com.kwad.sdk.core.response.a.a.bl(cb) && !ag.isWifiConnected(c0519a.getContext());
    }

    public static int s(a.C0519a c0519a) {
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(c0519a.getAdTemplate());
        if (cb.downloadSafeInfo.complianceInfo != null) {
            int db = c0519a.db();
            return db != 2 ? db != 3 ? cb.downloadSafeInfo.complianceInfo.actionBarType : cb.downloadSafeInfo.complianceInfo.materialJumpType : cb.downloadSafeInfo.complianceInfo.describeBarType;
        }
        return 0;
    }

    public final void a(a aVar) {
        this.Jc = aVar;
    }

    @Override // com.kwad.sdk.core.NetworkMonitor.a
    public final void a(NetworkMonitor.NetworkState networkState) {
        if (this.mAdInfo.status == 7 && networkState == NetworkMonitor.NetworkState.NETWORK_WIFI) {
            np();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public final void a(String str, int i, int i2, int i3) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 3;
            this.mAdInfo.progress = i;
            this.mAdInfo.soFarBytes = i2;
            this.mAdInfo.totalBytes = i3;
            nf();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public final void a(String str, int i, f fVar) {
        boolean z;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.IZ);
        if (fVar.vx()) {
            com.kwad.sdk.core.report.a.aq(this.IZ);
            fVar.vw();
            z = ne();
            com.kwad.sdk.kwai.kwai.c.sZ().ai(this.IZ);
            com.kwad.sdk.kwai.kwai.c.sZ().ag(this.IZ);
            com.kwad.sdk.kwai.kwai.b.sW().ab(this.IZ);
        } else {
            z = false;
        }
        final boolean z2 = z;
        g.execute(new Runnable() { // from class: com.kwad.components.core.d.b.c.2
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
            }
        });
        com.kwad.sdk.core.a.tS().bx(cb.downloadId);
        this.mAdInfo.status = 12;
        nf();
    }

    @Override // com.kwad.sdk.core.download.d
    public final void a(String str, int i, String str2, f fVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 7;
            nf();
            if (fVar.vx()) {
                a.C0565a c0565a = new a.C0565a(i, str2);
                com.kwad.sdk.core.report.a.a(this.IZ, c0565a);
                com.kwad.components.core.m.a.pb().a(this.IZ, this.mAdInfo.adConversionInfo.appDownloadUrl, c0565a.toJson().toString());
                fVar.vw();
            }
            if (this.mAdInfo.adConversionInfo.retryH5TimeStep <= 0 || this.Jb || System.currentTimeMillis() - this.Ja >= this.mAdInfo.adConversionInfo.retryH5TimeStep || TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.aK(this.mAdInfo))) {
                return;
            }
            AdWebViewActivityProxy.launch(KsAdSDKImpl.get().getContext(), this.IZ);
            this.Jb = true;
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public final void a(String str, f fVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 1) {
                if (fVar.vx()) {
                    com.kwad.sdk.core.report.a.ap(this.IZ);
                    fVar.vw();
                }
                this.Ja = System.currentTimeMillis();
            }
            this.mAdInfo.status = 1;
            nf();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public final void a(String str, String str2, f fVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.downloadFilePath = str2;
            this.mAdInfo.progress = 100;
            if (this.mAdInfo.status != 8 && !this.IZ.mDownloadFinishReported) {
                g.execute(new Runnable() { // from class: com.kwad.components.core.d.b.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
                    }
                });
                if (fVar.vx()) {
                    com.kwad.sdk.core.report.a.e(this.IZ, this.mReportExtData);
                    fVar.vw();
                }
                com.kwad.sdk.kwai.kwai.c.sZ().ah(this.IZ);
                com.kwad.sdk.kwai.kwai.c.sZ().af(this.IZ);
                com.kwad.sdk.kwai.kwai.b.sW().aa(this.IZ);
                this.IZ.mDownloadFinishReported = true;
            }
            this.mAdInfo.status = 8;
            nf();
            ApkCacheManager.getInstance().vh();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public final void aq(String str) {
        if (this.mAdInfo.downloadId.equals(str)) {
            com.kwad.sdk.core.report.a.ar(this.IZ);
        }
    }

    public final void as(int i) {
        this.IZ.downloadSource = i;
    }

    public final void b(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.kwad.components.core.d.b.c.6
                @Override // java.lang.Runnable
                public final void run() {
                    if (c.this.Je.contains(ksAppDownloadListener)) {
                        return;
                    }
                    c.this.Je.add(0, ksAppDownloadListener);
                }
            });
        } else if (!this.Je.contains(ksAppDownloadListener)) {
            this.Je.add(0, ksAppDownloadListener);
        }
        ng();
        a(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.download.d
    public final void b(String str, f fVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 4 && fVar.vx()) {
                com.kwad.sdk.core.report.a.c(this.IZ, this.mReportExtData);
                fVar.vw();
            }
            this.mAdInfo.status = 4;
            nf();
        }
    }

    public final void c(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.Je.remove(ksAppDownloadListener);
        } else {
            this.mHandler.post(new Runnable() { // from class: com.kwad.components.core.d.b.c.7
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.Je.remove(ksAppDownloadListener);
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public final void c(String str, f fVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 2 && fVar.vx()) {
                com.kwad.sdk.core.report.a.d(this.IZ, this.mReportExtData);
                fVar.vw();
            }
            this.mAdInfo.status = 2;
            nf();
        }
    }

    public final void clear() {
        nq();
        com.kwad.sdk.core.download.c.vu().a(this);
        if (com.kwad.sdk.core.config.d.uE()) {
            NetworkMonitor.getInstance().a(this);
        }
    }

    public final void d(KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        ng();
        a(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.download.d
    public final void d(String str, f fVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 5 && fVar.vx()) {
                com.kwad.sdk.core.report.a.f(this.IZ, this.mReportExtData);
                fVar.vw();
            }
            this.mAdInfo.status = 5;
            nf();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public final void e(String str, f fVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (fVar.vx()) {
                com.kwad.sdk.core.report.a.i(this.IZ, 2);
                fVar.vw();
            }
            this.mAdInfo.status = 9;
            nf();
        }
    }

    public final int m(a.C0519a c0519a) {
        int n;
        this.Jb = false;
        ng();
        switch (this.mAdInfo.status) {
            case 0:
            case 1:
            case 5:
            case 6:
            case 7:
                n = n(c0519a);
                break;
            case 2:
            case 3:
                n = 0;
                if (c0519a.mP()) {
                    n = 0;
                    if (this.downloadPauseEnable) {
                        com.kwad.sdk.core.download.a.bM(this.mAdInfo.downloadId);
                        return 0;
                    }
                }
                break;
            case 4:
                return np();
            case 8:
            case 9:
            case 11:
                no();
                return 0;
            case 10:
            default:
                return 0;
            case 12:
                nm();
                return 0;
        }
        return n;
    }

    public final int nb() {
        ng();
        if (this.mAdInfo.status == 3) {
            return 2;
        }
        return this.mAdInfo.status;
    }

    @Override // com.kwad.sdk.core.download.d
    public final String nc() {
        return this.mAdInfo.downloadId;
    }

    @Override // com.kwad.sdk.core.download.d
    public final String nd() {
        return this.mAdInfo.adBaseInfo.appPackageName;
    }

    public final boolean nh() {
        switch (this.mAdInfo.status) {
            case 0:
            case 1:
            case 4:
            case 5:
            case 6:
            case 7:
                return ni();
            case 2:
            case 3:
            case 10:
            default:
                return false;
            case 8:
            case 9:
            case 11:
                no();
                return true;
            case 12:
                nm();
                return true;
        }
    }

    public final AdTemplate nj() {
        return this.IZ;
    }

    public final boolean nk() {
        if (this.mAdInfo.status == 0) {
            return ni();
        }
        return false;
    }

    public final void nm() {
        g.execute(new Runnable() { // from class: com.kwad.components.core.d.b.c.5
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
            }
        });
        if (ak.aj(KsAdSDKImpl.get().getContext(), com.kwad.sdk.core.response.a.a.aq(this.mAdInfo))) {
            com.kwad.sdk.core.report.a.as(this.IZ);
        }
    }

    public final void no() {
        if (ak.ak(KsAdSDKImpl.get().getContext(), this.mAdInfo.downloadFilePath)) {
            com.kwad.sdk.core.report.a.i(this.IZ, 1);
        }
    }

    @Override // com.kwad.sdk.core.webview.a
    public final void nq() {
        List<KsAppDownloadListener> list = this.Je;
        if (list != null) {
            list.clear();
        }
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public final void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.Jd = onShowListener;
    }
}
