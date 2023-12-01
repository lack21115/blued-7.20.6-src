package com.blued.android.module.live_china.observer;

import android.app.AlertDialog;
import com.blued.android.module.common.model.LiveDefaultGiftModel;
import com.blued.android.module.live_china.model.GrabBoxModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.MuteLiveAudioModel;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/LiveRefreshUIObserver.class */
public class LiveRefreshUIObserver {

    /* renamed from: a  reason: collision with root package name */
    private static LiveRefreshUIObserver f13948a = new LiveRefreshUIObserver();
    private ArrayList<ILiveRefreshUIObserver> b = new ArrayList<>();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/LiveRefreshUIObserver$ILiveRefreshUIObserver.class */
    public interface ILiveRefreshUIObserver {
        void D();

        void I();

        void J();

        void K();

        void S();

        void a(int i, String str);

        void a(AlertDialog alertDialog);

        void a(LiveDefaultGiftModel liveDefaultGiftModel);

        void a(GrabBoxModel grabBoxModel);

        void a(MuteLiveAudioModel muteLiveAudioModel, String str);

        void a(boolean z);

        void a(boolean z, int i);

        boolean aE();

        void aF();

        void aG();

        void aI();

        void aL();

        void aM();

        void aN();

        void aQ();

        void af();

        void ag();

        void ah();

        void aj();

        void ak();

        void al();

        void b(long j);

        void b(LiveGiftModel liveGiftModel);

        void b(String str, int i);

        void b(String str, String str2);

        void b(boolean z, int i);

        void bb();

        void c(LiveGiftModel liveGiftModel);

        void c(String str, int i);

        void d(String str, int i);

        void d(boolean z);

        void e(boolean z);

        void f(String str);

        void f(boolean z);

        void g(String str);

        void h(String str);

        void i(int i);

        void j(int i);

        void j(boolean z);

        void k(int i);

        void l(int i);

        boolean onBackPressed();

        void y();
    }

    private LiveRefreshUIObserver() {
    }

    public static LiveRefreshUIObserver a() {
        return f13948a;
    }

    public void a(int i) {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.k(i);
                }
            }
        }
    }

    public void a(int i, String str) {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.a(i, str);
                }
            }
        }
    }

    public void a(long j) {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.b(j);
                }
            }
        }
    }

    public void a(AlertDialog alertDialog) {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.a(alertDialog);
                }
            }
        }
    }

    public void a(LiveDefaultGiftModel liveDefaultGiftModel) {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.a(liveDefaultGiftModel);
                }
            }
        }
    }

    public void a(GrabBoxModel grabBoxModel) {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.a(grabBoxModel);
                }
            }
        }
    }

    public void a(LiveGiftModel liveGiftModel) {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.b(liveGiftModel);
                }
            }
        }
    }

    public void a(MuteLiveAudioModel muteLiveAudioModel, String str) {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.a(muteLiveAudioModel, str);
                }
            }
        }
    }

    public void a(ILiveRefreshUIObserver iLiveRefreshUIObserver) {
        synchronized (this) {
            if (iLiveRefreshUIObserver != null) {
                this.b.add(iLiveRefreshUIObserver);
            }
        }
    }

    public void a(String str) {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.f(str);
                }
            }
        }
    }

    public void a(String str, int i) {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.d(str, i);
                }
            }
        }
    }

    public void a(String str, String str2) {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.b(str, str2);
                }
            }
        }
    }

    public void a(boolean z) {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.d(z);
                }
            }
        }
    }

    public void a(boolean z, int i) {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.a(z, i);
                }
            }
        }
    }

    public void b() {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.aL();
                }
            }
        }
    }

    public void b(int i) {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.j(i);
                }
            }
        }
    }

    public void b(LiveGiftModel liveGiftModel) {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.c(liveGiftModel);
                }
            }
        }
    }

    public void b(ILiveRefreshUIObserver iLiveRefreshUIObserver) {
        synchronized (this) {
            if (iLiveRefreshUIObserver != null) {
                this.b.remove(iLiveRefreshUIObserver);
            }
        }
    }

    public void b(String str) {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.g(str);
                }
            }
        }
    }

    public void b(String str, int i) {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.b(str, i);
                }
            }
        }
    }

    public void b(boolean z) {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.j(z);
                }
            }
        }
    }

    public void b(boolean z, int i) {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.b(z, i);
                }
            }
        }
    }

    public void c() {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.aM();
                }
            }
        }
    }

    public void c(int i) {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.i(i);
                }
            }
        }
    }

    public void c(String str) {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.h(str);
                }
            }
        }
    }

    public void c(String str, int i) {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.c(str, i);
                }
            }
        }
    }

    public void c(boolean z) {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.e(z);
                }
            }
        }
    }

    public void d() {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.aF();
                }
            }
        }
    }

    public void d(int i) {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.l(i);
                }
            }
        }
    }

    public void d(boolean z) {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.f(z);
                }
            }
        }
    }

    public void e() {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.aG();
                }
            }
        }
    }

    public boolean f() {
        ILiveRefreshUIObserver next;
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            do {
                if (!it.hasNext()) {
                    return true;
                }
                next = it.next();
            } while (next == null);
            return next.aE();
        }
    }

    public void g() {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.af();
                }
            }
        }
    }

    public void h() {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.ag();
                }
            }
        }
    }

    public void i() {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.y();
                }
            }
        }
    }

    public void j() {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.S();
                }
            }
        }
    }

    public void k() {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.aI();
                }
            }
        }
    }

    public void l() {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.J();
                }
            }
        }
    }

    public void m() {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.K();
                }
            }
        }
    }

    public void n() {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.a(true);
                }
            }
        }
    }

    public void o() {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.I();
                }
            }
        }
    }

    public void p() {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.bb();
                }
            }
        }
    }

    public void q() {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.onBackPressed();
                }
            }
        }
    }

    public void r() {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.D();
                }
            }
        }
    }

    public void s() {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.aQ();
                }
            }
        }
    }

    public void t() {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.aN();
                }
            }
        }
    }

    public void u() {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.ah();
                }
            }
        }
    }

    public void v() {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.aj();
                }
            }
        }
    }

    public void w() {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.ak();
                }
            }
        }
    }

    public void x() {
        synchronized (this) {
            Iterator<ILiveRefreshUIObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRefreshUIObserver next = it.next();
                if (next != null) {
                    next.al();
                }
            }
        }
    }
}
