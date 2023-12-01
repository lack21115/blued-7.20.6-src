package com.kwad.components.ad.interstitial.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.widget.KSFrameLayout;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/c/c.class */
public final class c extends com.kwad.sdk.mvp.a {
    public KsAdVideoPlayConfig dZ;
    public com.kwad.sdk.core.video.videoview.a eN;
    public com.kwad.components.core.webview.a.d.e gG;
    public com.kwad.components.ad.interstitial.d.b hL;
    public KsInterstitialAd.AdInteractionListener hN;
    public com.kwad.components.ad.interstitial.d hU;
    public KSFrameLayout jC;
    public d jD;
    public boolean jH;
    public com.kwad.components.ad.interstitial.e.f ju;
    public boolean jw;
    public boolean jx;
    public boolean jy;
    public a jz;
    public com.kwad.components.core.d.b.c mApkDownloadHelper;
    public List<a> jA = new CopyOnWriteArrayList();
    public List<h> jB = new CopyOnWriteArrayList();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    public volatile boolean jG = false;
    public int jI = -1;
    public List<a.c> jF = new CopyOnWriteArrayList();
    private List<e> jv = new CopyOnWriteArrayList();
    public List<InterfaceC0314c> jE = new ArrayList();

    /* renamed from: com.kwad.components.ad.interstitial.c.c$4  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/c/c$4.class */
    final class AnonymousClass4 implements ImageLoadingListener {
        final /* synthetic */ View fn;
        final /* synthetic */ Context jN;

