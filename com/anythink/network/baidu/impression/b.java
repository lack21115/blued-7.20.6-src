package com.anythink.network.baidu.impression;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/impression/b.class */
final class b {

    /* renamed from: a  reason: collision with root package name */
    static final int f6069a = 50;
    private static int d = 1000;
    final ViewTreeObserver.OnPreDrawListener b;

    /* renamed from: c  reason: collision with root package name */
    WeakReference<ViewTreeObserver> f6070c;
    private final ArrayList<View> e;
    private long f;
    private final Map<View, a> g;
    private final C0102b h;
    private d i;
    private final c j;
    private final Handler k;
    private boolean l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/impression/b$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f6072a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        long f6073c;
        View d;
        Integer e;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.baidu.impression.b$b  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/impression/b$b.class */
    public static final class C0102b {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f6074a = new Rect();

        private static boolean a(long j, int i) {
            return SystemClock.uptimeMillis() - j >= ((long) i);
        }

        final boolean a(View view, View view2, int i, Integer num) {
            if (view2 != null && view2.getVisibility() == 0 && view.getParent() != null && view2.getWindowVisibility() == 0 && view2.getGlobalVisibleRect(this.f6074a)) {
                long height = this.f6074a.height() * this.f6074a.width();
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
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/impression/b$c.class */
    public final class c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private final ArrayList<View> f6076c = new ArrayList<>();
        private final ArrayList<View> b = new ArrayList<>();

        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.a(b.this);
            for (Map.Entry entry : b.this.g.entrySet()) {
                View view = (View) entry.getKey();
                int i = ((a) entry.getValue()).f6072a;
                int i2 = ((a) entry.getValue()).b;
                Integer num = ((a) entry.getValue()).e;
                View view2 = ((a) entry.getValue()).d;
                if (b.this.h.a(view2, view, i, num)) {
                    this.b.add(view);
                } else if (!b.this.h.a(view2, view, i2, null)) {
                    this.f6076c.add(view);
                }
            }
            if (b.this.i != null) {
                b.this.i.onVisibilityChanged(this.b, this.f6076c);
            }
            this.b.clear();
            this.f6076c.clear();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/baidu/impression/b$d.class */
    interface d {
        void onVisibilityChanged(List<View> list, List<View> list2);
    }

    public b(Context context) {
        this(context, new WeakHashMap(10), new C0102b(), new Handler(Looper.getMainLooper()));
    }

    public b(Context context, int i) {
        this(context, new WeakHashMap(10), new C0102b(), new Handler(Looper.getMainLooper()));
        d = i;
    }

    private b(Context context, Map<View, a> map, C0102b c0102b, Handler handler) {
        this.f = 0L;
        this.g = map;
        this.h = c0102b;
        this.k = handler;
        this.j = new c();
        this.e = new ArrayList<>(50);
        this.b = new ViewTreeObserver.OnPreDrawListener() { // from class: com.anythink.network.baidu.impression.b.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                b.this.c();
                return true;
            }
        };
        this.f6070c = new WeakReference<>(null);
        a(context, null);
    }

    private void a(long j) {
        for (Map.Entry<View, a> entry : this.g.entrySet()) {
            if (entry.getValue().f6073c < j) {
                this.e.add(entry.getKey());
            }
        }
        Iterator<View> it = this.e.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        this.e.clear();
    }

    private void a(Context context, View view) {
        View topmostView;
        ViewTreeObserver viewTreeObserver = this.f6070c.get();
        if ((viewTreeObserver == null || !viewTreeObserver.isAlive()) && (topmostView = BDViews.getTopmostView(context, view)) != null) {
            ViewTreeObserver viewTreeObserver2 = topmostView.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                this.f6070c = new WeakReference<>(viewTreeObserver2);
                viewTreeObserver2.addOnPreDrawListener(this.b);
            }
        }
    }

    private void a(View view, int i, Integer num) {
        a(view, view, i, i, num);
    }

    private void a(View view, View view2, int i, Integer num) {
        a(view, view2, i, i, num);
    }

    static /* synthetic */ boolean a(b bVar) {
        bVar.l = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.g.clear();
        this.k.removeMessages(0);
        this.l = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(View view) {
        this.g.remove(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(View view, View view2, int i, int i2, Integer num) {
        try {
            a(view2.getContext(), view2);
            a aVar = this.g.get(view2);
            a aVar2 = aVar;
            if (aVar == null) {
                aVar2 = new a();
                this.g.put(view2, aVar2);
                c();
            }
            int min = Math.min(i2, i);
            aVar2.d = view;
            aVar2.f6072a = i;
            aVar2.b = min;
            aVar2.f6073c = this.f;
            aVar2.e = num;
            long j = this.f + 1;
            this.f = j;
            if (j % 50 == 0) {
                a(j - 50);
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(d dVar) {
        this.i = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        a();
        ViewTreeObserver viewTreeObserver = this.f6070c.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.b);
        }
        this.f6070c.clear();
        this.i = null;
    }

    final void c() {
        if (this.l) {
            return;
        }
        this.l = true;
        this.k.postDelayed(this.j, d);
    }
}
