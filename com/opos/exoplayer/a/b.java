package com.opos.exoplayer.a;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.anythink.expressad.video.module.a.a.m;
import com.bytedance.applog.tracker.Tracker;
import com.opos.exoplayer.core.k;
import com.opos.exoplayer.core.q;
import com.opos.exoplayer.core.y;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Locale;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/a/b.class */
public class b extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final View$OnClickListenerC0647b f24988a;
    private final StringBuilder b;

    /* renamed from: c  reason: collision with root package name */
    private final Formatter f24989c;
    private final y.a d;
    private final y.b e;
    private q f;
    private com.opos.exoplayer.core.c g;
    private a h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private long q;
    private long[] r;
    private boolean[] s;
    private long[] t;
    private boolean[] u;
    private final Runnable v;
    private final Runnable w;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/a/b$a.class */
    public interface a {
        void a(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.exoplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/a/b$b.class */
    public final class View$OnClickListenerC0647b extends q.a implements View.OnClickListener {
        private View$OnClickListenerC0647b() {
        }

        @Override // com.opos.exoplayer.core.q.a, com.opos.exoplayer.core.q.b
        public void a(int i) {
            b.this.i();
            b.this.h();
        }

        @Override // com.opos.exoplayer.core.q.a, com.opos.exoplayer.core.q.b
        public void a(y yVar, Object obj, int i) {
            b.this.h();
            b.this.k();
            b.this.l();
        }

        @Override // com.opos.exoplayer.core.q.a, com.opos.exoplayer.core.q.b
        public void a(boolean z, int i) {
            b.this.g();
            b.this.l();
        }

        @Override // com.opos.exoplayer.core.q.a, com.opos.exoplayer.core.q.b
        public void b(int i) {
            b.this.h();
            b.this.l();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            q unused = b.this.f;
            b.this.e();
        }
    }

    static {
        k.a("goog.exo.ui");
    }

    public b(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        this.v = new Runnable() { // from class: com.opos.exoplayer.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.l();
            }
        };
        this.w = new Runnable() { // from class: com.opos.exoplayer.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.c();
            }
        };
        this.l = 5000;
        this.m = 15000;
        this.n = 5000;
        this.o = 0;
        this.q = com.anythink.expressad.exoplayer.b.b;
        this.p = false;
        this.d = new y.a();
        this.e = new y.b();
        this.b = new StringBuilder();
        this.f24989c = new Formatter(this.b, Locale.getDefault());
        this.r = new long[0];
        this.s = new boolean[0];
        this.t = new long[0];
        this.u = new boolean[0];
        this.f24988a = new View$OnClickListenerC0647b();
        this.g = new com.opos.exoplayer.core.d();
        setDescendantFocusability(262144);
    }

    private void a(int i, long j) {
        if (this.g.a(this.f, i, j)) {
            return;
        }
        l();
    }

    private void a(long j) {
        a(this.f.i(), j);
    }

    private static boolean a(y yVar, y.b bVar) {
        boolean z;
        if (yVar.b() > 100) {
            return false;
        }
        int b = yVar.b();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= b) {
                z = true;
                break;
            }
            z = false;
            if (yVar.a(i2, bVar).i == com.anythink.expressad.exoplayer.b.b) {
                break;
            }
            i = i2 + 1;
        }
        return z;
    }

    private static boolean b(int i) {
        return i == 90 || i == 89 || i == 85 || i == 126 || i == 127 || i == 87 || i == 88;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        removeCallbacks(this.w);
        if (this.n <= 0) {
            this.q = com.anythink.expressad.exoplayer.b.b;
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        int i = this.n;
        this.q = uptimeMillis + i;
        if (this.i) {
            postDelayed(this.w, i);
        }
    }

    private void f() {
        g();
        h();
        i();
        j();
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (d() && this.i) {
            r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (d() && this.i) {
            q qVar = this.f;
            y h = qVar != null ? qVar.h() : null;
            if (!((h == null || h.a()) ? false : true) || this.f.o()) {
                return;
            }
            h.a(this.f.i(), this.e);
            if (!this.e.d && this.e.e) {
                this.f.k();
            }
            if (this.e.e) {
                return;
            }
            this.f.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
    }

    private void j() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        q qVar = this.f;
        if (qVar == null) {
            return;
        }
        this.k = this.j && a(qVar.h(), this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        long j;
        long j2;
        long j3;
        int i;
        if (d() && this.i) {
            q qVar = this.f;
            if (qVar != null) {
                y h = qVar.h();
                if (!h.a()) {
                    int i2 = this.f.i();
                    int i3 = this.k ? 0 : i2;
                    int b = this.k ? h.b() - 1 : i2;
                    long j4 = 0;
                    j2 = 0;
                    int i4 = 0;
                    while (true) {
                        j3 = j4;
                        if (i3 > b) {
                            break;
                        }
                        j3 = j4;
                        if (i3 == i2) {
                            j3 = j2;
                        }
                        h.a(i3, this.e);
                        if (this.e.i == com.anythink.expressad.exoplayer.b.b) {
                            com.opos.exoplayer.core.i.a.b(!this.k);
                            break;
                        }
                        int i5 = this.e.f;
                        while (true) {
                            int i6 = i5;
                            if (i6 <= this.e.g) {
                                h.a(i6, this.d);
                                int d = this.d.d();
                                int i7 = 0;
                                while (i7 < d) {
                                    long a2 = this.d.a(i7);
                                    long j5 = a2;
                                    if (a2 == Long.MIN_VALUE) {
                                        if (this.d.d == com.anythink.expressad.exoplayer.b.b) {
                                            i = i4;
                                            i7++;
                                            i4 = i;
                                        } else {
                                            j5 = this.d.d;
                                        }
                                    }
                                    long c2 = this.d.c() + j5;
                                    if (c2 >= 0) {
                                        i = i4;
                                        if (c2 <= this.e.i) {
                                            long[] jArr = this.r;
                                            if (i4 == jArr.length) {
                                                int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                                this.r = Arrays.copyOf(this.r, length);
                                                this.s = Arrays.copyOf(this.s, length);
                                            }
                                            this.r[i4] = com.opos.exoplayer.core.b.a(c2 + j2);
                                            this.s[i4] = this.d.c(i7);
                                            i = i4 + 1;
                                        }
                                    } else {
                                        i = i4;
                                    }
                                    i7++;
                                    i4 = i;
                                }
                                i5 = i6 + 1;
                            }
                        }
                        j2 += this.e.i;
                        i3++;
                        j4 = j3;
                    }
                } else {
                    j2 = 0;
                    j3 = 0;
                }
                com.opos.exoplayer.core.b.a(j2);
                long a3 = com.opos.exoplayer.core.b.a(j3);
                if (this.f.o()) {
                    j = this.f.p() + a3;
                } else {
                    j = this.f.m() + a3;
                    this.f.n();
                }
            } else {
                j = 0;
            }
            removeCallbacks(this.v);
            q qVar2 = this.f;
            int c3 = qVar2 == null ? 1 : qVar2.c();
            if (c3 == 1 || c3 == 4) {
                return;
            }
            long j6 = 1000;
            if (this.f.d()) {
                j6 = 1000;
                if (c3 == 3) {
                    float f = this.f.e().b;
                    if (f <= 0.1f) {
                        j6 = 1000;
                    } else if (f <= 5.0f) {
                        long max = 1000 / Math.max(1, Math.round(1.0f / f));
                        long j7 = max - (j % max);
                        j6 = j7;
                        if (j7 < max / 5) {
                            j6 = j7 + max;
                        }
                        if (f != 1.0f) {
                            j6 = ((float) j6) / f;
                        }
                    } else {
                        j6 = 200;
                    }
                }
            }
            postDelayed(this.v, j6);
        }
    }

    private void m() {
        r();
    }

    private void n() {
        y h = this.f.h();
        if (h.a()) {
            return;
        }
        h.a(this.f.i(), this.e);
        int k = this.f.k();
        if (k == -1 || (this.f.m() > m.ag && (!this.e.e || this.e.d))) {
            a(0L);
        } else {
            a(k, com.anythink.expressad.exoplayer.b.b);
        }
    }

    private void o() {
        y h = this.f.h();
        if (h.a()) {
            return;
        }
        int i = this.f.i();
        int j = this.f.j();
        if (j != -1) {
            a(j, com.anythink.expressad.exoplayer.b.b);
        } else if (h.a(i, this.e, false).e) {
            a(i, com.anythink.expressad.exoplayer.b.b);
        }
    }

    private void p() {
        if (this.l <= 0) {
            return;
        }
        a(Math.max(this.f.m() - this.l, 0L));
    }

    private void q() {
        if (this.m <= 0) {
            return;
        }
        long l = this.f.l();
        long m = this.f.m() + this.m;
        long j = m;
        if (l != com.anythink.expressad.exoplayer.b.b) {
            j = Math.min(m, l);
        }
        a(j);
    }

    private boolean r() {
        q qVar = this.f;
        return (qVar == null || qVar.c() == 4 || this.f.c() == 1 || !this.f.d()) ? false : true;
    }

    public int a() {
        return this.n;
    }

    public void a(int i) {
        this.n = i;
        if (d()) {
            e();
        }
    }

    public void a(q qVar) {
        q qVar2 = this.f;
        if (qVar2 == qVar) {
            return;
        }
        if (qVar2 != null) {
            qVar2.b(this.f24988a);
        }
        this.f = qVar;
        if (qVar != null) {
            qVar.a(this.f24988a);
        }
        f();
    }

    public boolean a(KeyEvent keyEvent) {
        q qVar;
        int keyCode = keyEvent.getKeyCode();
        boolean z = false;
        if (this.f != null) {
            if (!b(keyCode)) {
                return false;
            }
            if (keyEvent.getAction() == 0) {
                if (keyCode == 90) {
                    q();
                } else if (keyCode == 89) {
                    p();
                } else if (keyEvent.getRepeatCount() == 0) {
                    if (keyCode == 85) {
                        this.g.a(this.f, !qVar.d());
                    } else if (keyCode == 87) {
                        o();
                    } else if (keyCode == 88) {
                        n();
                    } else if (keyCode == 126) {
                        this.g.a(this.f, true);
                    } else if (keyCode == 127) {
                        this.g.a(this.f, false);
                    }
                }
            }
            z = true;
        }
        return z;
    }

    public void b() {
        if (!d()) {
            setVisibility(0);
            a aVar = this.h;
            if (aVar != null) {
                aVar.a(getVisibility());
            }
            f();
            m();
        }
        e();
    }

    public void c() {
        if (d()) {
            setVisibility(8);
            a aVar = this.h;
            if (aVar != null) {
                aVar.a(getVisibility());
            }
            removeCallbacks(this.v);
            removeCallbacks(this.w);
            this.q = com.anythink.expressad.exoplayer.b.b;
        }
    }

    public boolean d() {
        return getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.i = true;
        long j = this.q;
        if (j != com.anythink.expressad.exoplayer.b.b) {
            long uptimeMillis = j - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                c();
            } else {
                postDelayed(this.w, uptimeMillis);
            }
        } else if (d()) {
            e();
        }
        f();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i = false;
        removeCallbacks(this.v);
        removeCallbacks(this.w);
    }
}
