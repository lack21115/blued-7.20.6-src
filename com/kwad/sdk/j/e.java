package com.kwad.sdk.j;

import android.content.res.Resources;
import com.kwad.sdk.service.ServiceProvider;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/j/e.class */
public class e {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final AtomicBoolean Ip;
    private Resources aDE;
    private Resources aDF;
    private h aDG;
    private boolean aDH;
    private ClassLoader aDI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/j/e$a.class */
    public static final class a {
        private static final e aDJ = new e((byte) 0);
    }

    private e() {
        this.Ip = new AtomicBoolean(false);
    }

    /* synthetic */ e(byte b) {
        this();
    }

    public static e FK() {
        return a.aDJ;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00fe, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean FL() {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.j.e.FL():boolean");
    }

    private static boolean sO() {
        return ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sO();
    }

    private static boolean sP() {
        return ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sP();
    }

    public final boolean Ep() {
        return this.Ip.get();
    }

    public final ClassLoader getClassLoader() {
        return this.aDI;
    }

    public final Resources getResources() {
        return this.aDG;
    }

    public final void init() {
        if (this.Ip.get()) {
            return;
        }
        if (((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getIsExternal()) {
            if (sO() && FL()) {
                this.aDI = getClass().getClassLoader();
                i.bO(sP());
                com.kwad.sdk.core.d.b.d("KSDY/KSPlugin", toString());
                this.aDH = true;
            } else {
                this.aDH = false;
            }
        }
        this.Ip.set(true);
    }

    public String toString() {
        return "KSPlugin{mHostResources=" + this.aDE + ", mResResources=" + this.aDF + ", mPluginResources=" + this.aDG + ", mEnable=" + this.aDH + '}';
    }
}
