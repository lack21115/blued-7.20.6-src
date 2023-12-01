package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/view/ViewPropertyAnimatorCompatSet.class */
public class ViewPropertyAnimatorCompatSet {
    ViewPropertyAnimatorListener b;
    private Interpolator d;
    private boolean e;

    /* renamed from: c  reason: collision with root package name */
    private long f1601c = -1;
    private final ViewPropertyAnimatorListenerAdapter f = new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.view.ViewPropertyAnimatorCompatSet.1
        private boolean b = false;

        /* renamed from: c  reason: collision with root package name */
        private int f1603c = 0;

        void a() {
            this.f1603c = 0;
            this.b = false;
            ViewPropertyAnimatorCompatSet.this.a();
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            int i = this.f1603c + 1;
            this.f1603c = i;
            if (i == ViewPropertyAnimatorCompatSet.this.f1600a.size()) {
                if (ViewPropertyAnimatorCompatSet.this.b != null) {
                    ViewPropertyAnimatorCompatSet.this.b.onAnimationEnd(null);
                }
                a();
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            if (this.b) {
                return;
            }
            this.b = true;
            if (ViewPropertyAnimatorCompatSet.this.b != null) {
                ViewPropertyAnimatorCompatSet.this.b.onAnimationStart(null);
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<ViewPropertyAnimatorCompat> f1600a = new ArrayList<>();

    void a() {
        this.e = false;
    }

    public void cancel() {
        if (this.e) {
            Iterator<ViewPropertyAnimatorCompat> it = this.f1600a.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            this.e = false;
        }
    }

    public ViewPropertyAnimatorCompatSet play(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.e) {
            this.f1600a.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet playSequentially(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.f1600a.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.setStartDelay(viewPropertyAnimatorCompat.getDuration());
        this.f1600a.add(viewPropertyAnimatorCompat2);
        return this;
    }

    public ViewPropertyAnimatorCompatSet setDuration(long j) {
        if (!this.e) {
            this.f1601c = j;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setInterpolator(Interpolator interpolator) {
        if (!this.e) {
            this.d = interpolator;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.e) {
            this.b = viewPropertyAnimatorListener;
        }
        return this;
    }

    public void start() {
        if (this.e) {
            return;
        }
        Iterator<ViewPropertyAnimatorCompat> it = this.f1600a.iterator();
        while (it.hasNext()) {
            ViewPropertyAnimatorCompat next = it.next();
            long j = this.f1601c;
            if (j >= 0) {
                next.setDuration(j);
            }
            Interpolator interpolator = this.d;
            if (interpolator != null) {
                next.setInterpolator(interpolator);
            }
            if (this.b != null) {
                next.setListener(this.f);
            }
            next.start();
        }
        this.e = true;
    }
}
