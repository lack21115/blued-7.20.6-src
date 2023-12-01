package com.anythink.core.common.k.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/a/f.class */
public final class f {
    final int a;
    final ViewTreeObserver.OnPreDrawListener b;
    private int c;
    private final ArrayList<View> d;
    private long e;
    private final Map<View, a> f;
    private final b g;
    private d h;
    private final c i;
    private final Handler j;
    private boolean k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/a/f$a.class */
    public static final class a {
        int a;
        int b;
        long c;
        View d;
        Integer e;

        a() {
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/a/f$b.class */
    public static class b {
        private final Rect a = new Rect();

        private static boolean a(long j, int i) {
            return SystemClock.uptimeMillis() - j >= ((long) i);
        }

        public final boolean a(View view, View view2, int i, Integer num) {
            if (view2 != null && view2.isShown() && view.getParent() != null && view2.getWindowVisibility() == 0 && view2.getGlobalVisibleRect(this.a)) {
                long height = this.a.height() * this.a.width();
                long height2 = view2.getHeight() * view2.getWidth();
                if (height2 <= 0) {
                    return false;
                }
                return (num == null || num.intValue() <= 0) ? height * 100 >= ((long) i) * height2 : height >= ((long) num.intValue());
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/a/f$c.class */
    public final class c implements Runnable {
        private final ArrayList<View> c = new ArrayList<>();
        private final ArrayList<View> b = new ArrayList<>();

        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            for (Map.Entry entry : f.this.f.entrySet()) {
                View view = (View) entry.getKey();
                int i = ((a) entry.getValue()).a;
                int i2 = ((a) entry.getValue()).b;
                Integer num = ((a) entry.getValue()).e;
                View view2 = ((a) entry.getValue()).d;
                if (f.this.g.a(view2, view, i, num)) {
                    this.b.add(view);
                    try {
                        view.getViewTreeObserver().removeOnPreDrawListener(f.this.b);
                    } catch (Throwable th) {
                    }
                } else if (!f.this.g.a(view2, view, i2, null)) {
                    this.c.add(view);
                }
            }
            if (f.this.h != null) {
                f.this.h.a(this.b);
            }
            this.b.clear();
            this.c.clear();
            f.d(f.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/a/f$d.class */
    public interface d {
        void a(List<View> list);
    }

    public f() {
        this(new WeakHashMap(10), new b(), new Handler(Looper.getMainLooper()));
    }

    public f(int i) {
        this(new WeakHashMap(10), new b(), new Handler(Looper.getMainLooper()));
        this.c = i;
    }

    private f(Map<View, a> map, b bVar, Handler handler) {
        this.c = 100;
        this.a = 50;
        this.e = 0L;
        this.f = map;
        this.g = bVar;
        this.j = handler;
        this.i = new c();
        this.d = new ArrayList<>(50);
        this.b = new ViewTreeObserver.OnPreDrawListener() { // from class: com.anythink.core.common.k.a.f.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                f.this.c();
                return true;
            }
        };
    }

    private void a(long j) {
        for (Map.Entry<View, a> entry : this.f.entrySet()) {
            if (entry.getValue().c < j) {
                this.d.add(entry.getKey());
            }
        }
        Iterator<View> it = this.d.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        this.d.clear();
    }

    private void a(View view, int i, Integer num) {
        a(view, view, i, i, num);
    }

    private void a(View view, View view2, int i, Integer num) {
        a(view, view2, i, i, num);
    }

    private static boolean a(Context context, View view) {
        View rootView;
        View findViewById = !(context instanceof Activity) ? null : ((Activity) context).getWindow().getDecorView().findViewById(16908290);
        if (view == null) {
            rootView = null;
        } else {
            rootView = view.getRootView();
            if (rootView == null) {
                rootView = null;
            } else {
                View findViewById2 = rootView.findViewById(16908290);
                if (findViewById2 != null) {
                    rootView = findViewById2;
                }
            }
        }
        if (findViewById != null) {
            rootView = findViewById;
        }
        return rootView != null && rootView.getViewTreeObserver().isAlive();
    }

    static /* synthetic */ boolean d(f fVar) {
        fVar.k = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.f.clear();
        this.j.removeMessages(0);
        this.k = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(View view) {
        this.f.remove(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(View view, View view2, int i, int i2, Integer num) {
        try {
            if (a(view2.getContext(), view2)) {
                a aVar = this.f.get(view2);
                a aVar2 = aVar;
                if (aVar == null) {
                    aVar2 = new a();
                    this.f.put(view2, aVar2);
                    c();
                }
                int min = Math.min(i2, i);
                aVar2.d = view;
                aVar2.a = i;
                aVar2.b = min;
                aVar2.c = this.e;
                aVar2.e = num;
                view2.getViewTreeObserver().addOnPreDrawListener(this.b);
                long j = this.e + 1;
                this.e = j;
                if (j % 50 == 0) {
                    a(j - 50);
                }
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(d dVar) {
        this.h = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        a();
        this.h = null;
    }

    final void c() {
        if (this.k) {
            return;
        }
        this.k = true;
        this.j.postDelayed(this.i, this.c);
    }
}
