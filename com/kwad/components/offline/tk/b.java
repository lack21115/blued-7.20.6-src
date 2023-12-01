package com.kwad.components.offline.tk;

import android.content.Context;
import android.os.SystemClock;
import com.kwad.components.core.n.f;
import com.kwad.components.core.n.g;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadMsg;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.y;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/tk/b.class */
public final class b extends com.kwad.components.core.offline.init.a {
    private static long Xx;
    private final List<com.kwad.components.core.offline.api.a.a> Xw;
    private final AtomicBoolean Xy;

    /* renamed from: com.kwad.components.offline.tk.b$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/tk/b$1.class */
    final class AnonymousClass1 implements InitCallBack {
        final /* synthetic */ boolean Kd;
        final /* synthetic */ long XA;
        final /* synthetic */ long XB;
        final /* synthetic */ ITkOfflineCompo Xz;
        final /* synthetic */ Context jN;

        AnonymousClass1(ITkOfflineCompo iTkOfflineCompo, long j, long j2, boolean z, Context context) {
            this.Xz = iTkOfflineCompo;
            this.XA = j;
            this.XB = j2;
            this.Kd = z;
            this.jN = context;
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onSuccess(boolean z) {
            final TkCompoImpl tkCompoImpl = new TkCompoImpl(this.Xz);
            com.kwad.sdk.components.c.a(com.kwad.components.core.offline.api.a.c.class, tkCompoImpl);
            b.this.Xy.set(true);
            TkLoggerReporter tkLoggerReporter = TkLoggerReporter.get();
            TKDownloadMsg offlineSource = new TKDownloadMsg().setDownloadState(3).setOfflineLoadTime(this.XA).setSoLoadTime(SystemClock.elapsedRealtime() - this.XB).setOfflineSource(this.Kd ? 1 : 2);
            int i = 1;
            if (z) {
                i = 2;
            }
            tkLoggerReporter.reportTKSOLoad(ILoggerReporter.Category.APM_LOG, offlineSource.setSoSource(i).toJson());
            com.kwad.sdk.core.d.b.i(b.this.getTag(), "offlineComponent load success");
            b.this.nO();
            b.this.rR();
            f.a(new g() { // from class: com.kwad.components.offline.tk.b.1.1
                @Override // com.kwad.components.core.n.g, com.kwad.components.core.n.f.a
                public final void a(final SdkConfigData sdkConfigData) {
                    super.a(sdkConfigData);
                    com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.offline.tk.b.1.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            tkCompoImpl.onConfigRefresh(AnonymousClass1.this.jN, sdkConfigData.toJson());
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/tk/b$a.class */
    public static final class a {
        private static final b XG = new b((byte) 0);
    }

    private b() {
        this.Xw = new CopyOnWriteArrayList();
        this.Xy = new AtomicBoolean(false);
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public static void ak(Context context) {
        Xx = SystemClock.elapsedRealtime();
        rQ().init(context);
    }

    public static b rQ() {
        return a.XG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rR() {
        for (com.kwad.components.core.offline.api.a.a aVar : this.Xw) {
            aVar.onSuccess();
        }
    }

    public final void a(com.kwad.components.core.offline.api.a.a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.Xy.get()) {
            aVar.onSuccess();
        }
        this.Xw.add(aVar);
    }

    public final void b(com.kwad.components.core.offline.api.a.a aVar) {
        if (aVar == null) {
            return;
        }
        this.Xw.remove(aVar);
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean b(Context context, ClassLoader classLoader) {
        ITkOfflineCompo iTkOfflineCompo = (ITkOfflineCompo) a(classLoader, ITkOfflineCompo.IMPL);
        if (iTkOfflineCompo == null) {
            com.kwad.sdk.core.d.b.d("TkInitModule", "onPluginLoaded components is null");
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        long j = Xx;
        boolean h = y.h(context, nJ(), nK());
        String tag = getTag();
        com.kwad.sdk.core.d.b.d(tag, "offlineComponent load " + h + " components classLoader: " + iTkOfflineCompo.getClass().getClassLoader());
        iTkOfflineCompo.initReal(context, ServiceProvider.CB(), new c(), new AnonymousClass1(iTkOfflineCompo, elapsedRealtime2 - j, elapsedRealtime, h, context));
        return true;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String getTag() {
        return "TkInitModule";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean isEnabled() {
        return ((Boolean) d.b(com.kwad.sdk.core.config.c.acL)).booleanValue();
    }

    @Override // com.kwad.components.core.offline.init.a
    public final int nG() {
        return 1;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean nH() {
        return false;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nJ() {
        return ITkOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nK() {
        return "3.3.40";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nL() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/tk/ks_so-tachikomaNoSoRelease-3.3.40-c7665df844-282.zip";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nM() {
        return "4b490564376f5186e9438abf66d292da";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nN() {
        return "ks_tk_134ad9665";
    }
}
