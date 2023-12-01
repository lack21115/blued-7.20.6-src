package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.R;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/target/ViewTarget.class */
public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {
    private static boolean b;

    /* renamed from: c  reason: collision with root package name */
    private static int f21071c = R.id.glide_custom_view_target_tag;

    /* renamed from: a  reason: collision with root package name */
    protected final T f21072a;
    private final SizeDeterminer d;
    private View.OnAttachStateChangeListener e;
    private boolean f;
    private boolean g;

    /* renamed from: com.bumptech.glide.request.target.ViewTarget$1  reason: invalid class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/target/ViewTarget$1.class */
    class AnonymousClass1 implements View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewTarget f21073a;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f21073a.b();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.f21073a.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/target/ViewTarget$SizeDeterminer.class */
    public static final class SizeDeterminer {

        /* renamed from: a  reason: collision with root package name */
        static Integer f21074a;
        boolean b;

        /* renamed from: c  reason: collision with root package name */
        private final View f21075c;
        private final List<SizeReadyCallback> d = new ArrayList();
        private SizeDeterminerLayoutListener e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/target/ViewTarget$SizeDeterminer$SizeDeterminerLayoutListener.class */
        public static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<SizeDeterminer> f21076a;

            SizeDeterminerLayoutListener(SizeDeterminer sizeDeterminer) {
                this.f21076a = new WeakReference<>(sizeDeterminer);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                SizeDeterminer sizeDeterminer = this.f21076a.get();
                if (sizeDeterminer != null) {
                    sizeDeterminer.a();
                    return true;
                }
                return true;
            }
        }

        SizeDeterminer(View view) {
            this.f21075c = view;
        }

        private int a(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.b && this.f21075c.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.f21075c.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return a(this.f21075c.getContext());
        }

        private static int a(Context context) {
            if (f21074a == null) {
                Display defaultDisplay = ((WindowManager) Preconditions.a((WindowManager) context.getSystemService(Context.WINDOW_SERVICE))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f21074a = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f21074a.intValue();
        }

        private void a(int i, int i2) {
            Iterator it = new ArrayList(this.d).iterator();
            while (it.hasNext()) {
                ((SizeReadyCallback) it.next()).a(i, i2);
            }
        }

        private boolean a(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        private boolean b(int i, int i2) {
            return a(i) && a(i2);
        }

        private int c() {
            int paddingTop = this.f21075c.getPaddingTop();
            int paddingBottom = this.f21075c.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f21075c.getLayoutParams();
            return a(this.f21075c.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop + paddingBottom);
        }

        private int d() {
            int paddingLeft = this.f21075c.getPaddingLeft();
            int paddingRight = this.f21075c.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f21075c.getLayoutParams();
            return a(this.f21075c.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft + paddingRight);
        }

        void a() {
            if (this.d.isEmpty()) {
                return;
            }
            int d = d();
            int c2 = c();
            if (b(d, c2)) {
                a(d, c2);
                b();
            }
        }

        void a(SizeReadyCallback sizeReadyCallback) {
            int d = d();
            int c2 = c();
            if (b(d, c2)) {
                sizeReadyCallback.a(d, c2);
                return;
            }
            if (!this.d.contains(sizeReadyCallback)) {
                this.d.add(sizeReadyCallback);
            }
            if (this.e == null) {
                ViewTreeObserver viewTreeObserver = this.f21075c.getViewTreeObserver();
                SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new SizeDeterminerLayoutListener(this);
                this.e = sizeDeterminerLayoutListener;
                viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
            }
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.f21075c.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.e);
            }
            this.e = null;
            this.d.clear();
        }

        void b(SizeReadyCallback sizeReadyCallback) {
            this.d.remove(sizeReadyCallback);
        }
    }

    public ViewTarget(T t) {
        this.f21072a = (T) Preconditions.a(t);
        this.d = new SizeDeterminer(t);
    }

    private void a(Object obj) {
        b = true;
        this.f21072a.setTag(f21071c, obj);
    }

    private void e() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.e;
        if (onAttachStateChangeListener == null || this.g) {
            return;
        }
        this.f21072a.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.g = true;
    }

    private void f() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.e;
        if (onAttachStateChangeListener == null || !this.g) {
            return;
        }
        this.f21072a.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.g = false;
    }

    private Object g() {
        return this.f21072a.getTag(f21071c);
    }

    void b() {
        Request request = getRequest();
        if (request == null || !request.f()) {
            return;
        }
        request.a();
    }

    void c() {
        Request request = getRequest();
        if (request != null) {
            this.f = true;
            request.b();
            this.f = false;
        }
    }

    public T d() {
        return this.f21072a;
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public Request getRequest() {
        Object g = g();
        if (g != null) {
            if (g instanceof Request) {
                return (Request) g;
            }
            throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
        }
        return null;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void getSize(SizeReadyCallback sizeReadyCallback) {
        this.d.a(sizeReadyCallback);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        this.d.b();
        if (this.f) {
            return;
        }
        f();
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        e();
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(SizeReadyCallback sizeReadyCallback) {
        this.d.b(sizeReadyCallback);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void setRequest(Request request) {
        a(request);
    }

    public String toString() {
        return "Target for: " + this.f21072a;
    }
}
