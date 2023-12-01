package com.opos.mobad.l;

import android.app.Activity;
import com.opos.mobad.ad.i;
import java.util.concurrent.Callable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/l/k.class */
public abstract class k extends j implements com.opos.mobad.ad.i {

    /* renamed from: a  reason: collision with root package name */
    private i.a f12630a;

    public k(i.a aVar) {
        super(aVar);
        this.f12630a = aVar;
    }

    @Override // com.opos.mobad.ad.i
    public void a(final Activity activity) {
        d(new Callable<Boolean>() { // from class: com.opos.mobad.l.k.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                return Boolean.valueOf(k.this.b(activity));
            }
        });
    }

    protected abstract boolean b(Activity activity);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(Callable<Boolean> callable) {
        i.a aVar;
        int i;
        String str;
        int a2 = this.f.a(3, callable);
        com.opos.cmn.an.f.a.b("SyncStateController", "showAd state=" + a2 + ",Ad =" + this);
        switch (a2) {
            case 0:
            case 1:
            case 6:
                aVar = this.f12630a;
                if (aVar != null) {
                    i = 10006;
                    str = "ad data is null";
                    break;
                } else {
                    return;
                }
            case 2:
            case 3:
                return;
            case 4:
                aVar = this.f12630a;
                if (aVar != null) {
                    i = 10008;
                    str = "ad had showd, please reload";
                    break;
                } else {
                    return;
                }
            case 5:
                aVar = this.f12630a;
                if (aVar != null) {
                    i = 11001;
                    str = "ad has destroyed.";
                    break;
                } else {
                    return;
                }
            default:
                i.a aVar2 = this.f12630a;
                if (aVar2 != null) {
                    aVar2.a(-1, "show with illegal state:" + a2);
                    return;
                }
                return;
        }
        aVar.a(i, str);
    }

    @Override // com.opos.mobad.l.j
    public void i_() {
        i.a aVar;
        if (4 != this.f.a(4) || (aVar = this.f12630a) == null) {
            return;
        }
        aVar.b();
    }

    @Override // com.opos.mobad.l.j
    void n() {
        this.f = l.b();
    }

    public final void p() {
        i.a aVar;
        if (5 == d() || (aVar = this.f12630a) == null) {
            return;
        }
        aVar.a(0L);
    }

    public final void q() {
        i.a aVar;
        if (5 == d() || (aVar = this.f12630a) == null) {
            return;
        }
        aVar.a("");
    }
}
