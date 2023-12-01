package com.kwai.sodler.lib.a;

import android.content.Context;
import com.kwai.sodler.lib.i;
import java.io.File;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/a/a.class */
public abstract class a {
    protected File aKl;
    protected String aKm;
    protected String aKn;
    private final String aKq;
    protected com.kwai.sodler.lib.c.b aKr;
    protected String mVersion;
    private final byte[] aKp = new byte[0];
    private boolean aKo = false;
    protected com.kwai.sodler.lib.ext.c aJN = i.Jl().Jn();

    public a(String str) {
        this.aKq = str;
        this.aKm = str;
    }

    private void Jw() {
        if (this.aKo) {
            return;
        }
        synchronized (this.aKp) {
            this.aKo = true;
        }
    }

    public final String Jx() {
        return this.aKq;
    }

    public final String Jy() {
        com.kwai.sodler.lib.c.b bVar = this.aKr;
        if (bVar != null) {
            return bVar.aKW;
        }
        return null;
    }

    public final a a(com.kwai.sodler.lib.c.b bVar) {
        this.aKr = bVar;
        return this;
    }

    protected abstract void as(Context context, String str);

    public final void au(Context context, String str) {
        as(context, str);
        Jw();
    }

    public final void fP(String str) {
        this.mVersion = str;
    }

    public final void fQ(String str) {
        this.aKn = str;
    }

    public final void fR(String str) {
        this.aKm = str;
    }

    public final String getId() {
        return this.aKn;
    }

    public final String getVersion() {
        return this.mVersion;
    }

    public final boolean isLoaded() {
        boolean z;
        if (this.aKo) {
            return true;
        }
        synchronized (this.aKp) {
            z = this.aKo;
        }
        return z;
    }

    public String toString() {
        return "Plugin{, ApkPath = '" + this.aKq + "'}";
    }
}
