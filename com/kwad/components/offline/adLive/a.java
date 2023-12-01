package com.kwad.components.offline.adLive;

import android.content.Context;
import android.util.Log;
import com.kwad.components.core.n.f;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.sdk.components.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/adLive/a.class */
public final class a extends com.kwad.components.core.offline.init.a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.offline.adLive.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/adLive/a$a.class */
    public static final class C0545a {
        private static final a Xi = new a((byte) 0);
    }

    private a() {
    }

    /* synthetic */ a(byte b) {
        this();
    }

    public static void ak(Context context) {
        rL().init(context);
    }

    private static a rL() {
        return C0545a.Xi;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean b(final Context context, ClassLoader classLoader) {
        IAdLiveOfflineCompo iAdLiveOfflineCompo = (IAdLiveOfflineCompo) a(classLoader, IAdLiveOfflineCompo.IMPL);
        if (iAdLiveOfflineCompo == null) {
            com.kwad.sdk.core.d.b.d("AdLiveInitModule", "onPluginLoaded components is null");
            return false;
        }
        String tag = getTag();
        com.kwad.sdk.core.d.b.d(tag, "offlineComponent load components classLoader: " + iAdLiveOfflineCompo.getClass().getClassLoader());
        final AdLiveCompoImpl adLiveCompoImpl = new AdLiveCompoImpl(iAdLiveOfflineCompo);
        c.a(com.kwad.components.core.offline.api.kwai.a.class, adLiveCompoImpl);
        com.kwad.sdk.core.d.b.i(getTag(), "offlineComponent load success");
        iAdLiveOfflineCompo.initReal(context, ServiceProvider.CB(), new b(), new InitCallBack() { // from class: com.kwad.components.offline.adLive.a.1
            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z) {
                a.this.nO();
            }
        });
        final SdkConfigData uu = d.uu();
        if (uu != null) {
            adLiveCompoImpl.onConfigRefresh(context, uu.toJson());
        }
        f.a(new f.a() { // from class: com.kwad.components.offline.adLive.a.2
            @Override // com.kwad.components.core.n.f.a
            public final void a(SdkConfigData sdkConfigData) {
                Log.d("AdLiveInitModule", "onConfigRefresh");
                adLiveCompoImpl.onConfigRefresh(context, sdkConfigData.toJson());
            }

            @Override // com.kwad.components.core.n.f.a
            public final void nP() {
                Log.d("AdLiveInitModule", "onCacheLoaded");
                SdkConfigData sdkConfigData = uu;
                if (sdkConfigData != null) {
                    adLiveCompoImpl.onConfigRefresh(context, sdkConfigData.toJson());
                }
            }
        });
        return true;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String getTag() {
        return "AdLiveInitModule";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean isEnabled() {
        return ((Boolean) d.b(com.kwad.sdk.core.config.c.acK)).booleanValue();
    }

    @Override // com.kwad.components.core.offline.init.a
    public final int nG() {
        return 2;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nJ() {
        return IAdLiveOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nK() {
        return "3.3.40";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nL() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/adLive/ks_so-adLiveNoSoRelease-3.3.40-c04ae50398-274.zip";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nM() {
        return "c858e8b68e0fddffe563602161bb8f8d";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nN() {
        return "ks_live_ed677b1b2";
    }
}
