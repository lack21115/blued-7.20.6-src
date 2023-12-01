package com.kwai.sodler.lib.a;

import android.text.TextUtils;
import com.kwai.sodler.lib.a.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/a/f.class */
public abstract class f<P extends a> {
    protected Throwable aKA;
    protected String aKB;
    protected boolean aKC;
    protected long aKD;
    protected List<com.kwai.sodler.lib.c.a> aKE;
    protected com.kwai.sodler.lib.c.b aKF;
    protected e aKc;
    protected String aKn;
    private final byte[] aKp;
    protected int aKs;
    protected int aKt;
    protected StringBuffer aKu;
    protected String aKv;
    protected String aKw;
    protected boolean aKx;
    protected P aKy;
    protected com.kwai.sodler.lib.ext.b aKz;
    protected String atq;
    protected String mDownloadUrl;
    protected int mState;
    protected String mVersion;

    public f() {
        this.mState = -1;
        this.aKs = 0;
        this.aKp = new byte[0];
        this.aKu = new StringBuffer(String.valueOf(-1));
    }

    public f(com.kwai.sodler.lib.c.b bVar) {
        this();
        this.aKF = bVar;
        this.aKn = bVar.aKT;
        this.mVersion = bVar.version;
        this.aKC = bVar.aKC;
        this.aKB = bVar.aKB;
    }

    private List<com.kwai.sodler.lib.c.a> ax(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                return arrayList;
            }
            File file = new File(this.aKc.Jq().fL(str));
            if (!file.exists()) {
                return arrayList;
            }
            String[] list = file.list();
            if (list != null) {
                if (list.length == 0) {
                    return arrayList;
                }
                int length = list.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    String str3 = list[i2];
                    if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2) || !str2.equals(str3) || !this.aKc.Jq().aw(str, str3)) {
                        this.aKc.Jq().at(str, str3);
                    } else {
                        com.kwai.sodler.lib.c.a aVar = new com.kwai.sodler.lib.c.a();
                        aVar.aKT = str;
                        aVar.version = str3;
                        aVar.qy = true;
                        arrayList.add(aVar);
                    }
                    i = i2 + 1;
                }
                Collections.sort(arrayList);
            }
        }
        return arrayList;
    }

    public final e JA() {
        return this.aKc;
    }

    public final String JB() {
        return this.aKu.toString();
    }

    public final Throwable JC() {
        return this.aKA;
    }

    public final boolean JD() {
        dl(-1);
        this.aKE = null;
        int i = this.aKs + 1;
        this.aKs = i;
        return i <= this.aKt;
    }

    public final boolean JE() {
        return this.aKx;
    }

    public final int JF() {
        return this.aKs;
    }

    public final String JG() {
        return !TextUtils.isEmpty(this.aKv) ? this.aKv : this.aKw;
    }

    public final P JH() {
        return this.aKy;
    }

    public final com.kwai.sodler.lib.ext.b JI() {
        return this.aKz;
    }

    public final boolean JJ() {
        return this.aKC;
    }

    public final String JK() {
        return this.aKB;
    }

    public final String JL() {
        return this.atq;
    }

    public final List<com.kwai.sodler.lib.c.a> JM() {
        return this.aKE;
    }

    public final com.kwai.sodler.lib.c.b JN() {
        return this.aKF;
    }

    public final void JO() {
        String id = getId();
        if (TextUtils.isEmpty(id) || this.aKE != null) {
            return;
        }
        this.aKE = ax(id, getVersion());
    }

    public final void JP() {
        dl(-3);
    }

    public final f a(e eVar) {
        this.aKc = eVar;
        return this;
    }

    public final void a(com.kwai.sodler.lib.ext.b bVar) {
        this.aKz = bVar;
    }

    @Deprecated
    public final void as(long j) {
        this.aKD = j;
    }

    public final void b(com.kwai.sodler.lib.c.b bVar) {
        this.aKF = bVar;
    }

    public final void c(P p) {
        this.aKy = p;
    }

    public final void cancel() {
        synchronized (this.aKp) {
            dl(-7);
        }
    }

    public final f dl(int i) {
        synchronized (this.aKp) {
            this.mState = i;
        }
        return fS(String.valueOf(i));
    }

    public final void dm(int i) {
        if (i > 0) {
            this.aKt = i;
        }
    }

    public final void fP(String str) {
        this.mVersion = str;
    }

    public final f fS(String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuffer stringBuffer = this.aKu;
            stringBuffer.append(" --> ");
            stringBuffer.append(str);
        }
        return this;
    }

    public final void fT(String str) {
        this.aKv = str;
    }

    public final void fU(String str) {
        this.aKw = str;
    }

    public final void fV(String str) {
        this.atq = str;
    }

    public final void fW(String str) {
        this.mDownloadUrl = str;
    }

    public abstract P fX(String str);

    public final String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public final String getId() {
        return this.aKn;
    }

    public final int getState() {
        int i;
        synchronized (this.aKp) {
            i = this.mState;
        }
        return i;
    }

    public final String getVersion() {
        return this.mVersion;
    }

    public final boolean isCanceled() {
        return this.mState == -7;
    }

    public final f q(Throwable th) {
        this.aKA = th;
        return fS(th.getLocalizedMessage());
    }

    public String toString() {
        return "PluginRequest{mId='" + this.aKn + "'}";
    }
}
