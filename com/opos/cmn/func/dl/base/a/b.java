package com.opos.cmn.func.dl.base.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.c.d;
import java.io.File;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/a/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f11201a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    public int f11202c;
    String d;
    public String e;
    public String f;
    String g;
    public String h;
    public File i;
    public File j;
    public long k;
    public long l;
    public boolean m;
    boolean n;
    public boolean o;
    com.opos.cmn.func.dl.base.d p;
    public DownloadRequest q;
    public d.a r;
    public AtomicLong s = new AtomicLong();
    private File t;
    private int u;
    private int v;

    public b(DownloadRequest downloadRequest, com.opos.cmn.func.dl.base.d dVar) {
        this.q = downloadRequest;
        this.p = dVar;
        this.e = downloadRequest.f11181a;
        this.d = downloadRequest.e;
        this.b = downloadRequest.d;
        this.f11202c = downloadRequest.f;
        this.h = downloadRequest.f11182c;
        this.g = downloadRequest.b;
        this.o = downloadRequest.g;
        this.f11201a = dVar.f();
        this.r = dVar.h();
        this.v = dVar.b();
        this.u = dVar.a();
        String a2 = com.opos.cmn.func.dl.base.h.a.a(this.e);
        String str = this.g;
        this.i = new File(str, a2 + ".pos");
        String str2 = this.g;
        this.j = new File(str2, a2 + ".tmp");
    }

    public final File a() {
        File file = this.t;
        if (file != null) {
            return file;
        }
        if (TextUtils.isEmpty(this.h)) {
            this.h = com.opos.cmn.func.dl.base.h.a.d(this.e);
        }
        File file2 = new File(this.g, this.h);
        this.t = file2;
        return file2;
    }

    public final void a(long j) {
        this.s.set(j);
    }

    public final String toString() {
        return "DownloadInfo{mContext=" + this.f11201a + ", priority=" + this.b + ", downloadId=" + this.f11202c + ", mMd5='" + this.d + "', mUrl='" + this.e + "', mRedrictUrl='" + this.f + "', mDirPath='" + this.g + "', mFileName='" + this.h + "', mPosFile=" + this.i + ", mTempFile=" + this.j + ", mTotalLength=" + this.k + ", mStartLenght=" + this.l + ", writeThreadCount=" + this.v + ", isAcceptRange=" + this.m + ", allowDownload=" + this.n + ", mManager=" + this.p + ", mRequest=" + this.q + ", mConnFactory=" + this.r + ", mCurrentLength=" + this.s + '}';
    }
}
