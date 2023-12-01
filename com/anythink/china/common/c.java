package com.anythink.china.common;

import android.os.SystemClock;
import com.anythink.china.api.ATAppDownloadListener;
import com.anythink.china.api.CustomAdapterDownloadListener;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.b.j;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.e;
import com.anythink.core.common.e.f;
import com.anythink.core.common.r;
import java.lang.ref.WeakReference;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/common/c.class */
public final class c implements CustomAdapterDownloadListener {

    /* renamed from: a  reason: collision with root package name */
    ATBaseAdAdapter f6311a;
    BaseAd b;

    /* renamed from: c  reason: collision with root package name */
    ATAdInfo f6312c;
    WeakReference<ATAppDownloadListener> d;
    long e;
    boolean f;
    boolean g;

    public c(ATBaseAdAdapter aTBaseAdAdapter, BaseAd baseAd, ATEventInterface aTEventInterface) {
        this.f6311a = aTBaseAdAdapter;
        this.b = baseAd;
        if (aTEventInterface == null || !(aTEventInterface instanceof ATAppDownloadListener)) {
            return;
        }
        this.d = new WeakReference<>((ATAppDownloadListener) aTEventInterface);
    }

    private void a() {
        BaseAd baseAd = this.b;
        if (baseAd != null) {
            this.f6312c = j.a(baseAd);
        } else {
            this.f6312c = j.a(this.f6311a);
        }
    }

    private void a(final int i, final long j, final String str) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.china.common.c.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    f fVar = new f();
                    fVar.b = c.this.b != null ? c.this.b.getDetail() : c.this.f6311a.getTrackingInfo();
                    fVar.f6657a = i;
                    fVar.f6658c = System.currentTimeMillis();
                    if (fVar.b instanceof e) {
                        ((e) fVar.b).b(str);
                        ((e) fVar.b).b(j);
                    }
                    r.a(n.a().g()).a(i, fVar, com.anythink.core.c.b.a(n.a().g()).b(n.a().p()));
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // com.anythink.china.api.CustomAdapterDownloadListener
    public final void onDownloadFail(long j, long j2, String str, String str2) {
        if (this.f6312c == null) {
            a();
        }
        WeakReference<ATAppDownloadListener> weakReference = this.d;
        ATAppDownloadListener aTAppDownloadListener = weakReference != null ? weakReference.get() : null;
        if (aTAppDownloadListener != null) {
            aTAppDownloadListener.onDownloadFail(this.f6312c, j, j2, str, str2);
        }
    }

    @Override // com.anythink.china.api.CustomAdapterDownloadListener
    public final void onDownloadFinish(long j, String str, String str2) {
        if (this.f6312c == null) {
            a();
        }
        if (this.e != 0 && !this.g) {
            this.g = true;
            a(19, SystemClock.elapsedRealtime() - this.e, str2);
        }
        WeakReference<ATAppDownloadListener> weakReference = this.d;
        ATAppDownloadListener aTAppDownloadListener = weakReference != null ? weakReference.get() : null;
        if (aTAppDownloadListener != null) {
            aTAppDownloadListener.onDownloadFinish(this.f6312c, j, str, str2);
        }
    }

    @Override // com.anythink.china.api.CustomAdapterDownloadListener
    public final void onDownloadPause(long j, long j2, String str, String str2) {
        if (this.f6312c == null) {
            a();
        }
        WeakReference<ATAppDownloadListener> weakReference = this.d;
        ATAppDownloadListener aTAppDownloadListener = weakReference != null ? weakReference.get() : null;
        if (aTAppDownloadListener != null) {
            aTAppDownloadListener.onDownloadPause(this.f6312c, j, j2, str, str2);
        }
    }

    @Override // com.anythink.china.api.CustomAdapterDownloadListener
    public final void onDownloadStart(long j, long j2, String str, String str2) {
        if (this.f6312c == null) {
            a();
        }
        this.e = SystemClock.elapsedRealtime();
        a(18, 0L, str2);
        WeakReference<ATAppDownloadListener> weakReference = this.d;
        ATAppDownloadListener aTAppDownloadListener = weakReference != null ? weakReference.get() : null;
        if (aTAppDownloadListener != null) {
            aTAppDownloadListener.onDownloadStart(this.f6312c, j, j2, str, str2);
        }
    }

    @Override // com.anythink.china.api.CustomAdapterDownloadListener
    public final void onDownloadUpdate(long j, long j2, String str, String str2) {
        if (this.f6312c == null) {
            a();
        }
        WeakReference<ATAppDownloadListener> weakReference = this.d;
        ATAppDownloadListener aTAppDownloadListener = weakReference != null ? weakReference.get() : null;
        if (aTAppDownloadListener != null) {
            aTAppDownloadListener.onDownloadUpdate(this.f6312c, j, j2, str, str2);
        }
    }

    @Override // com.anythink.china.api.CustomAdapterDownloadListener
    public final void onInstalled(String str, String str2) {
        if (this.f6312c == null) {
            a();
        }
        if (!this.f) {
            this.f = true;
            a(20, 0L, str2);
        }
        WeakReference<ATAppDownloadListener> weakReference = this.d;
        ATAppDownloadListener aTAppDownloadListener = weakReference != null ? weakReference.get() : null;
        if (aTAppDownloadListener != null) {
            aTAppDownloadListener.onInstalled(this.f6312c, str, str2);
        }
    }
}
