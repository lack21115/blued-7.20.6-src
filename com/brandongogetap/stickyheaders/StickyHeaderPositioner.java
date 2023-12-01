package com.brandongogetap.stickyheaders;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.brandongogetap.stickyheaders.exposed.StickyHeaderListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/brandongogetap/stickyheaders/StickyHeaderPositioner.class */
final class StickyHeaderPositioner {

    /* renamed from: a  reason: collision with root package name */
    private final RecyclerView f7025a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private View f7026c;
    private List<Integer> e;
    private int f;
    private boolean g;
    private RecyclerView.ViewHolder j;
    private StickyHeaderListener k;
    private int d = -1;
    private float h = -1.0f;
    private int i = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StickyHeaderPositioner(RecyclerView recyclerView) {
        this.f7025a = recyclerView;
        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.brandongogetap.stickyheaders.StickyHeaderPositioner.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int visibility = StickyHeaderPositioner.this.f7025a.getVisibility();
                if (StickyHeaderPositioner.this.f7026c != null) {
                    StickyHeaderPositioner.this.f7026c.setVisibility(visibility);
                }
            }
        });
        this.b = i();
    }

    private float a(Context context, int i) {
        return i * context.getResources().getDisplayMetrics().density;
    }

    private float a(View view) {
        if (b(view)) {
            if (this.f == 1) {
                float f = -(this.f7026c.getHeight() - view.getY());
                this.f7026c.setTranslationY(f);
                return f;
            }
            float f2 = -(this.f7026c.getWidth() - view.getX());
            this.f7026c.setTranslationX(f2);
            return f2;
        }
        return -1.0f;
    }

    private int a(int i, View view) {
        int i2;
        int indexOf;
        if (!c(view) || (indexOf = this.e.indexOf(Integer.valueOf(i))) <= 0) {
            Iterator<Integer> it = this.e.iterator();
            int i3 = -1;
            while (true) {
                i2 = i3;
                if (!it.hasNext()) {
                    break;
                }
                Integer next = it.next();
                if (next.intValue() > i) {
                    break;
                }
                i3 = next.intValue();
            }
            return i2;
        }
        return this.e.get(indexOf - 1).intValue();
    }

    private void a(Context context) {
        int i = this.i;
        if (i == -1 || this.h != -1.0f) {
            return;
        }
        this.h = a(context, i);
    }

    private void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        marginLayoutParams.setMargins(this.f == 1 ? this.f7025a.getPaddingLeft() : 0, this.f == 1 ? 0 : this.f7025a.getPaddingTop(), this.f == 1 ? this.f7025a.getPaddingRight() : 0, 0);
    }

    private void b() {
        if (this.f == 1) {
            this.f7026c.setTranslationY(0.0f);
        } else {
            this.f7026c.setTranslationX(0.0f);
        }
    }

    private void b(final Map<Integer, View> map) {
        final View view = this.f7026c;
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.brandongogetap.stickyheaders.StickyHeaderPositioner.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT >= 16) {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
                if (StickyHeaderPositioner.this.f7026c == null) {
                    return;
                }
                StickyHeaderPositioner.this.j().requestLayout();
                StickyHeaderPositioner.this.a(map);
            }
        });
    }

    private boolean b(View view) {
        boolean z = false;
        if (this.f == 1) {
            if (view.getY() < this.f7026c.getHeight()) {
                z = true;
            }
            return z;
        }
        boolean z2 = false;
        if (view.getX() < this.f7026c.getWidth()) {
            z2 = true;
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c() {
        View view = this.f7026c;
        if (view == null) {
            return 0;
        }
        return this.f == 1 ? view.getHeight() : view.getWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        View view = this.f7026c;
        if (view == null) {
            return;
        }
        if (this.f == 1) {
            view.setTranslationY(view.getTranslationY() + i);
        } else {
            view.setTranslationX(view.getTranslationX() + i);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
        if (r4.getX() > 0.0f) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
        if (r4.getY() > 0.0f) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean c(android.view.View r4) {
        /*
            r3 = this;
            r0 = 0
            r6 = r0
            r0 = r6
            r5 = r0
            r0 = r4
            if (r0 == 0) goto L2b
            r0 = r3
            int r0 = r0.f
            r1 = 1
            if (r0 != r1) goto L1e
            r0 = r6
            r5 = r0
            r0 = r4
            float r0 = r0.getY()
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L2b
            goto L29
        L1e:
            r0 = r6
            r5 = r0
            r0 = r4
            float r0 = r0.getX()
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L2b
        L29:
            r0 = 1
            r5 = r0
        L2b:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.brandongogetap.stickyheaders.StickyHeaderPositioner.c(android.view.View):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        if (this.f7026c != null) {
            j().removeView(this.f7026c);
            f(i);
            this.f7026c = null;
            this.j = null;
        }
    }

    private void d(View view) {
        a((ViewGroup.MarginLayoutParams) view.getLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        View view = this.f7026c;
        boolean z = false;
        if (view == null) {
            return false;
        }
        if (this.f == 1) {
            if (view.getTranslationY() < 0.0f) {
                z = true;
            }
            return z;
        }
        boolean z2 = false;
        if (view.getTranslationX() < 0.0f) {
            z2 = true;
        }
        return z2;
    }

    private void e() {
        final View view = this.f7026c;
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.brandongogetap.stickyheaders.StickyHeaderPositioner.3

            /* renamed from: a  reason: collision with root package name */
            int f7029a;

            {
                this.f7029a = StickyHeaderPositioner.this.c();
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int i;
                if (Build.VERSION.SDK_INT >= 16) {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
                if (StickyHeaderPositioner.this.f7026c == null) {
                    return;
                }
                int c2 = StickyHeaderPositioner.this.c();
                if (!StickyHeaderPositioner.this.d() || (i = this.f7029a) == c2) {
                    return;
                }
                StickyHeaderPositioner.this.c(i - c2);
            }
        });
    }

    private void e(int i) {
        StickyHeaderListener stickyHeaderListener = this.k;
        if (stickyHeaderListener != null) {
            stickyHeaderListener.a(this.f7026c, i);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
        if (r4.getX() > 0.0f) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
        if (r4.getY() > 0.0f) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean e(android.view.View r4) {
        /*
            r3 = this;
            r0 = 0
            r6 = r0
            r0 = r6
            r5 = r0
            r0 = r4
            if (r0 == 0) goto L2b
            r0 = r3
            int r0 = r0.f
            r1 = 1
            if (r0 != r1) goto L1e
            r0 = r6
            r5 = r0
            r0 = r4
            float r0 = r0.getY()
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L2b
            goto L29
        L1e:
            r0 = r6
            r5 = r0
            r0 = r4
            float r0 = r0.getX()
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L2b
        L29:
            r0 = 1
            r5 = r0
        L2b:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.brandongogetap.stickyheaders.StickyHeaderPositioner.e(android.view.View):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        View view;
        if (this.h == -1.0f || (view = this.f7026c) == null) {
            return;
        }
        if ((this.f == 1 && view.getTranslationY() == 0.0f) || (this.f == 0 && this.f7026c.getTranslationX() == 0.0f)) {
            g();
        } else {
            h();
        }
    }

    private void f(int i) {
        StickyHeaderListener stickyHeaderListener = this.k;
        if (stickyHeaderListener != null) {
            stickyHeaderListener.b(this.f7026c, i);
        }
    }

    private void g() {
        if (Build.VERSION.SDK_INT < 21 || this.f7026c.getTag() != null) {
            return;
        }
        this.f7026c.setTag(true);
        this.f7026c.animate().z(this.h);
    }

    private void h() {
        if (Build.VERSION.SDK_INT < 21 || this.f7026c.getTag() == null) {
            return;
        }
        this.f7026c.setTag(null);
        this.f7026c.animate().z(0.0f);
    }

    private boolean i() {
        return this.f7025a.getPaddingLeft() > 0 || this.f7025a.getPaddingRight() > 0 || this.f7025a.getPaddingTop() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup j() {
        return (ViewGroup) this.f7025a.getParent();
    }

    private void k() {
        final int i = this.d;
        j().post(new Runnable() { // from class: com.brandongogetap.stickyheaders.StickyHeaderPositioner.5
            @Override // java.lang.Runnable
            public void run() {
                if (StickyHeaderPositioner.this.g) {
                    StickyHeaderPositioner.this.d(i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        d(this.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        if (i != -1) {
            this.i = i;
            return;
        }
        this.h = -1.0f;
        this.i = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, Map<Integer, View> map, ViewRetriever viewRetriever, boolean z) {
        int a2 = z ? -1 : a(i, map.get(Integer.valueOf(i)));
        View view = map.get(Integer.valueOf(a2));
        if (a2 != this.d) {
            if (a2 == -1 || (this.b && e(view))) {
                this.g = true;
                k();
                this.d = -1;
            } else {
                this.d = a2;
                a(viewRetriever.a(a2), a2);
            }
        } else if (this.b && e(view)) {
            d(this.d);
            this.d = -1;
        }
        a(map);
        this.f7025a.post(new Runnable() { // from class: com.brandongogetap.stickyheaders.StickyHeaderPositioner.2
            @Override // java.lang.Runnable
            public void run() {
                StickyHeaderPositioner.this.f();
            }
        });
    }

    void a(RecyclerView.ViewHolder viewHolder, int i) {
        if (this.j == viewHolder) {
            f(this.d);
            this.f7025a.getAdapter().onBindViewHolder(this.j, i);
            this.j.itemView.requestLayout();
            e();
            e(i);
            this.g = false;
            return;
        }
        d(this.d);
        this.j = viewHolder;
        this.f7025a.getAdapter().onBindViewHolder(this.j, i);
        this.f7026c = this.j.itemView;
        e(i);
        a(this.f7026c.getContext());
        this.f7026c.setVisibility(4);
        this.f7026c.setId(R.id.header_view);
        j().addView(this.f7026c);
        if (this.b) {
            d(this.f7026c);
        }
        this.g = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(StickyHeaderListener stickyHeaderListener) {
        this.k = stickyHeaderListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<Integer> list) {
        this.e = list;
    }

    void a(Map<Integer, View> map) {
        boolean z;
        View view = this.f7026c;
        if (view == null) {
            return;
        }
        if (view.getHeight() == 0) {
            b(map);
            return;
        }
        Iterator<Map.Entry<Integer, View>> it = map.entrySet().iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<Integer, View> next = it.next();
            if (next.getKey().intValue() > this.d) {
                z = a(next.getValue()) == -1.0f;
            }
        }
        if (z) {
            b();
        }
        this.f7026c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        this.f = i;
        this.d = -1;
        this.g = true;
        k();
    }
}
