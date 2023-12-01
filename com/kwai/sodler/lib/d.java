package com.kwai.sodler.lib;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.q;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/d.class */
public final class d implements com.kwai.sodler.lib.a.d {
    private final ConcurrentHashMap<String, com.kwai.sodler.lib.a.a> aJO = new ConcurrentHashMap<>();
    private final Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private static void a(com.kwai.sodler.lib.a.f fVar) {
        new StringBuilder("onCanceled state = ").append(fVar.getState());
        fVar.dl(-7);
        fVar.JA().Js().o(fVar);
    }

    private com.kwai.sodler.lib.a.a b(com.kwai.sodler.lib.a.f fVar, com.kwai.sodler.lib.a.a aVar) {
        String Jx = aVar.Jx();
        File file = new File(Jx);
        new StringBuilder("Loading plugin, path = ").append(Jx);
        com.kwai.sodler.lib.a.e JA = fVar.JA();
        if (file.exists()) {
            String id = fVar.getId();
            String version = fVar.getVersion();
            com.kwai.sodler.lib.a.a fM = fM(id);
            if (fM != null) {
                new StringBuilder("The current plugin has been loaded, id = ").append(version);
                return fM;
            }
            aVar.fQ(id);
            aVar.fP(version);
            if (JA.Jq().aw(id, version)) {
                String av = JA.Jq().av(id, version);
                if (q.ev(av)) {
                    aVar.fR(av);
                    aVar.au(this.mContext, av);
                    b(id, aVar);
                    return aVar;
                }
            }
            String b = JA.Jq().b(aVar);
            aVar.fR(b);
            new StringBuilder("installed .").append(b);
            aVar.au(this.mContext, b);
            b(id, aVar);
            if (Jx.endsWith(JA.Jn().JU())) {
                q.delete(Jx);
            }
            return aVar;
        }
        throw new PluginError.LoadError("Apk file not exist.", 3001);
    }

    private void b(com.kwai.sodler.lib.a.f fVar, PluginError pluginError) {
        new StringBuilder("onError state = ").append(fVar.getState());
        fVar.dl(-5);
        fVar.q(pluginError);
        h(fVar);
    }

    private void b(String str, com.kwai.sodler.lib.a.a aVar) {
        synchronized (this) {
            if (aVar != null) {
                if (aVar.isLoaded()) {
                    this.aJO.put(str, aVar);
                }
            }
        }
    }

    private static void g(com.kwai.sodler.lib.a.f fVar) {
        new StringBuilder("onPreLoad state = ").append(fVar.getState());
        fVar.JA().Js();
    }

    private static void h(com.kwai.sodler.lib.a.f fVar) {
        PluginError.LoadError loadError;
        new StringBuilder("onPostLoad state = ").append(fVar.getState());
        if (fVar.getState() == 0) {
            com.kwai.sodler.lib.a.a JH = fVar.JH();
            if (JH != null) {
                fVar.JA().Js().c(fVar, JH);
                return;
            }
            fVar.dl(-1);
        }
        if (fVar.JC() != null) {
            loadError = fVar.JC() instanceof PluginError ? (PluginError) fVar.JC() : new PluginError.LoadError(fVar.JC(), 4011);
        } else {
            loadError = new PluginError.LoadError("Can not get plugin instance " + fVar.getState(), 4011);
        }
        fVar.JA().Js().c(fVar, loadError);
    }

    @Override // com.kwai.sodler.lib.a.d
    public final com.kwai.sodler.lib.a.f f(com.kwai.sodler.lib.a.f fVar) {
        new StringBuilder("Loading plugin, id = ").append(fVar.getId());
        fVar.fS("Load");
        g(fVar);
        if (fVar.isCanceled()) {
            a(fVar);
            return fVar;
        }
        fVar.JO();
        com.kwai.sodler.lib.a.a aVar = this.aJO.get(fVar.getId());
        if (aVar != null && aVar.isLoaded()) {
            fVar.c(aVar);
            new StringBuilder("Load plugin success, path = ").append(aVar.Jx());
            fVar.dl(0);
            h(fVar);
            return fVar;
        }
        List<com.kwai.sodler.lib.c.a> JM = fVar.JM();
        com.kwai.sodler.lib.c.b k = f.k(fVar);
        if (k == null) {
            fVar.dl(-1);
            h(fVar);
            return fVar;
        }
        com.kwai.sodler.lib.c.a aVar2 = null;
        com.kwai.sodler.lib.c.a aVar3 = null;
        if (JM != null) {
            aVar3 = null;
            if (!JM.isEmpty()) {
                Iterator<com.kwai.sodler.lib.c.a> it = JM.iterator();
                while (true) {
                    aVar3 = aVar2;
                    if (!it.hasNext()) {
                        break;
                    }
                    com.kwai.sodler.lib.c.a next = it.next();
                    if (k.version.equals(next.version)) {
                        aVar2 = next;
                    } else {
                        fVar.JA().Jq().at(fVar.getId(), next.version);
                    }
                }
            }
        }
        if (aVar3 != null) {
            String av = fVar.JA().Jq().av(aVar3.aKT, aVar3.version);
            new StringBuilder("-------本地已存在--------").append(av);
            fVar.fT(av);
            fVar.fU(av);
            fVar.dl(1);
            fVar.fP(aVar3.version);
        } else if (!ag.isWifiConnected(this.mContext) && (k.aKX || (k.aKY && fVar.JF() > 0))) {
            b(fVar, new PluginError.NotWifiDownloadError("It can be downloaded only on WiFi", 2007));
            return fVar;
        } else {
            fVar.JA().Jp().i(fVar);
        }
        if (fVar.getState() != 1) {
            h(fVar);
            return fVar;
        }
        String JG = fVar.JG();
        new StringBuilder("-------更新成功或者获取到本地成功------------").append(JG);
        if (TextUtils.isEmpty(JG)) {
            fVar.dl(-1);
            h(fVar);
            return fVar;
        }
        com.kwai.sodler.lib.a.a a2 = fVar.fX(JG).a(k);
        if (fVar.isCanceled()) {
            a(fVar);
            return fVar;
        }
        try {
            fVar.c(b(fVar, a2));
            new StringBuilder("Load plugin success, path = ").append(JG);
            fVar.dl(0);
            h(fVar);
            return fVar;
        } catch (PluginError.InstallError e) {
            e = e;
            b(fVar, e);
            return fVar;
        } catch (PluginError.LoadError e2) {
            e = e2;
            b(fVar, e);
            return fVar;
        } catch (Throwable th) {
            a.e("Sodler.loader", "Load plugin failed, path = " + JG, th);
            b(fVar, new PluginError.InstallError("Load or install plugin failed", 4004));
            return fVar;
        }
    }

    @Override // com.kwai.sodler.lib.a.d
    public final com.kwai.sodler.lib.a.a fM(String str) {
        synchronized (this) {
            com.kwai.sodler.lib.a.a aVar = this.aJO.get(str);
            if (aVar != null) {
                if (!aVar.isLoaded()) {
                    return null;
                }
            }
            return aVar;
        }
    }
}
