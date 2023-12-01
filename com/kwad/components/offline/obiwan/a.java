package com.kwad.components.offline.obiwan;

import android.content.Context;
import com.kwad.components.core.n.f;
import com.kwad.components.core.offline.api.obiwan.ObiwanComponents;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/obiwan/a.class */
public final class a extends com.kwad.components.core.offline.init.a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.offline.obiwan.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/obiwan/a$a.class */
    public static final class C0546a {
        private static final a Xu = new a((byte) 0);
    }

    private a() {
    }

    /* synthetic */ a(byte b) {
        this();
    }

    public static void ak(Context context) {
        rO().init(context);
    }

    private static a rO() {
        return C0546a.Xu;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean b(Context context, ClassLoader classLoader) {
        IObiwanOfflineCompo iObiwanOfflineCompo = (IObiwanOfflineCompo) a(classLoader, IObiwanOfflineCompo.IMPL);
        if (iObiwanOfflineCompo == null) {
            return false;
        }
        final ObiwanComponentsImpl obiwanComponentsImpl = new ObiwanComponentsImpl(iObiwanOfflineCompo);
        com.kwad.sdk.components.c.a(ObiwanComponents.class, obiwanComponentsImpl);
        com.kwad.sdk.core.d.b.i(getTag(), "offlineComponent load success");
        iObiwanOfflineCompo.initReal(context, ServiceProvider.CB(), new c(), new InitCallBack() { // from class: com.kwad.components.offline.obiwan.a.1
            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z) {
                a.this.nO();
            }
        });
        com.kwad.sdk.core.d.b.a(new b(obiwanComponentsImpl.getLog()));
        f.a(new f.a() { // from class: com.kwad.components.offline.obiwan.a.2
            private void updateConfigs() {
                com.kwad.sdk.core.d.b.a(d.a(com.kwad.sdk.core.config.c.adl) ? new b(obiwanComponentsImpl.getLog()) : null);
                obiwanComponentsImpl.updateConfigs();
            }

            @Override // com.kwad.components.core.n.f.a
            public final void a(SdkConfigData sdkConfigData) {
                updateConfigs();
            }

            @Override // com.kwad.components.core.n.f.a
            public final void nP() {
                updateConfigs();
            }
        });
        return true;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String getTag() {
        return "ObiwanInitModule";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean isEnabled() {
        return ((Boolean) d.b(com.kwad.sdk.core.config.c.adl)).booleanValue();
    }

    @Override // com.kwad.components.core.offline.init.a
    public final int nG() {
        return 3;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nJ() {
        return IObiwanOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nK() {
        return "3.3.40";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nL() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/obiwan/ks_so-obiwanNoSoRelease-3.3.40-c04ae50398-273.zip";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nM() {
        return "68b663dbb3f66e09d06aa0753d724710";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nN() {
        return "ks_obiwan_773cd6541";
    }
}
