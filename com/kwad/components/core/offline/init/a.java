package com.kwad.components.core.offline.init;

import android.content.Context;
import android.os.SystemClock;
import com.kwad.components.core.n.f;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.utils.y;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/offline/init/a.class */
public abstract class a {
    private long mLoadStartTime;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, ClassLoader classLoader) {
        boolean z;
        try {
            z = b(context, classLoader);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
            z = false;
        }
        y.b(context, nJ(), nK(), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(Context context) {
        String tag = getTag();
        com.kwad.sdk.core.d.b.d(tag, "initReal disableOfflineComponents: " + com.kwad.components.core.a.Hl + " , isDevelopEnable: " + com.kwad.components.core.a.bI + " , DEBUG: false");
        if (com.kwad.components.core.a.Hl.booleanValue()) {
            a(context, getClass().getClassLoader());
        } else {
            ae(context);
        }
        com.kwad.sdk.core.d.b.d(getTag(), "initReal end");
    }

    private void ae(final Context context) {
        com.kwai.sodler.lib.c.b nI = nI();
        String tag = getTag();
        com.kwad.sdk.core.d.b.d(tag, "loadComponents pluginInfo: " + nI);
        com.kwai.sodler.kwai.a.a(context, nI, new b.a() { // from class: com.kwad.components.core.offline.init.a.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0425b, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.b.a aVar, PluginError pluginError) {
                super.a((AnonymousClass2) aVar, pluginError);
                String tag2 = a.this.getTag();
                com.kwad.sdk.core.d.b.d(tag2, "loadComponents failed error: " + pluginError);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0425b, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.b.a aVar, com.kwai.sodler.lib.kwai.a aVar2) {
                super.a((AnonymousClass2) aVar, (com.kwai.sodler.lib.b.a) aVar2);
                String tag2 = a.this.getTag();
                if (aVar2 == null) {
                    com.kwad.sdk.core.d.b.d(tag2, "loadComponents failed plugin null");
                    return;
                }
                com.kwad.sdk.core.d.b.d(tag2, "loadComponents success");
                a.this.a(context, aVar2.Jv());
            }
        });
    }

    private com.kwai.sodler.lib.c.b nI() {
        com.kwai.sodler.lib.c.b bVar = new com.kwai.sodler.lib.c.b();
        bVar.aKT = nJ();
        bVar.Ig = true;
        bVar.aKX = false;
        bVar.aKU = com.kwad.sdk.core.network.idc.a.wm().ch(nL());
        bVar.version = nK();
        bVar.aKW = nM();
        if (com.kwad.components.core.a.Ho.booleanValue()) {
            bVar.aKB = nN();
            bVar.aKC = true;
        }
        return bVar;
    }

    public final <T extends IOfflineCompo> T a(ClassLoader classLoader, String str) {
        IOfflineCompo iOfflineCompo;
        String tag = getTag();
        com.kwad.sdk.core.d.b.d(tag, "onOfflineComponentsLoaded classLoader:" + classLoader);
        try {
            iOfflineCompo = (IOfflineCompo) classLoader.loadClass(str).newInstance();
        } catch (Throwable th) {
            String tag2 = getTag();
            com.kwad.sdk.core.d.b.e(tag2, "loadClass or instance failed: " + str, th);
            iOfflineCompo = null;
        }
        String tag3 = getTag();
        com.kwad.sdk.core.d.b.d(tag3, "onOfflineComponentsLoaded components: " + iOfflineCompo);
        return iOfflineCompo;
    }

    protected abstract boolean b(Context context, ClassLoader classLoader);

    protected abstract String getTag();

    public final void init(final Context context) {
        if (!isEnabled()) {
            com.kwad.sdk.core.d.b.d(getTag(), "initReal disable");
            return;
        }
        this.mLoadStartTime = SystemClock.elapsedRealtime();
        com.kwad.components.core.offline.a.at(nG());
        final boolean h = y.h(context, nJ(), nK());
        String tag = getTag();
        com.kwad.sdk.core.d.b.d(tag, "init isSuccessLoaded: getCompoName()" + nJ() + h);
        f.a(new f.a() { // from class: com.kwad.components.core.offline.init.a.1
            @Override // com.kwad.components.core.n.f.a
            public final void a(SdkConfigData sdkConfigData) {
                String tag2 = a.this.getTag();
                com.kwad.sdk.core.d.b.d(tag2, "init onConfigRefresh  isSuccessLoaded:" + h);
                if (!a.this.nH() || h) {
                    return;
                }
                a.this.ad(context);
            }

            @Override // com.kwad.components.core.n.f.a
            public final void nP() {
                String tag2 = a.this.getTag();
                com.kwad.sdk.core.d.b.d(tag2, "init onCacheLoaded  isSuccessLoaded:" + h);
                if (!a.this.nH() || h) {
                    a.this.ad(context);
                }
            }
        });
    }

    public abstract boolean isEnabled();

    public abstract int nG();

    protected boolean nH() {
        return true;
    }

    protected abstract String nJ();

    protected abstract String nK();

    protected abstract String nL();

    protected abstract String nM();

    protected abstract String nN();

    public final void nO() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.mLoadStartTime;
        String tag = getTag();
        com.kwad.sdk.core.d.b.d(tag, "init success cost: " + elapsedRealtime);
        com.kwad.components.core.offline.a.b(nG(), elapsedRealtime);
    }
}
