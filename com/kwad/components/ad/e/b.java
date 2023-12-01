package com.kwad.components.ad.e;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bl;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/e/b.class */
public final class b {
    private com.kwad.sdk.core.f.d ef;
    private int mA;
    private CopyOnWriteArrayList<C0470b> mz = new CopyOnWriteArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/e/b$a.class */
    public static final class a {
        private static final b mD = new b();
    }

    /* renamed from: com.kwad.components.ad.e.b$b  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/e/b$b.class */
    public static final class C0470b {
        private final c mE;
        private final WeakReference<View> mF;

        public C0470b(c cVar, View view) {
            this.mF = new WeakReference<>(view);
            this.mE = cVar;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/e/b$c.class */
    public interface c {
        void f(double d);
    }

    private void a(float f, Context context) {
        this.ef = new com.kwad.sdk.core.f.d(f);
        this.mz = new CopyOnWriteArrayList<>();
        this.ef.a(new com.kwad.sdk.core.f.b() { // from class: com.kwad.components.ad.e.b.1
            @Override // com.kwad.sdk.core.f.b
            public final void a(double d) {
                if (b.this.mz != null) {
                    b.this.e(d);
                    bi.a(new Runnable() { // from class: com.kwad.components.ad.e.b.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.kwad.sdk.core.d.b.d("KSNativeAdShakeManager", "onShakeEvent openGate2");
                            b.this.ef.xD();
                        }
                    }, null, 500L);
                }
            }

            @Override // com.kwad.sdk.core.f.b
            public final void bd() {
            }
        });
        this.ef.e(f);
        this.ef.aX(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(double d) {
        CopyOnWriteArrayList<C0470b> copyOnWriteArrayList = this.mz;
        int uF = (int) (com.kwad.sdk.core.config.d.uF() * 100.0f);
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        int i = Integer.MAX_VALUE;
        Iterator<C0470b> it = copyOnWriteArrayList.iterator();
        C0470b c0470b = null;
        C0470b c0470b2 = null;
        while (it.hasNext()) {
            C0470b next = it.next();
            WeakReference weakReference = next.mF;
            if (weakReference != null) {
                Rect rect = new Rect();
                if (((View) weakReference.get()).getGlobalVisibleRect(rect) && bl.o((View) weakReference.get(), uF)) {
                    int i2 = this.mA / 2;
                    int min = Math.min(Math.abs(rect.top - i2), Math.abs(rect.bottom - i2));
                    if (min < i) {
                        c0470b = next;
                        i = min;
                    } else if (min == i) {
                        c0470b2 = next;
                    }
                }
            }
        }
        if (c0470b != null) {
            C0470b c0470b3 = c0470b;
            if (c0470b2 != null) {
                Rect rect2 = new Rect();
                ((View) c0470b.mF.get()).getGlobalVisibleRect(rect2);
                Rect rect3 = new Rect();
                ((View) c0470b2.mF.get()).getGlobalVisibleRect(rect2);
                c0470b3 = c0470b;
                if (rect2.top < rect3.top) {
                    c0470b3 = c0470b2;
                }
            }
            c0470b3.mE.f(d);
        }
    }

    public static b eI() {
        return a.mD;
    }

    public final void a(float f, View view, c cVar) {
        if (view == null || view.getContext() == null) {
            return;
        }
        if (this.ef == null) {
            this.mA = com.kwad.sdk.c.kwai.a.aw(view.getContext());
            a(f, view.getContext());
        }
        this.mz.add(new C0470b(cVar, view));
    }

    public final void a(c cVar) {
        Iterator<C0470b> it = this.mz.iterator();
        while (it.hasNext()) {
            C0470b next = it.next();
            if (next.mE == cVar) {
                this.mz.remove(next);
            }
        }
        com.kwad.sdk.core.d.b.d("KSNativeAdShakeManager", "sShakeItems size " + this.mz.size());
    }
}
