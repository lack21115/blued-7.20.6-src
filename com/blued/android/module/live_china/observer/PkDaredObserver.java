package com.blued.android.module.live_china.observer;

import com.blued.android.module.live_china.view.pkdared.PkDaredNoticeItemView;
import com.blued.android.module.live_china.view.pkdared.PkDaredPropItemView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/PkDaredObserver.class */
public class PkDaredObserver {
    private static PkDaredObserver a = new PkDaredObserver();
    private ArrayList<IPkDaredObserver> b = new ArrayList<>();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/PkDaredObserver$IPkDaredObserver.class */
    public interface IPkDaredObserver {
        void a();

        void a(int i);

        void a(int i, int i2);

        void a(int i, int i2, int i3, int i4, int i5);

        void a(int i, String str, int i2, String str2, String str3, int i3);

        void a(int i, boolean z, String str, int i2, String str2, int i3, int i4, int i5, int i6);

        void a(PkDaredNoticeItemView pkDaredNoticeItemView);

        void a(String str, String str2, long j, String str3, int i, int i2, int i3, int i4, int i5, int i6, String str4, String str5, boolean z);

        void a(boolean z, int i);

        void a(boolean z, PkDaredPropItemView pkDaredPropItemView);

        void a(boolean z, String str, String str2, int i);

        void a(boolean z, String str, String str2, String str3, String str4, int i, int i2, boolean z2, int i3);

        void b();

        void b(int i);

        void b(int i, int i2);

        void c();

        void c(int i);

        void c(int i, int i2);

        void d(int i);

        void d(int i, int i2);

        void e(int i);

        void e(int i, int i2);

        void f(int i);
    }

    private PkDaredObserver() {
    }

    public static PkDaredObserver a() {
        return a;
    }

    public void a(int i) {
        synchronized (this) {
            Iterator<IPkDaredObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPkDaredObserver next = it.next();
                if (next != null) {
                    next.a(i);
                }
            }
        }
    }

    public void a(int i, int i2) {
        synchronized (this) {
            Iterator<IPkDaredObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPkDaredObserver next = it.next();
                if (next != null) {
                    next.a(i, i2);
                }
            }
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        synchronized (this) {
            Iterator<IPkDaredObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPkDaredObserver next = it.next();
                if (next != null) {
                    next.a(i, i2, i3, i4, i5);
                }
            }
        }
    }

    public void a(int i, String str, int i2, String str2, String str3, int i3) {
        synchronized (this) {
            Iterator<IPkDaredObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPkDaredObserver next = it.next();
                if (next != null) {
                    next.a(i, str, i2, str2, str3, i3);
                }
            }
        }
    }

    public void a(int i, boolean z, String str, int i2, String str2, int i3, int i4, int i5, int i6) {
        synchronized (this) {
            Iterator<IPkDaredObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPkDaredObserver next = it.next();
                if (next != null) {
                    next.a(i, z, str, i2, str2, i3, i4, i5, i6);
                }
            }
        }
    }

    public void a(IPkDaredObserver iPkDaredObserver) {
        synchronized (this) {
            if (iPkDaredObserver != null) {
                this.b.add(iPkDaredObserver);
            }
        }
    }

    public void a(PkDaredNoticeItemView pkDaredNoticeItemView) {
        synchronized (this) {
            Iterator<IPkDaredObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPkDaredObserver next = it.next();
                if (next != null) {
                    next.a(pkDaredNoticeItemView);
                }
            }
        }
    }

    public void a(String str, String str2, long j, String str3, int i, int i2, int i3, int i4, int i5, int i6, String str4, String str5, boolean z) {
        synchronized (this) {
            Iterator<IPkDaredObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPkDaredObserver next = it.next();
                if (next != null) {
                    next.a(str, str2, j, str3, i, i2, i3, i4, i5, i6, str4, str5, z);
                }
            }
        }
    }

    public void a(boolean z, int i) {
        synchronized (this) {
            Iterator<IPkDaredObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPkDaredObserver next = it.next();
                if (next != null) {
                    next.a(z, i);
                }
            }
        }
    }

    public void a(boolean z, PkDaredPropItemView pkDaredPropItemView) {
        synchronized (this) {
            Iterator<IPkDaredObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPkDaredObserver next = it.next();
                if (next != null) {
                    next.a(z, pkDaredPropItemView);
                }
            }
        }
    }

    public void a(boolean z, String str, String str2, int i) {
        synchronized (this) {
            Iterator<IPkDaredObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPkDaredObserver next = it.next();
                if (next != null) {
                    next.a(z, str, str2, i);
                }
            }
        }
    }

    public void a(boolean z, String str, String str2, String str3, String str4, int i, int i2, boolean z2, int i3) {
        synchronized (this) {
            Iterator<IPkDaredObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPkDaredObserver next = it.next();
                if (next != null) {
                    next.a(z, str, str2, str3, str4, i, i2, z2, i3);
                }
            }
        }
    }

    public void b() {
        synchronized (this) {
            Iterator<IPkDaredObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPkDaredObserver next = it.next();
                if (next != null) {
                    next.a();
                }
            }
        }
    }

    public void b(int i) {
        synchronized (this) {
            Iterator<IPkDaredObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPkDaredObserver next = it.next();
                if (next != null) {
                    next.b(i);
                }
            }
        }
    }

    public void b(int i, int i2) {
        synchronized (this) {
            Iterator<IPkDaredObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPkDaredObserver next = it.next();
                if (next != null) {
                    next.b(i, i2);
                }
            }
        }
    }

    public void b(IPkDaredObserver iPkDaredObserver) {
        synchronized (this) {
            if (iPkDaredObserver != null) {
                this.b.remove(iPkDaredObserver);
            }
        }
    }

    public void c() {
        synchronized (this) {
            Iterator<IPkDaredObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPkDaredObserver next = it.next();
                if (next != null) {
                    next.b();
                }
            }
        }
    }

    public void c(int i) {
        synchronized (this) {
            Iterator<IPkDaredObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPkDaredObserver next = it.next();
                if (next != null) {
                    next.c(i);
                }
            }
        }
    }

    public void c(int i, int i2) {
        synchronized (this) {
            Iterator<IPkDaredObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPkDaredObserver next = it.next();
                if (next != null) {
                    next.c(i, i2);
                }
            }
        }
    }

    public void d() {
        synchronized (this) {
            Iterator<IPkDaredObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPkDaredObserver next = it.next();
                if (next != null) {
                    next.c();
                }
            }
        }
    }

    public void d(int i) {
        synchronized (this) {
            Iterator<IPkDaredObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPkDaredObserver next = it.next();
                if (next != null) {
                    next.d(i);
                }
            }
        }
    }

    public void d(int i, int i2) {
        synchronized (this) {
            Iterator<IPkDaredObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPkDaredObserver next = it.next();
                if (next != null) {
                    next.d(i, i2);
                }
            }
        }
    }

    public void e(int i) {
        synchronized (this) {
            Iterator<IPkDaredObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPkDaredObserver next = it.next();
                if (next != null) {
                    next.e(i);
                }
            }
        }
    }

    public void e(int i, int i2) {
        synchronized (this) {
            Iterator<IPkDaredObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPkDaredObserver next = it.next();
                if (next != null) {
                    next.e(i, i2);
                }
            }
        }
    }

    public void f(int i) {
        synchronized (this) {
            Iterator<IPkDaredObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPkDaredObserver next = it.next();
                if (next != null) {
                    next.f(i);
                }
            }
        }
    }
}