        AnonymousClass4(Context context, View view) {
            this.jN = context;
            this.fn = view;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return false;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, final DecodedResult decodedResult) {
            com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.c.4.1
                @Override // java.lang.Runnable
                public final void run() {
                    Bitmap bitmap = decodedResult.mBitmap;
                    com.kwad.sdk.core.d.b.d("InterstitialCallerContext", "onLoadingComplete before blur");
                    Bitmap stackBlur = BlurUtils.stackBlur(bitmap, 50, false);
                    com.kwad.sdk.core.d.b.d("InterstitialCallerContext", "onLoadingComplete after blur");
                    float dimension = AnonymousClass4.this.jN.getResources().getDimension(R.dimen.ksad_interstitial_icon_radius);
                    final RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(AnonymousClass4.this.jN.getResources(), stackBlur);
                    create.setCornerRadius(dimension);
                    AnonymousClass4.this.fn.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.c.4.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass4.this.fn.setBackground(create);
                        }
                    });
                }
            });
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/c/c$a.class */
    public interface a {
        void cr();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/c/c$b.class */
    public static final class b {
        private final Context context;
        private int jS;
        private boolean jT;
        private int jU;
        private boolean jV;
        private ac.a jW;
        public double jX;
        public boolean jY;

        public b(Context context) {
            this.context = context;
        }

        public final b C(int i) {
            this.jS = i;
            return this;
        }

        public final b D(int i) {
            this.jU = i;
            return this;
        }

        public final b a(ac.a aVar) {
            this.jW = aVar;
            return this;
        }

        public final b c(double d) {
            this.jX = d;
            return this;
        }

        public final int db() {
            return this.jS;
        }

        public final boolean dc() {
            return this.jT;
        }

        public final boolean dd() {
            return this.jV;
        }

        public final int de() {
            return this.jU;
        }

        public final double df() {
            return this.jX;
        }

        public final Context getContext() {
            return this.context;
        }

        public final ac.a getTouchCoords() {
            return this.jW;
        }

        public final b k(boolean z) {
            this.jT = z;
            return this;
        }

        public final b l(boolean z) {
            this.jV = true;
            return this;
        }

        public final b m(boolean z) {
            this.jY = true;
            return this;
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.c$c  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/c/c$c.class */
    public interface InterfaceC0314c {
        void dg();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/c/c$d.class */
    public interface d {
        void dh();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/c/c$e.class */
    interface e {
        void onError();
    }

    private static int a(long j, AdTemplate adTemplate) {
        int i = -1;
        if (j == -1) {
            return -1;
        }
        float G = ((float) com.kwad.sdk.core.response.a.a.G(com.kwad.sdk.core.response.a.d.cb(adTemplate))) / 1000.0f;
        if (G != 0.0f) {
            i = Math.round((((float) j) / G) * 100.0f);
        }
        return i;
    }

    private static long a(com.kwad.sdk.core.video.videoview.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        return aVar.getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, Context context) {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, new com.kwad.sdk.core.report.i().bn(i).bj(i2).bu(ai.DL() ? 2 : 1).wY(), (JSONObject) null);
        if (!this.jy && (adInteractionListener = this.hN) != null) {
            adInteractionListener.onAdClicked();
        }
        this.jw = true;
        if (this.jy) {
            return;
        }
        cr();
    }

    public static boolean a(Context context, AdInfo adInfo) {
        return com.kwad.sdk.core.response.a.a.aO(adInfo) && !ai.DL();
    }

    private static int b(com.kwad.sdk.core.video.videoview.a aVar) {
        int i = -1;
        if (aVar == null) {
            return -1;
        }
        long duration = aVar.getDuration();
        long currentPosition = aVar.getCurrentPosition();
        if (duration != 0) {
            i = Math.round((((float) currentPosition) / ((float) duration)) * 100.0f);
        }
        return i;
    }

    public final boolean M(Context context) {
        if (this.mAdTemplate == null || context == null) {
            com.kwad.sdk.core.d.b.w("InterstitialCallerContext", "isPlayable illegal params: " + this.mAdTemplate + ", context: " + context);
            return false;
        }
        return com.kwad.sdk.core.response.a.a.bv(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
    }

    public final void a(final Context context, final int i, int i2, int i3) {
        com.kwad.components.core.d.b.a.a(new a.C0349a(context).I(this.mAdTemplate).b(this.mApkDownloadHelper).ao(false).ap(2).an(6).ao(i).a(new a.b() { // from class: com.kwad.components.ad.interstitial.c.c.3
            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                c.this.a(r5, i, context);
            }
        }));
    }

    public final void a(Context context, AdInfo adInfo, AdTemplate adTemplate, View view) {
        if (view == null) {
            return;
        }
        String url = com.kwad.sdk.core.response.a.a.bi(adInfo).getUrl();
        if (bb.isNullString(url)) {
            return;
        }
        KSImageLoader.loadImage(url, adTemplate, KSImageLoader.IMGOPTION_NORMAL, new AnonymousClass4(context, view));
    }

    public final void a(a aVar) {
        if (aVar == null) {
            return;
        }
        this.jA.add(aVar);
    }

    public final void a(final b bVar) {
        boolean z = bVar.db() == 1;
        if ((com.kwad.components.ad.interstitial.kwai.b.cK() || z || bVar.dd() || bVar.jY) && com.kwad.components.core.d.b.a.a(new a.C0349a(bVar.getContext()).I(this.mAdTemplate).b(this.mApkDownloadHelper).ao(z).an(1).ao(bVar.jU).ap(bVar.db()).a(new a.b() { // from class: com.kwad.components.ad.interstitial.c.c.1
            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                c.this.b(bVar);
            }
        })) == 0 && this.hU != null && com.kwad.components.ad.interstitial.kwai.b.cN()) {
            a(false, -1, this.eN);
            this.mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.hU.dismiss();
                }
            }, 500L);
        }
    }

    public final void a(e eVar) {
        this.jv.add(eVar);
    }

    public final void a(h hVar) {
        if (hVar == null) {
            return;
        }
        this.jB.add(hVar);
    }

    public final void a(a.c cVar) {
        if (this.jF.contains(cVar)) {
            return;
        }
        this.jF.add(cVar);
    }

    public final void a(boolean z, int i, com.kwad.sdk.core.video.videoview.a aVar) {
        long j;
        int a2;
        if (aVar != null) {
            j = a(aVar);
            a2 = b(aVar);
        } else {
            j = i;
            a2 = a(j, this.mAdTemplate);
        }
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, z ? 14 : 1, j, a2, this.hU.getTimerHelper().getTime(), null);
    }

    public final void b(Context context, AdTemplate adTemplate) {
        if (this.jG) {
            return;
        }
        com.kwad.components.core.page.a.launch(context, adTemplate);
        this.jG = true;
    }

    public final void b(a aVar) {
        if (aVar == null) {
            return;
        }
        this.jA.remove(aVar);
    }

    public final void b(b bVar) {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        com.kwad.sdk.core.report.i iVar = new com.kwad.sdk.core.report.i();
        iVar.c(bVar.getTouchCoords());
        if (!bVar.dc() && !bVar.jV) {
            bVar.D(153);
        }
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, new com.kwad.sdk.core.report.i().bj(bVar.de()).c(bVar.getTouchCoords()).bu(ai.DL() ? 2 : 1).i(bVar.df()), (JSONObject) null);
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar != null) {
            long a2 = a(aVar);
            int b2 = b(this.eN);
            iVar.S(a2);
            iVar.bo(b2);
        }
        if (!this.jy && (adInteractionListener = this.hN) != null) {
            adInteractionListener.onAdClicked();
        }
        this.jw = true;
        if (this.jy) {
            return;
        }
        cr();
    }

    public final void b(h hVar) {
        if (hVar == null) {
            return;
        }
        this.jB.remove(hVar);
    }

    public final void b(a.c cVar) {
        this.jF.remove(cVar);
    }

    public final void cV() {
        List<e> list = this.jv;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (e eVar : this.jv) {
            if (eVar != null) {
                eVar.onError();
            }
        }
    }

    public final void cW() {
        d dVar = this.jD;
        if (dVar != null) {
            dVar.dh();
        }
    }

    public final void cX() {
        for (InterfaceC0314c interfaceC0314c : this.jE) {
            interfaceC0314c.dg();
        }
    }

    public final void cY() {
        for (h hVar : this.jB) {
            hVar.dA();
        }
    }

    public final void cZ() {
        for (h hVar : this.jB) {
            hVar.dB();
        }
    }

    public final void cr() {
        for (a aVar : this.jA) {
            aVar.cr();
        }
        a aVar2 = this.jz;
        if (aVar2 != null) {
            aVar2.cr();
        }
    }

    public final boolean da() {
        com.kwad.components.ad.interstitial.e.f fVar = this.ju;
        boolean z = fVar == null || fVar.getParent() == null;
        com.kwad.sdk.core.d.b.d("InterstitialCallerContext", "isH5Interstitial :" + z);
        return z;
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.jF.clear();
        this.jv.clear();
        this.jE.clear();
        this.jB.clear();
        com.kwad.components.ad.interstitial.d.b bVar = this.hL;
        if (bVar != null) {
            bVar.rE();
        }
    }
}
